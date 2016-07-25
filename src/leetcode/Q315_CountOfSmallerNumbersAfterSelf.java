package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q315_CountOfSmallerNumbersAfterSelf {
	private int lowbit(int x){ //返回数的最后一个1的位置
		/*
		 *  x   = 0 1010
		 * -x   = 1 0110 除符号位外取反+1
		 * x&-x = 0 0010 只剩最后一个1
		 */
		return x & (-x);
	}
	
	private int get(Map<Integer,Integer> bit, int idx){
		int ans = 0;
		//idx -= lowbit(idx); //不包括自己，所以直接去掉一个
		while(idx>0){
			ans += bit.containsKey(idx) ? bit.get(idx) : 0 ; //如果包含则返回那个值，否则返回0
			idx -= lowbit(idx); //idx 减去最后一位的1
		}
		return ans;
	}
	private void add(Map<Integer, Integer> bit, int max, int idx, int val){
		while(idx<=max){
			bit.put(idx, bit.containsKey(idx) ? bit.get(idx) + val : val);
			idx += lowbit(idx); //idx 加上最后一位的1 直到
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>(); //存放ans的list
        
        Map<Integer, Integer> bit = new HashMap<Integer,Integer>(); //Binary Index Tree
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
        		max = Math.max(max, nums[i]);
        		min = Math.min(min, nums[i]);
        }
        min--; //
        max = max - min; //max变成了数值的范围
        
        for(int i=nums.length-1; i>=0; i--){ //倒序摆列
        		nums[i] = nums[i] - min; //nums[i] 变成了相对于min的范围
        		ans.add( get(bit, nums[i]) ); //生成比nums[i]小的个数，存放到ans中
        		add(bit, max, nums[i] + 1, 1); //在对应数字那里加上1，表示那个位置有一个数字了
        		//注意：因为要找右边严格小于的 所以插入数字的时候要+1，意思是后面那些数可以计算，当前不计算
        }
        Collections.reverse(ans);
        return ans;
    }
	
	public static void main(String[] args) {
		Q315_CountOfSmallerNumbersAfterSelf q = new Q315_CountOfSmallerNumbersAfterSelf();
		List<Integer> ans = q.countSmaller(new int[]{5,2,6,1});
		for(Integer i:ans){
			System.out.print(i+"_");
		}
	}

}
