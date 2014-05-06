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


/**
 * 
 *                 A type defining the modelling steps section.                 
 *             
 * 
 * <p>Java class for ModellingStepsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModellingStepsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="NONMEMdataSet" type="{http://www.pharmml.org/2013/03/ModellingSteps}NONMEMdataSetType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TargetTool" type="{http://www.pharmml.org/2013/03/ModellingSteps}TargetToolType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModellingSteps}CommonModellingStep" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StepDependencies" type="{http://www.pharmml.org/2013/03/ModellingSteps}StepDependencyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModellingStepsType", propOrder = {
    "nonmeMdataSet",
    "targetTool",
    "commonModellingStep",
    "stepDependencies"
})
public class ModellingStepsType
    extends PharmMLRootType
{

    @XmlElement(name = "NONMEMdataSet")
    protected List<NONMEMdataSetType> nonmeMdataSet;
    @XmlElement(name = "TargetTool")
    protected List<TargetToolType> targetTool;
    @XmlElementRef(name = "CommonModellingStep", namespace = "http://www.pharmml.org/2013/03/ModellingSteps", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CommonModellingStepType>> commonModellingStep;
    @XmlElement(name = "StepDependencies")
    protected StepDependencyType stepDependencies;

    /**
     * Gets the value of the nonmeMdataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonmeMdataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNONMEMdataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NONMEMdataSetType }
     * 
     * @since PharmML 0.3
     */
    public List<NONMEMdataSetType> getNONMEMdataSet() {
        if (nonmeMdataSet == null) {
            nonmeMdataSet = new ArrayList<NONMEMdataSetType>();
        }
        return this.nonmeMdataSet;
    }

    /**
     * Gets the value of the targetTool property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetTool property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetTool().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetToolType }
     * 
     * @since PharmML 0.3
     */
    public List<TargetToolType> getTargetTool() {
        if (targetTool == null) {
            targetTool = new ArrayList<TargetToolType>();
        }
        return this.targetTool;
    }

    /**
     * 
     *                                 A modelling step.                
     *                             Gets the value of the commonModellingStep property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonModellingStep property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonModellingStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CommonModellingStepType }{@code >}
     * {@link JAXBElement }{@code <}{@link SimulationStepType }{@code >}
     * {@link JAXBElement }{@code <}{@link EstimationStepType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CommonModellingStepType>> getCommonModellingStep() {
        if (commonModellingStep == null) {
            commonModellingStep = new ArrayList<JAXBElement<? extends CommonModellingStepType>>();
        }
        return this.commonModellingStep;
    }

    /**
     * Gets the value of the stepDependencies property.
     * 
     * @return
     *     possible object is
     *     {@link StepDependencyType }
     *     
     */
    public StepDependencyType getStepDependencies() {
        return stepDependencies;
    }

    /**
     * Sets the value of the stepDependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link StepDependencyType }
     *     
     */
    public void setStepDependencies(StepDependencyType value) {
        this.stepDependencies = value;
    }

}
