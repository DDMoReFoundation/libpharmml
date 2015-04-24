package eu.ddmore.libpharmml.validation;

import java.util.List;

import eu.ddmore.libpharmml.IValidationError;

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
	 * Each validation error is returned.
	 * @return A {@link List} of {@link IValidationError} objects.
	 */
	List<IValidationError> validate();
	
}
