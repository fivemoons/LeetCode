package leetcode;

public class Q14_LongestCommonPrefix {//这也是一个水题，但是要注意{} {""}这两种情况。
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)	return "";//为了处理{}这种情况
		int ans = 0;//最后要返回的长度
		try {
			while (true) {
				for (int i = 0; i < strs.length; i++) {//从0开始 让{""}抛出异常
					if (strs[i].charAt(ans) != strs[0].charAt(ans))
						return strs[0].substring(0, ans);
				}
				ans++;
			}
		} catch (Exception e) {
			return strs[0].substring(0, ans);
		}
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {""}));
	}
}
