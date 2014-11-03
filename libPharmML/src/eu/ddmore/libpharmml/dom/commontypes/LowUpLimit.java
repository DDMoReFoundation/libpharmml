/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.21 at 11:29:00 AM BST 
//


package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Equation;


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
    "equation",
    "_int",
    "symbRef"
})
public class LowUpLimit
    extends PharmMLRootType
{
	
	public LowUpLimit(){};
	
	public LowUpLimit(int value){
		this._int = new IntValue(value);
	}
	
	public LowUpLimit(SymbolRefType value){
		this.symbRef = value;
	}
	
	public LowUpLimit(Equation value){
		this.equation = value;
	}

    @XmlElement(name = "Equation", namespace = "http://www.pharmml.org/2013/03/Maths")
    protected Equation equation;
    @XmlElement(name = "Int")
    protected IntValueType _int;
    @XmlElement(name = "SymbRef")
    protected SymbolRefType symbRef;

    /**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Equation }
     *     
     * @since PharmML 0.4.1
     */
    public Equation getEquation() {
        return equation;
    }

    /**
     * Sets the value of the equation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Equation }
     *     
     * @since PharmML 0.4.1
     */
    public void setEquation(Equation value) {
        this.equation = value;
    }

    /**
     * An integer value.
     * 
     * @return
     *     possible object is
     *     {@link IntValueType }
     *     
     */
    public IntValueType getInt() {
        return _int;
    }

    /**
     * Sets the value of the int property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntValueType }
     *     
     */
    public void setInt(IntValueType value) {
        this._int = value;
    }

    /**
     * A variable reference.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRefType }
     *     
     */
    public SymbolRefType getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRefType }
     *     
     */
    public void setSymbRef(SymbolRefType value) {
        this.symbRef = value;
    }

}
