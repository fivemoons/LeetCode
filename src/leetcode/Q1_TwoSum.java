package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i); //需要找的值->下标
		}
		for (int i = 0; i < nums.length; i++) {
			Integer v = map.get(nums[i]);
			if (v != null && v != i)//注意 别找到自己
				return new int[] { i , v  };
		}
		return new int[] { 0, 0 };
	}

	public static void main(String[] args) {
		int[] test = { 0, 4, 3, 3,3,0,90 };
		int target = 6;
		int[] result = new int[] {};
		result = twoSum(test, target);
		System.out.println(result[0] + "," + result[1]);
	}
}