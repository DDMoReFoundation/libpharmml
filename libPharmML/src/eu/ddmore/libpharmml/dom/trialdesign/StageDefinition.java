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
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicOperator;
import eu.ddmore.libpharmml.dom.maths.ObjectFactory;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Stage definition type.
 * 
 * <p>Java class for StageDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StageDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}LogicBinop"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StageDefinitionType", propOrder = {
    "logicBinop"
})
public class StageDefinition
    extends PharmMLRootType
{

    @XmlElement(name = "LogicBinop", namespace = NS_DEFAULT_MATH, required = true)
    protected LogicBinOp logicBinop;

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
     * Creates a new {@link LogicBinOp} element, adds it to the current object and returns it.
     * @return The created {@link LogicBinOp} object.
     */
    public LogicBinOp createLogicBinOp(){
    	LogicBinOp lbo = ObjectFactory.getInstance().createLogicBinOpType();
    	this.logicBinop = lbo;
    	return lbo;
    }
    
    /**
     * Creates a new {@link LogicBinOp} element, adds it to the current object and returns it.
     * @param op {@link LogicOperator} enum value.
     * @return The created {@link LogicBinOp} object.
     */
    public LogicBinOp createLogicBinOp(LogicOperator op){
    	LogicBinOp lbo = ObjectFactory.getInstance().createLogicBinOpType();
    	lbo.setOp(op.value());
    	this.logicBinop = lbo;
    	return lbo;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(logicBinop);
    }

}
