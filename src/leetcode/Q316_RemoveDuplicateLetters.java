package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q316_RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {
        Map<Character,Integer> freqs = new HashMap<>(); //为了统计字符数个数
        for(int i=0; i<s.length(); i++){
        		char c = s.charAt(i);
        		freqs.put(c, freqs.containsKey(c) ? freqs.get(c) + 1 : 1);
        }
        Set<Character> instack = new HashSet<Character>(); //哪些字符在栈中
        
        Deque<Character> q = new ArrayDeque<Character>(); //栈
        for(int i=0; i<s.length(); i++){
        		char c = s.charAt(i);
        		freqs.put(c, freqs.get(c) - 1); //当前字符个数-1
        		if(!instack.contains(c)){ //当前字符不在栈中
        			while(!q.isEmpty() && q.peek() > c && freqs.get(q.peek()) > 0){//把栈顶大的元素并且多余的都去掉
        				instack.remove(q.pop()); //出栈 标记为不在栈中
        			}
        			q.push(c); //字符入栈
        			instack.add(c); //标记为在栈中
        		}
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) sb.append(q.pop());
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));

	}

}
