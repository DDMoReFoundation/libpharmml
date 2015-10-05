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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type for objects that contain a {@link Rhs} assignment.
 * 
 * <p>Java class for StandardAssignType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardAssignType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardAssignType", propOrder = {
    "assign",
    "equation",
    "scalar",
    "symbRef"
})
@XmlSeeAlso({
    Endpoint.class
})
public class StandardAssignable
    extends PharmMLRootType implements Assignable
{

    @XmlElement(name = "Assign", required = true)
    protected Rhs assign;
    
    // The following attributes are meant to support the backward compatiblity before version 0.7.1.
    // When ScalarRhs attributes changed to StandardAssignable.
    @XmlElement(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected Scalar scalar;
    @XmlElement(name = "SymbRef")
    protected SymbolRef symbRef;
    
    /**
     * For backwards compatiblity only. Do not use.
     * @return
     */
    public Rhs toScalarRhs(){
    	Rhs saved_assign = null;
    	if(assign != null){
    		if(assign.getScalar() != null){
    			scalar = assign.getScalar();
    		} else if(assign.getSymbRef() != null){
    			symbRef = assign.getSymbRef();
    		} else {
    			equation = Equation.fromRhs(assign);
    		}
    		saved_assign = assign;
    		assign = null;
    	}
    	return saved_assign;
    }
    
    /**
     * For backwards compatiblity only. Do not use.
     */
    public void fromScalarRhs(){
    	if(equation != null){
    		assign = Equation.toRhs(equation);
    	} else if (scalar != null){
    		assign = new Rhs(scalar);
    	} else if (symbRef != null){
    		assign = new Rhs(symbRef);
    	}
    	equation = null;
    	scalar = null;
    	symbRef = null;
    }

    /**
     * Gets the value of the assign property.
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
        this.assign = value;
    }

	@Override
	public Rhs assign(Scalar scalar) {
		this.assign = new Rhs(scalar);
		return this.assign;
	}

	@Override
	public Rhs assign(Equation equation) {
		this.assign = new Rhs(equation);
		return this.assign;
	}

	@Override
	public Rhs assign(SymbolRef symbolRef) {
		this.assign = new Rhs(symbolRef);
		return this.assign;
	}

	@Override
	public Rhs assign(Sequence sequence) {
		this.assign = new Rhs(sequence);
		return this.assign;
	}

	@Override
	public Rhs assign(Vector vector) {
		this.assign = new Rhs(vector);
		return this.assign;
	}

	@Override
	public Rhs assign(Interpolation interpolation) {
		this.assign = new Rhs(interpolation);
		return this.assign;
	}

	@Override
	public Rhs assign(Matrix matrix) {
		this.assign = new Rhs(matrix);
		return this.assign;
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren()).addIfNotNull(assign);
	}

	@Override
	public Rhs assign(Constant constant) {
		this.assign = new Rhs(constant);
		return this.assign;
	}

	@Override
	public Rhs assign(Interval interval) {
		this.assign = new Rhs(interval);
		return this.assign;
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
