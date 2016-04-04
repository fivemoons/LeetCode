package leetcode2.string;

public class Q6_ZigZagConversion {
	/*
	 * 0   4   8
	 *  1 3 5 7 9
	 *   2   6   10
	 */
	public static String convert(String s, int numRows) {
		if(numRows<=1) return s;
		StringBuffer ss= new StringBuffer();
        int skip = (numRows-1)*2;//(n-1)*2   1,2,4,6,8 行间隔
        for (int i=0; i<numRows; i++){//遍历每一行
        		int now = i;
        		int k = skip - i * 2;
        		while (now < s.length()){
        			if(k!=0){
        				ss.append(s.charAt(now));
        				now += k;
        			}
        			k = skip - k;
        		}
        }
        return ss.toString();
    }
	public static void main(String[] args) {
		String s = "0123456789";
		System.out.println(convert(s,3));
	}
}
