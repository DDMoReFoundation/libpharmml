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

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 Type specifies the headers and columns in a dataset.
 *             
 * 
 * <p>Java class for HeaderColumnsDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderColumnsDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://www.pharmml.org/pharmml/0.7/Dataset}HeaderDefnType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Column" type="{http://www.pharmml.org/pharmml/0.7/Dataset}ColumnDefnType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderColumnsDefinitionType", propOrder = {
    "listOfHeader",
    "listOfColumn",
    "ignoreLine"
})
public class HeaderColumnsDefinition
    extends PharmMLRootType
{

    @XmlElement(name = "Header")
    protected List<HeaderDefinition> listOfHeader;
    @XmlElement(name = "Column", required = true)
    protected List<ColumnDefinition> listOfColumn;
    @XmlElement(name = "IgnoreLine")
    protected IgnoreLine ignoreLine;

    /**
     * Gets the value of the header property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the header property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfHeader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HeaderDefinition }
     * 
     * 
     */
    public List<HeaderDefinition> getListOfHeader() {
        if (listOfHeader == null) {
        	listOfHeader = new ArrayList<HeaderDefinition>();
        }
        return this.listOfHeader;
    }

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnDefinition }
     * 
     * 
     */
    public List<ColumnDefinition> getListOfColumn() {
        if (listOfColumn == null) {
        	listOfColumn = new ArrayList<ColumnDefinition>();
        }
        return this.listOfColumn;
    }
    
    /**
     * Creates a new empty {@link HeaderDefinition} listOfHeader element, adds it to the current object and returns it.
     * @return The created {@link HeaderDefinition} object.
     */
    public HeaderDefinition createHeaderDefinition(){
            HeaderDefinition el = ObjectFactory.getInstance().createHeaderDefinition();
            getListOfHeader().add(el);
            return el;
    }
    
    public HeaderDefinition createHeaderDefinition(String name, String headerType, Integer rowNumber){
    	HeaderDefinition el = ObjectFactory.getInstance().createHeaderDefinition();
    	el.setName(name);
    	el.setHeaderType(headerType);
    	el.setRowNumber(rowNumber);
        getListOfHeader().add(el);
        return el;
    }

    /**
     * Gets the value of the ignoreLine property.
     * 
     * @return
     *     possible object is
     *     {@link IgnoreLine }
     *     
     */
    public IgnoreLine getIgnoreLine() {
        return ignoreLine;
    }

    /**
     * Sets the value of the ignoreLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link IgnoreLine }
     *     
     */
    public void setIgnoreLine(IgnoreLine value) {
        this.ignoreLine = value;
    }

    /**
     * Creates a new empty {@link ColumnDefinition} listOfColumn element, adds it to the current object and returns it.
     * @return The created {@link ColumnDefinition} object.
     */
    public ColumnDefinition createColumnDefinition(){
            ColumnDefinition el = ObjectFactory.getInstance().createColumnDefnType();
            getListOfColumn().add(el);
            return el;
    }

    public ColumnDefinition createColumnDefinition(String columnId, ColumnType columnType, SymbolType valueType, Integer columnNum){
    	ColumnDefinition el = ObjectFactory.getInstance().createColumnDefnType();
    	el.setColumnId(columnId);
    	el.setColumnType(columnType);
    	el.setValueType(valueType);
    	el.setColumnNum(columnNum);
        getListOfColumn().add(el);
        return el;
    }
    
    public IgnoreLine createIgnoreLine(){
    	IgnoreLine il = new IgnoreLine();
    	this.ignoreLine = il;
    	return il;
    }
    
    public IgnoreLine createIgnoreLine(String symbol){
    	IgnoreLine il = new IgnoreLine();
    	il.setSymbol(symbol);
    	this.ignoreLine = il;
    	return il;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(listOfHeader)
    			.addIfNotNull(listOfColumn)
    			.addIfNotNull(ignoreLine);
    }
    
    @Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
