package leetcode;

public class Q275_HIndexII {
	public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while(l<=r){
        		int mid = (l+r)/2;
        		if(citations[mid] == n - mid) return n - mid; //最好的情况 引文数和高引文数量相同
        		else if(citations[mid] < n - mid) l = mid + 1; //引文低，右移
        		else r = mid - 1; //引文高，左移
        }
        return n - l; //引文数比高引文数量高
    }
	public static void main(String[] args) {

	}

}
