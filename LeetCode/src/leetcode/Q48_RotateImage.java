package leetcode;

public class Q48_RotateImage {
    public static void rotate(int[][] matrix) {
        for(int i=0; i < (matrix.length + 1) >> 1; i++){
        		for(int j=0; j < matrix.length >> 1; j++){
        			int n = matrix.length - 1;
        			int temp = matrix[i][j];
        			matrix[i][j] = matrix[n-j][i];
        			matrix[n-j][i] = matrix[n-i][n-j];
        			matrix[n-i][n-j] = matrix[j][n-i];
        			matrix[j][n-i] = temp;
        		}
        }
    }
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int[] i:matrix){
			for(int j:i){
				System.out.print(j + "_");
			}
			System.out.println();
		}
	}

}
