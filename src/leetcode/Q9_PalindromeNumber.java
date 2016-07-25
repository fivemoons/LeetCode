package leetcode;

public class Q9_PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x<0) return false;
		int len = (int) Math.log10(x);
		for (int i = 0; i<(len+1)/2;i++)
			if ((x/(int)Math.pow(10,i) % 10)!=(x/(int)Math.pow(10,len-i) % 10))
				return false;
		return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(101));
	}
}
