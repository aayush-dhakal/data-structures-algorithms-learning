// Q. Given a string, remove the vowels from the string and
// return the string without vowels. The string will contains
// lowercase letters.

// Example —
// Input: str = “what is your name ?”
// Output: “wht s yr nm ?”

// Explanation: After removing vowels i.e. {‘a’, ‘e’, ‘i’, ‘o’, ‘u’}, the string
// becomes “wht s yr nm ?”

import java.util.Set;

class RemoveVowels {

  public static String removeVowels(String str) {
    // creates an immutable set of characters representing the vowels 'a', 'e', 'i',
    // 'o', and 'u'.
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    // this stores the vowels in form of an array. System.out.println(vowels):
    // [u, a, i, o, e]
    // this output of vowels represents the result of calling toString() on the Set
    // created with Set.of('a', 'e', 'i', 'o', 'u'). The order of elements in the
    // output might not be the same as the order in which they were specified when
    // creating the set.

    // If you need to maintain the order of elements, you might consider using a
    // List instead. For example:
    // List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    // This will create an immutable list where the order of elements is maintained.
    // Keep in mind that lists allow duplicate elements, so if uniqueness is
    // crucial, you might need additional logic.

    StringBuilder sb = new StringBuilder();

    char[] charArray = str.toCharArray();

    for (Character ch : charArray) {
      if (!vowels.contains(ch)) {
        sb.append(ch);
      }
    }

    return sb.toString();
  }

  public static String removeVowels2(String str) {

    StringBuilder result = new StringBuilder();

    for (char c : str.toCharArray()) {
      if (!isVowel(c)) {
        result.append(c);
      }
    }

    return result.toString();
  }

  private static boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }

  public static String removeVowels3(String str) {
    // Use regular expression to remove vowels (case-insensitive)
    return str.replaceAll("[aeiouAEIOU]", "");
  }

  public static void main(String[] args) {
    String inputString = "what is your name ?";
    String result = removeVowels(inputString);
    String result2 = removeVowels2(inputString);
    String result3 = removeVowels2(inputString);

    System.out.println("Input: " + inputString);
    System.out.println("Output: " + result);
    System.out.println("Output2: " + result2);
    System.out.println("Output3: " + result3);
  }
}