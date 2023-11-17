class QuickSort {
  // objective of partitional is to partition the array in such a way that the
  // elements at left side of pivot are lesser or equal to pivot and right side
  // are greater than pivot.
  // Note: we just partitional the array and not sort them. Sorting is done in
  // another method
  int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // we can choose any pivot element, here we are taking last element as pivot
    int i = low, j = low;

    // low to j-1 will have elements smaller or equal to pivot(remember not
    // necessarily sorted)
    // j to i-1 will have elements greater than pivot
    // i to high are the elements yet to be traversed

    while (i <= high) {
      if (arr[i] <= pivot) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++; // we are increasing the both j and i coz we are not sorting the partitioned
             // elements itself. We are just partitioning for pivot
      }
      i++;
    }
    return j - 1; // this returns the pivot element index
  }

  void sort(int[] arr, int low, int high) {
    if (low < high) {
      int p = partition(arr, low, high); // this pivot will be in sorted place
      sort(arr, low, p - 1); // now we call the partion recursively and sort all the left side
      sort(arr, p + 1, high); // sorting the right side of the pivot
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
    int[] arr = new int[] { 8, -3, 5, 2, 6, 9, -6, 1, 3 };

    QuickSort qs = new QuickSort();

    qs.printArray(arr);

    qs.sort(arr, 0, arr.length - 1);

    System.out.println("After sort:");
    qs.printArray(arr);
  }
}
