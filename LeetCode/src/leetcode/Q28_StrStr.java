package leetcode;

public class Q28_StrStr {//找子串 最普通的方法。。。
	public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
	public static void main(String[] args) {
		System.out.println(strStr("abcdefg","cde"));
	}

}
