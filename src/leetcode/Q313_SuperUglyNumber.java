package leetcode;

import java.util.Arrays;

public class Q313_SuperUglyNumber {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] ans = new int[n]; //一共存放n个超级丑数
		int[] idx = new int[primes.length]; //idx中存放的是这个素数该和第几个素数乘
		
		Arrays.fill(ans, Integer.MAX_VALUE); //所有丑数先初始化为最大值
		ans[0] = 1; //第一个丑数是1
		
		for(int i=1; i<n; i++){ //依次生成第i个超级丑数
			for(int j=0; j<primes.length; j++){ //依次使用素数列表中的每一个 * 该乘的数
				ans[i] = Math.min(ans[i], primes[j] * ans[idx[j]]); //取最小值
			}
			for(int j=0; j<primes.length; j++){ //判断是哪个数能够生成
				if(ans[i] % primes[j] == 0) //如果是从那里生成出来
					idx[j]++; //这个素数的下标可以+1
			}
		}
		return ans[n-1];
	}
	public static void main(String[] args) {
	}

}
