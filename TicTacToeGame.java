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
		in.close();
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
	
	/**
	 * @return
	 * choose X or O
	 */
	public static char chooseLetter()
	{
		char letterChoice; 
		do
		{
			System.out.print("Choose X or O: ");
			letterChoice = Character.toUpperCase(in.next().charAt(0));
		} while(letterChoice!='X' && letterChoice!='O');
		return letterChoice;
	}
}
