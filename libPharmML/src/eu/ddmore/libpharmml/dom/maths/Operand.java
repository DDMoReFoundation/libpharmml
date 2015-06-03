package eu.ddmore.libpharmml.dom.maths;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;

/**
 * Interface implemented by any operand in a binay-operand expression.
 * 
 * @author florent
 *
 */
public interface Operand extends TreeNode {

	// TODO: experiment, put this method in PharmMLElement
	/**
	 * Converts the object to a JAXBElement for marshalling.
	 * @return An instance of {@link JAXBElement} that contains the current object.
	 */
	public JAXBElement<? extends Operand> toJAXBElement();
	
}
