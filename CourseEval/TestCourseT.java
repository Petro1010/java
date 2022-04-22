/**
 * Author: Mathew Petronilho
 * Revised: March 16, 2021
 * 
 * Description: Test cases for CourseT module
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestCourseT
{
	private CourseT test1;
	private CourseT test2;
	private CourseT test3;

	@Before
	public void setUp(){
		IndicatorT[] test1_indicators = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt,
                                                      IndicatorT.suitableFund};
       IndicatorT[] test2_indicators = new IndicatorT[] {};
       IndicatorT[] test3_indicators = new IndicatorT[] {IndicatorT.standards, IndicatorT.standards, IndicatorT.standards, IndicatorT.healthSafety};

       test1 = new CourseT("Course1", test1_indicators);
       test2 = new CourseT("Course2", test2_indicators);
       test3 = new CourseT("Course3", test3_indicators);
	}

	@After
	public void tearDown(){
		test1 = null;
		test2 = null;
		test3 = null;
	}

	@Test
    public void test1GetName()
    {
        assertEquals(test1.getName(), "Course1");
    }

    @Test
    public void test2GetName()
    {
        assertEquals(test2.getName(), "Course2");
    }

    @Test
    public void test3GetName()
    {
        assertEquals(test3.getName(), "Course3");
    }

    @Test
    public void testGetInd1()
    {	IndicatorT[] s = {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt, IndicatorT.suitableFund};
        assertTrue(arrayEquality2(s, test1.getIndicators()));

    }

    @Test
    public void testGetInd2()
    {	IndicatorT[] s = {};
        assertTrue(arrayEquality2(s, test2.getIndicators()));

    }

    @Test
    public void testGetInd3()
    {	IndicatorT[] s = {IndicatorT.standards, IndicatorT.healthSafety};
        assertTrue(arrayEquality2(s, test3.getIndicators()));

    }

    @Test
    public void testAdd_GetLOs1()
    {	LOsT LO1 = new LOsT("topic 1", 20, 40, 60, 80);
    	test1.addLO(IndicatorT.math, LO1);
    	test1.addLO(IndicatorT.math, LO1);
        assertTrue(arrayEquality1(test1.getLOs(IndicatorT.math), new LOsT[] {LO1}));

    }

    @Test
    public void testAdd_GetLOs2()
    {	LOsT LO1 = new LOsT("topic 2", 20, 40, 60, 80);
    	test2.addLO(IndicatorT.math, LO1);
        assertTrue(arrayEquality1(test2.getLOs(IndicatorT.math), new LOsT[] {}));

    }

    @Test
    public void testDel_GetLOs1()
    {	LOsT LO1 = new LOsT("topic 1", 20, 40, 60, 80);
    	test1.addLO(IndicatorT.math, LO1);
    	test1.delLO(IndicatorT.math, LO1);
        assertTrue(arrayEquality1(test1.getLOs(IndicatorT.math), new LOsT[] {}));

    }

    @Test
    public void testDel_GetLOs2()
    {	LOsT LO1 = new LOsT("topic 2", 20, 40, 60, 80);
    	LOsT ZIP = new LOsT("nada", 3, 4, 5, 6);
    	test1.addLO(IndicatorT.assumpt, LO1);
    	test1.delLO(IndicatorT.assumpt, ZIP);
        assertTrue(arrayEquality1(test1.getLOs(IndicatorT.assumpt), new LOsT[] {LO1}));

    }

    @Test
    public void testMember1()
    {	LOsT LO1 = new LOsT("topic 2", 20, 40, 60, 80);
    	LOsT ZIP = new LOsT("nada", 3, 4, 5, 6);
    	test1.addLO(IndicatorT.assumpt, LO1);
    	test1.addLO(IndicatorT.assumpt, ZIP);
        assertFalse(test1.member(IndicatorT.math, new LOsT[] {LO1}));

    }

    @Test
    public void testMember2()
    {	LOsT LO1 = new LOsT("topic 2", 20, 40, 60, 80);
    	LOsT ZIP = new LOsT("nada", 3, 4, 5, 6);
    	LOsT LO2 = new LOsT("a", 1, 0, 0, 0);
    	test1.addLO(IndicatorT.assumpt, LO1);
    	test1.addLO(IndicatorT.assumpt, ZIP);
    	test1.addLO(IndicatorT.math, LO2);
        assertFalse(test1.member(IndicatorT.assumpt, new LOsT[] {LO1, ZIP, LO2}));

    }

    @Test (expected=UnsupportedOperationException.class)
    public void testMeasure1(){
    	test1.measures();
    }

    @Test
    public void testMeasure2(){
    	LOsT LO1 = new LOsT("topic 2", 20, 40, 60, 80);
    	LOsT ZIP = new LOsT("nada", 3, 4, 5, 6);
    	test1.addLO(IndicatorT.assumpt, LO1);
    	test1.addLO(IndicatorT.assumpt, ZIP);
    	assertTrue(arrayEquality3(test1.measures(IndicatorT.assumpt), new double[] {23, 44, 65, 86}));
    }

    @Test
    public void testMeasure3(){
    	AttributeT s = new AttributeT("Hello", new IndicatorT[] {});
    	assertTrue(arrayEquality3(test1.measures(s), new double[] {0, 0, 0, 0}));
    }



    //Based off https://stackoverflow.com/questions/10154305/java-checking-equality-of-arrays-order-doesnt-matter
    private static boolean arrayEquality1(LOsT[] s, LOsT[] y){
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

    private static boolean arrayEquality2(IndicatorT[] s, IndicatorT[] y){
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

    private static boolean arrayEquality3(double[] s, double[] y){
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
