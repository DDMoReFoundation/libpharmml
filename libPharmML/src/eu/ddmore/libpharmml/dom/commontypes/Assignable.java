/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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

import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Interface for every element that contains an assign element.
 * @author F. Yvon
 *
 */
@XmlTransient
public interface Assignable {

	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param scalar The value of the assignment as a {@link Scalar}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Scalar scalar);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param equation The value of the assignment as a {@link Equation}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Equation equation);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param symbolRef The value of the assignment as a {@link SymbolRef}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(SymbolRef symbolRef);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param sequence The value of the assignment as a {@link Sequence}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Sequence sequence);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param vector The value of the assignment as a {@link Vector}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Vector vector);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param interpolation The value of the assignment as a {@link Interpolation}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Interpolation interpolation);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param matrix The value of the assignment as a {@link Matrix}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.4.1
	 */
	public Rhs assign(Matrix matrix);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param constant The value of the assignment as a {@link Constant}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7
	 */
	public Rhs assign(Constant constant);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param interval The value of the assignment as a {@link Interval}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7
	 */
	public Rhs assign(Interval interval);
	
}
