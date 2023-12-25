// Q. Given a string str, find the length of longest substring without repeating
// characters.
// Example -
// Input: str = "abcabcbb"
// Output: 3  // abc is longest non repeting characters

// Input: str = "bbbb"
// Output: 1   // b is longest non repeting characters

// Input: str = "pwwkew"
// Output: 3   // kew is longest non repeting characters

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class LongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    int start = 0;

    for (int end = 0; end < s.length(); end++) {
      char rightChar = s.charAt(end);

      if (map.containsKey(rightChar)) {
        start = Math.max(start, map.get(rightChar) + 1); // to take the latest non repeting character we use max
      }
      map.put(rightChar, end);
      maxLength = Math.max(maxLength, end - start - 1);
    }

    return maxLength;
  }

  public static int lengthOfLongestSubstring2(String str) {
    int n = str.length();
    int maxLength = 0;
    int left = 0;
    int right = 0;

    HashSet<Character> set = new HashSet<>();

    while (right < n) {
      if (!set.contains(str.charAt(right))) {
        set.add(str.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
        right++;
      } else {
        set.remove(str.charAt(left));
        left++;
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    String str1 = "abcabcbb";
    System.out.println("Output: " + lengthOfLongestSubstring2(str1));

    String str2 = "bbbb";
    System.out.println("Output: " + lengthOfLongestSubstring2(str2));

    String str3 = "pwwkew";
    System.out.println("Output: " + lengthOfLongestSubstring2(str3));

    String str4 = "abcabcbb";
    System.out.println("Output 2: " + lengthOfLongestSubstring2(str4));

    String str5 = "bbbb";
    System.out.println("Output 2: " + lengthOfLongestSubstring2(str5));

    String str6 = "pwwkew";
    System.out.println("Output 2: " + lengthOfLongestSubstring2(str6));
  }
}
