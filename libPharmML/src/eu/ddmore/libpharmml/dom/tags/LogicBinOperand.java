package eu.ddmore.libpharmml.dom.tags;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.dom.maths.LogicBinOp;

/**
 * Interface implemented by objects which can be values of {@link LogicBinOp} elements.
 *
 * @author F. Yvon
 */
public interface LogicBinOperand {
	
	JAXBElement<? extends LogicBinOperand> toJAXBElementOfLogicBinOp();

}
