package leetcode;

import java.util.Iterator;

public class Q284_PeekingIterator {
	class PeekingIterator implements Iterator<Integer> {//这个题的难点在与 next不能重来，所有要缓存
		Iterator<Integer> itr;
		boolean peeked;
		int peekVal;
		
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    this.itr = iterator;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        if(peeked){
	        		return peekVal;
	        }else{
	        		peeked = true;
	        		peekVal = itr.next();
	        }
	        return peekVal;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    if(peeked){
		    		peeked = false;
		    		return peekVal;
		    }else
		    		return itr.next();
		}

		@Override
		public boolean hasNext() {
			return peeked || itr.hasNext();
		}
	}
	public static void main(String[] args) {
	}

}
