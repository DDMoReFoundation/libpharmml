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


package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.dom.dataset.DatasetMap;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * <p>Java class for IndividualDosingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualDosingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ActivityRef" type="{http://www.pharmml.org/2013/03/CommonTypes}OidRefType"/>
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
@XmlType(name = "IndividualDosingType", propOrder = {
    "activityRef",
    "columnMapping",
	"individualRef",
    "doseAmount",
    "dosingTime",
    "rate",
    "duration",
    "ssEndTime",
    "ssPeriod",
	"dataSet"
})
public class IndividualDosing
    extends PharmMLRootType implements DatasetMap
{

    @XmlElement(name = "ActivityRef", required = true)
    protected OidRef activityRef;
    @XmlElement(name = "ColumnMapping", required = true)
    protected List<ColumnMapping> columnMapping;
    @XmlElement(name = "DataSet", namespace = XMLFilter.NS_DEFAULT_DS, required = true)
    protected DataSet dataSet;
	@XmlElement(name = "IndividualRef", required = true)
	@Deprecated
    protected ColumnReference individualRef;
    @XmlElement(name = "DoseAmount")
    @Deprecated
    protected ColumnReference doseAmount;
    @XmlElement(name = "DosingTime")
    @Deprecated
    protected ColumnReference dosingTime;
    @XmlElement(name = "Rate")
    @Deprecated
    protected ColumnReference rate;
    @XmlElement(name = "Duration")
    @Deprecated
    protected ColumnReference duration;
    @XmlElement(name = "SSEndTime")
    @Deprecated
    protected ColumnReference ssEndTime;
    @XmlElement(name = "SSPeriod")
    @Deprecated
    protected ColumnReference ssPeriod;

    /**
     * Gets the value of the activityRef property.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     */
    public OidRef getActivityRef() {
        return activityRef;
    }

    /**
     * Sets the value of the activityRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     */
    public void setActivityRef(OidRef value) {
        this.activityRef = value;
    }

    /**
     * @deprecated Use {@link #getListOfColumnMapping()}.
     */
    @Deprecated
    public List<ColumnMapping> getColumnMapping() {
        return getListOfColumnMapping();
    }

    /**
     * 
     *                                 The dataset that instantiates the per-subject dosing regimen.
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
	
	/**
     * Gets the value of the individualRef property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getIndividualRef() {
        return individualRef;
    }

    /**
     * Sets the value of the individualRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setIndividualRef(ColumnReference value) {
        this.individualRef = value;
    }

    /**
     * Gets the value of the doseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getDoseAmount() {
        return doseAmount;
    }

    /**
     * Sets the value of the doseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setDoseAmount(ColumnReference value) {
        this.doseAmount = value;
    }

    /**
     * Gets the value of the dosingTime property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getDosingTime() {
        return dosingTime;
    }

    /**
     * Sets the value of the dosingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setDosingTime(ColumnReference value) {
        this.dosingTime = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setRate(ColumnReference value) {
        this.rate = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setDuration(ColumnReference value) {
        this.duration = value;
    }

    /**
     * Gets the value of the ssEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getSSEndTime() {
        return ssEndTime;
    }

    /**
     * Sets the value of the ssEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setSSEndTime(ColumnReference value) {
        this.ssEndTime = value;
    }

    /**
     * Gets the value of the ssPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public ColumnReference getSSPeriod() {
        return ssPeriod;
    }

    /**
     * Sets the value of the ssPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnReference }
     *     
     * @deprecated Since PharmML 0.3. Column mapping should be done through {@link #getColumnMapping()}.
     */
    @Deprecated
    public void setSSPeriod(ColumnReference value) {
        this.ssPeriod = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(activityRef)
				.addIfNotNull(columnMapping)
				.addIfNotNull(dataSet);
	}

	@Override
	public List<ColumnMapping> getListOfColumnMapping() {
		if (columnMapping == null) {
            columnMapping = new ArrayList<ColumnMapping>();
        }
        return this.columnMapping;
	}
}
