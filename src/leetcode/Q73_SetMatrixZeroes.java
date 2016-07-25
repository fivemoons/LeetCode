package leetcode;

public class Q73_SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {//O(1)空间复杂度
    	int m = matrix.length; //行数
    	int n = matrix[0].length;//列数
    	
    	boolean firstm = false; //第一列是否有0
    	boolean firstn = false; //第一行是否有0
    	for(int i=0; i<m; i++){ //寻找第一列
    		if (matrix[i][0] == 0){
    			firstm = true;
    		}
    	}
    	for(int j=0; j<n; j++){ //寻找第一行
    		if (matrix[0][j] == 0){
    			firstn = true;
    		}
    	}
    	for(int i=0; i<m; i++){ //使用第一行和第一列来存放当前行或列的0值
    		for(int j=0; j<n; j++){
    			if (matrix[i][j] == 0){
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}
    	
    	for(int i=1; i<m; i++){ //注意：循环变量从1开始 ，如果当前行和列的首位是0，则当前位置设为0
    		for(int j=1; j<n; j++){
    			if((matrix[i][0] == 0) || (matrix[0][j] == 0)) matrix[i][j] = 0;
    		}
    	}
    	if(firstm){ //处理第一列
        	for(int i=0; i<m; i++){
   				matrix[i][0] = 0;
        	}
    	}
    	if(firstn){ //处理第一行
        	for(int j=0; j<n; j++){
   				matrix[0][j] = 0;
        	}
    	}

    }
	public static void main(String[] args) {
		int[][] ans = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans[0].length; j++){
				System.out.print(ans[i][j]+"_");
			}
			System.out.println();
		}
		System.out.println();
		setZeroes(ans);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans[0].length; j++){
				System.out.print(ans[i][j]+"_");
			}
			System.out.println();
		}
	}

}
