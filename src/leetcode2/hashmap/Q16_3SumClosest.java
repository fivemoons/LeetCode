package leetcode2.hashmap;

import java.util.Arrays;

public class Q16_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int close = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if((i!=0) && (nums[i] == nums[i-1]))
                continue;
            int l = i+1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(close > Math.abs(target - sum)){
                    ans = sum;
                    close = Math.abs(target - sum);
                }
                if (sum < target){
                    l++;
                    while((l<r) && (nums[l] == nums[l-1])) l++;
                }else{
                    r--;
                    while((l<r) && (nums[r] == nums[r+1])) r--;
                }
            }
        }
        return ans;
    }
}
