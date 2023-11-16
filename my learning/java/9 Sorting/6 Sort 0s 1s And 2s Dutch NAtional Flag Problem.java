class Sort0s1sAnd2s {
  // i will traverse the array and when it enconters the 0 it will swap it to the
  // initial part of the array which is dentoed by j and after the swap the j's
  // and i's(we increase i coz if 0 is at first then it is sorted so we need to
  // move to next index) index is increased.
  // Similarly, when i enconters the 2 it will swap it to the
  // last part of the array which is dentoed by k and after the swap the k's
  // index(we donot increase i as the swapped element at first part of the array
  // may still be in incorrect palce like if we swap 1 and 2 then 1 being at first
  // place is still not sorted as there can also be 0 in next comming indexes)
  // is decreased. When i encounters the 1, it will do no swap and only increase
  // the i index(we increase the i's index as it can be swapped with 0 if we do
  // encounter 0 later so then the elements will be in sorted format).
  void threeNumberSort(int[] arr) {
    int i = 0, j = 0, k = arr.length - 1;

    while (i <= k) {
      if (arr[i] == 0) {
        swap(arr, i, j);
        i++;
        j++;
      } else if (arr[i] == 1) {
        i++;
      } else if (arr[i] == 2) {
        swap(arr, i, k);
        k--;
      }
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void printArray(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = { 2, 1, 1, 0, 1, 0, 1, 2, 0 };

    Sort0s1sAnd2s s = new Sort0s1sAnd2s();
    s.printArray(nums);

    s.threeNumberSort(nums);

    System.out.println("After sort:");
    s.printArray(nums);
  }
}