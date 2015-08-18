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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type devining the covariates - individual and study-wise
 * 
 * <p>Java class for CovariatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovariatesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="IndividualCovariates" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}IndividualCovariatesType" minOccurs="0"/>
 *         &lt;element name="CovariateModel" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TD_CovariateModelType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovariatesType", propOrder = {
    "individualCovariates",
    "listOfCovariateModel"
})
public class Covariates
    extends PharmMLRootType
{

    @XmlElement(name = "IndividualCovariates")
    protected IndividualCovariates individualCovariates;
    @XmlElement(name = "CovariateModel")
    protected List<TDCovariateModel> listOfCovariateModel;

    /**
     * Gets the value of the individualCovariates property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualCovariates }
     *     
     */
    public IndividualCovariates getIndividualCovariates() {
        return individualCovariates;
    }

    /**
     * Sets the value of the individualCovariates property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualCovariates }
     *     
     */
    public void setIndividualCovariates(IndividualCovariates value) {
        this.individualCovariates = value;
    }

    /**
     * Gets the value of the covariateModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the covariateModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfCovariateModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDCovariateModel }
     * 
     * 
     */
    public List<TDCovariateModel> getListOfCovariateModel() {
        if (listOfCovariateModel == null) {
        	listOfCovariateModel = new ArrayList<TDCovariateModel>();
        }
        return this.listOfCovariateModel;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(individualCovariates)
    			.addIfNotNull(listOfCovariateModel);
    }
    
    /**
     * Creates a new empty {@link IndividualCovariates} individualCovariates element, adds it to the current object and returns it.
     * @return The created {@link IndividualCovariates} object.
     */
    public IndividualCovariates createIndividualCovariates(){
            IndividualCovariates el = new IndividualCovariates();
            this.individualCovariates = el;
            return el;
    }

    /**
     * Creates a new empty {@link TDCovariateModel} CovariateModel element, adds it to the current object and returns it.
     * @return The created {@link TDCovariateModel} object.
     */
    public TDCovariateModel createCovariateModel(){
            TDCovariateModel el = new TDCovariateModel();
            getListOfCovariateModel().add(el);
            return el;
    }


}
