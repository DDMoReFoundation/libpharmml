package eu.ddmore.libpharmml.standalone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;

public class ReadAndSave {

	public static void main(String[] args) throws FileNotFoundException {
		
		ILibPharmML libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		FileInputStream in = new FileInputStream(args[0]);
		IPharmMLResource resource = libPharmML.createDomFromResource(in);
		
		libPharmML.save(new FileOutputStream(args[1]), resource);

	}

}
