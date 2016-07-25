package leetcode;

public class Q304_RangeSumQuery2DImmutable {
    public Q304_RangeSumQuery2DImmutable(int[][] matrix) {
    		if(matrix == null || matrix.length == 0) return;
        sums = matrix.clone();
        int m = sums.length;
        int n = sums[0].length;
        for(int i=1; i<m; i++)
        		sums[i][0] += sums[i-1][0];
        for(int j=1; j<n; j++)
        		sums[0][j] += sums[0][j-1];
        for(int i=1; i<m; i++){
        		for(int j=1; j<n; j++){
        			sums[i][j] += sums[i][j-1] - sums[i-1][j-1] + sums[i-1][j];
        		}
        }
    }
    private int[][] sums;
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int num1 = (row1==0 || col1==0) ? 0 : sums[row1-1][col1-1];
        int num2 = (row1 == 0) ? 0 : sums[row1-1][col2];
        int num3 = (col1 == 0) ? 0 : sums[row2][col1-1];
        int num4 = sums[row2][col2];
        return num4 - num3 - num2 + num1;
    }
	public static void main(String[] args) {
		Q304_RangeSumQuery2DImmutable q = new Q304_RangeSumQuery2DImmutable(new int[][]
												{{3,0,1,4,2},
												 {5,6,3,2,1},
												 {1,2,0,1,5},
												 {4,1,0,1,7},
												 {1,0,3,0,5}});
		System.out.println(q.sumRegion(2, 1, 4, 3));
		System.out.println(q.sumRegion(1, 1, 2, 2));
		System.out.println(q.sumRegion(1, 2, 2, 4));
	}

}
