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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.commontypes;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.IndependentVariable;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * References the independent variable.
 * 
 * <p>Java class for IndependentVariableReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndependentVariableReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndependentVariableReferenceType", propOrder = {
    "symbRef"
})
public class IndependentVariableReference
    extends PharmMLRootType
{

    @XmlElement(name = "SymbRef", required = true)
    protected SymbolRef symbRef;
    
    /**
     * Empty constructor.
     */
    public IndependentVariableReference(){}
    
    /**
     * Creates an independant variable reference with a symbol reference.
     * @param symbRef Symbol reference to the independant variable.
     */
    public IndependentVariableReference(SymbolRef symbRef){
    	this.symbRef = symbRef;
    }
    
    /**
     * Creates a new reference to the provided independent variable. This will create a
     * symbol reference with the symbol id of the independant variable when this method is
     * called. Any further update of the independant variable symbol id may lead to a
     * dangling reference.
     * @param variable {@link IndependentVariable} this object refers to.
     */
    public IndependentVariableReference(IndependentVariable variable){
    	this.symbRef = new SymbolRef();
    	this.symbRef.setId(variable.getSymbId());
    }

    /**
     * References the independent variable symbol.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(symbRef);
	}

}
