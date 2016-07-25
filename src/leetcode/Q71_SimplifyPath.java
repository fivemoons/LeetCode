package leetcode;

import java.util.Stack;

public class Q71_SimplifyPath {
    public static String simplifyPath(String path) {
    	Stack<String> stack = new Stack<String>(); //栈
    	while (path.length() > 0) { //path还有
    		int i = 0; //寻找/之后的开始
    		while ((i<path.length()) && (path.charAt(i) == '/')) i++; //越过/
    		path = path.substring(i,path.length()); //去掉开头的/
    		String s = path.substring(0, path.indexOf('/') == -1 ? path.length() : path.indexOf('/')); //寻找第一个/之前的单词，可能为""
    		path = path.substring(s.length(),path.length()); //去掉开头的单词部分
    		if (("..".equals(s)) && (!stack.empty())) //如果是.. 就要出栈
    			stack.pop();
    		else if ( (!"".equals(s)) && (!".".equals(s)) && (!"..".equals(s))) //如果是单词 则进入栈中
    			stack.push(s);
    	}
    	
    	if (stack.empty()) //如果是空栈 直接返回/
    		return "/";
    	String ans = new String();
    	while(!stack.empty()){ //非空栈，按照出栈的倒叙输出
    		ans = "/" + stack.pop() + ans;
    	}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(simplifyPath("/abc/.../."));
	}

}
