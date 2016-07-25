package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q60_PermutationSequence {
	public static String getPermutation(int n, int k) { //康托展开
		k--;//第k大的数，变成从0开始计数，k-1大的数
		
        int[] fac = new int[n]; //存放n的阶乘
        fac[0] = 1; //0的阶乘为1
        for(int i=1; i<n; i++){ //依次计算阶乘到(n-1)!
        		fac[i] = i * fac[i-1];
        }
        
        int[] ktzk = new int[n]; //存放康托展开的系数
        for(int i=0; i<n; i++){ //a[n-1] * (n-1)! + ... + a[0] * (0)!
        		ktzk[i] = k / fac[n-1-i]; //ktzk[0 ... n-1]  fac[n-1 ... 0]
        		k = k % fac[n-1-i];
        }
        
        List<Integer> num = new LinkedList<Integer>(); //存放系数的list
        for(int i=1; i<=n; i++){
        		num.add(i); //1 ... n 只有这一个地方到n 因为答案中没有0数字的出现
        }
        
        String ans = "";
        for(int i=0; i<n; i++){
        		ans += num.get(ktzk[i]).toString(); //根据ktzk的系数得到，目前第几小的数
        		num.remove(ktzk[i]);//移除，后面的数补位
        }
        return ans; //返回ans
    }
	public static void main(String[] args) {
		System.out.println(getPermutation(8,8590));
	}

}
