package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {//这个程序相当漂亮。。
	private static List<String> ans = new ArrayList<>(); //用来存储最后的答案
	private static void gen(int l, int r, StringBuffer s){//递归生成函数：左括号剩余右括号剩余和当前字符串
		if ((l == 0)&&(r == 0)) ans.add(s.toString()); //递归的出口
		if (l>0){ //左括号还有剩余
			s.append('('); //追加左括号
			gen(l-1, r, s); //减去一个左括号
			s.deleteCharAt(s.length()-1); //恢复原状
		}
		if (r-l>0){ //右括号还有剩余
			s.append(')'); //追加右括号
			gen(l, r-1, s); //减去一个右括号
			s.deleteCharAt(s.length()-1); //恢复原状
		}
	}
	public static List<String> generateParenthesis(int n) {
        gen(n,n,new StringBuffer(""));
        return ans;
    }
	
	public static void main(String[] args) {
		List<String> list = generateParenthesis(5);
		for (String s : list){
			System.out.println(s);
		}
	}

}
