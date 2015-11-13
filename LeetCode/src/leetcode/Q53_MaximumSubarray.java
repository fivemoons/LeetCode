package leetcode;

public class Q53_MaximumSubarray {
    public static int maxSubArray(int[] nums) { //动态规划
        int[] b = new int[nums.length];
        b[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
        	b[i] = b[i-1] > 0 ? b[i-1] + nums[i]: nums[i];
        	max  = b[i] > max ? b[i] : max;
        }
        return max;
    }
    private static int maxSubArray2(int[] nums, int l, int r){
    	if (l==r) return nums[l];
    	
    	int mid = (l+r) >> 1;
    	int maxPre = maxSubArray2(nums,l,mid);
    	int maxEnd = maxSubArray2(nums,mid+1,r);
    	
    	int leftMax = Integer.MIN_VALUE;
    	int rightMax = Integer.MIN_VALUE;
        int sum = 0;  
        for (int i = mid; i >= l; i--)  
        {  
            sum += nums[i];  
            if (sum > leftMax)  
                leftMax = sum;  
        }  
        sum = 0;  
        for (int i = mid+1; i <=r; i++)  
        {  
            sum += nums[i];  
            if (sum > rightMax)  
                rightMax = sum;  
        }  
        sum = leftMax + rightMax;
    	
    	return Math.max( Math.max(maxPre, maxEnd) , sum);
    }
    public static int maxSubArray2(int[] nums){
    	if (nums.length<=0) return 0;
    	return maxSubArray2(nums,0,nums.length-1);
    }
	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int[]{1,2}));
	}

}
