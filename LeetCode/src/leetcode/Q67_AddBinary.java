package leetcode;

import java.math.BigInteger;

public class Q67_AddBinary { //BigInteger 很简单。。。
    public static String addBinary(String a, String b) {
    		BigInteger biga = new BigInteger(a,2);
    		BigInteger bigb = new BigInteger(b,2);
    		BigInteger bigc = biga.add(bigb);
    		return bigc.toString(2);
    }
	public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
	}

}
