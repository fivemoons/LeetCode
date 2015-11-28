package leetcode;

public class Q88_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {//方法非常好，从后往前移动
        int p1 = m - 1; //nums1尾指针
        int p2 = n - 1; //nums2尾指针
        int p3 = m + n - 1; //合并后的nums1尾指针
        while(p1>=0 && p2>=0){ //当p1和p2都有数
        		nums1[p3--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while(p2>=0){ //当p2还有数
        		nums1[p3--] = nums2[p2--];
        } 
    }
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3,5,7,9,0,0,0,0,0};
		int[] nums2 = new int[]{2,4,6,8,10};
		merge(nums1,5,nums2,5);
		for(int i=0; i<nums1.length; i++){
			System.out.print(nums1[i]);
		}
	}

}
