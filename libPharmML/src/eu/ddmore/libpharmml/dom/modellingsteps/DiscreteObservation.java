//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.27 at 11:15:38 AM GMT 
//


package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRefType;


/**
 * 
 *                 Type defining the type of a discrete observation variable to be simulated.
 *             
 * 
 * <p>Java class for DiscreteObservationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiscreteObservationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiscreteObservationType", propOrder = {
    "listOfSymbRef"
})
public class DiscreteObservation
    extends PharmMLRootType
{

    @XmlElement(name = "SymbRef", namespace = "http://www.pharmml.org/2013/03/CommonTypes", required = true)
    protected List<SymbolRefType> listOfSymbRef;

    /**
     * 
     *                                 Refers to the variable to be observed. 
     *                             Gets the value of the symbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolRefType }
     * 
     * 
     */
    public List<SymbolRefType> getListOfSymbRef() {
        if (listOfSymbRef == null) {
        	listOfSymbRef = new ArrayList<SymbolRefType>();
        }
        return this.listOfSymbRef;
    }
    
    /**
     * Creates a new symbol reference, adds it to the current discrete observation and returns it.
     * @param symbId Id of the refered symbol,
     * @return The created {@link SymbolRefType} object.
     */
    public SymbolRefType createSymbolRef(String symbId){
    	SymbolRefType symbRef = new SymbolRefType();
    	symbRef.setId(symbId);
    	getListOfSymbRef().add(symbRef);
    	return symbRef;
    }
    
    /**
     * Creates a new symbol reference, adds it to the current discrete observation and returns it.
     * @param symbId Id of the refered symbol,
     * @param blkId Id of the blk of the refered symbol.
     * @return The created {@link SymbolRefType} object.
     */
    public SymbolRefType createSymbolRef(String symbId, String blkId){
    	SymbolRefType symbRef = new SymbolRefType();
    	symbRef.setId(symbId);
    	symbRef.setBlkIdRef(blkId);
    	getListOfSymbRef().add(symbRef);
    	return symbRef;
    }

}
