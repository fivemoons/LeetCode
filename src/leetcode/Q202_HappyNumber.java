package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q202_HappyNumber {
    private static Set<Integer> set = new HashSet<Integer>();
    public static boolean isHappy(int n) {
    	int ans = 0;
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); i++){
        	int t = s.charAt(i) - '0';
        	ans += t*t;
        }
        if (ans == 1)
        	return true;
        else if (set.contains(ans))
        	return false;
        else{
        	set.add(ans);
        	return isHappy(ans);
        }
    }
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

}
