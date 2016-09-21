package leetcode2.array;

public class Q283_MoveZeroes {
	public void moveZeroes(int[] nums) {
        int begin = 0;
        for(int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                nums[begin++] = nums[i];
            }
        }
        while(begin<nums.length){
            nums[begin++] = 0;
        }
    }
}
