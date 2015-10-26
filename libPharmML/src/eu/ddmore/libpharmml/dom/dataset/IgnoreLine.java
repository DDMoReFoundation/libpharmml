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
package eu.ddmore.libpharmml.dom.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;


/**
 * <p>Java class for IgnoreLineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IgnoreLineType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.6/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="symbol" use="required" type="{http://www.pharmml.org/pharmml/0.6/Dataset}IgnoreSymbolType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.6 extension.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IgnoreLineType")
public class IgnoreLine
    extends PharmMLRootType
{

    @XmlAttribute(name = "symbol", required = true)
    protected String symbol;
    
    public IgnoreLine(){}
    
    public IgnoreLine(String symbol){
    	this.symbol = symbol;
    }

    /**
     * The ignore character symbol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * The ignore character symbol.
     * 
     * @param value
     *     allowed object is
     *     {@link String } with the following pattern: <code>"[^\s]{1,3}"</code>
     *     
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }
    
    @Override
    public String toString() {
    	return super.toString()+" symbol:"+symbol;
    }

}
