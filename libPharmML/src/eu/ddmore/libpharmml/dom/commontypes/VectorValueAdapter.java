package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;

public class VectorValueAdapter extends XmlAdapter<JAXBElement<?>, VectorValue>{
	
	private static ObjectFactory of = new ObjectFactory();

	@Override
	public VectorValue unmarshal(JAXBElement<?> v) throws Exception {
		return (VectorValue) v.getValue();
	}

	@Override
	public JAXBElement<?> marshal(VectorValue v) throws Exception {
		if(v instanceof VectorCellValue){
			return new VectorCellValueAdapter().marshal((VectorCellValue) v);
		} else if (v instanceof SequenceType){
			return of.createSequence((SequenceType) v);
		} else {
			throw new UndeclaredInterfaceImplementer(this, v);
		}
	}

}
