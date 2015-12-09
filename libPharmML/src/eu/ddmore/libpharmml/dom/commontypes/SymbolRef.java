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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.commontypes;

import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
import eu.ddmore.libpharmml.dom.maths.Operand;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;


/**
 * <p>Java class for SymbolRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SymbolRefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="blkIdRef" type="{http://www.pharmml.org/2013/03/CommonTypes}BlockIdType" />
 *       &lt;attribute name="symbIdRef" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymbolRefType")
@XmlRootElement(name = "SymbRef")
public class SymbolRef
    extends PharmMLRootType implements VectorCellValue, MatrixCellValue, MatrixRowValue, OperationVariable, Operand, ExpressionValue, MathExpression
{

    @XmlAttribute(name = "blkIdRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String blkIdRef;
    @XmlAttribute(name = "symbIdRef", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbIdRef;
    
    /**
     * Empty constructor.
     */
    public SymbolRef(){}
    
    /**
     * Creates a new reference to the given symbol.
     * @param symbIdRef Id of the refered symbol.
     */
    public SymbolRef(String symbIdRef){
    	this.symbIdRef = symbIdRef;
    }
    
    /**
     * Creates a new reference to the given symbol.
     * @param symbIdRef Id of the refered symbol.
     * @param blkIdRef Id of the block where the refered symbol is located.
     */
    public SymbolRef(String symbIdRef, String blkIdRef){
    	this.symbIdRef = symbIdRef;
    	this.blkIdRef = blkIdRef;
    }

    /**
     * Gets the value of the blkIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlkIdRef() {
        return blkIdRef;
    }

    /**
     * Sets the value of the blkIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlkIdRef(String value) {
        this.blkIdRef = value;
    }

    /**
     * Gets the value of the symbIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbIdRef() {
        return symbIdRef;
    }

    /**
     * Sets the value of the symbIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbIdRef(String value) {
        this.symbIdRef = value;
    }

	@Override
	public String asString() {
		return getSymbIdRef();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString()+" ");
		if(blkIdRef != null){
			sb.append("[");
			sb.append(blkIdRef);
			sb.append("]");
		}
		sb.append(symbIdRef);
		return sb.toString();
	};

	@Override
	public JAXBElement<SymbolRef> toJAXBElement() {
		return MasterObjectFactory.COMMONTYPES_OF.createSymbRef(this);
	}

	@Override
	protected List<TreeNode> listChildren() {
		return Collections.emptyList();
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
