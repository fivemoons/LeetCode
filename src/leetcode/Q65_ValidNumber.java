package leetcode;

public class Q65_ValidNumber {
	public static boolean isNumber(String s) {
		if (s.trim().isEmpty())
			return false;
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
		if (s.trim().matches(regex))
			return true;
		else
			return false;  
	}
	public static void main(String[] args) {
		System.out.println(isNumber("-123"));

	}

}
