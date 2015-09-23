package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q36_ValidSudoku {
	public static boolean isOk(int t1,int t2,int t3,int t4,char[][] board){
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
	public static boolean isValidSudoku(char[][] board) {
        boolean ans = true;
        for(int i=0; i<=8; i++){
        	ans &= isOk(i,i,0,8,board);
        	ans &= isOk(0,8,i,i,board);
        }
        for(int i=0; i<=2; i++){
        	for(int j=0; j<=2; j++){
        		ans &= isOk(3*i,3*i+2,3*j,3*j+2,board);
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][]
				{{'5','3','.','.','7','.','.','.','.'},
				 {'6','.','.','1','9','5','.','.','.'},
				 {'.','9','8','.','.','.','.','6','.'},
				 {'8','.','.','.','6','.','.','.','3'},
				 {'4','.','.','8','.','3','.','.','1'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','6','.','.','.','.','2','8','.'},
				 {'.','.','.','4','1','9','.','.','5'},
				 {'.','.','.','.','8','.','.','7','9'}}));
	}

}
