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


package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.CommonVariableDefinition;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;


/**
 * 
 *                 Type that specifies a structural model.
 *             
 * 
 * <p>Java class for StructuralModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuralModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}SimpleParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}CommonVariable" maxOccurs="unbounded"/>
 *         &lt;element name="PKmacros" type="{http://www.pharmml.org/2013/03/ModelDefinition}PKmacroType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/2013/03/CommonTypes}BlockDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuralModelType", propOrder = {
    "name",
    "simpleParameter",
    "commonVariable",
    "pKmacros"
})
public class StructuralModel
    extends PharmMLRootType
{

    @XmlElement(name = "Name", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected Name name;
    @XmlElement(name = "SimpleParameter")
    protected List<SimpleParameter> simpleParameter;
    @XmlElementRef(name = "CommonVariable", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class)
    protected List<JAXBElement<? extends CommonVariableDefinition>> commonVariable;
    @XmlElement(name = "PKmacros")
    protected PKMacroList pKmacros;
    @XmlAttribute(name = "blkId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String blkId;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * A parameter definition.Gets the value of the simpleParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simpleParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleParameter }
     * 
     * 
     */
    public List<SimpleParameter> getSimpleParameter() {
        if (simpleParameter == null) {
            simpleParameter = new ArrayList<SimpleParameter>();
        }
        return this.simpleParameter;
    }

    /**
     * A variable definition.Gets the value of the commonVariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonVariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CommonVariableDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link VariableDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivativeVariable }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CommonVariableDefinition>> getCommonVariable() {
        if (commonVariable == null) {
            commonVariable = new ArrayList<JAXBElement<? extends CommonVariableDefinition>>();
        }
        return this.commonVariable;
    }

    /**
     * Gets the value of the pKmacros property.
     * 
     * @return
     *     possible object is
     *     {@link PKmacroType }
     *     
     */
    public PKMacroList getPKmacros() {
        return pKmacros;
    }

    /**
     * Sets the value of the pKmacros property.
     * 
     * @param value
     *     allowed object is
     *     {@link PKmacroType }
     *     
     */
    public void setPKmacros(PKMacroList value) {
        this.pKmacros = value;
    }

    /**
     * Gets the value of the blkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlkId() {
        return blkId;
    }

    /**
     * Sets the value of the blkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlkId(String value) {
        this.blkId = value;
    }

}