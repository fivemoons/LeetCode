package leetcode;

public class Q3_LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s){
		boolean[] sign = new boolean[128];
		int begin = 0;
		int ans = 0;
		for(int i=0; i<s.length(); i++){
			if (sign[s.charAt(i)]){ //此字母出现过
				while ((s.charAt(begin) != s.charAt(i)) && (begin<i)){ //找到字母出现过的位置
					sign[s.charAt(begin++)] = false; //过路的字符设为false
				}
				begin++; //找到了重复的字符。
			}else{ //没出现过
				sign[s.charAt(i)] = true; //标记该字母出现了
				if (ans < (i - begin + 1)){
					ans = i - begin + 1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s1 = new String("abcabcbb");
		System.out.println(lengthOfLongestSubstring(s1));
	}
}
