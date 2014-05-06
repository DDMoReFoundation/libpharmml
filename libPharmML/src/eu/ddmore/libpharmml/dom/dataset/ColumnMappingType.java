/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRefType;


/**
 * 
 *                 The type that defines column mapping.
 *             
 * 
 * <p>Java class for ColumnMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColumnMappingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}ColumnRef"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnMappingType", propOrder = {
    "columnRef",
    "symbRef"
})
public class ColumnMappingType
    extends PharmMLRootType
{

    @XmlElement(name = "ColumnRef", required = true)
    protected ColumnRefType columnRef;
    @XmlElement(name = "SymbRef", namespace = "http://www.pharmml.org/2013/03/CommonTypes", required = true)
    protected SymbolRefType symbRef;

    /**
     * 
     *                                 The column reference to map to.
     *                             
     * 
     * @return
     *     possible object is
     *     {@link ColumnRefType }
     *     
     */
    public ColumnRefType getColumnRef() {
        return columnRef;
    }

    /**
     * Sets the value of the columnRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnRefType }
     *     
     */
    public void setColumnRef(ColumnRefType value) {
        this.columnRef = value;
    }

    /**
     * Reference to the symbol to map the column data to.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRefType }
     *     
     */
    public SymbolRefType getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRefType }
     *     
     */
    public void setSymbRef(SymbolRefType value) {
        this.symbRef = value;
    }

}
