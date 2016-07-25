package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
    		int ans = 0;
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        for(int i:nums){
        		map.put(i, false);
        }
        for(Integer key:map.keySet()){
        		if (!map.get(key)){
        			int now = 1;
        			int i = key;
        			while(map.containsKey(--i) && !map.get(i)){//注意：包含 并且false才可
        				map.put(i, true);
        				now++;
        			}
        			i = key;
        			while(map.containsKey(++i) && !map.get(i)){
        				map.put(i, true);
        				now++;
        			}
        			if (ans < now)
        				ans = now;
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}

}
