package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q179_LargestNumber {
	public static String largestNumber(int[] nums) {
        int n = nums.length; //长度
        String[] strs = new String[n]; //转换成字符串
        for(int i=0; i<n; i++){
        		strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>(){ //使用匿名内部类自定义排序
        		@Override
        		public int compare(String o1, String o2) { //39  3
        			String o12 = o1 + o2; //393
        			String o21 = o2 + o1; //339
        			return Long.parseLong(o12) - Long.parseLong(o21) >= 0 ? 1 : -1; //o1>o2 return>0
        		}
        });
        
        String ans = ""; //组合成ans字符串
        for(int i=0; i<n; i++){
        		ans = strs[i] + ans;
        }
        
        return ans.charAt(0) == '0' ? "0" : ans; //去掉多余前导0
    }
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{1,0}));

	}
	
}
