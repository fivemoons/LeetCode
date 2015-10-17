package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q49_GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs){ //超时算法，原因在于key每次都要排序比较，应该改用hash
        List<List<String>> ans = new LinkedList<List<String>>(); //存放答案
        for(String s:strs){ //遍历输入的字符串
            boolean flag = false; //标记是否找到相关string
            char[] c2 = s.toCharArray(); //当前的字符串数组
        		Arrays.sort(c2); //排序
        		for(List<String> l1:ans){ //枚举答案中已经存在的list
        			char[] c1 = l1.get(0).toCharArray(); //list中首元素的字符串数组
        			Arrays.sort(c1); //排序
        			if (Arrays.equals(c1, c2)){ //判断是否相等
        				for(int i=0; i<l1.size(); i++){ //如果相等，依次遍历list，寻找要插入的位置
        					if (s.compareTo(l1.get(i))<0){ //寻找到了位置
                    			l1.add(i, s); //插入新字符串
                    			flag = true; //标记设为true，说明找到了
        						break; //跳出该循坏
        					}
        				}
        				if (!flag){  //如果还没有找到，说明在list末尾
        					l1.add(s); //添加到list后面
        					flag = true; //设为true
        				}
        			}
        		}
        		if (!flag){ //如果没有相关list
        			List<String> newList = new LinkedList<String>(); //新建一个list
        			newList.add(s); //增加string
        			ans.add(newList); //加入到答案中
        		}
        }
        return ans;
    }
	public static List<List<String>> groupAnagrams2(String[] strs){ //加入了hash的方法
		Map<String,List<String>> map = new HashMap<String,List<String>>(); //存放未排序的答案字符串的map key：string的字典序 value：List<String>
		for(String s:strs){		//依次遍历string
			char[] c = s.toCharArray(); //得到当前字符串的字符数组
			Arrays.sort(c); //排序
			String key = new String(c); //转换成字典序的字符串
			List<String> l = map.containsKey(key) ? map.get(key) : new LinkedList<String>(); //如果包含则取出，如果不包含，则新建一个string
			l.add(s); //加入新元素到对应的List中
			map.put(key, l); //更新map，其实key存在map中时不用更新，list就在map中，新建list的情况需要map
		}
		List<List<String>> ans = new LinkedList<List<String>>(); //答案的形式
		for(String key : map.keySet()){ //依次遍历key值
			List<String> l2 = map.get(key); //对应的list
			Collections.sort(l2); //注意：collections.sort可以给 collection集合排序 
			ans.add(l2); //增加到最终答案中
		}
		return ans;
	}
	public static void main(String[] args) {
		List<List<String>> ans = groupAnagrams(new String[]{
				"eat", "tea", "tan", "ate", "nat", "bat"
		});
		ans = groupAnagrams2(new String[]{
				"eat", "tea", "tan", "ate", "nat", "bat"
		});
		for(List<String> l1: ans){
			for(String s1:l1){
				System.out.print(s1+"_");
			}
			System.out.println();
		}
	}
}
