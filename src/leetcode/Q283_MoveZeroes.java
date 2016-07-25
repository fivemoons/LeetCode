package leetcode;

public class Q283_MoveZeroes {
	public static void moveZeroes(int[] nums) {//这题够水
		int l = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != 0){
				nums[l++] = nums[i];
			}
		}
		while(l<nums.length) nums[l++] = 0;
    }
	public static void main(String[] args) {

	}

}
