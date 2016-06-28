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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * <p>Java class for MatrixVectorIndexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixVectorIndexType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Equation"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Int"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixVectorIndex", propOrder = {
		"mapped_assign",
	    "mapped_equation",
	    "intValue",
	    "symbRef"
	})
@HasElementRenamed(
		mappedFields = { 
				@RenamedElement(field = "mapped_equation"),
				@RenamedElement(field = "mapped_assign", since = PharmMLVersion.V0_7_3)
				},
		transientField = "assign")
public class MatrixVectorIndex extends PharmMLRootType {
	
	@XmlElement(name = "Equation", namespace = NS_DEFAULT_MATH)
	@XmlJavaTypeAdapter(RhsEquationAdapter.class)
    protected Rhs mapped_equation;
    @XmlElement(name = "Assign") // PharmML 0.7.1
    protected Rhs mapped_assign;
    @XmlTransient
    protected Rhs assign;
	
	@XmlElement(name = "Int")
	protected IntValue intValue;
	
	@XmlElement(name = "SymbRef")
	protected SymbolRef symbRef;
	
	public MatrixVectorIndex(){
		
	}
	
	public MatrixVectorIndex(int value){
		this(new IntValue(value));
	}
	
	public MatrixVectorIndex(IntValue value){
		intValue = value;
	}
	
	public MatrixVectorIndex(SymbolRef symbolRef){
		symbRef = symbolRef;
	}
	
//	public MatrixVectorIndex(Equation equation){
//		this.equation = equation;
//	}
	
	/**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     * @since PharmML 0.7.1
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     * @since PharmML 0.7.1
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }
	
//	/**
//     * A mathematical expression.
//     * 
//     * @return
//     *     possible object is
//     *     {@link Equation }
//     *     
//     */
//    public Equation getEquation() {
//        return equation;
//    }
//
//    /**
//     * Sets the value of the equation property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link Equation }
//     *     
//     */
//    public void setEquation(Equation value) {
//        this.equation = value;
//    }
	
	public IntValue getIntValue(){
		return intValue;
	}
	public void setIntValue(IntValue value){
		this.intValue = value;
	}
	
	public SymbolRef getSymbolRef(){
		return symbRef;
	}
	public void setSymbolRef(SymbolRef symbRef){
		this.symbRef = symbRef;
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(assign)
				.addIfNotNull(intValue)
				.addIfNotNull(symbRef);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
