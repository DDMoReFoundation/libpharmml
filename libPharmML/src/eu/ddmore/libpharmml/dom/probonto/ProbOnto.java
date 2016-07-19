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
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


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
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}StandardAssignType" minOccurs="0"/>
 *             &lt;element name="Weight" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}StandardAssignType" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="Parameter" type="{http://www.pharmml.org/probonto/ProbOnto}DistributionParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="LowerTruncationBound" type="{http://www.pharmml.org/probonto/ProbOnto}DistributionBoundType" minOccurs="0"/>
 *             &lt;element name="UpperTruncationBound" type="{http://www.pharmml.org/probonto/ProbOnto}DistributionBoundType" minOccurs="0"/>
 *             &lt;element name="MixtureComponent" type="{http://www.pharmml.org/probonto/ProbOnto}MixtureComponent" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="ColumnMapping" type="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnMappingType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;sequence>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Dataset}DataSet"/>
 *           &lt;/sequence>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.pharmml.org/probonto/ProbOnto}DistroType" />
 *       &lt;attribute name="name" use="required" type="{http://www.pharmml.org/probonto/ProbOnto}DistroNameType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProbOntoType", propOrder = {
		"realisation",
		"weight",
    "listOfParameter",
    "lowerTruncationBound",
    "upperTruncationBound",
    "listOfMixtureComponent",
	"listOfColumnMapping",
    "dataSet"
})
public class ProbOnto
    extends PharmMLRootType implements IProbOntoDistribution
{

	// Choice 1
	@XmlElement(name = "Realisation")
    protected StandardAssignable realisation;
    @XmlElement(name = "Weight")
    protected StandardAssignable weight;
    
    // Choice 2
    @XmlElement(name = "Parameter")
    protected List<DistributionParameter> listOfParameter;
    @XmlElement(name = "LowerTruncationBound")
    protected DistributionBound lowerTruncationBound;
    @XmlElement(name = "UpperTruncationBound")
    protected DistributionBound upperTruncationBound;
    @XmlElement(name = "MixtureComponent")
    protected List<MixtureComponent> listOfMixtureComponent;
    
	@XmlElement(name = "ColumnMapping")
    protected List<ColumnMapping> listOfColumnMapping;
    @XmlElement(name = "DataSet", namespace = NS_DEFAULT_DS)
    protected DataSet dataSet;
	@XmlAttribute(name = "type")
    protected DistributionType type;
    @XmlAttribute(name = "name", required = true)
    protected DistributionName name;
    
    /**
     * Empty constructor.
     */
    public ProbOnto(){
    	
    }
    
    /**
     * Minimal constructor.
     * @param name The name of the distribution.
     */
    public ProbOnto(DistributionName name){
    	this.name = name;
    }
    
    /**
     * Constructs a {@link ProbOnto} distribution with the given name and type.
     * @param name The name of the distribution (required).
     * @param type The type of the distribution, univariate or multivariate. Can be null.
     */
    public ProbOnto(DistributionName name, DistributionType type){
    	this.name = name;
    	this.type = type;
    }

    /**
     * Gets the value of the realisation property. Allows assignment of a symbol identifier 
     * used later for mapping with datacolumns in the dataset.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable getRealisation() {
        return realisation;
    }

    /**
     * Sets the value of the realisation property. Allows assignment of a symbol identifier 
     * used later for mapping with datacolumns in the dataset.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     * @since ProbOnto 1.1.1
     */
    public void setRealisation(StandardAssignable value) {
        this.realisation = value;
    }

    /**
     * Gets the value of the weight property. Allows assignment of a symbol identifier mapped to the
	 * weight in the dataset
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property. Allows assignment of a symbol identifier mapped to the
	 * weight in the dataset
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     * @since ProbOnto 1.1.1
     */
    public void setWeight(StandardAssignable value) {
        this.weight = value;
    }

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
    @Override
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionType }
     *     
     */
    public DistributionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionType }
     *     
     */
    public void setType(DistributionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionName }
     *     
     */
    @Override
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
    @Override
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
    
    /**
     * Creates a new {@link StandardAssignable} realisation, adds it to the current ProbOnto object and returns it.
     * @return The created realisation as a {@link StandardAssignable} instance.
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable createRealisation(){
    	StandardAssignable sa = new StandardAssignable();
    	this.realisation = sa;
    	return sa;
    }
    
    /**
     * Creates a new {@link StandardAssignable} realisation, adds it to the current ProbOnto object and returns it.
     * @param rhs The {@link Rhs} assignment of the realisation.
     * @return The created realisation as a {@link StandardAssignable} instance.
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable createRealisation(Rhs rhs){
    	StandardAssignable sa = new StandardAssignable();
    	sa.setAssign(rhs);
    	this.realisation = sa;
    	return sa;
    }

    /**
     * Creates a new {@link StandardAssignable} weight, adds it to the current ProbOnto object and returns it.
     * @return The created weight as a {@link StandardAssignable} instance.
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable createWeight(){
    	StandardAssignable sa = new StandardAssignable();
    	this.weight = sa;
    	return sa;
    }
    
    /**
     * Creates a new {@link StandardAssignable} weight, adds it to the current ProbOnto object and returns it.
     * @param rhs The {@link Rhs} assignment of the weight.
     * @return The created weight as a {@link StandardAssignable} instance.
     * @since ProbOnto 1.1.1
     */
    public StandardAssignable createWeight(Rhs rhs){
    	StandardAssignable sa = new StandardAssignable();
    	sa.setAssign(rhs);
    	this.weight = sa;
    	return sa;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(realisation)
    			.addIfNotNull(weight)
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
		Util.validateProbOnto(this, errorHandler);
	}
	
	/**
	 * Gets the {@link DistributionParameter} defined with the given name. If the parameter is not defined,
	 * this method returns null.
	 * @param parameter Name of the parameter
	 * @return The {@link DistributionParameter} with the given name.
	 */
	@Override
	public DistributionParameter getParameter(ParameterName parameter){
		for(DistributionParameter dp : getListOfParameter()){
			if(dp.getName() != null && dp.getName().equals(parameter)){
				return dp;
			}
		}
		return null;
	}
	
	/**
	 * Checks if this distribution contains the given parameter.
	 * @param parameter Name of the parameter
	 * @return true if the parameter is defined, else false.
	 */
	@Override
	public boolean containsParameter(ParameterName parameter){
		for(DistributionParameter dp : getListOfParameter()){
			if(dp.getName() != null && dp.getName().equals(parameter)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
