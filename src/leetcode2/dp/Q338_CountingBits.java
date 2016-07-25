package leetcode2.dp;

public class Q338_CountingBits {

	public static int[] countBits(int num) {
		int[] ans = new int[num+1];
		int i=1;
		int n=1;
		ans[0] = 0;
		while(i<num+1){
			if(i==2*n)
				n<<=1;
			ans[i] = ans[i-n] + 1;
			i++;
		}
		return ans;
    }
	public static void main(String[] args) {
		int[] ans = countBits(10);
		for(int i:ans){
			System.out.print(i);
		}
	}

}
