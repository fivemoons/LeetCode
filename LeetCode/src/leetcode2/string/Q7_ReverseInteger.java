package leetcode2.string;

public class Q7_ReverseInteger {
	public int reverse(int x) {	
		if (x == -2147483648) return 0;
		if (x < 0) return -reverse(-x);
		String s1 = new Integer(x).toString();
		char[] ch = s1.toCharArray();
		int n = ch.length - 1;
		for(int i = 0; i<=n/2; i++){
		    int j = n - i;
		    char c = ch[i];
		    ch[i] = ch[j];
		    ch[j] = c;
		}
		String s2 = new String(ch);
		try{
		    return Integer.parseInt(s2);
		}catch(Exception e){
		    return 0;
		}
	}
}
