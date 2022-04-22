/**
   
   Author: Mathew Petronilho, Petronim
   Revised: March 12, 2021

   Description: Attribute ADT class
*/

package src;

import java.util.HashSet;

/**
   @brief An ADT that represents an attribute that has a set of indicators
*/
public class AttributeT{

	private String name;
	private HashSet<IndicatorT> s;

	/**
	  @brief Initializes an AttributeT object
	  @param name Specific name of the attribute being looked at
	  @param s A sequence of indicators that describe this attribute
	*/
	public AttributeT(String name, IndicatorT[] s){
		this.name = name;
		
		HashSet<IndicatorT> set = new HashSet<IndicatorT>();
		for (IndicatorT i : s) {
			set.add(i);
		}
		this.s = set;
	}

	/**
	  @brief Gets the name of the attribute
	  @return The name of the attribute
	*/
	public String getName(){
		return name;
	}

    /**
	  @brief Gets the indicators of the attribute
	  @return A sequence of the indicators of the attribute
	*/
	public IndicatorT[] getIndicators(){
		IndicatorT[] seq = new IndicatorT[s.size()];
		int i = 0;
		for (IndicatorT h : s) {
			seq[i] = h;
			i++;
		}
		return seq;
	}
}