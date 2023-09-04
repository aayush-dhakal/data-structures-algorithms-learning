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
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);
    TreeNode sixth = new TreeNode(6);
    TreeNode seventh = new TreeNode(7);

    // TreeNode first = new TreeNode(9);
    // TreeNode second = new TreeNode(2);
    // TreeNode third = new TreeNode(3);
    // TreeNode fourth = new TreeNode(4);

    root = first;
    first.left = second;
    first.right = third;
    second.left = fourth;
    second.right = fifth;
    third.left = sixth;
    third.right = seventh;
  }

  public void postOrderTraversalRecursive(TreeNode root) {
    if (root == null) {
      return;
    }

    postOrderTraversalRecursive(root.left);
    postOrderTraversalRecursive(root.right);
    System.out.println(root.data + " ");
  }

  public void postOrderTraversalIterative(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode current = root;
    Stack<TreeNode> stack = new Stack<>();

    while (current != null || !stack.isEmpty()) {

      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        TreeNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.pop();
          System.out.println(temp.data + " ");

          // this is to check if the node is in right side or left. if right side then we
          // can visit its parent node as both left and right child will be visited
          while (!stack.isEmpty() && temp == stack.peek().right) {
            temp = stack.pop();
            System.out.println(temp.data + " ");
          }
        } else {
          current = temp;
        }
      }

    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();

    System.out.println("Recursive traversal");
    bt.postOrderTraversalRecursive(bt.root);

    System.out.println("Iterative traversal");
    bt.postOrderTraversalIterative(bt.root);
  }
}