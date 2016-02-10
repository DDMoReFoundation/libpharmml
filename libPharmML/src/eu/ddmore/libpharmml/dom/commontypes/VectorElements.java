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
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VectorElements", propOrder = {
	    "jaxb_elements"
	})
@XmlJavaTypeAdapter(VectorElements.Adapter.class)
public class VectorElements extends PharmMLRootType implements ScalarContainer, MathExpression {
		
	//-------
	@XmlElementRefs({
        @XmlElementRef(name = "Sequence", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH, type = Equation.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    })
	protected List<JAXBElement<? extends VectorValue>> jaxb_elements;
	@XmlTransient
	protected List<VectorValue> elements;
	//-------
	
	/**
	 * Empty constructor
	 */
	public VectorElements(){}
	
	
	public VectorElements(VectorValue []values){
		elements = new ArrayList<VectorValue>();
		for(VectorValue value : values){
			elements.add(value);
		}
	}
	
	public List<VectorValue> getListOfElements(){
		if(elements == null){
			elements = new ArrayList<VectorValue>();
		}
		return elements;
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
				if(v.elements != null){
					for(VectorValue el : v.elements){
						v.jaxb_elements.add(MasterObjectFactory.createVectorValue(el));
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
				.addIfNotNull(elements);
	}


	@Override
	public String toMathExpression() {
		// TODO Auto-generated method stub
		return null;
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
