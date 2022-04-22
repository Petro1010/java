/**
   
   Author: Mathew Petronilho, Petronim
   Revised: March 12, 2021

   Description: Measures interface
*/

package src;

/**
   @brief An interface that reperesents different measurements
*/
public interface Measures{

	public double[] measures() throws UnsupportedOperationException;
	public double[] measures(IndicatorT ind) throws UnsupportedOperationException;
	public double[] measures(AttributeT att) throws UnsupportedOperationException;
}
