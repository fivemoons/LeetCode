package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q126_WordLadderII {
	private class WordAttr{ //map的value值 这个点的属性
		int step;
		List<List<String>> path;
		void addPath(List<List<String>> path){ //增加方案的方法
			this.path.addAll(path);
		}
		WordAttr(int step, List<List<String>> path){ //构造方法
			this.step = step;
			this.path = path;
		}
	}
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	Queue<String> strQueue = new LinkedList<String>(); //BFS遍历的队列
        Map<String,WordAttr> map = new HashMap<String,WordAttr>(); //用来存放每个word及其step path
        
        strQueue.add(beginWord);//首节点加入到BFS队列中
        WordAttr beginWordAttr = new WordAttr(1, new LinkedList<List<String>>());//这是首节点的属性
        List<String> beginPath = new LinkedList<String>();//首节点的path
        beginPath.add(beginWord); //path增加自己
        beginWordAttr.path.add(beginPath); //把唯一的路径增加到path中
        map.put(beginWord, beginWordAttr);//构造出了第一个节点，放到map中
        
        wordList.add(endWord); //最后一个单词加入到原始Set
		
        while(!strQueue.isEmpty()){//如果BFS未完成
        		String curStr = strQueue.poll(); //拿出需要变换的字符串
        		if (curStr.equals(endWord)) //如果当前字符串是endWord
        			return map.get(curStr).path; //则返回最后的答案
        		wordList.remove(curStr);//注意：在这里remove，说明这个单词的最有步骤的所有情况已经枚举完成
        		StringBuffer sb = new StringBuffer(curStr);//找出接下来要拓展的String

        		for(int i=0; i<sb.length(); i++){//依次枚举每一位字符
        			char oldc = sb.charAt(i);//原来的字符
        			for(char c='a'; c<='z'; c++){//替换每一个
        				if (oldc!=c){//如果不是原来的字符
        					sb.setCharAt(i, c);//替换一个字符
        					
    						//生成下一个点的string
    						String nextStr = sb.toString();
        					if ( ( wordList.contains(nextStr) && (!map.containsKey(nextStr)) ) ||
        						 ( map.containsKey(nextStr)   && (map.get(curStr).step + 1 == map.get(nextStr).step) )
        						){//说明这个单词的这一步骤的所有可能还没有枚举完
        						
        						//生成下一个点的path
        						List<List<String>> curPath = map.get(curStr).path; //拿出原来的那个path
        						List<List<String>> nextPath = new LinkedList<List<String>>(); //新建一组下一步路径
        						for(List<String> list:curPath){ //深拷贝
        							nextPath.add(new LinkedList<String>(list));
        						}
        						for(List<String> list:nextPath){ //每一组路径后面加上新字符串
        							list.add(nextStr);
        						}
        						//生成下一个点的wordAttr
        						if (!map.containsKey(nextStr)){ //说明是一个新word
        							strQueue.add(nextStr); //只有这个点从来没有进过队列才进队，这样防止出现多重更新
        							map.put(nextStr, new WordAttr(map.get(curStr).step + 1, nextPath));//新建一个map点
        						}else
        							map.get(nextStr).addPath(nextPath);//字符串已经存在，只追加新路径
        						
        					}
        				}
        			}
				sb.setCharAt(i, oldc);//恢复为原来的字符，枚举下一位的字符
        		} //end bfs
        }
        return new LinkedList<List<String>>(); //没有找到答案，返回空
    }
	public static void main(String[] args) {
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		List<List<String>> ans = new LinkedList<List<String>>();
		ans = new Q126_WordLadderII().findLadders("hit","cog",wordList);
		System.out.println();
		for(List<String> list : ans){
			for(String s:list){
				System.out.print(s+"_");
			}
			System.out.println();
		}
	}

}
