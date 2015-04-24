package eu.ddmore.libpharmml.dom;

/**
 * Interface implemented by any element that has an "id" attribute, in order to be
 * annotatable.
 */
public interface Identifiable {
	
	/**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId();

    /**
     * Sets the value of the id property. The value must starts with "[A-Za-z]".
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value);

}
