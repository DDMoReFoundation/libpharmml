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

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.CovariateModelRef;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.modeldefn.DSCovariateDefinitionType;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.validation.SymbolResolver;


/**
 * 
 *                 Type defining a single design space for optimization.
 *             
 * 
 * <p>Java class for SingleDesignSpaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SingleDesignSpaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="InterventionRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="ObservationRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="ArmRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef" maxOccurs="unbounded"/>
 *           &lt;sequence minOccurs="0">
 *             &lt;element name="CovariateModelRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}CovariateModelRef"/>
 *             &lt;element name="CovariateRef" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DSCovariateDefinitionType"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;choice>
 *             &lt;element name="ArmSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="DoseAmount" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="DosingTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="Duration" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="NumberArms" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="NumberSamples" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="NumberTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *             &lt;element name="ObservationTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignable" minOccurs="0"/>
 *           &lt;/choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleDesignSpaceType", propOrder = {
    "listOfInterventionRef",
    "listOfObservationRef",
    "listOfArmRef",
    "listOfSymbRef",
    "covariateModelRef",
    "covariateRef",
    "armSize",
    "doseAmount",
    "dosingTimes",
    "duration",
    "numberArms",
    "numberSamples",
    "numberTimes",
    "observationTimes",
    "assign"
})
public class SingleDesignSpace
    extends PharmMLRootType implements ReferenceContainer
{

	// Choice 1
    @XmlElement(name = "InterventionRef")
    protected List<OidRef> listOfInterventionRef;
    @XmlElement(name = "ObservationRef")
    protected List<OidRef> listOfObservationRef;
    @XmlElement(name = "ArmRef")
    protected List<OidRef> listOfArmRef;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected List<SymbolRef> listOfSymbRef;
    /// Sequence
    @XmlElement(name = "CovariateModelRef")
    protected CovariateModelRef covariateModelRef;
    @XmlElement(name = "CovariateRef")
    protected DSCovariateDefinitionType covariateRef;
    /// --------
    
    // Choice 2
    @XmlElement(name = "ArmSize")
    protected StandardAssignable armSize;
    @XmlElement(name = "DoseAmount")
    protected StandardAssignable doseAmount;
    @XmlElement(name = "DosingTimes")
    protected StandardAssignable dosingTimes;
    @XmlElement(name = "Duration")
    protected StandardAssignable duration;
    @XmlElement(name = "NumberArms")
    protected StandardAssignable numberArms;
    @XmlElement(name = "NumberSamples")
    protected StandardAssignable numberSamples;
    @XmlElement(name = "NumberTimes")
    protected StandardAssignable numberTimes;
    @XmlElement(name = "ObservationTimes")
    protected StandardAssignable observationTimes;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;

    /**
     * Gets the value of the listOfInterventionRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfInterventionRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfInterventionRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OidRef }
     * 
     * 
     */
    public List<OidRef> getListOfInterventionRef() {
        if (listOfInterventionRef == null) {
            listOfInterventionRef = new ArrayList<OidRef>();
        }
        return this.listOfInterventionRef;
    }

    /**
     * Gets the value of the listOfObservationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfObservationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfObservationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OidRef }
     * 
     * 
     */
    public List<OidRef> getListOfObservationRef() {
        if (listOfObservationRef == null) {
            listOfObservationRef = new ArrayList<OidRef>();
        }
        return this.listOfObservationRef;
    }

    /**
     * Gets the value of the listOfArmRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfArmRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArmRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OidRef }
     * 
     * 
     */
    public List<OidRef> getListOfArmRef() {
        if (listOfArmRef == null) {
            listOfArmRef = new ArrayList<OidRef>();
        }
        return this.listOfArmRef;
    }

    /**
     * 
     *                                     Refers to the variable to be optimized. 
     *                                 Gets the value of the listOfSymbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfSymbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolRef }
     * 
     * 
     */
    public List<SymbolRef> getListOfSymbRef() {
        if (listOfSymbRef == null) {
            listOfSymbRef = new ArrayList<SymbolRef>();
        }
        return this.listOfSymbRef;
    }

    /**
     * Gets the value of the covariateModelRef property.
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
     * Sets the value of the covariateModelRef property.
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
     * Gets the value of the covariateRef property.
     * 
     * @return
     *     possible object is
     *     {@link DSCovariateDefinitionType }
     *     
     */
    public DSCovariateDefinitionType getCovariateRef() {
        return covariateRef;
    }

    /**
     * Sets the value of the covariateRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSCovariateDefinitionType }
     *     
     */
    public void setCovariateRef(DSCovariateDefinitionType value) {
        this.covariateRef = value;
    }

    /**
     * Gets the value of the armSize property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getArmSize() {
        return armSize;
    }

    /**
     * Sets the value of the armSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setArmSize(StandardAssignable value) {
        this.armSize = value;
    }

    /**
     * Gets the value of the doseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getDoseAmount() {
        return doseAmount;
    }

    /**
     * Sets the value of the doseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setDoseAmount(StandardAssignable value) {
        this.doseAmount = value;
    }

    /**
     * Gets the value of the dosingTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getDosingTimes() {
        return dosingTimes;
    }

    /**
     * Sets the value of the dosingTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setDosingTimes(StandardAssignable value) {
        this.dosingTimes = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setDuration(StandardAssignable value) {
        this.duration = value;
    }

    /**
     * Gets the value of the numberArms property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberArms() {
        return numberArms;
    }

    /**
     * Sets the value of the numberArms property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberArms(StandardAssignable value) {
        this.numberArms = value;
    }

    /**
     * Gets the value of the numberSamples property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberSamples() {
        return numberSamples;
    }

    /**
     * Sets the value of the numberSamples property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberSamples(StandardAssignable value) {
        this.numberSamples = value;
    }

    /**
     * Gets the value of the numberTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberTimes() {
        return numberTimes;
    }

    /**
     * Sets the value of the numberTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberTimes(StandardAssignable value) {
        this.numberTimes = value;
    }

    /**
     * Gets the value of the observationTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getObservationTimes() {
        return observationTimes;
    }

    /**
     * Sets the value of the observationTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setObservationTimes(StandardAssignable value) {
        this.observationTimes = value;
    }

    /**
     * Defines the optimization space of the referenced item..
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

	@Override
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(listOfInterventionRef)
				.addIfNotNull(listOfObservationRef)
				.addIfNotNull(listOfArmRef)
				.addIfNotNull(listOfSymbRef)
				.addIfNotNull(covariateModelRef)
				.addIfNotNull(covariateRef)
				.addIfNotNull(armSize)
				.addIfNotNull(doseAmount)
				.addIfNotNull(dosingTimes)
				.addIfNotNull(duration)
				.addIfNotNull(numberArms)
				.addIfNotNull(numberSamples)
				.addIfNotNull(numberTimes)
				.addIfNotNull(observationTimes)
				.addIfNotNull(assign);
	}
	
	/**                                                              
	 * Creates a new empty {@link OidRef} InterventionRef element, adds it to the current object and returns it.
	 * @return The created {@link OidRef} object.                                                               
	 */                                                                                                         
	public OidRef createInterventionRef(){                                                                      
	        OidRef el = new OidRef();                                                                           
	        getListOfInterventionRef().add(el);                                                              
	        return el;                                                                                          
	}                                                                                                           

	/**
	 * Creates a new {@link OidRef} InterventionRef, adds it to the current object and returns it.
	 * @param oidRef Reference to the intervention.                                                     
	 * @return The created {@link OidRef} object.                                                       
	 */                                                                                                 
	public OidRef createInterventionRef(String oidRef){                                                 
	        OidRef el = new OidRef();                                                                   
	        el.setOidRef(oidRef);                                                                       
	        getListOfInterventionRef().add(el);                                                         
	        return el;                                                                                  
	}                                                                                                   

	/**
	 * Creates a new empty {@link OidRef} ObservationRef element, adds it to the current object and returns it.
	 * @return The created {@link OidRef} object.                                                              
	 */                                                                                                        
	public OidRef createObservationRef(){                                                                      
	        OidRef el = new OidRef();                                                                          
	        getListOfObservationRef().add(el);                                                                 
	        return el;                                                                                         
	}                                                                                                          

	/**
	 * Creates a new {@link OidRef} ObservationRef, adds it to the current object and returns it.
	 * @param oidRef Reference to the intervention.                                                    
	 * @return The created {@link OidRef} object.                                                      
	 */                                                                                                
	public OidRef createObservationRef(String oidRef){                                                 
	        OidRef el = new OidRef();                                                                  
	        el.setOidRef(oidRef);                                                                      
	        getListOfObservationRef().add(el);                                                         
	        return el;                                                                                 
	}                                                                                                  

	/**
	 * Creates a new empty {@link OidRef} ArmRef element, adds it to the current object and returns it.
	 * @return The created {@link OidRef} object.                                                      
	 */                                                                                                
	public OidRef createArmRef(){                                                                      
	        OidRef el = new OidRef();                                                                  
	        getListOfArmRef().add(el);                                                                 
	        return el;                                                                                 
	}                                                                                                  

	/**
	 * Creates a new {@link OidRef} ArmRef, adds it to the current object and returns it.
	 * @param oidRef Reference to the intervention.                                            
	 * @return The created {@link OidRef} object.                                              
	 */                                                                                        
	public OidRef createArmRef(String oidRef){                                                 
	        OidRef el = new OidRef();                                                          
	        el.setOidRef(oidRef);                                                              
	        getListOfArmRef().add(el);                                                         
	        return el;                                                                         
	}                                                                                          

	/**
	 * Creates a new empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
	 * @return The created {@link SymbolRef} object.                                                       
	 */                                                                                                    
	public SymbolRef createSymbRef(){                                                                      
	        SymbolRef el = new SymbolRef();                                                                
	        getListOfSymbRef().add(el);                                                                    
	        return el;                                                                                     
	}
	
	/**
	 * Creates a new empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
	 * @param symbIdRef
	 * @return The created {@link SymbolRef} object.                                                       
	 */                                                                                                    
	public SymbolRef createSymbRef(String symbIdRef){                                                                      
	        SymbolRef el = new SymbolRef(); 
	        el.setSymbIdRef(symbIdRef);
	        getListOfSymbRef().add(el);                                                                    
	        return el;                                                                                     
	}
	
	/**
	 * Creates a new empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
	 * @param symbIdRef
	 * @param blkIdRef
	 * @return The created {@link SymbolRef} object.                                                       
	 */                                                                                                    
	public SymbolRef createSymbRef(String symbIdRef, String blkIdRef){                                                                      
	        SymbolRef el = new SymbolRef();
	        el.setSymbIdRef(symbIdRef);
	        el.setBlkIdRef(blkIdRef);
	        getListOfSymbRef().add(el);                            
	        return el;                                                                                     
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
	 * Creates a new empty {@link DSCovariateDefinitionType} covariateRef element, adds it to the current object and returns it.
	 * @return The created {@link DSCovariateDefinitionType} object.                                                            
	 */                                                                                                                         
	public DSCovariateDefinitionType createCovariateRef(){                                                                      
	        DSCovariateDefinitionType el = new DSCovariateDefinitionType();                                                     
	        this.covariateRef = el;                                                                                             
	        return el;                                                                                                          
	}                                                                                                                           

	/**
	 * Creates a new empty {@link StandardAssignable} armSize element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.                                                       
	 */                                                                                                             
	public StandardAssignable createArmSize(){                                                                      
	        StandardAssignable el = new StandardAssignable();                                                       
	        this.armSize = el;                                                                                      
	        return el;                                                                                              
	}                                                                                                               

	/**
	 * Creates a new empty {@link StandardAssignable} doseAmount element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.                                                          
	 */                                                                                                                
	public StandardAssignable createDoseAmount(){                                                                      
	        StandardAssignable el = new StandardAssignable();                                                          
	        this.doseAmount = el;                                                                                      
	        return el;                                                                                                 
	}                                                                                                                  

	/**
	 * Creates a new empty {@link StandardAssignable} dosingTimes element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.                                                           
	 */                                                                                                                 
	public StandardAssignable createDosingTimes(){                                                                      
	        StandardAssignable el = new StandardAssignable();                                                           
	        this.dosingTimes = el;                                                                                      
	        return el;                                                                                                  
	}

	/**
	 * Creates a new empty {@link StandardAssignable} duration element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.
	 */
	public StandardAssignable createDuration(){
	        StandardAssignable el = new StandardAssignable();
	        this.duration = el;
	        return el;
	}

	/**
	 * Creates a new empty {@link StandardAssignable} numberArms element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.
	 */
	public StandardAssignable createNumberArms(){
	        StandardAssignable el = new StandardAssignable();
	        this.numberArms = el;
	        return el;
	}

	/**
	 * Creates a new empty {@link StandardAssignable} numberSamples element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.
	 */
	public StandardAssignable createNumberSamples(){
	        StandardAssignable el = new StandardAssignable();
	        this.numberSamples = el;
	        return el;
	}

	/**
	 * Creates a new empty {@link StandardAssignable} numberTimes element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.
	 */
	public StandardAssignable createNumberTimes(){
	        StandardAssignable el = new StandardAssignable();
	        this.numberTimes = el;
	        return el;
	}

	/**
	 * Creates a new empty {@link StandardAssignable} observationTimes element, adds it to the current object and returns it.
	 * @return The created {@link StandardAssignable} object.
	 */
	public StandardAssignable createObservationTimes(){
	        StandardAssignable el = new StandardAssignable();
	        this.observationTimes = el;
	        return el;
	}


}
