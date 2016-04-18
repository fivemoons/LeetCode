package leetcode;

public class Q124_BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private int ans = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(0,dfs(root.left));
        int r = Math.max(0,dfs(root.right));
        ans = Math.max(ans, l + r + root.val);
        return Math.max(l,r) + root.val;
    }
	public int maxPathSum(TreeNode root) {
	    dfs(root);
	    return ans;
    }
	public static void main(String[] args) {
	
	}

}
