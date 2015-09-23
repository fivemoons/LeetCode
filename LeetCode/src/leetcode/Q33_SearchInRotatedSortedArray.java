package leetcode;
public class Q33_SearchInRotatedSortedArray {
	public static int search(int[] nums,int target){//二分法，左右下标要非常注意。
		int l = 0;
		int r = nums.length-1;
		while ((l <= r)&&((nums[l] <= target)||(target <= nums[r]))){//target在l和r中间
			int m = (l + r) / 2;
			if (nums[m] == target){
				return m;
			}else if (nums[l] == target){
				return l;
			}else if (nums[r] == target){
				return r;//这两种情况也要考虑 免得出现集中在一起。
			}else if (nums[l] <= nums[m]){ //mid是在大于的一侧
				if ((nums[l] <= target)&&(target < nums[m])){ //target卡在中间
					r = m - 1; //r左移
				}else{
					l = m + 1; //l右移
				}
			}else if (nums[m] <= nums[r]){//mid是在小于的一侧
				if ((nums[m] < target)&&(target <= nums[r])){ //target卡在中间
					l = m + 1;//l右移
				}else{
					r = m - 1;//r左移
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(search(new int[]{3,1},1));
	}
}
