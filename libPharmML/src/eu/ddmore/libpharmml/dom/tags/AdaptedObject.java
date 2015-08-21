package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;

/**
 * Interface implemented by adapted XML-mapped objects.
 * @param <T> The POJO class that is adapted by the implementing class.
 */
public interface AdaptedObject<T extends PharmMLElement> {
	
	/**
	 * Gets the object mapped by this adapter.
	 * @return The object mapped by this adapter.
	 */
	public T getUnmappedObject();

}
