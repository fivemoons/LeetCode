package leetcode;

import java.util.Arrays;

public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((postorder.length == 0) || (inorder.length == 0))
        		return null;
        else{
        		TreeNode root = new TreeNode(postorder[postorder.length-1]);
        		int index = 0;
        		while(inorder[index] != postorder[postorder.length-1]) index++;
        		int[] postleft  = Arrays.copyOfRange(postorder, 0, index);
        		int[] postright = Arrays.copyOfRange(postorder, index, postorder.length-1);
        		int[] inleft   = Arrays.copyOfRange(inorder, 0, index);
        		int[] inright  = Arrays.copyOfRange(inorder, index+1, inorder.length);
        		root.left = buildTree(inleft,postleft);
        		root.right = buildTree(inright,postright);
        		return root;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
