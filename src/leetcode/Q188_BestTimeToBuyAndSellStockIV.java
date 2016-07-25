package leetcode;

public class Q188_BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) { //动态规划，巨难
    		if (prices.length <= k){ //如果天数小于限制购买的次数，直接按照无限制次数做，返回正差值的的求和
    			int ans = 0;
    			for(int i= 1; i<prices.length; i++){
    				int d = prices[i] - prices[i-1]; //计算差值
    				ans +=  d > 0 ? d : 0; //如果是大于0则累加。
    			}
    			return ans;
    		}
    		int[] l = new int[k+1]; //局部最小值 l[i][j] 表示第i天一定卖出最多j次交易的最优值
    		int[] g = new int[k+1]; //全局最小值 g[i][j] 表示第i天不一定卖出最多j次交易的最优值
    		for(int i=1; i<prices.length; i++){ //依次枚举每一天
    			int d = prices[i] - prices[i-1]; //依次计算差值
    			for(int j=k; j>=1; j--){ //注意是倒序， 如果是二维dp数组可以是正序。因为g[i-1]必须是被更新之前的值。
    				//l[i][j]=max(l[i-1][j]+d,g[i-1][j-1]+max(d,0))
    				//今天必须卖出的j最优值 = max(昨天必须卖出的j最优值 + 今天的利润。今天可能为负，但是没法，必须今天卖。
    				//						  昨天不一定卖出j-1最优值 + 今天买卖一次挣的钱，如果为负就放弃。）
    				l[j] = Math.max(l[j] + d, g[j-1] + (d>0?d:0) ); //一维滚动数组写法
    				//g[i][j]=max(g[i-1][j]，l[i][j])
    				//今天不一定卖出的j最优值 = max(昨天不一定卖出的j最优值，今天一定卖出的j最优值)
    				g[j] = Math.max(g[j], l[j]);
    			}
    		}
    		return g[k];
    }
	public static void main(String[] args) {
		System.out.println(maxProfit(2,new int[]{2,1,2,0,1}));
	}

}
