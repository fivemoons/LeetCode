package leetcode;

import java.util.Arrays;

public class Q279_PerfectSquares {
	public static int numSquares(int n) {
		if(n == 0) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j=1; j<=n; j++){
        		for(int i=1; i*i<=j; i++){
        			dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
        		}
        }
        return dp[n];
    }
	public static void main(String[] args) {
		System.out.println(numSquares(13));

	}

}
