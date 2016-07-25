package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q93_RestoreIPAddresses {
	private static boolean isNum(String s){
		if ((s.length() == 0) ||((s.length() > 1) && ('0' == s.charAt(0))))
			return false; //空或者好几个0
		Integer i = Integer.valueOf(s); //转换成数字
		if ((0<=i) && (i<=255)) //0~255之内
			return true;
		else
			return false;
	}
	private static void isIP(List<String> ans, String s, int d1, int d2, int d3){
		int len = s.length();
		if (d1 + d2 + d3 >= len) return; //至少给最后一个留一个数
		if (len - d1 - d2 - d3 > 3) return; //最后一个数最多三位数
		String s1 = s.substring(0, d1); //第一段
		String s2 = s.substring(d1, d1+d2); //第二段
		String s3 = s.substring(d1+d2,d1+d2+d3); //第三段
		String s4 = s.substring(d1+d2+d3); //第四段
		if(isNum(s1) && isNum(s2) && isNum(s3) && isNum(s4)){ //四个都是0...255的数
			ans.add(s1+'.'+s2+'.'+s3+'.'+s4); //增加答案
		}
	}
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<String>();
        for(int i=1; i<=3; i++) //枚举第一个数的长度
        	for(int j=1; j<=3; j++) //枚举第二个数的长度
        	for(int k=1; k<=3; k++){ //枚举第三个数的长度
        		isIP(ans,s,i,j,k); //当前分法是不是IP
        	}
        return ans;
    }
	public static void main(String[] args) {
		List<String> ans = restoreIpAddresses("0000");
		for(String s:ans){
			System.out.println(s);
		}
	}

}
