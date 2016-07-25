package leetcode;

import java.util.Arrays;

public class Q108_ConvertSortedArrayToBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int mid = (0 + nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = sortedArrayToBST(Arrays.copyOf(nums, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        return root;
    }
	public static void main(String[] args) {

	}

}
