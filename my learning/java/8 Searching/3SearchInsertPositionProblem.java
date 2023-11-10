/*
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index if the target is found. If not, return the index where it would be if it were inserted in order. The algorithm should run in O(logn) time.
 */

class SearchInsertPositionProblem {
  public int search(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = high + low / 2;
      if (arr[mid] == key)
        return mid;

      if (key < arr[mid])
        high = mid - 1; // we subtract one coz key is not at mid postion as we already check for that
                        // condition above
      else
        low = mid + 1;
    }
    return low;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 5, 7, 8, 10, 56, 78 }; // the array must be in a sorted format for binary search to work
    SearchInsertPositionProblem ls = new SearchInsertPositionProblem();

    int item = 90;
    int item2 = 1;
    int item3 = 4;
    int item4 = 6;
    System.out.println(item + " is at index " + ls.search(arr, item));
    System.out.println(item2 + " is at index " + ls.search(arr, item2));
    System.out.println(item3 + " is at index " + ls.search(arr, item3));
    System.out.println(item4 + " is at index " + ls.search(arr, item4));
  }
}