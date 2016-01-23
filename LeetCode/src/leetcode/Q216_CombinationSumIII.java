package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q216_CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(ans,new ArrayList<Integer>(),k,n,1);//k个数凑n 现在可以用1
        return ans;
    }
    
    private static void dfs(List<List<Integer>> ans, List<Integer> cur, int k, int n, int from){
    	if((k==0)&&(n==0)){
    		ans.add(new ArrayList<Integer>(cur));
    		return;
    	}
    	if((k>0)&&(n>0)){
    		for(int i=from; i<=9; i++){
    			cur.add(i);
    			dfs(ans,cur,k-1,n-i,i+1);
    			cur.remove(cur.size() - 1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		List<List<Integer>> ans = combinationSum3(3,9);
		for(List<Integer> l1:ans){
			for(Integer l2:l1){
				System.out.print(l2+"_");
			}
			System.out.println();
		}
	}

}
