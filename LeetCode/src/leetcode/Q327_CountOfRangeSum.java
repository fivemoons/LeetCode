package leetcode;

import java.util.Arrays;

public class Q327_CountOfRangeSum { //这题。。又弄了一天
	private int lowbit(int x){
		return x & (-x);
	}
	private void add(int[] bit, int idx, int val){
		for( ;idx<bit.length; idx += lowbit(idx) ){
			bit[idx] += val;
		}
	}
	private int get(int[] bit, int idx){
		int ans = 0;
		for( ;idx>0; idx -= lowbit(idx) ){
			ans += bit[idx];
		}
		return ans;
	}
	public int countRangeSum(int[] nums, int lower, int upper) { //题意：返回nums的子区间和在[lower, upper]的数目
        int n = nums.length + 1; //一共有多少个累加和
        long[] sum = new long[n]; //用来计算累积和
        long[] cand = new long[3 * n + 1]; //这个数组很重要，记录左右下标和 sum 值
        
        cand[0] = 0;
        cand[1] = lower - 1;
        cand[2] = upper;
        for(int i=1; i<n; i++){
        		sum[i] = sum[i-1] + nums[i-1];
        		cand[3*i] = sum[i];
        		cand[3*i+1] = sum[i] + lower - 1;
        		cand[3*i+2] = sum[i] + upper;
        }
        cand[3*n] = Long.MIN_VALUE;
        
        Arrays.sort(cand); //别忘排序
        
        int[] bit = new int[3 * n + 1];//BIT树从1开始
        
        for(int i=0; i<sum.length; i++){
        		add(bit, Arrays.binarySearch(cand, sum[i]), 1); //sum[i]打上对勾
        }
        int ans = 0;
        for(int i=0; i<sum.length; i++){
        		add(bit, Arrays.binarySearch(cand, sum[i]), -1);//sum[i]去掉对勾
        		ans += get(bit, Arrays.binarySearch(cand, upper + sum[i])); //计算 sum[j]+lower-1 < sum[i] <= sum[j]+upper j<i
        		ans -= get(bit, Arrays.binarySearch(cand, lower + sum[i] - 1));
        }
        return ans;
    }
	public static void main(String[] args) {
	}

}