package leetcode;

import java.util.Arrays;

public class Q322_CoinChange {
	public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++){
			int min = Integer.MAX_VALUE;
        		for(int j=0; j<coins.length; j++){
        			if((i-coins[j]>=0) && (dp[i-coins[j]] != -1)){
        				min = Math.min(min, dp[i-coins[j]] + 1);
        			}
        		}
    			if(min != Integer.MAX_VALUE){
    				dp[i] = min;
    			}
        }
        return dp[amount];
    }
	public static void main(String[] args) {
		System.out.println(coinChange(new int[]{2,5,10,1},27));

	}

}
