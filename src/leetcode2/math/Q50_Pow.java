package leetcode2.math;

public class Q50_Pow {
	public double myPow(double x, int n) {
        if(n==Integer.MIN_VALUE) return myPow(x,n+1)*1.0/x;
        if(n<0) return myPow(1/x, -n);
        if(n==0) return 1;
        double v = myPow(x, n>>1);
        return v * v * ( n % 2 == 0 ? 1 : x);
    }
}
