package leetcode;

public class Q137_SingleNumberII {
    public static int singleNumber(int[] nums) {
        int[] w = new int[Integer.SIZE];
        for(int i=0; i<nums.length; i++){
        		for(int j = 0; j < Integer.SIZE; j++){
        			w[j] = (w[j] + ((nums[i] >> j) & 1)) % 3;
        		}
        }
        int ans = 0;
        for(int i=0; i<Integer.SIZE; i++)
        		ans += w[i] << i;
        return ans;
    }
    public static int singleNumber2(int[] nums){
    		int one = 0, two = 0, three = 0;
    		for(int i=0; i<nums.length; i++){
    			two |= (one & nums[i]);//two位：11才进位1
    			one ^= nums[i]; //one位：第一层异或
    			three = ~(one & two); //three  看不懂
    			one &= three;
    			two &= three;
    		}
    		return one;
    }
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{2,2,2,3}));

	}

}
