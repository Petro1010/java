/**
   Author: Mathew Petronilho, Petronim
   Revised: March 17, 2021

   Description: Course ADT class that manages learning objectives
*/
package src;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @brief An ADT that represents a course
 * @details A course it represented by its name and the learning objectives associated with its indicators
 */
public class CourseT implements Measures{
	private String name;
	private HashMap<IndicatorT, HashSet<LOsT>> m;
	
	/**
	 * @brief Initializes a course object
	 * @param courseName Name of the course
	 * @param indicators Indicators that the course include
	 */
	public CourseT(String courseName, IndicatorT[] indicators) {
		name = courseName;
		m = new HashMap<IndicatorT, HashSet<LOsT>>();
		
		for (IndicatorT i : indicators) { 
			m.put(i, new HashSet<LOsT>());
		}
		
	}
	
	/**
	 * @brief Gets the course name
	 * @return Name of the course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @brief Gets a sequence of indicators
	 * @return The sequence of all the indicators in the map state variable
	 */
	public IndicatorT[] getIndicators() {
		IndicatorT[] seq = new IndicatorT[m.size()];
		int i = 0;
		for (IndicatorT h : m.keySet()) {
			seq[i] = h;
			i++;
		}
		return seq;
	}
	
	/**
	 * @brief Gets a sequence of the learning objectives associated with an indicator
	 * @details If the indicator is not present, I assumed to return an empty array
	 * @param indicator A specific IndicatorT value
	 * @return A sequence of the learning objectives that are related to an indicator
	 */
	public LOsT[] getLOs(IndicatorT indicator) {
		if (!m.containsKey(indicator)){
			return new LOsT[0];
		}
		LOsT[] seq = new LOsT[m.get(indicator).size()];
		int i = 0;
		for (LOsT h : m.get(indicator)) {
			seq[i] = h;
			i++;
		}
		return seq;
	}
	
	/**
	 * @brief Adds a learning objective to a specific indicator
	 * @param indicator A specific IndicatorT value
	 * @param outcome The specific learning outcome to be added
	 */
	public void addLO(IndicatorT indicator, LOsT outcome) {
		if (m.containsKey(indicator)) {
			m.get(indicator).add(outcome);
		}
		else return;
	}
	
	/**
	 * @brief Deletes a learning objective of a specific indicator
	 * @param indicator A specific IndicatorT value
	 * @param outcome The specific learning outcome to be deleted
	 */
	public void delLO(IndicatorT indicator, LOsT outcome) {
		if (m.containsKey(indicator)) {
			m.get(indicator).remove(outcome);
		}
		else return;
	}
	
	/**
	 * @brief Determines if a course indicator has specific learning outcomes associated with it
	 * @param indicator A specific IndicatorT value
	 * @param outcomes The learning objectives that should be associated with the indicator
	 * @return Value representing if the indicator is present and has all expected learning objectives
	 */
	public boolean member(IndicatorT indicator, LOsT[] outcomes) {
		if (m.containsKey(indicator)) {
			for (LOsT i : outcomes) {
				if (m.get(indicator).contains(i)){
					continue;
				}
				else return false;
			}
			
			return true;
		}
		else return false;
	}
	
	/**
	  @brief Measures how well a learning objective is met
	  @details The entries in the output sequence correspond to: below expectations, marginal, meets expectations, exceeds expectations
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures() {
		throw new UnsupportedOperationException("Does not support this operation");
	}
	
	/**
	  @brief Measures how well a learning objective is met
	  @details The entries in the output sequence correspond to: below expectations, marginal, meets expectations, exceeds expectations
	  @param ind Indicator on which measurement is based
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures(IndicatorT ind) {
		if (this.getLOs(ind).length == 0) {
			double[] empty = {0, 0, 0, 0};
			return empty;
		}
		else {
			double[] start = {0, 0, 0, 0};
			for (LOsT o : m.get(ind)) {
				start = sumMeas(start, o.measures());
			}
			if (Norm.getNInd()) {
				return Services.normal(start);
			}
			else {
				return start;
			}
		}
	}
	
	/**
	  @brief Measures how well a learning objective is met
	  @details The entries in the output sequence correspond to: below expectations, marginal, meets expectations, exceeds expectations
	  @param att Attribute on which measurement is based
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures(AttributeT att) {
		if (att.getIndicators().length == 0) {
			double[] empty = {0, 0, 0, 0};
			return empty;
		}
		else {
			double[] start = {0, 0, 0, 0};
			for (IndicatorT i : att.getIndicators()) {
				start = sumMeas(start, this.measures(i));
			}
			if (Norm.getNAtt()) {
				return Services.normal(start);
			}
			else {
				return start;
			}
		}
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
