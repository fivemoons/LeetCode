package leetcode;

import java.util.Arrays;

public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder.length == 0) || (inorder.length == 0))
        		return null;
        else{
        		TreeNode root = new TreeNode(preorder[0]);
        		int index = 0;
        		while(inorder[index] != preorder[0]) index++;
        		int[] preleft  = Arrays.copyOfRange(preorder, 1, index+1);
        		int[] preright = Arrays.copyOfRange(preorder, index+1, preorder.length);
        		int[] inleft   = Arrays.copyOfRange(inorder, 0, index);
        		int[] inright  = Arrays.copyOfRange(inorder, index+1, inorder.length);
        		root.left = buildTree(preleft,inleft);
        		root.right = buildTree(preright,inright);
        		return root;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
