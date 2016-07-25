package leetcode;

import java.util.Stack;

public class Q224_BasicCalculator {
	public static int calculate(String s){ //使用栈来计算表达式的值
		if(s == null || s.length() == 0) return 0;
		
		Stack<Integer> stack = new Stack<Integer>(); //只有在遇到 () 时才会用到栈
		int ans = 0; //用来存放当前计算的结果
		int sign = 1; //用来存放下一个运算的符号
		
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i); //拿出字符
			if(Character.isDigit(c)){ //如果是数字
				int cur = c - '0';
				while(i+1<s.length() && Character.isDigit(s.charAt(i+1)) ){
					cur = 10*cur + s.charAt(++i) - '0';
				} //把数字拼凑完成
				ans += sign * cur; //计算下结果
			}else if(c == '-'){
				sign = -1; //下一次做-
			}else if(c == '+'){
				sign = 1; //下一次做+
			}else if(c == '('){ //如果是(
				stack.push(ans); //则把 结果 和 运算符号一起入栈，ans sign重置
				ans = 0; //必须，不然括号里第一个数字立即运算了
				stack.push(sign);
				sign = 1;//必须，不然括号里第一个数字之前的符号不确定
			}else if(c == ')'){ //如果是)
				ans = stack.pop() * ans + stack.pop(); //则把 运算符 和 结果一起出栈， 计算当前的结果
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}
