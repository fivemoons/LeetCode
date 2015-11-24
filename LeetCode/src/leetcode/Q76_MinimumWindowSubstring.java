package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q76_MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();//还有多少字母
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();//已经发现多少字母
        
        for(int i=0; i<t.length(); i++){
        		char c = t.charAt(i);
        		if (map1.containsKey(c)){
        			map1.put(c, map1.get(c) + 1);
        		}else{
        			map1.put(c, 1);
        		}
        		map2.put(c, 0);
        }
        
        int l = 0;
        int count = 0;
        String ans = ""; //没有找到答案的情况下的默认返回
        for(int r = 0; r<s.length(); r++){
        		char c = s.charAt(r);
        		if (map1.containsKey(c)){
        			map2.put(c, map2.get(c) + 1); //对于某个字符c，map2中存放的可能比map1中多
        			if (map1.get(c) >= map2.get(c)){ //这个字符不是多出来的字符，而是关键字符。
        				count++;
        			}
            		if (count == t.length()){ //如果关键字符的长度已经达到t的长度了
            			char f = s.charAt(l);
            			while( (!map1.containsKey(f)) || (map1.get(f) < map2.get(f)) ){ //不是关键字符：没有包含在map1中或者map2中字符足够
            				if (map2.containsKey(f)){ //如果是上式中第二种情况，则从map2中把这个字符删除一个。
            					map2.put(f, map2.get(f) - 1);
            				}
            				f = s.charAt(++l);
            			}//直到把头部多余字符全部拿走了
            			if ((ans.length() == 0) || (r - l + 1 < ans.length())){ //ans.length()是为了让初始答案能够更新
            				ans = s.substring(l, r + 1);//包括首，不包括尾
            			}
            		}//end if 计数达到标准
        		}//end if s中的字符有可能是关键字符
        }//end for 尾指针r往后走
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(minWindow("a","aa"));
	}

}
