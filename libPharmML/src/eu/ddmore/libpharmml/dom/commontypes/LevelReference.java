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
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 A reference to a variability level.
 *             
 * 
 * <p>Java class for LevelReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LevelReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *         &lt;element name="RandomEffectMapping" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}RandomEffectMappingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LevelReferenceType", propOrder = {
    "symbRef",
    "randomEffectMapping"
})
public class LevelReference
    extends PharmMLRootType
{

    @XmlElement(name = "SymbRef", required = true)
    protected SymbolRef symbRef;
    
    // PharmML 0.7
    @XmlElement(name = "RandomEffectMapping")
    protected RandomEffectMapping randomEffectMapping;

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
    
    /**
     * Gets the value of the randomEffectMapping property.
     * 
     * @return
     *     possible object is
     *     {@link RandomEffectMapping }
     *     
     * @since PharmML 0.7
     */
    public RandomEffectMapping getRandomEffectMapping() {
        return randomEffectMapping;
    }

    /**
     * Sets the value of the randomEffectMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link RandomEffectMapping }
     *   
     * @since PharmML 0.7
     */
    public void setRandomEffectMapping(RandomEffectMapping value) {
        this.randomEffectMapping = value;
    }
    
    /**
     * Creates a new empty {@link SymbolRef} symbRef element, adds it to the current object and returns it.
     * @return The created {@link SymbolRef} object.
     */
    public SymbolRef createSymbolRef(){
            SymbolRef el = new SymbolRef();
            this.symbRef = el;
            return el;
    }
    
	public SymbolRef createSymbolRef(String symbId){
		SymbolRef symb = new SymbolRef();
		symb.setSymbIdRef(symbId);
		this.symbRef = symb;
		return symb;
	}
	
	public SymbolRef createSymbolRef(String symbId, String blkId){
		SymbolRef symb = new SymbolRef();
		symb.setSymbIdRef(symbId);
		symb.setBlkIdRef(blkId);
		this.symbRef = symb;
		return symb;
	}

    /**
     * Creates a new empty {@link RandomEffectMapping} randomEffectMapping element, adds it to the current object and returns it.
     * @return The created {@link RandomEffectMapping} object.
     */
    public RandomEffectMapping createRandomEffectMapping(){
            RandomEffectMapping el = new RandomEffectMapping();
            this.randomEffectMapping = el;
            return el;
    }
    
    public RandomEffectMapping createRandomEffectMapping(SymbolRef symbolRef){
            RandomEffectMapping el = new RandomEffectMapping();
            el.setSymbRef(symbolRef);
            this.randomEffectMapping = el;
            return el;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(symbRef)
				.addIfNotNull(randomEffectMapping);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
