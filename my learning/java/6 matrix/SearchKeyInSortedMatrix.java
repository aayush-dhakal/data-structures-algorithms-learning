public class SearchKeyInSortedMatrix {

  public void search(int[][] matrix, int n, int x) {
    int i = 0;
    int j = n - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == x) {
        System.out.println(x + " found at - " + i + "," + j);
        return;
      }
      if (matrix[i][j] > x) { // if the given key is less than the traversed element of matrix then start the
                              // lookup from left side as in the matrix the left of the element will contain
                              // small element matrix(as we are assigning j to the last index so we move left)
        j--;
      } else { // if the given key is greater than the traversed element of matrix then start
               // the
               // lookup from bottom part of the matrix as the bottom of the element will
               // contain
               // greater element matrix(as we are assigning i to the first index so we move
               // bottom as the first element denoted by the index i will be the smallest)
        i++;
      }
    }
    System.out.println("Value " + x + " not found");
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 51 },
    };

    SearchKeyInSortedMatrix sm = new SearchKeyInSortedMatrix();
    sm.search(matrix, matrix.length, 32);
    sm.search(matrix, matrix.length, 320);
  }
}