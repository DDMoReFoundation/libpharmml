package eu.ddmore.libpharmml;

import java.io.FileInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidateUseCasesTest {
	
	private ILibPharmML libPharmML;
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
	}
	
	@Test
	public void testCreationReportUseCase9_version6() throws Exception {
		final String useCase9 = "examples/0_6_1/UseCase109.xml";
		IPharmMLResource resource = libPharmML.createDomFromResource(new FileInputStream(useCase9));
		
		AssertUtil.assertValid(resource.getCreationReport());
	}
	
	@Test
	public void testValidationReportUseCase9_version6() throws Exception {
		final String useCase9 = "examples/0_6_1/UseCase109.xml";
		IPharmMLResource resource = libPharmML.createDomFromResource(new FileInputStream(useCase9));
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(resource));
		
		libPharmML.save(System.out, resource);
	}

}
