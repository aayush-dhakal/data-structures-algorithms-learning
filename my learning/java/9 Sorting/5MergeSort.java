class MergeTwoSort {
  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // temp is used to store the result temporary
  void sort(int[] arr, int[] temp, int low, int high) {
    // when there is only one single element then low and high will be equal so this
    // will be our termination condition for recursion
    if (low < high) {
      int mid = low + (high - low) / 2; // you can also do low+high/2 if the sum of these intger values will
                                        // always be within the range of integer. We basically do
                                        // low + (high - low) / 2 to avoid the overflow

      sort(arr, temp, low, mid); // for these recursions low<high will act as a termination condition
      sort(arr, temp, mid + 1, high);
      merge(arr, temp, low, mid, high);
    }
  }

  public void merge(int[] arr, int[] temp, int low, int mid, int high) {
    // first we will simply just copy the two elements in temp array
    for (int i = low; i <= high; i++) {
      temp[i] = arr[i];
    }

    int i = low, j = mid + 1, k = low;

    while (i <= mid && j <= high) {
      if (temp[i] <= temp[j]) {
        arr[k] = temp[i];
        i++;
      } else {
        arr[k] = temp[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      arr[k] = temp[i];
      k++;
      i++;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 9, 5, 2, 4, 3 };

    MergeTwoSort ms = new MergeTwoSort();

    ms.printArray(arr);
    ms.sort(arr, new int[arr.length], 0, arr.length - 1);
    System.out.println("After sort: ");
    ms.printArray(arr);

  }
}
