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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;


/**
 * 
 *                 Type that defines variable/parameter, used in the injected code, to be mapped to the model or dataset.
 *             
 * 
 * <p>Java class for SymbolMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SymbolMappingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Dataset}ColumnRef"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymbolMappingType", propOrder = {
    "rest"
})
public class SymbolMapping
    extends PharmMLRootType
{

	//TODO: use an adapter
	
    @XmlElementRefs({
        @XmlElementRef(name = "ColumnRef", namespace = NS_DEFAULT_DS, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends PharmMLRootType>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "SymbRef" is used by two different parts of a schema. See: 
     * line 1419 of file:/automount/nas17b_vol-vol_homes-homes/florent/git/libPharmML/libPharmML/src/eu/ddmore/libpharmml/impl/definitions/0_7/trialDesign.xsd
     * line 1411 of file:/automount/nas17b_vol-vol_homes-homes/florent/git/libPharmML/libPharmML/src/eu/ddmore/libpharmml/impl/definitions/0_7/trialDesign.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ColumnReference }{@code >}
     * {@link JAXBElement }{@code <}{@link SymbolRef }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends PharmMLRootType>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<? extends PharmMLRootType>>();
        }
        return this.rest;
    }

}
