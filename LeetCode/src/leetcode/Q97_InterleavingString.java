package leetcode;

public class Q97_InterleavingString {
	/* 	     a b c
	 *     0 1 2 3
	 * a 0 T
	 * b 1
	 * c 2
	 * d 3
	 * e 4       A
	 */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false; //长度都不对
        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1]; //二维数组最左和嘴上加一层保护
        f[0][0] = true; //s3空串可以匹配
        for(int i=0; i<=s1.length(); i++) //依次枚举i和j 从0开始，相当于完全和另一个串相同
        	for(int j=0; j<=s2.length(); j++){
        		if(i>0) f[i][j]  =(s3.charAt(i+j-1) == s1.charAt(i-1)) && (f[i-1][j]); //i==0边界，递推
        		if(j>0) f[i][j] |=(s3.charAt(i+j-1) == s2.charAt(j-1)) && (f[i][j-1]); //j==0边界，递推
        	}
        return f[s1.length()][s2.length()]; //二维数组右下角
    }
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
	}

}
