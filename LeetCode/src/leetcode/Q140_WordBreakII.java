package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q140_WordBreakII {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i=1; i<=s.length(); i++){
    			for(String word:wordDict){
    				if ( (i >= word.length())
    						&& (s.substring(i-word.length(), i).equals(word)) 
    						&& (dp[i-word.length()]) ){
    					dp[i] = true;
    					continue;
    				}
    			}
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		ans.add(new ArrayList<String>());

		if (dp[s.length()]) {
			ans.get(0).add("");
			for (int i = 1; i <= s.length(); i++) { // 依次枚举间隔
				ans.add(new ArrayList<String>());
				for (int j = 0; j < i; j++) {
					String temp = s.substring(j, i);
					if (dp[j] && dp[i] && wordDict.contains(temp)) {
						for (String str : ans.get(j)) {
							ans.get(i).add(str + (str.equals("") ? "" : " ") + temp);
						}
					}
				}
			}
			return ans.get(s.length());
		}else
			return ans.get(0);
	}
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		List<String> ans = wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",wordDict);
		for(String s:ans){
			System.out.println(s);
		}
	}
}
