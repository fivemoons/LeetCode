package leetcode2.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q350_IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x: nums1){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int x: nums2){
            if(map.containsKey(x) && map.get(x) > 0){
                ans.add(x);
                map.put(x, map.get(x) - 1);
            }
        }
        int[] ans2 = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}
