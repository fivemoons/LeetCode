package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q77_Combinations {
	private static void dfs(List<List<Integer>> ans, List<Integer> now, int n, int k, int l){
		if (now.size() == k){ //找到一组答案
			ans.add(new LinkedList<Integer>(now)); //注意生成新list
		}else{
			for(int i=l; i<=n; i++){ //遍历
				now.add(i);//创建状态
				dfs(ans,now,n,k,i+1); //注意：i+1当前数是i
				now.remove(new Integer(i)); //恢复状态
			}
		}		
	}
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		dfs(ans,new LinkedList<Integer>(),n,k,1);
        return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans = combine(4,2);
		for(List<Integer> li:ans){
			for(Integer i:li){
				System.out.print(i+"_");
			}
			System.out.println();
		}
	}

}
