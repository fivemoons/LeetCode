package leetcode;

public class Q190_ReverseBits {
    public static int reverseBits(int n) {
        int INT_SIZE = Integer.SIZE; //32
        for(int i=0; i<INT_SIZE >>1; i++){ //0-15
        		int j = INT_SIZE - 1 - i; //31-16
        		int r = (n >> i) & 1; //i那一位
        		int l = (n >> j) & 1; //j那一位
        		if ((l ^ r) == 1){ //i j 不同
        			n = n ^ ((1 << i)|(1 << j)); //交换
        		}
        }
        return n;
    }
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));

	}

}
