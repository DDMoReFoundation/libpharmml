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
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.CategoryRef;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * A logical expression.
 * 
 * <p>Java class for LogicExprType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogicExprType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.6/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}LogicBinop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}LogicUniop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}Constant"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}CatRef"/>
 *         &lt;element name="ArmRef" type="{http://www.pharmml.org/pharmml/0.6/CommonTypes}OidRefType"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}Uniop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/Maths}FunctionCall"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}Sum"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}Product"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}VectorSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/ModelDefinition}Probability"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicExprType", propOrder = {
    "logicBinop",
    "logicUniop",
    "scalar",
    "constant",
    "symbRef",
    "pf",
    "statsop",
    "naryop",
    "binop",
    "uniop",
    "functionCall",
    "sum",
    "product",
    "vectorSelector",
    "matrixSelector",
    "probability",
    "realisation",
    "catRef", //TODO: deprecated ?
    "armRef" //TODO: deprecated ?
})
@XmlSeeAlso({
    LogicUniOp.class
})
public class LogicExpression
    extends PharmMLRootType
{

    @XmlElement(name = "LogicBinop")
    protected LogicBinOp logicBinop;
    @XmlElement(name = "LogicUniop")
    protected LogicUniOp logicUniop;
    @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected JAXBElement<?> scalar;
    @XmlElement(name = "Constant")
    protected Constant constant;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElement(name = "Binop")
    protected Binop binop;
    @XmlElement(name = "Uniop")
    protected Uniop uniop;
    @XmlElement(name = "FunctionCall")
    protected FunctionCallType functionCall;
    @XmlElement(name = "Sum", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Sum sum;
    @XmlElement(name = "Product", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Product product;
    @XmlElement(name = "VectorSelector", namespace = XMLFilter.NS_DEFAULT_CT)
    protected VectorSelector vectorSelector;
    @XmlElement(name = "MatrixSelector", namespace = XMLFilter.NS_DEFAULT_CT)
    protected MatrixSelector matrixSelector;
    @XmlElement(name = "Probability", namespace = XMLFilter.NS_DEFAULT_MDEF)
    protected Probability probability;
    
    // PharmML 0.6.2
    @XmlElement(name = "CatRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected CategoryRef catRef;
    @XmlElement(name = "ArmRef")
    protected OidRef armRef;
    
    // PharmML 0.8
    @XmlElementRefs({
		@XmlElementRef(name = "PDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
		@XmlElementRef(name = "SF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
		@XmlElementRef(name = "HF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
		@XmlElementRef(name = "CDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class)
    })
    protected ProbabilityFunction pf;
    @XmlElement(name = "Statsop")
    protected Statsop statsop;
    @XmlElement(name = "Naryop")
    protected Naryop naryop;
    @XmlElement(name = "Realisation")
    protected Realisation realisation;

    /**
     * Gets the value of the logicBinop property.
     * 
     * @return
     *     possible object is
     *     {@link LogicBinOp }
     *     
     */
    public LogicBinOp getLogicBinop() {
        return logicBinop;
    }

    /**
     * Sets the value of the logicBinop property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicBinOp }
     *     
     */
    public void setLogicBinop(LogicBinOp value) {
        this.logicBinop = value;
    }

    /**
     * Gets the value of the logicUniop property.
     * 
     * @return
     *     possible object is
     *     {@link LogicUniOp }
     *     
     */
    public LogicUniOp getLogicUniop() {
        return logicUniop;
    }

    /**
     * Sets the value of the logicUniop property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicUniOp }
     *     
     */
    public void setLogicUniop(LogicUniOp value) {
        this.logicUniop = value;
    }

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
     * Gets the value of the constant property.
     * 
     * @return
     *     possible object is
     *     {@link Constant }
     *     
     */
    public Constant getConstant() {
        return constant;
    }

    /**
     * Sets the value of the constant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Constant }
     *     
     */
    public void setConstant(Constant value) {
        this.constant = value;
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
    
    /**
     * Gets the value of the catRef property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryRef }
     *     
     * @since PharmML 0.6.2
     */
    public CategoryRef getCatRef() {
        return catRef;
    }

    /**
     * Sets the value of the catRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryRef }
     *     
     * @since PharmML 0.6.2
     */
    public void setCatRef(CategoryRef value) {
        this.catRef = value;
    }

    /**
     * Gets the value of the armRef property.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.6.2
     */
    public OidRef getArmRef() {
        return armRef;
    }

    /**
     * Sets the value of the armRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.6.2
     */
    public void setArmRef(OidRef value) {
        this.armRef = value;
    }
    
    /**
     * Gets the value of the statsop property.
     * 
     * @return
     *     possible object is
     *     {@link Statsop }
     *     
     * @since PharmML 0.8
     */
    public Statsop getStatsop() {
        return statsop;
    }

    /**
     * Sets the value of the statsop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statsop }
     *     
     * @since PharmML 0.8
     */
    public void setStatsop(Statsop value) {
        this.statsop = value;
    }

    /**
     * Gets the value of the naryop property.
     * 
     * @return
     *     possible object is
     *     {@link Naryop }
     *     
     * @since PharmML 0.8
     */
    public Naryop getNaryop() {
        return naryop;
    }

    /**
     * Sets the value of the naryop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Naryop }
     *     
     * @since PharmML 0.8
     */
    public void setNaryop(Naryop value) {
        this.naryop = value;
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
    
    public ProbabilityFunction getProbabilityFunction(){
    	return pf;
    }
    
    public void setProbabilityFunction(ProbabilityFunction pf){
    	this.pf = pf;
    }


    @Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> list = new ChainedList<TreeNode>()
				.addIfNotNull(logicBinop)
				.addIfNotNull(logicUniop)
				.addIfNotNull(constant)
				.addIfNotNull(symbRef)
				.addIfNotNull(catRef)
				.addIfNotNull(armRef)
				.addIfNotNull(binop)
				.addIfNotNull(uniop)
				.addIfNotNull(functionCall)
				.addIfNotNull(sum)
				.addIfNotNull(product)
				.addIfNotNull(vectorSelector)
				.addIfNotNull(matrixSelector)
				.addIfNotNull(probability)
				.addIfNotNull(pf)
				.addIfNotNull(statsop)
				.addIfNotNull(naryop)
				.addIfNotNull(realisation);
		if(scalar != null && scalar.getValue() instanceof TreeNode){
			list.add((TreeNode) scalar.getValue());
		}
		return list;
	}


}
