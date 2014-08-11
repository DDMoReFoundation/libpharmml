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


package eu.ddmore.libpharmml.dom.commontypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.util.SubList;


/**
 * 
 *                 The type specifies the content of a matrix.
 *             
 * 
 * <p>Java class for MatrixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="RowNames" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixColumnRowNames" minOccurs="0"/>
 *         &lt;element name="ColumnNames" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixColumnRowNames" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="MatrixRow" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixRowType" maxOccurs="unbounded"/>
 *           &lt;element name="MatrixCell" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixCellType" maxOccurs="unbounded"/>
 *           &lt;element name="MatrixBlock" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixBlockType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="diagDefault" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *       &lt;attribute name="offDiagDefault" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *       &lt;attribute name="numbCols" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="numbRows" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="matrixType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="Any"/>
 *             &lt;enumeration value="Diagonal"/>
 *             &lt;enumeration value="LowerTriangular"/>
 *             &lt;enumeration value="UpperTriangular"/>
 *             &lt;enumeration value="Symmetric"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixType", propOrder = {
    "rowNames",
    "columnNames",
    "matrixRowOrMatrixCellOrMatrixBlock"
})
public class MatrixType
    extends PharmMLRootType
{

    @XmlElement(name = "RowNames")
    protected MatrixColumnRowNames rowNames;
    @XmlElement(name = "ColumnNames")
    protected MatrixColumnRowNames columnNames;
    @XmlElements({
        @XmlElement(name = "MatrixRow", type = MatrixRowType.class),
        @XmlElement(name = "MatrixCell", type = MatrixCell.class),
        @XmlElement(name = "MatrixBlock", type = MatrixBlock.class)
    })
    protected List<PharmMLRootType> matrixRowOrMatrixCellOrMatrixBlock;
    @XmlAttribute(name = "diagDefault")
    protected Double diagDefault;
    @XmlAttribute(name = "offDiagDefault")
    protected Double offDiagDefault;
    @XmlAttribute(name = "numbCols")
    protected BigInteger numbCols;
    @XmlAttribute(name = "numbRows")
    protected BigInteger numbRows;
    @XmlAttribute(name = "matrixType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String matrixType;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;
    
    /**
     * @deprecated Use {@link Matrix} instead.
     */
    public MatrixType(){}
    
    /**
     * Internal purpose only.
     * @param a
     */
    protected MatrixType(int a){
    	
    }

    /**
     * Gets the value of the rowNames property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixColumnRowNames }
     *     
     */
    public MatrixColumnRowNames getRowNames() {
        return rowNames;
    }

    /**
     * Sets the value of the rowNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixColumnRowNames }
     *     
     */
    public void setRowNames(MatrixColumnRowNames value) {
        this.rowNames = value;
    }

    /**
     * Gets the value of the columnNames property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixColumnRowNames }
     *     
     */
    public MatrixColumnRowNames getColumnNames() {
        return columnNames;
    }

    /**
     * Sets the value of the columnNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixColumnRowNames }
     *     
     */
    public void setColumnNames(MatrixColumnRowNames value) {
        this.columnNames = value;
    }
	
	/**
     * Gets the value of the matrixRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matrixRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatrixRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatrixRowType }
     * 
     * @deprecated
     */
    public List<MatrixRowType> getMatrixRow() {
//        if (matrixRow == null) {
//            matrixRow = new ArrayList<MatrixRowType>();
//        }
//        return this.matrixRow;
    	return new SubList<MatrixRowType>(getListOfMatrixElements(), MatrixRowType.class);
    }

    /**
     * Gets the value of the matrixRowOrMatrixCellOrMatrixBlock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matrixRowOrMatrixCellOrMatrixBlock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatrixRowOrMatrixCellOrMatrixBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatrixRowType }
     * {@link MatrixCell }
     * {@link MatrixBlock }
     * 
     * 
     */
    public List<PharmMLRootType> getListOfMatrixElements() {
        if (matrixRowOrMatrixCellOrMatrixBlock == null) {
            matrixRowOrMatrixCellOrMatrixBlock = new ArrayList<PharmMLRootType>();
        }
        return this.matrixRowOrMatrixCellOrMatrixBlock;
    }

    /**
     * Gets the value of the diagDefault property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDiagDefault() {
        if (diagDefault == null) {
            return  0.0D;
        } else {
            return diagDefault;
        }
    }

    /**
     * Sets the value of the diagDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDiagDefault(Double value) {
        this.diagDefault = value;
    }

    /**
     * Gets the value of the offDiagDefault property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getOffDiagDefault() {
        if (offDiagDefault == null) {
            return  0.0D;
        } else {
            return offDiagDefault;
        }
    }

    /**
     * Sets the value of the offDiagDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOffDiagDefault(Double value) {
        this.offDiagDefault = value;
    }

    /**
     * Gets the value of the numbCols property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumbCols() {
        return numbCols;
    }

    /**
     * Sets the value of the numbCols property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumbCols(BigInteger value) {
        this.numbCols = value;
    }

    /**
     * Gets the value of the numbRows property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumbRows() {
        return numbRows;
    }

    /**
     * Sets the value of the numbRows property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumbRows(BigInteger value) {
        this.numbRows = value;
    }

    /**
     * Gets the value of the matrixType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatrixType() {
        return matrixType;
    }

    /**
     * Sets the value of the matrixType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatrixType(String value) {
        this.matrixType = value;
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
        
}
