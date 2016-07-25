package leetcode;

import java.util.Arrays;

public class Q31_NextPernutation {
	public static void nextPermutation(int[] nums) {
		/**
		 * 1、从右往左第一个nums[p] < nums[p+1]; 找到p
		 * 2、从右往左第一个nums[p] < nums[c]; 找到c
		 * 3、交换nums[p]和nums[c]
		 * 4、从p+1的位置开始到最后一个数 排序。
		 */
		//1
		int p = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > nums[i]) {
				p = i;
				break;
			}
		}

		if (p == -1) {
			Arrays.sort(nums);
			return;
		}
		//2
		int c = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[p] < nums[i]) {
				c = i;
				break;
			}
		}
		//3
		int t = nums[c];
		nums[c] = nums[p];
		nums[p] = t;
		//4
		Arrays.sort(nums, p + 1, nums.length);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 5 };
		nextPermutation(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
