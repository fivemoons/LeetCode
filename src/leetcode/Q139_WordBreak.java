package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q139_WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
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
        return dp[s.length()];
    }
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("dog");
		wordDict.add("s");
		wordDict.add("gs");
		System.out.println(wordBreak("dogs",wordDict));
	}

}
