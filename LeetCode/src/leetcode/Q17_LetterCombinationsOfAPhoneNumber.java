package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17_LetterCombinationsOfAPhoneNumber {
	private static List<String> ans = new ArrayList<String>();

	public static List<String> letterCombinations(String digits) {
		letter(digits, 0, new StringBuffer());
		return ans;
	}

	private static void letter(String digits, int n,StringBuffer now) {
		if (n>=digits.length()){
			if (now.length()>0)
					ans.add(now.toString());
			return;
		}
		switch (digits.charAt(n)) {
		case '2':
			letter(digits, n+1, now.append("a")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("b")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("c")); now.deleteCharAt(n);
			break;
		case '3':
			letter(digits, n+1, now.append("d")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("e")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("f")); now.deleteCharAt(n);
			break;
		case '4':
			letter(digits, n+1, now.append("g")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("h")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("i")); now.deleteCharAt(n);
			break;
		case '5':
			letter(digits, n+1, now.append("j")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("k")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("l")); now.deleteCharAt(n);
			break;
		case '6':
			letter(digits, n+1, now.append("m")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("n")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("o")); now.deleteCharAt(n);
			break;
		case '7':
			letter(digits, n+1, now.append("p")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("q")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("r")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("s")); now.deleteCharAt(n);
			break;
		case '8':
			letter(digits, n+1, now.append("t")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("u")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("v")); now.deleteCharAt(n);
			break;
		case '9':
			letter(digits, n+1, now.append("w")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("x")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("y")); now.deleteCharAt(n);
			letter(digits, n+1, now.append("z")); now.deleteCharAt(n);
			break;
		case '0':
			letter(digits, n+1, now.append(" ")); now.deleteCharAt(n);
			break;
		case '*':
			letter(digits, n+1, now.append("*")); now.deleteCharAt(n);
			break;
		case '#':
			letter(digits, n+1, now.append("#")); now.deleteCharAt(n);
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		List<String> list= letterCombinations("3");
		for(String s : list){
			System.out.print(s+"____");
		}
	}

}
