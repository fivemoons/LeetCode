package leetcode;

public class Q75_SortColors {
	public static void sortColors(int[] nums) { //计数的方法
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        for(int i=0; i<nums.length; i++){
        		if (nums[i] == 0) n0++;
        		else if (nums[i] == 1) n1++;
        		else if (nums[i] == 2) n2++;
        }
        for(int i=0; i<nums.length; i++){
        		if (i<n0) nums[i] = 0;
        		else if (i<n0+n1) nums[i] = 1;
        		else if (i<n0+n1+n2) nums[i] = 2;
        }
    }
	
	public static void sortColors2(int[] nums) { //三指针方法
		int l = 0;  //依次往右走，是0的走越过去了
		int m = 0;  //依次往右走，是0或者1的都越过去了
		int r = nums.length - 1; //依次往左走，是2的都越过去了
		while (m<=r){ //注意：终止条件是01都在m的左边，2在r的右边
			if (nums[m] == 0){  //是0，放在l的左边
				int t = nums[m];
				nums[m] = nums[l];
				nums[l] = t;
				l++;
				m++;
			}else if (nums[m] == 1){ //是1，放在m的左边
				m++;
			}else if (nums[m] == 2){ //是2，放在r的右边
				int t = nums[m];
				nums[m] = nums[r];
				nums[r] = t;
				r--; //注意，不可以m--或者m++ 因为交换之后的nums[m]不能确定大小。
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{2,1,0,0,1,2};
		sortColors2(nums);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]);
		}
	}

}
