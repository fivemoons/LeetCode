package leetcode;

public class Q312_BurstBalloons {
	public static int maxCoins(int[] nums) {
        int[] nums2 = new int[nums.length + 2]; //新建一个数组
        nums2[0] = 1;
        nums2[nums2.length -1] = 1;
        for(int i=0; i<nums.length; i++){
        		nums2[i+1] =nums[i];
        }
        
        //返回0~n-1 其中0和n-1不参与合并
        int n = nums2.length; //长度
        int[][] dp = new int[n][n]; //dp[l][r] 表示从l到r的最大组合
        for(int k=2; k<n; k++){ //枚举宽度
        		for(int l=0; l+k<n; l++){ //枚举首节点，保证尾节点不越界
        			int r = l+k; //尾节点
        			for(int m=l+1; m<r; m++){ //枚举中间位置
        				dp[l][r] = Math.max(dp[l][r],  //每一个状态的最大值
        						nums2[l] * nums2[m] * nums2[r] + dp[l][m] + dp[m][r]); //dp[l][m] 和dp[m][r]开始为0
        			}
        		}
        }
        return dp[0][n-1]; //返回最大合并
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
