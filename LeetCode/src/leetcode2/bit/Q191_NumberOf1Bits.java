package leetcode2.bit;

public class Q191_NumberOf1Bits {
	public static int hammingWeight(int n) {
        int INT_SIZE = Integer.SIZE;
        int ans = 0;
        for(int i=0; i<INT_SIZE; i++){
        		ans += ((n >> i) & 1) == 1 ? 1 : 0;
        }
        return ans;
    }
	public static int hammingWeight2(int n){
		int ans = 0;
		while(n!=0){
			ans++;
			n = n & (n-1);
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight2(11));
	}

}

