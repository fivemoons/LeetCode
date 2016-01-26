package leetcode;

public class Q221_MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	int max = 0;
    	
    	for(int i=0; i<dp.length; i++){
    		if(matrix[i][0]=='1'){
    			dp[i][0] = 1;
    			max = 1;
    		}
    	}
    	for(int j=0; j<dp[0].length; j++){
    		if(matrix[0][j]=='1'){
    			dp[0][j] = 1;
    			max = 1;
    		}
    	}
    	//dp公式：dp[i][j] = min(dp[i-1][j] , dp[i][j-1], dp[i-1][j-1]) + 1   when  =='1'
    	//                = 0                                               when  =='0' 
    	for(int i=1; i<dp.length; i++){
    		for(int j=1; j<dp[0].length; j++){
        		if(matrix[i][j]=='1'){
        			dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
        			max = Math.max(dp[i][j], max);
        		}else{
        			dp[i][j] = 0;
        		}
    		}
    	}
        return max * max;
    }
	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},
													  {'1','0','1','1','1'},
													  {'1','1','1','1','1'},
													  {'1','0','0','1','0'}}));
	}

}
