package leetcode;

import java.util.Arrays;

public class Q16_3SumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		int ans=0; //最后的答案 最接近target的值
		int closest = Integer.MAX_VALUE; //目前最好的差值
        Arrays.sort(nums); //首先排序
        for(int i=0; i<nums.length-2;i++){ //枚举第一个数
        	if ((i!=0)&&(nums[i-1]==nums[i])) continue; //为了去重
        	int l = i + 1; //2sum的左下标
        	int r = nums.length - 1; //2sum的右下标
        	while (l<r){ //左右逼近
        		int sum = nums[i] + nums[l] + nums[r]; //当前的和
    			if (Math.abs(target-sum) < closest){ //判断是否更优
    				closest = Math.abs(target - sum);
    				ans = sum;
    			}
        		if (sum < target){ //如果和偏小
        			l++; //右移左下标
        		}else if (sum > target){ //如果和偏大
        			r--;//左移右下标
        		}else
        			return sum;
        	}
        }
    	return ans;
    }
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
	}
}
