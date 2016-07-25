package leetcode;

public class Q110_BalancedBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static int height(TreeNode root){
		if (root==null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		if ((left>=0)&&(right>=0)&&(Math.abs(left - right) <=1))
			return Math.max(left, right) + 1; //注意：不要忘记+1，左右最深加上root
		else
			return -1; //非平衡
	}
    public static boolean isBalanced(TreeNode root) {
        return (height(root) >=0);
    }
	public static void main(String[] args) {

	}

}
