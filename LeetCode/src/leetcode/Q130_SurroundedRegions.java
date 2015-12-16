package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q130_SurroundedRegions {
	private static void bfs(char[][] board, int i, int j){
		int m = board.length;
        int n = board[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
		board[i][j] = 'O';
        q.add(i*n+j); //注意乘以列数
        while(!q.isEmpty()){
        		int xy = q.poll();
        		int x = xy / n;
        		int y = xy - x * n;
        		if ((0<x)   && (board[x-1][y] == '$')){
        			board[x-1][y] = 'O';
        			q.add((x-1)*n+y);
        		}
        		if ((x+1<m) && (board[x+1][y] == '$')){
        			board[x+1][y] = 'O';
        			q.add((x+1)*n+y);
        		}
        		if ((0<y)   && (board[x][y-1] == '$')){
        			board[x][y-1] = 'O';
        			q.add(x*n+y-1);
        		}
        		if ((y+1<n) && (board[x][y+1] == '$')){
        			board[x][y+1] = 'O';
        			q.add(x*n+y+1);
        		}
        }
	}
    public static void solve(char[][] board) {
    		if (board.length == 0) return; //注意：二维数组为空
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++)
        	for(int j=0; j<n; j++)
        		if (board[i][j] == 'O')
        			board[i][j] = '$';
        for(int i=0; i<m; i++){
        		if(board[i][0]   == '$') bfs(board,i,0);
        		if(board[i][n-1] == '$') bfs(board,i,n-1);
        }
        for(int j=0; j<n; j++){
        		if(board[0][j]   == '$') bfs(board,0,j);
        		if(board[m-1][j] == '$') bfs(board,m-1,j);
        }
        for(int i=0; i<m; i++)
        	for(int j=0; j<n; j++)
        		if (board[i][j] == '$')
        			board[i][j] = 'X';
        
    }
	public static void main(String[] args) {
		char[][] board = new char[][]{{'X','O','X','O','X','O'},
									 {'O','X','O','X','O','X'},
									 {'X','O','X','O','X','O'},
									 {'O','X','O','X','O','X'}};
		solve(board); //dfs居然栈溢出
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
