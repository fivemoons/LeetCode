package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinationsOfAPhoneNumber {
	
	public static List<String> letterCombinations(String digits) {
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    LinkedList<String> ans = new LinkedList<String>();
	    if (digits.equals("")) return ans;
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = digits.charAt(i) - '0';
	        while(ans.peek().length()==i){//使用队列
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}

	public static void main(String[] args) {
		List<String> list= letterCombinations("34");
		for(String s : list){
			System.out.print(s+"__");
		}
	}

}
