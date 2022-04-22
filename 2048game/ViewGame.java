/**
   Author: Mathew Petronilho, Petronim
   Revised: April 2, 2021

   Description: A view module for displaying the state and status of the game
*/
package src;
import java.util.Arrays;

/**
   @brief A library that provides methods to view the state of the game
*/
public class ViewGame{

	/**
	  @brief Displays the game board
	  @details Board is displayed in such a way that (0,0) is in the top-left and (3,3) is in the bottom-right
	  @param board the game board
	*/
	public static void print_board(int[][] board) {
		System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace(" 0", "  ").replace("0,", " ,"));
	}
	
	/**
	  @brief Displays a welcome message to the game
	*/
	public static void print_welcome_message() {
		System.out.println("----------------------------------------");
		System.out.println("            Welcome to 2048             ");
		System.out.println("----------------------------------------");
	}
	
	/**
	  @brief Displays the current score the player has achieved
	  @param score The current score
	*/
	public static void print_current_score(int score) {
		System.out.println("----------------------------------------");
		System.out.println("          Current Score: " + score + "          ");
		System.out.println("----------------------------------------");
	}
	
	/**
	  @brief Displays a prompt to enter a move direction or exit the game
	  @details Moves must be either left, right, up or down
	*/
	public static void print_move_prompt() {
		System.out.println("What direction would you like to move the board?");
		System.out.println("Enter U for up, D for down, R for right, L for left or E to exit: ");
	}
	
	/**
	  @brief Displays an invalid move message
	  @details Should be displayed when an invalid move is entered
	*/
	public static void print_invalid_move_message() {
		System.out.println();
		System.out.println("The move entered was invalid, try again.");
	}
	
	/**
	  @brief Displays a message letting the user know they lost
	*/
	public static void print_game_lost() {
		System.out.println("----------------------------------------");
		System.out.println(" You ran out of valid moves and lost :( ");
		System.out.println("----------------------------------------");
	}
	
	/**
	  @brief Displays a message letting the user know they won
	*/
	public static void print_game_won() {
		System.out.println("----------------------------------------");
		System.out.println("        You won, Congratulations!       ");
		System.out.println("----------------------------------------");
	}
	
	/**
	  @brief Displays a message thanking the player
	*/
	public static void print_ending_message() {
		System.out.println("----------------------------------------");
		System.out.println("          Thanks for playing :)         ");
		System.out.println("----------------------------------------");
	}
}