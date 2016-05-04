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


/**
 * This type specifies a column of values in a matrix. The column can contain 
 * indexed cells or scalars/symbols filling the whole column. Index of the matrix column is optional. 
 * If cells are defined inside column, the cells will be indexed relative to the column.
 * 
 * <p>Java class for MatrixColumnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixColumnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ColumnIndex" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}MatrixVectorIndexType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Sequence"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}Equation"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixColumnType", propOrder = {
    "columnIndex",
    "scalarOrSequenceOrSymbRef"
})
public class MatrixColumn
    extends PharmMLRootType
{

    @XmlElement(name = "ColumnIndex")
    protected MatrixVectorIndex columnIndex;
    @XmlElementRefs({
        @XmlElementRef(name = "Sequence", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Assign", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    })
    protected List<MatrixRowValue> scalarOrSequenceOrSymbRef;
    @XmlAttribute(name = "default")
    protected Double _default;

    /**
     * Gets the value of the columnIndex property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixVectorIndex }
     *     
     */
    public MatrixVectorIndex getColumnIndex() {
        return columnIndex;
    }

    /**
     * Sets the value of the columnIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixVectorIndex }
     *     
     */
    public void setColumnIndex(MatrixVectorIndex value) {
        this.columnIndex = value;
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
     * Objects of the following type(s) are allowed in the list:
     * {@link StringValue },
     * {@link SymbolRef },
     * {@link RealValue },
     * {@link MissingValue },
     * {@link FalseBoolean },
     * {@link Sequence },
     * {@link IntValue },
     * {@link TrueBoolean },
     * {@link Rhs},
     * {@link IdValue }
     * 
     * 
     */
    public List<MatrixRowValue> getListOfValues() {
        if (scalarOrSequenceOrSymbRef == null) {
            scalarOrSequenceOrSymbRef = new ArrayList<MatrixRowValue>();
        }
        return this.scalarOrSequenceOrSymbRef;
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
    	List<TreeNode> list = new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(columnIndex);
    	if(scalarOrSequenceOrSymbRef != null){
    		for(Object item : scalarOrSequenceOrSymbRef){
    			if(item instanceof TreeNode){
    				list.add((TreeNode) item);
    			}
    		}
    	}
    	return list;
    }

}
