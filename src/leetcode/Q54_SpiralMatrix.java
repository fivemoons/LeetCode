package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q54_SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new LinkedList<Integer>();
		int m = matrix.length;
		if (m==0) return ans; //注意传入空数组的情况
		int n = matrix[0].length;
		boolean[][] bool = new boolean[m][n];
		int i = 0, j = 0, d = 0; // 0右1下2左3上
		while (true) {
			ans.add(matrix[i][j]);
			bool[i][j] = true;
			switch (d) {
			case 0: //往右能走不
				if ((j + 1 < n) && (!bool[i][j + 1])) {
					j++;
				} else if ((i + 1 < m) && (!bool[i + 1][j])) {
					d = 1;
					i++;
				} else
					return ans;
				break;
			case 1: //往下能走不
				if ((i + 1 < m) && (!bool[i + 1][j])) {
					i++;
				} else if ((j - 1 >= 0) && (!bool[i][j - 1])) {
					d = 2;
					j--;
				} else
					return ans;
				break;
			case 2: //往左能走不
				if ((j - 1 >= 0) && (!bool[i][j - 1])) {
					j--;
				} else if ((i - 1 >= 0) && (!bool[i - 1][j])) {
					d = 3;
					i--;
				} else
					return ans;
				break;
			case 3: //往上能走不
				if ((i - 1 >= 0) && (!bool[i - 1][j])) {
					i--;
				} else if ((j + 1 < n) && (!bool[i][j + 1])) {
					d = 0;
					j++;
				} else
					return ans;
				break;
			}
		}
	}
	public static void main(String[] args) {
		List<Integer> ans = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		for(Integer i:ans){
			System.out.print(i + "_");
		}
		System.out.println();
	}

}
