package leetcode;

public class Q58_LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if (s.trim().length() == 0) return 0;
        String[] sp = s.trim().split(" ");
        return sp[sp.length - 1].length();
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
	}

}
