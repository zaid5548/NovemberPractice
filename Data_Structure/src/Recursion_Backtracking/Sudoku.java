package Recursion_Backtracking;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[][] board= { 
	            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
	            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
	            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
	            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
	            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
	            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
	            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};
//		for(int i=0;i<board.length;i++) {
//			for(int j=0;j<board[0].length;j++) {
//				board[i][j]=scn.nextInt();
//			}
//		}
		solver(board,0,0);
	}
	
	public static void solver(int[][] board,int row,int col) {
		
		if(col==board[0].length) {
			row++;
			col=0;
		}
		
		if(row==board.length) {
			System.out.println("\n---------------\n");
			display(board);
			return;
		}
		
		if(board[row][col]!=0) {
			solver(board, row, col+1);
		}
		
		
		for(int i=1;i<=9;i++) {
			
			if(isItsafe(board, row, col, i)) {
			board[row][col]=i;
			solver(board, row, col+1);
			board[row][col]=0;
			}
		}
		
	}
	
	public static boolean isItsafe(int[][] board,int row,int col,int val) {
		
		//check col
		for(int c=0;c<9;c++) {
			if(board[row][c]==val) {
				return false;
			}
		}
		
		//check row
		for(int r=0;r<9;r++) {
			if(board[r][col]==val) {
				return false;
			}
		}
		
		//check block
		int si=row-row%3;
		int ei=col-col%3;
		for(int i=si;i<si+3;i++) {
			for(int j=ei;j<ei+3;j++) {
				if(board[i][j]==val) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static void display(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
