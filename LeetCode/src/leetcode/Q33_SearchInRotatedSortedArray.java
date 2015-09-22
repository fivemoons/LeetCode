package leetcode;
public class Q33_SearchInRotatedSortedArray {
	public static int search(int[] nums,int target){
		int l = 0;
		int r = nums.length-1;
		while ((l <= r)&&((nums[l] <= target)||(target <= nums[r]))){
			int m = (l + r) / 2;
			if (nums[m] == target){
				return m;
			}else if (nums[l] == target){
				return l;
			}else if (nums[r] == target){
				return r;
			}else if (nums[l] <= nums[m]){
				if ((nums[l] <= target)&&(target < nums[m])){
					r = m - 1;
				}else{
					l = m + 1;
				}
			}else if (nums[m] <= nums[r]){
				if ((nums[m] < target)&&(target <= nums[r])){
					l = m + 1;
				}else{
					r = m - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(search(new int[]{3,1},1));
	}
}
