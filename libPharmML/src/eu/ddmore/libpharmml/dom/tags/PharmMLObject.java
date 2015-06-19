package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;

/**
 * Interface for all the PharmML elements thats can be identified as a
 * conceptual object. Those objects has a oid attribute, and can be
 * referred via a {@link OidRef} element.
 */
public interface PharmMLObject {
	
	/**
     * Gets the value of the oid property. This property can be used to refer
     * to this object via a {@link OidRef} element. The context of the 
     * {@link OidRef} element must be compatible with the type of this object.
     * 
     * @see OidRef
     * 
     * @return
     *     The oid property as a {@link String}.
     *     
     */
    public String getOid();

    /**
     * Sets the value of the oid property. The value of this property must be
     * unique within the whole PharmML document.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value);

}
