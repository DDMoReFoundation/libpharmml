/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.BooleanType;
import eu.ddmore.libpharmml.dom.commontypes.FalseBooleanType;
import eu.ddmore.libpharmml.dom.commontypes.IdValueType;
import eu.ddmore.libpharmml.dom.commontypes.IntValueType;
import eu.ddmore.libpharmml.dom.commontypes.RealValueType;
import eu.ddmore.libpharmml.dom.commontypes.StringValueType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRefType;
import eu.ddmore.libpharmml.dom.commontypes.TrueBooleanType;


/**
 * The schema type defining a mathematical expression.
 * 
 * <p>Java class for ExprType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExprType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Constant"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Uniop"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}FunctionCall"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExprType", propOrder = {
    "scalar",
    "symbRef",
    "constant",
    "binop",
    "uniop",
    "functionCall"
})
@XmlSeeAlso({
    UniopType.class,
    PieceType.class
})
public class ExprType {

    @XmlElementRef(name = "Scalar", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<?> scalar;
    @XmlElement(name = "SymbRef", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected SymbolRefType symbRef;
    @XmlElement(name = "Constant")
    protected ConstantType constant;
    @XmlElement(name = "Binop")
    protected BinopType binop;
    @XmlElement(name = "Uniop")
    protected UniopType uniop;
    @XmlElement(name = "FunctionCall")
    protected FunctionCallType functionCall;

    /**
     * Gets the value of the scalar property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBooleanType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBooleanType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link IdValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBooleanType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBooleanType }{@code >}
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
     *     {@link SymbolRefType }
     *     
     */
    public SymbolRefType getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRefType }
     *     
     */
    public void setSymbRef(SymbolRefType value) {
        this.symbRef = value;
    }

    /**
     * Gets the value of the constant property.
     * 
     * @return
     *     possible object is
     *     {@link ConstantType }
     *     
     */
    public ConstantType getConstant() {
        return constant;
    }

    /**
     * Sets the value of the constant property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantType }
     *     
     */
    public void setConstant(ConstantType value) {
        this.constant = value;
    }

    /**
     * Gets the value of the binop property.
     * 
     * @return
     *     possible object is
     *     {@link BinopType }
     *     
     */
    public BinopType getBinop() {
        return binop;
    }

    /**
     * Sets the value of the binop property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinopType }
     *     
     */
    public void setBinop(BinopType value) {
        this.binop = value;
    }

    /**
     * Gets the value of the uniop property.
     * 
     * @return
     *     possible object is
     *     {@link UniopType }
     *     
     */
    public UniopType getUniop() {
        return uniop;
    }

    /**
     * Sets the value of the uniop property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniopType }
     *     
     */
    public void setUniop(UniopType value) {
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

}
