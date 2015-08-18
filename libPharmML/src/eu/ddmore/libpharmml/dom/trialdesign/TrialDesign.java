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
import eu.ddmore.libpharmml.dom.commontypes.ToolName;
import eu.ddmore.libpharmml.dom.modeldefn.DesignParameter;
import eu.ddmore.libpharmml.dom.modellingsteps.InterventionsReference;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 * Defines the design of the study.
 *    
 * <p>Since PharmML 0.7, the structure of TrialDesign has been deeply changed. Here is an overview of the
 * new content of this element:
 * <ul>
 * 		<li> {@link ExternalDataSet} </li>
 * 		<li> {@link Interventions} </li>
 * 		<ul>
 * 			<li> {@link Administration} </li>
 * 			<ul>
 * 				<li> {@link InterventionsReference} </li>
 * 				<li> {@link Bolus} </li>
 * 				<li> {@link Infusion} </li>
 * 			</ul>
 * 			<li> {@link IndividualAdministration} </li>
 * 			<li> {@link Action} - {@link Washout} </li>
 * 			<ul>
 * 				<li> full reset </li>
 * 				<li> variable-wise </li>
 * 			</ul>
 * 			<li> {@link InterventionsCombination} </li>
 * 		</ul>
 * 		<li> {@link Observations} </li>
 * 		<ul>
 * 			<li> {@link LookupTable} </li>
 * 			<li> IndividualObservations </li>
 * 			<li> {@link Observation} </li>
 * 			<li> {@link ObservationsCombination} </li>
 * 		</ul>
 * 		<li> {@link Covariates} </li>
 * 		<ul>
 * 			<li> {@link TDCovariateModel} </li>
 * 			<li> {@link IndividualCovariates} </li>
 *
 * 		</ul>
 * 		<li> {@link OccasionSequence} - {@link OccasionList} </li>
 * 		<ul>
 * 			<li> VariabilityReference </li>
 * 			<li> {@link Occasion} </li>
 * 		</ul>
 * 		<li> {@link Arms} </li>
 * 		<li> {@link DesignSpaces} </li>
 * </ul>            
 * 
 * <p>Java class for TrialDesignType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrialDesignType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DesignParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExternalDataSet" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ExternalDataSetType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Interventions" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}InterventionsType" minOccurs="0"/>
 *         &lt;element name="Observations" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ObservationsType" minOccurs="0"/>
 *         &lt;element name="Covariates" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}CovariatesType" minOccurs="0"/>
 *         &lt;element name="Occasions" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}OccasionSequenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DesignSpaces" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}DesignSpacesType" minOccurs="0"/>
 *         &lt;element name="Arms" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ArmsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrialDesignType", propOrder = {
    "structure",
    "population",
    "individualDosing",
    "listOfDesignParameter",
    "listOfExternalDataSet",
    "interventions",
    "observations",
    "covariates",
    "listOfOccasions",
    "designSpaces",
    "arms"
})
public class TrialDesign
    extends PharmMLRootType
{

    @XmlElement(name = "Structure")
    @Deprecated
    protected TrialStructure structure;
    @XmlElement(name = "Population")
    @Deprecated
    protected Population population;
    @XmlElement(name = "IndividualDosing")
    @Deprecated
    protected List<IndividualDosing> individualDosing;
    
    // PharmML 0.7
    @XmlElement(name = "DesignParameter", namespace = XMLFilter.NS_DEFAULT_MDEF)
    protected List<DesignParameter> listOfDesignParameter;
    @XmlElement(name = "ExternalDataSet")
    protected List<ExternalDataSet> listOfExternalDataSet;
    @XmlElement(name = "Interventions")
    protected Interventions interventions;
    @XmlElement(name = "Observations")
    protected Observations observations;
    @XmlElement(name = "Covariates")
    protected Covariates covariates;
    @XmlElement(name = "Occasions")
    protected List<OccasionSequence> listOfOccasions;
    @XmlElement(name = "DesignSpaces")
    protected DesignSpaces designSpaces;
    @XmlElement(name = "Arms")
    protected Arms arms;

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link TrialStructure }
     * 
     * @deprecated Since PharmML 0.7, the structure of {@link TrialDesign} has been deeply changed.
     * See PharmML-0.7 change document for a full description.
     */
    @Deprecated
    public TrialStructure getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrialStructure }
     *     
     * @deprecated Since PharmML 0.7, the structure of {@link TrialDesign} has been deeply changed.
     * See PharmML-0.7 change document for a full description.
     */
    @Deprecated
    public void setStructure(TrialStructure value) {
        this.structure = value;
    }

    /**
     * Gets the value of the population property.
     * 
     * @return
     *     possible object is
     *     {@link Population }
     *     
     * @deprecated Since PharmML 0.7, the structure of {@link TrialDesign} has been deeply changed.
     * See PharmML-0.7 change document for a full description.
     */
    @Deprecated
    public Population getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     * 
     * @param value
     *     allowed object is
     *     {@link Population }
     *     
     * @deprecated Since PharmML 0.7, the structure of {@link TrialDesign} has been deeply changed.
     * See PharmML-0.7 change document for a full description.
     */
    @Deprecated
    public void setPopulation(Population value) {
        this.population = value;
    }

    /**
     * Gets the value of the individualDosing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualDosing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualDosing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualDosing }
     * 
     *     
     * @deprecated Since PharmML 0.7, the structure of {@link TrialDesign} has been deeply changed.
     * See PharmML-0.7 change document for a full description.
     */
    @Deprecated
    public List<IndividualDosing> getIndividualDosing() {
        if (individualDosing == null) {
            individualDosing = new ArrayList<IndividualDosing>();
        }
        return this.individualDosing;
    }
    
    /**
     * A design parameter definition.Gets the value of the designParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfDesignParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DesignParameter }
     * 
     * @since PharmML 0.7
     */
    public List<DesignParameter> getListOfDesignParameter() {
        if (listOfDesignParameter == null) {
        	listOfDesignParameter = new ArrayList<DesignParameter>();
        }
        return this.listOfDesignParameter;
    }

    /**
     * Gets the value of the externalDataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalDataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfExternalDataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalDataSet }
     * 
     * @since PharmML 0.7
     */
    public List<ExternalDataSet> getListOfExternalDataSet() {
        if (listOfExternalDataSet == null) {
        	listOfExternalDataSet = new ArrayList<ExternalDataSet>();
        }
        return this.listOfExternalDataSet;
    }

    /**
     * Gets the value of the interventions property.
     * 
     * @return
     *     possible object is
     *     {@link Interventions }
     *  
     * @since PharmML 0.7
     */
    public Interventions getInterventions() {
        return interventions;
    }

    /**
     * Sets the value of the interventions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interventions }
     *     
     * @since PharmML 0.7
     */
    public void setInterventions(Interventions value) {
        this.interventions = value;
    }

    /**
     * Gets the value of the observations property.
     * 
     * @return
     *     possible object is
     *     {@link Observations }
     *     
     * @since PharmML 0.7
     */
    public Observations getObservations() {
        return observations;
    }

    /**
     * Sets the value of the observations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Observations }
     *     
     * @since PharmML 0.7
     */
    public void setObservations(Observations value) {
        this.observations = value;
    }

    /**
     * Gets the value of the covariates property.
     * 
     * @return
     *     possible object is
     *     {@link Covariates }
     *     
     * @since PharmML 0.7
     */
    public Covariates getCovariates() {
        return covariates;
    }

    /**
     * Sets the value of the covariates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Covariates }
     *     
     * @since PharmML 0.7
     */
    public void setCovariates(Covariates value) {
        this.covariates = value;
    }

    /**
     * Gets the value of the occasions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occasions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOccasions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OccasionSequence }
     * 
     * 
     * @since PharmML 0.7
     */
    public List<OccasionSequence> getListOfOccasions() {
        if (listOfOccasions == null) {
        	listOfOccasions = new ArrayList<OccasionSequence>();
        }
        return this.listOfOccasions;
    }

    /**
     * Gets the value of the designSpaces property.
     * 
     * @return
     *     possible object is
     *     {@link DesignSpaces }
     *     
     * @since PharmML 0.7
     */
    public DesignSpaces getDesignSpaces() {
        return designSpaces;
    }

    /**
     * Sets the value of the designSpaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignSpaces }
     *     
     * @since PharmML 0.7
     */
    public void setDesignSpaces(DesignSpaces value) {
        this.designSpaces = value;
    }

    /**
     * Gets the value of the arms property.
     * 
     * @return
     *     possible object is
     *     {@link Arms }
     *     
     * @since PharmML 0.7
     */
    public Arms getArms() {
        return arms;
    }

    /**
     * Sets the value of the arms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Arms }
     *     
     * @since PharmML 0.7
     */
    public void setArms(Arms value) {
        this.arms = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(structure)
				.addIfNotNull(population)
				.addIfNotNull(individualDosing)
				.addIfNotNull(listOfDesignParameter)
				.addIfNotNull(listOfExternalDataSet)
				.addIfNotNull(interventions)
				.addIfNotNull(observations)
				.addIfNotNull(covariates)
				.addIfNotNull(listOfOccasions)
				.addIfNotNull(designSpaces)
				.addIfNotNull(arms);
	}
    
    /**                                                              
    * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
    * @return The created {@link DesignParameter} object.                                                                     
    */                                                                                                                        
    public DesignParameter createDesignParameter(){                                                                           
        DesignParameter el = new DesignParameter();                                                                           
        getListOfDesignParameter().add(el);                                                                                   
        return el;                                                                                                            
    }        

    /**                                                              
    * Creates a new {@link DesignParameter} element, adds it to the current object and returns it.
    * @param symbId The symbol id of the parameter.                                                     
    * @return The created {@link DesignParameter} object.                                                                     
    */                                                                                                                        
    public DesignParameter createDesignParameter(String symbId){                                                                      
        DesignParameter el = new DesignParameter();                                                                                   
        el.setSymbId(symbId);                                                                                                         
        getListOfDesignParameter().add(el);                                                                                           
        return el;                                                                                                                    
    }                                                                                                                                 

    /**
     * Creates a new empty {@link ExternalDataSet} element, adds it to the current object and returns it.
     * @return The created {@link ExternalDataSet} object.                                                                     
     */                                                                                                                           
    public ExternalDataSet createExternalDataSet(){                                                                      
            ExternalDataSet el = new ExternalDataSet();                                                                     
            getListOfExternalDataSet().add(el);                                                                             
            return el;                                                                                                            
    }     
    
    /**
     * Creates a new empty {@link ExternalDataSet} element, adds it to the current object and returns it.
     * @param oid Object id
     * @param name The name of the external tool this dataset comes from.
     * @return The created {@link ExternalDataSet} object.                                                                     
     */                                                                                                                           
    public ExternalDataSet createExternalDataSet(String oid, ToolName name){                                                                      
            ExternalDataSet el = new ExternalDataSet();     
            el.setOid(oid);
            el.setToolName(name);
            getListOfExternalDataSet().add(el);                                                                             
            return el;                                                                                                            
    }   

    /**
     * Creates a new empty {@link Interventions} interventions element, adds it to the current object and returns it.
     * @return The created {@link Interventions} object.                                                             
     */                                                                                                              
    public Interventions createInterventions(){                                                                      
            Interventions el = new Interventions();                                                                  
            this.interventions = el;                                                                                 
            return el;                                                                                               
    }

    /**
     * Creates a new empty {@link Observations} observations element, adds it to the current object and returns it.
     * @return The created {@link Observations} object.
     */
    public Observations createObservations(){
            Observations el = new Observations();
            this.observations = el;
            return el;
    }

    /**
     * Creates a new empty {@link Covariates} covariates element, adds it to the current object and returns it.
     * @return The created {@link Covariates} object.
     */
    public Covariates createCovariates(){
            Covariates el = new Covariates();
            this.covariates = el;
            return el;
    }

    /**
     * Creates a new empty {@link OccasionSequence} occasions element, adds it to the current object and returns it.
     * @return The created {@link OccasionSequence} object.
     */
    public OccasionSequence createOccasions(){
            OccasionSequence el = new OccasionSequence();
            getListOfOccasions().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link DesignSpaces} designSpaces element, adds it to the current object and returns it.
     * @return The created {@link DesignSpaces} object.
     */
    public DesignSpaces createDesignSpaces(){
            DesignSpaces el = new DesignSpaces();
            this.designSpaces = el;
            return el;
    }

    /**
     * Creates a new empty {@link Arms} arms element, adds it to the current object and returns it.
     * @return The created {@link Arms} object.
     */
    public Arms createArms(){
            Arms el = new Arms();
            this.arms = el;
            return el;
    }


}
