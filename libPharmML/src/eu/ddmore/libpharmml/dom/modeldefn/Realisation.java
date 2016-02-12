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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
import eu.ddmore.libpharmml.dom.maths.Operand;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.probonto.DistributionName;
import eu.ddmore.libpharmml.dom.probonto.ProbOnto;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining a single realisation from a distribution.
 * 
 * <p>Java class for RealisationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RealisationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="UncertML" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}UncertMLType"/>
 *         &lt;element ref="{http://www.pharmml.org/probonto/ProbOnto}ProbOnto"/>
 *         &lt;element name="Piecewise" type="{http://www.pharmml.org/pharmml/0.8/Maths}PiecewiseType"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RealisationType", propOrder = {
    "uncertML",
    "probOnto",
    "piecewise"
})
public class Realisation
    extends PharmMLRootType implements ExpressionValue, Operand
{

    @XmlElement(name = "UncertML")
    protected UncertML uncertML;
    @XmlElement(name = "ProbOnto", namespace = XMLFilter.NS_DEFAULT_PROBONTO)
    protected ProbOnto probOnto;
    @XmlElement(name = "Piecewise")
    protected Piecewise piecewise;

    /**
     * Gets the value of the uncertML property.
     * 
     * @return
     *     possible object is
     *     {@link UncertML }
     *     
     */
    public UncertML getUncertML() {
        return uncertML;
    }

    /**
     * Sets the value of the uncertML property.
     * 
     * @param value
     *     allowed object is
     *     {@link UncertML }
     *     
     */
    public void setUncertML(UncertML value) {
        this.uncertML = value;
    }

    /**
     * Gets the value of the probOnto property.
     * 
     * @return
     *     possible object is
     *     {@link ProbOnto }
     *     
     */
    public ProbOnto getProbOnto() {
        return probOnto;
    }

    /**
     * Sets the value of the probOnto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProbOnto }
     *     
     */
    public void setProbOnto(ProbOnto value) {
        this.probOnto = value;
    }

    /**
     * Gets the value of the piecewise property.
     * 
     * @return
     *     possible object is
     *     {@link Piecewise }
     *     
     */
    public Piecewise getPiecewise() {
        return piecewise;
    }

    /**
     * Sets the value of the piecewise property.
     * 
     * @param value
     *     allowed object is
     *     {@link Piecewise }
     *     
     */
    public void setPiecewise(Piecewise value) {
        this.piecewise = value;
    }
    
    /**
     * Creates a new empty {@link UncertML} uncertML element, adds it to the current object and returns it.
     * @return The created {@link UncertML} object.
     */
    public UncertML createUncertML(){
    	UncertML el = new UncertML();
    	this.uncertML = el;
    	return el;
    }

    /**
     * Creates a new empty {@link ProbOnto} probOnto element, adds it to the current object and returns it.
     * @return The created {@link ProbOnto} object.
     */
    public ProbOnto createProbOnto(){
    	ProbOnto el = new ProbOnto();
    	this.probOnto = el;
    	return el;
    }
    
   /**
    * Creates a new empty {@link ProbOnto} probOnto element, adds it to the current object and returns it.
    * @param name
    * @return The created {@link ProbOnto} object.
    */
   public ProbOnto createProbOnto(DistributionName name){
   	ProbOnto el = new ProbOnto();
   	el.setName(name);
   	this.probOnto = el;
   	return el;
   }

    /**
     * Creates a new empty {@link Piecewise} piecewise element, adds it to the current object and returns it.
     * @return The created {@link Piecewise} object.
     */
    public Piecewise createPiecewise(){
    	Piecewise el = new Piecewise();
    	this.piecewise = el;
    	return el;
    }

    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(uncertML)
    			.addIfNotNull(probOnto)
    			.addIfNotNull(piecewise);
    }

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createBinopTypeRealisation(this);
	}

	@Override
	public String toMathExpression() {
		return new MathExpressionConverterToExpression().convert(this);
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}

	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}

}
