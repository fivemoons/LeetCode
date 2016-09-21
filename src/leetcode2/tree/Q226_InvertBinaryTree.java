package leetcode2.tree;

public class Q226_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }else{
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }
    }
}
