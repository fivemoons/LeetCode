package leetcode;

public class Q152_MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		if (nums.length == 1) return nums[0];
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
        		max[i] = Math.max(max[i-1] * nums[i] , min[i-1] * nums[i]);
        		max[i] = Math.max(max[i], nums[i]);
        		min[i] = Math.min(max[i-1] * nums[i] , min[i-1] * nums[i]);
        		min[i] = Math.min(min[i], nums[i]);
        		ans = ans < max[i] ? max[i] : ans;
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{2,-1,1,1}));
	}

}
