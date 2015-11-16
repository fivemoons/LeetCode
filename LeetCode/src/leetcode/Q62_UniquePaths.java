package leetcode;

public class Q62_UniquePaths {
    public static int uniquePaths(int m, int n) { //动态规划的方法
    	int[][] ans = new int[m][n];
    	for(int i=0; i<m; i++){
    		ans[i][0] = 1;
    	}
    	for(int j=0; j<n; j++){
    		ans[0][j] = 1;
    	}
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			ans[i][j] = ans[i-1][j] + ans[i][j-1]; //状态转移方程
    		}
    	}
    	return ans[m-1][n-1];
    }
    private static int even(int from, int to){
    	int ans = 1;
    	for(int i=from; i<=to; i++){
    		ans*=i;
    	}
    	return ans;
    }
    private static int combination(int m, int n){
    	return even(n-m+1,n)/even(1,m);
    	
    }
    public static int uniquePaths2(int m, int n){//数论C(m-1,m+n-2);
    	//C(m-1,m+n-2) = 1;
    	return combination(m-1,m+n-2);
    }
	public static void main(String[] args) {
		System.out.println(uniquePaths(10,7));
		System.out.println(uniquePaths2(10,7));
	}

}
