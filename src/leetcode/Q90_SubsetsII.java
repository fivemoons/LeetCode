package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90_SubsetsII {
    	private static void dfs(List<List<Integer>> ans, List<Integer> now, //总答案，当前枚举list
    				int[] nums2, int[] nums3, int count, int l){ //无重复nums数组，num的个数数组，当前可以放哪个数
    		ans.add(new LinkedList<Integer>(now)); //注意生成新list
    		for(int i=l; i<count; i++){ //遍历
    			for(int j=1; j<=nums3[i]; j++){//依次放1..nums3[i]个，dfs
    				now.add(nums2[i]);//创建状态
    				dfs(ans,now,nums2,nums3,count,i+1); //注意：i+1当前数是i
    			}
    			for(int j=1; j<=nums3[i]; j++) //把nums3[i]个数全部恢复状态
    				now.remove(new Integer(nums2[i])); 
    		}	
    	}
    	public static List<List<Integer>> subsetsWithDup(int[] nums) {
    		List<List<Integer>> ans = new LinkedList<List<Integer>>();
    		Arrays.sort(nums);
    		
    		int[] nums2 = new int[nums.length]; //重复的数字算一个，把nums变成无重复数组
    		int[] nums3 = new int[nums.length]; //对应的nums2数字有几个。
    		int count = 0; //重复的数字算一个，一共有多少个数
    		if (nums.length>0){
    			nums2[0] = nums[0];
    			nums3[0] = 1;
    			count = 1;
    		}
    		for(int i=1; i<nums.length; i++){ //依次遍历nums
    			if (nums[i] != nums[i-1]){//i是个新的num
    				nums2[count] = nums[i]; //放置新num
    				nums3[count] = 1; //新num个数设为1
    				count++; //增加下标,count表个数，所以不先增加下标
    			}else{
    				nums3[count-1]++; //老num个数+1
    			}
    		}
    		
    		dfs(ans,new LinkedList<Integer>(),nums2,nums3,count,0);
    		return ans;
    }
    	public static void main(String[] args) {
    		List<List<Integer>> ans = subsetsWithDup(new int[]{2,2,1});
    		for(List<Integer> li:ans){
    			System.out.print('[');
    			for(Integer i:li){
    				System.out.print(i+"_");
    			}
    			System.out.println(']');
    		}
    	}

}
