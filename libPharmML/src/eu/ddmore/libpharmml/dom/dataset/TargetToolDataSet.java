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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 The type specifying the dataset for target tools. This type has optional 'Definition', otherwise identical with 'DataSetType'.
 *             
 * 
 * <p>Java class for TargetToolDataSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetToolDataSetType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}Definition" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}ImportTargetData"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}Table"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetToolDataSetType", propOrder = {
    "definition",
    "importTargetData",
    "table"
})
public class TargetToolDataSet
    extends PharmMLRootType
{

    @XmlElement(name = "Definition")
    protected HeaderColumnsDefinition definition;
    @XmlElement(name = "ImportTargetData")
    protected ImportTargetData importTargetData;
    @XmlElement(name = "Table")
    protected DataSetTable table;

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderColumnsDefinition }
     *     
     */
    public HeaderColumnsDefinition getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderColumnsDefinition }
     *     
     */
    public void setDefinition(HeaderColumnsDefinition value) {
        this.definition = value;
    }

    /**
     * 
     *                                     Import datafile
     *                                 
     * 
     * @return
     *     possible object is
     *     {@link ImportTargetData }
     *     
     */
    public ImportTargetData getImportTargetData() {
        return importTargetData;
    }

    /**
     * Sets the value of the importTargetData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportTargetData }
     *     
     */
    public void setImportTargetData(ImportTargetData value) {
        this.importTargetData = value;
    }

    /**
     * 
     * Defines a data table.
     *                                 
     * 
     * @return
     *     possible object is
     *     {@link DataSetTable }
     *     
     */
    public DataSetTable getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSetTable }
     *     
     */
    public void setTable(DataSetTable value) {
        this.table = value;
    }
    
    /**
     * Creates a new empty {@link HeaderColumnsDefinition} definition element, adds it to the current object and returns it.
     * @return The created {@link HeaderColumnsDefinition} object.
     */
    public HeaderColumnsDefinition createDefinition(){
            HeaderColumnsDefinition el = new HeaderColumnsDefinition();
            this.definition = el;
            return el;
    }

    /**
     * Creates a new empty {@link ImportTargetData} importTargetData element, adds it to the current object and returns it.
     * @return The created {@link ImportTargetData} object.
     */
    public ImportTargetData createImportTargetData(){
            ImportTargetData el = new ImportTargetData();
            this.importTargetData = el;
            return el;
    }

    /**
     * Creates a new empty {@link DataSetTable} table element, adds it to the current object and returns it.
     * @return The created {@link DataSetTable} object.
     */
    public DataSetTable createTable(){
            DataSetTable el = new DataSetTable();
            this.table = el;
            return el;
    }


	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(definition)
				.addIfNotNull(importTargetData)
				.addIfNotNull(table);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
