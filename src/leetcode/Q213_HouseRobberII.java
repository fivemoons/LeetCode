package leetcode;

import java.util.Arrays;

public class Q213_HouseRobberII {
    public static int rob(int[] nums) {
    	if (nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
    	int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
    	
		if (nums1.length >=2) nums1[1] = Math.max(nums1[0], nums1[1]);
		if (nums2.length >=2) nums2[1] = Math.max(nums2[0], nums2[1]);
		for(int i = 2; i<nums1.length; i++){
    		nums1[i] = Math.max(nums1[i-1], nums1[i-2] + nums1[i]);
    		nums2[i] = Math.max(nums2[i-1], nums2[i-2] + nums2[i]);
		}
		
		return Math.max(nums1[nums1.length -1] , nums2[nums2.length - 1]);
    }
	public static void main(String[] args) {
		System.out.println(rob(new int[]{1,2,3,4,5}));
	}

}
