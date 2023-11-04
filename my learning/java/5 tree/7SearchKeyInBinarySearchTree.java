
class SearchKeyInBinarySearchTree {

  private TreeNode root;

  private class TreeNode {
    private int data; // Generic type
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public void insert(int value) {
    root = insert(root, value);
  }

  public TreeNode insert(TreeNode root, int value) {
    if (root == null) {
      root = new TreeNode(value);
      return root;
    }

    if (value < root.data) {
      root.left = insert(root.left, value);
    } else {
      root.right = insert(root.right, value);
    }
    return root;
  }

  public void inOrder() {
    inOrder(root);
  }

  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public TreeNode search(int key) {
    return search(root, key);
  }

  public TreeNode search(TreeNode root, int key) {
    // base case
    if (root == null || root.data == key) {
      // if key is found in root data it will return that root else if the search
      // exhausts the entire tree then the root will point to null and we will return
      // that null root signifying that the key is not present in the tree
      return root;
    }

    if (key < root.data) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public static void main(String[] args) {
    SearchKeyInBinarySearchTree bst = new SearchKeyInBinarySearchTree();
    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(1);
    bst.insert(5);

    bst.inOrder(); // output will be in ascending sorted order: 1 3 5 5 7
    System.out.println();

    int key1 = 3;
    int key2 = 10;

    if (null != bst.search(key1)) {
      System.out.println("key " + key1 + " is in the tree.");
    } else {
      System.out.println("key " + key1 + " is not in the tree.");
    }

    if (null != bst.search(key2)) {
      System.out.println("key " + key2 + " is in the tree.");
    } else {
      System.out.println("key " + key2 + " is not in the tree.");
    }
  }
}
