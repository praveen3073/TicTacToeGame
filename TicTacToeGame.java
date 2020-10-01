package com.cg.tictactoe;
import java.util.*;

/**
 * @author Praveen Satya
 * Tic Tac Toe Game Simulator
 */
public class TicTacToeGame {
	static Scanner in = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac Toe Game");
		char board[] = createBoard();
		char playerLetter = chooseLetter();
		char compLetter;
		if(playerLetter=='X')
			compLetter = 'O';
		else
			compLetter = 'X';
		System.out.println("Player: "+playerLetter+" Computer: "+compLetter);
		System.out.println("Current Board: ");
		showBoard(board);
		makePlayerMove(board, playerLetter);
		showBoard(board);
		makePlayerMove(board, playerLetter);
		showBoard(board);
		in.close();
	}
	
	/**
	 * @return
	 * createBoard creates an empty board
	 */
	private static char[] createBoard()
	{
		char board[] = new char[10];
		for(char charValue : board)
			charValue = ' ';
		return board;
	}
	
	/**
	 * @return
	 * choose X or O
	 */
	private static char chooseLetter()
	{
		char letterChoice; 
		do
		{
			System.out.print("Choose X or O: ");
			letterChoice = Character.toUpperCase(in.next().charAt(0));
		} while(letterChoice!='X' && letterChoice!='O');
		return letterChoice;
	}
	
	/**
	 * @param board
	 * showBoard displays current board
	 */
	private static void showBoard(char board[])
	{
		for(int index=1; index<board.length; index++)
		{
			if(index%3==0)
				System.out.println(board[index]);
			else
				System.out.print(board[index] + ",");
		}
	}
	
	/**
	 * @param board
	 * @param playerLetter
	 * Make move in an empty index
	 */
	private static void makePlayerMove(char board[], char playerLetter)
	{
		int indexChoice;
		do
		{
			System.out.print("Select index between 1 and 9: ");
			indexChoice = in.nextInt();
			in.nextLine();
			if(isFreeIndex(indexChoice, board) == false)
				System.out.println("Index already filled");
			else
			{
				board[indexChoice] = playerLetter;
				return;
			}
		}while(board[indexChoice]!=' ');
	}
	
	/**
	 * @param index
	 * @param board
	 * @return
	 * checks for free index
	 */
	private static boolean isFreeIndex(int index, char board[])
	{
		if(board[index]=='X' || board[index]=='O')
			return false;
		else
			return true;
	}
}
