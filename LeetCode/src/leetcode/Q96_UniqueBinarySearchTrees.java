package leetcode;

public class Q96_UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] ans = new int[n+1]; //要计算到n+1
        ans[0] = 1; //0个点有1个
        ans[1] = 1; //1个点有1个
        for(int i=2; i<=n; i++){ //多个点
        		for(int j=0; j<i; j++){ //依次分配左子树
        			ans[i] += ans[j] * ans[i - j - 1]; //j个左子树， i-j-1个右子树，相乘，累加
        		}
        }
        return ans[n];
    }
	public static void main(String[] args) {
		System.out.println(numTrees(9));
	}

}
