package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_twoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			Integer v = map.get(nums[i]);
			if (v != null && v != i)
				return new int[] { i + 1, v + 1 };
		}
		return new int[] { 0, 0 };
	}

	public static void main(String[] args) {
		int[] test = { -3, 4, 3, 90 };
		int target = 0;
		int[] result = new int[] {};
		result = twoSum(test, target);
		System.out.println(result[0] + "," + result[1]);
	}
}