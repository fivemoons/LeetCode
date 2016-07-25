package leetcode;

public class Q13_RomanToInteger {
	public static int romanToInt(String s) {
		int ans = 0;
		while (s.length()!=0){//1、continue的使用  2、equals 和 == 的区别
			if ((s.length()>=2)&&(s.substring(0,2).equals("CM"))){ans += 900; s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='M'))		{ans += 1000;s = s.substring(1);  continue;}
			if ((s.length()>=2)&&(s.substring(0,2).equals("CD"))){ans += 400; s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='D'))		{ans += 500; s = s.substring(1);  continue;}
			if ((s.length()>=2)&&(s.substring(0,2).equals("XC"))){ans += 90;  s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='C'))		{ans += 100; s = s.substring(1);  continue;}
			if ((s.length()>=2)&&(s.substring(0,2).equals("XL"))){ans += 40;  s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='L'))		{ans += 50;  s = s.substring(1);  continue;}
			if ((s.length()>=2)&&(s.substring(0,2).equals("IX"))){ans += 9;   s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='X'))		{ans += 10;  s = s.substring(1);  continue;}
			if ((s.length()>=2)&&(s.substring(0,2).equals("IV"))){ans += 4;   s = s.substring(2); continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='V'))		{ans += 5;   s = s.substring(1);  continue;}
			if ((s.length()>=1)&&(s.charAt(0)=='I'))		{ans += 1;   s = s.substring(1);  continue;}
		}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCVI"));
	}

}
