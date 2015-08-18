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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.util.ChainedList;

/**
* The definition of a uniform sequence of numbers. It has three forms:
* <ol>
*                 <li>Begin:StepSize:End or</li>
*                 <li>Begin:StepSize:StepNumber or</li>
*                 <li>Begin:StepNumber:End</li>
* </ol>
* 
* <p>Java class for SequenceType complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="SequenceType">
*   &lt;complexContent>
*     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
*       &lt;sequence>
*         &lt;element name="Begin" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Rhs"/>
*         &lt;element name="StepSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Rhs" minOccurs="0"/>
*         &lt;element name="StepNumber" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Rhs" minOccurs="0"/>
*         &lt;element name="End" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Rhs" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/extension>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceType", propOrder = {
    "begin",
    "stepSize",
    "stepNumber",
    "end",
    "repetitions"
})
public class Sequence
    extends PharmMLRootType implements VectorValue, MatrixRowValue
{

    @XmlElement(name = "Begin", required = true)
    protected Rhs begin;
    @XmlElement(name = "StepSize") // required < PharmML 0.7.1
    protected Rhs stepSize;
    
    // PharmML 0.7.1
    @XmlElement(name = "StepNumber")
    protected Rhs stepNumber;
    // -------------
    
    @XmlElement(name = "End")
    protected Rhs end;
    @XmlElement(name = "Repetitions")
    protected Rhs repetitions;

    /**
     * Gets the value of the begin property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getBegin() {
        return begin;
    }

    /**
     * Sets the value of the begin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setBegin(Rhs value) {
        this.begin = value;
    }

    /**
     * Gets the value of the stepSize property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getStepSize() {
        return stepSize;
    }

    /**
     * Sets the value of the stepSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setStepSize(Rhs value) {
        this.stepSize = value;
    }
    
    /**
     * Gets the value of the stepNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getStepNumber() {
        return stepNumber;
    }

    /**
     * Sets the value of the stepNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setStepNumber(Rhs value) {
        this.stepNumber = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setEnd(Rhs value) {
        this.end = value;
    }

    /**
     * Gets the value of the repetitions property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getRepetitions() {
        return repetitions;
    }

    /**
     * Sets the value of the repetitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setRepetitions(Rhs value) {
        this.repetitions = value;
    }

	@Override
	public String asString() {
		return this.toString();
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(begin)
				.addIfNotNull(stepSize)
				.addIfNotNull(stepNumber)
				.addIfNotNull(end)
				.addIfNotNull(repetitions);
	}

}
