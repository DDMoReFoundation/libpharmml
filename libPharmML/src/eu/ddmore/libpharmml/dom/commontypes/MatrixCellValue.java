package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Interface for object types that can be used as value within in a matrix cell.
 * @author F. Yvon
 */
@XmlJavaTypeAdapter(MatrixCellValueAdapter.class)
public interface MatrixCellValue {

}
