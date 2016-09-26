package leetcode2.array;

import java.util.HashSet;
import java.util.Set;

public class Q349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<Integer>();
        Set<Integer> num = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++){
            num.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if (num.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int[] ansint = new int[ans.size()];
        int idx = 0;
        for(Integer x: ans){
            ansint[idx++] = x;
        }
        return ansint;
    }
}
