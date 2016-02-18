package eu.ddmore.libpharmml.dom.tags;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;

/**
 * Interface implemented by adapted XML-mapped objects.
 * @param <T> The POJO class that is adapted by the implementing class.
 */
public interface AdaptedClass<T extends PharmMLElement> {
	
	/**
	 * Gets the object mapped by this adapter. The first call of this method generates the POJO. This methods must be
	 * called within the implementation of {@link XmlAdapter#unmarshal(Object)} in the adapter. The reason is that the
	 * POJO may be used before the adpater being called.
	 * @return The object mapped by this adapter.
	 */
	public T getUnmappedObject();

}
