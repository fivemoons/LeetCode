package leetcode;

public class Q189_RotateArray {
	private static void reversal(int[] nums, int i, int j){
		while(i<j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reversal(nums,0,n-1-k);
		reversal(nums,n-k,n-1);
		reversal(nums,0,n-1);
    }
	public static void main(String[] args) {
		int[] ans = new int[]{1,2,3,4,5,6,7};
		rotate(ans,3);
		for(int i: ans){
			System.out.print(i);
		}
	}

}
