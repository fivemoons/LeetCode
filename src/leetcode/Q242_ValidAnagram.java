package leetcode;

import java.util.Arrays;

public class Q242_ValidAnagram {
	public static boolean isAnagram(String s, String t){
		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();
		Arrays.sort(sa);
		Arrays.sort(ta);
		return String.valueOf(sa).equals(String.valueOf(ta));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
