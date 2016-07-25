package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static void traversal(List<List<Integer>> ans, TreeNode root, int level){
		if (root == null) return;
		if (level>=ans.size())
			ans.add(new LinkedList<Integer>());
		if (level % 2 == 0)
			ans.get(level).add(root.val);
		else
			ans.get(level).add(0, root.val);
		traversal(ans, root.left,  level+1);
		traversal(ans, root.right, level+1);
	}
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        traversal(ans, root, 0);
        return ans; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
