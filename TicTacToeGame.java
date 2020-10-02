package com.cg.tictactoe;
import java.util.*;

/**
 * @author Praveen Satya
 * Tic Tac Toe Game Simulator
 */
public class TicTacToeGame {
	static Scanner in = new Scanner(System.in);
	static char playerLetter;
	static char compLetter;
	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac Toe Game");
		char board[] = createBoard();
		playerLetter = chooseLetter();
		if(playerLetter=='X')
			compLetter = 'O';
		else
			compLetter = 'X';
		System.out.println("Player: "+playerLetter+" Computer: "+compLetter);
		System.out.println("Current Board: ");
		showBoard(board);
		int tossWinner = toss();
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
			if(isFreeIndex(board, indexChoice) == false)
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
	private static boolean isFreeIndex(char board[], int index)
	{
		if(board[index]=='X' || board[index]=='O')
			return false;
		else
			return true;
	}
	
	/**
	 * @return
	 * returns winner of the toss
	 */
	private static int toss()
	{
		int randomNo = (int) (Math.random()*10)%2;
		if(randomNo==0)
			System.out.println("User won the toss.");
		else
			System.out.println("Computer won the toss.");
		return randomNo;
	}
	
	/**
	 * @param board
	 * @param lastLetterPlayed
	 * @return
	 * display game's current status - winner, tie or turn change
	 */
	private static int gameStatus(char board[], char lastLetterPlayed)
	{
		if((board[1]==lastLetterPlayed && board[2]==lastLetterPlayed && board[3]==lastLetterPlayed)
		|| (board[4]==lastLetterPlayed && board[5]==lastLetterPlayed && board[6]==lastLetterPlayed)
		|| (board[7]==lastLetterPlayed && board[8]==lastLetterPlayed && board[9]==lastLetterPlayed)
		|| (board[1]==lastLetterPlayed && board[4]==lastLetterPlayed && board[7]==lastLetterPlayed)
		|| (board[2]==lastLetterPlayed && board[5]==lastLetterPlayed && board[8]==lastLetterPlayed)
		|| (board[3]==lastLetterPlayed && board[6]==lastLetterPlayed && board[9]==lastLetterPlayed)
		|| (board[1]==lastLetterPlayed && board[5]==lastLetterPlayed && board[9]==lastLetterPlayed)
		|| (board[3]==lastLetterPlayed && board[5]==lastLetterPlayed && board[7]==lastLetterPlayed))
		{
			if(lastLetterPlayed == playerLetter)
				System.out.println("User has won the game.");
			else
				System.out.println("Computer has won the game.");
			return -1; 
		}
		for(int index = 1; index<board.length; index++)
			if(isFreeIndex(board,index) == true)
			{
				if(lastLetterPlayed == playerLetter)
					System.out.println("Conputer's turn.");
				else
					System.out.println("User's turn.");
				return 0;
			}
		System.out.println("The game has ended with a tie.");
		return 1;
	}
}
