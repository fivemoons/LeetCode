package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q149_MaxPointsOnALine {
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	public static int maxPoints(Point[] points) {
		int ans = 0; //最后的答案
        Map<Double, Integer> map = new HashMap<Double, Integer>(); //每个点的斜率有多少个
        for(int i=0; i<points.length; i++){
        		map.clear(); //每个新点都清空
        		int samenum = 1; //自己在线上，初始为1
        		for(int j=0; j<points.length; j++){ //依次遍历不是自己的点
        			if(i==j) continue;
        			Double k = 0.0; //斜率
        			if((points[i].x == points[j].x) && (points[i].y == points[j].y)){
        				samenum +=1; //相同的点
        				continue;
        			}else if(points[i].x == points[j].x){
        				k = (double) Integer.MAX_VALUE; //注意：斜率为无穷大
        			}else{ //计算斜率
        				k = (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
        			}
        			map.put(k, map.containsKey(k)? map.get(k) + 1 : 1); //将斜率更新
        		}
        		
        		if(map.keySet().size() == 0){ //都在一个点上
        			ans = Math.max(ans, samenum);
        		}else{
        			for(Double key:map.keySet()){ //不都在一个点上
        				ans = Math.max(ans, map.get(key) + samenum);
        			}
        		}
        }
        return ans;
    }

	public static void main(String[] args) {
		
	}

}
