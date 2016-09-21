package leetcode2.queue_stack;

import java.util.Stack;

public class Q155_MinStack {
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    /** initialize your data structure here. */
    public Q155_MinStack() {
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0){
            minStack.push(x);
        }else{
            minStack.push(Math.min(x,minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
