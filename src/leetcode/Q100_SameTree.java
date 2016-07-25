package leetcode;

public class Q100_SameTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) { //值相等，结构相同
        if ((p==null) && (q==null)) return true; //两个都为空返回true
        if ((p==null) || (q==null)) return false; //有一个为空，返回false
        return (p.val == q.val) && (isSameTree(p.left,q.left)) && (isSameTree(p.right,q.right));
    }
	public static void main(String[] args) {

	}

}
