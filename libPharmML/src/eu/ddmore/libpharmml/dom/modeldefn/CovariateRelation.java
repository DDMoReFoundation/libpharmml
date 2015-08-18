/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining the relationship between the covariate and a fixed effect parameter. Typically this defines a linear relationships.
 * 
 * <p>Java class for CovariateRelationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovariateRelationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *         &lt;element name="FixedEffect" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}FixedEffectRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovariateRelationType", propOrder = {
    "symbRef",
    "listOfFixedEffect"
})
public class CovariateRelation
    extends PharmMLRootType
{

    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT, required = true)
    protected SymbolRef symbRef;
    @XmlElement(name = "FixedEffect")
    protected List<FixedEffectRelation> listOfFixedEffect;

    /**
     * The covariate to be related.
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
     * The covariate to be related.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }
    
    /**
     * The fixed effect relating the parameter and covariate.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fixedEffect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFixedEffect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FixedEffectRelation }
     * 
     * 
     */
    public List<FixedEffectRelation> getListOfFixedEffect() {
        if (listOfFixedEffect == null) {
        	listOfFixedEffect = new ArrayList<FixedEffectRelation>();
        }
        return this.listOfFixedEffect;
    }

    /**
     * Gets the value of the fixedEffect property.
     * 
     * @return
     *     possible object is
     *     {@link FixedEffectRelation }
     *     
     * @deprecated Since PharmML 0.7, there can be multiple fixed effects. Use {@link #getListOfFixedEffect()}.
     */
    @Deprecated
    public FixedEffectRelation getFixedEffect() {
        if(getListOfFixedEffect().size() > 0){
        	return getListOfFixedEffect().get(0);
        } else {
        	return null;
        }
    }

    /**
     * Sets the value of the fixedEffect property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedEffectRelation }
     *   
     * @deprecated Since PharmML 0.7, there can be multiple fixed effects. Use {@link #getListOfFixedEffect()}.
     */
    public void setFixedEffect(FixedEffectRelation value) {
    	getListOfFixedEffect().clear();
        getListOfFixedEffect().add(value);
    }

    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(symbRef)
				.addIfNotNull(listOfFixedEffect);
	}

}
