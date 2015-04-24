package eu.ddmore.libpharmml.validation;

import java.util.ArrayList;
import java.util.List;

import eu.ddmore.libpharmml.IValidationError;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

/**
 * Class meant to perform validation following the rules in the PharmML specification. There is 
 * no schema-based validation performed within this object.
 * @author F. Yvon
 *
 */
public class PharmMLValidator {
	
	/**
	 * Validates a whole PharmML DOM by browsing it recursively, seeking for validatable objects.
	 * 
	 * <p>When an object implementing the {@link Validatable} interface is met, the validation errors
	 * that may be found are added to a master list, which is returned at the end of the process.
	 * @param dom The PharmML root object of the document.
	 * @return A {@link List} of {@link IValidationError} objects that was aggregated during
	 * the validation process.
	 */
	public static List<IValidationError> validate(PharmML dom){
		List<IValidationError> errors = new ArrayList<IValidationError>();
		
		PharmMLElementWrapper wRoot = new PharmMLElementWrapper(dom);
		recursiveValidate(errors, wRoot);
		
		return errors;
	}
	
	/**
	 * Recursive method that parses a PharmML tree and validates any validatable element.
	 * @param errors The list that shall be filled during the process.
	 * @param wEl The element to validate. Its mapped children are fetched and this method
	 * is executed on each child.
	 */
	private static void recursiveValidate(List<IValidationError> errors, PharmMLElementWrapper wEl){
		Object el = wEl.getElement();
		if(el instanceof Validatable){
			LoggerWrapper.getLogger().info("Validating "+el);
			errors.addAll(((Validatable)el).validate());
		}
		for(PharmMLElementWrapper wChild : wEl.getChildren()){
			recursiveValidate(errors, wChild);
		}
	}

}
