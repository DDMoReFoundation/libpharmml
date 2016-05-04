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
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 An activity that occurs during dosing. 
 *             
 * 
 * <p>Java class for ActivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/TrialDesign}LookupTable"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/TrialDesign}DosingRegimen"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/TrialDesign}Washout"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/2013/03/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.7, {@link TrialDesign} structure has been completely redefined. See PharmML
 * 0.7 change document, chapter 5.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityType", propOrder = {
    "lookupTable",
    "dosingRegimen",
    "washout"
})
@Deprecated
public class Activity
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "LookupTable")
    protected LookupTable lookupTable;
    @XmlElementRef(name = "DosingRegimen", namespace = NS_DEFAULT_TD, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends DosingRegimen> dosingRegimen;
    @XmlElement(name = "Washout")
    protected Washout washout;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

    /**
     * Gets the value of the lookupTable property.
     * 
     * @return
     *     possible object is
     *     {@link LookupTable }
     *     
     * @since PharmML 0.3
     */
    public LookupTable getLookupTable() {
        return lookupTable;
    }

    /**
     * Sets the value of the lookupTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupTable }
     *     
     * @since PharmML 0.3
     */
    public void setLookupTable(LookupTable value) {
        this.lookupTable = value;
    }

    /**
     * Gets the value of the dosingRegimen property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DosingRegimen }{@code >}
     *     {@link JAXBElement }{@code <}{@link Bolus }{@code >}
     *     {@link JAXBElement }{@code <}{@link Infusion }{@code >}
     *     
     */
    public JAXBElement<? extends DosingRegimen> getDosingRegimen() {
        return dosingRegimen;
    }

    /**
     * Sets the value of the dosingRegimen property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DosingRegimen }{@code >}
     *     {@link JAXBElement }{@code <}{@link Bolus }{@code >}
     *     {@link JAXBElement }{@code <}{@link Infusion }{@code >}
     *     
     */
    public void setDosingRegimen(JAXBElement<? extends DosingRegimen> value) {
        this.dosingRegimen = value;
    }

    /**
     * Gets the value of the washout property.
     * 
     * @return
     *     possible object is
     *     {@link Washout }
     *     
     */
    public Washout getWashout() {
        return washout;
    }

    /**
     * Sets the value of the washout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Washout }
     *     
     */
    public void setWashout(Washout value) {
        this.washout = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(lookupTable)
				.addJAXBIfNotNull(dosingRegimen)
				.addIfNotNull(washout);
	}

}
