package leetcode;

public class Q42_TrappingRainWater {
	public static int trap(int[] height){
		int[] maxl = new int[height.length];//当前位置以左最高的柱子
		int[] maxr = new int[height.length];//当前位置以右最高的柱子
		for(int i=1; i<height.length; i++){//第二个到最后
			maxl[i] = maxl[i-1] > height[i-1] ? maxl[i-1] : height[i-1]; //左边柱子和左边最大值
		}
		for(int i=height.length-2; i>=0; i--){//倒数第二个柱子到第一个
			maxr[i] = maxr[i+1] > height[i+1] ? maxr[i+1] : height[i+1]; //右边柱子和右边最大值
		}
		int ans = 0; //最后的答案
		for(int i=1; i< height.length - 1; i++){//第二个到倒数第二个
			int now = (maxl[i] < maxr[i] ? maxl[i] : maxr[i]) - height[i];//当前能放多少水，两边最小值-当前柱子值
			if (now > 0) ans += now;//如果大于0 能加到最后ans中
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(trap(new int[]{0,2,0}));
	}

}
