package leetcode;

public class Q136_SingleNumber {
    public static int singleNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i<nums.length; i++){
        		x = x ^ nums[i];
        }
        return x;
    }
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,2,2,3,3}));

	}

}
