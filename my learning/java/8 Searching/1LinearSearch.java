class LinearSearch {
  public int search(int[] arr, int n, int x) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 1, 9, 2, 10, 15, 20 };
    LinearSearch ls = new LinearSearch();

    int item = 10;
    System.out.println(item + " is at index " + ls.search(arr, arr.length, item));
  }
}