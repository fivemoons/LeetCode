package leetcode;


public class Q303_RangeSumQueryImmutable {
	private int[] sums;
	
    public Q303_RangeSumQueryImmutable(int[] nums) {
        sums = nums.clone();
        for(int i=1; i<sums.length; i++){
        		sums[i] += sums[i-1];//累加
        }
    }

    public int sumRange(int i, int j) {
        if(i>j || i<0 || j>sums.length) return 0;
        return i==0 ? sums[j] : (sums[j] - sums[i-1]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
