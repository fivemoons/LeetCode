package leetcode;

public class Q34_SearchForARange {
	public int search1(int[] nums, int target){
		int l = 0;
		int r = nums.length - 1;
		while (l <=r){
			int m = (l + r) /2;
			if (nums[m] == target){
				if ((m==0)||((m!=0)&&(nums[m-1] < target))) //相同元素的第一个
					return m;
				else
					r = m - 1;
			}else if (nums[m] < target){
				l = m + 1;
			}else if (target < nums[m]){
				r = m - 1;
			}
		}
		return -1;
	}
	public int search2(int[] nums, int target){
		int l = 0;
		int r = nums.length - 1;
		while (l <=r){
			int m = (l + r) /2;
			if (nums[m] == target){
				if ((m==nums.length - 1)||((m!=nums.length - 1)&&(target < nums[m+1])))//相同元素的最后一个
					return m;
				else
					l = m + 1;
			}else if (nums[m] < target){
				l = m + 1;
			}else if (target < nums[m]){
				r = m - 1;
			}
		}
		return -1;
	}
	public int[] searchRange(int[] nums, int target) {
        return new int[] {search1(nums,target),search2(nums,target)};
    }
	public static void main(String[] args) {
		Q34_SearchForARange q = new Q34_SearchForARange();
		int[] s = q.searchRange(new int[]{5,7,7,8,8,10},8);//寻找起始和终止的坐标
		System.out.println(s[0] + "____" + s[1]);
	}

}
