class SelectionSort {
  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void sort(int[] arr) {
   int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int min = i;

      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }

      // swap the smallest number from unsorted right side to the sorted left side
      int temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 5, 1, 9, 2, 15, 89, 23, 10 };
    SelectionSort bs = new SelectionSort();
    bs.printArray(arr);
    System.out.println("After Sort: ");
    bs.sort(arr);
    bs.printArray(arr);
  }
}