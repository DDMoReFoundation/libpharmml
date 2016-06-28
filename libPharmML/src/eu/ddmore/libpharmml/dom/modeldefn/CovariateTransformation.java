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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.RhsEquationAdapter;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type defines how the covariate is transformed when used.
 * 
 * <p>Java class for CovariateTransformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovariateTransformationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="TransformedCovariate" type="{http://www.pharmml.org/2013/03/ModelDefinition}TransformedCovariateType"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Equation"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovariateTransformationType", propOrder = {
    "transformedCovariate",
    "mapped_assign",
    "mapped_equation"
})
@HasElementRenamed(
		mappedFields = { 
				@RenamedElement(field = "mapped_equation"),
				@RenamedElement(field = "mapped_assign", since = PharmMLVersion.V0_7_3)
				},
		transientField = "assign")
public class CovariateTransformation
    extends PharmMLRootType
{

    @XmlElement(name = "TransformedCovariate", required = true)
    protected TransformedCovariate transformedCovariate;
    
    @XmlElement(name = "Equation", namespace = NS_DEFAULT_MATH)
    @XmlJavaTypeAdapter(RhsEquationAdapter.class)
    protected Rhs mapped_equation;
    @XmlElement(name = "Assign", namespace = NS_DEFAULT_CT) // PharmML 0.7.1
    protected Rhs mapped_assign;
    @XmlTransient
    protected Rhs assign;

    /**
     * Gets the value of the transformedCovariate property.
     * 
     * @return
     *     possible object is
     *     {@link TransformedCovariate }
     *     
     */
    public TransformedCovariate getTransformedCovariate() {
        return transformedCovariate;
    }

    /**
     * Sets the value of the transformedCovariate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformedCovariate }
     *     
     */
    public void setTransformedCovariate(TransformedCovariate value) {
        this.transformedCovariate = value;
    }
    
    /**
     * The transformation is defined as an expression that must include 
     * a reference to the covariate variable, defined by the parent of this element.
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
     * a reference to the covariate variable, defined by the parent of this element.
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
//     * 
//     *                                 The transformation is defined as an equation that must include a reference to the covariate variable, defined by the parent of this element.  
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
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(transformedCovariate)
				.addIfNotNull(assign);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
