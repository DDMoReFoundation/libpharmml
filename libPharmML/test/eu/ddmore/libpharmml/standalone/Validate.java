package eu.ddmore.libpharmml.standalone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

public class Validate {

	public static void main(String[] args) throws IOException {
		
		for(String fileName : args){
			ILibPharmML libPharmML = PharmMlFactory.getInstance().createLibPharmML();
			
			LoggerWrapper.getLogger().setLevel(Level.WARNING);
			
			File file = new File(fileName);
			
			print("Validating "+file.getName());
			
			InputStream in = new FileInputStream(file);
			IPharmMLResource pmlResource = libPharmML.createDomFromResource(in);
			in.close();
			
			IValidationReport creationReport = pmlResource.getCreationReport();
			print("CREATION REPORT: "+creationReport.numErrors()+" error(s)\n");
			for(int i=1;i<=pmlResource.getCreationReport().numErrors();i++){
				print("\t- "+pmlResource.getCreationReport().getError(i)+"\n");
			}
			@SuppressWarnings("unused")
			PharmML dom = pmlResource.getDom();

			IPharmMLValidator validator = libPharmML.getValidator();
			IValidationReport rpt = validator.createValidationReport(pmlResource);
			print("VALIDATION REPORT: "+rpt.numErrors()+" error(s)\n");
			for(int i=1;i<=rpt.numErrors();i++){
				print("\t- "+rpt.getError(i)+"\n");
			}
			
			print("---------------------------");
		}

	}

	private static void print(String string) {
		System.out.println(string);
	}

}
