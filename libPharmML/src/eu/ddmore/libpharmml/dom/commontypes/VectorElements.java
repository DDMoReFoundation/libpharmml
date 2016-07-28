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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.util.ChainedList;

/**
 * 
 * This type specifies a vector element - without indexes.
 *             
 * 
 * <p>Java class for VectorElementsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VectorElementsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sequence"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Assign"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@SuppressWarnings("deprecation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VectorElements", propOrder = {
	    "jaxb_elements"
	})
@XmlJavaTypeAdapter(VectorElements.Adapter.class)
public class VectorElements extends PharmMLRootType implements ScalarContainer, MathExpression {
		
	// listOfElements is a transient attribute. Its elements are converted to JAXBElements into the jaxb_elements
	// list which is mapped to XML, during the marshal process. See the VectorElements.Adapter class.
	//-------
	@XmlElementRefs({
        @XmlElementRef(name = "Sequence", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Equation", namespace = NS_DEFAULT_MATH, type = Equation.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Assign", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    })
	protected List<JAXBElement<? extends VectorValue>> jaxb_elements;
	@XmlTransient
	protected List<VectorValue> listOfElements;
	//-------
	
	/**
	 * Empty constructor
	 */
	public VectorElements(){}
	
	
	public VectorElements(VectorValue []values){
		listOfElements = new ArrayList<VectorValue>();
		for(VectorValue value : values){
			listOfElements.add(value);
		}
	}
	
	public List<VectorValue> getListOfElements(){
		if(listOfElements == null){
			listOfElements = new ArrayList<VectorValue>();
		}
		return listOfElements;
	}

	@Override
	public IntValue createIntValue(int value) {
		IntValue wValue = new IntValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public RealValue createRealValue(double value) {
		RealValue wValue = new RealValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public StringValue createStringValue(String value) {
		StringValue wValue = new StringValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public IdValue createIdValue(String value) {
		IdValue wValue = new IdValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public BooleanValue createBooleanValue(boolean value) {
		BooleanValue wValue;
		if(value){
			wValue = new TrueBoolean();
		} else {
			wValue = new FalseBoolean();
		}
		getListOfElements().add(wValue);
		return wValue;
	}
	
	@Override
	public MissingValue createMissingValue(MissingValueSymbol symbol) {
		MissingValue mValue = new MissingValue(symbol);
		getListOfElements().add(mValue);
		return mValue;
	}
	
	public SymbolRef createSymbolRef(String symbId){
		SymbolRef symbRef = new SymbolRef();
		symbRef.setId(symbId);
		getListOfElements().add(symbRef);
		return symbRef;
	}
	
	public SymbolRef createSymbolRef(String symbId, String blkId){
		SymbolRef symbRef = createSymbolRef(symbId);
		symbRef.setBlkIdRef(blkId);
		return symbRef;
	}
	
	public Sequence createSequence(){
		Sequence seq = new Sequence();
		getListOfElements().add(seq);
		return seq;
	}
	
	public Rhs createAssign(){
		Rhs rhs = new Rhs();
		getListOfElements().add(rhs);
		return rhs;
	}
	
	/**
	 * Adapter for marshaling a VectorElements object. This adapter is used for converting {@link VectorValue} objects
	 * to {@link JAXBElement} objects.
	 */
	protected static class Adapter extends XmlAdapter<VectorElements, VectorElements>{

		@Override
		public VectorElements unmarshal(VectorElements v) throws Exception {
			if(v.jaxb_elements != null){
				for(JAXBElement<? extends VectorValue> el : v.jaxb_elements){
					v.getListOfElements().add(el.getValue());
				}
			}
			return v;
		}

		@Override
		public VectorElements marshal(VectorElements v) throws Exception {
			if(v != null){
				v.jaxb_elements = new ArrayList<JAXBElement<? extends VectorValue>>();
				if(v.listOfElements != null){
					for(VectorValue el : v.listOfElements){
						if(el != null){
							v.jaxb_elements.add(el.toJAXBElementVectorValue());
						}
					}
				}
				return v;
			} else {
				return null;
			}
		}
		
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(listOfElements);
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
