package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q119_PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> l0 = new ArrayList<Integer>();
        List<Integer> l1 = new ArrayList<Integer>();
        if (rowIndex>=0){
        		l1 = new ArrayList<Integer>();
        		l1.add(1);
        }
        for(int i=1; i<=rowIndex; i++){
        		l0.clear();
        		l0.addAll(l1);
        		l1.clear();
        		l1.add(1);
        		for(int j=1; j<=i; j++){
        			l1.add(l0.get(j-1) + 
        					(i==j ? 0 : l0.get(j)));
        		}
        }
        return l1;
    }
	public static void main(String[] args) {
		List<Integer> ans = getRow(13);
		for(Integer i:ans){
			System.out.print(i+"__");
		}
	}

}
