package leetcode;

public class Q79_WordSearch {
	private static void copy(boolean[][] b1,boolean[][] b2){ //注意：拷贝二维数组，clone()和Arrays.fill()均不可以
		for(int i=0; i<b1.length; i++){
			for(int j=0; j<b1[0].length; j++){
				b2[i][j] = b1[i][j];
			}
		}
	}
	private static boolean find(char[][] board, boolean[][] used, String word, int f, int x, int y){
		//System.out.println(x+"_"+y+"_"+board[x][y]+"_"+f+"ZZZ");
		if (word.length() <= f) return true; //终止条件，字符串全部找到
		used[x][y] = true; //该坐标设为使用
		if ((x>0) 				  && (board[x-1][y] == word.charAt(f)) && (!used[x-1][y])){ //如果往上走
			if (find(board,used,word,f + 1,x-1,y)) //判断是否可以
				return true;
			else
				used[x-1][y] = false; //恢复原状
		}
		if ((x<board.length-1) 	  && (board[x+1][y] == word.charAt(f)) && (!used[x+1][y])){
			if (find(board,used,word,f + 1,x+1,y))
				return true;
			else
				used[x+1][y] = false;
		}		
		if ((y>0)				  && (board[x][y-1] == word.charAt(f)) && (!used[x][y-1])){
			if (find(board,used,word,f + 1,x,y-1))
				return true;
			else
				used[x][y-1] = false;
		}
		if ((y<board[0].length-1) && (board[x][y+1] == word.charAt(f)) && (!used[x][y+1])){
			if (find(board,used,word,f + 1,x,y+1))
				return true;
			else
				used[x][y+1] = false;
		}
		return false; //反正已经不可以了，used[x][y]不用恢复，直接被清零
	}
    public static boolean exist(char[][] board, String word) {
    		if (word.length() == 0) return true;
    		boolean[][] used = new boolean[board.length][board[0].length]; //存储目前用到的元素
    		boolean[][] usefalse = new boolean[board.length][board[0].length]; //存储全false的数组
        for(int i=0; i<board.length; i++){
        		for(int j=0; j<board[0].length; j++){
        			if (board[i][j] ==  word.charAt(0)){ //每次找到起始点
        				copy(usefalse,used); //用到的元素全部设为false
        				if (find(board,used,word,1,i,j)) //能否找到
        					return true;
        			}
        		}
        }
        return false;
    }
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}
		};
		System.out.println(exist(board,"ABCESEEEFS"));
	}

}
