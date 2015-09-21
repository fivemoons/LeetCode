package leetcode;

import java.util.Stack;

public class Q32_LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		boolean[] bool = new boolean[s.length()]; //判断当前字符是否合法的数组
        Stack<Integer> stack = new Stack<Integer>(); //存放当前括号的栈
        for (int i=0; i < s.length(); i++){
        	if (s.charAt(i) == '('){
        		stack.push(i);
        	}else if ((s.charAt(i) == ')') && !stack.isEmpty()){
        		bool[i] = true;
        		bool[stack.pop()] = true;
        	}
        }
        
        int ans=0;
        int cur=0;
        for (int i = 0; i<s.length(); i++){
        	if (bool[i])
        		cur++;
        	else
        		cur = 0;
        	ans = ans < cur? cur : ans;
        }
        return ans;
    } 
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")())"));
	}
}
