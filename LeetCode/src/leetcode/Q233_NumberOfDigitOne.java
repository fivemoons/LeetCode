package leetcode;

public class Q233_NumberOfDigitOne {
	public static int countDigitOne(int n) {//123X56
        int ans = 0;
        for(long m = 1; m <=n; m*=10){// m=100
        		long a = n / m; //123X
        		long b = n % m; //56
        		ans += a/10 * m; //123*100 + 56
        		if(a % 10 == 1) ans += b+1;//123*100 + 56
        		if(a % 10 >= 2) ans += m;//123*100 + 100
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
