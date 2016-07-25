package leetcode;

public class Q98_ValidateBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static boolean isValidBST(TreeNode root, long l,long r){
		if (root == null) return true;
		return  (l < root.val) && (root.val < r) &&
				isValidBST(root.left,l,root.val) && 
				isValidBST(root.right,root.val,r);
	}
    public static boolean isValidBST(TreeNode root) {
    		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	public static void main(String[] args) {
		TreeNode ans = new TreeNode(2);
		ans.left = new TreeNode(1);
		ans.right = new TreeNode(3);
		System.out.println(isValidBST(ans));

	}

}
