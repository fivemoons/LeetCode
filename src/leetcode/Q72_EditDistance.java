package leetcode;

public class Q72_EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] ans = new int[word1.length() + 1][word2.length() + 1];//有n+1个隔板
        for(int i=0; i<=word1.length(); i++){
        		ans[i][0] = i;//有多少字母就要编辑几次
        }
        for(int j=0; j<=word2.length(); j++){
        		ans[0][j] = j;//有多少字母就要编辑几次
        }
        for(int i=1; i<=word1.length(); i++){  //依次遍历每一个字母
        		for(int j=1; j<=word2.length(); j++){
        			if (word1.charAt(i-1) == word2.charAt(j-1)){ //0...n-1
        				ans[i][j] = ans[i-1][j-1]; //ans[i][j]表示A前i个字符和B前j个字符，隔板要+1
        			}else{
        				ans[i][j] = ans[i-1][j-1] + 1; //A[i]或B[j]替换
        				ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);//A[i]删除或B[j]增加
        				ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);//A[i]增加或B[j]删除
        			}
        		}
        }
        return ans[word1.length()][word2.length()];
    }
	public static void main(String[] args) {
		System.out.println(minDistance("", ""));
	}

}
