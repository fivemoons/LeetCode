package leetcode;

public class Q44_WildcardMatching {
    public static boolean isMatch(String s, String p) {
		if (p.length() == 0) //如果p串为空，只有s为空才可
			return s.length() == 0;
		if (s.length() == 0) //如果s串为空，只有p为空才可
			return p.length() == 0;
		if ((p.charAt(0) == '?')||(p.charAt(0) == s.charAt(0))){
			return isMatch(s.substring(1),p.substring(1));
		}else if (p.charAt(0) == '*'){
			while ((p.length() > 1)&&(p.charAt(1) == '*'))
				p = p.substring(1);
			for(int i=0; i<=s.length(); i++){
				if (isMatch(s.substring(i),p.substring(1)))
					return true;
			}
			return false;
		}else
			return false;
    }
	public static void main(String[] args) {
		System.out.println(isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
				"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));

	}

}
