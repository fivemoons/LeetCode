package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q227_BasicCalculatorII {
	/*  设立一个符号栈
	 *  数字:入栈
	 *  (:入栈
	 *  符号:相同优先级和比它高优先级的出栈
	 *  ):出栈直到(
	 *  出栈则意味着已经可以计算
	 */ 
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
    public static int calculate(String s) {
        Stack<Character> op = new Stack<Character>(); //操作符栈
        List<node> list = new LinkedList<node>(); //存放后缀表达式
        
        for(int i=0; i<s.length(); i++){
        		char c = s.charAt(i);
        		if(Character.isDigit(c)){ //找出全部的字符，直接加入到后缀表达式中
        			int num = c - '0';
        			while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
        				num = num * 10 + (s.charAt(++i) - '0'); 
        			}
        			list.add(new node(num));
        		}else if(c == '('){ //优先级最低，直接入栈
        			op.push('(');
        		}else if(c=='*' || c=='/'){//相同优先级出栈，然后*/入栈
        			while(!op.empty() && (op.peek() == '*' || op.peek() == '/')){
        				list.add(new node(op.pop()));
        			}
        			op.push(c);
        		}else if(c=='+' || c=='-'){//相同优先级和高优先级的出栈，然后+-入栈
        			while(!op.empty() && (op.peek() == '+' || op.peek() == '-' ||
        								  op.peek() == '*' || op.peek() == '/')){
        				list.add(new node(op.pop()));
        			}
        			op.push(c);
        		}else if(c==')'){ //优先级最高，全部出栈直到(
        			while(op.peek() != '('){
        				list.add(new node(op.pop()));
        			}
        			op.pop(); // ‘(’出栈
        		}
        }
        while(!op.empty()) list.add(new node(op.pop()));//把栈清空
        
        //计算后缀表达式值
        Stack<Integer> ans = new Stack<Integer>();
        for(node n:list){
        		//System.out.print(n.toStirng());
        		if (n.isNum)
        			ans.push(n.num);
        		else{
        			char c = n.op;
        			switch (c) {
					case '+': ans.push(ans.pop() + ans.pop()); break;
					case '-': ans.push(- ans.pop() + ans.pop()); break;
					case '*': ans.push(ans.pop() * ans.pop()); break;
					case '/': int num2 = ans.pop(); int num1 = ans.pop(); ans.push(num1/num2); break;
					default:
						break;
					}
        		}
        }
        return ans.pop();
    }
	public static void main(String[] args) {
		System.out.println(calculate("9+(3-1)*3+10/2"));
	}

}
