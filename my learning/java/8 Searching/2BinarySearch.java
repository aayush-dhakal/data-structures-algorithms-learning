class BinarySearch {
  public int search(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;

    while (low < high) {
      int mid = high + low / 2;
      if (arr[mid] == key)
        return mid;

      if (key < arr[mid])
        high = mid - 1; // we subtract one coz key is not at mid postion as we already check for that
                        // condition above
      else
        low = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 5, 7, 8, 10, 56, 78 }; // the array must be in a sorted format for binary search to work
    BinarySearch ls = new BinarySearch();

    int item = 10;
    System.out.println(item + " is at index " + ls.search(arr, item));
  }
}