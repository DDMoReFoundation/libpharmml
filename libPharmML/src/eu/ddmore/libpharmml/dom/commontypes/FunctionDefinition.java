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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 This defines a function that can be used elsewhere in the PharmML document.
 *             
 * 
 * <p>Java class for FunctionDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}CommonVariableDefinitionType">
 *       &lt;sequence>
 *         &lt;element name="FunctionArgument" type="{http://www.pharmml.org/2013/03/CommonTypes}FuncParameterDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Definition" type="{http://www.pharmml.org/2013/03/CommonTypes}ScalarRhs" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="symbolType" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolTypeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionDefinitionType", propOrder = {
    "functionArgument",
    "definition"
})
public class FunctionDefinition
    extends CommonVariableDefinition implements SymbolScope
{

    @XmlElement(name = "FunctionArgument")
    protected List<FunctionParameter> functionArgument;
    
    @XmlElement(name = "Definition")
    @XmlJavaTypeAdapter(StandardAssignableAdapted.ScalarRhsAdapter.class)
    protected StandardAssignable definition;
    
    @XmlAttribute(name = "symbolType", required = true)
    protected SymbolType symbolType;

    /**
     * Gets the value of the functionArgument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functionArgument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctionArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FunctionParameter }
     * 
     * 
     */
    public List<FunctionParameter> getFunctionArgument() {
        if (functionArgument == null) {
            functionArgument = new ArrayList<FunctionParameter>();
        }
        return this.functionArgument;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setDefinition(StandardAssignable value) {
        this.definition = value;
    }

    /**
     * Gets the value of the symbolType property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolType }
     *     
     */
    public SymbolType getSymbolType() {
        return symbolType;
    }

    /**
     * Sets the value of the symbolType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolType }
     *     
     */
    public void setSymbolType(SymbolType value) {
        this.symbolType = value;
    }
    
    /**
     * Creates a new empty {@link FunctionParameter} functionArgument element, adds it to the current object and returns it.
     * @return The created {@link FunctionParameter} object.
     */
    public FunctionParameter createFunctionArgument(){
            FunctionParameter el = new FunctionParameter();
            getFunctionArgument().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link FunctionParameter} functionArgument element, adds it to the current object and returns it.
     * @param symbolId
     * @param symbolType
     * @return The created {@link FunctionParameter} object.
     */
    public FunctionParameter createFunctionArgument(String symbolId, SymbolType symbolType){
            FunctionParameter el = new FunctionParameter(symbolId,symbolType);
            getFunctionArgument().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} definition element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createDefinition(){
    	StandardAssignable el = new StandardAssignable();
        this.definition = el;
        return el;
    }


	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(functionArgument)
				.addIfNotNull(definition);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
