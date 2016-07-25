package leetcode;

public class Q231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) { // 10000 01111
        return n>0 && (n & (n-1)) == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
