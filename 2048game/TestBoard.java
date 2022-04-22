/**
 * Author: Mathew Petornilho, Petronim
 * Revised: April 6, 2021
 * 
 * Description: Testing of the Board module
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TestBoard{
	private static int[][] test1;
	private static int[][] test2;
	private static int[][] test3;
	private static int[][] test4;

	@Before
	public void setUp(){
		int[][] test11 = {{8,2,4,16}, {0,0,2,4}, {0,0,0,64}, {0,0,0,0}};
		int[][] test22 = {{4,0,0,0}, {2,64,0,0}, {8,16,4,0}, {32,4,2,0}};  
		int[][] test33 = {{256,2,4,4}, {256,8,16,0}, {32,0,32,0}, {2,4,0,4}};
		int[][] test44 = {{4,4,4,4}, {4,4,4,4}, {4,4,4,4}, {4,4,4,4}};
		test1 = test11;
		test2 = test22;
		test3 = test33;
		test4 = test44;
	}

	@After
	public void tearDown(){
		test1 = null;
		test2 = null;
		test3 = null;
	}

	@Test
	public void testGetScore(){
		Board.init(test1);
		assertEquals(0, Board.get_score());
	}

	@Test
	public void testGetBoard(){
		Board.init(test1);
		int[][] expected = {{8,2,4,16}, {0,0,2,4}, {0,0,0,64}, {0,0,0,0}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUpdate1(){
		Board.init(test1);
		Board.update_board(MoveType.R);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUpdate2(){
		Board.init(test1);
		Board.update_board(MoveType.U);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUpdate3(){
		Board.init(test2);
		Board.update_board(MoveType.L);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testUpdate4(){
		Board.init(test2);
		Board.update_board(MoveType.D);
	}

	@Test
	public void testUpdate5(){
		Board.init(test3);
		Board.update_board(MoveType.L);
		int[][] expected = {{256,2,8,0}, {256,8,16,0}, {64,0,0,0}, {2,8,0,0}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
		//assertEquals(Board.get_score(), 80);
	}

	@Test
	public void testUpdate6(){
		Board.init(test3);
		Board.update_board(MoveType.R);
		int[][] expected = {{0,256,2,8}, {0,256,8,16}, {0,0,0,64}, {0,0,2,8}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
		//assertEqual(Board.get_score(), 80);
	}

	@Test
	public void testUpdate7(){
		Board.init(test3);
		Board.update_board(MoveType.U);
		int[][] expected = {{512,2,4,8}, {32,8,16,0}, {2,4,32,0}, {0,0,0,0}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
		//assertEqual(Board.get_score(), 520);
	}

	@Test
	public void testUpdate8(){
		Board.init(test3);
		Board.update_board(MoveType.D);
		int[][] expected = {{0,0,0,0}, {512,2,4,0}, {32,8,16,0}, {2,4,32,8}} ;
		assertTrue(array_2D_equal(Board.get_board(), expected));
		//assertEqual(Board.get_score(), 520);
	}

	@Test
	public void testUpdate9(){
		Board.init(test3);
		Board.update_board(MoveType.L);
		int[][] expected = {{256,2,8,0}, {256,8,16,0}, {64,0,0,0}, {2,8,0,0}};
		//assertTrue(array_2D_close(Board.get_board(), expected));
		assertEquals(Board.get_score(), 80);
	}

	@Test
	public void testUpdate10(){
		Board.init(test3);
		Board.update_board(MoveType.R);
		int[][] expected = {{0,256,2,8}, {0,256,8,16}, {0,0,0,64}, {0,0,2,8}};
		//assertTrue(array_2D_close(Board.get_board(), expected));
		assertEquals(Board.get_score(), 80);
	}

	@Test
	public void testUpdate11(){
		Board.init(test3);
		Board.update_board(MoveType.U);
		int[][] expected = {{512,2,4,8}, {32,8,16,0}, {2,4,32,0}, {0,0,0,0}};
		//assertTrue(array_2D_close(Board.get_board(), expected));
		assertEquals(Board.get_score(), 520);
	}

	@Test
	public void testUpdate12(){
		Board.init(test3);
		Board.update_board(MoveType.D);
		int[][] expected = {{0,0,0,0}, {512,2,4,0}, {32,8,16,0}, {2,4,32,8}} ;
		//assertTrue(array_2D_close(Board.get_board(), expected));
		assertEquals(Board.get_score(), 520);
	}

	@Test
	public void testUpdate13(){
		Board.init(test4);
		Board.update_board(MoveType.L);
		int[][] expected = {{8,8,0,0}, {8,8,0,0}, {8,8,0,0}, {8,8,0,0}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
	}

	@Test
	public void testUpdate14(){
		Board.init(test4);
		Board.update_board(MoveType.R);
		int[][] expected = {{0,0,8,8}, {0,0,8,8}, {0,0,8,8}, {0,0,8,8}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
	}

	@Test
	public void testUpdate15(){
		Board.init(test4);
		Board.update_board(MoveType.U);
		int[][] expected = {{8,8,8,8}, {8,8,8,8}, {0,0,0,0}, {0,0,0,0}};
		assertTrue(array_2D_equal(Board.get_board(), expected));
	}

	@Test
	public void testUpdate16(){
		Board.init(test4);
		Board.update_board(MoveType.D);
		int[][] expected = {{0,0,0,0}, {0,0,0,0}, {8,8,8,8}, {8,8,8,8}} ;
		assertTrue(array_2D_equal(Board.get_board(), expected));
	}

	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testRand1(){
		Board.init(test4);
		Board.update_random();
	}

	@Test
	public void testRand2(){
		Board.init(test3);
		Board.update_random();
		int[][] closeExpected = {{256,2,4,4}, {256,8,16,0}, {32,0,32,0}, {2,4,0,4}};
		assertTrue(array_2D_close(closeExpected, Board.get_board()));
	}

	@Test
	public void testMove(){
		Board.init(test3);
		Board.make_move(MoveType.L);
		int[][] expected = {{256,2,8,0}, {256,8,16,0}, {64,0,0,0}, {2,8,0,0}};
		assertTrue(array_2D_close(Board.get_board(), expected));
	}

	@Test
	public void testValidMove1(){
		int[][] test = {{2,128,4,2}, {4,8,16,4}, {8,4,8,2}, {64,32,2,4}};
		Board.init(test);
		assertFalse(Board.is_any_valid_move());
	}

	@Test
	public void testValidMove2(){
		int[][] test = {{2,128,4,2}, {2,8,16,4}, {8,4,8,2}, {64,32,2,4}};
		Board.init(test);
		assertTrue(Board.is_any_valid_move());
	}

	@Test
	public void testValidMove3(){
		int[][] test = {{2,0,0,0}, {4,8,16,4}, {8,4,8,2}, {64,32,2,4}};
		Board.init(test);
		assertTrue(Board.is_any_valid_move());
	}

	@Test
	public void testWon1(){
		int[][] test = {{2,2048,4,2}, {4,8,16,4}, {8,4,8,2}, {64,32,2,4}};
		Board.init(test);
		assertTrue(Board.is_game_won());
	}

	@Test
	public void testWon2(){
		int[][] test = {{2,2,4,2}, {4,8,16,4}, {8,4,8,2}, {64,32,2,4}};
		Board.init(test);
		assertFalse(Board.is_game_won());
	}

	@Test
	public void testWon3(){
		int[][] test = {{0,2048,4,2}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		Board.init(test);
		assertTrue(Board.is_game_won());
	}

	private static boolean array_2D_equal(int[][] arr1, int[][] arr2){
		for (int i = 0; i < arr1[0].length; i++){
			for (int j= 0; j < arr1[0].length; j++){
				if (arr1[i][j] == arr2[i][j]){
					continue;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}

	private static boolean array_2D_close(int[][] arr1, int[][] arr2){
		int wrong = 0;   // there can only be one tile off, which will be the randomly generated tile
		for (int i = 0; i < arr1[0].length; i++){
			for (int j= 0; j < arr1[0].length; j++){
				if (arr1[i][j] == arr2[i][j]){
					continue;
				}
				else if (wrong == 0){
					wrong++;
					continue;
				}
				else{
					return false;
				}
			}
		}
		if (wrong == 1){   //should be exactly one wrong
			return true;
		}
		return false;
	}

}