// Q. Given an Integer x. Return x with its digits reversed.

// Example 1
// Given an Integer - 1234.
// Output -- 4321

// Example 2
// Given an Integer - (-1234).
// Output -- (-4321)

// Example 3
// Given an Integer - (2147483647).
// Output -- (7463847412) // Note upon reversing the value may overflow the
// interger capacity so handle that case as well by either returning 0 or use
// long data type

class ReverseInteger {

  public static long reverse(int number) {
    boolean isNegative = number < 0;

    if (isNegative) {
      number = number * -1; // or take absolute as: number = Math.abs(number);
    }

    long reverse = 0;
    int lastDigit;

    while (number > 0) {
      lastDigit = number % 10;
      reverse = reverse * 10 + lastDigit;
      // if we don't multiply by 10 we will add the two numbers like 4+3=7 but by
      // multiplying with 10 we will add like 40 + 3 = 43 which is correct reverse
      number = number / 10;
    }

    return isNegative ? reverse * -1 : reverse;
  }

  // using int to check for overflow
  public static int reverse2(int x) {
    int result = 0;

    while (x != 0) {
      int digit = x % 10;
      int newResult = result * 10 + digit;

      // Check for overflow before updating the result
      if ((newResult - digit) / 10 != result) {
        return 0; // Overflow occurred
      }

      result = newResult;
      x /= 10;
    }

    return result;
  }

  public static void main(String[] args) {
    int num1 = 1234;
    int num2 = -1234;
    int num3 = 2147483647;

    System.out.println(reverse(num1)); // Output: 4321
    System.out.println(reverse(num2)); // Output: -4321
    System.out.println(reverse(num3)); // Output: 7463847412

    System.out.println(reverse2(num1)); // Output: 4321
    System.out.println(reverse2(num2)); // Output: -4321
    System.out.println(reverse2(num3)); // Output: 0 (Overflow check)
  }
}
