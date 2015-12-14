package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q127_WordLadder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    		wordList.add(endWord); //原始Set
    		Queue<String> strQueue = new LinkedList<String>(); //BFS遍历的队列
        Map<String,Integer> map = new HashMap<String,Integer>(); //每个使用过的单词的step
        strQueue.add(beginWord);//首节点加入到BFS队列中
        map.put(beginWord, 1);//首节点1步
        while(!strQueue.isEmpty()){//如果BFS未完成
        		StringBuffer str = new StringBuffer(strQueue.poll());//找出接下来要拓展的String
        		int step = map.get(str.toString()); //找出当前的步数
        		for(int i=0; i<str.length(); i++){//依次枚举每一位字符
        			char oldc = str.charAt(i);//原来的字符
        			for(char c='a'; c<='z'; c++){//替换每一个
        				if (oldc!=c){//如果不是原来的字符
        					str.setCharAt(i, c);//替换一个字符
        					if (wordList.contains(str.toString())){//如果还没有用到这个字符
        						String strnext = str.toString();//生成下一个string
        						strQueue.add(strnext); //增加进入队列
        						wordList.remove(strnext); //从set中移除string
        						map.put(strnext, step + 1); //增加步数
        						if(strnext.equals(endWord)) //找到答案
        							return step+1;
        					}
        				}
        			}
				str.setCharAt(i, oldc);
        		}
        }
        return 0;
    }
	public static void main(String[] args) {
		Set<String> wordList = new HashSet<String>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		System.out.println(ladderLength("a","c",wordList));
	}

}
