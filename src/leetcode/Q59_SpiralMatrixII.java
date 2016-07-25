package leetcode;

public class Q59_SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		int sum = n*n;
		int i = 0, j = -1;
		int d = 0;
		while(sum > 0){
			if ((0<=i+dir[d][0]) && (i+dir[d][0]<n) &&
				(0<=j+dir[d][1]) && (j+dir[d][1]<n) &&
				(ans[ i+dir[d][0] ][ j+dir[d][1] ]) == 0){
				i += dir[d][0];
				j += dir[d][1];
				sum--;
				ans[i][j] = n*n - sum;
			}else{
				d = (d + 1) % 4;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] ans = generateMatrix(3);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + "_");
			}
			System.out.println();
		}
	}

}
