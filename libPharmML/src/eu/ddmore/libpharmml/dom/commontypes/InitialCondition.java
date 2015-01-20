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
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The initial condition of the derivative variable.
 * 
 * <p>Java class for InitialConditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitialConditionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="InitialValue" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialValueType" minOccurs="0"/>
 *         &lt;element name="InitialTime" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialTimeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitialConditionType", propOrder = {
	"assign",
    "initialValue",
    "initialTime"
})
public class InitialCondition
    extends PharmMLRootType
{

    @XmlElement(name = "Assign")
    protected Rhs assign;
	@XmlElement(name = "InitialValue")
    protected InitialValue initialValue;
    @XmlElement(name = "InitialTime")
    protected InitialTime initialTime;
	
	/**
	 * @deprecated
	 * The initial value assigned to the derivative.
     * Since version 0.3, PharmML supports additionally the storage of initial time t0 and not only the initial value. Use now {@link #getInitialTime()} and {@link #getInitialValue()} instead.
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    @Deprecated
	public Rhs getAssign() {
        return assign;
    }

    /**
     * @deprecated
     * Sets the value of the assign property.
     * Since version 0.3, PharmML supports additionally the storage of initial time t0 and not only the initial value. Use now {@link #setInitialTime(InitialTime)} and {@link #setInitialValue(InitialValue)} instead.
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    @Deprecated
	public void setAssign(Rhs value) {
        this.assign = value;
    }

    /**
     * Gets the value of the initialValue property.
     * 
     * @return
     *     possible object is
     *     {@link InitialValue }
     *     
     */
    public InitialValue getInitialValue() {
        return initialValue;
    }

    /**
     * Sets the value of the initialValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialValue }
     *     
     */
    public void setInitialValue(InitialValue value) {
        this.initialValue = value;
    }

    /**
     * Gets the value of the initialTime property.
     * 
     * @return
     *     possible object is
     *     {@link InitialTime }
     *     
     */
    public InitialTime getInitialTime() {
        return initialTime;
    }

    /**
     * Sets the value of the initialTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialTime }
     *     
     */
    public void setInitialTime(InitialTime value) {
        this.initialTime = value;
    }

}