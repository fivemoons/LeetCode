package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q228_SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
    		List<String> ans = new LinkedList<String>();
        if (nums==null || nums.length == 0)
        		return ans;
        	int from = 0;
        	int to = 0;
        	for(int i=1; i<nums.length; i++){
        		if (nums[i]-nums[i-1] != 1){
        			to = i-1;
        			if (from == to){
        				ans.add(String.valueOf(nums[from]));
        			}else{
        				ans.add(String.valueOf(nums[from])+"->"+String.valueOf(nums[to]));
        			}
        			from = i;
        		}
        	}
        	to = nums.length - 1;
        	if (from == to)
        		ans.add(String.valueOf(nums[from]));
        	else
        		ans.add(String.valueOf(nums[from])+"->"+String.valueOf(nums[to]));
        	return ans;
    }
	public static void main(String[] args) {
		List<String> ans = summaryRanges(new int[]{0,1,2,4,6,7});
		for(String s: ans){
			System.out.println(s);
		}
	}

}
