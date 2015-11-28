package leetcode;

import java.util.Stack;

public class Q84_LargestRectangleInHistogram {
	public static int largestRectangleArea(int[] height) {//注意：用一个栈
		int ans = 0; //答案
		int i = 0; //下标
		Stack<Integer> s = new Stack<Integer>(); //当前左边的递减序列
		while(i<=height.length){ //比数组长度多1
			int now = (i == height.length ? 0 : height[i]); //把数组的最后一个元素调成0
			if (s.empty() || height[s.peek()] <= now ){ //是递增的加入栈中
				s.push(i++); //入栈，i++
			}else{ //是一个比刚才底的点
				int maxi = s.pop(); //前一个点出栈
				ans = Math.max(ans, (s.empty() ? i : i - s.peek() - 1 ) * height[maxi]); 
				//如果是空，则左边长度够，如果有点，则从该点之后的那个点开始算宽度，而高度为前一个点的高度。
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,2,2,2,2}));
	}

}
