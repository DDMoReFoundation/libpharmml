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


/**
 * The history for DDEs.
 * 
 * <p>Java class for HistoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoryType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="HistoryValue" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialValueType" minOccurs="0"/>
 *         &lt;element name="HistoryTime" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialTimeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryType", propOrder = {
    "historyValue",
    "historyTime"
})
public class History
    extends PharmMLRootType
{

    @XmlElement(name = "HistoryValue")
    protected InitialValueType historyValue;
    @XmlElement(name = "HistoryTime")
    protected InitialTime historyTime;
    
    /**
     * Empty constructor
     */
    public History(){}
    
    /**
     * Create a History element with assignment to value and time.
     * This creates a {@link InitialValueType} for value and a {@link InitialTime} for time
     * each one containing the {@link Rhs} historyValue amd historyTime elements respectively.
     * @param historyValue The assignment to value
     * @param historyTime The assignment to time
     */
    public History(Rhs historyValue, Rhs historyTime){
    	createHistoryValue(historyValue);
    	createHistoryTime(historyTime);
    }

    /**
     * Gets the value of the historyValue property.
     * 
     * @return
     *     possible object is
     *     {@link InitialValueType }
     *     
     */
    public InitialValueType getHistoryValue() {
        return historyValue;
    }

    /**
     * Sets the value of the historyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialValueType }
     *     
     */
    public void setHistoryValue(InitialValueType value) {
        this.historyValue = value;
    }

    /**
     * Gets the value of the historyTime property.
     * 
     * @return
     *     possible object is
     *     {@link InitialTime }
     *     
     */
    public InitialTime getHistoryTime() {
        return historyTime;
    }

    /**
     * Sets the value of the historyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialTime }
     *     
     */
    public void setHistoryTime(InitialTime value) {
        this.historyTime = value;
    }
    
    public InitialValueType createHistoryValue(){
    	InitialValueType value = new InitialValueType();
    	this.historyValue = value;
    	return value;
    }
    public InitialValueType createHistoryValue(Rhs assign){
    	InitialValueType value = createHistoryValue();
    	value.setAssign(assign);
    	return value;
    }
    public InitialTime createHistoryTime(){
    	InitialTime value = new InitialTime();
    	this.historyTime = value;
    	return value;
    }
    public InitialTime createHistoryTime(Rhs assign){
    	InitialTime value = createHistoryTime();
    	value.setAssign(assign);
    	return value;
    }
}
