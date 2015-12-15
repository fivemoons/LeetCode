package leetcode;

public class Q129_SumRootToLeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static int ANS = 0;
	private static void dfs(TreeNode root){
		if(root==null) return; //空节点
		if(root.left!=null){ //有左儿子
			root.left.val += root.val*10;
			dfs(root.left);
		}
		if(root.right!=null){ //有右儿子
			root.right.val += root.val*10;
			dfs(root.right);
		}
		if((root.left==null)&&(root.right==null)){ //叶子节点
			ANS+=root.val;
		}
	}
    public static int sumNumbers(TreeNode root) {
        dfs(root);
        return ANS;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}

}
