package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets {
	private static void dfs(List<List<Integer>> ans, List<Integer> now, int[] nums, int l){
		//l是当前从第几个数字开始遍历
		ans.add(new LinkedList<Integer>(now)); //注意生成新list，防止引用传递
		for(int i=l; i<nums.length; i++){ //遍历，枚举这次放的是哪个数字
			now.add(nums[i]);//创建状态
			dfs(ans,now,nums,i+1); //注意：下个可以放的数是i+1 当前数是i
			now.remove(new Integer(nums[i])); //恢复状态
		}	
	}
    public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();//用于存放答案
		Arrays.sort(nums); //首先排序
		dfs(ans,new LinkedList<Integer>(),nums,0); //注意新申请一个用于动态存放当前迭代
        return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans = subsets(new int[]{1,2,2});
		for(List<Integer> li:ans){
			for(Integer i:li){
				System.out.print(i+"_");
			}
			System.out.println();
		}
	}

}
