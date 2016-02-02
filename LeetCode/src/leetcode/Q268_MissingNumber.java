package leetcode;

public class Q268_MissingNumber {
	public int missingNumber(int[] nums) {//nums.length==5时  先xor 0-5 再xor数组，剩下的就是ans
		int ans = 0;
		for(int i=0; i<=nums.length; i++)
			ans ^=i;
		for(int i=0; i<nums.length; i++)
			ans ^=nums[i];
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
