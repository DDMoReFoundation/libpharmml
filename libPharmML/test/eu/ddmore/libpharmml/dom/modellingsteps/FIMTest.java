package eu.ddmore.libpharmml.dom.modellingsteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.AssertUtil;
import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.ConstantOperator;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class FIMTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private IPharmMLResource unmarshalResource;
	
	private static final PharmMLVersion VERSION = PharmMLVersion.V0_8_1;
	private static final String TESTFILE = "testFIM.xml";
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		this.unmarshalResource = libPharmML.createDomFromResource(is);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource = null;
		this.unmarshalResource = null;
	}
	
	@Test
	public void testMarshal() throws Exception {
		PharmML dom = resource.getDom();
		ModellingSteps msteps = dom.createModellingSteps();
		OptimalDesignStep odstep = msteps.createOptimalDesignStep("od1");
		OptimalDesignOperation odop = odstep.createOperation(1, OptimalDesignOpType.EVALUATION, new Name("operation_name"));
		odop.createProperty("prop1").assign(new Constant(ConstantOperator.EXPONENTIALE));
		odstep.createFim(FIMtype.B);
		
		libPharmML.save(System.out, resource);
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		PharmML dom = unmarshalResource.getDom();
		ModellingSteps msteps = dom.getModellingSteps();
		OptimalDesignStep ods = msteps.getListOfOptimalDesignStep().get(0);
		FIM fim = ods.getFIM();
		assertNotNull(fim);
		assertEquals(FIMtype.B,fim.getType());
	}
	
	@Test
	public void testValidateUnmarshal() throws Exception {
		AssertUtil.assertValid(unmarshalResource.getCreationReport());
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(unmarshalResource));
	}

}
