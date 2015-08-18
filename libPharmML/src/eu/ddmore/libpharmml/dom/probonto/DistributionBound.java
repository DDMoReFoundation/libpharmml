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
package eu.ddmore.libpharmml.dom.probonto;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type for specifying truncation bounds of a distribution.
 * 
 * <p>Java class for DistributionBoundType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributionBoundType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" default="closed">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="closed"/>
 *             &lt;enumeration value="open"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributionBoundType", propOrder = {
    "assign"
})
public class DistributionBound
    extends PharmMLRootType implements Assignable
{

    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlAttribute(name = "type")
    protected String type;

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

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "closed";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(assign);
    }
    
    @Override
	public Rhs assign(Scalar scalar) {
		Rhs rhs = new Rhs(scalar);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Equation equation) {
		Rhs rhs = new Rhs(equation);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(SymbolRef symbolRef) {
		Rhs rhs = new Rhs(symbolRef);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Sequence sequence) {
		Rhs rhs = new Rhs(sequence);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Vector vector) {
		Rhs rhs = new Rhs(vector);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Interpolation interpolation) {
		Rhs rhs = new Rhs(interpolation);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Matrix matrix) {
		Rhs rhs = new Rhs(matrix);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Constant constant) {
		Rhs rhs = new Rhs(constant);
		this.assign = rhs;
		return rhs;
	}

	@Override
	public Rhs assign(Interval interval) {
		Rhs rhs = new Rhs(interval);
		this.assign = rhs;
		return rhs;
	}

}
