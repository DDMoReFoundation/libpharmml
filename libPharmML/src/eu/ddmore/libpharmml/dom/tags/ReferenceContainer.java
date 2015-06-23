package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.validation.PharmMLValidator;
import eu.ddmore.libpharmml.validation.SymbolResolver;

/**
 * Interface implemented by object that contain references to other elements in
 * the model, like {@link OidRef}. As validation needs to know the name of the 
 * element rather than the class, the validation process is performed within
 * the implementing class and partially within the {@link PharmMLValidator}
 * class.
 */
public interface ReferenceContainer {
	
	/**
	 * Attempt to validate the references within this object.
	 * @param sr The {@link SymbolResolver} built from the current DOM.
	 * @param errorHandler {@link IErrorHandler} to catch any potential error.
	 */
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler);

}
