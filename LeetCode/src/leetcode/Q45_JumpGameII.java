package leetcode;

public class Q45_JumpGameII {
	public static int jump(int[] nums) { //贪心
		int step = 0; //当前跳的步数
		int currRange = 0; //当前能够跳的最远下标
		int nextRange = 0; //下一跳能到达的最远下标
		for(int i=0; i<nums.length; i++){ //遍历数组
			if(currRange < i){ //如果当前坐标已经超出当前的最大范围
				step++; //多跳一步
				currRange = nextRange;  //因为多跳了一步，所以最大范围更新
			}
			nextRange = Math.max(nextRange , i + nums[i]); //保持下一跳的范围为最新
		}
		return step;
    }
	public static void main(String[] args) {
		System.out.println(jump(new int[]{3,2,1}));
	}

}
