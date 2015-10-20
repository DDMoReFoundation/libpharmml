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

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Defines the structured model type.
 * 
 * <p>Java class for StructuredModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuredModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Transformation" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}LRHSTransformationType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="PopulationValue">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="LinearCovariate">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *                   &lt;sequence>
 *                     &lt;element name="PopulationValue">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Covariate" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}CovariateRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="GeneralCovariate">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="RandomEffects" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}ParameterRandomEffectType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredModelType", propOrder = {
    "transformation",
    "populationValue",
    "linearCovariate",
    "generalCovariate",
    "randomEffects"
})
public class StructuredModel
    extends PharmMLRootType
{

    @XmlElement(name = "Transformation")
    protected LRHSTransformationType transformation;
    @XmlElement(name = "PopulationValue")
    protected StructuredModel.PopulationValue populationValue;
    @XmlElement(name = "LinearCovariate")
    protected StructuredModel.LinearCovariate linearCovariate;
    @XmlElement(name = "GeneralCovariate")
    protected StructuredModel.GeneralCovariate generalCovariate;
    @XmlElement(name = "RandomEffects", required = true)
    protected List<ParameterRandomEffect> randomEffects;

    /**
     * The transformation (h) applied to both sides of the equation.
     * 
     * @return
     *     possible object is
     *     {@link LRHSTransformationType }
     *     
     */
    public LRHSTransformationType getTransformation() {
        return transformation;
    }

    /**
     * The transformation (h) applied to both sides of the equation.
     * 
     * @param value
     *     allowed object is
     *     {@link LRHSTransformationType }
     *     
     */
    public void setTransformation(LRHSTransformationType value) {
        this.transformation = value;
    }

    /**
     * The population/typical value: psi_pop.
     * 
     * @return
     *     possible object is
     *     {@link StructuredModel.PopulationValue }
     *     
     */
    public StructuredModel.PopulationValue getPopulationValue() {
        return populationValue;
    }

    /**
     * The population/typical value: psi_pop.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredModel.PopulationValue }
     *     
     */
    public void setPopulationValue(StructuredModel.PopulationValue value) {
        this.populationValue = value;
    }

    /**
     * Defines the linear covariate model: h(psi_pop) + beta c_i
     * 
     * @return
     *     possible object is
     *     {@link StructuredModel.LinearCovariate }
     *     
     */
    public StructuredModel.LinearCovariate getLinearCovariate() {
        return linearCovariate;
    }

    /**
     * Defines the linear covariate model: h(psi_pop) + beta c_i
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredModel.LinearCovariate }
     *     
     */
    public void setLinearCovariate(StructuredModel.LinearCovariate value) {
        this.linearCovariate = value;
    }

    /**
     * A general covariate model definition. This can be used to define a non-linear covariate
     * model. This equates to H in the above definitions.
     * 
     * @return
     *     possible object is
     *     {@link StructuredModel.GeneralCovariate }
     *     
     */
    public StructuredModel.GeneralCovariate getGeneralCovariate() {
        return generalCovariate;
    }

    /**
     * A general covariate model definition. This can be used to define a non-linear covariate
     * model. This equates to H in the above definitions.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredModel.GeneralCovariate }
     *     
     */
    public void setGeneralCovariate(StructuredModel.GeneralCovariate value) {
        this.generalCovariate = value;
    }

    /**
     * Gets the value of the randomEffects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the randomEffects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfRandomEffects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterRandomEffect }
     * 
     * 
     */
    public List<ParameterRandomEffect> getListOfRandomEffects() {
        if (randomEffects == null) {
            randomEffects = new ArrayList<ParameterRandomEffect>();
        }
        return this.randomEffects;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "assign"
    })
    public static class GeneralCovariate
        extends PharmMLRootType
    {

        @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT, required = true)
        protected Rhs assign;

        /**
         * 
         * The general covariate definition. Note that this should NOT contain references 
         * to a random variable. You should use an explicit (type 3) parameter definition 
         * to do that.
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
        
        @Override
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>()
        			.addIfNotNull(assign);
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
     *       &lt;sequence>
     *         &lt;element name="PopulationValue">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Covariate" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}CovariateRelationType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "populationValue",
        "listOfCovariate"
    })
    public static class LinearCovariate
        extends PharmMLRootType
    {

        @XmlElement(name = "PopulationValue", required = true)
        protected StructuredModel.LinearCovariate.PopulationValue populationValue;
        @XmlElement(name = "Covariate")
        protected List<CovariateRelation> listOfCovariate;

        /**
         * Gets the value of the populationValue property.
         * 
         * @return
         *     possible object is
         *     {@link StructuredModel.LinearCovariate.PopulationValue }
         *     
         */
        public StructuredModel.LinearCovariate.PopulationValue getPopulationValue() {
            return populationValue;
        }

        /**
         * Sets the value of the populationValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link StructuredModel.LinearCovariate.PopulationValue }
         *     
         */
        public void setPopulationValue(StructuredModel.LinearCovariate.PopulationValue value) {
            this.populationValue = value;
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
         * {@link CovariateRelation }
         * 
         * 
         */
        public List<CovariateRelation> getListOfCovariate() {
            if (listOfCovariate == null) {
            	listOfCovariate = new ArrayList<CovariateRelation>();
            }
            return this.listOfCovariate;
        }
        
        @Override
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>()
        			.addIfNotNull(populationValue)
        			.addIfNotNull(listOfCovariate);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
         *       &lt;sequence>
         *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "assign"
        })
        public static class PopulationValue
            extends PharmMLRootType
        {

            @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT, required = true)
            protected Rhs assign;

            /**
             * Gets the value of the assign property.
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
            protected List<TreeNode> listChildren() {
            	return new ChainedList<TreeNode>()
            			.addIfNotNull(assign);
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "assign"
    })
    public static class PopulationValue
        extends PharmMLRootType
    {

        @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT, required = true)
        protected Rhs assign;

        /**
         * Gets the value of the assign property.
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
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>()
        			.addIfNotNull(assign);
        }

    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(transformation)
    			.addIfNotNull(populationValue)
    			.addIfNotNull(linearCovariate)
    			.addIfNotNull(generalCovariate)
    			.addIfNotNull(randomEffects);
    }

}
