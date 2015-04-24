package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.JAXBElement;

/**
 * Interface implemented by any possible type of value within {@link Expression} objects, such as
 * {@link Uniop} or {@link Piece}.
 * @author F. Yvon
 *
 */
public interface ExpressionValue {
	
	/**
	 * Converts the object to a JAXBElement for marshalling.
	 * @return An instance of {@link JAXBElement} that contains the current object.
	 */
	public JAXBElement<? extends Operand> toJAXBElement();

}
