package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q37_SudokuSolver {
	public boolean isOk(int t1,int t2,int t3,int t4,char[][] board){
		Set<Character> s = new HashSet<Character>();
		for(int i=t1; i<=t2; i++)
			for(int j=t3; j<=t4; j++){
				if ((board[i][j]!='.')&&(s.contains(board[i][j]))){
					return false; 
				}else{
					s.add(board[i][j]);
				}
			}
		return true;
	}
	public boolean Next(char[][] board){
		for(int i=0; i<=8; i++){
			for(int j=0; j<=8; j++){
				if (board[i][j]=='.'){
					for(int k=1; k<=9; k++){
						board[i][j] = (char) ('0' + k);
						if((isOk(i,i,0,8,board))&&
						   (isOk(0,8,j,j,board))&&
						   (isOk(i/3*3,i/3*3+2,j/3*3,j/3*3+2,board))&&
						   (Next(board))){//注意出口这样写，递归子问题，子问题返回ok则认为满足条件。
								return true;
						}
						board[i][j]='.';//注意：状态要后退，不然影响下次的判断isOk
					}
					return false;
				}
			}
		}
		return true;
	}
	public void solveSudoku(char[][] board){
		Next(board);
	}
	public static void main(String[] args) {
		Q37_SudokuSolver q = new Q37_SudokuSolver();
		char[][] board = new char[][]
				{{'5','3','.','.','7','.','.','.','.'},
				 {'6','.','.','1','9','5','.','.','.'},
				 {'.','9','8','.','.','.','.','6','.'},
				 {'8','.','.','.','6','.','.','.','3'},
				 {'4','.','.','8','.','3','.','.','1'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','6','.','.','.','.','2','8','.'},
				 {'.','.','.','4','1','9','.','.','5'},
				 {'.','.','.','.','8','.','.','7','9'}};
		
		
		for(int i=0; i<=8; i++){
			for(int j=0; j<=8; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		q.solveSudoku(board);
		for(int i=0; i<=8; i++){
			for(int j=0; j<=8; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
