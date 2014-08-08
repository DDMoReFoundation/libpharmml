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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * VectorCell class for specifying a single value within a type-B {@link Vector}.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VectorCellType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="VectorIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixVectorIndexType"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *           &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class VectorCell extends PharmMLRootType implements ScalarContainer {
	
	// Mapped attributes
	
	@XmlElement(name = "VectorIndex")
	protected MatrixVectorIndex vectorIndex;
	
	@XmlElementRef(name = "VectorCellValue", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class)
	protected VectorCellValue value;
		
	// -----------------
	
	/**
	 * Empty constructor
	 */
	public VectorCell(){}
	
	/**
	 * Constructs a vector cell at the specified index and with the given value.
	 * @param index Index of the cell within the parent vector.
	 * @param value Value of the cell as a symbol reference.
	 */
	public VectorCell(MatrixVectorIndex index, SymbolRefType value){
		this.vectorIndex = index;
		this.value = value;
	}
	
	/**
	 * Constructs a vector cell at the specified index and with the given value.
	 * @param index Index of the cell within the parent vector.
	 * @param value Value of the cell as a scalar.
	 */
	public VectorCell(MatrixVectorIndex index, Scalar value){
		this.vectorIndex = index;
		this.value = value;
	}
	
	
	public void setVectorIndex(MatrixVectorIndex index){
		vectorIndex = index;
	}
	
	public MatrixVectorIndex getVectorIndex(){
		return vectorIndex;
	}
	
	/**
	 * Gets the value of the cell.
	 * Possible types are {@link Scalar} and {@link SymbolRefType}.
	 * @return The value of the cell.
	 */
	public VectorCellValue getValue(){
		return value;
	}
	
	public void setValue(SymbolRefType value){
		this.value = value;
	}
	
	public void setValue(Scalar value){
		this.value = value;
	}
	
	public MatrixVectorIndex createIndex(SymbolRefType index){
		this.vectorIndex = new MatrixVectorIndex(index);
		return this.vectorIndex;
	}
	
	public MatrixVectorIndex createIndex(int index){
		this.vectorIndex = new MatrixVectorIndex(index);
		return this.vectorIndex;
	}

	public SymbolRefType createSymbolRef(String symbId){
		SymbolRefType symb = new SymbolRefType();
		symb.setSymbIdRef(symbId);
		setValue(symb);
		return symb;
	}
	
	public SymbolRefType createSymbolRef(String symbId, String blkId){
		SymbolRefType symb = createSymbolRef(symbId);
		symb.setBlkIdRef(blkId);
		return symb;
	}
	
	@Override
	public IntValue createIntValue(int value) {
		IntValue wValue = new IntValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public RealValue createRealValue(double value) {
		RealValue wValue = new RealValue(value);
		setValue(wValue);
		return wValue;
	}
	
	
	@Override
	public StringValue createStringValue(String value) {
		StringValue wValue = new StringValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public IdValue createIdValue(String value) {
		IdValue wValue = new IdValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public BooleanType createBooleanValue(boolean value) {
		BooleanType wValue;
		if(value){
			wValue = new TrueBooleanType();
		} else {
			wValue = new FalseBooleanType();
		}
		setValue(wValue);
		return wValue;
	}
	

}
