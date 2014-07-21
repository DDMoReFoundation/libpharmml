package eu.ddmore.libpharmml.exceptions;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UndeclaredInterfaceImplementer extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6709822764061769834L;
	
	public UndeclaredInterfaceImplementer(XmlAdapter<?,?> adapter, Object suspect){
		super("Undeclared class of "+suspect+" in adapter "+adapter.getClass());
	}

}
