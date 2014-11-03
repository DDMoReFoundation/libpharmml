package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Interface for object types that can be used as value within in a matrix value.
 * @author F. Yvon
 */
@XmlJavaTypeAdapter(MatrixRowValueAdapter.class)
public interface MatrixRowValue {

}
