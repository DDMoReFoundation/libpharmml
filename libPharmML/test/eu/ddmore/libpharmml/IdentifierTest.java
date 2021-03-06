package eu.ddmore.libpharmml;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.FunctionDefinition;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class IdentifierTest {
	
	private static final String MODEL_FILE = "example4.xml";
	
	// Parameters
	private final PharmMLVersion version;
	private final Integer n_identifiables;
	
	private ILibPharmML testInstance;
	private IPharmMLResource testResource;
	private String exampleDir;
	
	public IdentifierTest(final PharmMLVersion version, final Integer n_identifiables) {
		this.version = version;
		this.n_identifiables = n_identifiables;
	}
	
	@Parameters
	public static Collection<Object[]> parameters(){
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_6, 562}, 
				{PharmMLVersion.V0_7_3, 606},
				{PharmMLVersion.V0_8, 606},
		});
	}
	
	@Before
	public void setUp() throws Exception {
		this.testInstance = PharmMlFactory.getInstance().createLibPharmML();
		this.exampleDir = PharmMLVersionFactory.getExampleDir(version);
		this.testResource = createResource();
	}
	
	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.testResource = null;
	}
	
	private IPharmMLResource createResource() throws IOException{
		return testInstance.createDomFromResource(new FileInputStream(exampleDir+"/"+MODEL_FILE));
	}
	
	@Test
	public void testFind(){
		assertNotNull("Found", testResource.find("i1"));
		assertNotNull("Found", testResource.find("e1"));
		assertNull("Not found", testResource.find("foo"));
	}
	
	@Test
	public void testAutosetIdOn() throws IOException{
		File tmpFile = File.createTempFile("tst", ".xml");
//		LoggerWrapper.getLogger().warning(tmpFile.getAbsolutePath());
		tmpFile.deleteOnExit();
		testInstance.save(new FileOutputStream(tmpFile), testResource);
		
		IPharmMLResource newResource = testInstance.createDomFromResource(new FileInputStream(tmpFile));
		assertEquals("Number of generated ids",n_identifiables, Integer.valueOf(newResource.getIdFactory().getListOfIdentifiable().size()));
		assertNotNull("Previous id found", newResource.find("e1"));
	}
	
	@Test
	public void testAutosetIdOff() throws IOException{
		File tmpFile = File.createTempFile("tst", ".xml");
//		LoggerWrapper.getLogger().warning(tmpFile.getAbsolutePath());
		tmpFile.deleteOnExit();
		testResource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		testInstance.save(new FileOutputStream(tmpFile), testResource);
		testResource.setParameter(IPharmMLResource.AUTOSET_ID, true);
		
		IPharmMLResource newResource = testInstance.createDomFromResource(new FileInputStream(tmpFile));
		assertEquals("Number of ids",2, newResource.getIdFactory().getListOfIdentifiable().size());
		assertNotNull("Previous id found", newResource.find("e1"));
		assertNull("No new id", newResource.find("i10"));
	}
	
	@Test
	public void testRegisterAdaptedObject() throws Exception {
		final String TEST_ID = "testId";
		IPharmMLResource resource = testInstance.createDom(PharmMLVersion.DEFAULT);
		PharmML dom = resource.getDom();
		FunctionDefinition funcDef = dom.createFunctionDefinition("f1", SymbolType.REAL);
		StandardAssignable definition = funcDef.createDefinition();
		definition.assign(new RealValue(0));
		definition.setId(TEST_ID);
		
		File tmpFile = File.createTempFile("unitTest", ".xml");
		tmpFile.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(tmpFile);
		testInstance.save(fos, resource); // register ids
		fos.close();
		
		Identifiable identifiable = resource.find(TEST_ID);
		assertNotNull(identifiable);
		assertThat(identifiable, instanceOf(StandardAssignable.class));
		
		IPharmMLResource unmarshalResource = testInstance.createDomFromResource(new FileInputStream(tmpFile));
		Identifiable unmarshalIdentifiable = unmarshalResource.find(TEST_ID);
		assertNotNull(unmarshalIdentifiable);
		assertThat(unmarshalIdentifiable, instanceOf(StandardAssignable.class));
	}

}
