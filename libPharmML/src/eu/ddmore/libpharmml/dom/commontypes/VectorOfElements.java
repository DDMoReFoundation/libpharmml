package eu.ddmore.libpharmml.dom.commontypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class VectorOfElements extends VectorType implements ScalarContainer {
	
	public VectorOfElements(VectorValue elements[]){
		this();
		for(VectorValue value : elements){
			this.getListOfElements().add(value);
		}
	}
	
	public VectorOfElements(Double elements[]){
		this();
		for(Double value : elements){
			this.getListOfElements().add(new RealValue(value));
		}
	}
	
	public VectorOfElements(){
		super(VectorOfElements.class);
	}
	
	VectorOfElements(VectorType vt) {
		this();
		this.id = vt.id;
		this.description = vt.description;
		this.sequenceOrScalar = vt.sequenceOrScalar;
		this.elements = vt.elements;
//		if(vt.vectorElements != null){
////			for(JAXBElement<?> jaxbEl : vt.vectorElements.getChildren()){
////				if(jaxbEl.getValue() instanceof VectorValue){
////					this.getListOfElements().add((VectorValue) jaxbEl.getValue());
////				}
////			}
//			this.elements = vt.vectorElements.getListOfElements();
//		}
	}
	
	public int getLength(){
		return elements.size();
	}
	
	public List<VectorValue> getListOfElements(){
		if(elements == null){
			elements = new ArrayList<VectorValue>();
		}
		return elements;
	}
	
	private boolean add(VectorValue value){
		return getListOfElements().add(value);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString()+" : ");
		sb.append("[");
		if(!getListOfElements().isEmpty()){
			Iterator<VectorValue> it = getListOfElements().iterator();
			sb.append(it.next().asString());
			while(it.hasNext()){
				sb.append(","+it.next().asString());
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public IntValue createIntValue(int value) {
		IntValue wValue = new IntValue(value);
		add(wValue);
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
		add(wValue);
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
		add(wValue);
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
		add(wValue);
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
		add(wValue);
		return wValue;
	}

	@Override
	public BooleanType createBooleanValue(boolean value, String id) {
		BooleanType wValue = createBooleanValue(value);
		wValue.setId(id);
		return wValue;
	}
	
	public SymbolRefType createSymbolRef(String symbId){
		SymbolRefType symbRef = new SymbolRefType();
		symbRef.setSymbIdRef(symbId);
		add(symbRef);
		return symbRef;
	}
	
	public SymbolRefType createSymbolRef(String symbId, String blkId){
		SymbolRefType symbRef = createSymbolRef(symbId);
		symbRef.setBlkIdRef(blkId);
		return symbRef;
	}

}
