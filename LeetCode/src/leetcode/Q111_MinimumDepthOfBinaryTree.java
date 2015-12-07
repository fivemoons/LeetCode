package leetcode;

public class Q111_MinimumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static int minDepth(TreeNode root) {
        if (root == null) return 0; //递归不会出现这种情况
        if ((root.left == null) && (root.right == null)) return 1; //这才是根结点
        if (root.left == null) return minDepth(root.right) + 1; //右子树
        if (root.right == null) return minDepth(root.left) + 1; //左子树
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1; //左右最小值
    }
	public static void main(String[] args) {
	}

}
