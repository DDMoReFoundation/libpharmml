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
package eu.ddmore.libpharmml.dom.dataset;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 * The type specifies the content of a dataset.
 *             
 * 
 * <p>Java class for DataSetTableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSetTableType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="HeaderRow" type="{http://www.pharmml.org/pharmml/0.7/Dataset}HeaderRowType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Row" type="{http://www.pharmml.org/pharmml/0.7/Dataset}DatasetRowType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSetTableType", propOrder = {
    "listOfHeaderRow",
    "liftOfRow"
})
public class DataSetTable
    extends PharmMLRootType
{

    @XmlElement(name = "HeaderRow")
    protected List<HeaderRow> listOfHeaderRow;
    @XmlElement(name = "Row", required = true)
    protected List<DatasetRow> liftOfRow;

    /**
     * Gets the value of the headerRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the headerRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfHeaderRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HeaderRow }
     * 
     * 
     */
    public List<HeaderRow> getListOfHeaderRow() {
        if (listOfHeaderRow == null) {
        	listOfHeaderRow = new ArrayList<HeaderRow>();
        }
        return this.listOfHeaderRow;
    }

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatasetRow }
     * 
     * 
     */
    public List<DatasetRow> getListOfRow() {
        if (liftOfRow == null) {
        	liftOfRow = new ArrayList<DatasetRow>();
        }
        return this.liftOfRow;
    }
    
    /**
     * Creates a new empty {@link HeaderRow} listOfHeaderRow element, adds it to the current object and returns it.
     * @return The created {@link HeaderRow} object.
     */
    public HeaderRow createHeaderRow(){
            HeaderRow el = new HeaderRow();
            getListOfHeaderRow().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link HeaderRow} listOfHeaderRow element, adds it to the current object and returns it.
     * @param order The order of the row.
     * @return The created {@link HeaderRow} object.
     */
    public HeaderRow createHeaderRow(Integer order){
            HeaderRow el = new HeaderRow();
            el.setOrder(order);
            getListOfHeaderRow().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link DatasetRow} liftOfRow element, adds it to the current object and returns it.
     * @return The created {@link DatasetRow} object.
     */
    public DatasetRow createRow(){
            DatasetRow el = new DatasetRow();
            getListOfRow().add(el);
            return el;
    }


	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(listOfHeaderRow)
				.addIfNotNull(liftOfRow);
	}

}
