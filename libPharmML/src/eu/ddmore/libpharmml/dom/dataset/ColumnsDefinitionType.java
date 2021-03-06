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


package eu.ddmore.libpharmml.dom.dataset;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 Type specifies all the columns in a dataset.
 *             
 * 
 * <p>Java class for ColumnsDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColumnsDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Column" type="{http://www.pharmml.org/2013/08/Dataset}ColumnDefnType"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.7, column definition are available within {@link HeaderColumnsDefinition}.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnsDefinitionType", propOrder = {
	"columnOrTable",
    "column"
})
@Deprecated
public class ColumnsDefinitionType
    extends PharmMLRootType
{
	@XmlElements({
        @XmlElement(name = "Column", type = ColumnDefinition.class),
        @XmlElement(name = "Table", type = DataSetTableDefnType.class)
    })
    protected List<CommonColumnDefinition> columnOrTable;
	
    @XmlElement(name = "Column")
    protected List<ColumnDefinition> column;
	
	/**
     * Gets the value of the columnOrTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnOrTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnOrTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnDefinition }
     * {@link DataSetTableDefnType }
     * 
     * @deprecated Since version 0.3. This method should only be used with 0.2 PharmML documents. 
     * This attribute would remain empty for other versions. Use {@link #getColumn()} instead.
     */
    @Deprecated
	public List<CommonColumnDefinition> getColumnOrTable() {
        if (columnOrTable == null) {
            columnOrTable = new ArrayList<CommonColumnDefinition>();
        }
        return this.columnOrTable;
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
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnDefinition }
     * 
     * 
     */
    public List<ColumnDefinition> getColumn() {
        if (column == null) {
            column = new ArrayList<ColumnDefinition>();
        }
        return this.column;
    }
        
    protected void afterUnmarshal(Unmarshaller unmarshaller, Object parent){
    	PharmMLVersion version = getUnmarshalVersion();
    	switch(version){
    	case V0_2_1 :
    		// nothing to do. Keep colorOrTable attribute
    		break;
    	default :
    		if(getColumnOrTable().size() > 0){
    			for(CommonColumnDefinition colOrTab : getColumnOrTable()){
        			if(colOrTab instanceof ColumnDefinition){
        				getColumn().add((ColumnDefinition)colOrTab);
        				LoggerWrapper.getLogger().info("Moved 1 column from columnOrTable attribute to column attribute in "+this);
        			} else {
        				LoggerWrapper.getLogger().warning("Skipping 1 table in the element "+this+". No more used in version "+version);
        			}
        		}
    			getColumnOrTable().clear();
    		}
    	}
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(column);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
