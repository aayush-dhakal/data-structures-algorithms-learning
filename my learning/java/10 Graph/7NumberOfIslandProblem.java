class NumberOfIslandProblem {

  public int numlslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int numOfIslands = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          dfs(grid, i, j, visited);
          numOfIslands++;
        }
      }
    }
    return numOfIslands;
  }

  void dfs(char[][] grid, int row, int col, boolean[][] visited) {
    if (row < 0 || col < 0 ||
        row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') {
      return;
    }
    visited[row][col] = true;
    dfs(grid, row, col - 1, visited); // go left
    dfs(grid, row - 1, col, visited); // go up
    dfs(grid, row, col + 1, visited); // go right
    dfs(grid, row + 1, col, visited); // go down
  }

  public static void main(String[] args) {

    NumberOfIslandProblem g = new NumberOfIslandProblem();

    char[][] grid1 = {
        { '0', '1', '1', '1', '0', '0', '0' },
        { '0', '0', '1', '1', '0', '1', '0' }
    };
    char[][] grid2 = {
        { '1', '1', '0', '0' },
        { '1', '0', '0', '0' },
        { '0', '0', '1', '0' },
        { '0', '0', '0', '1' },
    };

    int result = g.numlslands(grid1);
    int result2 = g.numlslands(grid2);

    System.out.println("the total number of islands are: " + result);
    System.out.println("the total number of islands are: " + result2);
  }
}
