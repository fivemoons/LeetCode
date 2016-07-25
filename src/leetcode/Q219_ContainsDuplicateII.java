package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q219_ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums.length == 0) return false;
    	Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length; i++){
        	if(!set.contains(nums[i])){
        		set.add(nums[i]);
        	}else{
        		return true;
        	}
        	if (i-k>=0)
        		set.remove(nums[i-k]);
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{99,99},2));
	}

}
