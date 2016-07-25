package leetcode;

public class Q260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int ab = 0;
        for(int i:nums){
        		ab ^=i;
        }
        //此时AB是 a xor b
        int mask = ab & (~(ab-1));
        //此时mask是ab的只有最后一位是1
        int a=0,b=0;
        for(int i:nums){
        		if((i&mask) == 0){ //将i分为两类，一类mask位为0
        			a^=i;
        		}else{ //另一类为1
        			b^=i;
        		}
        }
        return new int[]{a,b};
    }
	public static void main(String[] args) {
	}

}
