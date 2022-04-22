/**
 * Author: Mathew Petronilho, Petronim
 * Revised: March 16, 2021
 * 
 * Description: Test cases for ProgramT module
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.lang.Math;

public class TestProgramT
{	private ProgramT test;
	private AttributeT s;
	
	@Before
	public void setUp(){
	   IndicatorT[] class1_indicators = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt, IndicatorT.suitableFund};
       IndicatorT[] class2_indicators = new IndicatorT[] {IndicatorT.math};
       IndicatorT[] class3_indicators = new IndicatorT[] {IndicatorT.standards, IndicatorT.healthSafety};

       CourseT class1 = new CourseT("Class1", class1_indicators);
	   CourseT class2 = new CourseT("Class2", class2_indicators);
       CourseT class3 = new CourseT("Class3", class3_indicators);

       class1.addLO(IndicatorT.specEngKnow, new LOsT("SpecEng1", 50, 50, 50, 50));
       class1.addLO(IndicatorT.assumpt, new LOsT("Assumpt1", 20, 10, 80, 90));
       class1.addLO(IndicatorT.suitableFund, new LOsT("Fund1", 60, 90, 40, 10));
       class1.addLO(IndicatorT.specEngKnow, new LOsT("SpecEng2", 70, 50, 30, 50));
       class2.addLO(IndicatorT.math, new LOsT("Math1", 100, 40, 20, 40));
       class2.addLO(IndicatorT.math, new LOsT("Math2", 10, 150, 20, 20));      
       class2.addLO(IndicatorT.math, new LOsT("Math3", 90, 10, 160, 140));
       class3.addLO(IndicatorT.standards, new LOsT("Standards1", 200, 80, 100, 10));      
       class3.addLO(IndicatorT.healthSafety, new LOsT("HandS1", 0, 20, 90, 20));
       class3.addLO(IndicatorT.healthSafety, new LOsT("HandS2", 0, 50, 5, 30));
       class3.addLO(IndicatorT.healthSafety, new LOsT("HandS3", 0, 50, 5, 140));

       test = new ProgramT();
       test.add(class1);
       test.add(class2);
       test.add(class3);

       s = new AttributeT("Attribute1", new IndicatorT[] {IndicatorT.math, IndicatorT.assumpt,
                                                                      IndicatorT.specEngKnow, IndicatorT.suitableFund,
                                                                      IndicatorT.healthSafety, IndicatorT.standards});
	}

	@After
	public void tearDown(){
		test = null;
	}

	@Test (expected=UnsupportedOperationException.class)
    public void testMeasure1(){
    	test.measures();
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testMeasure2(){
    	test.measures(IndicatorT.math);
    }	

    @Test
    public void testMeasure3(){
    	assertTrue(arrayEquality(test.measures(s), new double[] {0.25, 0.25, 0.25, 0.25}));
    }

    @Test
    public void testMeasure4(){
    	Norm.setNorms(false, false, true);
    	assertTrue(arrayEquality(test.measures(s), new double[] {0.25, 0.25, 0.25, 0.25}));
    	Norm.setNorms(false, false, false);
    }

    @Test
    public void testMeasure5(){
    	Norm.setNorms(false, true, true);
    	assertTrue(arrayEquality(test.measures(s), new double[] {0.25, 0.25, 0.25, 0.25}));
    	Norm.setNorms(false, false, false);
    }

    @Test
    public void testMeasure6(){
    	Norm.setNorms(true, true, true);
    	assertTrue(arrayEquality(test.measures(s), new double[] {0.25, 0.28, 0.24, 0.23}));
    	Norm.setNorms(false, false, false);
    }

    private static boolean arrayEquality(double[] s, double[] y){
    	if (s.length != y.length){
    		return false;
    	}
    	main_loop:
    	for (int i = 0; i < s.length; i++){
    		for (int j = 0; j < y.length; j++){
    			if (Math.abs(s[i] - y[j]) < 0.01){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	main_loop:
    	for (int i = 0; i < y.length; i++){
    		for (int j = 0; j < s.length; j++){
    			if (Math.abs(s[i] - y[j]) < 0.01){
    				break main_loop;
    			}
    		}
    		return false;
    	}

    	return true;
    }

}
