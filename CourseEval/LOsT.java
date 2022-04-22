/**
   Author: Mathew Petronilho, Petronim
   Revised: March 14, 2021

   Description: Learning objectives ADT
*/
package src;


/**
   @brief An ADT that represents how well a learning objective is being met
*/
public class LOsT implements Measures{
	private String name;
	private int n_blw;
	private int n_mrg;
	private int n_mts;
	private int n_exc;

	/**
	  @brief Initializes an LOsT object
	  @param topic Specific topic of the learning objective
	  @param nblw Number of times it is below
	  @param nmrg Number of times it is marginally met
	  @param nmts Number of times it is met
	  @param nexc Number of times it is exceeded
	*/
	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {
		if (nblw < 0 || nmrg < 0 || nmts < 0 || nexc < 0 || (nblw == 0 && nmrg == 0 && nmts == 0 && nexc == 0)) {
			throw new IllegalArgumentException("Values inputted are not all above 0 or are all 0");
		}
		name = topic;
		n_blw = nblw;
		n_mrg = nmrg;
		n_mts = nmts;
		n_exc = nexc;
		
	}
	
	/**
	  @brief Gets the name of the learning objective
	  @return The name of the learning objective
	*/
	public String getName() {
		return name;
	}
	
	/**
	  @brief Tests equality of two learning outcomes
	  @param o Learning objective to be compared
	  @return Boolean representing if they are equal or not
	*/
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof LOsT)) return false;
		
		LOsT v = (LOsT) o;
		return v.getName() == this.name;
		
	}
	
	/**
	  @brief Creates hashcode for object
	  @return Number that represents hash code of object
	*/
	@Override
	public int hashCode() {
		int num = 0;
		for (int i = 0; i < name.length(); i++){
			num = num + (int) name.charAt(i) * i;
		}
		return num;
	}
	
	/**
	  @brief Measures how well an objective is met
	  @return Array with numbers representing a measurement of performance
	*/
	public double[] measures() {
		double[] n = {n_blw, n_mrg, n_mts, n_exc};
		if (!Norm.getNLOs()){
			return n;
		}
		else {
			return Services.normal(n);
		}
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
		throw new UnsupportedOperationException("Does not support this operation");
	}
	

}