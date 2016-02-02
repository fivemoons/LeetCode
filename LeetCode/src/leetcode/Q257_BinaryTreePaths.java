package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q257_BinaryTreePaths {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static void dfs(TreeNode root, List<TreeNode> path, List<String> ans){
		//该递归哪个点，当前路径，存放答案
		if(root==null) return; //空路径直接返回
		path.add(root); //假设状态
		if(root.left == null && root.right == null){ //如果是叶子节点
			StringBuffer s = new StringBuffer(); //生成答案
			for(TreeNode t:path)
				s.append(new Integer(t.val).toString() + "->");
			ans.add(s.delete(s.length()-2,s.length()).toString());
		}
		dfs(root.left, path, ans); //递归左子树
		dfs(root.right, path, ans); //递归右子树
		path.remove(root); //移除状态
	}
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<String>();
        dfs(root,new LinkedList<TreeNode>(),ans);
        return ans;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		List<String> ans = binaryTreePaths(root);
		for(String s:ans){
			System.out.println(s);
		}
	}
}
