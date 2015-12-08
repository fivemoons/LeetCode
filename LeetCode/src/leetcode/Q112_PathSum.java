package leetcode;

public class Q112_PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static boolean hasPathSum(TreeNode root, int sum) {
    		if (root == null) //根是空节点返回0
    			return false;
    		else if ((root.val == sum)&&(root.left == null)&&(root.right == null)) //叶节点
    			return true;
    		else if ((root.left != null)&&(hasPathSum(root.left, sum - root.val))) //递归左儿子
    			return true;
    		else if ((root.right != null)&&(hasPathSum(root.right, sum - root.val))) //递归右儿子
    			return true;
    		return false; //不满足
    }
	public static void main(String[] args) {
	}

}
