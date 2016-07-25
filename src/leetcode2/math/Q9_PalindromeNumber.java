package leetcode2.math;

public class Q9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int len = (int)Math.log10(x)+1;
        for(int i=0; i<=len/2; i++){
            if((x / (int)Math.pow(10,i) % 10) != (x / (int)Math.pow(10,len-i-1) % 10))
                return false;
        }
        return true;
    }
	public static void main(String[] args) {
	}

}
