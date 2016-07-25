package leetcode;

public class Q63_UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid[0][0] == 1) return 0; //起始点有障碍 直接返回0
    	int m = obstacleGrid.length; //地图宽度
    	int n = obstacleGrid[0].length; //地图长度
    	int[][] ans = new int[m][n]; //存放ans

    	ans[0][0] = 1; //初始步数为1
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if (obstacleGrid[i][j] == 0){ //如果这一个点没有障碍
        			if (i>0) ans[i][j] += ans[i-1][j]; //从上边来
        			if (j>0) ans[i][j] += ans[i][j-1]; //从左边来
    			}
    		}
    	}
    	return ans[m-1][n-1];
    }
	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}

}
