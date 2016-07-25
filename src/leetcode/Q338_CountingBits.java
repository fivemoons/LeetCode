package leetcode;

public class Q338_CountingBits {
	public static int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        for(int i = 1; i<=num; i++){
        	ans[i] =  ans[i>>1] + i % 2;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] ans = countBits(10);
		for(int i:ans){
			System.out.print(i+" ");
		}
	}

}
