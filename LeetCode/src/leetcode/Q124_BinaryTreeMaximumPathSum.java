package leetcode;

public class Q124_BinaryTreeMaximumPathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static int ans = Integer.MIN_VALUE; //注意：初始点为-无穷
	private static int dfs(TreeNode root){
		if (root == null) return 0;
		int l = dfs(root.left); //左根最大值
		int r = dfs(root.right); //右根最大值
		int now = root.val; //以下代码选择这个点中转
		if (l>0) now+=l;
		if (r>0) now+=r;
		if (ans<now) ans = now;
		return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val; //返回一根的最大值和当前节点
	}
	public static int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
	public static void main(String[] args) {
	
	}

}
