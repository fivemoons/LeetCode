package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q332_ReconstructItinerary {
	public static List<String> findItinerary(String[][] tickets) {
		//初始化邻接表
        int n = tickets.length;
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(int i=0; i<n; i++){
        		map.putIfAbsent(tickets[i][0], new PriorityQueue<String>());
        		map.putIfAbsent(tickets[i][1], new PriorityQueue<String>());
        }
        //创建邻接表
        for(int i=0; i<n; i++){
        		map.get(tickets[i][0]).offer(tickets[i][1]);
        }
        //初始化答案
        List<String> ans = new LinkedList<String>();
        //创建栈
        Deque<String> stack = new LinkedList<String>();
        
        String from = "JFK";
   /* {   
        	for(int k=1; k<=n; k++){ //一共要走n条路
        		while(map.get(from).isEmpty()){//路还没用完，但是已经无路可走
        			stack.push(from); //把路后退，存入到栈中，但是已经是答案的一部分了
            		from = ans.remove(ans.size()-1);//后退路径
        		}
        		ans.add(from);//这个点终于可以往后走了，所以加入到答案中
        		from = map.get(from).poll(); //找下一个点，看他怎么样
        	}
        ans.add(from); //最后一个点加入到其中
        
	}*/
    
        ans.add(from);
        for(int k=1; k<=n; k++){
        		while(map.get(from).isEmpty()){
        			stack.push(ans.remove(ans.size()-1));
        			from = ans.get(ans.size()-1);
        		}
        		from = map.get(from).poll();
        		ans.add(from);
        }
        
        
        while(!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }
	public static void main(String[] args) {
		List<String> ans = findItinerary(
				new String[][]{{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},
							   {"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},
							   {"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},
							   {"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},
							   {"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},
							   {"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},
							   {"EZE","ANU"},{"AUA","ANU"}});
		for(String s : ans){
			System.out.println(s);
		}
	}

}
