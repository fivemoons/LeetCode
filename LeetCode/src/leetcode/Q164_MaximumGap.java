package leetcode;

import java.util.Arrays;

public class Q164_MaximumGap {
	public static int maximumGap(int[] nums) {//桶排序  注意：这个题桶的大小非常有讲究
		if (nums.length <2) return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i:nums){
			max = max > i ? max : i;
			min = min < i ? min : i;
		}
		if (max == min) return 0; //防止出现len==0的情况；
		//假设nums中的数字是等间隔排列的，len是间隔大小。也是ans的最小值。桶大小。每个桶内的最大差。
		int len = (int)Math.ceil((double)(max - min) / (nums.length - 1));
		//桶的个数,范围/桶大小+1
		int n = (max-min) / len + 1; //0，1，2……n-1
		int[] bMin = new int[n];//每个桶的最小值
		int[] bMax = new int[n];//每个桶的最大值
		Arrays.fill(bMin, Integer.MAX_VALUE);
		Arrays.fill(bMax, Integer.MIN_VALUE);
		
		for(int i=0; i<nums.length; i++){
			int t = (nums[i] - min) / len; //当前数放入几号桶
			bMin[t] = bMin[t] < nums[i] ? bMin[t] : nums[i];
			bMax[t] = bMax[t] > nums[i] ? bMax[t] : nums[i];
		}
		int ans = 0;
		int lastMax = bMax[0];
		for(int i=0; i<n; i++){//枚举每一个桶
			if((bMin[i]!=Integer.MAX_VALUE)&&(bMax[i]!=Integer.MIN_VALUE)){
				ans = Math.max(ans, bMin[i] - lastMax);
				lastMax = bMax[i];
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(maximumGap(new int[]{1,1,1,1}));
	}

}
