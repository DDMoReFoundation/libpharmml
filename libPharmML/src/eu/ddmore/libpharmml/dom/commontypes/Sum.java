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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.21 at 11:29:00 AM BST 
//


package eu.ddmore.libpharmml.dom.commontypes;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
import eu.ddmore.libpharmml.dom.maths.Operand;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining summation.
 * 
 * <p>
 * <math xmlns="http://www.w3.org/1998/Math/MathML">
 *	<mrow>
 *	<munderover>
 *	<mo>&Sum;</mo>
 *		<mrow>
 *		<mi>i</mi>
 *		<mo>=</mo>
 *		<mi>n</mi>
 *		</mrow>
 *		<mrow>
 *		<mi>N</mi>
 *		</mrow>
 *	</munderover>
 *	<mrow>
 *		<mi>V</mi>
 *	</msup>
 *	</mrow>
 *	</mrow>
 * </math>
 * 
 * <p>where:
 * <ul>
 * <li>i is the sum index</li>
 * <li>n is the low limit</li>
 * <li>N is the up limit</li>
 * <li>V the variable for which the sum is defined</li>
 * </ul>
 * 
 * <p>Its is also possible to define summation with a range of values for the index:
 * <p>
 * <math xmlns="http://www.w3.org/1998/Math/MathML">
 *	<mrow>
 *	<munderover>
 *	<mo>&Sum;</mo>
 *		<mrow>
 *		<mi>i</mi>
 *		<mo>&isin;</mo>
 *		<mi>S</mi>
 *		</mrow>
 *		<mrow>
 *		</mrow>
 *	</munderover>
 *	<mrow>
 *		<mi>V</mi>
 *	</msup>
 *	</mrow>
 *	</mrow>
 * </math>
 * 
 * <p>where S is the set range of values for i.
 * 
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SumType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}Probability"/>
 *         &lt;/choice>
 *         &lt;element name="SumIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}SumProductIndexType"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="LowLimit" type="{http://www.pharmml.org/2013/03/CommonTypes}LowUpLimitType"/>
 *             &lt;element name="UpLimit" type="{http://www.pharmml.org/2013/03/CommonTypes}LowUpLimitType"/>
 *           &lt;/sequence>
 *           &lt;element name="SumIndexSet" type="{http://www.pharmml.org/2013/03/CommonTypes}SumIndexSetType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * <p>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SumType", propOrder = {
    "variable",
    "sumIndex",
    "lowLimit",
    "upLimit",
    "sumIndexSet"
})
public class Sum
    extends AbstractFormula implements Operand, ExpressionValue
{
	
	/**
	 * Empty constructor
	 */
	public Sum(){}
	
	/**
	 * Construct a summation with lower and upper bounds as integers.
	 * @param V The affected variable
	 * @param i The index of summation
	 * @param n The lower bound
	 * @param N The upper bound
	 */
	public Sum(OperationVariable V, SymbolRef i, int n, int N){
		this.variable = V;
		createSumIndex(i);
		createLowLimit(n);
		createUpLimit(N);
	}
	
	/**
	 * Construct a summation with a set of values for the index.
	 * @param V The affected variable
	 * @param i The index of summation
	 * @param indexSet The set of values for the index
	 */
	public Sum(OperationVariable V, SymbolRef i, Vector indexSet){
		this.variable = V;
		createSumIndex(i);
		createSumIndexSet(indexSet);
	}

//    @XmlElement(name = "Probability", namespace = "http://www.pharmml.org/2013/03/ModelDefinition")
//    protected Probability probability;
    @XmlElement(name = "SumIndex", required = true)
    protected SumProductIndex sumIndex;
    @XmlElement(name = "SumIndexSet")
    protected SumIndexSet sumIndexSet;

    /**
     * Gets the value of the sumIndex property.
     * 
     * @return
     *     possible object is
     *     {@link SumProductIndex }
     *     
     */
    public SumProductIndex getSumIndex() {
        return sumIndex;
    }

    /**
     * Sets the value of the sumIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link SumProductIndex }
     *     
     */
    public void setSumIndex(SumProductIndex value) {
        this.sumIndex = value;
    }

    /**
     * Gets the value of the sumIndexSet property.
     * 
     * @return
     *     possible object is
     *     {@link SumIndexSet }
     *     
     */
    public SumIndexSet getSumIndexSet() {
        return sumIndexSet;
    }

    /**
     * Sets the value of the sumIndexSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link SumIndexSet }
     *     
     */
    public void setSumIndexSet(SumIndexSet value) {
        this.sumIndexSet = value;
    }
    
    /**
     * Creates a new {@link SumIndexSet} (S), adds it to the current sum and returns it.
     * @param vector The {@link Vector} object used as a sum index set.
     * @return The created {@link SumIndexSet} object.
     */
    public SumIndexSet createSumIndexSet(Vector vector){
    	SumIndexSet indexSet = new SumIndexSet();
    	indexSet.setVector(vector);
    	this.setSumIndexSet(indexSet);
    	return indexSet;
    }
    
    /**
     * Creates a new {@link SumProductIndex} (i), adds it to the current sum and returns it.
     * @param i The index as a symbol reference.
     * @return The created {@link SumProductIndex} object.
     */
    public SumProductIndex createSumIndex(SymbolRef i){
    	SumProductIndex index = new SumProductIndex();
    	index.setSymbRef(i);
    	this.setSumIndex(index);
    	return index;
    }

	@Override
	public JAXBElement<Sum> toJAXBElement() {
		return MasterObjectFactory.COMMONTYPES_OF.createSum(this);
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(variable)
				.addIfNotNull(sumIndex)
				.addIfNotNull(lowLimit)
				.addIfNotNull(upLimit)
				.addIfNotNull(sumIndexSet);
	}

	@Override
	public String toMathExpression() {
		// TODO Auto-generated method stub
		return null;
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
