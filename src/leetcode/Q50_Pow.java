package leetcode;

public class Q50_Pow {
	public static double myPow(double x, int n) {
		if (n==Integer.MIN_VALUE) return myPow(x,n+1)*1.0/x; //n=-2147483648的情况
        if (n<0) return 1.0/myPow(x,-n); //n为负数的情况
        if (n==0) return 1; //n==0的情况
        double v = myPow(x,n/2); //得到一半的幂
        return v * v * ( n % 2 == 0 ? 1 : x); //按照奇偶返回
    }
	public static void main(String[] args) {
		System.out.println(myPow(1,-2147483648));
	}

}
