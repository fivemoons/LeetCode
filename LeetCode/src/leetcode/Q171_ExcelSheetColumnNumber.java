package leetcode;

public class Q171_ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int ans = 0;
        for(int i=0; i<s.length(); i++){
        		char c = s.charAt(i);
        		ans = ans * 26 + (c - 'A' + 1); //注意：记得+1  A是1
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AA"));
	}

}
