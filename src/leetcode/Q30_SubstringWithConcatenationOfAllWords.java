package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30_SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<Integer>(); // 返回的答案列表
		Map<String, Integer> map = new HashMap<String, Integer>(); //存储words的个数和使用量
		for (String ss : words) {
			if (map.containsKey(ss)) { //包含这一项
				map.put(ss, map.get(ss) + 1); //把这一项拿出来+1
			} else {
				map.put(ss, 1); //新添加一个words
			}
		}

		Map<String, Integer> mapclone = new HashMap<String, Integer>(); //新建一个mapclone用于备份map
		mapclone.putAll(map); //putall函数可以实现深拷贝

		int len = words[0].length(); //每一个words的长度
		for (int i = 0; i <= s.length() - len * words.length; i++) { //注意长度上界
			String subs = s.substring(i, i + len); //第一个子串
			int count = 0; //用于计数，看是否已经满足条件
			int from = i; //头指针
			while (map.containsKey(subs) && map.get(subs) > 0) { //判断是否包含subs
				map.put(subs, map.get(subs) - 1); //把map中的subs项-1
				count++; //计数+1
				from += len; //from坐标往后+1
				if (from + len > s.length()) break; //如果已经超过了界线 退出循环
				subs = s.substring(from, from + len); //寻找下一个子串
			}
			if (count == words.length){//添加最新的i加入到ans中
				ans.add(i);
			}
			map.clear();//清空map
			map.putAll(mapclone); //从mapclone中拷贝一份到map中重新开始
		}
		return ans;

	}

	public static void main(String[] args) {
		List<Integer> list = findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","good" });
		for (Integer i : list) {
			System.out.println(i);
		}
	}

}
