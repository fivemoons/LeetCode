package leetcode;

public class Q35_SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if (target < nums[0])//比所有元素都小
			return 0;
		if (nums[nums.length - 1] < target) //比所有元素都大
			return nums.length;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
        	int m = (l + r) / 2;
        	if (nums[m] == target)
        		return m;
        	else if (nums[m] < target){
        		if ((m < nums.length - 1)&&(target < nums[m + 1])){ //target>mid找到了位置
        			return m + 1;
        		}else{
        			l = m + 1;
        		}	
        	}else if (target < nums[m]){
        		if ((m > 0)&&(nums[m - 1] < target)){//target<mid找到了位置
        			return m;
        		}else{
        			r = m - 1;
        		}
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6},0));
	}
}
