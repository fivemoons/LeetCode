package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q187_RepeatedDNASequences {
	private static int hash(String s){ //一个字符2个bit
		int ans = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			switch (c) {
				case 'A':	ans = ans << 2 | 0;	break;
				case 'C':	ans = ans << 2 | 1;	break;
				case 'G':	ans = ans << 2 | 2;	break;
				case 'T':	ans = ans << 2 | 3;	break;
				default:		break;
			}
		}
		return ans;
	}
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i+9<s.length(); i++){ //依次枚举每10个
        		String temp = s.substring(i, i+10);
        		int hashnum = hash(temp);
        		if (!map.containsKey(hashnum)){ //第一次 加入map
        			map.put(hashnum, 1);
        		}else if (map.get(hashnum) == 1){ //第二次 加入ans 置位第二次
        			ans.add(temp);
        			map.put(hashnum, 2);
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		List<String> ans = findRepeatedDnaSequences("ACCCTCCCACTTGGATGCCGCACGTGTCGACTAACCTTACATTGTCCCCCCACCTCCAGACGGTTAACTCTTGAAATGGGGGAATAGCTGCTTGCGCGTG");
		for(String s: ans){
			System.out.println(s);
		}
	}

}
