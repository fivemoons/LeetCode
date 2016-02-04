package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295_FindMedianFromDataStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {//默认顺序为小根堆
			return o1-o2;
		}
	});
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {//比较器 设为大根堆
			return o2-o1;
		}
	});
	
    // Adds a number into the data structure.
	//大根堆在前，小根堆在后
    public void addNum(int num) {
    		if (maxHeap.size() == 0) //为避免空堆，加入左堆
    			maxHeap.add(num);
    		else if(num < maxHeap.peek()) //比左堆小，加入左堆
    			maxHeap.add(num);
    		else
    			minHeap.add(num); //否则一律加入右堆
        if(maxHeap.size() + 1 < minHeap.size()) //需要向左方平衡
        		maxHeap.add(minHeap.poll());
        if(maxHeap.size() > minHeap.size() + 1) //需要向右方平衡
        		minHeap.add(maxHeap.poll());
    }
    // Returns the median of current data stream
    public double findMedian() {
        int hmax = maxHeap.size();
        int hmin = minHeap.size();
        if(hmax == 0 && hmin == 0){//两个都为空则返回0
        		return 0d;
        }else if(hmax > hmin){ //返回多的那一个堆的堆顶元素
        		return maxHeap.peek();
        }else if(hmax < hmin){
        		return minHeap.peek();
        }else//两个都不为空且相等 返回均值
        		return ((double) (minHeap.peek()+maxHeap.peek()))/2.0;
    }
	public static void main(String[] args) {

	}

}
