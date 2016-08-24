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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.MissingDataAttribute;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * This is a data type for external data files.
 * 
 * <p>Java class for ImportDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="delimiter">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;enumeration value="TAB"/>
 *               &lt;enumeration value="SPACE"/>
 *               &lt;enumeration value="COMMA"/>
 *               &lt;enumeration value="SEMICOLON"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/2013/03/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportDataType", propOrder = {
    "name",
    "url",
    "path",
    "format",
    "delimiter",
    "listOfMissingData"
})
public class ExternalFile
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement
    @Deprecated
    protected String name;
    @XmlElement
    @Deprecated
    protected String url;
    
    @XmlElement(required = true)
    protected String path;
    
    @XmlElement(required = true)
    protected String format;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String delimiter;
    
    @XmlElement(name = "MissingData") // since PharmML 0.7
    protected List<MissingDataMap> listOfMissingData;
    
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;
    
    public ExternalFile() {
	}
    
    public ExternalFile(String oid, String path, String format, String delimiter){
    	this.oid = oid;
    	this.path = path;
    	this.format = format;
    	this.delimiter = delimiter;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     * @deprecated Path of the file is now accessed through {@link #getPath()}.
     */
    @Deprecated
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @deprecated Path of the file is now accessed through {@link #setPath(String)}.
     */
    @Deprecated
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     * @deprecated Path of the file is now accessed through {@link #getPath()}.
     */
    @Deprecated
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @deprecated Path of the file is now accessed through {@link #setPath(String)}.
     */
    public void setUrl(String value) {
        this.url = value;
    }
    
    /**
     * Gets the relative path to data file from the current PharmML document.
     * @return The value of the path property
     */
    public String getPath(){
    	return path;
    }
    /**
     * Sets the path to data file. It should always be relative from the current PharmML document.
     * @param path
     */
    public void setPath(String path){
    	this.path = path;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the delimiter property.
     * 
     * @return
     *     {@link Delimiter} enum value
     *     
     */
    public String getDelimiter() {
    	return delimiter;
    }

    /**
     * Sets the value of the delimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(Delimiter value) {
    	if(value == null){
    		this.delimiter = null;
    	} else {
    		this.delimiter = value.toString();
    	}
    }
    
    /**
     * Sets the value of the delimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(String value) {
        this.delimiter = value;
    }
    
    /**
     * The mapping of symbols used in dataset and allowed missing categories.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missingData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfMissingData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MissingDataMap }
     * 
     * @since PharmML 0.7
     */
    public List<MissingDataMap> getListOfMissingData() {
        if (listOfMissingData == null) {
        	listOfMissingData = new ArrayList<MissingDataMap>();
        }
        return this.listOfMissingData;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }
    
    public enum Delimiter{
    	COMMA("COMMA"),
    	SPACE("SPACE"),
    	TAB("TAB"),
    	SEMICOLON("SEMICOLON");
    	
    	private String value;
    	
    	private Delimiter(String v){
    		value = v;
    	}
    	@Override
    	public String toString(){
    		return value;
    	}
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(listOfMissingData);
	}
	
	/**
	 * Creates a new {@link MissingDataMap} empty object and adds it to the current
	 * external file.
	 * @return The created {@link MissingDataMap} instance.
	 * @since PharmML 0.7
	 */
	public MissingDataMap createMissingData(){
		MissingDataMap mdp = new MissingDataMap();
		getListOfMissingData().add(mdp);
		return mdp;
	}
	
	/**
	 * Creates a new {@link MissingDataMap} object and adds it to the current
	 * external file.
	 * @param dataCode Missing data representation in the dataset.
	 * @param missingDataType The type of missing data that the code represents.
	 * @return The created {@link MissingDataMap} instance.
	 * @since PharmML 0.7
	 */
	public MissingDataMap createMissingData(String dataCode, MissingDataAttribute missingDataType){
		MissingDataMap mdp = new MissingDataMap();
		mdp.setDataCode(dataCode);
		mdp.setMissingDataType(missingDataType);
		getListOfMissingData().add(mdp);
		return mdp;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
