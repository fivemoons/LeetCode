package leetcode;

public class Q151_ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i=1;
        while(i<sb.length()){
        	if ((sb.charAt(i)==' ')&&(sb.charAt(i-1)==' '))
        		sb.deleteCharAt(i);
        	else
        		i++;
        }
        if ((sb.length()!=0) && (sb.charAt(0) == ' ')) sb.deleteCharAt(0);
        if ((sb.length()!=0) && (sb.charAt(sb.length() - 1) == ' ')) sb.deleteCharAt(sb.length() - 1);
        String[] sarr = sb.toString().split(" ");
        String ans = "";
        for(int j=sarr.length - 1; j>=0; j--)
        	ans += " " + sarr[j];
        return ans.length() == 0 ? ans : ans.substring(1);
    }
	public static void main(String[] args) {
		System.out.println(reverseWords(" 1"));
	}

}
