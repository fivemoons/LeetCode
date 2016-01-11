package leetcode;

public class Q191_NumberOf1Bits {
	public static int hammingWeight(int n) {
        int INT_SIZE = Integer.SIZE;
        int ans = 0;
        for(int i=0; i<INT_SIZE; i++){
        		ans += ((n >> i) & 1) == 1 ? 1 : 0;
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));

	}

}
