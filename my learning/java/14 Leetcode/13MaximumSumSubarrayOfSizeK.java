// Q. Given an array of integers arr, there is a sliding window of size k which
// is moving from the very left of the array to the very right. Find the maximum
// sum of any contiguous subarray of size k.
// Example -
// Input: arr = {2, 7, 3, 5, 8, 1}, k = 3
// Output: arr = = 16
// Window position Sum
// [2 7 3] 5 8 1 -> 12
// 2 [7 3 5] 8 1 -> 15
// 2 7 [3 5 8] 1 -> 16
// 2 7 3 [5 8 1] -> 14

class MaxSumSubarray {

  public static int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0;
    int windowSum = 0;
    int start = 0;

    for (int end = 0; end < arr.length; end++) {
      windowSum = windowSum + arr[end];

      if (end >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum = windowSum - arr[start];
        start++;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 7, 3, 5, 8, 1 };
    int k = 3;

    int result = maxSumSubarray(arr, k);
    System.out.println("Output: " + result);
  }
}
