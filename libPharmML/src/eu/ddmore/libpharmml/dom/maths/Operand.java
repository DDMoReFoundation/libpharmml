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
package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.dom.tags.MathExpression;

/**
 * Interface implemented by any operand in a binay-operand expression.
 * 
 * @author F. Yvon
 *
 */
public interface Operand extends MathExpression {

	/**
	 * Converts the object to a JAXBElement for marshalling. This method may be used any time the XML element
	 * is named according to its type. If the XML element has a different name, an other method must be used.
	 * @return An instance of {@link JAXBElement} that contains the current object.
	 */
	public JAXBElement<? extends Operand> toJAXBElement();
	
}
