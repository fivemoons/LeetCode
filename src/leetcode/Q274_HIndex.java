package leetcode;

public class Q274_HIndex {
	public static int hIndex(int[] citations) {
		int n = citations.length; //H值肯定小于等于最高引用量，也小于等于文章总数
        int[] count = new int[n + 1];//0~citations.length
        for(int i=0; i<n; i++) count[Math.min(citations[i], n)]++;
        int ans = 0;
        for(int i=n; i>=0; i--){
        		ans += count[i];//大于等于i个引用量的文章有多少个
        		if(ans >= i) //个数已经大于等于引用量
        			return i;//返回的是引用量，引用量是不连续的，文章数目是连续的
        }
        return 0;
    }
	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{3,0,6,1,5}));
	}

}
