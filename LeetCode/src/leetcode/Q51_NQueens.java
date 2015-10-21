package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q51_NQueens {
	private static boolean isOK(int[] cur, int row, int n){
		for(int i=0; i<row; i++){
			if(cur[i] == cur[row]) return false; //是否有相同列
			if(cur[i]-i == cur[row]-row) return false;//是否有相同左上右下对角线
			if(cur[i]+i == cur[row]+row) return false;//是否有相同右上左下对角线
		}
		return true;
	}
    private static void dfs(List<List<String>> ans, int[] cur, int row, int n){
    	if (row == n){ //当前需要放置==n说明已经找到答案
    		List<String> newans = new ArrayList<String>(); //新建一组答案
    		for(int i = 0; i < n; i++){ //遍历每一个答案，生成每一行 
    			StringBuffer s = new StringBuffer();
    			for(int j=0; j<n; j++)
    				s.append('.'); //首先生成n长的字符串
    			s.setCharAt(cur[i], 'Q');//把相应位置的.换成Q
    			newans.add(s.toString());//将string放入newans中
    		}
    		ans.add(newans);//生成一组答案放入ans中
    	}else{
    		for(int i=0; i<n; i++){//依次遍历这一行的每一个位置
    			cur[row] = i;//将当前位置放上皇后
    			if(isOK(cur,row,n)){//判断row行的皇后能否满足条件
    				dfs(ans,cur,row + 1,n);//满足条件则继续递归下一行
    			}
    		}
    	}
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(ans, new int[n],0,n); //答案list 递归存放位置的数组，当前需要放置的行，总行数
        return ans;
        
    }
	public static void main(String[] args) {
		List<List<String>> ans = solveNQueens(4);
		for(List<String> l1 : ans){
			for(String s:l1){
				System.out.println(s);
			}
			System.out.println("----------------------------");
		}
	}

}
