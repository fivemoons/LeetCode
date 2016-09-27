package leetcode2.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q387_FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) < 2){
                return i;
            }
        }
        return -1;
    }
}
