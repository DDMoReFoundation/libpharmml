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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.21 at 11:29:00 AM BST 
//


package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 * Type defines a categorical covariate.
 *             
 * 
 * <p>Java class for CategoricalCovariateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoricalCovariateType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VariabilityReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}CategoryType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoricalCovariateType", propOrder = {
	"listOfVariabilityReference",
    "listOfCategory",
    "assign",
    "distribution",
    "realisation"
})
public class CategoricalCovariate
    extends PharmMLRootType implements Assignable
{

	@XmlElement(name = "VariabilityReference", namespace = NS_DEFAULT_CT)
    protected List<LevelReference> listOfVariabilityReference;
    @XmlElement(name = "Category")
    protected List<Category> listOfCategory;
    @XmlElement(name = "Assign", namespace = NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlElement(name = "Distribution")
    protected Distribution distribution;
    @XmlElement(name = "Realisation")
    protected Realisation realisation;
    
    /**
     * The level of random variability associated with a categorical covariate 
     * defined in the trial design.Gets the value of the variabilityReference property.
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
     * @since PharmML 0.7
     */
    public List<LevelReference> getListOfVariabilityReference() {
        if (listOfVariabilityReference == null) {
        	listOfVariabilityReference = new ArrayList<LevelReference>();
        }
        return this.listOfVariabilityReference;
    }


    /**
     * @deprecated Use {@link #getListOfCategory()}.
     */
    @Deprecated
    public List<Category> getCategory() {
        return getListOfCategory();
    }
    
    /**
     * A category of the categorical covariate.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Category }
     * 
     * 
     */
    public List<Category> getListOfCategory() {
        if (listOfCategory == null) {
        	listOfCategory = new ArrayList<Category>();
        }
        return this.listOfCategory;
    }
    
    /**
     * Gets the value of the assign property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     * @since PharmML 0.8
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
     * @since PharmML 0.8
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * @return
     *     possible object is
     *     {@link Distribution }
     *     
     * @since PharmML 0.8
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
     * @since PharmML 0.8
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

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(listOfVariabilityReference)
				.addIfNotNull(listOfCategory)
				.addIfNotNull(assign)
				.addIfNotNull(distribution)
				.addIfNotNull(realisation);
	}
	
	 @Override
	public Rhs assign(Scalar scalar) {
		Rhs rhs = new Rhs(scalar);
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

	@Override
	public Rhs assign(Binop binop) {
		Rhs rhs = new Rhs(binop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Uniop uniop) {
		Rhs rhs = new Rhs(uniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Piecewise piecewise) {
		Rhs rhs = new Rhs(piecewise);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(FunctionCallType functionCall) {
		Rhs rhs = new Rhs(functionCall);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Sum sum) {
		Rhs rhs = new Rhs(sum);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Product product) {
		Rhs rhs = new Rhs(product);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Delay delay) {
		Rhs rhs = new Rhs(delay);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(VectorSelector vectorSelector) {
		Rhs rhs = new Rhs(vectorSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixSelector matrixSelector) {
		Rhs rhs = new Rhs(matrixSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixUniOp matrixUniop) {
		Rhs rhs = new Rhs(matrixUniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Probability probability) {
		Rhs rhs = new Rhs(probability);
		setAssign(rhs);
		return rhs;
	}

}
