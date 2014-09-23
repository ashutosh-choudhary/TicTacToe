package com.fdbdevelopment.tictactoe;

import java.util.Random;

public class TicTacToeGame {
	
	private char mBoard[];
	private final static int BOARD_SIZE = 9;
	
	public static final char HUMAN_PLAYER = 'X';
	public static final char BOT_PLAYER = '0';
	public static final char EMPTY_SPACE = ' ';
	
	private Random mRand;
	
	public static int getBOARD_SIZE(){
		return BOARD_SIZE;
	}
	
	public TicTacToeGame(){
		
		mBoard = new char[BOARD_SIZE];				
		clearBoard();		
		mRand = new Random();
			
	}
	
	public void clearBoard(){
		for(int i = 0; i < BOARD_SIZE; i++)
			mBoard[i] = EMPTY_SPACE;
	}
	
	public void setMove(char player, int location){
		mBoard[location] = player;
	}
	
	public int getBotMove(){		
		int move;
		for(int i = 0; i < getBOARD_SIZE(); i++){
			if(mBoard[i] != HUMAN_PLAYER && mBoard[i] != BOT_PLAYER){
				char curr = mBoard[i];
				mBoard[i] = BOT_PLAYER;
				if(checkForWinner() == 3){
					setMove(BOT_PLAYER, i);
					return i;
				}else
					mBoard[i] = curr;				
			}
		}
		
		for(int i = 0; i < getBOARD_SIZE(); i++){
			if(mBoard[i] != HUMAN_PLAYER && mBoard[i] != BOT_PLAYER){
				char curr = mBoard[i];
				mBoard[i] = HUMAN_PLAYER;
				if(checkForWinner() == 2){
					setMove(BOT_PLAYER, i);
					return i;
				}else
					mBoard[i] = curr;				
			}
		}
		
		do{
			move = mRand.nextInt(getBOARD_SIZE());			
		}while(mBoard[move] == HUMAN_PLAYER || mBoard[move] == BOT_PLAYER);
		
		setMove(BOT_PLAYER, move);
		return move;
	}
	/** Method to check whether there is a win situation
	 * @return integer depicting win scenario
	 * 0 - No win-draw scenario
	 * 1 - A Draw
	 * 2 - Human Win
	 * 3 - Bot Win
	 */
	
	
	public int checkForWinner(){
		//Checking Horizontal Win
		for(int i = 0; i <= 6; i += 3){
			if(mBoard[i] == HUMAN_PLAYER &&
			   mBoard[i+1] == HUMAN_PLAYER &&
			   mBoard[i+2] == HUMAN_PLAYER)
				return 2;
			if(mBoard[i] == BOT_PLAYER &&
			   mBoard[i+1] == BOT_PLAYER &&
			   mBoard[i+2] == BOT_PLAYER)
				return 3;
		}
		//Checking Vertical Win
		for(int i = 0; i <= 2; i++){
			if(mBoard[i] == HUMAN_PLAYER &&
			   mBoard[i+3] == HUMAN_PLAYER &&
			   mBoard[i+6] == HUMAN_PLAYER)
				return 2;
			if(mBoard[i] == BOT_PLAYER &&
			   mBoard[i+3] == BOT_PLAYER &&
			   mBoard[i+6] == BOT_PLAYER)
				return 3;
		}
		//Checking Diagonal Win
		int i = 0;
			if(mBoard[i] == HUMAN_PLAYER &&
			   mBoard[i+4] == HUMAN_PLAYER &&
			   mBoard[i+8] == HUMAN_PLAYER)
				return 2;
			if(mBoard[i] == BOT_PLAYER &&
			   mBoard[i+4] == BOT_PLAYER &&
			   mBoard[i+8] == BOT_PLAYER)
				return 3;
		
		i = 2;
			if(mBoard[i] == HUMAN_PLAYER &&
			   mBoard[i+2] == HUMAN_PLAYER &&
			   mBoard[i+4] == HUMAN_PLAYER)
				return 2;
			if(mBoard[i] == BOT_PLAYER &&
			   mBoard[i+2] == BOT_PLAYER &&
			   mBoard[i+4] == BOT_PLAYER)
				return 3;
			
		for(i = 0; i < getBOARD_SIZE(); i++){
			if(mBoard[i] != HUMAN_PLAYER && mBoard[i] != BOT_PLAYER)
				return 0;
		}
		
		return 1;
	}
	
}
