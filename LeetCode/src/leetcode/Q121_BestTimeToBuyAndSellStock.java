package leetcode;

public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; //当前最小的价格
        int profit = 0; //当前最大的利润
        for(int i=0; i<prices.length; i++){
        		if (min>prices[i])
        			min = prices[i];
        		if (prices[i] - min > profit)
        			profit = prices[i] - min;
        }
        return profit;
    }
	public static void main(String[] args) {
	}

}
