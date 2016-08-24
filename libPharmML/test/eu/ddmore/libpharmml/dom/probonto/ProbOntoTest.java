package eu.ddmore.libpharmml.dom.probonto;

import static eu.ddmore.libpharmml.AssertUtil.assertInvalid;
import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.MissingValueSymbol;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.modeldefn.Distribution;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.ValidationReportFactory;

@RunWith(Parameterized.class)
public class ProbOntoTest {

	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	
	private static final String TESTFILE = "testProbOnto.xml";
	private IPharmMLResource unmarshalResource;
	
	public ProbOntoTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, true);

		
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		unmarshalResource = libPharmML.createDomFromResource(is);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource = null;
		this.unmarshalResource = null;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_7_3},
					{PharmMLVersion.V0_8}
		});
	}
	
	@Test
	public void testTest(){
		assertNotNull(ParameterName.fromValue("mean"));
	}
	
	@Test
	public void testMarshal() throws Exception {
		PharmML dom = resource.getDom();
		ParameterModel pm = dom.createModelDefinition().createParameterModel("pm1");
		IndividualParameter param = MasterObjectFactory.MODELDEFN_OF.createIndividualParameterType();
		param.setSymbId("ip1");
//		JAXBElement<IndividualParameter> jaxb_param = MasterObjectFactory.MODELDEFN_OF.createIndividualParameter(param);
//		pm.getCommonParameterElement().add(jaxb_param);
		pm.getListOfParameterModelElements().add(param);
		
		Distribution distrib = param.createDistribution();
		
		ProbOnto probonto = createValidProbOnto();
		distrib.setProbOnto(probonto);
		
		DistributionBound lower = probonto.createLowerTruncationBound();
		lower.assign(new RealValue(0));
		DistributionBound upper = probonto.createUpperTruncationBound();
		upper.assign(new RealValue(100));
		
		MixtureComponent mixt = probonto.createMixtureComponent(DistributionName.BERNOULLI_1);
		mixt.createParameter(ParameterName.PROBABILITY).assign(new MissingValue(MissingValueSymbol.PLUSINF));
		
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		libPharmML.save(baos, resource);
//		
//		System.out.print(baos);
		
		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		PharmML dom = unmarshalResource.getDom();
		dom.getModelDefinition();
		assertValid(libPharmML.getValidator().createValidationReport(unmarshalResource));
	}

	@Test
	public void testMarshalEmpirical() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		PharmML dom = resource.getDom();
		ParameterModel pm = dom.createModelDefinition().createParameterModel("pm1");
		IndividualParameter param = MasterObjectFactory.MODELDEFN_OF.createIndividualParameterType();
		param.setSymbId("ip1");
		pm.getListOfParameterModelElements().add(param);
		
		Distribution distrib = param.createDistribution();
		ProbOnto po = distrib.createProbOnto(DistributionName.STANDARD_NORMAL_1, DistributionType.UNIVARIATE);
		po.createRealisation(new Rhs(new RealValue(50)));
		po.createWeight(new Rhs(new RealValue(1)));
		
		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}

//	@Test
//	public void testParamProperties() throws Exception {
//		for(DistributionName dn : DistributionName.values()){
////			System.out.println(dn);
//			assertTrue(dn+" has parameters defined.", dn.allowedParameters().size() > 0);
//		}
//	}
	
	@Test
	public void testRequiredParameters() throws Exception {
		DistributionName name = DistributionName.NORMAL_1;
		ParameterName[] requiredParam = name.requiredParameters();
		assertEquals("2 required parameters", 2, requiredParam.length);
		assertThat(requiredParam[0], anyOf(equalTo(ParameterName.MEAN), equalTo(ParameterName.STDEV)));
		assertThat(requiredParam[1], anyOf(equalTo(ParameterName.MEAN), equalTo(ParameterName.STDEV)));
	}
	
	@Test
	public void testAllowedParameters() throws Exception {
		DistributionName name = DistributionName.STANDARD_NORMAL_1;
		Set<ParameterName> allowedParams = name.allowedParameters();
		assertEquals("2 allowed parameters", 2, allowedParams.size());
		assertTrue("Allowed param: MEAN", allowedParams.contains(ParameterName.MEAN));
		assertTrue("Allowed param: STDEV", allowedParams.contains(ParameterName.STDEV));
		assertEquals("No required parameter", 0, name.requiredParameters().length);
	}
	
	@Test
	public void testInvalidDistribution() throws Exception {
		ValidationReportFactory errorHandler = new ValidationReportFactory();
		ProbOnto probOnto = createInvalidProbOnto();
		probOnto.validate(errorHandler);
		assertInvalid(1, errorHandler.createReport());
	}
	
	@Test
	public void testValidStandardNormal1() throws Exception {
		ValidationReportFactory errorHandler = new ValidationReportFactory();
		ProbOnto po = ObjectFactory.getInstance().createProbOnto();
		po.setName(DistributionName.STANDARD_NORMAL_1);
		po.validate(errorHandler);
		assertValid(errorHandler.createReport());
	}
	
	@Test
	public void testValidHyperbolicSecant1() throws Exception {
		ValidationReportFactory errorHandler = new ValidationReportFactory();
		ProbOnto po = ObjectFactory.getInstance().createProbOnto();
		po.setName(DistributionName.HYPERBOLIC_SECANT_1);
		po.validate(errorHandler);
		assertValid(errorHandler.createReport());
	}
	
	@Test
	public void testInvalidHyperbolicSecant1() throws Exception {
		ValidationReportFactory errorHandler = new ValidationReportFactory();
		ProbOnto po = ObjectFactory.getInstance().createProbOnto();
		po.setName(DistributionName.HYPERBOLIC_SECANT_1);
		po.createParameter(ParameterName.ALPHA).assign(new RealValue(2.0));
		po.validate(errorHandler);
		assertInvalid(1,errorHandler.createReport());
	}
	
	public static ProbOnto createInvalidProbOnto(){
		ProbOnto probOnto = ObjectFactory.getInstance().createProbOnto();
		probOnto.setName(DistributionName.LAPLACE_1);
		probOnto.createParameter(ParameterName.LOCATION).assign(new IntValue(2));
		return probOnto;
	}
	
	public static ProbOnto createValidProbOnto(){
		ProbOnto probOnto = ObjectFactory.getInstance().createProbOnto();
		probOnto.setName(DistributionName.NORMAL_1);
		probOnto.createParameter(ParameterName.MEAN).assign(new RealValue(0));
		probOnto.createParameter(ParameterName.STDEV).assign(new RealValue(1));
		return probOnto;
	}
	
}
