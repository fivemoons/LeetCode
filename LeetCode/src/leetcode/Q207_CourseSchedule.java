package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q207_CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> map = new ArrayList<Set<Integer>>(); //邻接表list
        for(int i=0; i<numCourses; i++){
        		map.add(new HashSet<Integer>()); //邻接表初始化
        }
        int[] InNums = new int[numCourses]; //节点的入度
        for(int i=0; i<prerequisites.length; i++){
        		if(!map.get(prerequisites[i][1]).contains(prerequisites[i][0])){ //已经存在该边
        			map.get(prerequisites[i][1]).add(prerequisites[i][0]); //在1的列表中加上0
        			InNums[prerequisites[i][0]]++; //0的入度+1
        		}
        }
        
        Queue<Integer> queue = new LinkedList<Integer>(); //BFS队列
        for(int i=0; i<numCourses; i++){
        		if(InNums[i] == 0){ //首先将入度为0的点加入队列
        			queue.add(i);
        		}
        }
        
        int count = 0; //多少个节点已经完成了拓扑排序
        while(!queue.isEmpty()){ //当队列不为空
        		int cur = queue.poll(); //出队节点
        		for(int i:map.get(cur)){ //每一个邻接表
        			if(--InNums[i] == 0){ //入度-1
        				queue.add(i); //入度为0后加入队列
        			}
        		}
        		count++; //计算多少个能够从出队，即能删掉多少个点
        }
        System.out.println(count);
        return count == numCourses; //没有环
    }
	public static void main(String[] args) {
		System.out.println(canFinish(10,new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}}));  //1-->0
	}

}
