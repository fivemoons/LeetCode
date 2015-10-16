package leetcode;

import java.util.Arrays;

public class Q45_JumpGameII {
	public static int jump2(int[] nums) { //DP TLE
		int[] step = new int[nums.length];
		Arrays.fill(step, -1);
		step[0] = 0;
		for(int i=1; i<step.length; i++){
			for(int j=1;(j <= nums[i])&&(i+j<nums.length); j++){
				step[i+j] = step[i+j] > step[i] + 1 ? step[i+j] : step[i] + 1; 
			}
		}
		return step[step.length - 1];
    }
	public static int jump(int[] nums) { //贪心
		int step = 0; //当前跳的步数
		int currRange = 0; //当前能够跳的最远下标
		int nextRange = 0; //下一跳能到达的最远下标
		for(int i=0; i<nums.length; i++){ //遍历数组
			if(currRange < i){ //如果当前坐标已经超出当前的最大范围
				step++; //多跳一步
				currRange = nextRange;  //因为多跳了一步，所以最大范围更新
			}
			nextRange = nextRange > i + nums[i] ? nextRange : i + nums[i]; //保持下一跳的范围为最新
		}
		return step;
    }
	public static void main(String[] args) {
		System.out.println(jump(new int[]{3,2,1}));
	}

}