package leetcode2.string;

import java.util.HashSet;
import java.util.Set;

public class Q3_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
    	int l = 0;
    	int ans = 0;
    	Set<Character> set = new HashSet<Character>();
    	for(int i=0; i<s.length(); i++){
    		if (set.contains(s.charAt(i))){
    			while(s.charAt(l) != s.charAt(i)){
    				set.remove(s.charAt(l));
    				l++;
    			}
    			l++;
    		}else{
    			set.add(s.charAt(i));
    			ans = (ans > i-l+1) ? ans : (i-l+1);
    		}
    	}
        return ans;
    }
	public static void main(String[] args) {
	}

}
