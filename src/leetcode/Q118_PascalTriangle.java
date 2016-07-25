package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numRows>=1){
        		List<Integer> l0 = new ArrayList<Integer>();
        		l0.add(1);
        		ans.add(l0);
        }
        for(int i=1; i<numRows; i++){
        		List<Integer> li = new ArrayList<Integer>();
        		li.add(1);
        		for(int j=1; j<=i; j++){
        			li.add(ans.get(i-1).get(j-1) + 
        					(i==j ? 0 : ans.get(i-1).get(j)));
        		}
    			ans.add(new ArrayList<Integer>(li));
        }
        return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans = generate(5);
		for(List<Integer> l:ans){
			for(Integer i:l){
				System.out.print(i);
			}
			System.out.println();
		}

	}

}
