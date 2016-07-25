package leetcode;

public class Q81_SearchInRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {//二分法，左右下标要非常注意。
		int l = 0;
		int r = nums.length-1;
		while (l <= r){//target在l和r中间
			int m = (l + r) / 2;
			//System.out.println(l+"_"+m+"_"+r);
			if (nums[m] == target){
				return true;
			}else if (nums[l] == target){
				return true;
			}else if (nums[r] == target){
				return true;
			}else if (nums[l] < nums[m]){ //mid是在大于的一侧
				if ((nums[l] < target) && (target < nums[m])){ //target卡在中间
					r = m - 1; //r左移
				}else{
					l = m + 1; //l右移
				}
			}else if (nums[l] > nums[m]){//mid是在小于的一侧
				if ((nums[m] < target) && (target < nums[r])){ //target卡在中间
					l = m + 1;//l右移
				}else{
					r = m - 1;//r左移
				}
			}else if(nums[l] == nums[m]){ //注意：关键在于这里，不能根据nums[l] =nums[m] 判断m是前半部，还是后半部
				l++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[] {1,3,5} , 1));
	}

}
