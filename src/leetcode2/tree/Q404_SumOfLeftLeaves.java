package leetcode2.tree;

public class Q404_SumOfLeftLeaves {
	public boolean isLeave(TreeNode root){
        if (root == null){
            return false;
        }else if (root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }else if(isLeave(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }else{
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
