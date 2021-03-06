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


package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.SymbolName;
import eu.ddmore.libpharmml.dom.tags.StructuralModelElement;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Abstract type defining the common properties of a parameter definition.
 * 
 * <p>Java class for CommonParameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Symbol" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbolIdType" />
 *       &lt;attribute name="symbIdRef" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@SuppressWarnings("deprecation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonParameterType", propOrder = {
    "symbol"
})
@XmlSeeAlso({
    ParameterRandomVariable.class,
    SimpleParameter.class,
    DesignParameter.class,
    PopulationParameter.class,
    IndividualParameter.class,
    Parameter.class,
})
public abstract class CommonParameter
    extends PharmMLRootType implements Symbol, StructuralModelElement
{

    @XmlElement(name = "Symbol", namespace = NS_DEFAULT_CT)
    protected SymbolName symbol;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;
    @XmlAttribute(name = "symbIdRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbIdRef; // PharmML 0.8
    
    public CommonParameter(){}
    
    public CommonParameter(String symbId){
    	this.symbId = symbId;
    }
    
    public CommonParameter(CommonParameter referredParameter){
    	this.symbIdRef = referredParameter.getSymbId();
    }

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
    @Override
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
    @Override
	public void setSymbId(String value) {
        this.symbId = value;
    }
    
    /**
     * Gets the value of the symbIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     * @since PharmML 0.8
     */
    public String getSymbIdRef() {
        return symbIdRef;
    }

    /**
     * Sets the value of the symbIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @since PharmML 0.8
     */
    public void setSymbIdRef(String value) {
        this.symbIdRef = value;
    }

    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(symbol);
	}

}
