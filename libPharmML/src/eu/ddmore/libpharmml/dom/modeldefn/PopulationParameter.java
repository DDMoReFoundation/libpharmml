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

import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Describes an population parameter.
 *             
 * 
 * <p>Java class for PopulationParameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PopulationParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}CommonParameterType">
 *       &lt;sequence>
 *         &lt;element name="LHSTransformation" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}LHSTransformationType" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *           &lt;sequence>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VariabilityReference" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="Distribution" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionType"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PopulationParameterType", propOrder = {
    "lhsTransformation",
    "assign",
    "listOfVariabilityReference",
    "distribution"
})
public class PopulationParameter
    extends CommonParameter implements Assignable
{

    @XmlElement(name = "LHSTransformation")
    protected LHSTransformationType lhsTransformation;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlElement(name = "VariabilityReference", namespace = XMLFilter.NS_DEFAULT_CT)
    protected List<LevelReference> listOfVariabilityReference;
    @XmlElement(name = "Distribution")
    protected Distribution distribution;

    /**
     * Gets the value of the lhsTransformation property.
     * 
     * @return
     *     possible object is
     *     {@link LHSTransformationType }
     *     
     */
    public LHSTransformationType getLHSTransformation() {
        return lhsTransformation;
    }

    /**
     * Sets the value of the lhsTransformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LHSTransformationType }
     *     
     */
    public void setLHSTransformation(LHSTransformationType value) {
        this.lhsTransformation = value;
    }

    /**
     * 
     * The explicit definition of an population parameter.
     *                                 
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

    /**
     * The level of random variability and its connection to variance/stdev 
     * as defined when using the {@link Distribution}.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variabilityReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfVariabilityReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelReference }
     * 
     * 
     */
    public List<LevelReference> getListOfVariabilityReference() {
        if (listOfVariabilityReference == null) {
        	listOfVariabilityReference = new ArrayList<LevelReference>();
        }
        return this.listOfVariabilityReference;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * @return
     *     possible object is
     *     {@link Distribution }
     *     
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Sets the value of the distribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Distribution }
     *     
     */
    public void setDistribution(Distribution value) {
        this.distribution = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(lhsTransformation)
    			.addIfNotNull(assign)
    			.addIfNotNull(listOfVariabilityReference)
    			.addIfNotNull(distribution);
    }
    
    /**                                                              
    * Creates a new empty {@link LHSTransformationType} lhsTransformation element, adds it to the current object and returns it.
    * @return The created {@link LHSTransformationType} object.                                                                 
    */                                                                                                                          
    public LHSTransformationType createLhsTransformation(){                                                                     
        LHSTransformationType el = new LHSTransformationType();                                                                 
        this.lhsTransformation = el;                                                                                            
        return el;                                                                                                              
    }                                                                                                                           

    /**
    * Creates a new {@link LHSTransformationType} lhsTransformation element, adds it to the current object and returns it.
    * @param type The type of transformation.                                                                             
    * @return The created {@link LHSTransformationType} object.                                                           
    */                                                                                                                    
    public LHSTransformationType createLhsTransformation(TransformationType type){                                        
        LHSTransformationType el = new LHSTransformationType();                                                           
        el.setType(type);                                                                                                 
        this.lhsTransformation = el;                                                                                      
        return el;                                                                                                        
    }                                                                                                                     

    @Override
    public Rhs assign(Scalar scalar) {
            Rhs rhs = new Rhs(scalar);
            setAssign(rhs);           
            return rhs;               
    }                                 

    @Override
    public Rhs assign(Equation equation) {
            Rhs rhs = new Rhs(equation);  
            setAssign(rhs);               
            return rhs;                   
    }                                     

    @Override
    public Rhs assign(SymbolRef symbolRef) {
            Rhs rhs = new Rhs(symbolRef);   
            setAssign(rhs);                 
            return rhs;                     
    }                                       

    @Override
    public Rhs assign(Sequence sequence) {
            Rhs rhs = new Rhs(sequence);  
            setAssign(rhs);               
            return rhs;                   
    }                                     

    @Override
    public Rhs assign(Vector vector) {
            Rhs rhs = new Rhs(vector);
            setAssign(rhs);
            return rhs;
    }

    @Override
    public Rhs assign(Interpolation interpolation) {
            Rhs rhs = new Rhs(interpolation);
            setAssign(rhs);
            return rhs;
    }

    @Override
    public Rhs assign(Matrix matrix) {
            Rhs rhs = new Rhs(matrix);
            setAssign(rhs);
            return rhs;
    }

    @Override
    public Rhs assign(Constant constant) {
            Rhs rhs = new Rhs(constant);
            setAssign(rhs);
            return rhs;
    }

    @Override
    public Rhs assign(Interval interval) {
            Rhs rhs = new Rhs(interval);
            setAssign(rhs);
            return rhs;
    }

    /**
     * Creates a new empty {@link LevelReference} listOfVariabilityReference element, adds it to the current object and returns it.
     * @return The created {@link LevelReference} object.
     */
    public LevelReference createListOfVariabilityReference(){
            LevelReference el = new LevelReference();
            getListOfVariabilityReference().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link Distribution} distribution element, adds it to the current object and returns it.
     * @return The created {@link Distribution} object.
     */
    public Distribution createDistribution(){
            Distribution el = new Distribution();
            this.distribution = el;
            return el;
    }


}
