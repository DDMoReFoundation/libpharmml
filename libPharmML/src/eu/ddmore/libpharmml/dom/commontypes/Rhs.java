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
package eu.ddmore.libpharmml.dom.commontypes;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Naryop;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.ProbabilityFunction;
import eu.ddmore.libpharmml.dom.maths.Statsop;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.modellingsteps.InitialEstimate;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Class defining a right-hand side assignment in an equation.
 * 
 * <p>This class proposes multiple single child elements. Although only 1 may be used in the given Rhs ir order to
 * be valid. If, for any reason, the content of a Rhs has to change, one can use the method {@link #clearContent()}
 * to make sure that any content is deleted before the new assignment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rhs">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Constant"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sequence"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Interval"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Vector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Matrix"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Interpolation"/>
 *         &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}RealisationType"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}PDF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}CDF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}HF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}SF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *         &lt;element name="Piecewise" type="{http://www.pharmml.org/pharmml/0.8/Maths}PiecewiseType"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}FunctionCall"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sum"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Product"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Delay"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}MatrixUniop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}Probability"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@SuppressWarnings("deprecation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rhs", propOrder = {
    "constant",
    "scalar",
    "symbRef",
    "sequence",
    "interval",
    "vector",
    "matrix",
    "interpolation",
    "realisation", // PharmML 0.8
    "pf", // PharmML 0.8
    "statsop", // PharmML 0.8
    "naryop", // PharmML 0.8
    "binop",
    "uniop",
    "piecewise_ct",
    "piecewise_math",
    "functionCall",
    "sum",
    "product",
    "delay",
    "vectorSelector",
    "matrixSelector",
    "matrixUniop",
    "probability",
    "equation" // < PharmML 0.7.1
})
@XmlSeeAlso({
    InitialEstimate.class
})
@XmlJavaTypeAdapter(RhsAdapter.class)
@HasElementRenamed(mappedFields = { 
		@RenamedElement(field = "piecewise_ct"),
		@RenamedElement(field = "piecewise_math", since = PharmMLVersion.V0_8_1)}, 
		transientField = "piecewise") 
