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
 * Type defining the stdev or variance to be referenced
 *                 in the VariabilityReference element.
 * 
 * <p>Java class for RandomEffectMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RandomEffectMappingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RandomEffectMappingType", propOrder = {
    "symbRef"
})
public class RandomEffectMapping
    extends PharmMLRootType
{

    @XmlElement(name = "SymbRef", required = true)
    protected SymbolRef symbRef;
    
    /**
     * Empty constructor.
     */
    public RandomEffectMapping(){}
    
    /**
     * Constructs a {@link RandomEffectMapping} with the given reference.
     * @param symbolRef
     */
    public RandomEffectMapping(SymbolRef symbolRef){
    	this.symbRef = symbolRef;
    }

    /**
     * Gets the value of the symbRef property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }
    
    public SymbolRef createSymbolRef(){
    	this.symbRef = new SymbolRef();
    	return this.symbRef;
    }
    
    public SymbolRef createSymbolRef(String symbolId){
    	return createSymbolRef(symbolId,null);
    }
    
    public SymbolRef createSymbolRef(String symbolId, String blkId){
    	SymbolRef symbRef = new SymbolRef();
    	symbRef.setSymbIdRef(symbolId);
    	symbRef.setBlkIdRef(blkId);
    	this.symbRef = symbRef;
    	return symbRef;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren()).addIfNotNull(symbRef);
    }

}
