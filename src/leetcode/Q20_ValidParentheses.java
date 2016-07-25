package leetcode;

public class Q20_ValidParentheses {
	public static boolean isValid(String s) {
		StringBuffer ss = new StringBuffer();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				ss.append(c);
				break;
			case '}':
				if ((ss.length()>0)&&(ss.charAt(ss.length()-1))=='{')
					ss.deleteCharAt(ss.length()-1);
				else return false;
				break;
			case ']':
				if ((ss.length()>0)&&(ss.charAt(ss.length()-1))=='[')
					ss.deleteCharAt(ss.length()-1);
				else return false;
				break;
			case ')':
				if ((ss.length()>0)&&(ss.charAt(ss.length()-1))=='(')
					ss.deleteCharAt(ss.length()-1);
				else return false;
				break;
			default:
				return false;
			}
		}
		return ss.length()==0?true:false;
    }
	public static void main(String[] args) {
		System.out.println(isValid("{{{[]{{}}()}}"));
	}

}
