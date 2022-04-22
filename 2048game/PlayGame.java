/**
   Author: Mathew Petronilho, Petronim
   Revised: April 2, 2021

   Description: A module allowing a user to play 2048
*/
package src;
//import src.ViewGameGame;
//import src.Board;

import java.util.Scanner;
import java.util.Arrays;

/**
  @brief This module simulates the game 2048
*/
public class PlayGame {

	public static void main(String[] args) {
		play_2048();

	}
	
	
	public static void play_2048() {
		Board.init();
		ViewGame.print_welcome_message();
		
		while(Board.is_any_valid_move()) {
			ViewGame.print_current_score(Board.get_score());
			ViewGame.print_board(Board.get_board());
		
			Scanner myScanner = new Scanner(System.in);
			ViewGame.print_move_prompt();
			String answer = myScanner.next();
			try {
				if (answer.charAt(0) == 'U') {
					//System.out.println("One");
					Board.make_move(MoveType.U);
				}
			
				else if (answer.charAt(0) == 'D') {
					Board.make_move(MoveType.D);
				}
			
				else if (answer.charAt(0) == 'L') {
					Board.make_move(MoveType.L);
				}
				else if (answer.charAt(0) == 'E') {
					ViewGame.print_ending_message();
					return;
				}
			
				else {
					Board.make_move(MoveType.R);
				}
			}
			catch(Exception e){
				ViewGame.print_invalid_move_message();
				continue;
			}
			
			
			if (Board.is_game_won()) {
				ViewGame.print_board(Board.get_board());
				ViewGame.print_game_won();
				ViewGame.print_ending_message();
				myScanner.close();
				return;
			}
			
			//myScanner.close();
		}
		
		ViewGame.print_board(Board.get_board());
		ViewGame.print_game_lost();
		ViewGame.print_ending_message();
		return;
	}

}
