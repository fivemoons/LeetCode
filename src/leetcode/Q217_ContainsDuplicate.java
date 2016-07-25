package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
        	if(!set.contains(nums[i])){
        		set.add(nums[i]);
        	}else{
        		return true;
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{}));
	}

}
