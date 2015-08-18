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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
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
    "assign"
})
@XmlSeeAlso({
    Endpoint.class
})
public class StandardAssignable
    extends PharmMLRootType implements Assignable
{

    @XmlElement(name = "Assign", required = true)
    protected Rhs assign;

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

}
