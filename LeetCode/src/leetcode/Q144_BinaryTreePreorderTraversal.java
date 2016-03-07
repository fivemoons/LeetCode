package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144_BinaryTreePreorderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
        while((root != null) || (!stack.empty())){
        		if(root!=null){
        			stack.push(root);
        			ans.add(root.val);
        			root = root.left;
        		}else{
        			root = stack.pop().right;
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.right = new TreeNode(2);
		t.right.left = new TreeNode(3);
		List<Integer> ans = preorderTraversal(t);
		for(Integer i:ans){
			System.out.println(i);
		}
	}

}
