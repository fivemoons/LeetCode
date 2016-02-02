package leetcode;

public class Q240_SearchA2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
        		return false;
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
        		int x = matrix[i][j];
        		if(x == target)
        			return true;
        		else if(x < target)
        			i++;
        		else
        			j--;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
