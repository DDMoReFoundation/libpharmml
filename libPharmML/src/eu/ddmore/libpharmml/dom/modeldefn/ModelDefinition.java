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
 * Type that specifies the model definition section of the PharmML document.
 * 
 * <p>Java class for ModelDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModelDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="VariabilityModel" type="{http://www.pharmml.org/2013/03/ModelDefinition}VariabilityDefnBlock" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CovariateModel" type="{http://www.pharmml.org/2013/03/ModelDefinition}CovariateModelType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ParameterModel" type="{http://www.pharmml.org/2013/03/ModelDefinition}ParameterModelType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}StructuralModel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ObservationModel" type="{http://www.pharmml.org/2013/03/ModelDefinition}ObservationModelType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelDefinitionType", propOrder = {
    "listOfVariabilityModel",
    "listOfCovariateModel",
    "listOfParameterModel",
    "listOfStructuralModel",
    "listOfObservationModel"
})
public class ModelDefinition
    extends PharmMLRootType
{

    @XmlElement(name = "VariabilityModel")
    protected List<VariabilityDefnBlock> listOfVariabilityModel;
    @XmlElement(name = "CovariateModel")
    protected List<CovariateModel> listOfCovariateModel;
    @XmlElement(name = "ParameterModel")
    protected List<ParameterModel> listOfParameterModel;
    @XmlElement(name = "StructuralModel")
    protected List<StructuralModel> listOfStructuralModel;
    @XmlElement(name = "ObservationModel")
    protected List<ObservationModel> listOfObservationModel;

    /**
     * @deprecated Since libPharmML 0.4. Use {@link #getListOfVariabilityModel()} instead.
     */
    @Deprecated
    public List<VariabilityDefnBlock> getVariabilityModel() {
        return getListOfVariabilityModel();
    }
    /**
     * Gets the list of the variability models.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variabilityModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariabilityModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariabilityDefnBlock }
     * 
     * 
     */
    public List<VariabilityDefnBlock> getListOfVariabilityModel() {
        if (listOfVariabilityModel == null) {
        	listOfVariabilityModel = new ArrayList<VariabilityDefnBlock>();
        }
        return this.listOfVariabilityModel;
    }

    /**
     * @deprecated Since libPharmML 0.4. Use {@link #getListOfCovariateModel()} instead.
     */
    @Deprecated
    public List<CovariateModel> getCovariateModel() {
        return getListOfCovariateModel();
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
     *    getCovariateModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CovariateModel }
     * 
     * 
     */
    public List<CovariateModel> getListOfCovariateModel() {
        if (listOfCovariateModel == null) {
        	listOfCovariateModel = new ArrayList<CovariateModel>();
        }
        return this.listOfCovariateModel;
    }

    /**
     * @deprecated Since libPharmML 0.4. Use {@link #getListOfParameterModel()} instead.
     */
    @Deprecated
    public List<ParameterModel> getParameterModel() {
        return getListOfParameterModel();
    }
    /**
     * Gets the list of the parameter models.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterModel }
     * 
     * 
     */
    public List<ParameterModel> getListOfParameterModel() {
        if (listOfParameterModel == null) {
        	listOfParameterModel = new ArrayList<ParameterModel>();
        }
        return this.listOfParameterModel;
    }

    /**
     * @deprecated Since libPharmML 0.4. Use {@link #getListOfStructuralModel()} instead.
     */
    @Deprecated
    public List<StructuralModel> getStructuralModel() {
        return getListOfStructuralModel();
    }
    /**
     * Gets the list of structural models.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the structuralModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStructuralModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructuralModel }
     * 
     * 
     */
    public List<StructuralModel> getListOfStructuralModel() {
        if (listOfStructuralModel == null) {
        	listOfStructuralModel = new ArrayList<StructuralModel>();
        }
        return this.listOfStructuralModel;
    }

    /**
     * @deprecated Since libPharmML 0.4. Use {@link #getListOfObservationModel()} instead.
     */
    @Deprecated
    public List<ObservationModel> getObservationModel() {
        return getListOfObservationModel();
    }
    /**
     * Gets the list of observation models.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the observationModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObservationModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObservationModel }
     * 
     * 
     */
    public List<ObservationModel> getListOfObservationModel() {
        if (listOfObservationModel == null) {
        	listOfObservationModel = new ArrayList<ObservationModel>();
        }
        return this.listOfObservationModel;
    }
    
    /**
     * Creates a new empty {@link VariabilityDefnBlock} variabilityModel element, adds it to the current object and returns it.
     * @return The created {@link VariabilityDefnBlock} object.
     */
    public VariabilityDefnBlock createVariabilityModel(){
            VariabilityDefnBlock el = new VariabilityDefnBlock();
            getListOfVariabilityModel().add(el);
            return el;
    }
    /**
     * Creates a new {@link VariabilityDefnBlock} variabilityModel element, adds it to the current object and returns it.
     * @param blkId
     * @param variability
     * @return The created {@link VariabilityDefnBlock} object.
     */
    public VariabilityDefnBlock createVariabilityModel(String blkId, Variability variability){
            VariabilityDefnBlock el = createVariabilityModel();
            el.setBlkId(blkId);
            el.setType(variability);
            return el;
    }

    /**
     * Creates a new empty {@link CovariateModel} covariateModel element, adds it to the current object and returns it.
     * @return The created {@link CovariateModel} object.
     */
    public CovariateModel createCovariateModel(){
            CovariateModel el = new CovariateModel();
            getListOfCovariateModel().add(el);
            return el;
    }
    /**
     * Creates a new {@link CovariateModel} covariateModel element, adds it to the current object and returns it.
     * @param blkId Block id of the covariate model.
     * @return The created {@link CovariateModel} object.
     */
    public CovariateModel createCovariateModel(String blkId){
            CovariateModel el = createCovariateModel();
            el.setBlkId(blkId);
            return el;
    }

    /**
     * Creates a new {@link ParameterModel} parameterModel element, adds it to the current object and returns it.
     * @return The created {@link ParameterModel} object.
     */
    public ParameterModel createParameterModel(){
            ParameterModel el = new ParameterModel();
            getListOfParameterModel().add(el);
            return el;
    }
    /**
     * Creates a new empty {@link ParameterModel} parameterModel element, adds it to the current object and returns it.
     * @param blkId Block id of the parameter model.
     * @return The created {@link ParameterModel} object.
     */
    public ParameterModel createParameterModel(String blkId){
            ParameterModel el = createParameterModel();
            el.setBlkId(blkId);
            return el;
    }

    /**
     * Creates a new empty {@link StructuralModel} structuralModel element, adds it to the current object and returns it.
     * @return The created {@link StructuralModel} object.
     */
    public StructuralModel createStructuralModel(){
            StructuralModel el = new StructuralModel();
            getListOfStructuralModel().add(el);
            return el;
    }
    /**
     * Creates a new {@link StructuralModel} structuralModel element, adds it to the current object and returns it.
     * @param blkId Block id of the structural model.
     * @return The created {@link StructuralModel} object.
     */
    public StructuralModel createStructuralModel(String blkId){
            StructuralModel el = createStructuralModel();
            el.setBlkId(blkId);
            return el;
    }

    /**
     * Creates a new empty {@link ObservationModel} observationModel element, adds it to the current object and returns it.
     * @return The created {@link ObservationModel} object.
     */
    public ObservationModel createObservationModel(){
            ObservationModel el = new ObservationModel();
            getListOfObservationModel().add(el);
            return el;
    }
    /**
     * Creates a new {@link ObservationModel} observationModel element, adds it to the current object and returns it.
     * @param blkId Block id of the observation model.
     * @return The created {@link ObservationModel} object.
     */
    public ObservationModel createObservationModel(String blkId){
            ObservationModel el = createObservationModel();
            el.setBlkId(blkId);
            return el;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(listOfVariabilityModel)
				.addIfNotNull(listOfCovariateModel)
				.addIfNotNull(listOfParameterModel)
				.addIfNotNull(listOfStructuralModel)
				.addIfNotNull(listOfObservationModel);
	}


}
