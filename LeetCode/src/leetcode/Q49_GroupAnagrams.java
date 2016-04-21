package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q49_GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs){ //加入了hash的方法
		Map<String,List<String>> map = new HashMap<String,List<String>>(); //存放未排序的答案字符串的map key：string的字典序 value：List<String>
		for(String s:strs){		//依次遍历string
			char[] c = s.toCharArray(); //得到当前字符串的字符数组
			Arrays.sort(c); //排序
			String key = new String(c); //转换成字典序的字符串
			List<String> l = map.containsKey(key) ? map.get(key) : new LinkedList<String>(); //如果包含则取出，如果不包含，则新建一个string
			l.add(s); //加入新元素到对应的List中
		}
		List<List<String>> ans = new LinkedList<List<String>>(); //答案的形式
		for(String key : map.keySet()){ //依次遍历key值
			List<String> l2 = map.get(key); //对应的list
			Collections.sort(l2); 
			ans.add(l2); //增加到最终答案中
		}
		return ans;
	}
	public static void main(String[] args) {
		List<List<String>> ans = groupAnagrams(new String[]{
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
