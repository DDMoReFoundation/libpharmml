package eu.ddmore.libpharmml.dom.commontypes;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Interface for object types that can be used as value within in a matrix cell.
 * @author F. Yvon
 * 
 *  * Possible implementations:
 * 		{@link Scalar},
 * 		{@link Sequence},
 * 		{@link SymbolRef},
 * 		{@link Equation}
 */
@XmlJavaTypeAdapter(MatrixCellValueAdapter.class)
public interface MatrixCellValue extends TreeNode{

}
