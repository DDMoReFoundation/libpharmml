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

import eu.ddmore.libpharmml.util.ChainedList;


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
    protected StandardAssignable historyValue;
    @XmlElement(name = "HistoryTime")
    protected StandardAssignable historyTime;
    
    /**
     * Empty constructor
     */
    public History(){}
    
    /**
     * Create a History element with assignment to value and time.
     * This creates a {@link InitialValue} for value and a {@link InitialTime} for time
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
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getHistoryValue() {
        return historyValue;
    }

    /**
     * Sets the value of the historyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setHistoryValue(StandardAssignable value) {
        this.historyValue = value;
    }

    /**
     * Gets the value of the historyTime property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getHistoryTime() {
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
    public void setHistoryTime(StandardAssignable value) {
        this.historyTime = value;
    }
    
    public StandardAssignable createHistoryValue(){
    	StandardAssignable value = new StandardAssignable();
    	this.historyValue = value;
    	return value;
    }
    public StandardAssignable createHistoryValue(Rhs assign){
    	StandardAssignable value = new StandardAssignable();
    	this.historyValue = value;
    	value.setAssign(assign);
    	return value;
    }
    public StandardAssignable createHistoryTime(){
    	StandardAssignable value = new StandardAssignable();
    	this.historyTime = value;
    	return value;
    }
    public StandardAssignable createHistoryTime(Rhs assign){
    	StandardAssignable value = new StandardAssignable();
    	this.historyTime = value;
    	value.setAssign(assign);
    	return value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(historyValue)
				.addIfNotNull(historyTime);
	}
}
