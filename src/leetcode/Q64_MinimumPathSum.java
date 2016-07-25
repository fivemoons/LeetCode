package leetcode;

public class Q64_MinimumPathSum {
	public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
		int[][] ans = new int[m][n];
		ans[0][0] = grid[0][0];
		for(int i=1; i<m; i++){
			ans[i][0] = grid[i][0] + ans[i-1][0];
		}
		for(int j=1; j<n; j++){
			ans[0][j] = grid[0][j] + ans[0][j-1];
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				ans[i][j] = Math.min(ans[i-1][j], ans[i][j-1]) + grid[i][j]; //动态转移方程
			}
		}
		return ans[m-1][n-1];
    }
	public static void main(String[] args) {
		int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minPathSum(grid));
	}

}
