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


package eu.ddmore.libpharmml.dom.commontypes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * This type specifies a row of values in a matrix. The row can contain indexed cells or 
 *                 scalars/symbols filling the whole row. Index of the matrix row is optoinal. If cells are defined inside rows, 
 *                 the cells will be indexed relative to the row.
 * 
 * <p>Java class for MatrixRowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixRowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="RowIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixVectorIndexType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sequence"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixRowType", propOrder = {
    "rowIndex",
    "listOfValues"
})
public class MatrixRow
    extends PharmMLRootType
{

    @XmlElement(name = "RowIndex")
    protected MatrixVectorIndex rowIndex;
    @XmlElementRefs({
        @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Sequence", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Assign", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Equation", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false)
    })
    protected List<MatrixRowValue> listOfValues;
    @XmlAttribute(name = "default")
    protected Double _default;

    /**
     * Gets the value of the rowIndex property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixVectorIndex }
     *     
     */
    public MatrixVectorIndex getRowIndex() {
        return rowIndex;
    }

    /**
     * Sets the value of the rowIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixVectorIndex }
     *     
     */
    public void setRowIndex(MatrixVectorIndex value) {
        this.rowIndex = value;
    }

    /**
     * Gets the value of the scalarOrSequenceOrSymbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scalarOrSequenceOrSymbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScalarOrSequenceOrSymbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Sequence }{@code >}
     * {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     * {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     * {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     * {@link JAXBElement }{@code <}{@link SymbolRef }{@code >}
     * {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     * {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     * {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     * 
     * 
     */
    public List<MatrixRowValue> getListOfValues() {
        if (listOfValues == null) {
        	listOfValues = new ArrayList<MatrixRowValue>();
        }
        return this.listOfValues;
    }
	
    
	/**
	 * @deprecated The list of row values is now accessed through {@link #getListOfValues()}
	 */
    @SuppressWarnings("unchecked")
	@Deprecated
	public List<Object> getRealOrSymbRef() {
        return (List<Object>) (List<?>) getListOfValues();
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDefault() {
        if (_default == null) {
            return  0.0D;
        } else {
            return _default;
        }
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDefault(Double value) {
        this._default = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(rowIndex)
				.addIfNotNull(listOfValues);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
