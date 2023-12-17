// Dynamic Programming is mainly an optimization over recursion.
// Dynamic Programming = Recursion + Memorization

// Implementaion with Bottom Up dynamic programming approach:
// We try to solve smaller sub-problems first, use their solution to
// build on and arrive at solutions to bigger sub-problems.
// It is also called as Tabulation method.
// The solution is build in a tabular form by using solutions of smaller
// sub-problems iteratively and generating solutions to bigger sub-
// problems.
class FibonacciSeriesWithoutBottomUpDPApproach {
  public int fibonacciDP(int n) {
    int[] table = new int[n + 1]; // we will store the previous calcaulation for a particular number in the array

    table[0] = 0;
    table[1] = 1;

    for (int i = 2; i <= n; i++) {
      table[i] = table[i - 1] + table[i - 2];
    }

    return table[n];
  }

  public static void main(String args[]) {
    FibonacciSeriesWithoutBottomUpDPApproach fibNum = new FibonacciSeriesWithoutBottomUpDPApproach();

    int num = 6;
    System.out.print("The " + num + "th Fibonacci number is " + fibNum.fibonacciDP(num));

  }
}