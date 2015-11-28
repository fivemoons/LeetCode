package leetcode;

public class Q87_ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        //if (len == 0) return true;
        boolean[][][] bool = new boolean[len][len][len];
        for(int i=0; i<len; i++){
        		for(int j=0; j<len; j++){
        			bool[0][i][j] = (s1.charAt(i) == s2.charAt(j)); //当前字符串，i,i+0
        		}
        }
        for(int k=1; k<len; k++){ //是当前字符串的长度是 i,i+k
        		for(int i=0; i<len-k; i++){ //保证i+k不越界
        			for(int j=0; j<len-k; j++){ //保证j+k不越界
        				//本次计算bool[k][i][j] 默认是false;
        				for(int m=0; m<k && !bool[k][i][j]; m++){ //m枚举每次分隔的情况,直到结果有true或完成
        					bool[k][i][j] = ((bool[m][i][j] && bool[k-m-1][i+m+1][j+m+1])//注意：下标，非常难，画图
        								 || (bool[m][i][j+k-m] && bool[k-m-1][i+m+1][j]));
        					//System.out.println(k+"_"+i+'_'+j+"_"+m+'_'+bool[k][i][j]);
        				}
        			}
        		}
        }
        return bool[len-1][0][0];
    }
	public static void main(String[] args) {
		System.out.println(isScramble("great","eatgr"));
	}

}
