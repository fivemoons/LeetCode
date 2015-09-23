package leetcode;

import java.util.Stack;

public class Q32_LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		boolean[] bool = new boolean[s.length()]; //判断当前字符是否合法的数组
        Stack<Integer> stack = new Stack<Integer>(); //存放当前括号下标的栈
        for (int i=0; i < s.length(); i++){
        	if (s.charAt(i) == '('){
        		stack.push(i);//左括号进栈
        	}else if ((s.charAt(i) == ')') && !stack.isEmpty()){ //右括号并且栈有东西
        		bool[i] = true;//当前右括号是合法的
        		bool[stack.pop()] = true;//栈顶的左括号出栈，这个左括号也合法
        	}
        }
        
        //找到最长的连续true即可
        int ans=0;//答案
        int cur=0;//当前的true的长度。
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
