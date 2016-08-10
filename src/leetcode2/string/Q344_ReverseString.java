package leetcode2.string;

public class Q344_ReverseString {
	public String reverseString(String s) {
        StringBuffer ans = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            ans.insert(0, s.charAt(i));
        }
        return ans.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
