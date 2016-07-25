package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q107_BinaryTreeLevelOrderTraversalII {
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
		ans.get(level).add(root.val);
		traversal(ans, root.left,  level+1);
		traversal(ans, root.right, level+1);
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        traversal(ans, root, 0);
        List<List<Integer>> ansreverse = new LinkedList<List<Integer>>();
        for(List<Integer> list : ans){
        		ansreverse.add(0, list);
        }
        return ansreverse;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<List<Integer>> ans = levelOrderBottom(root);
		for(List<Integer> list : ans){
			for (Integer i:list){
				System.out.println(i);
			}
		}
	}

}
