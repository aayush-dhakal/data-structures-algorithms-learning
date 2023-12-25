/*
Q. Given the root of a binary tree, check whether it is a mirror of itself(ie symmetric around its center)
 */

/* Symmetric example:
       1
      / \
     2   2
    / \ / \
   3  4 4  3
*/

/* Non-Symmetric example:(here both right child are same but we need one left and other right child to be similar)
       1
      / \
     2   2
      \   \
       3   3
*/

import java.util.Stack;

class SymmetricTreeExample {

  static class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }

  static class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {

      if (root == null)
        return true;

      Stack<TreeNode> stack = new Stack<>();

      stack.push(root.left);
      stack.push(root.right);

      while (!stack.isEmpty()) {
        TreeNode n1 = stack.pop();
        TreeNode n2 = stack.pop();

        // check if there are not element in left and right child of node
        if (n1 == null && n2 == null) {
          return true;
        }

        // if any of child is null then the children will not match, since we have
        // already filtered both child null condition above so this condition will be
        // true when the children won't match
        if (n1 == null || n2 == null || n1.val != n2.val) {
          return false;
        }

        stack.push(n1.left);
        stack.push(n2.right);
        stack.push(n1.right);
        stack.push(n2.left);
      }

      return true;
    }

    public static boolean isSymmetric2(TreeNode root) {
      if (root == null) {
        return true; // An empty tree is symmetric
      }

      return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true; // Both subtrees are empty, they are symmetric
      }

      if (left == null || right == null) {
        return false; // One subtree is empty, the other is not, they are not symmetric
      }

      // Check if the values of the current nodes are equal
      // and the left subtree of the left node is a mirror of the right subtree of the
      // right node
      // and the right subtree of the left node is a mirror of the left subtree of the
      // right node
      return (left.val == right.val)
          && isMirror(left.left, right.right)
          && isMirror(left.right, right.left);
    }
  }

  public static void main(String[] args) {
    // Example symmetric tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    // Check if the tree is symmetric
    System.out.println("output: " + SymmetricTree.isSymmetric(root)); // Output: true
    System.out.println("output 2: " + SymmetricTree.isSymmetric2(root)); // Output: true

    // Example non-symmetric tree
    TreeNode nonSymmetricRoot = new TreeNode(1);
    nonSymmetricRoot.left = new TreeNode(2);
    nonSymmetricRoot.right = new TreeNode(2);
    nonSymmetricRoot.left.right = new TreeNode(3);
    nonSymmetricRoot.right.right = new TreeNode(3);

    // Check if the tree is symmetric
    System.out.println("output: " + SymmetricTree.isSymmetric(nonSymmetricRoot)); // Output: false
    System.out.println("output 2: " + SymmetricTree.isSymmetric2(nonSymmetricRoot)); // Output: false
  }
}
