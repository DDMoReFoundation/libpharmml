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

import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;

/**
 * Interface for every element that contains an assign element.
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
	 * @param equation The value of the assignment as a {@link eu.ddmore.libpharmml.dom.maths.Equation}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @deprecated Since PharmML 0.7.1, Equation is not used anymore. Use other assign(...) methods instead.
	 */
	@Deprecated
	public Rhs assign(eu.ddmore.libpharmml.dom.maths.Equation equation);
	
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
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param binop The value of the assignment as a {@link Binop}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Binop binop);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param uniop The value of the assignment as a {@link Uniop}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Uniop uniop);
	
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param piecewise The value of the assignment as a {@link Piecewise}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Piecewise piecewise);

    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param functionCall The value of the assignment as a {@link FunctionCallType}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(FunctionCallType functionCall);
    
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param sum The value of the assignment as a {@link Sum}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Sum sum);
    
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param product The value of the assignment as a {@link Product}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Product product);
    
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param delay The value of the assignment as a {@link Delay}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Delay delay);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param vectorSelector The value of the assignment as a {@link VectorSelector}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(VectorSelector vectorSelector);
    
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param matrixSelector The value of the assignment as a {@link MatrixSelector}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(MatrixSelector matrixSelector);
	
    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param matrixUniop The value of the assignment as a {@link MatrixUniOp}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(MatrixUniOp matrixUniop);

    /**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param probability The value of the assignment as a {@link Probability}.
	 * @return The created {@link Rhs} assign element.
	 * 
	 * @since PharmML 0.7.1
	 */
	public Rhs assign(Probability probability);
	
	
}
