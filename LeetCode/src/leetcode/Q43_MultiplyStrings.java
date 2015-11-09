package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class Q43_MultiplyStrings {
    public static String multiply(String num1, String num2) {
        BigInteger big1 = new BigInteger(num1);
        BigInteger big2 = new BigInteger(num2);
        return big1.multiply(big2).toString();
    }
    public static String multiply2(String num1, String num2){
    	int[] n3 = new int[num1.length() + num2.length()]; //n3的长度
    	Arrays.fill(n3, 0);//全部赋值0
    	for(int i=0; i<num1.length(); i++)
    		for(int j=0; j<num2.length(); j++){
    			n3[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); //模拟
    		}
    	String ans="";//最后答案
    	for(int i=n3.length - 1; i>=0; i--){
    		if(i>0)//不越界
    			n3[i-1] += n3[i] / 10;
    		n3[i] = n3[i] % 10;
    		ans = (char)(n3[i] + '0') + ans; //转换成char
    	}
    	while ((ans.charAt(0)=='0')&&(ans.length() > 1)) //去掉首位的0
    		ans = ans.substring(1);
    	return ans;
    }
	public static void main(String[] args) {
		System.out.println(multiply2("9133",""));
	}

}
