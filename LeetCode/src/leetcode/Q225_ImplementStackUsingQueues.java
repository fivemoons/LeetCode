package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q225_ImplementStackUsingQueues {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
    // 把x压入栈
    public void push(int x) {
    	q1.offer(x); //入队
    }

    // 移除栈顶元素
    public void pop() {
        while(q1.size() > 1) q2.offer(q1.poll()); //出1队，入2队
        q1.poll(); //最后一个元素剔除
        Queue<Integer> t=q1; q1=q2; q2=t;
    }

    // 返回栈顶元素，并没有移除
    public int top() {
        while(q1.size() > 1) q2.offer(q1.poll()); //出1队，入2队
        int x = q1.poll(); //最后一个元素
        q2.offer(x); //也入2队
        Queue<Integer> t=q1; q1=q2; q2=t;
        return x;
    }

    // 判断是否为空
    public boolean empty() {
        return q1.isEmpty();
    }
	public static void main(String[] args) {
	}

}
