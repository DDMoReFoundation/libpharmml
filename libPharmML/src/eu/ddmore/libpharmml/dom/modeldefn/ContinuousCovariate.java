/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
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
import eu.ddmore.libpharmml.impl.XMLFilter;


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
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractContinuousUnivariateDistribution" minOccurs="0"/>
 *         &lt;element name="Transformation" type="{http://www.pharmml.org/2013/03/ModelDefinition}CovariateTransformationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Interpolation" minOccurs="0"/>
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
    "listOfTransformation",
    "interpolation"
})
public class ContinuousCovariate
    extends PharmMLRootType
{

    @XmlElementRef(name = "AbstractContinuousUnivariateDistribution", namespace = XMLFilter.NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractContinuousUnivariateDistributionType> abstractContinuousUnivariateDistribution;
    @XmlElement(name = "Transformation")
    protected List<CovariateTransformation> listOfTransformation;
    @XmlElement(name = "Interpolation", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Interpolation interpolation;

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
     */
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
     */
    public void setAbstractContinuousUnivariateDistribution(JAXBElement<? extends AbstractContinuousUnivariateDistributionType> value) {
        this.abstractContinuousUnivariateDistribution = value;
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
     * Gets the value of the transformation property.
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

}
