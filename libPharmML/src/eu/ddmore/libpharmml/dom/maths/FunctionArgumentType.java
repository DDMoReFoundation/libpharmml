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
package eu.ddmore.libpharmml.dom.maths;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.commontypes.AnnotationType;
import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.SymbolName;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * A type defining an argument of a function being called.
 * 
 * <p>Java class for FunctionArgumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionArgumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Symbol" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Description" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Equation"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Constant"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sum"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Product"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}Probability"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="symbId" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionArgumentType", propOrder = {
    "symbol",
    "description",
    "assign",
    "equation",
    "scalar",
    "constant",
    "symbRef",
    "sum",
    "product",
    "vectorSelector",
    "matrixSelector",
    "probability"
})
@XmlSeeAlso({
    eu.ddmore.libpharmml.dom.maths.FunctionCallType.FunctionArgument.class
})
public class FunctionArgumentType extends PharmMLElement implements Symbol, Assignable, MathExpression {

    @XmlElement(name = "Symbol", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolName symbol;
    @XmlElement(name = "Description", namespace = XMLFilter.NS_DEFAULT_CT)
    protected AnnotationType description;
    
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT) // PharmML 0.7.1
    protected Rhs assign;
    @Deprecated
    @XmlElement(name = "Equation") // < PharmML 0.7.1
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected JAXBElement<?> scalar;
    @Deprecated
    @XmlElement(name = "Constant")
    protected Constant constant;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @Deprecated
    @XmlElement(name = "Sum", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Sum sum;
    @Deprecated
    @XmlElement(name = "Product", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Product product;
    @Deprecated
    @XmlElement(name = "VectorSelector", namespace = XMLFilter.NS_DEFAULT_CT)
    protected VectorSelector vectorSelector;
    @Deprecated
    @XmlElement(name = "MatrixSelector", namespace = XMLFilter.NS_DEFAULT_CT)
    protected MatrixSelector matrixSelector;
    @Deprecated
    @XmlElement(name = "Probability", namespace = XMLFilter.NS_DEFAULT_MDEF)
    protected Probability probability;
    
    @XmlAttribute(name = "symbId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolName }
     *     
     */
    public SymbolName getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolName }
     *     
     */
    public void setSymbol(SymbolName value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationType }
     *     
     */
    public AnnotationType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationType }
     *     
     */
    public void setDescription(AnnotationType value) {
        this.description = value;
    }
    
    /**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     * @since PharmML 0.7.1
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
     * @since PharmML 0.7.1
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

    /**
     * Gets the value of the equation property.
     * 
     * @return
     *     possible object is
     *     {@link Equation }
     *     
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
    public void setEquation(Equation value) {
        this.equation = value;
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * Gets the value of the sum property.
     * 
     * @return
     *     possible object is
     *     {@link Sum }
     *     
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
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
     * @deprecated Since PharmML 0.7.1, the value of the argument is located within {@link #getAssign()}.
     */
    @Deprecated
    public void setProbability(Probability value) {
        this.probability = value;
    }

    /**
     * Gets the value of the symbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbId() {
        return symbId;
    }

    /**
     * Sets the value of the symbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbId(String value) {
        this.symbId = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> list = new ChainedList<TreeNode>()
				.addIfNotNull(assign)
				.addIfNotNull(symbol)
				.addIfNotNull(description)
				.addIfNotNull(equation)
				.addIfNotNull(constant)
				.addIfNotNull(symbRef)
				.addIfNotNull(sum)
				.addIfNotNull(product)
				.addIfNotNull(vectorSelector)
				.addIfNotNull(matrixSelector)
				.addIfNotNull(probability);
		if(scalar != null && scalar.getValue() instanceof TreeNode){
			list.add((TreeNode) scalar.getValue());
		}
		return list;
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
	
	@Override
	public Rhs assign(Scalar scalar) {
		Rhs rhs = new Rhs(scalar);
		setAssign(rhs);
		return rhs;
	}

	@Deprecated
	public Rhs assign(Equation equation) {
		Rhs rhs = new Rhs(equation);
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
