class Check {

  public static boolean checkPalindrome(String word) {
    char[] charArray = word.toCharArray();
    int start = 0;
    // int end = word.length() - 1;
    int end = charArray.length - 1;

    while (start < end) {
      if (charArray[start] != charArray[end]) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static void main(String a[]) {
    String s1 = "okthis";
    String s2 = "madam";
    String s3 = "caac";
    String s4 = "caacs";

    System.out.println(checkPalindrome(s1));
    System.out.println(checkPalindrome(s2));
    System.out.println(checkPalindrome(s3));
    System.out.println(checkPalindrome(s4));

  }
}