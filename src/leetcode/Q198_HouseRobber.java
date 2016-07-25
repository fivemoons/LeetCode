package leetcode;

public class Q198_HouseRobber {
    public static int rob(int[] nums) {
    		if (nums.length == 0) return 0;
    		if (nums.length >=2) nums[1] = Math.max(nums[0], nums[1]); 
        for(int i = 2; i<nums.length; i++){
        		nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i]);
        }
        return nums[nums.length -1];
    }
	public static void main(String[] args) {
		System.out.println(rob(new int[]{1,2,3,4,5}));
	}

}
