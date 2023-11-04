class CheckValidityOfBinarySearchTree {

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

  public boolean isValid(TreeNode root, long min, long max) {
    // base case
    if (root == null) {
      return true;
    }

    if (root.data <= min || root.data >= max) {
      return false;
    }

    boolean left = isValid(root.left, min, root.data);

    if (left) {
      boolean right = isValid(root.right, root.data, max);
      return right;
    }

    return false;
  }

  public static void main(String[] args) {
    CheckValidityOfBinarySearchTree bst = new CheckValidityOfBinarySearchTree();
    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(1);
    // bst.insert(5);
    bst.insert(10);

    bst.inOrder(); // output will be in ascending sorted order: 1 3 5 5 7
    System.out.println();

    // isValid(root,Long.MIN_VALUE,LONG.MAX_VALUE)
    boolean isBinarySearchTree = bst.isValid(bst.root, Long.MIN_VALUE, Long.MAX_VALUE);
    System.out.println("Is the tree a binary search tree: ");
    System.out.println(isBinarySearchTree);
  }
}
