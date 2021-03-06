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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.uncertml.AbstractContinuousUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.BetaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.CauchyDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ChiSquareDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ContinuousUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.DiracDeltaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ExponentialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.FDistribution;
import eu.ddmore.libpharmml.dom.uncertml.GammaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.InverseGammaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LaplaceDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LogNormalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LogisticDistribution;
import eu.ddmore.libpharmml.dom.uncertml.NormalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ParetoDistribution;
import eu.ddmore.libpharmml.dom.uncertml.StudentTDistribution;
import eu.ddmore.libpharmml.dom.uncertml.UniformDistribution;
import eu.ddmore.libpharmml.dom.uncertml.WeibullDistribution;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type defines a continuous covariate.
 * 
 * <p>Java class for ContinuousCovariateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContinuousCovariateType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Distribution" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DistributionType" minOccurs="0"/>
 *         &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}RealisationType" minOccurs="0"/>
 *         &lt;element name="Transformation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CovariateTransformationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Interpolation" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Assign" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContinuousCovariateType", propOrder = {
    "abstractContinuousUnivariateDistribution",
    "distribution",
    "realisation",
    "listOfTransformation",
    "interpolation",
    "assign"
})
public class ContinuousCovariate
    extends PharmMLRootType
{

    @XmlElementRef(name = "AbstractContinuousUnivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractContinuousUnivariateDistributionType> abstractContinuousUnivariateDistribution;
    
    @XmlElement(name = "Distribution") // PharmML 0.7
    protected Distribution distribution;
    @XmlElement(name = "Realisation")
    protected Realisation realisation; // PharmML 0.8
    @XmlElement(name = "Transformation")
    protected List<CovariateTransformation> listOfTransformation;
    @XmlElement(name = "Interpolation", namespace = NS_DEFAULT_CT)
    protected Interpolation interpolation;
    @XmlElement(name = "Assign", namespace = NS_DEFAULT_CT) // PharmML 0.7
    protected Rhs assign;

    /**
     * The distribution that the continuous covariate follows.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ParetoDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BetaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudentTDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiracDeltaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CauchyDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link UniformDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeibullDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link GammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link InverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LaplaceDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChiSquareDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogisticDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExponentialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link FDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousUnivariateDistributionType }{@code >}
     *     
     * @deprecated Since PharmML 0.7. Distributions are included within {@link Distribution} via
     * {@link #getDistribution()}.
     */
    @Deprecated
    public JAXBElement<? extends AbstractContinuousUnivariateDistributionType> getAbstractContinuousUnivariateDistribution() {
        return abstractContinuousUnivariateDistribution;
    }

    /**
     * Sets the value of the abstractContinuousUnivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ParetoDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BetaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudentTDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiracDeltaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CauchyDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link UniformDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeibullDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link GammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link InverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LaplaceDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChiSquareDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogisticDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExponentialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link FDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousUnivariateDistributionType }{@code >}
     *     
     * @deprecated Since PharmML 0.7. Distributions are included within {@link Distribution} via
     * {@link #setDistribution(Distribution)}.
     */
    @Deprecated
	public void setAbstractContinuousUnivariateDistribution(JAXBElement<? extends AbstractContinuousUnivariateDistributionType> value) {
        this.abstractContinuousUnivariateDistribution = value;
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
     * Gets the value of the realisation property.
     * 
     * @return
     *     possible object is
     *     {@link Realisation }
     *     
     * @since PharmML 0.8
     */
    public Realisation getRealisation() {
        return realisation;
    }

    /**
     * Sets the value of the realisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Realisation }
     *     
     * @since PharmML 0.8
     */
    public void setRealisation(Realisation value) {
        this.realisation = value;
    }

    /**
     * Gets the value of the transformation property.
     * 
     * @return
     *     possible object is
     *     {@link CovariateTransformation }
     *     
     * @deprecated This attribute is now a list (since PharmML 0.4.1).
     * Use {@link #getListOfTransformation()} instead.
     */
    @Deprecated
    public CovariateTransformation getTransformation() {
        if(getListOfTransformation().size() >= 1){
        	return getListOfTransformation().get(0);
        } else {
        	return null;
        }
    }

    /**
     * Sets the value of the transformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CovariateTransformation }
     * 
     * @deprecated This attribute is now a list (since PharmML 0.4.1).
     * Add an element to the list {@link #getListOfTransformation()} instead.
     */
    @Deprecated
    public void setTransformation(CovariateTransformation value) {
        getListOfTransformation().clear();
        getListOfTransformation().add(value);
    }
    
    /**
     * The transformation to be applied when the covariate is used.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfTransformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CovariateTransformation }
     * 
     * 
     */
    public List<CovariateTransformation> getListOfTransformation() {
        if (listOfTransformation == null) {
            listOfTransformation = new ArrayList<CovariateTransformation>();
        }
        return listOfTransformation;
     }

    /**
     * Gets the value of the interpolation property.
     * 
     * @return
     *     possible object is
     *     {@link Interpolation }
     *     
     */
    public Interpolation getInterpolation() {
        return interpolation;
    }

    /**
     * Sets the value of the interpolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interpolation }
     *     
     */
    public void setInterpolation(Interpolation value) {
        this.interpolation = value;
    }
    
    /**
     * Gets the value of the assign property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *
     * @since PharmML 0.7
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
     * @since PharmML 0.7
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addJAXBIfNotNull(abstractContinuousUnivariateDistribution)
				.addIfNotNull(distribution)
				.addIfNotNull(realisation)
				.addIfNotNull(listOfTransformation)
				.addIfNotNull(interpolation)
				.addIfNotNull(assign);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
