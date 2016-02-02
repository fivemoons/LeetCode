package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q264_UglyNumberII {
	public static int nthUglyNumber(int n) {
		int ugly = 0;
		Queue<Integer> q1 = new LinkedList<Integer>(); //1 2 4 8
		Queue<Integer> q2 = new LinkedList<Integer>(); //1 3 6
		Queue<Integer> q3 = new LinkedList<Integer>(); //1 5 10
		q1.add(1);
		q2.add(1);
		q3.add(1);
		for(int i=1; i<=n; i++){
			ugly = Math.min(Math.min(q1.peek(), q2.peek()), q3.peek()); //选择当前的最小值
			if(ugly == q1.peek()) q1.poll(); //和目前相同的丑数出队
			if(ugly == q2.peek()) q2.poll();
			if(ugly == q3.peek()) q3.poll();
			q1.add(ugly * 2); //每次加入到队列中的是当前丑数的 2 3 5倍
			q2.add(ugly * 3);
			q3.add(ugly * 5);
		}
		return ugly;
    }
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(3));
	}

}
