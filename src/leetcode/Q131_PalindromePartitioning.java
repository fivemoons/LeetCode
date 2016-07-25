package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131_PalindromePartitioning {
	private static boolean isPa(String s){//判断是否是回文
		for(int i=0; i<s.length() >> 1; i++){
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
	private static void dfs(List<List<String>> ans, List<String> now, String s){
		if (isPa(s)){ //整个字符串的情况
			now.add(s);
			ans.add(new ArrayList<String>(now));
			now.remove(now.size()-1);
		}
		for(int i=1; i<s.length(); i++){ //一个分隔的情况到剩一个
			if(isPa(s.substring(0, i))){
				now.add(s.substring(0, i));
				dfs(ans,now,s.substring(i));
				now.remove(now.size()-1);
			}
		}
	}
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<List<String>>();
        dfs(ans,new ArrayList<String>(),s);
        return ans;
    }
	public static void main(String[] args) {
		List<List<String>> ans = partition("aab");
		for(List<String> list:ans){
			for(String s:list){
				System.out.print(s+"_");
			}
			System.out.println();
		}
	}

}
