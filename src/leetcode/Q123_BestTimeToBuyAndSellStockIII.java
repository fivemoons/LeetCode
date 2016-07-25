package leetcode;

public class Q123_BestTimeToBuyAndSellStockIII {
	/*
	 * 差分序列的最大m字段和，m<=2
	 * f[i]表示[0,i]中最大利润 g[i]表示[i,n-1]中最大利润，max{f[i],g[i]}
	 * 
	 */
	public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<=1) return 0;
        int[] f = new int[n];
        int[] g = new int[n];
        int min = prices[0];
        for(int i=1; i<n; i++){
        		min  = Math.min(min, prices[i]); //左侧最小的数字
        		f[i] = Math.max(f[i-1], prices[i] - min); //右侧卖出
        }
        int max = prices[n-1];
        for(int i=n-2; i>=0; i--){
        		max  = Math.max(max, prices[i]); //右侧最大的数字
        		g[i] = Math.max(g[i+1], max - prices[i]); //左侧买入
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
        		ans = Math.max(ans, f[i] + g[i]); //枚举每一个点的分割
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{2,3,1,4,6,2,5}));

	}

}
