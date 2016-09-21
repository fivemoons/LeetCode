package leetcode2.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q389_FindTheDifference {
	public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for(int i=0; i<t.length(); i++){
            if ((!map.containsKey(t.charAt(i)))||(map.get(t.charAt(i))==0)){
                return t.charAt(i);
            }else{
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        return ' ';
    }
}
