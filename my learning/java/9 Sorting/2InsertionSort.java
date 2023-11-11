class InsertionSort {
  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void sort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int temp = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 5, 1, 9, 2, 15, 89, 10 };
    InsertionSort bs = new InsertionSort();
    bs.printArray(arr);
    System.out.println("After Sort: ");
    bs.sort(arr);
    bs.printArray(arr);
  }
}