// Q. Given an array of integers arr, there is a sliding window of size k which
// is moving from the very left of the array to the very right. You can only see
// the k numbers in the window. Each time the sliding window moves right by one
// position. Return the max sliding window.
// Example -
// Input: arr = {44, 77, 33, 44, 88, 11}, k = 3
// Output: arr = [77, 77, 88, 88]

// Window position -> Max
// [44 77 33] 44 88 11 -> 77
// 44 [77 33 44] 88 11 -> 77
// 44 77 [33 44 88] 11 -> 88
// 44 77 33 [44 88 11] -> 88

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class MaxSlidingWindow {

  public static List<Integer> maxSlidingWindow(int[] arr, int k) {
    int[] nextGreaterIndexes = nextGreaterElement(arr);
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i <= arr.length - k; i++) { // arr.length - k will allow to take only k elements into consideration
      int j = i;
      while (nextGreaterIndexes[j] < i + k) {
        j = nextGreaterIndexes[j];
        result.add(arr[j]);
      }
    }
    return result;
  }

  public static int[] nextGreaterElement(int[] arr) {
    int[] result = new int[arr.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
          stack.pop(); // get the maximum
        }
      }

      if (stack.isEmpty()) {
        result[i] = arr.length;
      } else {
        // get the current array value if it is maximum and its index is out of window
        // bound
        result[i] = stack.peek();
      }
      stack.push(i); // next max
    }
    return result;
  }

  // using queue
  public static int[] maxSlidingWindow2(int[] arr, int k) {
    int n = arr.length;
    if (n == 0) {
      return new int[0];
    }

    int[] result = new int[n - k + 1];
    int resultIndex = 0;

    Deque<Integer> deque = new ArrayDeque<>();

    // Process the first k elements separately to initialize the deque
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }

    // Process the rest of the elements
    for (int i = k; i < n; i++) {
      result[resultIndex++] = arr[deque.peekFirst()];

      // Remove elements that are outside the current window
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }

      // Remove smaller elements from the back of the deque
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.pollLast();
      }

      // Add the current element to the deque
      deque.offerLast(i);
    }

    // Add the maximum element from the last window to the result
    result[resultIndex] = arr[deque.peekFirst()];

    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 44, 77, 33, 44, 88, 11 };
    int k = 3;

    List<Integer> result = maxSlidingWindow(arr, k);
    System.out.println("Output: " + result);

    int[] result2 = maxSlidingWindow2(arr, k);
    System.out.println("Output 2: " + Arrays.toString(result2));
  }
}
