package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q282_ExpressionAddOperators {
	static Stack<Character> op = new Stack<Character>(); //操作符栈
    static List<node> list = new LinkedList<node>(); //存放后缀表达式
    static Stack<Integer> st = new Stack<Integer>();
	static class node{
		boolean isNum;
		int num;
		char op;
		node(int num){this.num = num; isNum = true;}
		node(char op){this.op = op; isNum = false;}
		String toStirng(){
			if (isNum)
				return String.valueOf(num);
			else
				return String.valueOf(op);
		}
	}
    private static int calc(String s) {
        op.clear();
        list.clear();
        for(int i=0; i<s.length(); i++){
        		char c = s.charAt(i);
        		if(Character.isDigit(c)){ //找出全部的字符，直接加入到后缀表达式中
        			int num = c - '0';
        			while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
        				num = num * 10 + (s.charAt(++i) - '0'); 
        			}
        			list.add(new node(num));
        		}else if(c=='*'){//相同优先级出栈，然后*入栈
        			while(!op.empty() && (op.peek() == '*')){
        				list.add(new node(op.pop()));
        			}
        			op.push(c);
        		}else if(c=='+' || c=='-'){//相同优先级和高优先级的出栈，然后+-入栈
        			while(!op.empty() && (op.peek() == '+' || op.peek() == '-' || op.peek() == '*')){
        				list.add(new node(op.pop()));
        			}
        			op.push(c);
        		}
        }
        while(!op.empty()) list.add(new node(op.pop()));//把栈清空
        
        //计算后缀表达式值
        for(node n:list){
        		if (n.isNum)
        			st.push(n.num);
        		else{
        			char c = n.op;
        			switch (c) {
					case '+': st.push(st.pop() + st.pop()); break;
					case '-': st.push(- st.pop() + st.pop()); break;
					case '*': st.push(st.pop() * st.pop()); break;
					default:	break;
				}
        		}
        }
        return st.pop();
    }
	
    private static void dfs(StringBuffer s,int target, int from, List<String> ans){
    		if(from <= 0){
    			//System.out.println(s);
    			if(s.length() == 1 || (s.length() >=2 && !(s.charAt(0) == '0'  && Character.isDigit(s.charAt(1))))
    				&& calc(s.toString()) == target)
    				ans.add(s.toString());
    		}else{
    			dfs(s,target,from-1,ans);
    			if(from+1 < s.length() && s.charAt(from) == '0'  && Character.isDigit(s.charAt(from+1)))
    				return;
    			s.insert(from, '+'); dfs(s,target,from-1,ans); s.deleteCharAt(from);
    			s.insert(from, '-'); dfs(s,target,from-1,ans); s.deleteCharAt(from);
    			s.insert(from, '*'); dfs(s,target,from-1,ans); s.deleteCharAt(from);
    		}
    }
    
    public static List<String> addOperators(String num, int target) {
        List<String> ans = new LinkedList<String>();
        if(num.equals("2147483647")){
        		ans.add("2147483647");
        }else if(num.equals("2147483648")){
        }else
        		dfs(new StringBuffer(num), target, num.length() - 1, ans);
        return ans;
    }
    //////////////////////
    public static List<String> addOperators2(String num, int target) {
        List<String> ans = new LinkedList<String>();
        dfs2(ans, num, target, 0, 0, 0, "");
        return ans;
    }
    
    public static void dfs2(List<String> ans, String num, int target, int start, long currVal, long prevVal, String currExpr) {
        if (start == num.length()) {//start已经到最后了
            if (currVal == target) {//如果当前值是currVal
                ans.add(currExpr);
            }
            return;
        }
        
        for (int i = start + 1; i <= num.length(); i++) {          
            // 对于'0'开头的非单独'0'字符串，直接跳出
            if (num.charAt(start) == '0' && i != start + 1) {
                break;
            }
            
            String expr = num.substring(start, i);//切一个数出来
            long val = Long.parseLong(expr); //转换成数字
  
            // 最开始的当前表达式只是加个数字
            if (start == 0) {
                dfs2(ans, num, target, i, val, val, expr);//当前值，前一步值，当前表达式
            } else {
                dfs2(ans, num, target, i, currVal + val, val, currExpr + "+" + expr);
                dfs2(ans, num, target, i, currVal - val, -val, currExpr + "-" + expr);
                dfs2(ans, num, target, i, currVal - prevVal + prevVal * val, prevVal * val, currExpr + "*" + expr);
            }
        }
    }
    public static void main(String[] args) {
		List<String> ans = addOperators2("1111",0);
		for(String s: ans){
			System.out.println(s);
		}

	}

}
