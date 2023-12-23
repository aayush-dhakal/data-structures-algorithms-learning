class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode(); // root is empty 
  }

  private class TrieNode {
    private TrieNode[] children; // An array of TrieNode references representing the children of the current
                                 // node. In this case, it's an array of size 26, assuming English words and
                                 // using lowercase letters 'a' through 'z'.
    private boolean isWord; // A boolean flag indicating whether the node represents the end of a complete
                            // word.

    public TrieNode() {
      this.children = new TrieNode[26]; // storing english words - a -> z this.isWord = false;
    }
  }

  public void insert(String word) {
    if (word == null || word.isEmpty()) {
      throw new IllegalArgumentException("Invalid input");
    }

    word = word.toLowerCase();

    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a'; // The expression c - 'a' is used to map the character c to an index in the
                           // range [0, 25], assuming the lowercase English alphabet. This is done to index
                           // into the array of children.
      // The expression c - 'a' is a common technique in Trie implementations. It
      // takes advantage of the fact that characters in Java are represented as
      // Unicode values, and lowercase English letters are contiguous in the Unicode
      // table. By subtracting the Unicode value of 'a', you get an index
      // corresponding to the letter's position in the alphabet. This helps map
      // characters to indices in an array, making it an efficient way to store and
      // retrieve information in the Trie.
      // example:
      // System.out.println((int) 'a'); // prints 97(Unicode of a)
      // System.out.println('a' - 'a'); // prints 0
      // System.out.println('b' - 'a'); // prints 1 (Unicode of b is 98 ie Unicode of
      // a + 1)

      if (current.children[index] == null) {
        TrieNode node = new TrieNode();
        current.children[index] = node;
        current = node;
      } else {
        current = current.children[index];
      }
    }
    current.isWord = true; // when all the characters of the word are inserted we mark the referebce as
                           // true indiciating that it is a complete word
  }

  public boolean search(String word) {
    if (word == null || word.isEmpty()) {
      throw new IllegalArgumentException("Invalid input");
    }

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';

      if (current.children[index] == null) {
        // If at any point the character is not found, the word is not in the Trie.
        return false;
      }

      current = current.children[index];
    }

    // Check if the last node represents the end of a complete word.
    return current.isWord;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("cat");
    trie.insert("cab");
    trie.insert("son");
    trie.insert("so");

    System.out.println("Values inserted successfully !!!");

    System.out.println("Is son in the trie? " + trie.search("son"));
    System.out.println("Is so in the trie? " + trie.search("cat"));
    System.out.println("Is az in the trie? " + trie.search("az"));
  }
}