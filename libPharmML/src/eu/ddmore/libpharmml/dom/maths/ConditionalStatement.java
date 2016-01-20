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
package eu.ddmore.libpharmml.dom.maths;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.tags.StructuralModelElement;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * The schema type defining a conditional statement.
 * 
 * <p>Java class for ConditionalStatementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionalStatementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="If" type="{http://www.pharmml.org/pharmml/0.8/Maths}IfElseIfType"/>
 *         &lt;element name="ElseIf" type="{http://www.pharmml.org/pharmml/0.8/Maths}IfElseIfType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Else" type="{http://www.pharmml.org/pharmml/0.8/Maths}ElseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionalStatementType", propOrder = {
    "_if",
    "listOfElseIf",
    "_else"
})
public class ConditionalStatement extends PharmMLElement implements StructuralModelElement {

    @XmlElement(name = "If", required = true)
    protected IfElseIfCondition _if;
    @XmlElement(name = "ElseIf")
    protected List<IfElseIfCondition> listOfElseIf;
    @XmlElement(name = "Else")
    protected ElseCondition _else;

    /**
     * Gets the value of the if property.
     * 
     * @return
     *     possible object is
     *     {@link IfElseIfCondition }
     *     
     */
    public IfElseIfCondition getIf() {
        return _if;
    }

    /**
     * Sets the value of the if property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfElseIfCondition }
     *     
     */
    public void setIf(IfElseIfCondition value) {
        this._if = value;
    }

    /**
     * Gets the value of the elseIf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elseIf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfElseIf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IfElseIfCondition }
     * 
     * 
     */
    public List<IfElseIfCondition> getListOfElseIf() {
        if (listOfElseIf == null) {
        	listOfElseIf = new ArrayList<IfElseIfCondition>();
        }
        return this.listOfElseIf;
    }

    /**
     * Gets the value of the else property.
     * 
     * @return
     *     possible object is
     *     {@link ElseCondition }
     *     
     */
    public ElseCondition getElse() {
        return _else;
    }

    /**
     * Sets the value of the else property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElseCondition }
     *     
     */
    public void setElse(ElseCondition value) {
        this._else = value;
    }
    
    /**
     * Creates a new empty {@link IfElseIfCondition} _if element, adds it to the current object and returns it.
     * @return The created {@link IfElseIfCondition} object.
     */
    public IfElseIfCondition createIf(){
            IfElseIfCondition el = new IfElseIfCondition();
            this._if = el;
            return el;
    }
    
    /**
     * Creates a new empty {@link IfElseIfCondition} _if element, adds it to the current object and returns it.
     * @return The created {@link IfElseIfCondition} object.
     */
    public IfElseIfCondition createIf(Condition condition){
            IfElseIfCondition el = new IfElseIfCondition();
            el.setCondition(condition);
            this._if = el;
            return el;
    }

    /**
     * Creates a new empty {@link IfElseIfCondition} elseIf element, adds it to the current object and returns it.
     * @return The created {@link IfElseIfCondition} object.
     */
    public IfElseIfCondition createElseIf(){
            IfElseIfCondition el = new IfElseIfCondition();
            getListOfElseIf().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link ElseCondition} _else element, adds it to the current object and returns it.
     * @return The created {@link ElseCondition} object.
     */
    public ElseCondition createElse(){
            ElseCondition el = new ElseCondition();
            this._else = el;
            return el;
    }

    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(_if)
    			.addIfNotNull(listOfElseIf)
    			.addIfNotNull(_else);
    }

}
