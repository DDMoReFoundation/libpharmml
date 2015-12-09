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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;


/**
 * 
 *                 The schema type defining a mathematical constant.
 *             
 * 
 * <p>Java class for ConstantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConstantType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="notanumber"/>
 *             &lt;enumeration value="pi"/>
 *             &lt;enumeration value="exponentiale"/>
 *             &lt;enumeration value="infinity"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConstantType")
public class Constant extends PharmMLElement implements Operand, ExpressionValue, MathExpression {

    @XmlAttribute(name = "op", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String op;
    
    /**
     * Use constructor
     */
    @Deprecated
    public static final Constant NOTANUMBER = new Constant("notanumber");
    /**
     * Use constructor
     */
    @Deprecated
    public static final Constant PI = new Constant("pi");
    /**
     * Use constructor
     */
    @Deprecated
    public static final Constant EXPONENTIALE = new Constant("exponentiale");
    /**
     * Use constructor
     */
    @Deprecated
    public static final Constant INFINITY = new Constant("infinity");
    
    /**
     * Empty constructor.
     */
    public Constant(){}
    
    public Constant(ConstantOperator op){
    	this(op.value());
    }
    
    private Constant(String op){
    	this.op = op;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOp() {
        return op;
    }

    /**
     * Sets the value of the op property.
     * 
     * @param op A {@link ConstantOperator} enum value.
     */
    public void setOp(ConstantOperator op) {
        this.op = op.value();
    }

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createConstant(this);
	}
	
	@Override
	public String toString(){
		return this.getOp();
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
