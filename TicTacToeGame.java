package com.cg.tictactoe;

public class TicTacToeGame {
	/**
	 * @author Praveen Satya
	 * Tic Tac Toe Game Simulator	
	 */
	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac Toe Game");
		char board[] = createBoard();
	}
	
	/**
	 * @return
	 * createBoard creates an empty board
	 */
	public static char[] createBoard()
	{
		char board[] = new char[10];
		for(char charValue : board)
			charValue = ' ';
		return board;
	}
}
