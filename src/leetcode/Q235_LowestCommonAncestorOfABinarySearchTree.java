package leetcode;

public class Q235_LowestCommonAncestorOfABinarySearchTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        if(Math.max(p.val, q.val)<root.val) return lowestCommonAncestor(root.left,p,q);
        if(Math.min(p.val, q.val)>root.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		TreeNode p = root.left.left;
		TreeNode q = root.right.right;
		TreeNode f = lowestCommonAncestor(root,p,q);
		System.out.println(f.val);
	}

}
