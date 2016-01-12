package leetcode;

public class Q201_BitwiseANDOfNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while(m!=n){
        	m >>=1;
        	n >>=1;
        	bit++;
        }
        return m << bit;
    }
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7));
	}

}
