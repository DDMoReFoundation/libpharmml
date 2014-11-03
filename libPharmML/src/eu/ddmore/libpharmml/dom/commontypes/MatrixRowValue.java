package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Interface for object types that can be used as value within in a matrix value.
 * 
 * Possible implementations:
 * 		{@link Scalar},
 * 		{@link SequenceType},
 * 		{@link SymbolRefType},
 * 		{@link Equation}
 * 
 * @author F. Yvon
 */
@XmlJavaTypeAdapter(MatrixRowValueAdapter.class)
public interface MatrixRowValue {

}
