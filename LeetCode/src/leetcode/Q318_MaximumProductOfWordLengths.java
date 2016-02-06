package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q318_MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String s : words){
        		int hash = 0;
        		for(int i=0; i<s.length(); i++){
        			hash |= 1<<(s.charAt(i) - 'a');
        		}
        		map.put(s, hash);
        }
        int ans = 0;
        for(int i=0; i<words.length-1; i++){
        		for(int j=i+1; j<words.length; j++){
        			int hash1 = map.get(words[i]);
        			int hash2 = map.get(words[j]);
        			if((hash1 & hash2) == 0){
        				ans = Math.max(ans, words[i].length() * words[j].length());
        			}
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
