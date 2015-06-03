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

import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;


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
public class Constant extends PharmMLElement implements Operand, ExpressionValue{

    @XmlAttribute(name = "op", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String op;
    
    public static final Constant NOTANUMBER = new Constant("notanumber");
    public static final Constant PI = new Constant("pi");
    public static final Constant EXPONENTIALE = new Constant("exponentiale");
    public static final Constant INFINITY = new Constant("infinity");
    
    /**
     * Empty constructor.
     */
    protected Constant(){}
    
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

//    /**
//     * Sets the value of the op property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *     
//     */
//    public void setOp(String value) {
//        this.op = value;
//    }

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createConstant(this);
	}
	
	@Override
	public String toString(){
		return this.getOp();
	}

	@Override
	protected List<TreeNode> listChildren() {
		return Collections.emptyList();
	}

}
