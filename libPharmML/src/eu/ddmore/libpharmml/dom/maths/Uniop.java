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
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.PharmMLVersion;


/**
 * 
 *                 The unary operator type. Takes one operator.
 *             
 * 
 * 
 *                         Extends the expression which is in effect the operand.
 *                     
 * 
 * <p>Java class for UniopType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UniopType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/Maths}ExprType">
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="abs"/>
 *             &lt;enumeration value="exp"/>
 *             &lt;enumeration value="factorial"/>
 *             &lt;enumeration value="factln"/>
 *             &lt;enumeration value="gammaln"/>
 *             &lt;enumeration value="ln"/>
 *             &lt;enumeration value="log"/>
 *             &lt;enumeration value="logistic"/>
 *             &lt;enumeration value="logit"/>
 *             &lt;enumeration value="normcdf"/>
 *             &lt;enumeration value="probit"/>
 *             &lt;enumeration value="minus"/>
 *             &lt;enumeration value="sqrt"/>
 *             &lt;enumeration value="sin"/>
 *             &lt;enumeration value="cos"/>
 *             &lt;enumeration value="tan"/>
 *             &lt;enumeration value="sec"/>
 *             &lt;enumeration value="csc"/>
 *             &lt;enumeration value="cot"/>
 *             &lt;enumeration value="sinh"/>
 *             &lt;enumeration value="cosh"/>
 *             &lt;enumeration value="tanh"/>
 *             &lt;enumeration value="sech"/>
 *             &lt;enumeration value="csch"/>
 *             &lt;enumeration value="coth"/>
 *             &lt;enumeration value="arcsin"/>
 *             &lt;enumeration value="arccos"/>
 *             &lt;enumeration value="arctan"/>
 *             &lt;enumeration value="arcsec"/>
 *             &lt;enumeration value="arccsc"/>
 *             &lt;enumeration value="arccot"/>
 *             &lt;enumeration value="arcsinh"/>
 *             &lt;enumeration value="arccosh"/>
 *             &lt;enumeration value="arctanh"/>
 *             &lt;enumeration value="arcsech"/>
 *             &lt;enumeration value="arccsch"/>
 *             &lt;enumeration value="arccoth"/>
 *             &lt;enumeration value="floor"/>
 *             &lt;enumeration value="ceiling"/>
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
@XmlType(name = "UniopType")
public class Uniop
    extends Expression implements Operand, ExpressionValue, MathExpression
{

    @XmlAttribute(name = "op", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String op;
    
    @XmlTransient
    protected Unioperator operator;
    
    /**
     * Empty constructor
     */
    public Uniop() {}
    
    /**
     * Creates a new unioperation with the given operator and the given value.
     * @param operator
     * @param value
     */
    public Uniop(Unioperator operator, ExpressionValue value){
    	this.operator = operator;
    	this.value = value;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *  
     * @deprecated Operator must now be accessed through {@link #getOperator()} (since libPharmML 0.4).
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
     *     allowed object is
     *     {@link String }
     * 
     * @deprecated Operator must now be accessed through {@link #setOperator(Unioperator)} (since libPharmML 0.4).
     */
    @Deprecated
    public void setOp(String value) {
        setOperator(Unioperator.fromString(value));
    }
    
    

	public Unioperator getOperator() {
		return operator;
	}

	public void setOperator(Unioperator operator) {
		this.operator = operator;
	}

	@Override
	public JAXBElement<Uniop> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createUniop(this);
	}
	
	/**
     * Clears the mapped attributes before setting their values for marshalling.
     */
    private void init(){
    	op = null;
    }
	
	protected void beforeMarshal(Marshaller m){
		init();
//		super.beforeMarshal(m);
		if(operator != null){
			if(getMarshalVersion() != null 
					&& getMarshalVersion().isBetween(PharmMLVersion.V0_3, PharmMLVersion.V0_3_1)
					&& operator.equals(Unioperator.LOG)){
						op = "ln";
			} else {
				op = operator.getOperator();
			}
		}
	}
	
	protected void afterUnmarshal(Unmarshaller u, Object parent) {
//		super.afterUnmarshal(u, parent);
		  if(op != null){
			  operator = Unioperator.fromString(op);
		  }
	}
	
	@Override
	public String toString() {
		String content = getValue().toString();
		
		StringBuilder sb = new StringBuilder();
		switch (operator){
		case MINUS:
			sb.append("- "+content);
			break;
		default:
			sb.append(operator+"("+content+")");
			break;
			
		}
		return sb.toString();
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
