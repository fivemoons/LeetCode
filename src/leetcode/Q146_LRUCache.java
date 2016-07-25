package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q146_LRUCache {
    //继承内部类方式
	private Map<Integer, Integer> map;
    @SuppressWarnings("serial")
	public Q146_LRUCache(int capacity) {
    		//Collections.synchronizedMap(map) 产生线程安全map
        map = new LinkedHashMap<Integer, Integer>(  (int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true  ){
        		@Override
    			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        			return size() > capacity;
        		}
        };
    }
    
    //委托者方式
    @SuppressWarnings("unused")
	private LinkedHashMap<Integer, Integer> map2 = null;
    @SuppressWarnings("serial")
	public void Q146_LRUCache2(int capacity) {
    		map2 = new LinkedHashMap<Integer, Integer>(  (int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true  ){
    			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
    			return size() > capacity;
    			}
    		};
    }
    
    //linkedHashMap的FIFO实现
    public int get(int key) {
    		if(map.containsKey(key))
    			return map.get(key);
    		else
    			return -1;
    }
    
    public void set(int key, int value) {
    		map.put(key, value);
    }
	public static void main(String[] args) {
	}

}
