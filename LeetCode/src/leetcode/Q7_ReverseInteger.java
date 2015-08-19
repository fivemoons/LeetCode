package leetcode;

public class Q7_ReverseInteger {
	public static int reverse(int x) {	
		try {
			if(x==Integer.MIN_VALUE) throw new Exception();
			if(x<0) return -reverse(-x);
			return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
}
