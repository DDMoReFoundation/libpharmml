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
package eu.ddmore.libpharmml.dom.maths;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 A N-ary operator describing a numerical operation. Takes N operands.
 *             
 * 
 * <p>Java class for NaryopType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaryopType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sequence"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Vector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *       &lt;/choice>
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="plus"/>
 *             &lt;enumeration value="times"/>
 *             &lt;enumeration value="min"/>
 *             &lt;enumeration value="max"/>
 *             &lt;enumeration value="gcd"/>
 *             &lt;enumeration value="lcm"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaryopType", propOrder = {
    "content"
})
public class Naryop
    extends PharmMLRootType implements ExpressionValue, Operand
{

    @XmlElements({
        @XmlElement(name = "MatrixSelector", namespace = NS_DEFAULT_CT, type = MatrixSelector.class),
        @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT, type = SymbolRef.class),
        @XmlElement(name = "Sequence", namespace = NS_DEFAULT_CT, type = Sequence.class),
        @XmlElement(name = "Vector", namespace = NS_DEFAULT_CT, type = Vector.class),
        @XmlElement(name = "VectorSelector", namespace = NS_DEFAULT_CT, type = VectorSelector.class)
    })
    protected List<PharmMLRootType> content;
    @XmlAttribute(name = "op", required = true)
    protected Naryoperator op;
    
    /**
     * Empty constructor.
     */
    public Naryop(){}
    
    /**
     * Constructs a new Naryop object with the given {@link Naryoperator}.
     * @param operator {@link Naryoperator} of this naryoperation.
     */
    public Naryop(Naryoperator operator){
    	op = operator;
    }

    /**
     * Gets the value of the matrixSelectorOrSymbRefOrSequence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matrixSelectorOrSymbRefOrSequence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatrixSelector }
     * {@link SymbolRef }
     * {@link Sequence }
     * {@link Vector }
     * {@link VectorSelector }
     * 
     * 
     */
    public List<PharmMLRootType> getContent() {
        if (content == null) {
            content = new ArrayList<PharmMLRootType>();
        }
        return this.content;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link Naryoperator }
     *     
     */
    public Naryoperator getOp() {
        return op;
    }

    /**
     * Sets the value of the op property.
     * 
     * @param value
     *     allowed object is
     *     {@link Naryoperator }
     *     
     */
    public void setOp(Naryoperator value) {
        this.op = value;
    }
    
    public MatrixSelector createMatrixSelector(){
    	MatrixSelector ms = new MatrixSelector();
    	getContent().add(ms);
    	return ms;
    }
    
    public MatrixSelector createMatrixSelector(SymbolRef symbolRef){
    	MatrixSelector ms = new MatrixSelector(symbolRef);
    	getContent().add(ms);
    	return ms;
    }
    
    public SymbolRef createSymbRef(){
    	SymbolRef sref = new SymbolRef();
    	getContent().add(sref);
    	return sref;
    }
    
    public SymbolRef createSymbRef(String symbId){
    	SymbolRef sref = new SymbolRef(symbId);
    	getContent().add(sref);
    	return sref;
    }
    
    public SymbolRef createSymbRef(String symbId, String blkId){
    	SymbolRef sref = new SymbolRef(symbId,blkId);
    	getContent().add(sref);
    	return sref;
    }
    
    public Sequence createSequence(){
    	Sequence seq = new Sequence();
    	getContent().add(seq);
    	return seq;
    }
    
    public Vector createVector(){
    	Vector vector = new Vector();
    	getContent().add(vector);
    	return vector;
    }
    
    public VectorSelector createVectorSelector(){
    	VectorSelector vs = new VectorSelector();
    	getContent().add(vs);
    	return vs;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(content);
    }

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createNaryop(this);
	}

	@Override
	public String toMathExpression() {
		return new MathExpressionConverterToExpression().convert(this);
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}

	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}

}
