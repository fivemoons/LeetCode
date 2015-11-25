package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets {
	private static void dfs(List<List<Integer>> ans, List<Integer> now, int[] nums, int l){
		ans.add(new LinkedList<Integer>(now)); //注意生成新list
		for(int i=l; i<nums.length; i++){ //遍历
			now.add(nums[i]);//创建状态
			dfs(ans,now,nums,i+1); //注意：i+1当前数是i
			now.remove(new Integer(nums[i])); //恢复状态
		}	
	}
    public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		dfs(ans,new LinkedList<Integer>(),nums,0);
        return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans = subsets(new int[]{4,1,0});
		for(List<Integer> li:ans){
			for(Integer i:li){
				System.out.print(i+"_");
			}
			System.out.println();
		}
	}

}
