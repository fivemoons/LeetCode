package leetcode;

public class Q278_FirstBadVersion {
	private static boolean isBadVersion(int i){
		if (i>=2) return true;
		return false;
	}
    public static int firstBadVersion(int n) {
        int l = 2, r = n;
        while(l<=r){
        		int m = l + (r - l)/2;
        		System.out.println(m);
        		if(isBadVersion(m) && (!isBadVersion(m-1))) return m;
        		else if(isBadVersion(m) && isBadVersion(m-1)) r = m - 1;
        		else l = m + 1;
        }
        return 1;
    }
	public static void main(String[] args) {
		System.out.println(firstBadVersion(4));
	}

}
