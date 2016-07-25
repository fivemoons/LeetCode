package leetcode;

public class Q27_RemoveElement {
	public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int ans = 0;
        for (int i=0; i<nums.length; i++){
        	if (nums[i]!=val)
        		nums[ans++] = nums[i];
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] nums = new int[] { 1,1,2 };
		int ans = removeElement(nums,1);
		for (int i = 0; i < ans; i++) {
			System.out.print(nums[i]);
		}
	}

}
