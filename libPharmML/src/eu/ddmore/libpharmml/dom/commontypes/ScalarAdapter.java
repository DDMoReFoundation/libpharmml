package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ScalarAdapter extends XmlAdapter<JAXBElement<?>, Scalar>{
	
	private static ObjectFactory of = new ObjectFactory();

	@Override
	public Scalar unmarshal(JAXBElement<?> v) throws Exception {
		return (Scalar) v.getValue();
	}

	@Override
	public JAXBElement<?> marshal(Scalar v) throws Exception {
		if(v instanceof IntValueType){
			return of.createInt((IntValueType) v);
		} else if(v instanceof RealValueType){
			return of.createReal((RealValueType) v);
		} else if(v instanceof StringValueType){
			return of.createString((StringValueType) v);
		} else if(v instanceof IdValueType){
			return of.createId((IdValueType) v);
		} else if(v instanceof BooleanType){
			return of.createBoolean((BooleanType) v);
		} else {
			throw new RuntimeException("Unknown scalar type in adapter");
		}
	}

	
}
