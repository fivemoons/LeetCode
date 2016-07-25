package leetcode2.hashmap;

public class Q74_SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return false;
        //从右上角往左下角遍历
        int x = 0;
        int y = matrix[0].length-1;
        while ((x<matrix.length) && (y>=0)){
        	if (matrix[x][y] == target) return true;
        	else if(matrix[x][y] < target) x++;
        	else y--;
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(searchMatrix(
				new int[][]{{1},{3}},1));
	}

}
