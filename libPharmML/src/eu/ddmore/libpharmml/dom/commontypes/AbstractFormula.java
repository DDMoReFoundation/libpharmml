/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Abstract class for regrouping common properties in formulas.
 * @author F. Yvon
 */
@XmlTransient
public abstract class AbstractFormula extends PharmMLRootType {
	
//	@XmlElement(name = "SymbRef", required = true)
//    protected SymbolRefType symbRef;
	
	@XmlElements({ 
		@XmlElement(name = "SymbRef", type = SymbolRef.class),
		@XmlElement(name = "Equation", namespace = "http://www.pharmml.org/2013/03/Maths" ,type = Equation.class)
		})
	public OperationVariable variable;
	
	@XmlElement(name = "LowLimit", required = true)
    protected LowUpLimit lowLimit;
    @XmlElement(name = "UpLimit", required = true)
    protected LowUpLimit upLimit;
    
    /**
     * A variable reference.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     * @deprecated
     * 
     */
    @Deprecated
    public SymbolRef getSymbRef() {
        if(variable != null && variable instanceof SymbolRef){
        	return (SymbolRef) variable;
        } else {
        	return null;
        }
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    @Deprecated
    public void setSymbRef(SymbolRef value) {
        this.variable = value;
    }
    
    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef },
     *     {@link Equation }
     * 
     */
    public OperationVariable getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef },
     *     {@link Equation}
     *     
     */
    public void setVariable(OperationVariable value) {
        this.variable = value;
    }
    
    /**
     * Gets the value of the lowLimit property.
     * 
     * @return
     *     possible object is
     *     {@link LowUpLimit }
     *     
     */
    public LowUpLimit getLowLimit() {
        return lowLimit;
    }

    /**
     * Sets the value of the lowLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowUpLimit }
     *     
     */
    public void setLowLimit(LowUpLimit value) {
        this.lowLimit = value;
    }

    /**
     * Gets the value of the upLimit property.
     * 
     * @return
     *     possible object is
     *     {@link LowUpLimit }
     *     
     */
    public LowUpLimit getUpLimit() {
        return upLimit;
    }

    /**
     * Sets the value of the upLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowUpLimit }
     *     
     */
    public void setUpLimit(LowUpLimit value) {
        this.upLimit = value;
    }

    public LowUpLimit createLowLimit(int limit){
    	LowUpLimit lowLimit = new LowUpLimit(limit);
    	this.setLowLimit(lowLimit);
    	return lowLimit;
    }
    public LowUpLimit createLowLimit(SymbolRef limit){
    	LowUpLimit lowLimit = new LowUpLimit(limit);
    	this.setLowLimit(lowLimit);
    	return lowLimit;
    }
    
    public LowUpLimit createUpLimit(int limit){
    	LowUpLimit upLimit = new LowUpLimit(limit);
    	this.setUpLimit(upLimit);
    	return upLimit;
    }
    public LowUpLimit createUpLimit(SymbolRef limit){
    	LowUpLimit upLimit = new LowUpLimit(limit);
    	this.setUpLimit(upLimit);
    	return upLimit;
    }

}
