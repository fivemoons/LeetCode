package leetcode;

public class Q10_RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) //如果p串为空，只有s为空才可
			return s.length() == 0;
		if ((p.length() == 1)||(p.charAt(1) != '*')){//p只剩一个 或者 p的第二个不是*
			if ((s.length()!=0) && //空串肯定匹配不上
					((p.charAt(0)==s.charAt(0))||(p.charAt(0)=='.'))) //匹配上
				return isMatch(s.substring(1),p.substring(1)); //递归子问题
			else
				return false; //匹配不上直接返回false
		}else{//p至少有两个并且第二个是*
			while ((s.length()!=0) && //空串可以匹配a*，不用再递归尝试
					((p.charAt(0)==s.charAt(0)) || (p.charAt(0)=='.'))){//匹配上
				if (isMatch(s,p.substring(2)))//找到s挪位之后能否匹配上。
						return true;
				s=s.substring(1);//当前挪位没有匹配成功继续挪位。
			}
			return isMatch(s,p.substring(2));//只有当a*匹配了0次才会运行到这里
		}
    }
	public static void main(String[] args) {
		System.out.println(isMatch("aab",".*"));
	}
}
