package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q166_FractionToRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; //分子是0
        if (denominator == 0) return ""; //分母是0
        
        String ans = "";
        
        if((numerator < 0) ^ (denominator < 0)) ans+="-";//结果为负
        
        long n = numerator, d = denominator;//避免转正后溢出
        n = Math.abs(n);
        d = Math.abs(d);
        
        ans += new Long(n / d).toString(); //整数部分
        if (n % d == 0) return ans;//整除，没有小数部分
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();//被除数--ans中的位置 注意key
        ans += ".";
        n = n % d; //变成 n<d
        
        while(n != 0){
        		Long r = n * 10 / d; //计算这一位的试商
        		if(map.containsKey(n)){//出现了循环
        			int index = map.get(n); //循环体开始的位置
        			String s1 = ans.substring(0, index);
        			String s2 = ans.substring(index, ans.length());
        			return s1 + "(" + s2 + ")";
        		}else{//未出现循环
        			map.put(n, ans.length());//这个被除数对应放在ans第多少位
        			ans += r.toString(); //追加商
        		}
        		n = n * 10 % d; //计算剩余被除数
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1,333));

	}

}
