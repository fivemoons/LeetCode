package leetcode;

public class Q6_ZigZagConversion {
	public static String convert(String s, int numRows) {
        String ss= new String("");
        int skip = 1;//(n-1)*2   1,2,4,6,8 行间隔
        int k = 0;//间隔跳转
        int now = 0;//当前坐标
        for (int i=0; i<numRows; i++){//遍历每一行
        		if ((numRows-1) * 2!=0);//排除n=0的情况
        			skip = (numRows-1)*2;//每行的间隔
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
