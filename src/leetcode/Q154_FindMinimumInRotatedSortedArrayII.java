package leetcode;

import java.util.Arrays;

public class Q154_FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
		if (nums[0] < nums[nums.length -1]) return nums[0]; //这部分没有翻转
		if (nums.length == 1) return nums[0]; //一个数
		if (nums.length == 2) return Math.min(nums[0], nums[1]); //两个数
		int mid = nums[nums.length>>1]; //三个数以上的中点
    	if (nums[0] < mid) //真的在右侧
    		return(findMin(Arrays.copyOfRange(nums, nums.length >> 1, nums.length)));//带着mid
    	else if (mid < nums[nums.length - 1]) //真的在左侧
    		return(findMin(Arrays.copyOfRange(nums, 0, (nums.length >> 1) + 1)));//带着mid
    	else //左右都可能
    		return Math.min(findMin(Arrays.copyOfRange(nums, nums.length >> 1, nums.length)),
    						findMin(Arrays.copyOfRange(nums, 0, (nums.length >> 1) + 1)));
    }
    public static void main(String[] args) {
    		System.out.println(findMin(new int[]{3,1,3,3}));
    }
}
