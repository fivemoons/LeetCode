package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q310_MinimumHeightTrees {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new ArrayList<Integer>(); //存放答案的list，树的重心
		
        if(edges == null || edges.length == 0){ //如果没有边
        		ans.add(0);
        		return ans;
        	}
		
		int[] indegree = new int[n]; //入度
        Map<Integer,Set<Integer>> map = new HashMap<>(); //邻接表
        for(int i=0; i<n; i++){ //初始化map
        		map.put(i, new HashSet<Integer>()); //每个点的邻接表初始化为空
        }
     
        for(int i=0; i<edges.length; i++){
        		indegree[edges[i][0]]++; //入度
        		indegree[edges[i][1]]++; //入度
        		map.get(edges[i][0]).add(edges[i][1]); //边的两边都增加邻接表
        		map.get(edges[i][1]).add(edges[i][0]); //
        }
        
        Queue<Integer> queue = new LinkedList<Integer>(); //遍历队列
        for(int i=0; i<n; i++){ //首先将入度为1的点入队
        		if(indegree[i] == 1) //如果入度是1
        			queue.add(i);
        }
        
        while(!queue.isEmpty()){ //还有点没有删除
        		int size = queue.size(); //这一层树的外层数
        		ans.clear(); //缓存这一层节点
        		for(int i=0; i<size; i++){ //依次出队
        			ans.add(queue.peek()); //出队的依次加入到ans中
        			Set<Integer> set = map.get(queue.poll()); //找到出队的节点的邻接表
        			for(int out:set){ //遍历邻接表
        				indegree[out]-=1; //和它相邻的点入度减一
        				if(indegree[out] == 1){ //如果这个点变成了叶子节点
        					queue.add(out); //加入到队列中
        				}
        			}
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		List<Integer> ans = findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}});
		for(Integer i:ans){
			System.out.println(i);
		}

	}

}
