package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30_SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>(); //返回的答案列表
        Map<String,Integer> map = new HashMap<String,Integer>(); //
        for (String ss : words){
        	if (map.containsKey(ss)){
        		map.put(ss, map.get(ss) + 1);
        	}else{
        		map.put(ss, 1);
        	}
        }
        
        Map<String,Integer> mapclone = new HashMap<String,Integer>();
        mapclone.putAll(map);
        
        int len = words[0].length();
        for (int i=0; i<=s.length()-len * words.length; i++){
        	String subs = s.substring(i,i + len);
        	int count = 0;
        	int from = i;
        	while (map.containsKey(subs) && map.get(subs) > 0){
        		map.put(subs, map.get(subs) - 1);
        		count++;
        		
        	}
        }
        
        return ans;
        
    }
	public static void main(String[] args) {
		List<Integer> list = findSubstring("barfoothefoobarman",new String[]{"foo", "bar"});
		for(Integer i:list){
			System.out.println(i);
		}
	}

}
