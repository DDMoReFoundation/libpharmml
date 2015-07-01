package eu.ddmore.libpharmml.wiki.snippets;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class CreateMethod {

	public static void main(String[] args) {
		
		ILibPharmML libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		
		IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.V0_6);
		PharmML dom = resource.getDom();
		
		// Creating an ampty model definition and adding to the PharmML root element
		ModelDefinition modelDefinition = dom.createModelDefinition();
		
		// Creating a new structural model with blkId=sm1
		StructuralModel structuralModel = modelDefinition.createStructuralModel("sm1");
		
		libPharmML.save(System.out, resource);
	}

}
