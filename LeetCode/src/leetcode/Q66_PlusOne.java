package leetcode;

public class Q66_PlusOne {
    public static int[] plusOne(int[] digits) {
    		digits[digits.length-1]++; //+1
    		for(int i=digits.length-1; i>0; i--){ //依次进位
    			digits[i-1] += digits[i] / 10;
    			digits[i] %= 10;
    		}
    		if (digits[0]>9){ //首数字是否大于9
    			int[] ans = new int[digits.length + 1];
    			System.arraycopy(digits, 0, ans, 1, digits.length); //注意System.arraycopy
    			ans[0] = ans[1] / 10;
    			ans[1] %= 10;
    			return ans;
    		}else
    			return digits;
    }
	public static void main(String[] args) {
		int[] ans = plusOne(new int[]{9});
		for(int i:ans){
			System.out.print(i+"_");
		}
	}

}
