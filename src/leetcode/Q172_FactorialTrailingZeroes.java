package leetcode;

public class Q172_FactorialTrailingZeroes { //注意：很巧妙
    public static int trailingZeroes(int n) { //计算n!中因子5的个数即可。
        int ans = 0;
        while(n > 0){
        		n = n / 5; //n!里面有n/5个元素是有5 25 125因子的
        		ans += n; //记录5 25 125
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(trailingZeroes(100));
	}

}
