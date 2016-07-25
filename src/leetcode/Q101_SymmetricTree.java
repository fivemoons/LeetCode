package leetcode;

public class Q101_SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean isSymmetric(TreeNode root) {
        if (root==null)
        		return true;
        else
        		return isSymmetric(root.left,root.right);
    }
	
	public static boolean isSymmetric(TreeNode p, TreeNode q) { //值相等，结构相同
        if ((p==null) && (q==null)) return true; //两个都为空返回true
        if ((p==null) || (q==null)) return false; //有一个为空，返回false
        return (p.val == q.val) && (isSymmetric(p.left,q.right)) && (isSymmetric(p.right,q.left));
    }
	
	public static void main(String[] args) {
	}

}
