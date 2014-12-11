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

import javax.xml.bind.annotation.XmlTransient;

/**
 * The definition of a non-uniform sequence of numbers. The vector is an ordered list of
 *             values. The values of the sequence element are inserted into the vector at the point of definition.
 *             For example, take the vector (the [] brackets denote a sequence): 0, 4, [0:1:3], 33. Inserting the 
 *             sequence gives us the vector of values: 0, 4, 0, 1, 2, 3, 33. 
 *             
 * <p>Vectors can have 2 different forms. A first one where all the elements of the vector are specified (Type A),
 * and an other one where the elements that are not explicitly specified have a default value (Type B).
 * The possible values in a vector are {@link Scalar}, {@link SymbolRefType} and {@link SequenceType}.
 * 
 * <p><h3>Type A (complete):</h3>
 * This is the most simple representation of a vector.
 * All the elements within the vector have to be explicitly specified. These elements are wrapped
 * into a {@link VectorElements} object within the vector. In this case, the {@link VectorElements}
 * object is the only child element authorized in the {@link Vector}.
 * <p>For example, if one wants to encode a vector with the following values:
 * <p>{0,0,1,5,6,4,2,0}
 * <p>then one can proceed as follows:
 * <p><code>
 * Integer[] values = {0,0,1,5,6,4,2,0};<br>
 * Vector vector = new Vector();<br>
 * VectorElements vectorElements = vector.createVectorElements();<br>
 * for(Integer value : values){<br>
 * &nbsp;&nbsp;&nbsp;vectorElements.createIntValue(value);<br>
 * }<br>
 * vector.setLength(values.length);<br>
 * </code>
 * <p>It is mandatory to specify manually the length of the vector. This is because the length
 * of the vector cannot be found automatically when a {@link SequenceType} or a {@link SymbolRefType}
 * object is in the list, as it can refer to multiple values.
 * 
 * <p><h3>Type B (sparse):</h3>
 * It is possible to specify only a few elements within the vector. The value of the other ones equals
 * the default value of the vector. In this form, the "default" attribute is mandatory.   
 * To specify some values, one can include {@link VectorCell} elements or {@link VectorSegment} elements. 
 * 
 * <p>Example:
 * <p>Vector to encode: {0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,0}
 * <p><code>
 * Vector vector = new Vector();<br>
 * vector.setDefaultValue(0);<br>
 * vector.setLength(16);<br>
 * vector.createVectorCell(4,1); // index, value<br>
 * vector.createVectorSegment(8,5,1); // startIndex, length, defaultValue<br>
 * </code>
 * 
 * <p><h3>Schema:</h3>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VectorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="VectorElements" type="{http://www.pharmml.org/2013/03/CommonTypes}VectorElementsType"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="VectorCell" type="{http://www.pharmml.org/2013/03/CommonTypes}VectorCellType" maxOccurs="unbounded"/>
 *           &lt;element name="VectorSegment" type="{http://www.pharmml.org/2013/03/CommonTypes}VectorSegmentType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/choice>
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlTransient
public class Vector extends VectorType {
	
	/**
	 * Creates an empty vector.
	 */
	public Vector(){
		super(0);
	}
	
	/**
	 * Constructs a type-A vector from provided values.
	 * @param values An array of {@link VectorValue} elements.
	 * @param length Length of the vector.
	 */
	public Vector(VectorValue []values, int length){
		this();
		this.vectorElements = new VectorElements(values);
		this.length = length;
	}
	
	/**
	 * Constructs a type-B vector with a default value. This type of vector is meant to be filled
	 * by {@link VectorCell} elements or {@link VectorSegment} elements.
	 * @param defaultValue The value of the vector cells that are not explicitly specified.
	 * @param length Length of the vector.
	 */
	public Vector(double defaultValue,int length){
		this();
		this.defaultValue = defaultValue;
	}
	
	public boolean addVectorCell(VectorCell cell){
		return getListOfVectorCellAndSegment().add(cell);
	}
	
	public boolean addVectorSegment(VectorSegment segment) {
		return getListOfVectorCellAndSegment().add(segment);
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index without any value.
	 * @param index Index of the cell within the vector.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index){
		VectorCell cell = new VectorCell();
		cell.setVectorIndex(new MatrixVectorIndex(index));
		addVectorCell(cell);
		return cell;
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a symbol as value.
	 * @param index Index of the cell within the vector.
	 * @param value Symbol value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, SymbolRefType value){
		VectorCell cell = createVectorCell(index);
		cell.setValue(value);
		return cell;
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a scalar as value.
	 * @param index Index of the cell within the vector.
	 * @param value {@link Scalar} value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, Scalar value){
		VectorCell cell = createVectorCell(index);
		cell.setValue(value);
		return cell;
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a real value.
	 * A {@link RealValue} object is constructed from the provided primitive variable.
	 * @param index Index of the cell within the vector.
	 * @param value Primitive value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, double value){
		return createVectorCell(index, new RealValue(value));
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a integer value.
	 * A {@link IntValue} object is constructed from the provided primitive variable.
	 * @param index Index of the cell within the vector.
	 * @param value Primitive value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, int value){
		return createVectorCell(index, new IntValue(value));
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a boolean value.
	 * A {@link BooleanType} object is constructed from the provided primitive variable.
	 * @param index Index of the cell within the vector.
	 * @param value Primitive value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, boolean value){
		return createVectorCell(index, BooleanType.fromBoolean(value));
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a string value.
	 * A {@link StringValue} object is constructed from the provided primitive variable.
	 * @param index Index of the cell within the vector.
	 * @param value Primitive value of the cell.
	 * @return The created {@link VectorCell} instance.
	 */
	public VectorCell createVectorCell(int index, String value){
		return createVectorCell(index, new StringValue(value));
	}
	
	/**
	 * Creates a new vector cell into the vector at the specified index with a value.
	 * This is the most abstracted method for creating a cell.
	 * @param index The index of the cell as {@link MatrixVectorIndex}
	 * @param value The value of the cell which can be {@link Scalar} or {@link SymbolRefType}
	 * @return The created cell.
	 */
	public VectorCell createVectorCell(MatrixVectorIndex index, VectorCellValue value){
		VectorCell cell = new VectorCell();
		if(value instanceof Scalar){
			cell.setValue((Scalar) value);
		} else if(value instanceof SymbolRefType){
			cell.setValue((SymbolRefType) value);
		}
		cell.setVectorIndex(index);
		addVectorCell(cell);
		return cell;
	}
	
	/**
	 * Creates an empty vector segment into the vector and returns it.
	 * @return The created {@link VectorSegment} object.
	 */
	public VectorSegment createVectorSegment(){
		VectorSegment segment = new VectorSegment();
		addVectorSegment(segment);
		return segment;
	}
	
	/**
	 * Creates a vector segment into the vector and returns it. 
	 * @param startIndex Start index of the segment within the parent vector.
	 * @param segmentLength Length of the segment.
	 * @param defaultValue Value of the vector elements that are explictly specified.
	 * @param values Values of the segment.
	 * @return The created {@link VectorSegment} object.
	 */
	public VectorSegment createVectorSegment(int startIndex, int segmentLength, double defaultValue, VectorValue values[]){
		VectorSegment segment = new VectorSegment(
				new MatrixVectorIndex(startIndex), 
				new MatrixVectorIndex(segmentLength), 
				defaultValue, 
				values);
		addVectorSegment(segment);
		return segment;
	}
	
	/**
	 * Creates a vector segment into the vector and returns it. 
	 * @param startIndex Start index of the segment within the parent vector.
	 * @param segmentLength Length of the segment.
	 * @param defaultValue Value of the vector elements that are explictly specified.
	 * @return The created {@link VectorSegment} object.
	 */
	public VectorSegment createVectorSegment(int startIndex, int segmentLength, double defaultValue){
		VectorSegment segment = new VectorSegment(
				new MatrixVectorIndex(startIndex), 
				new MatrixVectorIndex(segmentLength), 
				defaultValue);
		addVectorSegment(segment);
		return segment;
	}
}
