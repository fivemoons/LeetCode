package leetcode;

public class Q200_NumberOfIslands {
	private static char[][] g;
	private static int n = 0;
	private static int m = 0;
	private static void reversal(int i, int j){
		g[i][j] = '0';
		if ((0<=i-1)&&(g[i-1][j] == '1')) reversal(i-1, j);
		if ((i+1<n) &&(g[i+1][j] == '1')) reversal(i+1, j);
		if ((0<=j-1)&&(g[i][j-1] == '1')) reversal(i, j-1);
		if ((j+1<m) &&(g[i][j+1] == '1')) reversal(i, j+1);
	}
	public static int numIslands(char[][] grid) {
		if ((grid == null)||(grid.length == 0)) return 0;
        g = grid.clone();
        n = g.length;
        m = g[0].length;
        int ans = 0;
        for(int i=0; i<n; i++){
        	for(int j=0; j<m; j++){
        		if(g[i][j] =='1'){
        			reversal(i, j);
        			ans++;
        		}
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','0','0','0'},
									 {'1','1','0','0','0'},
									 {'0','0','1','0','0'},
									 {'0','0','0','1','1'}};
		char[][] grid2 = new char[][]{};
		System.out.println(numIslands(grid));
		System.out.println(numIslands(grid2));

	}

}
