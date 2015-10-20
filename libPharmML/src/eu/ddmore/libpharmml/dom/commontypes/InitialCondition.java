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
 * The initial condition of the derivative variable.
 * 
 * <p>Java class for InitialConditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitialConditionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="InitialValue" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialValueType" minOccurs="0"/>
 *         &lt;element name="InitialTime" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialTimeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitialConditionType", propOrder = {
	"assign",
    "initialValue",
    "initialTime"
})
public class InitialCondition
    extends PharmMLRootType
{

    @XmlElement(name = "Assign")
    @Deprecated
    protected Rhs assign;
	@XmlElement(name = "InitialValue")
    protected StandardAssignable initialValue;
    @XmlElement(name = "InitialTime")
    protected StandardAssignable initialTime;
	
	/**
	 * @deprecated
	 * The initial value assigned to the derivative.
     * Since version 0.3, PharmML supports additionally the storage of initial time t0 and not only the initial value. Use now {@link #getInitialTime()} and {@link #getInitialValue()} instead.
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    @Deprecated
	public Rhs getAssign() {
        return assign;
    }

    /**
     * @deprecated
     * Sets the value of the assign property.
     * Since version 0.3, PharmML supports additionally the storage of initial time t0 and 
     * not only the initial value. Use now {@link #setInitialTime(StandardAssignable)} and
     *  {@link #setInitialValue(StandardAssignable)} instead.
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    @Deprecated
	public void setAssign(Rhs value) {
        this.assign = value;
    }

    /**
     * The initial value of the ODE.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getInitialValue() {
        return initialValue;
    }

    /**
     * The initial value of the ODE.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setInitialValue(StandardAssignable value) {
        this.initialValue = value;
    }

    /**
     * The value of the initial condition time.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getInitialTime() {
        return initialTime;
    }

    /**
     * The value of the initial condition time.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setInitialTime(StandardAssignable value) {
        this.initialTime = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(assign)
				.addIfNotNull(initialValue)
				.addIfNotNull(initialTime);
	}

}
