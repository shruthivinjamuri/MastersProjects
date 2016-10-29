package selfPreparation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] board = {{0,-1,-1,0},{-1,0,1,-1},{0,-1,-1,0}};
		System.out.println(isLegalMove(board, 1, 1, false));

	}
	/**
	 * 
	 * @param board - This board will have 0 for empty place, 1 for white stone and -1 for black stone
	 * @param row - x coordinate where the next stone should be placed
	 * @param col - y coordinate for the next stone
	 * @param isBlack - boolean value indcating whether the current stone is black or white
	 * @return - true if the stone can be placed at x,y position otherwise false
	 */
	public static boolean isLegalMove(int [][] board, int row, int col, boolean isBlack){
		int cols = board[0].length;
		int rows = board.length;
		//check whether row,col is a valid coordinate on board.
		if(row < 0 || row > rows || col < 0 || col > cols)
			return false;
		//position already occupied
		if(board[row][col] != 0) return false;
		
		Set<String> set = new HashSet<String>();
		
		Stack<Integer> rowSt = new Stack<Integer>();
		Stack<Integer> colSt = new Stack<Integer>();
		rowSt.push(row);colSt.push(col);
		set.add(row+"-"+col);
		while(!rowSt.isEmpty()){
			int curRow = rowSt.pop();
			int curCol = colSt.pop();
			//up
			if(curRow > 0 && !set.contains((curRow-1)+"-"+curCol)){
				if(board[curRow-1][curCol] == 0)
					return true;
				if((isBlack && board[curRow-1][curCol] == -1) || (!isBlack && board[curRow-1][curCol] == 1)){
					rowSt.push(curRow-1);
					colSt.push(curCol);
					set.add((curRow-1)+"-"+curCol);
				}
			}
			//down
			if(curRow+1 < rows && !set.contains((curRow+1)+"-"+curCol)){
				if(board[curRow+1][curCol] == 0)
					return true;
				if((isBlack && board[curRow+1][curCol] == -1) || (!isBlack && board[curRow+1][curCol] == 1)){
					rowSt.push(curRow+1);
					colSt.push(curCol);
					set.add((curRow+1)+"-"+curCol);
				}
			}
			
			//left
			if(curCol > 0 && !set.contains((curRow)+"-"+(curCol-1))){
				if(board[curRow][curCol-1] == 0)
					return true;
				if((isBlack && board[curRow][curCol-1] == -1) || (!isBlack && board[curRow][curCol-1] == 1)){
					rowSt.push(curRow);
					colSt.push(curCol-1);
					set.add((curRow)+"-"+(curCol-1));
				}
			}
			
			//right
			if(curCol+1 < cols && !set.contains((curRow)+"-"+(curCol+1))){
				if(board[curRow][curCol+1] == 0)
					return true;
				if((isBlack && board[curRow][curCol+1] == -1) || (!isBlack && board[curRow][curCol+1] == 1)){
					rowSt.push(curRow);
					colSt.push(curCol+1);
					set.add((curRow)+"-"+(curCol+1));
				}
			}
		}
		
		return false;
	}

}
