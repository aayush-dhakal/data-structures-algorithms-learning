// Q. Given a string s, return the index of first non-repeating
// character in it. If it does not exist, return -1. The string will only
// contain lowercase letters.

// Example —
// Input: str = “codeforcode”
// Output: 4
// Explanation: The first non-repeating character is ‘f’ and is found at
// index 4

// Input: str = “aabb”
// Output: -1
// Explanation: It doesn’t have any non repeating character.

import java.util.HashMap;

class FirstNonRepeatingCharacter {

  public static int firstNonRepeatingCharIndex(String s) {
    HashMap<Character, Integer> charCount = new HashMap<>();

    // Count occurrences of each character
    for (char c : s.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);

      // charCount.getOrDefault(c, 0) attempts to get the current count for the
      // character c from the charCount HashMap. If the key c is present, it returns
      // the current count value; otherwise, it returns the default value 0. At first
      // there will be no character so it will return 0 and we will add it 1 to
      // signify that the character c has occured 1 time. If the same character comes
      // again then will get its value say 1 for second time then we will add 1 to it
      // signifying its occurence 2 times
    }

    // Find the first non-repeating character
    for (int i = 0; i < s.length(); i++) {
      if (charCount.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    // No non-repeating character found
    return -1;
  }

  public static int firstNonRepeatingCharIndex2(String s) {
    int[] charCount = new int[26]; // Assuming only lowercase letters, so using an array of size 26

    // Count occurrences of each character
    for (char c : s.toCharArray()) {
      charCount[c - 'a']++;
    }

    // Find the first non-repeating character
    for (int i = 0; i < s.length(); i++) {
      if (charCount[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    // No non-repeating character found
    return -1;
  }

  public static void main(String[] args) {
    String str1 = "codeforcode";
    String str2 = "aabb";

    System.out.println(firstNonRepeatingCharIndex(str1)); // Output: 4
    System.out.println(firstNonRepeatingCharIndex(str2)); // Output: -1

    System.out.println(firstNonRepeatingCharIndex2(str1)); // Output: 4
    System.out.println(firstNonRepeatingCharIndex2(str2)); // Output: -1
  }
}
