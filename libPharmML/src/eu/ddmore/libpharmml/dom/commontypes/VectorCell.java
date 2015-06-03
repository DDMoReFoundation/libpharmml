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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;

/**
 * 
 * VectorCell class for specifying a single value within a type-B {@link Vector}.
 * 
 * <b>Important</b>:
 * The index of the cell, accessible through {@link #getIndex()}
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VectorCellType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="CellIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixVectorIndexType"/>
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
@XmlType(propOrder = {
	    "cellIndex",
	    "vectorIndex",
	    "value"
	})
@HasElementRenamed(mappedFields = { 
		@RenamedElement(field = "cellIndex", since = PharmMLVersion.V0_4_1),
		@RenamedElement(field = "vectorIndex")
}, transientField = "index")
public class VectorCell extends PharmMLRootType implements ScalarContainer {
	
	// Mapped attributes
	
	@XmlElement(name = "CellIndex", required = true)
	protected MatrixVectorIndex cellIndex;
	@XmlElement(name = "VectorIndex")
	// not used since PharmML 0.4.1. Replaced by cellIndex.
	protected MatrixVectorIndex vectorIndex;
	
	@XmlTransient
	// Attribute used for index in software side. Will be copied to either cellIndex or
	// vectorIndex according to the document written version. See beforeMarshal and afterUnmarshal
	// in this class.
	protected MatrixVectorIndex index;
	
	@XmlElementRef(name = "VectorCellValue", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class)
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
	public VectorCell(MatrixVectorIndex index, SymbolRef value){
		this.index = index;
		this.value = value;
	}
	
	/**
	 * Constructs a vector cell at the specified index and with the given value.
	 * @param index Index of the cell within the parent vector.
	 * @param value Value of the cell as a scalar.
	 */
	public VectorCell(MatrixVectorIndex index, Scalar value){
		this.index = index;
		this.value = value;
	}
	
	/**
	 * Set the value of the index of the cell within the parent vector.
	 * @param index A {@link MatrixVectorIndex} object.
	 */
	public void setVectorIndex(MatrixVectorIndex index){
		this.index = index;
	}
	
	/**
	 * @deprecated Use {@link #getIndex()} instead.
	 * 
	 * Gets the index of the cell within the vector.
	 * @return The index as a {@link MatrixVectorIndex} object.
	 */
	@Deprecated
	public MatrixVectorIndex getVectorIndex(){
		return getIndex();
	}
	
	/**
	 * Gets the index of the cell within the vector.
	 * @return The index as a {@link MatrixVectorIndex} object.
	 */
	public MatrixVectorIndex getIndex(){
		return this.index;
	}
	
	/**
	 * Gets the value of the cell.
	 * Possible types are {@link Scalar} and {@link SymbolRef}.
	 * @return The value of the cell.
	 */
	public VectorCellValue getValue(){
		return value;
	}
	
	public void setValue(SymbolRef value){
		this.value = value;
	}
	
	public void setValue(Scalar value){
		this.value = value;
	}
	
	public MatrixVectorIndex createIndex(SymbolRef index){
		this.index = new MatrixVectorIndex(index);
		return this.index;
	}
	
	public MatrixVectorIndex createIndex(int index){
		this.index = new MatrixVectorIndex(index);
		return this.index;
	}

	public SymbolRef createSymbolRef(String symbId){
		SymbolRef symb = new SymbolRef();
		symb.setSymbIdRef(symbId);
		setValue(symb);
		return symb;
	}
	
	public SymbolRef createSymbolRef(String symbId, String blkId){
		SymbolRef symb = createSymbolRef(symbId);
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
	public BooleanValue createBooleanValue(boolean value) {
		BooleanValue wValue;
		if(value){
			wValue = new TrueBoolean();
		} else {
			wValue = new FalseBoolean();
		}
		setValue(wValue);
		return wValue;
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(index)
				.addIfNotNull(value);
	}

}
