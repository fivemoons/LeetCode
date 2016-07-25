package leetcode;

public class Q165_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\."); //正则表达式分隔
        String[] str2 = version2.split("\\."); //正则表达式分隔
        for(int i=0; (i<str1.length) || (i<str2.length); i++){ //||
        		int num1 = i<str1.length ? Integer.parseInt(str1[i]) : 0; //如果没有，补0
        		int num2 = i<str2.length ? Integer.parseInt(str2[i]) : 0;
        		if (num1>num2) return 1;
        		if (num1<num2) return -1;
        }
        return 0;
    }
	public static void main(String[] args) {
		System.out.println(compareVersion("1","1.0"));
	}

}
