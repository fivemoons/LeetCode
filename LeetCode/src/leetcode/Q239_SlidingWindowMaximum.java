package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    		if(nums==null || nums.length == 0 || k == 0) return new int[]{};
        Deque<Integer> q = new LinkedList<Integer>();//q中存放的是在k的范围内的最大值的队列，降序，不会超过k
        int[] ans = new int[nums.length+1-k]; //答案
        for(int i=0; i<nums.length; i++){ //一次遍历
        		while(!q.isEmpty() && nums[q.getLast()]<=nums[i]){ //当当前的数比队尾要大，则把队尾依次移除
        			q.removeLast();
        		}
        		q.addLast(i); //加入队列尾中
        		if(i-(q.getFirst()-1) > k){ //每加入一个元素，则可能会需要移除一个元素
        			q.removeFirst();
        		}
        		if (i+1>=k) //满足可以加入到队列中
        			ans[i+1-k]=nums[q.getFirst()]; //队头元素为当前最大值,肯定在范围内
        }
        return ans;
    }
	public static void main(String[] args) {
	}

}
