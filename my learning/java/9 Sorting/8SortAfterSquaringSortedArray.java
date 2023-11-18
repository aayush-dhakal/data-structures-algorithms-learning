// Given an integer array sorted in ascending order, return an array of the squares of each number sorted in ascending order
class SortAfterSquaringSortedArray {
  public int[] sortedSqauredArray(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];

    int i = 0, j = n - 1; // i will hold the left side values and j will hold the right side values

    // k will help to place the largest element at the last index of the array
    for (int k = n - 1; k >= 0; k--) {
      // we basically take the positive number from both extreme ends and compare
      // there squares and put the largest element in the last place. And only
      // increasing the index of the element that was placed at last index.
      if (Math.abs(arr[i]) > Math.abs(arr[j])) { // Math.abs returns an absolute value ie a positive value
        result[k] = arr[i] * arr[i];
        i++;
      } else {
        result[k] = arr[j] * arr[j];
        j--;
      }
    }

    return result;
  }

  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = new int[] { -4, -2, -1, 0, 3, 4, 10 };
    SortAfterSquaringSortedArray sas = new SortAfterSquaringSortedArray();

    sas.printArray(arr);

    int[] result = sas.sortedSqauredArray(arr);

    System.out.println("After sorting");
    sas.printArray(result);
  }
}
