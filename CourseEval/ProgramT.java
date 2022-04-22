/**
   Author: Mathew Petronilho, Petronim
   Revised: March 17, 2021

   Description: Program ADT that holds different courses
*/
package src;

import java.util.HashSet;

/**
 * @brief An ADT that represents a program and its courses
 */
public class ProgramT extends HashSet<CourseT> implements Measures {
	
	/**
	  @brief Initializes a ProgramT object
	  @details Extends the HashSet<CourseT> object, using its constructor
	*/
	public ProgramT() {
		super();
	}
	
	/**
	  @brief Measures how well an objective is met
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures() {
		throw new UnsupportedOperationException("Does not support this operation");
	}
	
	/**
	  @brief Measures how well an objective is met
	  @param ind Indicator on which measurement is based
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures(IndicatorT ind) {
		throw new UnsupportedOperationException("Does not support this operation");
	}
	
	/**
	  @brief Measures how well an objective is met
	  @param att Attribute on which measurement is based
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures(AttributeT att) {
		double[] start = {0, 0, 0, 0};
		for (CourseT c : this) {
			start = sumMeas(start, c.measures(att));
		}
		return Services.normal(start);
	}
	
	/**
	 * @brief Takes the sum of 2 sequences
	 * @details Add the values at a particular index of each sequence. Assume sequences have same length.
	 * @param a A sequence of doubles
	 * @param b A sequence of doubles
	 * @return The sum of these sequences
	 */
	private double[] sumMeas(double[] a, double[] b) {
		double[] sum = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			sum[i] = a[i] + b[i];
		}
		return sum;
	}
}