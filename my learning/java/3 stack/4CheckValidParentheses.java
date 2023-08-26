import java.util.Stack;

class CheckValidParentheses {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        // add to stack if it is opening bracket
        stack.push(c);
      } else {
        // when the first charcter is closing bracket then this block will execute and
        // return false
        if (stack.isEmpty()) {
          return false;
        } else {
          char top = stack.peek();

          // if the current character is closing bracket then compare it to the top most
          // bracket to make sure it is the correct closing bracket
          if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }

    // after iterating
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String str = "{([()])}";
    String str2 = ")}";
    String str3 = "({)";

    System.out.println(str + " is valid: " + isValid(str));
    System.out.println(str2 + " is valid: " + isValid(str2));
    System.out.println(str3 + " is valid: " + isValid(str3));
  }
}
