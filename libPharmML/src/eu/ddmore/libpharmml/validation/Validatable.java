package eu.ddmore.libpharmml.validation;

import eu.ddmore.libpharmml.IErrorHandler;

/**
 * Interface implemented by each validatable element.
 * 
 * During the validation process, the DOM tree is browsed. If a node implements this
 * interface, then the method {@link #validate()} is executed.
 * 
 * @author F. Yvon
 *
 */
public interface Validatable {

	/**
	 * Tries to validate the current element following the PharmML specification. 
	 * Each validation error is handled by the given {@link IErrorHandler} implementation.
	 * @param errorHandler An implementation of {@link IErrorHandler}.
	 */
	void validate(IErrorHandler errorHandler);
	
}
