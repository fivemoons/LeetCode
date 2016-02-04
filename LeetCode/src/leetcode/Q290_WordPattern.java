package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q290_WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<Character, String>();
		str += ' ';
		int p = pattern.length();
        for(int i=0; i<p; i++){
        		char c = pattern.charAt(i);
        		int k = str.indexOf(' ');
        		if(k == -1) return false;
        		String s = str.substring(0, str.indexOf(' '));
        		str = str.substring(k+1);
        		
        		if(map.containsKey(c)){
        			if (!map.get(c).equals(s))
        				return false;
        		}else if(map.containsValue(s))
        			return false;
        		else{
        			map.put(c, s);
        		}
        }
        return str.length() == 0;
    }
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}

}
