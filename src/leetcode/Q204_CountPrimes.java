package leetcode;

public class Q204_CountPrimes {
    public static int countPrimes(int n) {
    		if (n<2) return 0;
        boolean[] p = new boolean[n]; //是不是合数
        p[0] = true;
        p[1] = true;
        for(int i=2; i*i<n; i++){
        		if (!p[i])
        			for(int j=i*i; j<n; j+=i){
        				if (j % i == 0)
        					p[j] = true;
        			}
        }
        int ans = 0;
        for(int i=2; i<n; i++)
        		if(!p[i]){
        			ans++;
        		}
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(999983));
	}

}
