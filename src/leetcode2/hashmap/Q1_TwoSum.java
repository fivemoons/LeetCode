package leetcode2.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], i);
		}
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(target - nums[i]) && (map.get(target-nums[i]) != i)){
				return new int[]{i, map.get(target-nums[i])};
			}
		}
		return new int[]{0,0};
	}

	public static void main(String[] args) {
		int[] test = { 3,2,4 };
		int target = 6;
		int[] result = new int[] {};
		result = twoSum(test, target);
		System.out.println(result[0] + "," + result[1]);
	}
}