package eu.ddmore.libpharmml.exceptions;

public class AnnotationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3294003744250401849L;
	private String message;
	
	public AnnotationException(Object o, String message){
		this.message = "Element "+o+ " has an incorrect annotation: "+message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
}
