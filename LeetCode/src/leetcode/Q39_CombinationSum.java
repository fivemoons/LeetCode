package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_CombinationSum {//输入无序，数组中没有重复的数，但一个数可以用多次
	public List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public int[] can = new int[]{};
	public void back(ArrayList<Integer> curans, int from, int target){ //存放当前答案的下标，从下标from开始回溯，target是最终值
		if (target==0){
			ans.add(new ArrayList<Integer>(curans)); //找到了一组合法答案，加入到ans中。
		}else{
			for(int i=from; (i<can.length) && (target >= can[i]); i++){//下标没越界，剩下的target大于等于当前值。
				curans.add(can[i]);//增加的是can中的数，不知道为什么存放下标会只有一组值。
				back(curans,i,target-can[i]);//回溯当前答案list，当前下标（说明下标可以重复选择，剩余target值）
				curans.remove(new Integer(can[i])); //注意：curans是个ArrayList 存放的是Integer，删除是必须是Integer类型才是元素，而int类型则是list的下标。
			}
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); //首先进行排序，选择下标返回会变少。
        can = candidates; //保存一份candidates数组。
        back(new ArrayList<Integer>(),0,target);  //从空list开始，下标从0开始，target
        return ans;
    }
	
	public static void main(String[] args) {
		Q39_CombinationSum q = new Q39_CombinationSum();
		List<List<Integer>> temp = q.combinationSum(new int[]{1},1);
		for (List<Integer> t1 : temp){
			for(Integer t2 : t1){
				System.out.print(t2+"_");
			}
			System.out.println();
		}
	
	}

}
