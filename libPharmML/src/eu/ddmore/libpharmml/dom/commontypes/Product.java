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
 * Type defining product.
 * 
 * <p>
 * <math xmlns="http://www.w3.org/1998/Math/MathML">
 *	<mrow>
 *	<munderover>
 *	<mo>&prod;</mo>
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
 * <li>i is the product index</li>
 * <li>n is the low limit</li>
 * <li>N is the up limit</li>
 * <li>V the variable for which the product is defined</li>
 * </ul>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;element name="ProductIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}SumProductIndexType"/>
 *         &lt;element name="LowLimit" type="{http://www.pharmml.org/2013/03/CommonTypes}LowUpLimitType"/>
 *         &lt;element name="UpLimit" type="{http://www.pharmml.org/2013/03/CommonTypes}LowUpLimitType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductType", propOrder = {
    "variable",
    "productIndex",
    "lowLimit",
    "upLimit"
})
public class Product
    extends AbstractFormula implements Operand, ExpressionValue
{
	
	/**
	 * Empty constructor.
	 */
	public Product(){}
	
	/**
	 * Construct a product with lower and upper bounds as integers.
	 * @param V The affected variable
	 * @param i The index of product
	 * @param n The lower bound
	 * @param N The upper bound
	 */
	public Product(OperationVariable V, SymbolRef i, int n, int N){
		this.variable = V;
		createProductIndex(i);
		createLowLimit(n);
		createUpLimit(N);
	}

    @XmlElement(name = "ProductIndex", required = true)
    protected SumProductIndex productIndex;

    /**
     * Gets the value of the productIndex property.
     * 
     * @return
     *     possible object is
     *     {@link SumProductIndex }
     *     
     */
    public SumProductIndex getProductIndex() {
        return productIndex;
    }

    /**
     * Sets the value of the productIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link SumProductIndex }
     *     
     */
    public void setProductIndex(SumProductIndex value) {
        this.productIndex = value;
    }
    
    public SumProductIndex createProductIndex(SymbolRef i){
    	SumProductIndex index = new SumProductIndex();
    	index.setSymbRef(i);
    	this.setProductIndex(index);
    	return index;
    }

	@Override
	public JAXBElement<Product> toJAXBElement() {
		return MasterObjectFactory.COMMONTYPES_OF.createProduct(this);
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(variable)
				.addIfNotNull(productIndex)
				.addIfNotNull(lowLimit)
				.addIfNotNull(upLimit);
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
