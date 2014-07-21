package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(VectorValueAdapter.class)
public interface VectorValue {

	public String asString();
	
}
