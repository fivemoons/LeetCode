package leetcode;

public class Q338_CountingBits {
	public static int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        int i = 1;
        int n = 1;
        while(i<num+1){
            if(i == n * 2)
                n <<= 1;
            ans[i] = ans[i-n] + 1;
            i++;
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
