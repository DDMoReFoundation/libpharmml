package eu.ddmore.libpharmml.impl;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.dom.PharmML;

public class TestResourceFactory {
	
	public static IPharmMLResource createResource(PharmML dom){
		return new PharmMLResourceImpl(dom, new ValidationReportFactory().createReport(), new IdFactoryImpl());
	}

}
