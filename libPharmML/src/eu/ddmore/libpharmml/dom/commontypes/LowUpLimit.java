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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;


/**
 * <p>Java class for LowUpLimitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LowUpLimitType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Int"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LowUpLimitType", propOrder = {
	"mapped_assign",
    "mapped_equation",
    "_int",
    "symbRef"
})
@HasElementRenamed(
		mappedFields = { 
				@RenamedElement(field = "mapped_equation"),
				@RenamedElement(field = "mapped_assign", since = PharmMLVersion.V0_7_1)
				},
		transientField = "assign")
public class LowUpLimit
    extends PharmMLRootType
{
	
	public LowUpLimit(){};
	
	public LowUpLimit(int value){
		this._int = new IntValue(value);
	}
	
	public LowUpLimit(SymbolRef value){
		this.symbRef = value;
	}
	
//	public LowUpLimit(Equation value){
//		this.equation = value;
//	}

    @XmlElement(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected Rhs mapped_equation;
    @XmlElement(name = "Assign") // PharmML 0.7.1
    protected Rhs mapped_assign;
    @XmlTransient
    protected Rhs assign;
    
    @XmlElement(name = "Int")
    protected IntValue _int;
    @XmlElement(name = "SymbRef")
    protected SymbolRef symbRef;
    
    /**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     * @since PharmML 0.7.1
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
     * @since PharmML 0.7.1
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

//    /**
//     * A mathematical expression.
//     * 
//     * @return
//     *     possible object is
//     *     {@link Equation }
//     *     
//     * @since PharmML 0.4.1
//     */
//    public Equation getEquation() {
//        return equation;
//    }
//
//    /**
//     * Sets the value of the equation property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link Equation }
//     *     
//     * @since PharmML 0.4.1
//     */
//    public void setEquation(Equation value) {
//        this.equation = value;
//    }

    /**
     * An integer value.
     * 
     * @return
     *     possible object is
     *     {@link IntValue }
     *     
     */
    public IntValue getInt() {
        return _int;
    }

    /**
     * Sets the value of the int property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntValue }
     *     
     */
    public void setInt(IntValue value) {
        this._int = value;
    }

    /**
     * A variable reference.
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

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(assign)
				.addIfNotNull(_int)
				.addIfNotNull(symbRef);
	}

}
