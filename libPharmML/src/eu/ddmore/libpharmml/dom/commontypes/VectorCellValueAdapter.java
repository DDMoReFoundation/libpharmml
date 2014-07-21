package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

public class VectorCellValueAdapter extends XmlAdapter<JAXBElement<?>, VectorCellValue>{
	
	private ObjectFactory of = new ObjectFactory();

	@Override
	public VectorCellValue unmarshal(JAXBElement<?> v) throws Exception {
		if(v.getValue() == null){
			throw new RuntimeException("nulllll");
		}
		LoggerWrapper.getLogger().severe(v.getValue().toString());
		return (VectorCellValue) v.getValue();
	}

	@Override
	public JAXBElement<?> marshal(VectorCellValue v) throws Exception {
		if(v instanceof SymbolRefType){
			return of.createSymbRef((SymbolRefType) v);
		} else if (v instanceof Scalar){
			ScalarAdapter scalarAdapter = new ScalarAdapter();
			return scalarAdapter.marshal((Scalar) v);
		} else {
			throw new UndeclaredInterfaceImplementer(this, v);
		}
	}

}
