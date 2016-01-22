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
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type defining the population of subjects with covariates in the study.   
 *             
 * 
 * <p>Java class for IndividualCovariatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualCovariatesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VariabilityReference" minOccurs="0"/>
 *         &lt;element name="ColumnMapping" type="{http://www.pharmml.org/pharmml/0.7/Dataset}ColumnMappingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}DataSet"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualCovariatesType", propOrder = {
    "variabilityReference",
    "listOfColumnMapping",
    "dataSet"
})
public class IndividualCovariates
    extends PharmMLRootType
{

    @XmlElement(name = "VariabilityReference", namespace = XMLFilter.NS_DEFAULT_CT)
    protected LevelReference variabilityReference;
    @XmlElement(name = "ColumnMapping")
    protected List<ColumnMapping> listOfColumnMapping;
    @XmlElement(name = "DataSet", namespace = XMLFilter.NS_DEFAULT_DS, required = true)
    protected DataSet dataSet;

    /**
     * 
     * Refers to the variability level that defines the random variability between
     * the subjects of the study (BSV).
     *                             
     * 
     * @return
     *     possible object is
     *     {@link LevelReference }
     *     
     */
    public LevelReference getVariabilityReference() {
        return variabilityReference;
    }

    /**
     * Sets the value of the variabilityReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelReference }
     *     
     */
    public void setVariabilityReference(LevelReference value) {
        this.variabilityReference = value;
    }

    /**
     * Gets the value of the columnMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfColumnMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnMapping }
     * 
     * 
     */
    public List<ColumnMapping> getListOfColumnMapping() {
        if (listOfColumnMapping == null) {
        	listOfColumnMapping = new ArrayList<ColumnMapping>();
        }
        return this.listOfColumnMapping;
    }

    /**
     * 
     * Instantiates the individual template defined above with data for each subject within
     * the study.
     *                             
     * 
     * @return
     *     possible object is
     *     {@link DataSet }
     *     
     */
    public DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSet }
     *     
     */
    public void setDataSet(DataSet value) {
        this.dataSet = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(variabilityReference)
    			.addIfNotNull(listOfColumnMapping)
    			.addIfNotNull(dataSet);
    }
    
    /**
     * Creates a new empty {@link LevelReference} variabilityReference element, adds it to the current object and returns it.
     * @return The created {@link LevelReference} object.
     */
    public LevelReference createVariabilityReference(){
            LevelReference el = new LevelReference();
            this.variabilityReference = el;
            return el;
    }

    /**
     * Creates a new empty {@link ColumnMapping} ColumnMapping element, adds it to the current object and returns it.
     * @return The created {@link ColumnMapping} object.
     */
    public ColumnMapping createColumnMapping(){
            ColumnMapping el = new ColumnMapping();
            getListOfColumnMapping().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link DataSet} dataSet element, adds it to the current object and returns it.
     * @return The created {@link DataSet} object.
     */
    public DataSet createDataSet(){
            DataSet el = new DataSet();
            this.dataSet = el;
            return el;
    }

}
