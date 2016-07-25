package leetcode;

public class Q122_BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int ans = 0; //累加差分序列
		for(int i=1; i<prices.length; i++){
        		if (prices[i] > prices[i-1]) //如果差分>0
        			ans += prices[i] - prices[i-1];
        }
		return ans;
    }
	public static void main(String[] args) {
	}

}
