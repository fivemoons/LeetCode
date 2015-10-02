package leetcode;

public class Q44_WildcardMatching {
    public static boolean isMatch(String s, String p) {//TLE
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
    public static boolean isMatch2(String s, String p){
    		int lastsl = -1;  //上一个*匹配的s
    		int lastpl = -1;  //上一个*的p位置
    		int sl = 0; //s下标
    		int pl = 0; //p下标
    		while(sl < s.length()){   //当sl没有匹配完成
    			if ( (pl < p.length()) &&   //pl还没到最后，并且匹配上。
    				 ((s.charAt(sl) == p.charAt(pl)) || (p.charAt(pl) == '?')) ){
    				sl++;
    				pl++;
    			}else if((pl < p.length()) && (p.charAt(pl) == '*')){//pl还没到最后，并且是*
    				lastsl = sl + 1;  //当前sl不增加，说明*匹配了0个字符，lastsl为匹配失败后回溯的位置
    				lastpl = pl++; //记录上这个*号的位置，p下标++
    			}else if(lastpl != -1){  //匹配不上了，但是如果之前有过*号
    				sl = lastsl++; //回退到上次的位置，回溯位置+1
        			pl = lastpl + 1; //从*后一个位置开始匹配。
    			}else{
    				return false; //实在匹配不上了
    			}
    		}
    		while ((pl < p.length())&&(p.charAt(pl) == '*')){
    			pl++;
    		}
    		return pl == p.length();
    }
	public static void main(String[] args) {
		//System.out.println(isMatch2("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
		//		"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
		System.out.println(isMatch2("aaaaaa","aba"));
	}

}
