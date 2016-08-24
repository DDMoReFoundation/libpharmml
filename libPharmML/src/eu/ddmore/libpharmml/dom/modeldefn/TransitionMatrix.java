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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.TransitionMatrixAttrType;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Transition matrix type
 * 
 * <p>Java class for TransitionMatrixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitionMatrixType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Matrix"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}TransitionMatrixAttrType" />
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransitionMatrixType", propOrder = {
    "matrix"
})
public class TransitionMatrix
    extends PharmMLRootType implements Symbol
{

    @XmlElement(name = "Matrix", namespace = NS_DEFAULT_CT, required = true)
    protected Matrix matrix;
    @XmlAttribute(name = "type")
    protected TransitionMatrixAttrType type;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;

    /**
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link Matrix }
     *     
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matrix }
     *     
     */
    public void setMatrix(Matrix value) {
        this.matrix = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TransitionMatrixAttrType }
     *     
     */
    public TransitionMatrixAttrType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitionMatrixAttrType }
     *     
     */
    public void setType(TransitionMatrixAttrType value) {
        this.type = value;
    }

    /**
     * Gets the value of the symbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
	public String getSymbId() {
        return symbId;
    }

    /**
     * Sets the value of the symbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
	public void setSymbId(String value) {
        this.symbId = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(matrix);
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
