/**
 * Author: Mathew Petronilho, Petronim
 * Revised: March 16, 2021
 * 
 * Description: Test cases for LOsT module
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TestLOsT
{

    private LOsT test1;
	private LOsT test2;

	@Before
	public void setUp(){
       test1 = new LOsT("Topic1", 22, 44, 33, 55);
       test2 = new LOsT("Topic2", 10, 10, 10, 10);
	}

	@After
	public void tearDown(){
		test1 = null;
		test2 = null;
	}

	@Test (expected=IllegalArgumentException.class)
    public void testConstruct1(){
    	LOsT s = new LOsT("Hello", 0, 0, 0, 0);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testConstruct2(){
    	LOsT s = new LOsT("Hello", 0, 0, 0, -5);
    }

    @Test
    public void test1GetName()
    {
        assertEquals(test1.getName(), "Topic1");
    }

    @Test
    public void test2GetName()
    {
        assertEquals(test2.getName(), "Topic2");
    }

    @Test
    public void test1Equals()
    {   LOsT s = new LOsT("Topic1", 77, 88, 22, 44);
        assertTrue(test1.equals(s));
    }

    @Test
    public void test2Equals()
    {   LOsT s = new LOsT("Topic3", 10, 10, 10, 10);
        assertFalse(test2.equals(s));
    }

    @Test
    public void testMeasure1(){
    	assertTrue(arrayEquality2(test1.measures(), new double[] {22, 44, 33, 55}));
    }

    @Test
    public void testMeasure2(){
    	Norm.setNorms(true, true, true);
    	assertTrue(arrayEquality2(test2.measures(), new double[] {0.25, 0.25, 0.25, 0.25}));
    	Norm.setNorms(false, false, false);
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testMeasure3(){
    	test1.measures(IndicatorT.math);
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testMeasure4(){
    	test1.measures(new AttributeT("Test 2", new IndicatorT[] {}));
    }

    //Based off https://stackoverflow.com/questions/10154305/java-checking-equality-of-arrays-order-doesnt-matter
    private static boolean arrayEquality(LOsT[] s, LOsT[] y){
    	if (s.length != y.length){
    		return false;
    	}
    	main_loop:
    	for (int i = 0; i < s.length; i++){
    		for (int j = 0; j < y.length; j++){
    			if (s[i].equals(y[j])){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	main_loop:
    	for (int i = 0; i < y.length; i++){
    		for (int j = 0; j < s.length; j++){
    			if (y[i].equals(s[j])){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	return true;
    }

    private static boolean arrayEquality2(double[] s, double[] y){
    	if (s.length != y.length){
    		return false;
    	}
    	main_loop:
    	for (int i = 0; i < s.length; i++){
    		for (int j = 0; j < y.length; j++){
    			if (s[i] == y[j]){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	main_loop:
    	for (int i = 0; i < y.length; i++){
    		for (int j = 0; j < s.length; j++){
    			if (y[i] == s[j]){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	return true;
    }

}
