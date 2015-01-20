package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;

public class MatrixRowValueAdapter extends XmlAdapter<JAXBElement<?>, MatrixRowValue> {

	@Override
	public MatrixRowValue unmarshal(JAXBElement<?> v) throws Exception {
		Object el = v.getValue();
		if(el instanceof MatrixRowValue){
			return (MatrixRowValue) el;
		} else {
			return null;
		}
	}

	@Override
	public JAXBElement<?> marshal(MatrixRowValue v) throws Exception {
		JAXBElement<?> jaxbEl;
		if(v != null){
			if(v instanceof Scalar){
				jaxbEl = MasterObjectFactory.createScalar((Scalar) v);
			} else if (v instanceof Sequence){
				jaxbEl = MasterObjectFactory.COMMONTYPES_OF.createSequence((Sequence) v);
			} else if (v instanceof SymbolRef){
				jaxbEl = MasterObjectFactory.COMMONTYPES_OF.createSymbRef((SymbolRef) v);
			} else if (v instanceof Equation){
				jaxbEl = new JAXBElement<Equation>(new QName("http://www.pharmml.org/2013/03/Maths", "Equation"), Equation.class, (Equation) v);
			} else {
				throw new UndeclaredInterfaceImplementer(this, v);
			}
		} else {
			jaxbEl = null;
		}
		return jaxbEl;
	}

}
