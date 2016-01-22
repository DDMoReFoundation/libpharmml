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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolName;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type that specifies a covariate definition.
 * 
 * <p>Java class for DSCovariateDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSCovariateDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Symbol" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Continuous" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}ContinuousCovariateType"/>
 *           &lt;element name="Categorical" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DSCategoricalCovariateType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}CovariateAttributeGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSCovariateDefinitionType", propOrder = {
    "symbol",
    "continuous",
    "categorical"
})
public class DSCovariateDefinitionType
    extends PharmMLRootType
{

    @XmlElement(name = "Symbol", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolName symbol;
    @XmlElement(name = "Continuous")
    protected ContinuousCovariate continuous;
    @XmlElement(name = "Categorical")
    protected DSCategoricalCovariateType categorical;
    @XmlAttribute(name = "symbIdRef", required = true)
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
     * Gets the value of the continuous property.
     * 
     * @return
     *     possible object is
     *     {@link ContinuousCovariate }
     *     
     */
    public ContinuousCovariate getContinuous() {
        return continuous;
    }

    /**
     * Sets the value of the continuous property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuousCovariate }
     *     
     */
    public void setContinuous(ContinuousCovariate value) {
        this.continuous = value;
    }

    /**
     * Gets the value of the categorical property.
     * 
     * @return
     *     possible object is
     *     {@link DSCategoricalCovariateType }
     *     
     */
    public DSCategoricalCovariateType getCategorical() {
        return categorical;
    }

    /**
     * Sets the value of the categorical property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSCategoricalCovariateType }
     *     
     */
    public void setCategorical(DSCategoricalCovariateType value) {
        this.categorical = value;
    }

    /**
     * Gets the value of the symbIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
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
     */
    public void setSymbIdRef(String value) {
        this.symbIdRef = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(symbol)
    			.addIfNotNull(continuous)
    			.addIfNotNull(categorical);
    }


}
