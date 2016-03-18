package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q15_3Sum {
	public static List<List<Integer>> threeSum(int[] nums) {// n2logn
		Arrays.sort(nums);// 先排序。Arrays的静态方法。
		List<List<Integer>> ans = new ArrayList<>();// ArrayList泛型写空
		for(int b = 0 ; b <=nums.length -3; b++){ //枚举第一个节点
			if(nums[b] > 0) continue;
			if((b > 0) && (nums[b] == nums[b - 1])) continue;
			for(int e = nums.length - 1; e>=b+2; e--){ //枚举第三个节点
				if(nums[e] < 0) continue;
				if((e < nums.length - 1) && (nums[e + 1] == nums[e])) continue;
				int m = 0 - nums[b] - nums[e];// 需要的第二个节点
				if (Arrays.binarySearch(nums, b + 1, e, m) >= 0) {// 二叉查找第二个节点
					ans.add(Arrays.asList(new Integer[] { nums[b], m, nums[e] }));// 找到
																				// 添加
				}
			}
		}
		return ans;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {//n2
		//1 排序
		Arrays.sort(nums);
		//2 构造hashmap
		Map<Integer, Integer> map = new HashMap<>();//存储每个点下标
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);//多个值存在的话 保留最后一个
		}
		//3 寻找答案
		List<List<Integer>> ans = new ArrayList<>();
		for (int b = 0; b < nums.length; b++) {
			if ((b != 0) && (nums[b] == nums[b - 1]))	continue;
			for (int m = b + 1; m < nums.length; m++) {
				if ((m != b + 1) && (nums[m] == nums[m - 1]))	continue;
				int e = 0 - nums[b] - nums[m];//要找的值
				if (map.get(e) != null && map.get(e) > m) {//确定找到
					ans.add(Arrays.asList(new Integer[] { nums[b], nums[m], e }));//添加
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// -4_-1_-1_0_1_2_
		//System.out.println(threeSum(new int[] {-4,-1,-1,0,1,2}));
		//System.out.println(threeSum2(new int[] {-4,-1,-1,0,1,2}));
		System.out.println(threeSum(new int[] {0,0,0,0}));
		/*System.out.println(threeSum(new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4,
				-15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7,
				0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6,
				-13, 14, -2, -5, -11, 1, 3, -6 }));
		System.out.println(threeSum2(new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4,
				-15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7,
				0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6,
				-13, 14, -2, -5, -11, 1, 3, -6 }));*/
	}

}
