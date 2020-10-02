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
		do
		{
			char board[] = createBoard();
			playerLetter = chooseLetter();
			if(playerLetter=='X')
				compLetter = 'O';
			else
				compLetter = 'X';
			System.out.println("Player: "+playerLetter+" Computer: "+compLetter);
			System.out.println("Initial board: ");
			showBoard(board);
			int tossWinner = toss(); // user : 0 & computer : 1
			switch(tossWinner)
			{
				case 0:
					do
					{
						makePlayerMove(board);
						showBoard(board);
						if(isGameOver(gameStatus(board, playerLetter))==true)
							break;
						makeCompMove(board);
						showBoard(board);
					}while(isGameOver(gameStatus(board, compLetter))==false);
					break;
				case 1:
					do
					{
						makeCompMove(board);
						showBoard(board);
						if(isGameOver(gameStatus(board, compLetter))==true)
							break;
						makePlayerMove(board);
						showBoard(board);
					}while(isGameOver(gameStatus(board, playerLetter))==false);
			}
		}while(rematch()==true);
		in.close();
		System.out.println("-----Program Terminated-----");
	}
	
	/**
	 * @return
	 * createBoard creates an empty board
	 */
	private static char[] createBoard()
	{
		char board[] = new char[10];
		for(int index=0; index<board.length; index++)
			board[index] = ' ';
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
	private static void makePlayerMove(char board[])
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
	
	/**
	 * @param board
	 * Make computer move
	 */
	private static void makeCompMove(char board[])
	{
		//make winning move
		if(board[1]==compLetter && board[2]==compLetter && board[3]==' ')
			board[3] = compLetter;
		else if(board[1]==compLetter && board[2]==' ' && board[3]==compLetter)
			board[2] = compLetter;
		else if(board[1]==' ' && board[2]==compLetter && board[3]==compLetter)
			board[1] = compLetter;
		else if(board[4]==compLetter && board[5]==compLetter && board[6]==' ')
			board[6] = compLetter;
		else if(board[4]==compLetter && board[5]==' ' && board[6]==compLetter)
			board[5] = compLetter;
		else if(board[4]==' ' && board[5]==compLetter && board[6]==compLetter)
			board[4] = compLetter;
		else if(board[7]==compLetter && board[8]==compLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[7]==compLetter && board[8]==' ' && board[9]==compLetter)
			board[8] = compLetter;
		else if(board[7]==' ' && board[8]==compLetter && board[9]==compLetter)
			board[7] = compLetter;
		else if(board[1]==compLetter && board[4]==compLetter && board[7]==' ')
			board[7] = compLetter;
		else if(board[1]==compLetter && board[4]==' ' && board[7]==compLetter)
			board[4] = compLetter;
		else if(board[1]==' ' && board[4]==compLetter && board[7]==compLetter)
			board[1] = compLetter;
		else if(board[2]==compLetter && board[5]==compLetter && board[8]==' ')
			board[8] = compLetter;
		else if(board[2]==compLetter && board[5]==' ' && board[8]==compLetter)
			board[5] = compLetter;
		else if(board[2]==' ' && board[5]==compLetter && board[8]==compLetter)
			board[2] = compLetter;
		else if(board[3]==compLetter && board[6]==compLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[3]==compLetter && board[6]==' ' && board[9]==compLetter)
			board[6] = compLetter;
		else if(board[3]==' ' && board[6]==compLetter && board[9]==compLetter)
			board[3] = compLetter;
		else if(board[1]==compLetter && board[5]==compLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[1]==compLetter && board[5]==' ' && board[9]==compLetter)
			board[5] = compLetter;
		else if(board[1]==' ' && board[5]==compLetter && board[9]==compLetter)
			board[1] = compLetter;
		else if(board[3]==compLetter && board[5]==compLetter && board[7]==' ')
			board[7] = compLetter;
		else if(board[3]==compLetter && board[5]==' ' && board[7]==compLetter)
			board[5] = compLetter;
		else if(board[3]==' ' && board[5]==compLetter && board[7]==compLetter)
			board[3] = compLetter;
		else
		{
			if(blockPlayerWin(board)=='F')
			{
				if(makeCompCornerMove(board)=='F')
					makeAvailableCompMove(board);
			}
		}
	}
	
	/**
	 * @param board
	 * Make computer move to avoid player win
	 */
	private static char blockPlayerWin(char board[])
	{
		if(board[1]==playerLetter && board[2]==playerLetter && board[3]==' ')
			board[3] = compLetter;
		else if(board[1]==playerLetter && board[2]==' ' && board[3]==playerLetter)
			board[2] = compLetter;
		else if(board[1]==' ' && board[2]==playerLetter && board[3]==playerLetter)
			board[1] = compLetter;
		else if(board[4]==playerLetter && board[5]==playerLetter && board[6]==' ')
			board[6] = compLetter;
		else if(board[4]==playerLetter && board[5]==' ' && board[6]==playerLetter)
			board[5] = compLetter;
		else if(board[4]==' ' && board[5]==playerLetter && board[6]==playerLetter)
			board[4] = compLetter;
		else if(board[7]==playerLetter && board[8]==playerLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[7]==playerLetter && board[8]==' ' && board[9]==playerLetter)
			board[8] = compLetter;
		else if(board[7]==' ' && board[8]==playerLetter && board[9]==playerLetter)
			board[7] = compLetter;
		else if(board[1]==playerLetter && board[4]==playerLetter && board[7]==' ')
			board[7] = compLetter;
		else if(board[1]==playerLetter && board[4]==' ' && board[7]==playerLetter)
			board[4] = compLetter;
		else if(board[1]==' ' && board[4]==playerLetter && board[7]==playerLetter)
			board[1] = compLetter;
		else if(board[2]==playerLetter && board[5]==playerLetter && board[8]==' ')
			board[8] = compLetter;
		else if(board[2]==playerLetter && board[5]==' ' && board[8]==playerLetter)
			board[5] = compLetter;
		else if(board[2]==' ' && board[5]==playerLetter && board[8]==playerLetter)
			board[2] = compLetter;
		else if(board[3]==playerLetter && board[6]==playerLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[3]==playerLetter && board[6]==' ' && board[9]==playerLetter)
			board[6] = compLetter;
		else if(board[3]==' ' && board[6]==playerLetter && board[9]==playerLetter)
			board[3] = compLetter;
		else if(board[1]==playerLetter && board[5]==playerLetter && board[9]==' ')
			board[9] = compLetter;
		else if(board[1]==playerLetter && board[5]==' ' && board[9]==playerLetter)
			board[5] = compLetter;
		else if(board[1]==' ' && board[5]==playerLetter && board[9]==playerLetter)
			board[1] = compLetter;
		else if(board[3]==playerLetter && board[5]==playerLetter && board[7]==' ')
			board[7] = compLetter;
		else if(board[3]==playerLetter && board[5]==' ' && board[7]==playerLetter)
			board[5] = compLetter;
		else if(board[3]==' ' && board[5]==playerLetter && board[7]==playerLetter)
			board[3] = compLetter;
		else
			return 'F';
		return 'T';
	}
	
	/**
	 * @param board
	 * @return
	 * Make computer move to occupy corner
	 */
	private static char makeCompCornerMove(char board[])
	{
		if(isFreeIndex(board,1)==true)
			board[1] = compLetter;
		else if(isFreeIndex(board,3)==true)
			board[3] = compLetter;
		else if(isFreeIndex(board,7)==true)
			board[7] = compLetter;
		else if(isFreeIndex(board,9)==true)
			board[9] = compLetter;
		else
			return 'F';
		return 'T';
	}
	
	/**
	 * @param board
	 * Make remaining available computer moves - center and sides
	 */
	private static void makeAvailableCompMove(char board[])
	{
		if(isFreeIndex(board,5)==true)
			board[5] = compLetter;
		else if(isFreeIndex(board,2)==true)
			board[2] = compLetter;
		else if(isFreeIndex(board,4)==true)
			board[4] = compLetter;
		else if(isFreeIndex(board,6)==true)
			board[6] = compLetter;
		else if(isFreeIndex(board,8)==true)
			board[8] = compLetter;
	}
	
	/**
	 * @param gameStatusValue
	 * @return
	 * check if the game is over
	 * gameStatusValue = -1, Game Won
	 * gameStatusValue =  1, Board Full
	 */
	private static boolean isGameOver(int gameStatusValue)
	{
		if(gameStatusValue==-1 || gameStatusValue==1)
			System.out.println("-----Game Over-----");
		else
			return false;
		return true;
	}
	
	/**
	 * @return
	 * ask user for a rematch
	 */
	private static boolean rematch()
	{
		System.out.println("\nUp for a rematch? (y/n): ");
		char choice = in.next().charAt(0);
		if(choice=='y')
			return true;
		else
			return false;
	}
}
