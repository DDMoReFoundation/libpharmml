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
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.CovariateModelRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateDefinition;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 A type defining a covariate model - trial design version based on ModelDefinition 
 *                 without pop parameter, name etc.
 *             
 * 
 * <p>Java class for TD_CovariateModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TD_CovariateModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="CovariateModelRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}CovariateModelRefType" minOccurs="0"/>
 *         &lt;element name="Covariate" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}CovariateDefinitionType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TD_CovariateModelType", propOrder = {
    "covariateModelRef",
    "listOfCovariate"
})
public class TDCovariateModel
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "CovariateModelRef")
    protected CovariateModelRef covariateModelRef;
    @XmlElement(name = "Covariate", required = true)
    protected List<CovariateDefinition> listOfCovariate;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;
    
    public TDCovariateModel(){}
    
    public TDCovariateModel(String oid){
    	this.oid = oid;
    }

    /**
     * Reference to a covariate model from which the current model inherits its features.
     * 
     * @return
     *     possible object is
     *     {@link CovariateModelRef }
     *     
     */
    public CovariateModelRef getCovariateModelRef() {
        return covariateModelRef;
    }

    /**
     * Reference to a covariate model from which the current model inherits its features.
     * 
     * @param value
     *     allowed object is
     *     {@link CovariateModelRef }
     *     
     */
    public void setCovariateModelRef(CovariateModelRef value) {
        this.covariateModelRef = value;
    }

    /**
     * Gets the value of the covariate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the covariate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfCovariate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CovariateDefinition }
     * 
     * 
     */
    public List<CovariateDefinition> getListOfCovariate() {
        if (listOfCovariate == null) {
        	listOfCovariate = new ArrayList<CovariateDefinition>();
        }
        return this.listOfCovariate;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(covariateModelRef)
    			.addIfNotNull(listOfCovariate);
    }
    
    /**
     * Creates a new empty {@link CovariateModelRef} covariateModelRef element, adds it to the current object and returns it.
     * @return The created {@link CovariateModelRef} object.
     */
    public CovariateModelRef createCovariateModelRef(){
            CovariateModelRef el = new CovariateModelRef();
            this.covariateModelRef = el;
            return el;
    }

    /**
     * Creates a new empty {@link CovariateDefinition} covariate element, adds it to the current object and returns it.
     * @return The created {@link CovariateDefinition} object.
     */
    public CovariateDefinition createCovariate(){
            CovariateDefinition el = new CovariateDefinition();
            getListOfCovariate().add(el);
            return el;
    }


}
