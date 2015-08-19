package leetcode;

public class Q6_ZigZagConversion {
	public static String convert(String s, int numRows) {
        String ss= new String("");
        int skip = 1;
        int k = 0;
        int now = 0;
        for (int i=0; i<numRows; i++){
        		if ((numRows-1) * 2!=0);
        			skip = (numRows-1)*2;
        		now = i;
        		k = skip - i * 2;
        		while (now < s.length()){
        			if (k!=0)
        				ss += s.charAt(now);
        			now += k;
        			k = skip -k;
        		}
        }
        return ss;
    }
	public static void main(String[] args) {
		String s = "0";
		System.out.println(convert(s,1));
	}
}
