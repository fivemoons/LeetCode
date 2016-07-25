package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q47_PermutationsII {
	private static void back(Map<Integer,Integer> numMap, int rest, List<Integer> ansList, List<List<Integer>> ans){
		if (rest==0){
			ans.add(new LinkedList<Integer>(ansList)); //找到 加入答案中
		}else{
			for(Integer i:numMap.keySet()){ //依次遍历numMap中的数
				if (numMap.get(i)>0){ //如果还有可用
					numMap.put(i, numMap.get(i) - 1); //-1
					ansList.add(i); //list中追加当前元素
					back(numMap,rest - 1,ansList,ans); //枚举下一个num
					numMap.put(i, numMap.get(i) + 1); //+1
					ansList.remove(ansList.size() - 1); //从list中移除最后一个数  注意：remove有重载，移除下标或者第一个Object
				}
			}
		}
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();//创建nums的map，对应value是这个值可用否
		for(int i=0; i<nums.length; i++){
			numMap.put(nums[i], numMap.containsKey(nums[i]) ? numMap.get(nums[i]) + 1 : 1);
		}
		List<List<Integer>> ans = new LinkedList<>();
		back(numMap,nums.length,new LinkedList<Integer>(),ans); //dfs结果
        return ans;
    }
	public static List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>(); //创建答案ans
		int[] firstNums = nums.clone(); //得到一份当前数组的副本
		do {
			List<Integer> ansList = new LinkedList<Integer>(); //存放当前数组
			for(int i:nums){ //将当前数组转换成list
				ansList.add(i);
			}
			ans.add(ansList); //当前list增加进答案
			Q31_NextPernutation.nextPermutation(nums); //nums变成下一个排列
		}while (!Arrays.equals(firstNums, nums)); //直到循环一圈
		return ans;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> ans = permuteUnique(new int[]{2,2,1,1});  //深度优先搜索
		//ans = permuteUnique2(new int[]{1,1,2}); //使用Q31 下一个排列的方法
		for(List<Integer> l1:ans){
			for(Integer i1:l1){
				System.out.print(i1+",");
			}
			System.out.println();
		}
	}

}
