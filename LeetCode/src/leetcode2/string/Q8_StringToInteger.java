package leetcode2.string;

public class Q8_StringToInteger {
	public static int myAtoi(String str) {
		str = str.trim();// 去掉字符串前后空格
		if (str == null || str.length() == 0) // 空字符情况
			return 0;
		boolean flag = true; // 字符符号 true + false -
		int i = 0; // 处理坐标
		if (str.charAt(0) == '-') {//负号
			flag = false;
			i++;
		} else if (str.charAt(0) == '+') {//正号
			i++;
		}
		double ans = 0;//默认返回值
		while ((i < str.length()) && (str.charAt(i) >= '0') && (str.charAt(i) <= '9'))
			ans = ans * 10 + (str.charAt(i++) - '0');//运行到错误停止
		return (int) Math.min( Math.max(flag?ans:-ans , Integer.MIN_VALUE) , Integer.MAX_VALUE );
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-123x333"));
	}
}

