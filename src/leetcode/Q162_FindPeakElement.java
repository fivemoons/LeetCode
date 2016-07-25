package leetcode;

public class Q162_FindPeakElement {
    public static int findPeakElement(int[] nums) { //找序列最大值
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){ //卡在中间的部分一定比两边的大
        		if (l==r) return l;
        		else{
        			int mid = (l+r)>>1;
        			if (nums[mid]<nums[mid+1])
        				l = mid + 1;
        			else
        				r = mid;
        		}
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,3,1}));

	}

}
