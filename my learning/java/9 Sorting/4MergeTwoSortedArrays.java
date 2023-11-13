class MergeTwoSortedArrays {
  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public int[] merge(int[] arr1, int[] arr2, int n, int m) {
    int[] result = new int[n + m];

    int i = 0, j = 0, k = 0;

    while (i < n && j < m) { // ie if both arrays have elements in them then we compare their respective same
                             // place elements and place then in new array in ascending order
      if (arr1[i] < arr2[j]) {
        result[k] = arr1[i];
        i++;
      } else { // even if both values are same then then will come to this else block
        result[k] = arr2[j];
        j++;
      }
      k++;
    }

    // if array2 gets exhausted but array1 still has elements then place all elemets
    // of it in result array
    while (i < n) {
      result[k] = arr1[i];
      i++;
      k++;
    }

    // if array2 still has elements then place all elemets of it in result array
    while (j < n) {
      result[k] = arr1[j];
      j++;
      k++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] { 1, 4, 6, 8, 9 };
    int[] arr2 = new int[] { 0, 1, 4, 5, 6, 7 };

    MergeTwoSortedArrays bs = new MergeTwoSortedArrays();

    bs.printArray(arr1);
    bs.printArray(arr2);

    int[] mergedArray = bs.merge(arr1, arr2, 5, 6);
    System.out.println("After merge: ");
    bs.printArray(mergedArray);
  }
}
