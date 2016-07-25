package leetcode;

public class Q236_LowestCommonAncestorOfABinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null ? left : right;
    }
	public static void main(String[] args) {
	}

}
