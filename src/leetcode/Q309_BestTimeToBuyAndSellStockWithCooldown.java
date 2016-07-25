package leetcode;

public class Q309_BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) return 0;
		int[] sellDp = new int[prices.length];  // 当天手里为空的最大利润
		int[] buyDp = new int[prices.length];   // 当天手里持股的最大利润
		
		buyDp[0] = -prices[0]; //第一天就买了 赔多少钱
		sellDp[0] = 0; //第一天没买 初始为0
		for (int i=1; i<prices.length; i++){
			sellDp[i] = Math.max(sellDp[i-1], buyDp[i-1] + prices[i]); //卖不受限制 今天为空 = max(昨天就为空，昨天不为空 今天卖出)
			if (i >= 2) {
				buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);//买受影响 今天持有 = max(昨天就持有， 前天为空 昨天冷冻或者无操作 今天买入)
			}else{
				buyDp[i] = Math.max(buyDp[i - 1], -prices[i]); //买受影响 没有前天： 今天持有=max(昨天就持有，昨天没有买 今天第一次买)
			}
		}
		return sellDp[prices.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
