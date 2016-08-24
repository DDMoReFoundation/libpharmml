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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type defining one option only: Assign but can be empty as well.
 * 
 * <p>Java class for StandardExtAssignType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardExtAssignType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardExtAssignType", propOrder = {
    "assign"
})
public class StandardOptionalAssignable
    extends PharmMLRootType implements Assignable
{

    @XmlElement(name = "Assign")
    protected Rhs assign;

    /**
     * Gets the value of the assign property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    @Override
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
    @Override
	public void setAssign(Rhs value) {
        this.assign = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren()).addIfNotNull(assign);
	}
    
    @Override
	public Rhs assign(Scalar scalar) {
		this.assign = new Rhs(scalar);
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

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
