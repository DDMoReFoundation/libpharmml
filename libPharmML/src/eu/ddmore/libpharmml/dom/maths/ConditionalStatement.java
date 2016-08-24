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

import eu.ddmore.libpharmml.dom.commontypes.CommonVariableDefinition;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateModel;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModel;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.tags.StructuralModelElement;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Conditional assignments provide additional flexibility to the language. So far only piecewise statements 
 * were supported which have the drawback that only single variables are assigned per statement.
 * 
 * <p>Conditional assignments don’t replace the existing piecewise statements, they are an entirely independent structure.
 * 
 * <p>The general form of the (nested) conditional statement looks as follows.
 * 
 * <pre>if ( condition1 ) then
 * 	statement1
 * else if ( condition2 ) then
 * 	statement2
 * else if ( conditionN-1 ) then
 * 	statementN-1
 * else
 * 	statementN
 * end if
 * </pre>
 * 
 * <p>The following definition of the conditional statement has been adapted from the STAN specification v2.9.0.
 * There must be a single leading if clause, which may be followed by any number of else if clauses, all of
 * which may be optionally followed by an else clause. Each condition must be a TRUE or FALSE value.
 * Nested if-then-else as part of each statement are allowed.
 * The entire sequence of if-then-else clauses forms a single conditional statement for evaluation. The
 * conditions are evaluated in order until one of the conditions evaluates to a TRUE value, at which point
 * its corresponding statement is executed and the conditional statement finishes execution. If none of the
 * conditions evaluates to a TRUE value and there is a final else clause, its statement is executed.
 * 
 * <p>Therefore, in order to read a conditional statement, one must use in order:
 * <ol>
 * <li>{@link #getIf()}</li>
 * <li>{@link #getListOfElseIf()}</li>
 * <li>{@link #getElse()}</li>
 * </ol>
 * 
 * <h3>Rules</h3>
 * 
 * <ol>
 * <li>The conditionals are available in the {@link CovariateModel}, {@link ParameterModel}, {@link StructuralModel} and the 
 * {@link ObservationModel}, similarly to the assignment statements.</li>
 * <li>Allowed statement elements are:<br>
 * 	<ul>
 * 		<li>{@link IndividualParameter} and {@link PopulationParameter}</li>
 * 		<li>variables ({@link CommonVariableDefinition}) and {@link ParameterRandomVariable}</li>
 * 		<li>assignment statements (using {@link LogicBinOp})</li>
 * 		<li>nested {@link ConditionalStatement}</li>
 * 	</ul>
 * </li>
 * <li>Parameters, variables assigned and/or referred to in a conditional statement must be declared outside the conditional
 *  in the first level of the according model block.</li>
 * <li>Parameters or variables assigned within the conditional statement have to be referred to using the attribute 
 * symbIdRef.</li>
 * <li>Parameters or variables assigned within the conditional statement cannot be assigned elsewhere unless such assignment
 * is coupled with its declaration. The assignment of a parameter or variable within a conditional statement has precedence 
 * over an assignment coupled with a declaration.</li>
 * <li>Neither PharmML nor libPharmML do process the conditional statements in any way. The order of statements encoded in 
 * PharmML will be preserved when translating to a target tool.</li>
 * <li>libPharmML doesn’t have the capability to evaluate conditional statements – it is the responsibility of the user to 
 * define them in a meaningful and unambiguous way (the condition domains defined should be mutually exclusive).</li>
 * </ol>
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
     * Creates a new {@link IfElseIfCondition} elseIf element, adds it to the current object and returns it.
     * @param condition The condition of this statement.
     * @return The created {@link IfElseIfCondition} object.
     */
    public IfElseIfCondition createElseIf(Condition condition){
            IfElseIfCondition el = new IfElseIfCondition();
            el.setCondition(condition);
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

	@Override
	public ConditionalStatement clone() {
		return clone(ConditionalStatement.class, this);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
