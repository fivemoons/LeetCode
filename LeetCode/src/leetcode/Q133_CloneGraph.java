package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q133_CloneGraph {
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	//dfs方法：目的是为了返回这个节点及其关系
	private static UndirectedGraphNode dfs(UndirectedGraphNode old, Map<Integer,UndirectedGraphNode> map){
		if(map.containsKey(old.label)) //如果这个label已经存在
			return map.get(old.label); //直接去map中返回这个label的节点引用
		else{ //如果这个label还没有存在
			UndirectedGraphNode node = new UndirectedGraphNode(old.label); //新建一个节点
			map.put(node.label, node); //把这个点加入到map中
			for(UndirectedGraphNode n:old.neighbors) //迭代old节点的list
				node.neighbors.add(dfs(n,map)); //依次加入到新node节点的list中，而这个list中的节点需要递归生成
			return node;
		}
	}
	//bfs方法：
	private static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node){
		if (node==null) return null;
		Map<UndirectedGraphNode,UndirectedGraphNode> map = 
				new HashMap<UndirectedGraphNode,UndirectedGraphNode>(); //存放每一个node的旧点对应的新点
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>(); //存放那些自己被复制过，但是邻居节点还没复制过的点
		q.add(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while(!q.isEmpty()){
			UndirectedGraphNode now = q.poll();
			for(UndirectedGraphNode nbr:now.neighbors){
				if(!map.containsKey(nbr)){ //如果是一个新点
					map.put(nbr,new UndirectedGraphNode(nbr.label)); //新建一个点加入到map
					q.add(nbr); //新建的点nbr还没有拓展呢
				}
				map.get(now).neighbors.add(map.get(nbr));//增加邻居
			}
		}
		return map.get(node);
	}
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    		if (node==null) return null;
    		Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
    		return dfs(node,map);
    }
	public static void main(String[] args) {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		UndirectedGraphNode ans = cloneGraph(node0);
		ans = cloneGraph2(node0);
		System.out.println(ans.label);
		for(UndirectedGraphNode i:ans.neighbors)
			System.out.println(i.label);
	}

}
