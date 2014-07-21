package eu.ddmore.libpharmml.dom.commontypes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class Vector extends VectorType {
	
	// Transient attributes. They are ordered by the VectorType.Adapter during the marshal process
	@XmlTransient
	List<VectorCell> vectorCells;
	
	@XmlTransient
	List<VectorSegment> vectorSegments;

	/**
	 * Converts a VectorType object to a <b>new</b> Vector object
	 * @param vectorType
	 */
	Vector(VectorType vectorType){
		this();
		this.sequenceOrScalar = vectorType.sequenceOrScalar;
		this.description = vectorType.description;
		this.id = vectorType.id;
		if(vectorType.getVectorCellsAndSegments() != null){
			for(JAXBElement<?> el : vectorType.vectorCellsAndSegments){
				if(el.getValue() instanceof VectorCell){
					this.addVectorCell((VectorCell) el.getValue());
				} else if (el.getValue() instanceof VectorSegment){
					this.addVectorSegment((VectorSegment) el.getValue());
				}
			}
		}
	}

	public Vector(){
		super(Vector.class);
		vectorCells = new ArrayList<VectorCell>();
		vectorSegments = new ArrayList<VectorSegment>();
	}
	
	public Vector(double defaultValue,int length){
		this();
		this.defaultValue = defaultValue;
	}
	
	public List<VectorCell> getListOfVectorCells(){
		return vectorCells;
	}
	
	public List<VectorSegment> getListOfVectorSegments(){
		return vectorSegments;
	}
	
	
	public boolean addVectorCell(VectorCell cell){
		return vectorCells.add(cell);
	}
	
	public boolean addVectorSegment(VectorSegment segment) {
		return vectorSegments.add(segment);
	}
	
	public VectorCell createVectorCell(int index){
		VectorCell cell = new VectorCell();
		cell.setVectorIndex(index);
		addVectorCell(cell);
		return cell;
	}
	
	public VectorCell createVectorCell(int index, SymbolRefType value){
		VectorCell cell = createVectorCell(index);
		cell.setValue(value);
		return cell;
	}
	
	public VectorCell createVectorCell(int index, Scalar value){
		VectorCell cell = createVectorCell(index);
		cell.setValue(value);
		return cell;
	}
	
	public VectorCell createVectorCell(int index, double value){
		VectorCell cell = createVectorCell(index);
		cell.setValue(new RealValue(value));
		return cell;
	}
	
	public VectorSegment createVectorSegment(int startIndex, int segmentLength, double defaultValue, VectorValue values[]){
		VectorSegment segment = new VectorSegment(
				new MatrixVectorIndex(startIndex), 
				new MatrixVectorIndex(segmentLength), 
				defaultValue, 
				values);
		this.vectorSegments.add(segment);
		return segment;
	}
	
	public VectorSegment createVectorSegment(int startIndex, int segmentLength, double defaultValue){
		VectorSegment segment = new VectorSegment(
				new MatrixVectorIndex(startIndex), 
				new MatrixVectorIndex(segmentLength), 
				defaultValue);
		this.vectorSegments.add(segment);
		return segment;
	}
}
