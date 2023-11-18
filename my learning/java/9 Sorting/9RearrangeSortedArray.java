// Given sorted array of integers, rearrange array in such a way that the first position will have the largest number, the second will have the smallest, the third will have the second-largest, and son on. Do this in the array itself so in O(1) space, don't use a second array.
class RearrangeSortedArray {
  // we first generate a number and with that number we can decode the max and min
  // numbers
  // largest elememts are at even index -> 0,2,4 -> maxIndex
  // smallest elememts are at odd index -> 1,3,5 -> minIndex
  // Formula:
  // Even index(largest) -> arr[i] = arr[i] + (arr[maxIdx] % max) * max
  // Odd index(smallest) -> arr[i] = arr[i] + (arr[minIdx] % max) * max
  // To calculate the sorted value: we just divide the numbers and take quotient
  // of it

  void arrangeMaxMin(int[] arr) {
    int maxIdx = arr.length - 1;
    int minIdx = 0;
    int max = arr[maxIdx] + 1;

    // putting new values in array
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0) {
        arr[i] = arr[i] + (arr[maxIdx] % max) * max;
        maxIdx--;
      } else {
        arr[i] = arr[i] + (arr[minIdx] % max) * max;
        minIdx++;
      }
    }

    // calculating the sorted values from the new values
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / max;
    }
  }

  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 5, 6, 8, 9 };
    RearrangeSortedArray rsa = new RearrangeSortedArray();

    rsa.printArray(arr);

    rsa.arrangeMaxMin(arr);

    System.out.println("After rearranging:");
    rsa.printArray(arr);
  }
}
