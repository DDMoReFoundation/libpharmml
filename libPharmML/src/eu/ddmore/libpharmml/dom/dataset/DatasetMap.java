package eu.ddmore.libpharmml.dom.dataset;

import java.util.List;

/**
 * Interface for elements that describe a {@link DataSet} and a list of {@link ColumnMapping} objects.
 * All the classes that implement this interface will be validated following the dataset mapping
 * validation rules.
 */
public interface DatasetMap {
	
	/**
	 * Gets the value of the columnMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnMapping }
     * 
	 * @return A {@link List} of {@link ColumnMapping} objects.
	 */
	public List<ColumnMapping> getListOfColumnMapping();
	
	public DataSet getDataSet();

}
