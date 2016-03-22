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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.dataset.ExternalFile.Delimiter;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.validation.Validatable;


/**
 * 
 *                 The type specifying the dataset. The dataset is decribed in more detail in the Language Overview section of the specification.
 *             
 * 
 * <p>Java class for DataSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSetType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}Definition"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}ExternalFile"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}Table"/>
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
@XmlType(name = "DataSetType", propOrder = {
    "definition",
    "mapped_externalFile",
    "mapped_importData",
    "table"
})
@HasElementRenamed(mappedFields = { 
		@RenamedElement(field = "mapped_externalFile", since = PharmMLVersion.V0_6),
		@RenamedElement(field = "mapped_importData")
}, transientField = "externalFile")
public class DataSet
    extends PharmMLRootType implements Validatable
{

	// ExternalData renamed fields
	@XmlElement(name = "ExternalFile")
    protected ExternalFile mapped_externalFile;
    @XmlElement(name = "ImportData")
    protected ExternalFile mapped_importData;
    @XmlTransient
    protected ExternalFile externalFile;
    
    // PharmML 0.7 (reversed from WrappedList stuff)
    @XmlElement(name = "Definition")
    protected HeaderColumnsDefinition definition;
    @XmlElement(name = "Table")
    protected DataSetTable table;
    
//    /**
//     * @deprecated The list of row must now be get from {@link DataSetTable} via
//     * {@link #getTable()}.
//     */
//    @Deprecated
//    public List<DatasetRow> getListOfRow(){
//    	if(table == null){
//    		table = new DataSetTable();
//    	}
//    	return table.getListOfRow();
//    }
//    
//    /**
//     * @deprecated The list of column definitions is now available within {@link HeaderColumnsDefinition}
//     * via {@link #getDefinition()}.
//     */
//    @Deprecated
//    public List<ColumnDefinition> getListOfColumnDefinition(){
//    	if(definition == null){
//    		definition = new HeaderColumnsDefinition();
//    	}
//    	return definition.getListOfColumn();
//    }
    
    /**
     * Gets the value of the definition property. Contains a list of {@link ColumnDefinition}
     * and {@link HeaderColumnsDefinition}.
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
     * @deprecated Use {@link HeaderColumnsDefinition#createColumnDefinition(String, ColumnType, SymbolType, Integer)}
     * via {@link #getDefinition()}.
     */
    @Deprecated
    public ColumnDefinition createColumnDefinition(String columnId, ColumnType columnType, SymbolType valueType, Integer columnNum){
    	if(definition == null){
    		definition = new HeaderColumnsDefinition();
    	}
    	return definition.createColumnDefinition(columnId, columnType, valueType, columnNum);
    }
    
    /**
     * Creates a new row in this table with heterogeneous values. The actual type of each value is set
     * according to the valueType attribute of the corresponding column. The conversion is made during
     * the execution of this method. Therefore the reassignment of the valueType attribute of a column
     * after the execution of this method can lead to an inconsistency.
     * 
     * <p>Concerning booleans, only the string "true" (ignoring case) is converted to the DOM true boolean 
     * type. Any other string value equals "false". For example, the string "True" is converted to
     * {@link TrueBoolean}, whereas the string "1" is converted to {@link FalseBoolean}.
     * 
     * <p>If the length of the provided array does not match the number of columns, or if the valueType
     * attribute of one of these columns is undefined, an {@link IllegalStateException} is thrown. 
     * 
     * <p>An exception such as a {@link NumberFormatException} may also be thrown if the string value cannot
     * be converted to the type of the column.
     * 
     * @param values A {@link String} array of values.
     * @return The created row as a {@link DatasetRow} object. All the values may be accessed in their
     * DOM version within that object.
     */
    public DatasetRow createRow(String[] values){
    	DatasetRow row = new DatasetRow();
    	
    	if(getDefinition() == null){
    		throw new IllegalStateException("Can't create row from array without column definition.");
    	}
    	List<ColumnDefinition> listOfColumns = getDefinition().getListOfColumn();
    	
    	int size = values.length;
    	if(size != listOfColumns.size()){
    		throw new IllegalStateException("Size of the array of values does not match the number of columns");
    	}
    	
    	for(int i=0;i<size;i++){
    		SymbolType symbolType = listOfColumns.get(i).getValueType();
    		if(symbolType == null){
    			throw new IllegalStateException("valueType attribute is undefined for column "+i+".");
    		}
    		Scalar value = stringToScalar(symbolType, values[i]);
    		row.getListOfValue().add(value);
    	}
    	
    	DataSetTable table;
    	if(getTable() == null){
    		table = createTable();
    	} else {
    		table = getTable();
    	}
    	table.getListOfRow().add(row);
    	
    	return row;
    }
    
    /**
     * @deprecated Use createExternalFile(String, String, Delimiter, String) instead.
     */
    @Deprecated
    public ExternalFile createImportData(String path, String format, Delimiter delimiter, String oid){
    	return createExternalFile(path, format, delimiter, oid);
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
     * Creates a new empty {@link DataSetTable} table element, adds it to the current object and returns it.
     * @return The created {@link DataSetTable} object.
     */
    public DataSetTable createTable(){
            DataSetTable el = new DataSetTable();
            this.table = el;
            return el;
    }

    /**
     * Creates a new import data, adds it to the current dataset and returns it.
     * @param path The URL of the import data file.
     * @param format Format of the file such as "CSV".
     * @param delimiter Delimiter in the csv file.
     * @param oid Object id of the import data element.
     * @return The created import data as a {@link ExternalFile} object.
     */
    public ExternalFile createExternalFile(String path, String format, Delimiter delimiter, String oid){
    	ExternalFile data = new ExternalFile();
    	data.setPath(path);
    	data.setFormat(format);
    	data.setDelimiter(delimiter);
    	data.setOid(oid);
    	setExternalFile(data);
    	return data;
    }
    
    /**
     * 
     *                                     Import datafile
     *                                 
     * 
     * @return
     *     possible object is
     *     {@link ExternalFile }
     *     
     * @deprecated Use {@link #getExternalFile()} instead.
     */
    @Deprecated
    public ExternalFile getImportData() {
        return externalFile;
    }

    /**
     * Sets the value of the importData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalFile }
     *     
     * @deprecated Use {@link #setExternalFile(ExternalFile)}.
     */
    @Deprecated
    public void setImportData(ExternalFile value) {
        this.externalFile = value;
    }
    
    /**
     * 
     *                                     Import datafile
     *                                 
     * 
     * @return
     *     possible object is
     *     {@link ExternalFile }
     *     
     */
    public ExternalFile getExternalFile() {
        return externalFile;
    }

    /**
     * Sets the value of the importData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalFile }
     *     
     */
    public void setExternalFile(ExternalFile value) {
        this.externalFile = value;
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

	@Override
	public void validate(IErrorHandler errorHandler) {		
		
		boolean DS1a = false;
		
		if(getDefinition() != null){
			boolean hasIdColumn = false;
			List<ColumnDefinition> listOfColumn = getDefinition().getListOfColumn();
			for(ColumnDefinition col : listOfColumn){
				if(col.hasColumnType(ColumnType.ID)){
					if(hasIdColumn){
						DS1a = true;
					} else {
						hasIdColumn = true;
					}
				}
			}
			if(getTable() != null){
				for(DatasetRow row : getTable().getListOfRow()){
					int n = 0;
					try {
						for(Scalar value : row.getListOfValue()){
							n++;
							ColumnDefinition col = listOfColumn.get(n-1);
							if(col.getValueType() != null && !value.getClass().equals(col.getValueType().getDataType())){
								errorHandler.handleError("DS2", "Each cell must contain a value that is type compatible with the column definition.", this);
							}
						}
						if(n != listOfColumn.size()){
							errorHandler.handleError("DS3","Each row must define a cell for each column.",this);
						}
					} catch (IndexOutOfBoundsException e) {
						errorHandler.handleError("DS3","Each row must define a cell for each column.",this);
					}
				}
			}
		}
		
		
		
		
		if(DS1a){
			errorHandler.handleError("DS1", "Only one column with columnType=\"id\" attribute is allowed", this);
		}
		
	}
	
	/**
	 * Updates the DOM types of all the values stored in this dataset, following the valueType of each
	 * column definition. This method should be executed if the valueType of one of the column defitinio
	 * has been modified.
	 * 
	 * <p>An exception such as a {@link NumberFormatException} may be thrown if one value cannot
     * be converted to the type of the column.
	 */
	public void updateTypes(){
		if(definition != null && table != null){
			int columnSize = definition.getListOfColumn().size();
			for(DatasetRow row : table.getListOfRow()){
				int size = Math.min(columnSize, row.getListOfValue().size());
				for(int i=0;i<size;i++){
					Scalar preValue = row.getListOfValue().get(i);
					SymbolType symbolType = definition.getListOfColumn().get(i).getValueType();
					Scalar newValue = stringToScalar(symbolType, preValue.asString());
					row.getListOfValue().set(i, newValue);
				}
			}
		} else {
			LoggerWrapper.getLogger().warning("Can't update dataset types without defined definition and table.");
		}
	}
	
	/**
	 * Convert a string value to a scalar, following the given symbol type.
	 * @param type 
	 * @param value
	 * @return Possible types are {@link IdValue}, {@link RealValue}, {@link StringValue},
	 * {@link IntValue} or {@link BooleanValue}.
	 */
	private static Scalar stringToScalar(SymbolType type, String value){
		Scalar scalar;
		switch (type) {
			case ID:
				scalar = new IdValue(value);
				break;
			case REAL:
				scalar = new RealValue(Double.valueOf(value));
				break;
			case STRING:
				scalar = new StringValue(value);
				break;
			case INT:
				scalar = new IntValue(Integer.valueOf(value));
				break;
			case BOOLEAN:
				scalar = BooleanValue.fromBoolean(Boolean.parseBoolean(value));
				break;
			default:
				scalar = null;
				break;
		}
		return scalar;
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(definition)
				.addIfNotNull(externalFile)
				.addIfNotNull(table);
	}
	
}
