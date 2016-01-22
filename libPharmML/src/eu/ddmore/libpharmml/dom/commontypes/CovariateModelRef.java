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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.validation.SymbolResolver;


/**
 * <p>Java class for CovariateModelRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovariateModelRefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="blkIdRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}BlockIdType" />
 *       &lt;attribute name="oidRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}oidType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovariateModelRefType")
public class CovariateModelRef
    extends PharmMLRootType implements ReferenceContainer
{

    @XmlAttribute(name = "blkIdRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String blkIdRef;
    @XmlAttribute(name = "oidRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oidRef;

    /**
     * Gets the value of the blkIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlkIdRef() {
        return blkIdRef;
    }

    /**
     * Sets the value of the blkIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlkIdRef(String value) {
        this.blkIdRef = value;
    }

    /**
     * Gets the value of the oidRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOidRef() {
        return oidRef;
    }

    /**
     * Sets the value of the oidRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOidRef(String value) {
        this.oidRef = value;
    }

	@Override
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}

}
