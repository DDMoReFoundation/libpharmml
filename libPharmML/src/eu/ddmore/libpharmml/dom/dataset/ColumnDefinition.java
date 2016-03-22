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
package eu.ddmore.libpharmml.dom.dataset;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.SymbolType;


/**
 * <p>Java class for ColumnDefnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColumnDefnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="columnId" use="required" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbolIdType" />
 *       &lt;attribute name="columnType" type="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnTypeType" />
 *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="valueType" use="required" type="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnValueTypeType" />
 *       &lt;attribute name="columnNum" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnDefnType")
public class ColumnDefinition
    extends CommonColumnDefinition
{

	// CommonColumnDefinition inheritance removed since PharmML 0.7
	// Now should be PharmMLRootType
	
    @XmlAttribute(name = "columnId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String columnId;
    @XmlAttribute(name = "columnType") // required < PharmML 0.7.1
    protected List<ColumnType> listOfColumnType;
    @XmlAttribute(name = "level")
    protected String level;
    @XmlAttribute(name = "valueType", required = true)
    protected SymbolType valueType;
    
    /**
     * Empty constructor
     */
    public ColumnDefinition(){}
    
    /**
     * Creates a new column definition with all the required attributes.
     * @param columnId Identifier of the column.
     * @param valueType Type of the values within this column. The scalar elements within
     * this column must fit with this value type.
     * @param columnNum The column number. Needed to map the column into the dataset.
     */
    public ColumnDefinition(String columnId, SymbolType valueType, Integer columnNum){
    	this.columnId = columnId;
    	this.valueType = valueType;
    	this.columnNum = columnNum;
    }

    /**
     * Creates a new column definition with all the required attributes and the column type.
     * @param columnId Identifier of the column.
     * @param columnType Type of the column.
     * @param valueType Type of the values within this column. The scalar elements within
     * this column must fit with this value type.
     * @param columnNum The column number. Needed to map the column into the dataset.
     * 
     * @deprecated Use constructor {@link #ColumnDefinition(String, SymbolType, Integer, ColumnType...)}
     * for consistency.
     */
    @Deprecated
    public ColumnDefinition(String columnId, ColumnType columnType, SymbolType valueType, Integer columnNum){
    	this.columnId = columnId;
    	getListOfColumnType().add(columnType);
    	this.valueType = valueType;
    	this.columnNum = columnNum;
    }
    
    /**
     * Creates a new column definition with all the required attributes and the column type.
     * @param columnId Identifier of the column.
     * @param valueType Type of the values within this column. The scalar elements within
     * this column must fit with this value type.
     * @param columnNum The column number. Needed to map the column into the dataset.
     * @param types The types of this column. Can have multiple types.
     */
    public ColumnDefinition(String columnId, SymbolType valueType, Integer columnNum, ColumnType... types){
    	this.columnId = columnId;
    	setColumnType(types);
    	this.valueType = valueType;
    	this.columnNum = columnNum;
    }
    
    /**
     * Gets the value of the columnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * Sets the value of the columnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnId(String value) {
        this.columnId = value;
    }

    /**
     * The column type for this column. Optional if mapping of this column is defined then it is not 
     * required. This helps avoiding redundancies or inconsistencies.
     * 
     * @return
     *     possible object is
     *     {@link ColumnType }
     *     
     * @deprecated Since PharmML 0.8.1, columns can have multiple types. Use {@link #getListOfColumnType()}.
     */
    @Deprecated
    public ColumnType getColumnType() {
        if(getListOfColumnType().size() > 0){
        	return getListOfColumnType().get(0);
        } else {
        	return null;
        }
    }
    
    /**
     * The column type for this column. Optional if mapping of this column is defined then it is not 
     * required. This helps avoiding redundancies or inconsistencies. Since PharmML 0.8.1, column may 
     * have multiple types.
     * 
     * @param types
     *     allowed objects are
     *     {@link ColumnType }
     *    
     */
    public void setColumnType(ColumnType... types){
    	getListOfColumnType().clear();
    	for(ColumnType type : types){
    		getListOfColumnType().add(type);
    	}
    }
    
    /**
     * Gets the value of the columnType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnType }
     * 
     * @since PharmML 0.8.1
     */
    public List<ColumnType> getListOfColumnType() {
        if (listOfColumnType == null) {
        	listOfColumnType = new ArrayList<ColumnType>();
        }
        return this.listOfColumnType;
    }
    
    /**
     * Optional attribute to identify var level in SO.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     * @since PharmML 0.8.1
     */
    public String getLevel() {
        return level;
    }

    /**
     * Optional attribute to identify var level in SO.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @since PharmML 0.8.1
     */
    public void setLevel(String value) {
        this.level = value;
    }

    /**
     * Gets the value of the valueType property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolType }
     *     
     */
    public SymbolType getValueType() {
        return valueType;
    }

    /**
     * Sets the value of the valueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolType }
     *     
     */
    public void setValueType(SymbolType value) {
        this.valueType = value;
    }

}
