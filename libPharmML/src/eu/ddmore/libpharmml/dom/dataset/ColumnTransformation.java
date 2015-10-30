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

package eu.ddmore.libpharmml.dom.dataset;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.RhsEquationAdapter;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;


/**
 * Type defines how the column is transformed when used.
 * 
 * <p>Java class for ColumnTransformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColumnTransformationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Equation"/>
 *       &lt;/sequence>
 *       &lt;attribute name="transformId" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnTransformationType", propOrder = {
		"mapped_assign",
	    "mapped_equation",
})
@HasElementRenamed(
		mappedFields = { 
				@RenamedElement(field = "mapped_equation"),
				@RenamedElement(field = "mapped_assign", since = PharmMLVersion.V0_7_3)
				},
		transientField = "assign")
public class ColumnTransformation
    extends PharmMLRootType
{

	@XmlElement(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH)
	@XmlJavaTypeAdapter(RhsEquationAdapter.class)
    protected Rhs mapped_equation;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT) // PharmML 0.7.1
    protected Rhs mapped_assign;
    @XmlTransient
    protected Rhs assign;
    
    @XmlAttribute(name = "transformId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String transformId;
    
    public ColumnTransformation(){}
    
//    public ColumnTransformation(Equation equation, String transformId){
//    	this.equation = equation;
//    	this.transformId = transformId;
//    }

//    /**
//     * 
//     *                                 The transformation is defined as an equation that must include a reference to the column, defined by the parent of this element.  
//     *                             
//     * 
//     * @return
//     *     possible object is
//     *     {@link Equation }
//     *     
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
//     */
//    public void setEquation(Equation value) {
//        this.equation = value;
//    }
    
    /**
     * The transformation is defined as an expression that must include 
     * a reference to the column, defined by the parent of this element.
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
     * The transformation is defined as an expression that must include 
     * a reference to the column, defined by the parent of this element.
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

    /**
     * Gets the value of the transformId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransformId() {
        return transformId;
    }

    /**
     * Sets the value of the transformId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransformId(String value) {
        this.transformId = value;
    }
    
//    /**
//     * Creates a new empty {@link Equation} equation element, adds it to the current object and returns it.
//     * @return The created {@link Equation} object.
//     */
//    public Equation createEquation(){
//            Equation el = new Equation();
//            this.equation = el;
//            return el;
//    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(assign);
	}


}
