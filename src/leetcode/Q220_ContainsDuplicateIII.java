package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class Q220_ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0 ||  k<0 || nums.length == 0) return false;
        SortedSet<Long> set = new TreeSet<Long>(); //增删查 在o(logn)时间复杂度下 防止+-t之后越界，需要使用Long
        for(int i=0; i<nums.length; i++){
        	if(set.subSet((long)nums[i] - t, (long)nums[i] + t + 1).isEmpty()){ //空集，说明不包含
        		set.add((long)nums[i]); //当前数字没有问题， 加入到sortedset中
        	}else{ //说明在-t~~t范围内存在元素
        		return true;  //返回true 说明存在相同的元素
        	}
        	if (i-k>=0) //超过k的元素需要移除
        		set.remove((long) nums[i-k]);
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1,1},0,0));
	}

}
