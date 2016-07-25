package leetcode;

public class Q74_SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int f = 0; //第一行
        int e = matrix.length - 1; //最后一行
        int l = 0; //最左一列
        int r = matrix[0].length - 1;  //最右一列
        while (f <= e){ //寻找所在行
        		if (f == e) break; //找到了
        		else{
        			int m = (f + e) >> 1; //中值
        			if (matrix[m][matrix[0].length - 1] < target) //在所在行之后
        				f = m + 1;
        			else if(target < matrix[m][0]) //在所在行之前
        				e = m - 1;
        			else{ //就在所在行，找到啦，下一循环break
        				f = m;
        				e = m;
        			}
        		}
        }
        if (f != e) return false; //没有找到所在行
        
        while (l <= r){ //在所在行中寻找 二分查找
        		int m = (l + r) >> 1;
        		if (matrix[f][m] == target)
        			return true;
        		else{
        			if (matrix[f][m] < target)
        				l = m + 1;
        			else if(target < matrix[f][m])
        				r = m - 1;
        		}
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(searchMatrix(
				new int[][]{{1},{3}},1));
	}

}
