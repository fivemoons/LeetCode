package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	}
public class Q57_InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0){
    			intervals.add(newInterval);
    			return intervals;
		}
		ListIterator<Interval> it = intervals.listIterator();
		while(it.hasNext()){
			Interval now = it.next(); //返回it后面的元素，并且后移一位
			if (newInterval.end < now.start){ //如果新区间正好卡在两个区间中间
				it.previous(); //返回前一个区间
				it.add(newInterval); //增加一个元素
				return intervals; //任务完成，返回答案
			}else if(newInterval.start <= now.end){ //如果有区间重叠
				newInterval.start = Math.min(newInterval.start, now.start); //左取最小值
				newInterval.end = Math.max(newInterval.end, now.end); //右取最大值
				it.remove(); //it这个点已经没有用了，拿着新区间和别人比较
			}
		}
		intervals.add(newInterval); //第二种情况
		return intervals;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(5,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(11,13));
		intervals = insert(intervals, new Interval(3,8));
		for(Interval interval:intervals){
			System.out.println(interval.start+"_"+interval.end);
		}
	}

}
