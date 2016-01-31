package leetcode;

import java.util.Stack;

public class Q232_ImplementQueueUsingStacks {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(s1.size() > 1){
        		s2.add(s1.pop());
        }
        s1.pop();
        while(s2.size() > 0){
        		s1.add(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
    		while(s1.size() > 1){
    			s2.add(s1.pop());
    		}
    		int x = s1.peek();
    		while(s2.size() > 0){
    			s1.add(s2.pop());
    		}
    		return x;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
