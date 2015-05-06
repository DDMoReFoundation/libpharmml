package eu.ddmore.libpharmml.dom.commontypes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VectorElements", propOrder = {
	    "jaxb_elements"
	})
@XmlJavaTypeAdapter(VectorElements.Adapter.class)
public class VectorElements extends PharmMLRootType implements ScalarContainer {
		
	//-------
	@XmlElementRefs({
		@XmlElementRef(name = "VectorValue", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type=JAXBElement.class),
		@XmlElementRef(name = "Sequence", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type=JAXBElement.class)
	})
	protected List<JAXBElement<? extends VectorValue>> jaxb_elements;
	@XmlTransient
	protected List<VectorValue> elements;
	//-------
	
	/**
	 * Empty constructor
	 */
	public VectorElements(){}
	
	
	public VectorElements(VectorValue []values){
		elements = new ArrayList<VectorValue>();
		for(VectorValue value : values){
			elements.add(value);
		}
	}
	
	public List<VectorValue> getListOfElements(){
		if(elements == null){
			elements = new ArrayList<VectorValue>();
		}
		return elements;
	}

	@Override
	public IntValue createIntValue(int value) {
		IntValue wValue = new IntValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public RealValue createRealValue(double value) {
		RealValue wValue = new RealValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public StringValue createStringValue(String value) {
		StringValue wValue = new StringValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public IdValue createIdValue(String value) {
		IdValue wValue = new IdValue(value);
		getListOfElements().add(wValue);
		return wValue;
	}

	@Override
	public BooleanValue createBooleanValue(boolean value) {
		BooleanValue wValue;
		if(value){
			wValue = new TrueBoolean();
		} else {
			wValue = new FalseBoolean();
		}
		getListOfElements().add(wValue);
		return wValue;
	}
	
	public SymbolRef createSymbolRef(String symbId){
		SymbolRef symbRef = new SymbolRef();
		symbRef.setId(symbId);
		getListOfElements().add(symbRef);
		return symbRef;
	}
	
	public SymbolRef createSymbolRef(String symbId, String blkId){
		SymbolRef symbRef = createSymbolRef(symbId);
		symbRef.setBlkIdRef(blkId);
		return symbRef;
	}
	
	public Sequence createSequence(){
		Sequence seq = new Sequence();
		getListOfElements().add(seq);
		return seq;
	}
	
	protected static class Adapter extends XmlAdapter<VectorElements, VectorElements>{

		@Override
		public VectorElements unmarshal(VectorElements v) throws Exception {
			if(v.jaxb_elements != null){
				for(JAXBElement<? extends VectorValue> el : v.jaxb_elements){
					v.getListOfElements().add(el.getValue());
				}
			}
			return v;
		}

		@Override
		public VectorElements marshal(VectorElements v) throws Exception {
			if(v != null){
				v.jaxb_elements = new ArrayList<JAXBElement<? extends VectorValue>>();
				if(v.elements != null){
					for(VectorValue el : v.elements){
						v.jaxb_elements.add(MasterObjectFactory.createVectorValue(el));
					}
				}
				return v;
			} else {
				return null;
			}
		}
		
	}
	
}