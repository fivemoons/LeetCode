package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_BinaryTreeLevelOrderTraversal {
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        traversal(ans, root, 0);
        return ans;
    }
    
    
    
    public static List<List<Integer>> levelOrder2(TreeNode root){
    		List<List<Integer>> ans = new LinkedList<List<Integer>>();
    		if (root==null) return ans;
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		Queue<Integer> level = new LinkedList<Integer>();
    		queue.add(root);
    		level.add(0);
    		while(!queue.isEmpty()){
    			TreeNode tempNode = queue.poll();
    			Integer tempIndex = level.poll();
    			if (ans.size()<=tempIndex)
    				ans.add(new LinkedList<Integer>());
    			ans.get(tempIndex).add(tempNode.val);
    			if (tempNode.left != null){
    				queue.add(tempNode.left);
    				level.add(tempIndex+1);
    			}
    			if (tempNode.right != null){
    				queue.add(tempNode.right);
    				level.add(tempIndex+1);
    			}
    		}
    		return ans;
    }
    
	public static void main(String[] args) {
	}

}
