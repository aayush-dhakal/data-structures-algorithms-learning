// A subsequence of a string is a new string formed from the
// original string by deleting some or no characters without
// changing the order of remaining characters.
// Example —
// “ace” is a subsequence of “abcde”
// “abcde” is a subsequence of “abcde”
// “aec” is not a subsequence of “abcde”

class ValidSubsequence {

  public static boolean isSubsequence(String sub, String str) {
    int subIndex = 0; // Index for the subsequence
    int strIndex = 0; // Index for the original string

    // checking if the indexes are more than or equal to the length of strings to
    // traverse through the entire string
    while (subIndex < sub.length() && strIndex < str.length()) {
      if (sub.charAt(subIndex) == str.charAt(strIndex)) {
        // If characters match, move to the next character in the subsequence
        subIndex++;
      }
      // Move to the next character in the original string
      strIndex++;
    }

    // If subIndex reaches the length of sub, all characters of sub have been found
    return subIndex == sub.length();
  }

  public static void main(String[] args) {
    String str1 = "abcde";
    String sub1 = "ace";

    String str2 = "abcde";
    String sub2 = "aec";

    String str3 = "abcde";
    String sub3 = "abcde";

    System.out.println(isSubsequence(sub1, str1)); // true
    System.out.println(isSubsequence(sub2, str2)); // false
    System.out.println(isSubsequence(sub3, str3)); // true
  }
}
