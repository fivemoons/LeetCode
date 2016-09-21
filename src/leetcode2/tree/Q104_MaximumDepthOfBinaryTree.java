package leetcode2.tree;

public class Q104_MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
