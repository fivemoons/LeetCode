package leetcode;

import java.util.Arrays;

public class Q4_MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length + nums2.length;
		if ((m & 0x01) == 0x01) //奇数
			return find(nums1, nums2, m/2); //下标
		else
			return (find(nums1, nums2, m/2-1) + 
					find(nums1, nums2, m/2))/2.0;
	}
	
	private static double find(int[] nums1,int[] nums2,int k){
		//System.out.println(nums1.length + "__" + nums2.length + "__" + k);
		if (nums1.length > nums2.length) return find(nums2,nums1,k); //保证nums1比nums2要短
		if (nums1.length == 0) return nums2[k]; //nums1为空
		if (k==0) return Math.min(nums1[0], nums2[0]); //直接返回最小值
		int m1 = Math.min(k/2,nums1.length-1);//nums1要比较的点的坐标
		int m2 = k - m1 -1;//nums2要比较点的坐标，因为两个数组的坐标都是0开始的，所以-1
		//m1+m2=k-1 所以删除包括m1和m2的数时不会删多。
		
		//System.out.println(nums1.length + "__" + nums2.length + "__" + k + "__" + m1 + "__" + m2);
		
		if(nums1[m1] == nums2[m2])
			return nums1[m1]; //直接找到要的值
		else if(nums1[m1] < nums2[m2]){//删除0-m1这m1+1个点
			return find(Arrays.copyOfRange(nums1, m1 + 1, nums1.length) , nums2, m2);
		}else{//删除0-m2这m2+1个点
			return find(nums1 , Arrays.copyOfRange(nums2, m2 + 1, nums2.length), m1);
		}
	}
	public static void main(String[] args) {
		int[] nums1 = new int[]{4,6};
		int[] nums2 = new int[]{1,2,3,5,7};
		System.out.println(find(nums1,nums2,2));
		//System.out.println(findMedianSortedArrays(nums1,nums2));
	}
}
