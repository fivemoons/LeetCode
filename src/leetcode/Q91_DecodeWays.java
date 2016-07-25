package leetcode;

public class Q91_DecodeWays {
    public static int numDecodings(String s) {
        if ((s.length() == 0) || (s.charAt(0) == '0')) return 0;
        int[] ans = new int[s.length() + 1];
        ans[0] = 1; //零个字符只有一种可能
        ans[1] = 1; //一个字符只有一种可能
        for(int i=2; i<=s.length(); i++){
        		ans[i] = 0; //i个字符能产生多少种方案
        		if (s.charAt(i-1) == '0'){//当前是00 10 20 30 40 50...
        			if ((s.charAt(i-2) == '1') || (s.charAt(i-2) == '2')) //当前是10 20  其他ans[i]=0;
        				ans[i] = ans[i-2];
        		}else if ((s.charAt(i-2) == '1') || ((s.charAt(i-2) == '2') && (s.charAt(i-1) <= '6'))){ //11-19 21-26
        			ans[i] = ans[i-2] + ans[i-1]; 
        		}else{ //26以上非0
        			ans[i] = ans[i-1];
        		}
        }
        return ans[s.length()];
    }
	public static void main(String[] args) {
		System.out.println(numDecodings("10"));
	}

}
