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
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
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
 * Describes an individual parameter. Three encodings of a parameter model are available:
 * <p>Type 1. explicit equation type of parameter model<br>
 * psi_i = H(beta, c_i, eta_i)
 *                 
 * <p>Type 2. Structured (e.g. Gaussian) model with general covariate model<br>
 * h(psi_i) = H(beta, c_i) + eta_i [if eta_i ~ N()]
 *                 
 * <p>Type 3. Structured (e.g. Gaussian) model with linear covariate model<br>
 * h(psi_i) = h(psi_pop) + beta c_i + eta_i [if eta_i ~ N()]
 *                 
 * <p>Type 4. Generic parameter model using distribution, i.e. so called eta-free notation <br>
 * h(psi_i) ~ distribution(parameter1, parameter2, ...) e.g. log(psi_i) ~ N(log(psi_pop) + beta c_i, omega_psi)
 *             
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/ModelDefinition}CommonParameterType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="GaussianModel">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *                   &lt;sequence>
 *                     &lt;element name="Transformation" type="{http://www.pharmml.org/2013/03/ModelDefinition}LRHSTransformationType" minOccurs="0"/>
 *                     &lt;choice>
 *                       &lt;element name="LinearCovariate">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *                               &lt;sequence>
 *                                 &lt;element name="PopulationParameter">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="Covariate" type="{http://www.pharmml.org/2013/03/ModelDefinition}CovariateRelationType" maxOccurs="unbounded" minOccurs="0"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="GeneralCovariate">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/choice>
 *                     &lt;element name="RandomEffects" type="{http://www.pharmml.org/2013/03/ModelDefinition}ParameterRandomEffectType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
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
@XmlType(name = "IndividualParameterType", propOrder = {
    "gaussianModel",
    "structuredModel",
    "assign",
    "lhsTransformation",
    "listOfVariabilityReference",
    "distribution"
})
public class IndividualParameter
    extends CommonParameter implements Assignable
{

	@Deprecated
    @XmlElement(name = "GaussianModel")
    protected IndividualParameter.GaussianModel gaussianModel;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
    
    // PharmML 0.7
    @XmlElement(name = "StructuredModel")
    protected StructuredModel structuredModel;
    @XmlElement(name = "LHSTransformation")
    protected LHSTransformationType lhsTransformation;
    @XmlElement(name = "VariabilityReference", namespace = XMLFilter.NS_DEFAULT_CT)
    protected List<LevelReference> listOfVariabilityReference;
    @XmlElement(name = "Distribution")
    protected Distribution distribution;

    /**
     * Gets the value of the gaussianModel property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualParameter.GaussianModel }
     *    
     * @deprecated Since PharmML 0.7, the gaussian model is renamed as structured model available
     * via {@link #getStructuredModel()}.
     */
    @Deprecated
    public IndividualParameter.GaussianModel getGaussianModel() {
        return gaussianModel;
    }

    /**
     * Sets the value of the gaussianModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualParameter.GaussianModel }
     *     
     * @deprecated Since PharmML 0.7, the gaussian model is renamed as structured model available
     * via {@link #setStructuredModel(StructuredModel)}.
     */
    @Deprecated
    public void setGaussianModel(IndividualParameter.GaussianModel value) {
        this.gaussianModel = value;
    }

    /**
     * Gets the value of the structuredModel property.
     * 
     * @return
     *     possible object is
     *     {@link StructuredModel }
     *     
     * @since PharmML 0.7
     */
    public StructuredModel getStructuredModel() {
        return structuredModel;
    }

    /**
     * Sets the value of the structuredModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredModel }
     *     
     * @since PharmML 0.7
     */
    public void setStructuredModel(StructuredModel value) {
        this.structuredModel = value;
    }

    /**
     * 
     * The explicit, type 1, definition of an individual parameter. This defines H and can 
     * contain references to one or more random variables.
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
     * Gets the value of the lhsTransformation property.
     * 
     * @return
     *     possible object is
     *     {@link LHSTransformationType }
     *     
     * @since PharmML 0.7
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
     * @since PharmML 0.7
     */
    public void setLHSTransformation(LHSTransformationType value) {
        this.lhsTransformation = value;
    }

    /**
     * The level of random variability and its connection
     *                                             to variance/stdev as defined when using the distribution.Gets the value of the variabilityReference property.
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
     * @since PharmML 0.7
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
     * @since PharmML 0.7
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
     * @since PharmML 0.7
     */
    public void setDistribution(Distribution value) {
        this.distribution = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
     *       &lt;sequence>
     *         &lt;element name="Transformation" type="{http://www.pharmml.org/2013/03/ModelDefinition}LRHSTransformationType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="LinearCovariate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
     *                   &lt;sequence>
     *                     &lt;element name="PopulationParameter">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="Covariate" type="{http://www.pharmml.org/2013/03/ModelDefinition}CovariateRelationType" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="GeneralCovariate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
     *         &lt;element name="RandomEffects" type="{http://www.pharmml.org/2013/03/ModelDefinition}ParameterRandomEffectType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * @deprecated Since PharmML 0.7, GaussianModel has been renamed to {@link StructuredModel}.
     */
    @Deprecated
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transformation",
        "linearCovariate",
        "generalCovariate",
        "randomEffects"
    })
    public static class GaussianModel
        extends PharmMLRootType
    {

        @XmlElement(name = "Transformation")
        protected LhsTransformation transformation;
        @XmlElement(name = "LinearCovariate")
        protected IndividualParameter.GaussianModel.LinearCovariate linearCovariate;
        @XmlElement(name = "GeneralCovariate")
        protected IndividualParameter.GaussianModel.GeneralCovariate generalCovariate;
        @XmlElement(name = "RandomEffects", required = true)
        protected List<ParameterRandomEffect> randomEffects;

        /**
         * Gets the value of the transformation property.
         * 
         * @return
         *     possible object is
         *     {@link LhsTransformation }
         *     
         */
        public LhsTransformation getTransformation() {
            return transformation;
        }

        /**
         * Sets the value of the transformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LhsTransformation }
         *     
         */
        public void setTransformation(LhsTransformation value) {
            this.transformation = value;
        }

        /**
         * Gets the value of the linearCovariate property.
         * 
         * @return
         *     possible object is
         *     {@link IndividualParameter.GaussianModel.LinearCovariate }
         *     
         */
        public IndividualParameter.GaussianModel.LinearCovariate getLinearCovariate() {
            return linearCovariate;
        }

        /**
         * Sets the value of the linearCovariate property.
         * 
         * @param value
         *     allowed object is
         *     {@link IndividualParameter.GaussianModel.LinearCovariate }
         *     
         */
        public void setLinearCovariate(IndividualParameter.GaussianModel.LinearCovariate value) {
            this.linearCovariate = value;
        }

        /**
         * Gets the value of the generalCovariate property.
         * 
         * @return
         *     possible object is
         *     {@link IndividualParameter.GaussianModel.GeneralCovariate }
         *     
         */
        public IndividualParameter.GaussianModel.GeneralCovariate getGeneralCovariate() {
            return generalCovariate;
        }

        /**
         * Sets the value of the generalCovariate property.
         * 
         * @param value
         *     allowed object is
         *     {@link IndividualParameter.GaussianModel.GeneralCovariate }
         *     
         */
        public void setGeneralCovariate(IndividualParameter.GaussianModel.GeneralCovariate value) {
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
         *    getRandomEffects().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ParameterRandomEffect }
         * 
         * @since PharmML 0.3. This method returned an indivual element before.
         */
        public List<ParameterRandomEffect> getRandomEffects() {
            if (randomEffects == null) {
                randomEffects = new ArrayList<ParameterRandomEffect>();
            }
            return this.randomEffects;
        }
        
        @Override
    	protected List<TreeNode> listChildren() {
    		return new ChainedList<TreeNode>()
    				.addIfNotNull(linearCovariate)
    				.addIfNotNull(generalCovariate)
    				.addIfNotNull(randomEffects);
    	}


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
         *       &lt;sequence>
         *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
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
             *                                                                 The general covariate definition. Note that this should NOT contain references to a random variable. You should use an explicit (type 3) parameter definition to do that.
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
         *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
         *       &lt;sequence>
         *         &lt;element name="PopulationParameter">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Covariate" type="{http://www.pharmml.org/2013/03/ModelDefinition}CovariateRelationType" maxOccurs="unbounded" minOccurs="0"/>
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
            "populationParameter",
            "covariate"
        })
        public static class LinearCovariate
            extends PharmMLRootType
        {

            @XmlElement(name = "PopulationParameter", required = true)
            protected IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter populationParameter;
            @XmlElement(name = "Covariate")
            protected List<CovariateRelation> covariate;

            /**
             * Gets the value of the populationParameter property.
             * 
             * @return
             *     possible object is
             *     {@link IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter }
             *     
             */
            public IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter getPopulationParameter() {
                return populationParameter;
            }

            /**
             * Sets the value of the populationParameter property.
             * 
             * @param value
             *     allowed object is
             *     {@link IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter }
             *     
             */
            public void setPopulationParameter(IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter value) {
                this.populationParameter = value;
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
             *    getCovariate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CovariateRelation }
             * 
             * 
             */
            public List<CovariateRelation> getCovariate() {
                if (covariate == null) {
                    covariate = new ArrayList<CovariateRelation>();
                }
                return this.covariate;
            }
            
            @Override
        	protected List<TreeNode> listChildren() {
        		return new ChainedList<TreeNode>()
        				.addIfNotNull(populationParameter)
        				.addIfNotNull(covariate);
        	}


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
             *       &lt;sequence>
             *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
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
            public static class PopulationParameter
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

    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(super.listChildren())
				.addIfNotNull(gaussianModel)
				.addIfNotNull(structuredModel)
				.addIfNotNull(assign)
				.addIfNotNull(lhsTransformation)
				.addIfNotNull(listOfVariabilityReference)
				.addIfNotNull(distribution);
	}
    
    /**
     * Creates a new empty {@link StructuredModel} structuredModel element, adds it to the current object and returns it.
     * @return The created {@link StructuredModel} object.
     */
    public StructuredModel createStructuredModel(){
            StructuredModel el = new StructuredModel();
            this.structuredModel = el;
            return el;
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

    /**
     * Creates a new empty {@link LevelReference} variabilityReference element, adds it to the current object and returns it.
     * @return The created {@link LevelReference} object.
     */
    public LevelReference createVariabilityReference(){
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


}
