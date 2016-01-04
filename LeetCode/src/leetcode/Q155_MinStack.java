package leetcode;

import java.util.Stack;

public class Q155_MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();//存放最小数栈
	
    public void push(int x) {
        if(minStack.empty() || x <= minStack.peek())
        		minStack.push(x);
        stack.push(x);
    }

    public void pop() {
    		if(stack.peek().equals(minStack.peek()))
    			minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
    		return minStack.peek();
    }
	public static void main(String[] args) {
		Q155_MinStack ans = new Q155_MinStack();
		ans.push(0);
		System.out.println(ans.top());
	}

}
