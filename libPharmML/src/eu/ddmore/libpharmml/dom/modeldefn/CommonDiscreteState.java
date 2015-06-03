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


package eu.ddmore.libpharmml.dom.modeldefn;

import java.math.BigInteger;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicUniOp;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining a discrete state: current, previous and a general condition.
 * 
 * <p>Java class for CommonDiscreteStateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonDiscreteStateType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicBinop"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicUniop"/>
 *       &lt;/choice>
 *       &lt;attribute name="MarkovOrder" type="{http://www.pharmml.org/2013/03/CommonTypes}MarkovOrderType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonDiscreteStateType", propOrder = {
    "logicBinop",
    "logicUniop"
})
public class CommonDiscreteState
    extends PharmMLRootType
{

    @XmlElement(name = "LogicBinop", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected LogicBinOp logicBinop;
    @XmlElement(name = "LogicUniop", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected LogicUniOp logicUniop;
    @XmlAttribute(name = "MarkovOrder")
    protected BigInteger markovOrder;

    /**
     * Gets the value of the logicBinop property.
     * 
     * @return
     *     possible object is
     *     {@link LogicBinOp }
     *     
     */
    public LogicBinOp getLogicBinop() {
        return logicBinop;
    }

    /**
     * Sets the value of the logicBinop property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicBinOp }
     *     
     */
    public void setLogicBinop(LogicBinOp value) {
        this.logicBinop = value;
    }

    /**
     * Gets the value of the logicUniop property.
     * 
     * @return
     *     possible object is
     *     {@link LogicUniOp }
     *     
     */
    public LogicUniOp getLogicUniop() {
        return logicUniop;
    }

    /**
     * Sets the value of the logicUniop property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicUniOp }
     *     
     */
    public void setLogicUniop(LogicUniOp value) {
        this.logicUniop = value;
    }

    /**
     * Gets the value of the markovOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMarkovOrder() {
        return markovOrder;
    }

    /**
     * Sets the value of the markovOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMarkovOrder(BigInteger value) {
        this.markovOrder = value;
    }
    
    /**
     * Creates a new empty {@link LogicBinOp} element, adds it to the current {@link CommonDiscreteState} object and returns it.
     * @return The created {@link LogicBinOp} object.
     */
    public LogicBinOp createLogicBinop(){
            LogicBinOp el = new LogicBinOp();
            this.logicBinop = el;
            return el;
    }

    /**
     * Creates a new empty {@link LogicUniOp} element, adds it to the current {@link CommonDiscreteState} object and returns it.
     * @return The created {@link LogicUniOp} object.
     */
    public LogicUniOp createLogicUniop(){
            LogicUniOp el = new LogicUniOp();
            this.logicUniop = el;
            return el;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(logicBinop)
				.addIfNotNull(logicUniop);
	}


}
