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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.impl.XMLFilter;


/**
 * The schema type defining a binary logical operator.
 * 
 * <p>Java class for LogicBinOpType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogicBinOpType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicBinop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicUniop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Constant"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}FunctionCall"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sum"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Product"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}Probability"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicBinop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}LogicUniop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Constant"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/Maths}FunctionCall"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sum"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Product"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}Probability"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="lt"/>
 *             &lt;enumeration value="leq"/>
 *             &lt;enumeration value="gt"/>
 *             &lt;enumeration value="geq"/>
 *             &lt;enumeration value="eq"/>
 *             &lt;enumeration value="neq"/>
 *             &lt;enumeration value="and"/>
 *             &lt;enumeration value="or"/>
 *             &lt;enumeration value="xor"/>
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
@XmlType(name = "LogicBinOpType", propOrder = {
    "content"
})
public class LogicBinOp
    extends PharmMLRootType
{

    @XmlElementRefs({
        @XmlElementRef(name = "Sum", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LogicBinop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Constant", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Binop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VectorSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LogicUniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
		@XmlElementRef(name = "ColumnRef", namespace = XMLFilter.NS_DEFAULT_DS, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Uniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MatrixSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FunctionCall", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Probability", namespace = XMLFilter.NS_DEFAULT_MDEF, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Product", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ColumnRef", namespace = XMLFilter.NS_DEFAULT_DS, type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;
    @XmlAttribute(name = "op", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String op;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link LogicBinOp }{@code >}
     * {@link JAXBElement }{@code <}{@link ColumnReference }{@code >}
     * {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     * {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     * {@link JAXBElement }{@code <}{@link FunctionCallType }{@code >}
     * {@link JAXBElement }{@code <}{@link LogicUniOp }{@code >}
     * {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Binop }{@code >}
     * {@link JAXBElement }{@code <}{@link Uniop }{@code >}
     * {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     * {@link JAXBElement }{@code <}{@link SymbolRef }{@code >}
     * {@link JAXBElement }{@code <}{@link Constant }{@code >}
     * {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     * {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     * 
     * <p>
     * In order to be compliant with the PharmML specification (>= 0.3.1), only 1 {@link ColumnReference } is allowed in the content,
     * and should always be the 1st operand (i.e., the first element of this list). Anyway, this is checked only
     * during the XSD-based validation process.
     * </p>
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
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
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOp(String value) {
        this.op = value;
    }

}
