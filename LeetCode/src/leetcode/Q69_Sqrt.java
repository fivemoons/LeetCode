package leetcode;

public class Q69_Sqrt {
	public static int mySqrt(int x) {
		if (x<2) return x; //防止出现div zero错误
        int l = 1; //左 避开0
        int r = x/2; //右
        int last = 0; //非整除情况
        while(l <= r){
        		int mid = (l + r) / 2; //二分
        		if (x / mid == mid)
        			return mid;
        		else if (x / mid < mid)
        			r = mid - 1;
        		else{ //当x / mid > mid 时 可能是mid多一点，但也要返回mid，所以要记住mid
        			l = mid + 1;
        			last = mid;
        		}
        }
        return last; //没有能整除
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(2));
	}

}
