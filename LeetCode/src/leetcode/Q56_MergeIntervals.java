package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q56_MergeIntervals {
	static class Interval {
		int start;
		int end;
		public Interval() { start = 0; end = 0; }
	    public Interval(int s, int e) { start = s; end = e; }
	}

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0) return intervals; //空list的情况
		Collections.sort(intervals, new Comparator<Interval>(){ //比较函数 匿名内部类，实现接口
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start; //< -1 > 1 = 0
			}});
		List<Interval> ans = new LinkedList<Interval>(); //新建ans
		Interval l1 = intervals.get(0); //初始区间
		for (int i=1; i < intervals.size(); i++){ 
			Interval l2 = intervals.get(i); //依次拿出区间
			if (l1.end < l2.start){ //如果没有重叠
				ans.add(l1); //将前一个区间加入ans
				l1 = l2; //当前区间 变为 前一个区间
			}else{ //有重叠的区间
				l1 = new Interval(l1.start, Math.max(l1.end, l2.end)); //新建一个合并区间
			}
		}
		ans.add(l1); //别忘将最后一个区间加入到ans中
        return ans;
    }
	public static void main(String[] args) {
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		intervals = merge(intervals);
		for(Interval interval:intervals){
			System.out.println(interval.start+"_"+interval.end);
		}
	}

}
