package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;
import eu.ddmore.libpharmml.impl.XMLFilter;

public class MatrixCellValueAdapter extends XmlAdapter<JAXBElement<?>, MatrixCellValue>{

	@Override
	public MatrixCellValue unmarshal(JAXBElement<?> v) throws Exception {
		Object el = v.getValue();
		if(el instanceof MatrixCellValue){
			return (MatrixCellValue) el;
		} else {
			return null;
		}
	}

	@Override
	public JAXBElement<?> marshal(MatrixCellValue v) throws Exception {
		JAXBElement<?> jaxbEl;
		if(v != null){
			if(v instanceof Scalar){
				jaxbEl = MasterObjectFactory.createScalar((Scalar) v);
			} else if (v instanceof SymbolRef){
				jaxbEl = MasterObjectFactory.COMMONTYPES_OF.createSymbRef((SymbolRef) v);
			} else if (v instanceof Equation){
				jaxbEl = new JAXBElement<Equation>(new QName(XMLFilter.NS_DEFAULT_MATH, "Equation"), Equation.class, (Equation) v);
			} else {
				throw new UndeclaredInterfaceImplementer(this, v);
			}
		} else {
			jaxbEl = null;
		}
		return jaxbEl;
	}

	
}
