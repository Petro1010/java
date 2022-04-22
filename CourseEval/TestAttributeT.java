/**
 * Author: Mathew Petornilho, Petronim
 * Revised: March 16, 2021
 * 
 * Description: Testing of the AttributeT module
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TestAttributeT
{
	private AttributeT test1;
	private AttributeT test2;
	private AttributeT test3;

	@Before
	public void setUp(){
		test1 = new AttributeT("Test 1", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt});
		test2 = new AttributeT("Test 2", new IndicatorT[] {});
		test3 = new AttributeT("Test 3", new IndicatorT[] {IndicatorT.desPrinciples, IndicatorT.desPrinciples, IndicatorT.desPrinciples, IndicatorT.engInSoc});
	}

	@After
	public void tearDown(){
		test1 = null;
		test2 = null;
		test3 = null;
	}

    @Test
    public void testGetName1()
    {
        assertTrue(test1.getName() == "Test 1");
    }

    @Test
    public void testGetName2()
    {
        assertTrue(test2.getName() == "Test 2");
    }

    @Test
    public void testGetName3()
    {
        assertTrue(test3.getName() == "Test 3");
    }

    @Test
    public void testGetInd1()
    {	IndicatorT[] s = {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        assertTrue(arrayEquality(s, test1.getIndicators()));

    }

    @Test
    public void testGetInd2()
    {	IndicatorT[] s = {};
        assertTrue(arrayEquality(s, test2.getIndicators()));

    }

    @Test
    public void testGetInd3()
    {	IndicatorT[] s = {IndicatorT.desPrinciples, IndicatorT.engInSoc};
        assertTrue(arrayEquality(s, test3.getIndicators()));

    }

    //Based off https://stackoverflow.com/questions/10154305/java-checking-equality-of-arrays-order-doesnt-matter
    private static boolean arrayEquality(IndicatorT[] s, IndicatorT[] y){
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




}
