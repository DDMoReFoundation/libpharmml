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

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.modeldefn.DesignParameter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining the interventions: administrations and actions.
 * 
 * <p>Java class for InterventionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterventionsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DesignParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Administration" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}AdministrationType" maxOccurs="unbounded"/>
 *         &lt;element name="IndividualAdministration" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}IndividualAdministrationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ActionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InterventionsCombination" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}InterventionsCombinationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterventionsType", propOrder = {
    "listOfDesignParameter",
    "listOfAdministration",
    "listOfIndividualAdministration",
    "listOfLookupTable",
    "listOfAction",
    "listOfInterventionsCombination"
})
public class Interventions
    extends PharmMLRootType
{

    @XmlElement(name = "DesignParameter", namespace = NS_DEFAULT_MDEF)
    protected List<DesignParameter> listOfDesignParameter;
    @XmlElement(name = "Administration", required = true)
    protected List<Administration> listOfAdministration;
    @XmlElement(name = "IndividualAdministration")
    protected List<IndividualAdministration> listOfIndividualAdministration;
    @XmlElement(name = "LookupTable")
    protected List<LookupTable> listOfLookupTable; // PharmML 0.8
    @XmlElement(name = "Action")
    protected List<Action> listOfAction;
    @XmlElement(name = "InterventionsCombination")
    protected List<InterventionsCombination> listOfInterventionsCombination;

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
     * 
     */
    public List<DesignParameter> getListOfDesignParameter() {
        if (listOfDesignParameter == null) {
        	listOfDesignParameter = new ArrayList<DesignParameter>();
        }
        return this.listOfDesignParameter;
    }

    /**
     * Gets the value of the administration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the administration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfAdministration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Administration }
     * 
     * 
     */
    public List<Administration> getListOfAdministration() {
        if (listOfAdministration == null) {
        	listOfAdministration = new ArrayList<Administration>();
        }
        return this.listOfAdministration;
    }

    /**
     * Gets the value of the individualAdministration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualAdministration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfIndividualAdministration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualAdministration }
     * 
     * 
     */
    public List<IndividualAdministration> getListOfIndividualAdministration() {
        if (listOfIndividualAdministration == null) {
        	listOfIndividualAdministration = new ArrayList<IndividualAdministration>();
        }
        return this.listOfIndividualAdministration;
    }
    
    /**
     * Gets the value of the lookupTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lookupTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLookupTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LookupTable }
     * 
     * @since PharmML 0.8
     */
    public List<LookupTable> getListOfLookupTable() {
        if (listOfLookupTable == null) {
        	listOfLookupTable = new ArrayList<LookupTable>();
        }
        return this.listOfLookupTable;
    }

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Action }
     * 
     * 
     */
    public List<Action> getListOfAction() {
        if (listOfAction == null) {
        	listOfAction = new ArrayList<Action>();
        }
        return this.listOfAction;
    }

    /**
     * Gets the value of the interventionsCombination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interventionsCombination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterventionsCombination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterventionsCombination }
     * 
     * 
     */
    public List<InterventionsCombination> getListOfInterventionsCombination() {
        if (listOfInterventionsCombination == null) {
        	listOfInterventionsCombination = new ArrayList<InterventionsCombination>();
        }
        return this.listOfInterventionsCombination;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfDesignParameter)
    			.addIfNotNull(listOfAdministration)
    			.addIfNotNull(listOfIndividualAdministration)
    			.addIfNotNull(listOfLookupTable)
    			.addIfNotNull(listOfAction)
    			.addIfNotNull(listOfInterventionsCombination);
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
    * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
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
     * Creates a new empty {@link Administration} Administration element, adds it to the current object and returns it.
     * @return The created {@link Administration} object.
     */
    public Administration createAdministration(){
            Administration el = new Administration();
            getListOfAdministration().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link Administration} Administration element, adds it to the current object and returns it.
     * @param oid
     * @return The created {@link Administration} object.
     */
    public Administration createAdministration(String oid){
            Administration el = new Administration();
            el.setOid(oid);
            getListOfAdministration().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link IndividualAdministration} IndividualAdministration element, adds it to the current object and returns it.
     * @return The created {@link IndividualAdministration} object.
     */
    public IndividualAdministration createIndividualAdministration(){
            IndividualAdministration el = new IndividualAdministration();
            getListOfIndividualAdministration().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link Action} Action element, adds it to the current object and returns it.
     * @return The created {@link Action} object.
     */
    public Action createAction(){
            Action el = new Action();
            getListOfAction().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link InterventionsCombination} InterventionsCombination element, adds it to the current object and returns it.
     * @return The created {@link InterventionsCombination} object.
     */
    public InterventionsCombination createInterventionsCombination(){
            InterventionsCombination el = new InterventionsCombination();
            getListOfInterventionsCombination().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link LookupTable} element, adds it to the current object and returns it.
     * @return The created {@link LookupTable} object.
     */
    public LookupTable createLookupTable(){
    	LookupTable lt = new LookupTable();
    	getListOfLookupTable().add(lt);
    	return lt;
    }

}
