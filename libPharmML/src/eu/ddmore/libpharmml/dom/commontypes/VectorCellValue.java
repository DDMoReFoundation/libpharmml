package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(VectorCellValueAdapter.class)
public interface VectorCellValue extends VectorValue {

}
