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

  public void inOrderTraversalRecursive(TreeNode root) {
    if (root == null) {
      return;
    }

    inOrderTraversalRecursive(root.left);
    System.out.println(root.data + " ");
    inOrderTraversalRecursive(root.right);
  }

  public void inOrderTraversalIterative(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode temp = root;

    while (!stack.isEmpty() || temp != null) {

      if (temp != null) {
        stack.push(temp);
        temp = temp.left;
      } else {
        temp = stack.pop();
        System.out.println(temp.data);
        temp = temp.right;
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();

    System.out.println("Recursive traversal");
    bt.inOrderTraversalRecursive(bt.root);

    System.out.println("Iterative traversal");
    bt.inOrderTraversalIterative(bt.root);
  }
}