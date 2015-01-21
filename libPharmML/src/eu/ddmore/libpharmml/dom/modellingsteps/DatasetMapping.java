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


package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.VariableAssignment;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.DataSet;


/**
 * 
 *                 A type defining type data and task settings.                
 *             
 * 
 * <p>Java class for DatasetMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatasetMappingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ColumnMapping" type="{http://www.pharmml.org/2013/08/Dataset}ColumnMappingType" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/08/Dataset}DataSet"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatasetMappingType", propOrder = {
    "variableAssignment",
    "mapping",
	"columnMapping",
    "dataSet"
})
public class DatasetMapping
    extends PharmMLRootType
{

	@XmlElement(name = "VariableAssignment", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
	@Deprecated
    protected List<VariableAssignment> variableAssignment;
	@XmlElementRef(name = "Mapping", namespace = "http://www.pharmml.org/2013/03/ModellingSteps", type = JAXBElement.class)
	@Deprecated
    protected List<JAXBElement<? extends MappingType>> mapping;
    @XmlElement(name = "ColumnMapping", required = true)
    protected List<ColumnMapping> columnMapping;
    @XmlElement(name = "DataSet", namespace = "http://www.pharmml.org/2013/08/Dataset", required = true)
    protected DataSet dataSet;

	/**
     * 
     *                                 Initialises a variable.  
     *                             Gets the value of the variableAssignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableAssignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableAssignment }
     * 
     * @deprecated Since PharmML 0.3
     */
    @Deprecated
    public List<VariableAssignment> getVariableAssignment() {
        if (variableAssignment == null) {
            variableAssignment = new ArrayList<VariableAssignment>();
        }
        return this.variableAssignment;
    }
	
	/**
     * 
     *                                 Defines mapping to the dataset containing objective data. 
     *                             Gets the value of the mapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link VariableMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link MappingType }{@code >}
     * {@link JAXBElement }{@code <}{@link IndividualMapping }{@code >}
     * 
     * @deprecated Since PharmML 0.3
     */
    @Deprecated
    public List<JAXBElement<? extends MappingType>> getMapping() {
        if (mapping == null) {
            mapping = new ArrayList<JAXBElement<? extends MappingType>>();
        }
        return this.mapping;
    }
	
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
     * @since libPharmML 0.3
     */
    public List<ColumnMapping> getColumnMapping() {
        if (columnMapping == null) {
            columnMapping = new ArrayList<ColumnMapping>();
        }
        return this.columnMapping;
    }

    /**
     * 
     *                                 Instantiates the individual template defined above with data for each subject within
     *                                 the study.
     *                             
     * 
     * @return
     *     possible object is
     *     {@link DataSet }
     *     
     */
    public DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSet }
     *     
     */
    public void setDataSet(DataSet value) {
        this.dataSet = value;
    }

}
