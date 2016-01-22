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

import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.dom.commontypes.Vector;

/**
 * 
 * A segment of a vector with numerical values or variables and facultative index.
 * 
 * 
 * <p>Java class for VectorSegmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VectorSegmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="StartIndex" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixVectorIndexType"/>
 *         &lt;element name="SegmentLength" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixVectorIndexType"/>
 *         &lt;element name="VectorElements" type="{http://www.pharmml.org/2013/03/CommonTypes}VectorElementsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @see Vector
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VectorSegmentType", propOrder = {
    "startIndex",
    "segmentStartIndex",
    "segmentLength",
    "vectorElements"
})
@HasElementRenamed(mappedFields = {
		@RenamedElement(field = "segmentStartIndex", since = PharmMLVersion.V0_4_1),
		@RenamedElement(field = "startIndex")
		}, transientField = "index")
public class VectorSegment extends AbstractVector {
	
	@XmlElement(name = "StartIndex")
	protected MatrixVectorIndex startIndex;
	@XmlElement(name = "SegmentStartIndex")
	protected MatrixVectorIndex segmentStartIndex;
	@XmlTransient
	protected MatrixVectorIndex index;
	
	@XmlElement(name = "SegmentLength")
	protected MatrixVectorIndex segmentLength;
	
	
	/**
	 * Empty constructor
	 */
	public VectorSegment(){
	}
	
	public VectorSegment(MatrixVectorIndex startIndex, MatrixVectorIndex segmentLength, double defaultValue){
		this.defaultValue = defaultValue;
		this.index = startIndex;
		this.segmentLength = segmentLength;
	}
	
	public VectorSegment(MatrixVectorIndex startIndex, MatrixVectorIndex segmentLength, double defaultValue, VectorValue values[]){
		this(startIndex,segmentLength,defaultValue);
		createVectorElements(values);
	}
	
	public MatrixVectorIndex getStartIndex(){
		return index;
	}
	
	public MatrixVectorIndex getSegmentLength(){
		return segmentLength;
	}
	
	public void setStartIndex(MatrixVectorIndex startIndex){
		this.index = startIndex;
	}
	
	public void setSegmentLength(MatrixVectorIndex segmentLength){
		this.segmentLength = segmentLength;
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(index)
				.addIfNotNull(segmentLength)
				.addIfNotNull(vectorElements);
	}

}
