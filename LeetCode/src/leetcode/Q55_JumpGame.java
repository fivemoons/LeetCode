package leetcode;

public class Q55_JumpGame {
    public static boolean canJump(int[] nums) {
        int max = nums[0]; //现在最远到达的范围
        for(int i=1; i<nums.length; i++){
        		if (i > max) return false; //如果已经到不了，返回false
        		max = Math.max(max, i+nums[i]); //更新最远范围。
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
