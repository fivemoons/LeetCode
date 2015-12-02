package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>(); //就算为空也要新来一个list
		if (root == null) return ans; //空点，返回空list
		ans.addAll(inorderTraversal(root.left)); //增加左子树
		ans.add(root.val); //增加当前值
		ans.addAll(inorderTraversal(root.right)); //增加右子树
		return ans;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> ans = inorderTraversal(root);
		for(Integer i:ans){
			System.out.print(i);
		}
	}

}
