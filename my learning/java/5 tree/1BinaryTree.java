import java.util.Stack;

class BinaryTree {

  private TreeNode root;

  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data; // can be of Generic(any) type. here we are using integer type to store as data

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public void createBinaryTree() {
    // TreeNode first = new TreeNode(1);
    // TreeNode second = new TreeNode(2);
    // TreeNode third = new TreeNode(3);
    // TreeNode fourth = new TreeNode(4);
    // TreeNode fifth = new TreeNode(5);

    TreeNode first = new TreeNode(9);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);

    root = first;
    first.left = second;
    first.right = third;

    second.left = fourth;
  }

  public void preOrderTraversalRecursive(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.println(root.data + " ");
    preOrderTraversalRecursive(root.left);
    preOrderTraversalRecursive(root.right);
  }

  public void preOrderTraversalIterative(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      System.out.println(temp.data);

      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();

    System.out.println("Recursive traversal");
    bt.preOrderTraversalRecursive(bt.root);

    System.out.println("Iterative traversal");
    bt.preOrderTraversalIterative(bt.root);
  }
}