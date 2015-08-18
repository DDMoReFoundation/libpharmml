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
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 A type that defines a washout epoch. When this applies the system is reinitialised.
 *             
 * 
 * <p>Java class for WashoutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WashoutType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="VariableToReset" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}VariableToResetType" maxOccurs="unbounded"/>
 *         &lt;sequence>
 *           &lt;element name="Start" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TimepointsType"/>
 *           &lt;element name="End" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TimepointsType" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WashoutType", propOrder = {
    "listOfVariableToReset",
    "start",
    "end"
})
public class Washout
    extends PharmMLRootType
{
	
	@XmlElement(name = "VariableToReset")
    protected List<VariableToReset> listOfVariableToReset;
    @XmlElement(name = "Start")
    protected Timepoints start;
    @XmlElement(name = "End")
    protected Timepoints end;

    /**
     * Gets the value of the variableToReset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableToReset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfVariableToReset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableToReset }
     * 
     * 
     */
    public List<VariableToReset> getListOfVariableToReset() {
        if (listOfVariableToReset == null) {
        	listOfVariableToReset = new ArrayList<VariableToReset>();
        }
        return this.listOfVariableToReset;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Timepoints }
     *     
     */
    public Timepoints getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timepoints }
     *     
     */
    public void setStart(Timepoints value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Timepoints }
     *     
     */
    public Timepoints getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timepoints }
     *     
     */
    public void setEnd(Timepoints value) {
        this.end = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(listOfVariableToReset)
				.addIfNotNull(start)
				.addIfNotNull(end);
	}

	/**
	 * Creates a new empty {@link VariableToReset} VariableToReset element, adds it to the current object and returns it.
	 * @return The created {@link VariableToReset} object.
	 */
	public VariableToReset createVariableToReset(){
	        VariableToReset el = new VariableToReset();
	        getListOfVariableToReset().add(el);
	        return el;
	}

	/**
	 * Creates a new empty {@link Timepoints} start element, adds it to the current object and returns it.
	 * @return The created {@link Timepoints} object.
	 */
	public Timepoints createStart(){
	        Timepoints el = new Timepoints();
	        this.start = el;
	        return el;
	}

	/**
	 * Creates a new empty {@link Timepoints} end element, adds it to the current object and returns it.
	 * @return The created {@link Timepoints} object.
	 */
	public Timepoints createEnd(){
	        Timepoints el = new Timepoints();
	        this.end = el;
	        return el;
	}

}
