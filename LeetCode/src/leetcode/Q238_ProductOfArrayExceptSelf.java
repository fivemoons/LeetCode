package leetcode;

public class Q238_ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[nums.length-1] = 1; //每个点存的是这个点后面的所有点的乘积
        for(int i=nums.length-2; i>=0; i--){
        		output[i] = output[i+1] * nums[i+1];
        }
        int left = 1; //存放当前点的左边的乘积
        for(int i=0; i<nums.length; i++){
        		output[i] = left * output[i];
        		left = left * nums[i];
        }
        return output;
    }
	public static void main(String[] args) {
	}

}
