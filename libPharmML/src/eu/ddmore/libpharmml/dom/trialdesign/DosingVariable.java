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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.dataset.TargetMapping;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 The type that specifies a dosing variable.
 *             
 * 
 * <p>Java class for DosingVariableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DosingVariableType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="TargetMapping" type="{http://www.pharmml.org/2013/08/Dataset}TargetMappingType" minOccurs="0"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/2013/03/TrialDesign}doseVarAttGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DosingVariableType", propOrder = {
    "targetMapping",
    "symbRef",
    "assign"
})
@XmlSeeAlso({
    eu.ddmore.libpharmml.dom.trialdesign.Infusion.DoseAmount.class
})
public class DosingVariable
    extends PharmMLRootType
{

    @XmlElement(name = "TargetMapping")
    protected TargetMapping targetMapping;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
	@XmlAttribute(name = "inputType")
	@Deprecated
    protected DoseInputTypeType inputType;
    @XmlAttribute(name = "inputTarget", required = false)
    protected DoseInputTarget inputTarget;

    /**
     * Gets the value of the targetMapping property.
     * 
     * @return
     *     possible object is
     *     {@link TargetMapping }
     *     
     */
    public TargetMapping getTargetMapping() {
        return targetMapping;
    }

    /**
     * Sets the value of the targetMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetMapping }
     *     
     */
    public void setTargetMapping(TargetMapping value) {
        this.targetMapping = value;
    }

    /**
     * 
     *                                     The name of the variable that is the dose administered to.
     *                                 
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

    /**
     * The amount of dose to be applied at dosing time.
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
     * Gets the value of the inputType property.
     * 
     * @return
     *     possible object is
     *     {@link DoseInputTypeType }
     *     
     * @deprecated Since PharmML 0.3. See {@link #getInputTarget()}.
     */
    @Deprecated
	public DoseInputTypeType getInputType() {
        return inputType;
    }

    /**
     * Sets the value of the inputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoseInputTypeType }
     *     
     * @deprecated Since PharmML 0.3. See {@link #setInputTarget(DoseInputTarget)}.
     */
    @Deprecated
	public void setInputType(DoseInputTypeType value) {
        this.inputType = value;
    }

    /**
     * Gets the value of the inputTarget property.
     * 
     * @return
     *     possible object is
     *     {@link DoseInputTarget }
     *     
     */
    public DoseInputTarget getInputTarget() {
        return inputTarget;
    }

    /**
     * Sets the value of the inputTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoseInputTarget }
     *     
     */
    public void setInputTarget(DoseInputTarget value) {
        this.inputTarget = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(targetMapping)
				.addIfNotNull(symbRef)
				.addIfNotNull(assign);
	}

}
