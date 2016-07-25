package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSumII {
	public List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public int[] can = new int[]{}; //存放原始数据的数组
	
	public void back(ArrayList<Integer> curans, int from, int target){ //存放当前答案的下标，从下标from开始回溯，target是最终值
		if (target==0){
			boolean exist = false;//判断是否已经存在
			for (int i=0; i<ans.size(); i++){
				if (ans.get(i).size() != curans.size()){ //长度不一样，直接pass，判断下一个
					continue;
				}
				int j;
				for (j = 0; j<curans.size(); j++){
					if (ans.get(i).get(j) != curans.get(j))//返回第一个不一样的坐标
						break;
				}
				if (j==curans.size()){//全都相等，坐标越界
					exist = true;//判断已经存在
					break;//不用再继续判断
				}
					
			}
			if (!exist)
				ans.add(new ArrayList<Integer>(curans)); //找到了一组合法答案，加入到ans中。
		}else{
			for(int i=from; (i<can.length) && (target >= can[i]); i++){//下标没越界，剩下的target大于等于当前值。
				curans.add(can[i]);//增加的是can中的数，不知道为什么存放下标会只有一组值。
				back(curans,i + 1,target-can[i]);//回溯当前答案list，当前下标+1（说明下标不可以重复），剩余target值
				curans.remove(new Integer(can[i])); //注意：curans是个ArrayList 存放的是Integer，删除是必须是Integer类型才是元素，而int类型则是list的下标。
			}
		}
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //首先进行排序，选择下标返回会变少。
        can = candidates; //保存一份candidates数组。
        back(new ArrayList<Integer>(),0,target);  //从空list开始，下标从0开始，target
        return ans;
    }
	
	public static void main(String[] args) {
		Q40_CombinationSumII q = new Q40_CombinationSumII();
		List<List<Integer>> temp = q.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
		for (List<Integer> t1 : temp){
			for(Integer t2 : t1){
				System.out.print(t2+"_");
			}
			System.out.println();
		}
	
	}

}
