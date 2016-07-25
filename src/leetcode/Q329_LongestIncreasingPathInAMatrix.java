package leetcode;

public class Q329_LongestIncreasingPathInAMatrix {
	public static int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] indegree = new int[m][n];
		int[][] indegree2 = new int[m][n];
		//构造入度矩阵
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i-1>=0 && matrix[i-1][j] < matrix[i][j]) indegree[i][j]++;
				if(j-1>=0 && matrix[i][j-1] < matrix[i][j]) indegree[i][j]++;
				if(i+1<m  && matrix[i+1][j] < matrix[i][j]) indegree[i][j]++;
				if(j+1<n  && matrix[i][j+1] < matrix[i][j]) indegree[i][j]++;
			}
		}
		//拓扑排序
		boolean end = true;//默认能结束
		int ans = 0;
		do{                         
			end = true;
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++)
					indegree2[i][j] = indegree[i][j];
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(indegree[i][j] == 0){//删这个入度为0的点
						end = false;
						indegree2[i][j] = -1;  
						if(i-1>=0 && matrix[i-1][j] > matrix[i][j] && indegree[i-1][j]!=-1) indegree2[i-1][j]--;
						if(j-1>=0 && matrix[i][j-1] > matrix[i][j] && indegree[i][j-1]!=-1) indegree2[i][j-1]--;
						if(i+1<m  && matrix[i+1][j] > matrix[i][j] && indegree[i+1][j]!=-1) indegree2[i+1][j]--;
						if(j+1<n  && matrix[i][j+1] > matrix[i][j] && indegree[i][j+1]!=-1) indegree2[i][j+1]--;
					}
				}
			}
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++)
					indegree[i][j] = indegree2[i][j];
			if(!end) ans++;
		}while(!end);
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
	}

}
