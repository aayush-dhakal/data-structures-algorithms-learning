// Implementaion with Top Down dynamic programming approach:
// It is also called as Memoization.
// We break the large problem into multiple sub-problems. Each of the sub-problems are solved and solutions are remembered.
// If the sub-problem is solved already, reuse the answer. Else solve the sub-problem and store the result.
class FibonacciSeriesTopDownDPApproach {
  public int fibonacciDP(int[] memo, int n) {
    // memo will be n+1 temporary array to hold the previous calculated results
    if (memo[n] == 0) {
      if (n < 2) {
        memo[n] = n;
      } else {
        int previous = fibonacciDP(memo, n - 1);
        int previousPrevious = fibonacciDP(memo, n - 2);
        memo[n] = previous + previousPrevious;
      }
    }
    return memo[n];
  }

  public static void main(String args[]) {
    FibonacciSeriesTopDownDPApproach fibNum = new FibonacciSeriesTopDownDPApproach();

    int num = 6;
    System.out.print("The " + num + "th Fibonacci number is " + fibNum.fibonacciDP(new int[num + 1], num));
  }
}