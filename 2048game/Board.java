/**
   Author: Mathew Petronilho, Petronim
   Revised: April 2, 2021

   Description: A model module for holding the state and status of the game
*/
package src;

/**
   @brief An abstract object that represents the game board and its state
*/
public class Board {
	
	private static int[][] board;
	private static int SIZE = 4;
	private static int MAX = 2048;
	private static int BASE = 2;
	private static int score;
	

	/**
		@brief Constructor of board
		@details Creates a board of zeros with two random values
	*/
	public static void init() {
		board = new int[SIZE][SIZE];
		for (int i = 0; i < 2; i++) {
			random_place(); 
		}

		score = 0;
		
	}

	/**
		@brief Constructor of board
		@details Allows user to pick starting board. Assume that all boards entered satisfy MIS specifications.
		         Also allows easier testing of the module.
		@param b User specified board
	*/
	public static void init(int[][] b) {
		board = b;
		score = 0;
		
	}

	/**
		@brief Changes board according to direction given
		@details Shifts board in specified direction and adds tiles accordingly.
		@param dir Direction in which the board should be shifted
	*/
	public static void update_board(MoveType dir) {
		if (dir == MoveType.D) {
			if (is_valid_move_down()) {
				shift_down();
				add_down();
				shift_down();
			}
			
			else {
				throw new IllegalArgumentException("Not Possible to move down");
			}
			
			
		}
		
		else if (dir == MoveType.U) {
			if (is_valid_move_up()) {
				shift_up();
				add_up();
				shift_up();
			}
			
			else {
				throw new IllegalArgumentException("Not Possible to move up");
			}
			
		}
		
		else if (dir == MoveType.L) {
			if (is_valid_move_left()) {
				shift_left();
				add_left();
				shift_left();
			}
			
			else {
				throw new IllegalArgumentException("Not Possible to move left");
			}
			
		}
		
		else {
			if (is_valid_move_right()) {
				shift_right();
				add_right();
				shift_right();
			}
			
			else {
				throw new IllegalArgumentException("Not Possible to move right");
			}
			
		}
	}

