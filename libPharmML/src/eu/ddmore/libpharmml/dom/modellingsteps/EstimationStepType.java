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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Type defining the estimation step.
 *             
 * 
 * <p>Java class for EstimationStepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimationStepType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/ModellingSteps}CommonModellingStepType">
 *       &lt;sequence>
 *         &lt;element name="ObjectiveDataSet" type="{http://www.pharmml.org/2013/03/ModellingSteps}DatasetMappingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ParametersToEstimate" type="{http://www.pharmml.org/2013/03/ModellingSteps}ToEstimateType"/>
 *         &lt;element name="Operation" type="{http://www.pharmml.org/2013/03/ModellingSteps}EstimationOperationType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimationStepType", propOrder = {
    "objectiveDataSet",
    "parametersToEstimate",
    "operation"
})
public class EstimationStepType
    extends CommonModellingStep
{

    @XmlElement(name = "ObjectiveDataSet")
    protected List<DatasetMapping> objectiveDataSet;
    @XmlElement(name = "ParametersToEstimate", required = true)
    protected ToEstimate parametersToEstimate;
    @XmlElement(name = "Operation", required = true)
    protected List<EstimationOperation> operation;

    /**
     * Gets the value of the objectiveDataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectiveDataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectiveDataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatasetMapping }
     * 
     * 
     */
    public List<DatasetMapping> getObjectiveDataSet() {
        if (objectiveDataSet == null) {
            objectiveDataSet = new ArrayList<DatasetMapping>();
        }
        return this.objectiveDataSet;
    }

    /**
     * Gets the value of the parametersToEstimate property.
     * 
     * @return
     *     possible object is
     *     {@link ToEstimate }
     *     
     */
    public ToEstimate getParametersToEstimate() {
        return parametersToEstimate;
    }

    /**
     * Sets the value of the parametersToEstimate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToEstimate }
     *     
     */
    public void setParametersToEstimate(ToEstimate value) {
        this.parametersToEstimate = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstimationOperation }
     * 
     * 
     */
    public List<EstimationOperation> getOperation() {
        if (operation == null) {
            operation = new ArrayList<EstimationOperation>();
        }
        return this.operation;
    }

}
