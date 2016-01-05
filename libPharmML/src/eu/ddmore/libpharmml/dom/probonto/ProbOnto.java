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
package eu.ddmore.libpharmml.dom.probonto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.validation.Validatable;


/**
 * Type for ProbOnto distributions.
 * 
 * <p>Java class for ProbOntoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProbOntoType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Parameter" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionParameterType" maxOccurs="unbounded"/>
 *         &lt;element name="LowerTruncationBound" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionBoundType" minOccurs="0"/>
 *         &lt;element name="UpperTruncationBound" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionBoundType" minOccurs="0"/>
 *         &lt;element name="MixtureComponent" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}MixtureComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="ColumnMapping" type="{http://www.pharmml.org/pharmml/0.7/Dataset}ColumnMappingType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;sequence>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}DataSet"/>
 *           &lt;/sequence>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistroNameType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProbOntoType", propOrder = {
    "listOfParameter",
    "lowerTruncationBound",
    "upperTruncationBound",
    "listOfMixtureComponent",
	"listOfColumnMapping",
    "dataSet"
})
public class ProbOnto
    extends PharmMLRootType implements Validatable
{

    @XmlElement(name = "Parameter", required = true)
    protected List<DistributionParameter> listOfParameter;
    @XmlElement(name = "LowerTruncationBound")
    protected DistributionBound lowerTruncationBound;
    @XmlElement(name = "UpperTruncationBound")
    protected DistributionBound upperTruncationBound;
    @XmlElement(name = "MixtureComponent")
    protected List<MixtureComponent> listOfMixtureComponent;
	@XmlElement(name = "ColumnMapping")
    protected List<ColumnMapping> listOfColumnMapping;
    @XmlElement(name = "DataSet", namespace = XMLFilter.NS_DEFAULT_DS)
    protected DataSet dataSet;
    @XmlAttribute(name = "name", required = true)
    protected DistributionName name;

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributionParameter }
     * 
     * 
     */
    public List<DistributionParameter> getListOfParameter() {
        if (listOfParameter == null) {
        	listOfParameter = new ArrayList<DistributionParameter>();
        }
        return this.listOfParameter;
    }

    /**
     * Gets the value of the lowerTruncationBound property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionBound }
     *     
     */
    public DistributionBound getLowerTruncationBound() {
        return lowerTruncationBound;
    }

    /**
     * Sets the value of the lowerTruncationBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionBound }
     *     
     */
    public void setLowerTruncationBound(DistributionBound value) {
        this.lowerTruncationBound = value;
    }

    /**
     * Gets the value of the upperTruncationBound property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionBound }
     *     
     */
    public DistributionBound getUpperTruncationBound() {
        return upperTruncationBound;
    }

    /**
     * Sets the value of the upperTruncationBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionBound }
     *     
     */
    public void setUpperTruncationBound(DistributionBound value) {
        this.upperTruncationBound = value;
    }

    /**
     * Gets the value of the mixtureComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mixtureComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfMixtureComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MixtureComponent }
     * 
     * 
     */
    public List<MixtureComponent> getListOfMixtureComponent() {
        if (listOfMixtureComponent == null) {
        	listOfMixtureComponent = new ArrayList<MixtureComponent>();
        }
        return this.listOfMixtureComponent;
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
     *                                         Data for each subject within the study.
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

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionName }
     *     
     */
    public DistributionName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionName }
     *     
     */
    public void setName(DistributionName value) {
        this.name = value;
    }
    
    /**
     * Creates a new empty {@link DistributionParameter} listOfParameter element, adds it to the current object and returns it.
     * @return The created {@link DistributionParameter} object.
     */
    public DistributionParameter createParameter(){
            DistributionParameter el = new DistributionParameter();
            getListOfParameter().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link DistributionParameter} listOfParameter element, adds it to the current object and returns it.
     * @param name Name of the parameter. Check the validity of this name according to the name of
     * this distribution.
     * @return The created {@link DistributionParameter} object.
     */
    public DistributionParameter createParameter(ParameterName name){
            DistributionParameter el = new DistributionParameter();
            el.setName(name);
            getListOfParameter().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link DistributionBound} lowerTruncationBound element, adds it to the current object and returns it.
     * @return The created {@link DistributionBound} object.
     */
    public DistributionBound createLowerTruncationBound(){
            DistributionBound el = new DistributionBound();
            this.lowerTruncationBound = el;
            return el;
    }

    /**
     * Creates a new empty {@link DistributionBound} upperTruncationBound element, adds it to the current object and returns it.
     * @return The created {@link DistributionBound} object.
     */
    public DistributionBound createUpperTruncationBound(){
            DistributionBound el = new DistributionBound();
            this.upperTruncationBound = el;
            return el;
    }

    /**
     * Creates a new empty {@link MixtureComponent} listOfMixtureComponent element, adds it to the current object and returns it.
     * @return The created {@link MixtureComponent} object.
     */
    public MixtureComponent createMixtureComponent(){
            MixtureComponent el = new MixtureComponent();
            getListOfMixtureComponent().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link MixtureComponent} listOfMixtureComponent element, adds it to the current object and returns it.
     * @param name The name of the distribution.
     * @return The created {@link MixtureComponent} object.
     */
    public MixtureComponent createMixtureComponent(DistributionName name){
            MixtureComponent el = new MixtureComponent();
            el.setName(name);
            getListOfMixtureComponent().add(el);
            return el;
    }

    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfParameter)
    			.addIfNotNull(lowerTruncationBound)
    			.addIfNotNull(upperTruncationBound)
    			.addIfNotNull(listOfMixtureComponent)
    			.addIfNotNull(listOfColumnMapping)
    			.addIfNotNull(dataSet);
    }
    
    @Override
    public String toString() {
    	return super.toString()+" "+name;
    }

	@Override
	public void validate(IErrorHandler errorHandler) {
		//TODO: validate parameters based on distribution name
	}

}
