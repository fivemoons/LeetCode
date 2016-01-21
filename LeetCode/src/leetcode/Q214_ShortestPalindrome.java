package leetcode;

public class Q214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }
    private int getCommonLength(String s){
    	StringBuffer sb = new StringBuffer(s)
    			.append("#")
    			.append(new StringBuffer(s).reverse());
    	int[] next = new int[sb.length()];
    	for(int i=1; i<next.length; i++){
    		int j = next[i-1];
    		while(j>0 && sb.charAt(i) != sb.charAt(j)) j = next[j-1];
    		next[i] = j==0 ? (sb.charAt(i) == sb.charAt(0) ? 1 : 0) : j+1;
    	}
    	return next[next.length - 1];
    }
	public static void main(String[] args) {
	}

}
