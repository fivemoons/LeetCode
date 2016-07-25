package leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q301_RemoveInvalidParentheses { //注：这个题写的非常好
	private static int[] lrkh(String s){
		int rkh = 0; //错误的右括号数
		int m = 0; //错误分隔线
		int lkh = 0; //错误的左括号数
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c == '(')
				lkh++; //左括号累加
			else if(c == ')'){
				if(lkh==0){
					rkh++;//出现未匹配的右括号
					m = i+1; //记录最护一个未匹配的右括号之后的位置
				}else
					lkh--;//匹配了一个左括号
			}
		}
		return new int[]{rkh,m,lkh};
	}
	private static void dfs(StringBuilder sb,int from, int del, char c, Set<String> ans){
		if(del == 0){ //已经不用删了
			int[] temp = lrkh(sb.toString()); //是一个正确的括号组合
			if(temp[0] + temp[2] == 0)
				ans.add(sb.toString());
		}
		if(from<0) return; //注意：这个在上一个if之后，因为如果sb是空字符串，则del==0 from==-1 需要添加一个""到ans中
		for(int i=from; i>=0; i--){ //枚举删除哪个点
			if(sb.charAt(i) == c){
				sb.deleteCharAt(i); //创建状态
				dfs(sb,i-1,del-1,c,ans); //递归
				sb.insert(i, c); //恢复状态
			}
		}
	}
    public static List<String> removeInvalidParentheses(String s) {
    		int[] lr = lrkh(s);
    		int r = lr[0], m = lr[1], l = lr[2];
    		StringBuilder sb1 = new StringBuilder(s.substring(0,m));//根据返回结果切割字符串
    		StringBuilder sb2 = new StringBuilder(s.substring(m));

    		
    		Set<String> ans1 = new LinkedHashSet<String>(); //存放左半部分，注意，为了去重 使用Set
    		Set<String> ans2 = new LinkedHashSet<String>(); //存放右半部分
    		List<String> ans = new LinkedList<String>(); //存放最后答案
    		
    		dfs(sb1,sb1.length()-1,r,')',ans1);//s1字符串，从最后开始，删r个右括号，答案存在ans1中
    		dfs(sb2,sb2.length()-1,l,'(',ans2);//s2字符串，从最后开始，删l个左括号，答案存在ans2中
    		
    		for(String s1:ans1){
    			for(String s2:ans2){
    				ans.add(s1 + s2); //依次拼接最后的答案
    			}
    		}
    		return ans;
    }
	public static void main(String[] args) {
		List<String> ans = removeInvalidParentheses(")(");
		System.out.println(ans.size());
		for(String s:ans){
			System.out.println(s);
		}
	}

}
