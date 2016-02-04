package leetcode;

public class Q289_GameOfLife {
	private static int getNext(int[][] board, int x, int y){
		int c = 0;
		for(int i=x-1; i<=x+1; i++){
			for(int j=y-1; j<=y+1; j++){
				if(i==x && j==y) continue;
				if(i<0 || j<0 || i>=board.length || j>=board[0].length) continue;
				if(board[i][j]%10==1)
					c++;
			}
		}
		return c;
	}
	public static void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
        		for(int j=0; j<n; j++){
        			int c = getNext(board,i,j);
        			if(board[i][j] == 1){
        				if (c==2 || c==3)
        					board[i][j] += 10;
        			}else{
        				if (c==3)
        					board[i][j] += 10;
        			}
        		}
        }
        for(int i=0; i<m; i++){
        		for(int j=0; j<n; j++){
        			board[i][j] /= 10;
        		}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
