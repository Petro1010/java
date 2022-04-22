/**
   Author: Mathew Petronilho, Petronim
   Revised: March 14, 2021

   Description: Sets boolean for norms
*/
package src;

/**
   @brief An abstract object that sets whether a norm is true or false
*/
public class Norm{

	private static boolean normLOs;
	private static boolean normInd;
	private static boolean normAtt;
	
	/**
	  @brief Sets the status of all the norm types
	  @param nLOs status of normLOS
	  @param nInd status of normInd
	  @param nAtt status of normAtt
	*/
	public static void setNorms(boolean nLOs, boolean nInd, boolean nAtt){
		normLOs = nLOs;
		normInd = nInd;
		normAtt = nAtt;
		
	}

	/**
	  @brief Gets the status of normLOs
	  @return Boolean representing normLOs
	*/
	public static boolean getNLOs() {
		return normLOs;
	}
	
	/**
	  @brief Gets the status of normInd
	  @return Boolean representing normInd
	*/
	public static boolean getNInd() {
		return normInd;
	}
	
	/**
	  @brief Gets the status of normAtt
	  @return Boolean representing normAtt
	*/
	public static boolean getNAtt() {
		return normAtt;
	}

	/**
	  @brief Sets the status of normLOs
	  @param nLOs New status of normLOS
	*/
	public static void setNLOs(boolean nLOs) {
		normLOs = nLOs;
	}
	
	/**
	  @brief Sets the status of normInd
	  @param nInd New status of normINd
	*/
	public static void setNInd(boolean nInd) {
		normInd = nInd;
	}
	
	/**
	  @brief Sets the status of normAtt
	  @param nAtt New status of normAtt
	*/
	public static void setNAtt(boolean nAtt) {
		normAtt = nAtt;
	}

}