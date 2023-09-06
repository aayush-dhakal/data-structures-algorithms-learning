import java.util.LinkedList;
import java.util.Queue;

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

  public int findMax() {
    return findMax(root); // this method will take an argument so its method overloading
  }

  public int findMax(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE; // retuns the minimum possible for Integer data type
    }

    int result = root.data;
    int left = findMax(root.left);
    int right = findMax(root.right);

    if (left > result) {
      result = left;
    }
    if (right > result) {
      result = right;
    }

    return result;
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();

    System.out.println("Maximum value in Tree is: " + bt.findMax());
  }
}