package leetcode;

public class Q115_DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int[][] f = new int[s.length() + 1][t.length() + 1];
        for(int i=0; i<=s.length(); i++) //循环变量是字符串的隔板，从0个字符串到n个长度的字符串
        		f[i][0] = 1; //从s的任意长度删成空都只有一种方案
        for(int i=1; i<=s.length(); i++) //枚举字符串的隔板
        	for(int j=1; j<=t.length(); j++){
        		if (s.charAt(i-1) == t.charAt(j-1)) //如果字符相等
        			f[i][j] = f[i-1][j] + f[i-1][j-1]; //当前方案=删掉当前字符（当前字符和s之前匹配）+不删掉当前字符（当前字符匹配）
        		else
        			f[i][j] = f[i-1][j];//字符不相等，当前字符必须删掉，方案数为之前成功的方案数（当前字符和s之前匹配）
        	}
        return f[s.length()][t.length()];
    }
	public static void main(String[] args) {
	}

}
