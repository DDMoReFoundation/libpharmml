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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.tags.StructuralModelElement;


/**
 * 
 *                 An abstract type defining the comment properties of a variable definition.
 *             
 * 
 * <p>Java class for CommonVariableDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonVariableDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Symbol" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="symbId" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonVariableDefinitionType", propOrder = {
    "symbol"
})
@XmlSeeAlso({
    FunctionDefinition.class,
    VariableDefinition.class,
    DerivativeVariable.class,
    FunctionParameter.class
})
public abstract class CommonVariableDefinition
    extends PharmMLRootType implements Symbol, StructuralModelElement
{

    @XmlElement(name = "Symbol")
    protected SymbolName symbol;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;
    
    // PharmML 0.8.1
    @XmlAttribute(name = "symbIdRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbIdRef;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolName }
     *     
     */
    public SymbolName getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolName }
     *     
     */
    public void setSymbol(SymbolName value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the symbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbId() {
        return symbId;
    }

    /**
     * Sets the value of the symbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbId(String value) {
        this.symbId = value;
    }
    
    /**
     * Gets the value of the symbIdRef property. This attribute is used within conditional statements when the variable
     * must be declared within the {@link StructuralModel} element.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     * @since PharmML 0.8.1
     */
    public String getSymbIdRef() {
        return symbIdRef;
    }

    /**
     * Sets the value of the symbIdRef property. This attribute is used within conditional statements when the variable
     * must be declared within the {@link StructuralModel} element.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @since PharmML 0.8.1
     */
    public void setSymbIdRef(String value) {
        this.symbIdRef = value;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder(super.toString());
    	sb.append(" ");
    	if(symbIdRef != null){
    		sb.append("symbIdRef:").append(symbIdRef);
    	} else {
    		sb.append("symbId:").append(symbId);
    	}
    	return sb.toString();
    }

}
