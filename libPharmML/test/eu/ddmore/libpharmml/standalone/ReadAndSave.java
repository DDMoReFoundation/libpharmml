package eu.ddmore.libpharmml.standalone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationError;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMlFactory;

public class ReadAndSave {

	public static void main(String[] args) throws FileNotFoundException {
		
//		LoggerWrapper.getLogger().setLevel(Level.ALL);
		
		ILibPharmML libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		FileInputStream in = new FileInputStream(args[0]);
		IPharmMLResource resource = libPharmML.createDomFromResource(in);
		
		IValidationReport report = libPharmML.getValidator().createValidationReport(resource);
		Iterator<IValidationError> it = report.errorIterator();
		while(it.hasNext()){
			System.err.println(it.next());
		}
		
		libPharmML.save(new FileOutputStream(args[1]), resource);

	}

}
