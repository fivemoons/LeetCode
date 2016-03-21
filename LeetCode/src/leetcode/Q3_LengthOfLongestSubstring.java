package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3_LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
    	int l = 0; //头指针
    	int ans = 0; //存放ans
    	Set<Character> set = new HashSet<Character>();
    	for(int i=0; i<s.length(); i++){
    		if (set.contains(s.charAt(i))){ //如果前面出现过
    			while(s.charAt(l) != s.charAt(i)){
    				set.remove(s.charAt(l));
    				l++;
    			}
    			l++;
    		}else{ //如果前面未出现过
    			set.add(s.charAt(i));
    			ans = (ans > i-l+1) ? ans : (i-l+1);
    		}
    	}
        return ans;
    }
	public static void main(String[] args) {
		String s1 = new String("abcabcbb");
		System.out.println(lengthOfLongestSubstring(s1));
	}
}
