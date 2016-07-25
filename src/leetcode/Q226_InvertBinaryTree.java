package leetcode;

public class Q226_InvertBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode l = invertTree(root.right);
        TreeNode r = invertTree(root.left);
        root.left = l;
        root.right = r;
        return root;
    }
	public static void main(String[] args) {
	}

}
