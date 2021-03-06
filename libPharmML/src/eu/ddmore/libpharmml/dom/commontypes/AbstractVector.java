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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Abstract class for common properties of vectors
 * @author F. Yvon
 *
 */
@XmlTransient
public abstract class AbstractVector extends PharmMLRootType {
	
	@XmlElement(name = "VectorElements")
    protected VectorElements vectorElements;
	
	@XmlAttribute(name = "default")
	protected Double defaultValue;
	
	/**
	 * Gets the value of the vectorElements property.
	 * @return A {@link VectorElements} instance.
	 */
	public VectorElements getVectorElements(){
		return this.vectorElements;
	}
	
	/**
	 * Sets the value of the vectorElements property.
	 * @param vectorElements The new value
	 */
	public void setVectorElements(VectorElements vectorElements){
		this.vectorElements = vectorElements;
	}
	
	/**
	 * Gets the default value of the vector, which is the value of en element that is not
	 * explicitly specified in the vector.
	 * @return The default real value
	 */
	public Double getDefaultValue(){
    	return this.defaultValue;
    }
    
	/**
	 * Sets the default value of the vector, which is the value of en element that is not
	 * explicitly specified in the vector.
	 * @param value The new real value
	 */
    public void setDefaultValue(double value){
    	this.defaultValue = value;
    }
    
    /**
	 * Sets the default value of the vector, which is the value of en element that is not
	 * explicitly specified in the vector. As the default type of the value is {@link Double},
	 * the provided argument will be casted to double.
	 * @param value The new integer value
	 */
    public void setDefaultValue(int value){
    	this.defaultValue = (double) value;
    }
    
    /**
     * Creates an empty {@link VectorElements} object, adds it to this vector and returns it.
     * @return The created {@link VectorElements} object.
     */
	public VectorElements createVectorElements(){
		this.vectorElements = new VectorElements();
		return this.vectorElements;
	}
	
	/**
     * Creates a {@link VectorElements} object with the given values, adds it to this vector and returns it.
     * @param values An array of values.
     * @return The created {@link VectorElements} object.
     */
	public VectorElements createVectorElements(VectorValue[] values){
		this.vectorElements = new VectorElements(values);
		return this.vectorElements;
	}

}
