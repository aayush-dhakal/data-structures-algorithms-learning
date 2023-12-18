class KadaneAlgorithmForMaximumSumSubarray {
  public static int maxSubArraySum(int[] arr) {
    int currentMax = arr[0];
    int maxSoFar = arr[0];

    int start = 0; // Start index of the current subarray
    int end = 0; // End index of the current subarray
    int tempStart = 0; // Temporary start index to update when currentMax becomes arr[i]

    for (int i = 1; i < arr.length; i++) {
      currentMax = currentMax + arr[i]; // adding element to current sub array

      if (currentMax < arr[i]) {
        currentMax = arr[i]; // element decides to start its own subarray
        tempStart = i;
      }
      if (maxSoFar < currentMax) {
        maxSoFar = currentMax; // new maximum for new sub array
        start = tempStart;
        end = i;
      }
    }

    System.out.print("The max subarray is: ");
    for (int i = start; i <= end; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println(); // Print a new line for better formatting

    return maxSoFar;
  }

  public static void main(String[] args) {
    int[] arr = { 4, 3, -2, 6, -12, 7, -1, 6 };

    System.out.println("The max sum is: " + maxSubArraySum(arr));
    // System.out.println("The max subarray is: ");

  }
}
