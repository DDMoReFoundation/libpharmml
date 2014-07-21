package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = {
		"startIndex",
		"segmentLength"
})
public class VectorSegment extends VectorOfElements {
	
	@XmlElement(name = "StartIndex")
	protected MatrixVectorIndex startIndex;
	
	@XmlElement(name = "SegmentLength")
	protected MatrixVectorIndex segmentLength;
	
	
	public VectorSegment(){
		super();
	}
	
	public VectorSegment(MatrixVectorIndex startIndex, MatrixVectorIndex segmentLength, double defaultValue){
		this.defaultValue = defaultValue;
		this.startIndex = startIndex;
		this.segmentLength = segmentLength;
	}
	
	public VectorSegment(MatrixVectorIndex startIndex, MatrixVectorIndex segmentLength, double defaultValue, VectorValue values[]){
		super(values);
		this.defaultValue = defaultValue;
		this.startIndex = startIndex;
		this.segmentLength = segmentLength;
	}
	
	public MatrixVectorIndex getStartIndex(){
		return startIndex;
	}
	
	public MatrixVectorIndex getSegmentLength(){
		return segmentLength;
	}
	
	public void setStartIndex(MatrixVectorIndex startIndex){
		this.startIndex = startIndex;
	}
	
	public void setSegmentLength(MatrixVectorIndex segmentLength){
		this.segmentLength = segmentLength;
	}

}
