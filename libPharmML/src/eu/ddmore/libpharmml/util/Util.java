package eu.ddmore.libpharmml.util;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;

public class Util {

	public static void cloneRoot(PharmMLRootType from, PharmMLRootType to){
		to.setDescription(from.getDescription());
		to.setId(from.getId());
		to.setUnmarshalVersion(from.getUnmarshalVersion());
	}
	
}
