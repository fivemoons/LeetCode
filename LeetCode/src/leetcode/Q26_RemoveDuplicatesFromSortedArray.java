package leetcode;

public class Q26_RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0; //空数组返回0
		int ans = 1; //默认返回一个数组元素
		for (int i = 1; i < nums.length; i++) { //遍历数组
			if (nums[i] != nums[ans-1])//如果是新的数字
				nums[ans++] = nums[i]; //数组位置+1
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1,1,2 };
		int ans = removeDuplicates(nums);
		for (int i = 0; i < ans; i++) {
			System.out.print(nums[i]);
		}
	}

}
