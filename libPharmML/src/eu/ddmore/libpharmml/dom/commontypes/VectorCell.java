package eu.ddmore.libpharmml.dom.commontypes;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class VectorCell extends PharmMLElement implements ScalarContainer {
	
	// Mapped attributes
	
	@XmlElement(name = "VectorIndex")
	protected MatrixVectorIndex vectorIndex;
	
	@XmlElementRef(name = "VectorCellValue", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class)
	protected VectorCellValue value;
		
	// -----------------
	
	public void setVectorIndex(int index){
		setVectorIndex(new IntValue(BigInteger.valueOf(index)));
	}
	
	public void setVectorIndex(IntValueType index){
		vectorIndex = new MatrixVectorIndex(index);
	}
	
	public void setVectorIndex(SymbolRefType index){
		vectorIndex = new MatrixVectorIndex(index);
	}
	
	public MatrixVectorIndex getVectorIndex(){
		return vectorIndex;
	}
	
	public VectorCellValue getValue(){
		return value;
	}
	
	public void setValue(SymbolRefType value){
		this.value = value;
	}
	
	public void setValue(VectorCellValue value){
		this.value = value;
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
	public IntValue createIntValue(int value, String id) {
		IntValue wValue = createIntValue(value);
		wValue.setId(id);
		return wValue;
	}
	
	@Override
	public RealValue createRealValue(double value) {
		RealValue wValue = new RealValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public RealValue createRealValue(double value, String id) {
		RealValue wValue = createRealValue(value);
		wValue.setId(id);
		return wValue;
	}
	
	@Override
	public StringValue createStringValue(String value) {
		StringValue wValue = new StringValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public StringValue createStringValue(String value, String id) {
		StringValue wValue = createStringValue(value);
		wValue.setId(id);
		return wValue;
	}
	
	@Override
	public IdValue createIdValue(String value) {
		IdValue wValue = new IdValue(value);
		setValue(wValue);
		return wValue;
	}
	
	@Override
	public IdValue createIdValue(String value, String id) {
		IdValue wValue = createIdValue(value);
		wValue.setId(id);
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
	
	@Override
	public BooleanType createBooleanValue(boolean value, String id) {
		BooleanType wValue = createBooleanValue(value);
		wValue.setId(id);
		return wValue;
	}

}