public class Rhs
    extends PharmMLRootType implements MatrixCellValue, MatrixRowValue, OperationVariable, VectorValue
{

	// Here all the namespaces are specified, as Rhs may be used as math:Equation elements
	// in versions < 0.7.1.
	
	@XmlElement(name = "Equation", namespace = NS_DEFAULT_MATH)
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected Scalar scalar;
    @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElement(name = "Sequence", namespace = NS_DEFAULT_CT)
    protected Sequence sequence;
    @XmlElement(name = "Vector", namespace = NS_DEFAULT_CT)
    protected Vector vector;
    @XmlElement(name = "Interpolation", namespace = NS_DEFAULT_CT)
    protected Interpolation interpolation;
    @XmlElement(name = "Matrix", namespace = NS_DEFAULT_CT)
    protected Matrix matrix;
    
    // PharmML 0.7
    @XmlElement(name = "Constant", namespace = NS_DEFAULT_MATH)
    protected Constant constant;
    @XmlElement(name = "Interval", namespace = NS_DEFAULT_CT)
    protected Interval interval;
    
    // PharmML 0.7.1
    @XmlElement(name = "Binop", namespace = NS_DEFAULT_MATH)
    protected Binop binop;
    @XmlElement(name = "Uniop", namespace = NS_DEFAULT_MATH)
    protected Uniop uniop;
    
    @XmlElement(name = "Piecewise", namespace = NS_DEFAULT_CT)
    protected Piecewise piecewise_ct;
    @XmlElement(name = "Piecewise", namespace = NS_DEFAULT_MATH)
    protected Piecewise piecewise_math;
    @XmlTransient
    protected Piecewise piecewise;
    
    @XmlElement(name = "FunctionCall", namespace = NS_DEFAULT_MATH)
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
    @XmlElement(name = "MatrixUniop", namespace = NS_DEFAULT_MATH)
    protected MatrixUniOp matrixUniop;
    @XmlElement(name = "Probability", namespace = NS_DEFAULT_MDEF)
    protected Probability probability;
    
    // PharmML 0.8
    @XmlElement(name = "Realisation")
    protected Realisation realisation;
//    @XmlElement(name = "PDF", namespace = NS_DEFAULT_MATH)
//    protected ProbabilityFunction pdf;
//    @XmlElement(name = "CDF", namespace = NS_DEFAULT_MATH)
//    protected ProbabilityFunction cdf;
//    @XmlElement(name = "HF", namespace = NS_DEFAULT_MATH)
//    protected ProbabilityFunction hf;
//    @XmlElement(name = "SF", namespace = NS_DEFAULT_MATH)
//    protected ProbabilityFunction sf;
    @XmlElementRefs({
    		@XmlElementRef(name = "PDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    		@XmlElementRef(name = "SF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    		@XmlElementRef(name = "HF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    		@XmlElementRef(name = "CDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class)
    })
    protected ProbabilityFunction pf;
    @XmlElement(name = "Statsop", namespace = NS_DEFAULT_MATH)
    protected Statsop statsop;
    @XmlElement(name = "Naryop", namespace = NS_DEFAULT_MATH)
    protected Naryop naryop;
    
    /**
     * Empty constructor.
     */
    public Rhs(){}
    
    /**
     * Constructs a right-hand side assignment with a {@link Equation}.
     * @param equation The {@link Equation} to be assigned.
     * 
     * @deprecated Since PharmML 0.7.1, equations have been removed.
     */
    @Deprecated
    public Rhs(Equation equation){
    	this.equation = equation;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Scalar}.
     * @param scalar The {@link Scalar} to be assigned.
     */
    public Rhs(Scalar scalar){
    	this.scalar = scalar;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link SymbolRef}.
     * @param symbRef The {@link SymbolRef} to be assigned.
     */
    public Rhs(SymbolRef symbRef){
    	this.symbRef = symbRef;
    }

    /**
     * Constructs a right-hand side assignment with a {@link Sequence}.
     * @param sequence The {@link Sequence} to be assigned.
     */
    public Rhs(Sequence sequence){
    	this.sequence = sequence;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Vector}.
     * @param vector The {@link Vector} to be assigned.
     */
    public Rhs(Vector vector){
    	this.vector = vector;
    }
    
    /**
     * Constructs a right-hand side assignment with an {@link Interpolation}.
     * @param interpolation The {@link Interpolation} to be assigned.
     */
    public Rhs(Interpolation interpolation){
    	this.interpolation = interpolation;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Matrix}.
     * @param matrix The {@link Matrix} to be assigned.
     * 
     * @since PharmML 0.4.1
     */
    public Rhs(Matrix matrix){
    	this.matrix = matrix;
    }
    
    /**
     * Constructs a right-hand side assignment with an {@link Interval}.
     * @param interval The {@link Interval} to be assigned.
     * 
     * @since PharmML 0.7
     */
    public Rhs(Interval interval){
    	this.interval = interval;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Constant}.
     * @param constant The {@link Constant} to be assigned.
     * 
     * @since PharmML 0.7
     */
    public Rhs(Constant constant){
    	this.constant = constant;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Binop}.
     * @param binop
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Binop binop){
    	this.binop = binop;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Uniop}.
     * @param uniop
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Uniop uniop){
    	this.uniop = uniop;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Piecewise}.
     * @param pw
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Piecewise pw){
    	this.piecewise = pw;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link FunctionCallType}.
     * @param functionCall
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(FunctionCallType functionCall){
    	this.functionCall = functionCall;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Sum}.
     * @param sum
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Sum sum){
    	this.sum = sum;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Product}.
     * @param product
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Product product){
    	this.product = product;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Delay}.
     * @param delay
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Delay delay){
    	this.delay = delay;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link VectorSelector}.
     * @param vectorSelector
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(VectorSelector vectorSelector){
    	this.vectorSelector = vectorSelector;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link MatrixSelector}.
     * @param matrixSelector
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(MatrixSelector matrixSelector){
    	this.matrixSelector = matrixSelector;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link MatrixUniOp}.
     * @param matrixUniop
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(MatrixUniOp matrixUniop){
    	this.matrixUniop = matrixUniop;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Binop}.
     * @param probability
     * 
     * @since PharmML 0.7.1
     */
    public Rhs(Probability probability){
    	this.probability = probability;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Realisation}.
     * @param realisation
     * 
     * @since PharmML 0.8
     */
    public Rhs(Realisation realisation){
    	this.realisation = realisation;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link ProbabilityFunction}.
     * @param probaFunction
     * 
     * @since PharmML 0.8
     */
    public Rhs(ProbabilityFunction probaFunction){
    	this.pf = probaFunction;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Statsop}.
     * @param statsop
     * 
     * @since PharmML 0.8
     */
    public Rhs(Statsop statsop){
    	this.statsop = statsop;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Naryop}.
     * @param naryop
     * 
     * @since PharmML 0.8
     */
    public Rhs(Naryop naryop){
    	this.naryop = naryop;
    }
    
    /**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Equation }
     *     
     * @deprecated Since PharmML 0.7.1, equations have been removed.
     */
    @Deprecated
    public Equation getEquation() {
        return equation;
    }

    /**
     * Sets the value of the equation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Equation }
     *     
     * @deprecated Since PharmML 0.7.1, equations have been removed.
     */
    @Deprecated
    public void setEquation(Equation value) {
        this.equation = value;
    }
    
    /**
     * Gets the value of the constant property.
     * 
     * @return
     *     possible object is
     *     {@link Constant }
     *     
     * @since PharmML 0.7
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
     * @since PharmML 0.7
     */
    public void setConstant(Constant value) {
        this.constant = value;
    }

    /**
     * A scalar value.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     *     
     */
    public Scalar getScalar() {
        return scalar;
    }

    /**
     * Sets the value of the scalar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     *     
     */
    public void setScalar(Scalar value) {
        this.scalar = value;
    }

    /**
     * A variable reference.
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
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Sequence }
     *     
     */
    public Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequence }
     *     
     */
    public void setSequence(Sequence value) {
        this.sequence = value;
    }
    
    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Interval }
     *     
     * @since PharmML 0.7
     */
    public Interval getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interval }
     *     
     * @since PharmML 0.7
     */
    public void setInterval(Interval value) {
        this.interval = value;
    }

    /**
     * Gets the value of the vector property.
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Sets the value of the vector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setVector(Vector value) {
        this.vector = value;
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
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link Matrix }
     *     
     * @since PharmML 0.4.1
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matrix }
     *     
     * @since PharmML 0.4.1
     */
    public void setMatrix(Matrix value) {
        this.matrix = value;
    }
    
    /**
     * @since PharmML 0.7.1
     * @return A {@link Binop} object.
     */
    public Binop getBinop() {
		return binop;
	}

	public void setBinop(Binop binop) {
		this.binop = binop;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Uniop} object.
     */
	public Uniop getUniop() {
		return uniop;
	}

	public void setUniop(Uniop uniop) {
		this.uniop = uniop;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Piecewise} object.
     */
	public Piecewise getPiecewise() {
		return piecewise;
	}

	public void setPiecewise(Piecewise piecewise) {
		this.piecewise = piecewise;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link FunctionCallType} object.
     */
	public FunctionCallType getFunctionCall() {
		return functionCall;
	}

	public void setFunctionCall(FunctionCallType functionCall) {
		this.functionCall = functionCall;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Sum} object.
     */
	public Sum getSum() {
		return sum;
	}

	public void setSum(Sum sum) {
		this.sum = sum;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Product} object.
     */
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Delay} object.
     */
	public Delay getDelay() {
		return delay;
	}

	public void setDelay(Delay delay) {
		this.delay = delay;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link VectorSelector} object.
     */
	public VectorSelector getVectorSelector() {
		return vectorSelector;
	}

	public void setVectorSelector(VectorSelector vectorSelector) {
		this.vectorSelector = vectorSelector;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link MatrixSelector} object.
     */
	public MatrixSelector getMatrixSelector() {
		return matrixSelector;
	}

	public void setMatrixSelector(MatrixSelector matrixSelector) {
		this.matrixSelector = matrixSelector;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link MatrixUniOp} object.
     */
	public MatrixUniOp getMatrixUniop() {
		return matrixUniop;
	}

	public void setMatrixUniop(MatrixUniOp matrixUniop) {
		this.matrixUniop = matrixUniop;
	}

	/**
     * @since PharmML 0.7.1
     * @return A {@link Probability} object.
     */
	public Probability getProbability() {
		return probability;
	}

	public void setProbability(Probability probability) {
		this.probability = probability;
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
     * Gets the value of the probabilityFunction property.
     * 
     * @return
     *     possible object is
     *     {@link ProbabilityFunction }
     *     
     * @since PharmML 0.8
     */
    public ProbabilityFunction getProbabilityFunction() {
        return pf;
    }

    /**
     * Sets the value of the probabilityFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProbabilityFunction }
     *     
     * @since PharmML 0.8
     */
    public void setProbabilityFunction(ProbabilityFunction value) {
        this.pf = value;
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
     * Gets the unique content of this Rhs. Each mapped attribute is checked and the first checked one
     * that is not null is returned. Only one is returned even if 2 or more attributes have been set.
     * If there is no content, this method returns null.
     * @return Possible return types are {@link Equation}, {@link Scalar}, {@link SymbolRef}, 
     * {@link Vector}, {@link Matrix}, {@link Interpolation}, {@link Interval},
     * {@link Constant}, {@link Sequence}, {@link Binop}, {@link Uniop}, {@link Piecewise},
     * {@link FunctionCallType}, {@link Sum}, {@link Product}, {@link Delay}, {@link VectorSelector},
     * {@link MatrixSelector}, {@link MatrixUniOp} and {@link Probability}.
     */
    public Object getContent(){
    	if(scalar != null) return scalar;
    	if(symbRef != null) return symbRef;
    	if(vector != null) return vector;
    	if(matrix != null) return matrix;
    	if(interpolation != null) return interpolation;
    	if(sequence != null) return sequence;
    	if(interval != null) return interval;
    	if(constant != null) return constant;
    	if(binop != null) return binop;
    	if(uniop != null) return uniop;
    	if(piecewise != null) return piecewise;
    	if(functionCall != null) return functionCall;
    	if(sum != null) return sum;
    	if(product != null) return product;
    	if(delay != null) return delay;
    	if(vectorSelector != null) return vectorSelector;
    	if(matrixSelector != null) return matrixSelector;
    	if(matrixUniop != null) return matrixUniop;
    	if(probability != null) return probability;
    	if(realisation != null) return realisation;
    	if(pf != null) return pf;
    	if(statsop != null) return statsop;
    	if(naryop != null) return naryop;
    	if(equation != null) return equation;
    	else return null;
    }
    
    public void clearContent(){
    	this.equation = null;
		this.scalar = null;
		this.symbRef = null;
		this.sequence = null;
		this.vector = null;
		this.interpolation = null;
		this.matrix = null;
		this.constant = null;
		this.interval = null;
		this.binop = null;
		this.uniop = null;
		this.piecewise = null;
		this.functionCall = null;
		this.sum = null;
		this.product = null;
		this.delay = null;
		this.vectorSelector = null;
		this.matrixSelector = null;
		this.matrixUniop = null;
		this.probability = null;
		this.realisation = null;
		this.pf = null;
		this.statsop = null;
		this.naryop = null;
    }

	@Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> list = new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(scalar)
				.addIfNotNull(symbRef)
				.addIfNotNull(sequence)
				.addIfNotNull(interval)
				.addIfNotNull(vector)
				.addIfNotNull(interpolation)
				.addIfNotNull(matrix)
				.addIfNotNull(constant)
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
				.addIfNotNull(probability)
				.addIfNotNull(realisation)
				.addIfNotNull(pf)
				.addIfNotNull(statsop)
				.addIfNotNull(naryop)
				.addIfNotNull(equation);
		return list;
	}

	@Override
	public String asString() {
		return "Assign:"+String.valueOf(getContent());
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}

	@Override
	public String toMathExpression() {
		return new MathExpressionConverterToExpression().convert(this);
	}
	
	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
