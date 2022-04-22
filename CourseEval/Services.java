/**
   Author: Mathew Petronilho, Petronim
   Revised: March 14, 2021

   Description: Calculates normal of a sequence
*/
package src;

/**
   @brief An library that provides the normal method
*/
public class Services{


	/**
	  @brief Calculates the normal of a sequence
	  @param v A sequence of real numbers
	  @return A sequence of real numbers that represent the norm
	*/
	public static double[] normal(double[] v){
		double[] norm = new double[v.length];

		double sum = 0;
		for (double j : v) {
			sum = sum + j; 
		}
		int i = 0;
		for (double j : v) {
			norm[i] = j / sum;
			i++;
		}
		return norm;
	}

}
