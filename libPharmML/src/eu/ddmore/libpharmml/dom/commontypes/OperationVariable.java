package eu.ddmore.libpharmml.dom.commontypes;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Interface implementend by entities that can be affected by sums or products.
 * Possible types:
 * 		{@link SymbolRef},
 * 		{@link Equation}
 */
public interface OperationVariable extends TreeNode {

}
