package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q218_TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {//[1,2,9]
        List<int[]> ans = new ArrayList<>();
        List<int[]> height = new ArrayList<>(); //用于将int[][]转为List<int[]>排序
        for(int[] b:buildings){
        	height.add(new int[]{b[0], -b[2]}); //如果是长方形开头，存负数
        	height.add(new int[]{b[1], b[2]});  //如果是长方形结束，存正数
        }
        Collections.sort(height, new Comparator<int[]>(){
			@Override
			public int compare(int[] x, int[] y) {
				if(x[0] != y[0]){ //如果两个坐标不等
					return x[0] - y[0]; //坐标小的<坐标大的
				}else{ //如果两个坐标相等
					return x[1] - y[1]; //坐标小的<坐标大的
				}
			}
        });
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; //o1<o2 1   o1>o2 -1 大根堆
			}
        });
        
        queue.offer(0); //将地平线加入堆中
        int last = 0; //用于记录上次的高度
        for(int[] h:height){
        	if(h[1] < 0){
        		queue.offer(-h[1]); //将左顶点加入堆中
        	}else{
        		queue.remove(h[1]); //将右顶点对应点移除
        	}
        	int cur = queue.peek();
        	if(last != cur){
        		ans.add(new int[]{h[0],cur});
        		last = cur;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		List<int[]> ans = getSkyline(new int[][]{{2,9,10}, {3,7,15},{5,12,12},{15,20,10},{19,24,8}});
		for(int[] a:ans){
			System.out.println(a[0]+"_"+a[1]);
		}
	}

}
