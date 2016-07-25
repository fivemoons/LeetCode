package leetcode;

public class Q209_MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
    		int l = 0, r = 0;
    		int count = 0;
    		int ans = Integer.MAX_VALUE;
    		while(r < nums.length){ //尾指针
    			count += nums[r];
    			while (s <= count){ //首指针
    				ans = Math.min(ans, r - l + 1);
    				count -= nums[l++];
    			}
    			r++;
    		}
    		return ans == Integer.MAX_VALUE ? 0 : ans;
    }
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));

	}

}
