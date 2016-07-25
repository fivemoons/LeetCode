package leetcode;

public class Q168_ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        String ans = "";
        while(n!=0){
        		ans = (char)((n-1) % 26 + 'A') + ans; //减一再取余计算与A的偏移  高位在前
        		n = (n-1) / 26; //25变成0 26变成0 27变成1 28变成1 除数26不能变
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(26));

	}

}
