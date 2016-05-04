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
package eu.ddmore.libpharmml.dom.maths;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Complex Type that defines a mathematical equation.
 * 
 * <p>Java class for EquationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EquationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Uniop"/>
 *         &lt;element name="Piecewise" type="{http://www.pharmml.org/2013/03/Maths}PiecewiseType"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}FunctionCall"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sum"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Product"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Delay"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}VectorSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}Probability"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.7.1, equation elements has been removed as they were semantically
 * incorrect.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquationType", propOrder = {
    "scalar",
    "symbRef",
    "binop",
    "uniop",
    "piecewise",
    "functionCall",
    "sum",
    "product",
    "delay",
    "vectorSelector",
    "matrixSelector",
    "matrixUniop",
    "probability"
})
@XmlSeeAlso({
    Equation.class
})
@Deprecated
public class EquationType
    extends PharmMLRootType
{

    @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected JAXBElement<?> scalar;
    @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElement(name = "Binop")
    protected Binop binop;
    @XmlElement(name = "Uniop")
    protected Uniop uniop;
    @XmlElement(name = "Piecewise")
    protected Piecewise piecewise;
    @XmlElement(name = "FunctionCall")
    protected FunctionCallType functionCall;
	@XmlElement(name = "Sum", namespace = NS_DEFAULT_CT)
    protected Sum sum;
    @XmlElement(name = "Product", namespace = NS_DEFAULT_CT)
    protected Product product;
    @XmlElement(name = "Delay", namespace = NS_DEFAULT_CT)
    protected Delay delay;
    @XmlElement(name = "VectorSelector", namespace = NS_DEFAULT_CT)
    protected VectorSelector vectorSelector;
    @XmlElement(name = "MatrixSelector", namespace = NS_DEFAULT_CT)
    protected MatrixSelector matrixSelector;
    @XmlElement(name = "MatrixUniop")
    protected MatrixUniOp matrixUniop;
    @XmlElement(name = "Probability", namespace = NS_DEFAULT_MDEF)
    protected Probability probability;

    /**
     * Gets the value of the scalar property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     
     */
    public JAXBElement<?> getScalar() {
        return scalar;
    }

    /**
     * Sets the value of the scalar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     
     */
    public void setScalar(JAXBElement<?> value) {
        this.scalar = value;
    }

    /**
     * Gets the value of the symbRef property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

    /**
     * Gets the value of the binop property.
     * 
     * @return
     *     possible object is
     *     {@link Binop }
     *     
     */
    public Binop getBinop() {
        return binop;
    }

    /**
     * Sets the value of the binop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Binop }
     *     
     */
    public void setBinop(Binop value) {
        this.binop = value;
    }

    /**
     * Gets the value of the uniop property.
     * 
     * @return
     *     possible object is
     *     {@link Uniop }
     *     
     */
    public Uniop getUniop() {
        return uniop;
    }

    /**
     * Sets the value of the uniop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uniop }
     *     
     */
    public void setUniop(Uniop value) {
        this.uniop = value;
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
     * Gets the value of the functionCall property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionCallType }
     *     
     */
    public FunctionCallType getFunctionCall() {
        return functionCall;
    }

    /**
     * Sets the value of the functionCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionCallType }
     *     
     */
    public void setFunctionCall(FunctionCallType value) {
        this.functionCall = value;
    }

    /**
     * Gets the value of the sum property.
     * 
     * @return
     *     possible object is
     *     {@link Sum }
     *     
     */
    public Sum getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sum }
     *     
     */
    public void setSum(Sum value) {
        this.sum = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the delay property.
     * 
     * @return
     *     possible object is
     *     {@link Delay }
     *     
     */
    public Delay getDelay() {
        return delay;
    }

    /**
     * Sets the value of the delay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Delay }
     *     
     */
    public void setDelay(Delay value) {
        this.delay = value;
    }

    /**
     * Gets the value of the vectorSelector property.
     * 
     * @return
     *     possible object is
     *     {@link VectorSelector }
     *     
     */
    public VectorSelector getVectorSelector() {
        return vectorSelector;
    }

    /**
     * Sets the value of the vectorSelector property.
     * 
     * @param value
     *     allowed object is
     *     {@link VectorSelector }
     *     
     */
    public void setVectorSelector(VectorSelector value) {
        this.vectorSelector = value;
    }

    /**
     * Gets the value of the matrixSelector property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixSelector }
     *     
     */
    public MatrixSelector getMatrixSelector() {
        return matrixSelector;
    }

    /**
     * Sets the value of the matrixSelector property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixSelector }
     *     
     */
    public void setMatrixSelector(MatrixSelector value) {
        this.matrixSelector = value;
    }
    
    /**
     * Gets the value of the matrixUniop property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixUniOp }
     *     
     */
    public MatrixUniOp getMatrixUniop() {
        return matrixUniop;
    }

    /**
     * Sets the value of the matrixUniop property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixUniOp }
     *     
     */
    public void setMatrixUniop(MatrixUniOp value) {
        this.matrixUniop = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link Probability }
     *     
     */
    public Probability getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Probability }
     *     
     */
    public void setProbability(Probability value) {
        this.probability = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> list = new ChainedList<TreeNode>()
				.addIfNotNull(symbRef)
				.addIfNotNull(binop)
				.addIfNotNull(uniop)
				.addIfNotNull(piecewise)
				.addIfNotNull(functionCall)
				.addIfNotNull(sum)
				.addIfNotNull(product)
				.addIfNotNull(delay)
				.addIfNotNull(vectorSelector)
				.addIfNotNull(matrixSelector)
				.addIfNotNull(matrixUniop)
				.addIfNotNull(probability);
		if(scalar != null && scalar.getValue() instanceof TreeNode){
			list.add((TreeNode) scalar.getValue());
		}
		return list;
	}

}