	/**
		@brief Spawns a random tile in an unoccupied coordinate on the board
		@details Numbers spawned and their probability of spawning are determined by the random_num function
	*/
	public static void update_random(){
		int zeros = 0;
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				if (board[i][j] == 0){
					zeros++;
				}
			}
		}
		if (zeros == 0) throw new ArrayIndexOutOfBoundsException("Can not spawn new tile on full board"); 

		boolean NotPlaced = true;
		while (NotPlaced) {
			int x = random_coord();
			int y = random_coord();
			if (board[x][y] == 0) {
				board[x][y] = random_num();
				NotPlaced = false;
			}
		}
	}

	/**
		@brief Changes board according to direction given
		@details Shifts board in specified direction and adds tiles accordingly. Also spawns a new random tile
		@param dir Direction in which the board should be shifted
	*/
	public static void make_move(MoveType dir){
		update_board(dir);
		update_random();
	}

	/**
		@brief Get the score of the current game
		@return The score of the current game
	*/
	public static int get_score() {
		return score;
	}

	/**
		@brief Get the board of the current game
		@return The board of the current game
	*/
	public static int[][] get_board(){
		return board;
	}

	/**
		@brief Determines if any valid move can be made on the current board
		@return A value representing if there are valid moves left to be made
	*/	
	public static boolean is_any_valid_move() {
		return is_valid_move_left() || is_valid_move_right() || is_valid_move_up() || is_valid_move_down();
	}

	/**
		@brief Determines if the player has won the game
		@details The game is considered to be won if the MAX value is on the board
		@return A value representing if there are valid moves left to be made
	*/
	public static boolean is_game_won() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == MAX) {
					return true;
				}
			}
		}
		return false;
	}	

	private static boolean is_valid_move_left() {
		for (int i = 0; i < SIZE; i++) {        
			for (int j = 1; j < SIZE; j++) {  //dont check first column
				if (board[i][j] != 0 && (board[i][j] == board[i][j - 1] || board[i][j - 1] == 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean is_valid_move_right() {
		for (int i = 0; i < SIZE; i++) {        
			for (int j = 0; j < SIZE - 1; j++) {  //dont check last column
				if (board[i][j] != 0 && (board[i][j] == board[i][j + 1] || board[i][j + 1] == 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean is_valid_move_up() {
		for (int i = 1; i < SIZE; i++) {        //dont check first row
			for (int j = 0; j < SIZE; j++) {  
				if (board[i][j] != 0 && (board[i][j] == board[i - 1][j] || board[i - 1][j] == 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean is_valid_move_down() {
		for (int i = 0; i < SIZE - 1; i++) {        //dont check last row
			for (int j = 0; j < SIZE; j++) {  
				if (board[i][j] != 0 && (board[i][j] == board[i + 1][j] || board[i + 1][j] == 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static void shift_left() {
		for (int j = 0; j < SIZE; j++) {   //each row
			int i = 1;                     //start at column 1 (left)
			while (i < SIZE) {   
				if (board[j][i] == 0){       //if the tile itself is 0, move on to next
					i++;
					continue;
				}
				else {
					for (int k = i; k > 0; k--) {     //shifts current tile as far left as possible
						if (board[j][k - 1] != 0 ) {  //if to the left there is not a 0, we can't shift anymore
							break;
						}
						board[j][k - 1] = board[j][k];   //shift tile left
						board[j][k] = 0;
						
					}
					i++;
					
				}
				
			}
		}
	}	
	
	private static void shift_right() {
		for (int j = 0; j < SIZE; j++) {   //each row
			int i = SIZE - 2;                     //start at last column
			while (i >= 0) {   
				if (board[j][i] == 0){       //if the tile itself is 0, move on to next
					i--;
					continue;
				}
				else {
					for (int k = i; k < SIZE - 1; k++) {     //shifts current tile as far right as possible
						if (board[j][k + 1] != 0 ) {  //if to the right there is not a 0, we can't shift anymore
							break;
						}
						board[j][k + 1] = board[j][k];   //shift tile right
						board[j][k] = 0;
						
					}
					i--;
					
				}
				
			}
		}
	}
	
	private static void shift_up() {
		for (int j = 0; j < SIZE; j++) { 
			int i = 1;                     
			while (i < SIZE) {   
				if (board[i][j] == 0){       //if the tile itself is 0, move on to next
					i++;
					continue;
				}
				else {
					for (int k = i; k > 0; k--) {     //shifts current tile as far up as possible
						if (board[k - 1][j] != 0 ) {  //if to the above there is not a 0, we can't shift anymore
							break;
						}
						board[k - 1][j] = board[k][j];   //shift tile up
						board[k][j] = 0;
						
					}
					i++;
					
				}
				
			}
		}
	}
	
	private static void shift_down() {
		for (int j = 0; j < SIZE; j++) {
			int i = SIZE - 2;                     
			while (i >= 0) {   
				if (board[i][j] == 0){       //if the tile itself is 0, move on to next
					i--;
					continue;
				}
				else {
					for (int k = i; k < SIZE - 1; k++) {     //shifts current tile as far down as possible
						if (board[k + 1][j] != 0 ) {  //if below there is not a 0, we can't shift anymore
							break;
						}
						board[k + 1][j] = board[k][j];   //shift tile down
						board[k][j] = 0;
						
					}
					i--;
					
				}
				
			}
		}
	}
	
	private static void add_left() {
		for (int i = 0; i < SIZE; i++) {   //each row
			for (int j = 0; j < SIZE - 1; j++) {  //column
				if (board[i][j] == board[i][j + 1] && board[i][j] != 0) {
					board[i][j] = board[i][j] + board[i][j + 1];
					board[i][j + 1] = 0;
					score += board[i][j];
				}
			}
		}
	}
	
	private static void add_right() {
		for (int i = 0; i < SIZE; i++) {   //each row
			for (int j = SIZE - 1; j > 0; j--) {  //column
				if (board[i][j] == board[i][j - 1] && board[i][j] != 0) {
					board[i][j] = board[i][j] + board[i][j - 1];
					board[i][j - 1] = 0;
					score += board[i][j];
				}
			}
		}
	}
	
	private static void add_up() {
		for (int i = 0; i < SIZE; i++) {   //each column
			for (int j = 0; j < SIZE - 1; j++) {  //row
				if (board[j][i] == board[j + 1][i] && board[j][i] != 0) {
					board[j][i] = board[j][i] + board[j + 1][i];
					board[j + 1][i] = 0;
					score += board[j][i];
				}
			}
		}
	}
	
	private static void add_down() {
		for (int i = 0; i < SIZE; i++) {   //each column
			for (int j = SIZE - 1; j > 0; j--) {  //row
				if (board[j][i] == board[j - 1][i] && board[j][i] != 0) {
					board[j][i] = board[j][i] + board[j - 1][i];
					board[j - 1][i] = 0;
					score += board[j][i];
				}
			}
		}
	}

	private static void random_place() {
		boolean NotPlaced = true;
		while (NotPlaced) {
			int x = random_coord();
			int y = random_coord();
			if (board[x][y] == 0) {
				board[x][y] = random_num();
				NotPlaced = false;
			}
		}
	}

	private static int random_coord() {
		double num = Math.random();
		
		if (num < 0.25) return 0;
		else if (num < 0.5) return 1;
		else if (num < 0.75) return 2;
		else return 3;
		
	}
	
	private static int random_num() {
		double num = Math.random();
		
		if (num < 0.2) return BASE*BASE;   //20% chance that 4 will occur
		else return BASE;
	}
}