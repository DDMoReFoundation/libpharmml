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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.PharmMLNode;
import eu.ddmore.libpharmml.dom.tags.MathExpression;

/**
 * Interface for object types that can be used as a value within a vector or a matrix.
 * @author F. Yvon
 *
 */
@XmlJavaTypeAdapter(VectorValueAdapter.class)
public interface VectorValue extends PharmMLNode, MathExpression {

	/**
	 * Gets a human readable representation of the value.
	 * @return The vector value as a {@link String}.
	 */
	public String asString();
	
	/**
	 * Creates a {@link JAXBElement} container for this vector value, in the context of {@link VectorElements}.
	 * @return A {@link JAXBElement} containing this vector value.
	 */
	public JAXBElement<? extends VectorValue> toJAXBElementVectorValue();
	
}
