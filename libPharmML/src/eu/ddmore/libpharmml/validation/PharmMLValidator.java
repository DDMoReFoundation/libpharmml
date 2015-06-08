package eu.ddmore.libpharmml.validation;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.IErrorHandler;
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
	 * @param errorHandler
	 */
	public static void validate(PharmML dom, IErrorHandler errorHandler){	
		SymbolResolver sr = new SymbolResolver(dom, errorHandler);
		sr.validateAll();
		recursiveValidate(errorHandler, dom);
	}
	
	/**
	 * Recursive method that parses a PharmML tree and validates any validatable element.
	 * @param errors The list that shall be filled during the process.
	 * @param wEl The element to validate. Its mapped children are fetched and this method
	 * is executed on each child.
	 */
	private static void recursiveValidate(IErrorHandler errorHandler, TreeNode el){
		if(el instanceof Validatable){
			LoggerWrapper.getLogger().info("Validating "+el);
			((Validatable)el).validate(errorHandler);
		}
		@SuppressWarnings("unchecked")
		Enumeration<TreeNode> children = el.children();
		while(children.hasMoreElements()){
			recursiveValidate(errorHandler, children.nextElement());
		}
	}

}
