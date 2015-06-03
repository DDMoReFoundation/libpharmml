package eu.ddmore.libpharmml.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

/**
 * And extended {@link ArrayList} that provides the possibility
 * of method chaining.

 * @param <T> Class of the content of the list.
 */
public class ChainedList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7322317602466355646L;

	public ChainedList<T> addIfNotNull(T element){
		if(element != null){
			add(element);
		}
		return this;
	}
	
	public ChainedList<T> addJAXBIfNotNull(JAXBElement<? extends T> jaxbEl){
		if(jaxbEl != null && jaxbEl.getValue() != null){
			add(jaxbEl.getValue());
		}
		return this;
	}
	
	public ChainedList<T> addIfNotNull(List<? extends T> element){
		if(element != null){
			addAll(element);
		}
		return this;
	}

}
