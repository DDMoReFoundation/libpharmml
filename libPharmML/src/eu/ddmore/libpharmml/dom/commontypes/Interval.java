/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
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
 * The definition of a range of numbers.
 *             
 * 
 * <p>Java class for IntervalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntervalType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="IntervalLength" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType"/>
 *         &lt;sequence>
 *           &lt;element name="LeftEndpoint" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}EndpointType"/>
 *           &lt;element name="RightEndpoint" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}EndpointType"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalType", propOrder = {
    "intervalLength",
    "leftEndpoint",
    "rightEndpoint"
})
public class Interval
    extends PharmMLRootType
{

    @XmlElement(name = "IntervalLength")
    protected StandardAssignable intervalLength;
    @XmlElement(name = "LeftEndpoint")
    protected Endpoint leftEndpoint;
    @XmlElement(name = "RightEndpoint")
    protected Endpoint rightEndpoint;
    
    /**
     * Empty constructor
     */
    public Interval(){}
    

    /**
     * Gets the value of the intervalLength property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getIntervalLength() {
        return intervalLength;
    }

    /**
     * Sets the value of the intervalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setIntervalLength(StandardAssignable value) {
        this.intervalLength = value;
    }

    /**
     * Gets the value of the leftEndpoint property.
     * 
     * @return
     *     possible object is
     *     {@link Endpoint }
     *     
     */
    public Endpoint getLeftEndpoint() {
        return leftEndpoint;
    }

    /**
     * Sets the value of the leftEndpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Endpoint }
     *     
     */
    public void setLeftEndpoint(Endpoint value) {
        this.leftEndpoint = value;
    }

    /**
     * Gets the value of the rightEndpoint property.
     * 
     * @return
     *     possible object is
     *     {@link Endpoint }
     *     
     */
    public Endpoint getRightEndpoint() {
        return rightEndpoint;
    }

    /**
     * Sets the value of the rightEndpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Endpoint }
     *     
     */
    public void setRightEndpoint(Endpoint value) {
        this.rightEndpoint = value;
    }
    
    /**
     * Creates a new empty {@link StandardAssignable} intervalLength element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createIntervalLength(){
            StandardAssignable el = new StandardAssignable();
            this.intervalLength = el;
            return el;
    }

    /**
     * Creates a new empty {@link Endpoint} leftEndpoint element, adds it to the current object and returns it.
     * @return The created {@link Endpoint} object.
     */
    public Endpoint createLeftEndpoint(){
            Endpoint el = new Endpoint();
            this.leftEndpoint = el;
            return el;
    }

    /**
     * Creates a new empty {@link Endpoint} rightEndpoint element, adds it to the current object and returns it.
     * @return The created {@link Endpoint} object.
     */
    public Endpoint createRightEndpoint(){
            Endpoint el = new Endpoint();
            this.rightEndpoint = el;
            return el;
    }

    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(intervalLength)
    			.addIfNotNull(leftEndpoint)
    			.addIfNotNull(rightEndpoint);
    }

}
