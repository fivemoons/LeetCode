package leetcode;

public class Q125_ValidPalindrome {
	public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
        		if ((('a'<=s.charAt(i))&&(s.charAt(i)<='z')) || 
        			(('A'<=s.charAt(i))&&(s.charAt(i)<='Z')) || 
        			(('0'<=s.charAt(i))&&(s.charAt(i)<='9')))
        			sb.append(s.charAt(i));
        }
        System.out.println(sb);
        for(int i=0; i<sb.length()>>1; i++){
        		int c1 = sb.charAt(i);
        		int c2 = sb.charAt(sb.length() - i - 1);
        		if ((c1 != c2) && (Math.abs(c1 - c2) != 32))
        			return false;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome("1a2"));
	}

}
