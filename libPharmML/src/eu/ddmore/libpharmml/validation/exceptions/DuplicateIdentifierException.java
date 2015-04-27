package eu.ddmore.libpharmml.validation.exceptions;

import eu.ddmore.libpharmml.dom.Identifiable;

/**
 * Exception thrown during an attempt to store an {@link Identifiable} with an already
 * given identifier.
 */
public class DuplicateIdentifierException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4961201589224567621L;
	
	private final Identifiable duplicate;
	
	/**
	 * Minimal constructor.
	 * @param duplicate The {@link Identifiable} object that already exists.
	 */
	public DuplicateIdentifierException(Identifiable duplicate){
		this.duplicate = duplicate;
	}
	
	/**
	 * Gets the object that has existed first with the given identifier.
	 * @return The duplicate {@link Identifiable} object.
	 */
	public Identifiable getDuplicate(){
		return duplicate;
	}

}
