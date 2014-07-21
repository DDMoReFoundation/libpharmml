package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixVectorIndex", propOrder = {
	    "intValue",
	    "symbRef"
	})
public class MatrixVectorIndex extends PharmMLRootType {
	
	@XmlElement(name = "Int")
	protected IntValueType intValue;
	
	@XmlElement(name = "SymbRef")
	protected SymbolRefType symbRef;
	
	public MatrixVectorIndex(){
		
	}
	
	public MatrixVectorIndex(int value){
		this(new IntValue(value));
	}
	
	public MatrixVectorIndex(IntValueType value){
		intValue = value;
	}
	
	public MatrixVectorIndex(SymbolRefType symbolRef){
		symbRef = symbolRef;
	}
	
	public IntValueType getIntValue(){
		return intValue;
	}
	public void setIntValue(IntValueType value){
		this.intValue = value;
	}
	
	public SymbolRefType getSymbolRef(){
		return symbRef;
	}
	public void setSymbolRef(SymbolRefType symbRef){
		this.symbRef = symbRef;
	}

}
