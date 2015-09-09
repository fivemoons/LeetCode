package leetcode;
public class Q29_DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) //除数为0
			return 0;
		if (dividend == Integer.MIN_VALUE) { //被除数为最小值 没有相反数
			if (divisor < 0) //除数小于零
				return divide(dividend - divisor, divisor)==Integer.MAX_VALUE ? //判断是否是MAX_INT
						divide(dividend - divisor, divisor)  :
							divide(dividend - divisor, divisor) + 1;//-1 后+1
			else
				return divide(dividend + divisor, divisor) - 1;
		}
		if (divisor == Integer.MIN_VALUE)//除数为最小值
			return dividend == divisor ? 1: 0;
		if (divisor < 0) //除数为负数
			return divide(-dividend, -divisor);
		if (dividend < 0)//除数为正数
			return -divide(-dividend, divisor);
		int[] ansi = new int[11];
		int ans = 0;
		for (int i = 9; i >= 0; i--) {
			long now = divisor * (new Double(Math.pow(10, i))).longValue();
			while (dividend >= now) {
				dividend -= now;
				ansi[i]++;
				ans += new Double(Math.pow(10, i)).intValue();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));
	}

}
