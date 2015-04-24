package eu.ddmore.libpharmml.util.annotations;

import eu.ddmore.libpharmml.impl.PharmMLVersion;

public @interface RenamedElement {

	String field();
	PharmMLVersion since() default PharmMLVersion.V0_2_1;
	
}
