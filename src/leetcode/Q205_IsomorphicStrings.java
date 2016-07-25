package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
    		Map<Character,Character> map = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
        		char c1 = s.charAt(i);
        		char c2 = t.charAt(i);
        		if (map.containsKey(c1)){ //出现过
        			if (map.get(c1) != c2) //匹配不成功
        				return false;
        		}else{
        			if (map.containsValue(c2)) //被别的字母映射
        				return false;
        			else
        				map.put(c1, c2); //新出现的映射关系
        		}
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab","aa"));

	}

}
