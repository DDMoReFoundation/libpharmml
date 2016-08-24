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
package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * FIM type to be computed type type.
 * 
 * <p>Java class for TypeFIMType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeFIMType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="type" use="required" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}TypeFIMTypeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeFIMType")
public class TypeFIM
    extends PharmMLRootType
{

    @XmlAttribute(name = "type", required = true)
    protected TypeFIMType type;
    
    public TypeFIM(){}
    
    public TypeFIM(TypeFIMType type){
    	this.type = type;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TypeFIMType }
     *     
     */
    public TypeFIMType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeFIMType }
     *     
     */
    public void setType(TypeFIMType value) {
        this.type = value;
    }
    
    @Override
    public String toString() {
    	return super.toString()+" type:"+String.valueOf(type);
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
