package leetcode2.queue_stack;

import java.util.Stack;

public class Q232_ImplementQueueUsingStacks {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        stack1.pop();
        while(stack2.size() != 0){
            stack1.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int ans = stack1.peek();
        while(stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        return ans;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.size() == 0;
    }
}
