package leetcode;

public class Q53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] b = new int[nums.length];
        b[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
        	b[i] = b[i-1] > 0 ? b[i-1] + nums[i]: nums[i];
        	max  = b[i] > max ? b[i] : max;
        }
        return max;
    }
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{1,2}));
	}

}
