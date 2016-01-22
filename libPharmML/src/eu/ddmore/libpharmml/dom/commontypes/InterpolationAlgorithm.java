/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.dom.commontypes;

/**
 * Enumeration defining the possible algorithms of interpolation.
 * 
 * @since PharmML 0.7
 */
public enum InterpolationAlgorithm {
	
	/**
	 * Constant interpolation
	 */
	CONSTANT("constant"),
	/**
	 * Nearest-neighbor interpolation
	 */
	NEAREST("nearest"),
	/**
	 * Linear interpolation
	 */
	LINEAR("linear"),
	/**
	 * Spline interpolation
	 */
	SPLINE("spline"),
	/**
	 * Piecewise Cubic Hermite Interpolating Polynomial interpolation
	 */
	PCHIP("pchip"),
	/**
	 * Cubic Polynomial interpolation
	 */
	CUBIC("cubic"),
	/**
	 * Last value interpolation
	 */
	LASTVALUE("lastValue");
	
	private String value;
	
	private InterpolationAlgorithm(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
	
	public static boolean contains(String value){
		for(InterpolationAlgorithm item : values()){
			if(item.value().equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public InterpolationAlgorithm fromValue(String value){
		for(InterpolationAlgorithm item : values()){
			if(item.value().equals(value)){
				return item;
			}
		}
		throw new IllegalArgumentException("Unknown enum type \""+value+"\".");
	}

}
