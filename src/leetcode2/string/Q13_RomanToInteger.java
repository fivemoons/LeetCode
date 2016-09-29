package leetcode2.string;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int ans = 0;
        for(int i=0; i<s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans -= map.get(s.charAt(i));
            }else{
                ans += map.get(s.charAt(i));
            }
        }
        return ans + map.get(s.charAt(s.length()-1));
    }
}
