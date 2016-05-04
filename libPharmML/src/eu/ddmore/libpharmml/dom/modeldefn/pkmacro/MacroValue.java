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
package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.util.ChainedList;

/**
 * Class for PK macro values.
 * 
 * <p>There are two types of macro values. The 1st type is a value without an explicit assignment.
 * This kind of value must contain only a symbol reference to the proper variable. The symbol
 * id must be compliant with the parent macro definition. One may use the constructor
 * {@link #MacroValue(SymbolRef)} in order to create a value of this type.
 * 
 * <p>The 2nd type is a value with an explicit assignment. The argument name and its value must
 * be specified. The argument name must be compliant with the parent macro definition. One may 
 * use the constructor {@link #MacroValue(String, Rhs)} in order to create a value of this type.
 * 
 * <p>No control of the argument name is made at this level. The validity of each macro is
 * checked during the validation process.
 * 
 * @author F. Yvon
 */
public class MacroValue extends PharmMLRootType implements Assignable {
		
	@XmlElement(name = "Assign", namespace = NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected Scalar scalar;
    @XmlAttribute(name = "argument")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String argument;
    
    /**
     * Empty constructor
     */
    public MacroValue(){}
    
    /**
     * Constructs a new macro value without an assignment. The referenced symbol must be compliant
     * with the macro definition which this value belongs to.
     * @param symbolRef
     */
    public MacroValue(SymbolRef symbolRef){
    	this.symbRef = symbolRef;
    }
    
    /**
     * Constructs a new macro value with an assignment.
     * @param argument The argument must a have a valid name in the macro definition which
     * this macro value belongs to.
     * @param assignment The assignment for the argument.
     */
    public MacroValue(String argument, Rhs assignment){
    	this.argument = argument;
    	this.assign = assignment;
    }

    /**
     * Initialise the name attribute.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setAssign(Rhs value) {
    	this.scalar = null;
        this.assign = value;
    }

    /**
     * Reference to the variable which is assigned to the 'name' attribute.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

//    /**
//     * The value of the name attribute.
//     * 
//     * @return
//     *     possible object is
//     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
//     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
//     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
//     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
//     *     
//     */
//    public Scalar getScalar() {
//        return scalar;
//    }
//
//    /**
//     * Sets the value of the scalar property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link JAXBElement }{@code <}{@link FalseBooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
//     *     {@link JAXBElement }{@code <}{@link BooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link StringValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IntValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link TrueBooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link RealValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IdValueType }{@code >}
//     *     
//     */
//    public void setScalar(Scalar value) {
//        this.scalar = value;
//    }

    /**
     * Gets the value of the argument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgument() {
        return argument;
    }

    /**
     * Sets the value of the argument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgument(String value) {
        this.argument = value;
    }

	@Override
	public Rhs assign(Scalar scalar) {
		Rhs assign = new Rhs(scalar);
		setAssign(assign);
		return assign;
	}

	@Deprecated
	public Rhs assign(eu.ddmore.libpharmml.dom.maths.Equation equation) {
		Rhs rhs = new Rhs(equation);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(SymbolRef symbolRef) {
		Rhs assign = new Rhs(symbolRef);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Sequence sequence) {
		Rhs assign = new Rhs(sequence);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Vector vector) {
		Rhs assign = new Rhs(vector);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Interpolation interpolation) {
		Rhs assign = new Rhs(interpolation);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Matrix matrix) {
		Rhs assign = new Rhs(matrix);
		setAssign(assign);
		return assign;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(argument != null){
			sb.append(argument+"=");
		}
		if(scalar != null){
			sb.append(scalar.toString());
		} else if(assign != null && assign.getContent() != null){
			sb.append(assign.getContent().toString());
		} else if(symbRef != null){
			sb.append(symbRef.getSymbIdRef());
		}
		return sb.toString();
	}
	
	/**
	 * Executed after the unmarshalling process. The signature of this method is standardised by
	 * the JAXB library.
	 * 
	 * <p>
	 * This implementation is meant to deal with the ambiguity of scalar assignment to macro
	 * arguments. If the macro argument is assigned to a scalar without using a assign element,
	 * the value of the scalar attribute is wrapped and moved to the assign attribute. Therefore,
	 * whatever the type of the assignment is, the value is accessed via {@link #getAssign()}.
	 * 
	 * @param u
	 * @param parent
	 */
	protected void afterUnmarshal(Unmarshaller u, Object parent) {
		if(this.scalar != null && this.assign == null){
			this.assign = new Rhs(scalar);
			this.scalar = null;
		} else if (this.argument != null && this.assign == null && this.symbRef != null){
			this.assign = new Rhs(symbRef);
			this.symbRef = null;
		}
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(assign)
				.addIfNotNull(symbRef)
				.addIfNotNull(scalar);
	}

	@Override
	public Rhs assign(Constant constant) {
		Rhs assign = new Rhs(constant);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Interval interval) {
		Rhs assign = new Rhs(interval);
		setAssign(assign);
		return assign;
	}
	
	@Override
	public Rhs assign(Binop binop) {
		Rhs rhs = new Rhs(binop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Uniop uniop) {
		Rhs rhs = new Rhs(uniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Piecewise piecewise) {
		Rhs rhs = new Rhs(piecewise);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(FunctionCallType functionCall) {
		Rhs rhs = new Rhs(functionCall);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Sum sum) {
		Rhs rhs = new Rhs(sum);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Product product) {
		Rhs rhs = new Rhs(product);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Delay delay) {
		Rhs rhs = new Rhs(delay);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(VectorSelector vectorSelector) {
		Rhs rhs = new Rhs(vectorSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixSelector matrixSelector) {
		Rhs rhs = new Rhs(matrixSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixUniOp matrixUniop) {
		Rhs rhs = new Rhs(matrixUniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Probability probability) {
		Rhs rhs = new Rhs(probability);
		setAssign(rhs);
		return rhs;
	}


}
