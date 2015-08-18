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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.impl.XMLFilter;


/**
 * 
 *                 An activity that occurs during dosing. 
 *             
 * 
 * <p>Java class for AdministrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdministrationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="InterventionRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/TrialDesign}DosingRegimen" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdministrationType", propOrder = {
    "interventionRef",
    "dosingRegimen"
})
public class Administration
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "InterventionRef")
    protected OidRef interventionRef;
    @XmlElementRef(name = "DosingRegimen", namespace = XMLFilter.NS_DEFAULT_TD, type = JAXBElement.class, required = false)
    protected JAXBElement<? extends DosingRegimen> dosingRegimen;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

    /**
     * Gets the value of the interventionRef property.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     */
    public OidRef getInterventionRef() {
        return interventionRef;
    }

    /**
     * Sets the value of the interventionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     */
    public void setInterventionRef(OidRef value) {
        this.interventionRef = value;
    }

    /**
     * Gets the value of the dosingRegimen property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DosingRegimenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BolusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InfusionType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link DosingRegimenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BolusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InfusionType }{@code >}
     *     
     */
    public void setDosingRegimen(JAXBElement<? extends DosingRegimen> value) {
        this.dosingRegimen = value;
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

}
