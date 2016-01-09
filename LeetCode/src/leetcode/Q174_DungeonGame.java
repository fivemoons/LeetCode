package leetcode;

public class Q174_DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) { //使用动态规划
        int m = dungeon.length; //高度
        int n = dungeon[0].length;//长度
		int[][] dp = new int[m][n]; //dp数组
        for(int i=m-1; i>=0; i--){ //倒序
        		for(int j=n-1; j>=0; j--){
        			if ((i==m-1)&&(j==n-1)) //起始点 保证能通过最后一个点
        				dp[i][j] = dungeon[m-1][n-1] >= 0      ? 0 : -dungeon[m-1][n-1];
        			else if (i==m-1) //最后一行
        				dp[i][j] = dungeon[i][j] >= dp[i][j+1] ? 0 : dp[i][j+1] - dungeon[i][j];
        			else if (j==n-1) //最后一列
        				dp[i][j] = dungeon[i][j] >= dp[i+1][j] ? 0 : dp[i+1][j] - dungeon[i][j];
        			else
        				dp[i][j] = Math.min(
        						dungeon[i][j] >= dp[i][j+1] ? 0 : dp[i][j+1] - dungeon[i][j], //横着走
        						dungeon[i][j] >= dp[i+1][j] ? 0 : dp[i+1][j] - dungeon[i][j]); //竖着走
        		}
        }
        return dp[0][0] + 1;
    }
	public static void main(String[] args) {
		System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
	}

}
