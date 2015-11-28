package leetcode;

import java.util.Stack;

public class Q85_MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
    		if (matrix.length == 0) return 0;
        int[][] mat = new int[matrix.length][matrix[0].length];
		Stack<Integer> s = new Stack<Integer>();       
		int ans = 0;
        for(int i=0; i<matrix.length; i++){
        		for(int j=0; j<matrix[0].length; j++){
        			if (matrix[i][j] == '1')
        				mat[i][j] = (i>0 ? mat[i-1][j] + 1 : 1);
        			else
        				mat[i][j] = 0;
        		}
        		s.clear();
        		int k = 0;
        		while(k<=matrix[0].length){
        			int now = (k == matrix[0].length ? 0: mat[i][k]); //now是当前点的值
        			if (s.empty() || mat[i][s.peek()] <= now){ //栈顶元素的值
        				s.push(k++); //追加进栈
        			}else{
        				int tmp = s.pop(); //返回的是最高点的下标
        				ans = Math.max(ans, mat[i][tmp] * (s.empty() ? k : k - s.peek() - 1));
        			}
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'1'}};
		System.out.println(maximalRectangle(matrix));
	}

}
