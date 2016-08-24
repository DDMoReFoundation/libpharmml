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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractCategoricalMultivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractCategoricalUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractContinuousMultivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractContinuousUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractDiscreteMultivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractDiscreteUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.BernoulliDistribution;
import eu.ddmore.libpharmml.dom.uncertml.BetaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.BinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalMultivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.CauchyDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ChiSquareDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ContinuousMultivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.ContinuousUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.DiracDeltaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.DirichletDistribution;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteMultivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.ExponentialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.FDistribution;
import eu.ddmore.libpharmml.dom.uncertml.GammaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.GeometricDistribution;
import eu.ddmore.libpharmml.dom.uncertml.HypergeometricDistribution;
import eu.ddmore.libpharmml.dom.uncertml.InverseGammaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LaplaceDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LogNormalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.LogisticDistribution;
import eu.ddmore.libpharmml.dom.uncertml.MultinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.MultivariateNormalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.MultivariateStudentTDistribution;
import eu.ddmore.libpharmml.dom.uncertml.NegativeBinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.NormalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.NormalInverseGammaDistribution;
import eu.ddmore.libpharmml.dom.uncertml.ParetoDistribution;
import eu.ddmore.libpharmml.dom.uncertml.PoissonDistribution;
import eu.ddmore.libpharmml.dom.uncertml.StudentTDistribution;
import eu.ddmore.libpharmml.dom.uncertml.UniformDistribution;
import eu.ddmore.libpharmml.dom.uncertml.WeibullDistribution;
import eu.ddmore.libpharmml.dom.uncertml.WishartDistribution;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type for UncertML distributions.
 * 
 * <p>Java class for UncertMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UncertMLType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractContinuousUnivariateDistribution"/>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractContinuousMultivariateDistribution"/>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractCategoricalUnivariateDistribution"/>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractCategoricalMultivariateDistribution"/>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractDiscreteUnivariateDistribution"/>
 *         &lt;element ref="{http://www.uncertml.org/3.0}AbstractDiscreteMultivariateDistribution"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UncertMLType", propOrder = {
    "abstractContinuousUnivariateDistribution",
    "abstractContinuousMultivariateDistribution",
    "abstractCategoricalUnivariateDistribution",
    "abstractCategoricalMultivariateDistribution",
    "abstractDiscreteUnivariateDistribution",
    "abstractDiscreteMultivariateDistribution"
})
public class UncertML
    extends PharmMLRootType
{

    @XmlElementRef(name = "AbstractContinuousUnivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractContinuousUnivariateDistributionType> abstractContinuousUnivariateDistribution;
    @XmlElementRef(name = "AbstractContinuousMultivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractContinuousMultivariateDistributionType> abstractContinuousMultivariateDistribution;
    @XmlElementRef(name = "AbstractCategoricalUnivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractCategoricalUnivariateDistributionType> abstractCategoricalUnivariateDistribution;
    @XmlElementRef(name = "AbstractCategoricalMultivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractCategoricalMultivariateDistributionType> abstractCategoricalMultivariateDistribution;
    @XmlElementRef(name = "AbstractDiscreteUnivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractDiscreteUnivariateDistributionType> abstractDiscreteUnivariateDistribution;
    @XmlElementRef(name = "AbstractDiscreteMultivariateDistribution", namespace = NS_DEFAULT_UNCERTML, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractDiscreteMultivariateDistributionType> abstractDiscreteMultivariateDistribution;

    /**
     * 
     *                                 A continuous univariate probability distribution, defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link FDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeibullDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link InverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BetaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudentTDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ParetoDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link UniformDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChiSquareDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CauchyDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExponentialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LaplaceDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousUnivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogisticDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiracDeltaDistribution }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link GammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link FDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WeibullDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link InverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BetaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudentTDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ParetoDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link UniformDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ChiSquareDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CauchyDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExponentialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LaplaceDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousUnivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogisticDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiracDeltaDistribution }{@code >}
     *     
     */
    public void setAbstractContinuousUnivariateDistribution(JAXBElement<? extends AbstractContinuousUnivariateDistributionType> value) {
        this.abstractContinuousUnivariateDistribution = value;
    }

    /**
     * 
     *                                 A continuous multivariate probability distribution, defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DirichletDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultivariateNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousMultivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalInverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousMultivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultivariateStudentTDistribution }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractContinuousMultivariateDistributionType> getAbstractContinuousMultivariateDistribution() {
        return abstractContinuousMultivariateDistribution;
    }

    /**
     * Sets the value of the abstractContinuousMultivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DirichletDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultivariateNormalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousMultivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NormalInverseGammaDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link ContinuousMultivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultivariateStudentTDistribution }{@code >}
     *     
     */
    public void setAbstractContinuousMultivariateDistribution(JAXBElement<? extends AbstractContinuousMultivariateDistributionType> value) {
        this.abstractContinuousMultivariateDistribution = value;
    }

    /**
     * 
     *                                 A categorical univariate probability distribution as defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BernoulliDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCategoricalUnivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalUnivariateMixtureModel }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractCategoricalUnivariateDistributionType> getAbstractCategoricalUnivariateDistribution() {
        return abstractCategoricalUnivariateDistribution;
    }

    /**
     * Sets the value of the abstractCategoricalUnivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BernoulliDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCategoricalUnivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalUnivariateMixtureModel }{@code >}
     *     
     */
    public void setAbstractCategoricalUnivariateDistribution(JAXBElement<? extends AbstractCategoricalUnivariateDistributionType> value) {
        this.abstractCategoricalUnivariateDistribution = value;
    }

    /**
     * 
     *                                 A categorical multivariate probability distribution as defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AbstractCategoricalMultivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalMultivariateMixtureModel }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractCategoricalMultivariateDistributionType> getAbstractCategoricalMultivariateDistribution() {
        return abstractCategoricalMultivariateDistribution;
    }

    /**
     * Sets the value of the abstractCategoricalMultivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AbstractCategoricalMultivariateDistributionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link CategoricalMultivariateMixtureModel }{@code >}
     *     
     */
    public void setAbstractCategoricalMultivariateDistribution(JAXBElement<? extends AbstractCategoricalMultivariateDistributionType> value) {
        this.abstractCategoricalMultivariateDistribution = value;
    }

    /**
     * 
     *                                 A discrete univariate probability distribution as defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GeometricDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link HypergeometricDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link PoissonDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiscreteUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link NegativeBinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteUnivariateDistributionType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractDiscreteUnivariateDistributionType> getAbstractDiscreteUnivariateDistribution() {
        return abstractDiscreteUnivariateDistribution;
    }

    /**
     * Sets the value of the abstractDiscreteUnivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GeometricDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link HypergeometricDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link PoissonDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link DiscreteUnivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link NegativeBinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteUnivariateDistributionType }{@code >}
     *     
     */
    public void setAbstractDiscreteUnivariateDistribution(JAXBElement<? extends AbstractDiscreteUnivariateDistributionType> value) {
        this.abstractDiscreteUnivariateDistribution = value;
    }

    /**
     * 
     *                                 A discrete multivariate probability distribution as defined by UncertML. 
     *                             
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DiscreteMultivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WishartDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteMultivariateDistributionType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractDiscreteMultivariateDistributionType> getAbstractDiscreteMultivariateDistribution() {
        return abstractDiscreteMultivariateDistribution;
    }

    /**
     * Sets the value of the abstractDiscreteMultivariateDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DiscreteMultivariateMixtureModel }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultinomialDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link WishartDistribution }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteMultivariateDistributionType }{@code >}
     *     
     */
    public void setAbstractDiscreteMultivariateDistribution(JAXBElement<? extends AbstractDiscreteMultivariateDistributionType> value) {
        this.abstractDiscreteMultivariateDistribution = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addJAXBIfNotNull(abstractContinuousUnivariateDistribution)
    			.addJAXBIfNotNull(abstractContinuousMultivariateDistribution)
    			.addJAXBIfNotNull(abstractCategoricalUnivariateDistribution)
    			.addJAXBIfNotNull(abstractCategoricalMultivariateDistribution)
    			.addJAXBIfNotNull(abstractDiscreteUnivariateDistribution)
    			.addJAXBIfNotNull(abstractDiscreteMultivariateDistribution);
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
