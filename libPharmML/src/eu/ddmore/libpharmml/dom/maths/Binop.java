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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.tags.LogicBinOperand;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 * A binary operator describing a numerical operation. Takes two operands (as you would expect).
 * 
 * <p><h3>Binary operator semantics:</h3>
 * Possible operators are listed within the {@link Binoperator} enum. Their semantics are described
 * in the following table:
 * 
 * <p><table border=1>
 * <tr><th>Operator</th><th>Definition</th><th>Operand 1</th><th>Operand 2</th></tr>
 * <tr>
 * 	<td>{@link Binoperator#PLUS}</td>
 * 	<td>a + b</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#MINUS}</td>
 * 	<td>a - b</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#TIMES}</td>
 * 	<td>a * b</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#DIVIDE}</td>
 * 	<td>a / b</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#POWER}</td>
 * 	<td>x<sup>y</sup></td>
 * 	<td>base (x)</td>
 * 	<td>exponent (y)</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#ROOT}</td>
 * 	<td><math xmlns="http://www.w3.org/1998/Math/MathML"><mroot><mrow>x</mrow><mn>y</mn></mroot></math></td>
 * 	<td>radicand (x)</td>
 * 	<td>degree (y)</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#LOGX}</td>
 * 	<td><math xmlns="http://www.w3.org/1998/Math/MathML"><mrow><msub><mi>log</mi><mi>y</mi></msub><mi>x</mi></mrow></math></td>
 * 	<td>power (x)</td>
 * 	<td>base (y)</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#MAX}</td>
 * 	<td>max {a b}</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#MIN}</td>
 * 	<td>min {a b}</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#REM}</td>
 * 	<td>a % b</td>
 * 	<td>dividend (a)</td>
 * 	<td>divisor (b)</td>
 * </tr>
 * <tr>
 * 	<td>{@link Binoperator#ATAN2}</td>
 * 	<td>atan2(a,b)</td>
 * 	<td>a</td>
 * 	<td>b</td>
 * </tr>
 * </table>
 * 
 * 
 * <p><h3>Schema:</h3>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinopType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Constant"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}PDF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}CDF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}HF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}SF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}FunctionCall"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sum"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Product"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Delay"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}Probability"/>
 *           &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}RealisationType"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Constant"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}PDF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}CDF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}HF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}SF"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}FunctionCall"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sum"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Product"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Delay"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}Probability"/>
 *           &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}RealisationType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="plus"/>
 *             &lt;enumeration value="minus"/>
 *             &lt;enumeration value="times"/>
 *             &lt;enumeration value="divide"/>
 *             &lt;enumeration value="power"/>
 *             &lt;enumeration value="logx"/>
 *             &lt;enumeration value="root"/>
 *             &lt;enumeration value="min"/>
 *             &lt;enumeration value="max"/>
 *             &lt;enumeration value="rem"/>
 *             &lt;enumeration value="atan2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinopType", propOrder = {
    "content"
})
public class Binop
    extends PharmMLRootType implements Operand, ExpressionValue, MathExpression, LogicBinOperand
{
    
	@XmlElementRefs({
        @XmlElementRef(name = "Sum", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
		@XmlElementRef(name = "ColumnRef", namespace = NS_DEFAULT_DS, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Uniop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MatrixSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FunctionCall", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Constant", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Delay", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VectorSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Binop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Probability", namespace = NS_DEFAULT_MDEF, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Product", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Realisation", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Statsop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Naryop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "PDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "CDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "HF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "SF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class) // PharmML 0.8
    })
    protected List<JAXBElement<?>> content;
    @XmlAttribute(name = "op", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String op;
    
    @XmlTransient
    protected Operand operand1;
    @XmlTransient
    protected Operand operand2;
    @XmlTransient
    protected Binoperator operator;
    
    /**
     * Empty constructor.
     */
    public Binop(){
    	init();
    }
    
    /**
     * Creates a new binop element with the provided operator.
     * @param operator
     */
    public Binop(Binoperator operator){
    	this();
    	this.operator = operator;
    }
    
    /**
     * Creates a new binop element with the provided operands and operator.
     * @param operator
     * @param operand1
     * @param operand2
     */
    public Binop(Binoperator operator, Operand operand1, Operand operand2){
    	this();
    	this.operator = operator;
    	this.operand1 = operand1;
    	this.operand2 = operand2;
    }

    /**
     * Clears the mapped attributes before setting their values for marshalling.
     */
    protected void init(){
    	content = new ArrayList<JAXBElement<?>>();
    	content.add(null);
    	content.add(null);
    	op = null;
    }
    
    /**
     * Gets the operator value of the binop.
     * @return The operator as {@link Binoperator} enum.
     */
    public Binoperator getOperator(){
    	return operator;
    }
    
    /**
     * Sets the operator of the binop.
     * @param operator 
     */
    public void setOperator(Binoperator operator){
    	this.operator = operator;
    }
    
    /**
     * Gets the 1st operand. See {@link Binop} documentation for the exact role of this operand 
     * following the operator.
     * @return Possible return types are:
     *   {@link Delay},
     *   {@link MatrixSelector},
     *   {@link Product},
     *   {@link Scalar},
     *   {@link Sum},
     *   {@link SymbolRef},
     *   {@link VectorSelector},
     *   {@link ColumnReference},
     *   {@link Binop},
     *   {@link Constant},
     *   {@link FunctionCallType},
     *   {@link Uniop},
     *   {@link Probability},
     *   {@link Realisation},
     *   {@link Statsop},
     *   {@link Naryop},
     *   {@link ProbabilityFunction}
     */
    public Operand getOperand1(){
    	return operand1;
    }
    
    /**
     * Gets the 2nd operand. See {@link Binop} documentation for the exact role of this operand 
     * following the operator.
     * @return Possible return types are:
     *   {@link Delay},
     *   {@link MatrixSelector},
     *   {@link Product},
     *   {@link Scalar},
     *   {@link Sum},
     *   {@link SymbolRef},
     *   {@link VectorSelector},
     *   {@link ColumnReference},
     *   {@link Binop},
     *   {@link Constant},
     *   {@link FunctionCallType},
     *   {@link Uniop},
     *   {@link Probability},
     *   {@link Realisation},
     *   {@link Statsop},
     *   {@link Naryop},
     *   {@link ProbabilityFunction}
     */
    public Operand getOperand2(){
    	return operand2;
    }
    
    /**
     * Sets the 1st operand. See {@link Binop} documentation for the exact role of this operand 
     * following the operator.
     * Possible types are:
     *   {@link Delay},
     *   {@link MatrixSelector},
     *   {@link Product},
     *   {@link Scalar},
     *   {@link Sum},
     *   {@link SymbolRef},
     *   {@link VectorSelector},
     *   {@link ColumnReference},
     *   {@link Binop},
     *   {@link Constant},
     *   {@link FunctionCallType},
     *   {@link Uniop},
     *   {@link Probability},
     *   {@link Realisation},
     *   {@link Statsop},
     *   {@link Naryop},
     *   {@link ProbabilityFunction}
     */
    public void setOperand1(Operand operand){
    	this.operand1 = operand;
    }
    
    /**
     * Sets the 2nd operand. See {@link Binop} documentation for the exact role of this operand 
     * following the operator.
     * Possible types are:
     *   {@link Delay},
     *   {@link MatrixSelector},
     *   {@link Product},
     *   {@link Scalar},
     *   {@link Sum},
     *   {@link SymbolRef},
     *   {@link VectorSelector},
     *   {@link ColumnReference},
     *   {@link Binop},
     *   {@link Constant},
     *   {@link FunctionCallType},
     *   {@link Uniop},
     *   {@link Probability},
     *   {@link Realisation},
     *   {@link Statsop},
     *   {@link Naryop},
     *   {@link ProbabilityFunction}
     */
    public void setOperand2(Operand operand){
    	this.operand2 = operand;
    }
    
    /**
    * Gets the value of the op property.
    *
    * @return
    * possible object is
    * {@link String }
    *
    * @deprecated Operator must now be get through {@link #getOperator()} (since libPharmML 0.4).
    */
    @Deprecated
    public String getOp() {
    	if(this.operator != null){
    		return this.operator.getOperator();
    	} else {
    		return null;
    	}
    }
    
    /**
    * Sets the value of the op property.
    *
    * @param value
    * allowed object is
    * {@link String }
    *
    * @deprecated Operator must now be set through {@link #setOperator(Binoperator)}
    * (since libPharmML 0.4).
    */
    @Deprecated
    public void setOp(String value) {
    	setOperator(Binoperator.fromString(value));
    }

	@Override
	public JAXBElement<Binop> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createBinop(this);
	}
	
	protected void beforeMarshal(Marshaller m){
		init();
		if(operand1 != null){
			content.set(0, operand1.toJAXBElement());
		}
		if(operand2 != null){
			content.set(1, operand2.toJAXBElement());
		}
		if(operator != null){
			op = operator.getOperator();
		}
	}
	
	protected void afterUnmarshal(Unmarshaller u, Object parent) {
		// TODO: use an adpater
		  if(content != null){
			  if(content.size() >= 1){
				  Object _operand = content.get(0).getValue();
				  if(_operand instanceof ProbabilityFunction){
					  try {
						operand1 = new ProbabilityFunction.Adapter().unmarshal((JAXBElement<ProbabilityFunction>) content.get(0));
					} catch (Exception e) {
						LoggerWrapper.getLogger().warning(_operand+" is not unmarshalled as it is not an Operand type.");
					}
				  } else if(_operand instanceof Operand){
					  operand1 = (Operand) _operand;
				  } else {
					  LoggerWrapper.getLogger().warning(_operand+" is not unmarshalled as it is not an Operand type.");
				  }
			  }
			  if(content.size() >= 2){
				  Object _operand = content.get(1).getValue();
				  if(_operand instanceof ProbabilityFunction){
					  try {
						operand2 = new ProbabilityFunction.Adapter().unmarshal((JAXBElement<ProbabilityFunction>) content.get(1));
					} catch (Exception e) {
						LoggerWrapper.getLogger().warning(_operand+" is not unmarshalled as it is not an Operand type.");
					}
				  } else if(_operand instanceof Operand){
					  operand2 = (Operand) _operand;
				  } else {
					  LoggerWrapper.getLogger().warning(_operand+" is not unmarshalled as it is not an Operand type.");
				  }
			  }
		  }
		  if(op != null){
			  operator = Binoperator.fromString(op);
		  }
	}
	
	@Override
	public String toString() {
		if(operator == null){
			return super.toString();
		} else {
			String superString = super.toString()+" [";
			String operand1String;
			String operand2String;
			if(operand1 instanceof Scalar){
				operand1String = ((Scalar) operand1).valueToString();
			} else {
				operand1String = String.valueOf(operand1);
			}
			if(operand2 instanceof Scalar){
				operand2String = ((Scalar) operand2).valueToString();
			} else {
				operand2String = String.valueOf(operand2);
			}
			String string;
			switch (operator) {
				case ATAN2:
					string = "atan2( "+operand1String+" , "+operand2String+" )";
					break;
				case DIVIDE:
					string = operand1String+" / "+operand2String;
					break;
				case LOGX:
					string = operand1String+"log "+operand2String;
					break;
				case MAX:
					string = "max{ "+operand1String+" , "+operand2String+" }";
					break;
				case MIN:
					string = "min{ "+operand1String+" , "+operand2String+" }";
					break;
				case MINUS:
					string = operand1String+" - "+operand2String;
					break;
				case PLUS:
					string = operand1String+" + "+operand2String;
					break;
				case POWER:
					string = operand1String+" ^ "+operand2String;
					break;
				case REM:
					string = operand1String+" % "+operand2String;
					break;
				case ROOT:
					string = operand2String+"root( "+operand1String+" )";
					break;
				case TIMES:
					string = operand1String+" x "+operand2String;
					break;
				default:
					string = "" + operand1String + operator + operand2String;
					break;
			}
			return superString+string+"]";
		}
	}

	@Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> children = new ArrayList<TreeNode>();
		if(operand1 instanceof TreeNode){
			children.add((TreeNode) operand1);
		}
		if(operand2 instanceof TreeNode){
			children.add((TreeNode) operand2);
		}
		return children;
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

	@Override
	public JAXBElement<Binop> toJAXBElementOfLogicBinOp() {
		return ObjectFactory.getInstance().createBinop(this);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
