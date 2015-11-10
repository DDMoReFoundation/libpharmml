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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for CategoryRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryRefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.6/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="blkIdRef" type="{http://www.pharmml.org/pharmml/0.6/CommonTypes}BlockIdType" />
 *       &lt;attribute name="catIdRef" use="required" type="{http://www.pharmml.org/pharmml/0.6/CommonTypes}CategoryIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.6.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryRefType")
public class CategoryRef
    extends PharmMLRootType
{

    @XmlAttribute(name = "blkIdRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String blkIdRef;
    @XmlAttribute(name = "catIdRef", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String catIdRef;
    
    public CategoryRef(){}
    
    public CategoryRef(String catIdRef){
    	this.catIdRef = catIdRef;
    }
    
    public CategoryRef(String catIdRef, String blkIdRef){
    	this.catIdRef = catIdRef;
    	this.blkIdRef = blkIdRef;
    }

    /**
     * Gets the value of the blkIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlkIdRef() {
        return blkIdRef;
    }

    /**
     * Sets the value of the blkIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlkIdRef(String value) {
        this.blkIdRef = value;
    }

    /**
     * Gets the value of the catIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatIdRef() {
        return catIdRef;
    }

    /**
     * Sets the value of the catIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatIdRef(String value) {
        this.catIdRef = value;
    }
    
    @Override
    public String toString() {
    	return super.toString()+" catIdRef:"+catIdRef+" blkIdRef:"+blkIdRef;
    }

}
