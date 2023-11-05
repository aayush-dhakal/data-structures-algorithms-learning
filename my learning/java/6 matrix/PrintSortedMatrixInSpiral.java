public class PrintSortedMatrixInSpiral {

  public void spiralPrint(int[][] matrix, int r, int c) { // r and c denote row and column pointer
    int i, k = 0, l = 0; // k will help in printing row and l will help in printing column

    while (k < r && l < c) {
      // for printing first row
      for (i = l; i < c; i++) {
        System.out.println(matrix[k][i] + " ");
      }
      // for printing right column
      k++;
      for (i = k; i < r; i++) {
        System.out.println(matrix[i][c - 1] + " ");
      }
      // for printing bottom row
      c--;
      if (k < r) {
        for (i = c - 1; i >= l; i--) {
          System.out.println(matrix[r - 1][i] + " ");
        }
        r--;
      }
      // for printing inner elements
      if (l < c) {
        for (i = r - 1; i >= k; i--) {
          System.out.println(matrix[i][l] + " ");
        }
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 51 },
    };

    PrintSortedMatrixInSpiral sm = new PrintSortedMatrixInSpiral();

    sm.spiralPrint(matrix, 4, 4); // there are 4 columns and 4 rows
  }
}