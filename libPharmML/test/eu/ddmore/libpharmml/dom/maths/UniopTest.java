package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.AssertUtil;
import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModel;
import eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter;
import eu.ddmore.libpharmml.dom.modeldefn.SimpleParameter;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@SuppressWarnings("deprecation")
@RunWith(Parameterized.class)
public class UniopTest {
	
	private final PharmMLVersion VERSION;

	private ILibPharmML libPharmML;
//	private eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory of = MasterObjectFactory.MODELDEFN_OF;
	
	private static final String TESTFILE = "testUniop.xml";
	private static final String TESTFILE_PROBAFUNCTION = "testUniopProbaFunction.xml";
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
	}
	
	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_3},
				{PharmMLVersion.V0_7_3},
				{PharmMLVersion.V0_8}
		});
	}
	
	public UniopTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Test
	public void testMarshal() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(VERSION);
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.createModelDefinition();
		ParameterModel pm = mdef.createParameterModel("pm1");
		if(VERSION.isEqualOrLaterThan(PharmMLVersion.V0_7_3)){
			addLogPopParam(pm, "param1", new RealValue(33));
			addLogPopParam(pm, "param2", new Binop(Binoperator.PLUS, new IntValue(1), new IntValue(2)));
			addLogPopParam(pm, "param3", new Constant(ConstantOperator.PI));
		} else {
			SimpleParameter sp = new SimpleParameter();
			sp.setSymbId("param1");
			sp.assign(new Uniop(Unioperator.LOG, new RealValue(33)));
			pm.getListOfParameterModelElements().add(sp);
			// A SM is mandatory in this version
			StructuralModel sm =mdef.createStructuralModel("sm1");
			sm.createDerivativeVariable("Ac", SymbolType.REAL);
		}
		
//		libPharmML.save(System.out, resource);
		
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	private void addLogPopParam(ParameterModel pm, String name, ExpressionValue value){
		PopulationParameter pp = new PopulationParameter();
		pp.setSymbId(name);
		pp.assign(new Uniop(Unioperator.LOG, value));
		pm.getListOfParameterModelElements().add(pp);
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		if(VERSION.equals(PharmMLVersion.V0_7_3)){
			ModelDefinition mdef = resource.getDom().getModelDefinition();
			ParameterModel pm = mdef.getListOfParameterModel().get(0);
			validate((PopulationParameter) pm.getListOfParameterModelElements().get(0), 
					RealValue.class, "param1");
			validate((PopulationParameter) pm.getListOfParameterModelElements().get(1), 
					Binop.class, "param2");
			validate((PopulationParameter) pm.getListOfParameterModelElements().get(2), 
					Constant.class, "param3");
		}
	}
	
	private void validate(PopulationParameter param,Class<?> type,String name){
		assertEquals(name, param.getSymbId());
		assertThat(param.getAssign().getUniop().getValue(), instanceOf(type));
	}
	
	@Test
	public void testMarshalProbabilityFunction() throws Exception {
		if(VERSION.isEqualOrLaterThan(PharmMLVersion.V0_8)){
			IPharmMLResource resource = libPharmML.createDom(VERSION);
			resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
			PharmML dom = resource.getDom();
			ModelDefinition mdef = dom.createModelDefinition();
			ParameterModel pm = mdef.createParameterModel("pm1");
			IndividualParameter ip = pm.createIndividualParameter("ip1");
			Uniop uniop = new Uniop(Unioperator.LOG, TestMathObjectFactory.createValidProbabilityFunction(ProbabilityFunctionType.PDF));
			ip.assign(uniop);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			libPharmML.save(baos, resource);
			
			String output = baos.toString();
			assertThat(output, containsString("<math:Uniop op=\"log\">"));
			assertThat(output, containsString("<math:PDF>"));
			assertThat(output, containsString("<math:Distribution>"));
			
			AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(resource));
		}
	}
	
	@Test
	public void testUnmarshalProbabilityFunction() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_PROBAFUNCTION);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(res.getCreationReport());
		assertValid(libPharmML.getValidator().createValidationReport(res));
		
		IndividualParameter ip = (IndividualParameter) res.getDom().getModelDefinition().getListOfParameterModel().get(0).getListOfParameterModelElements().get(0);
		Rhs rhs = ip.getAssign();
		Uniop uniop = rhs.getUniop();
		assertNotNull(uniop);
		ExpressionValue value = uniop.getValue();
		assertNotNull(value);
		assertThat(value, instanceOf(ProbabilityFunction.class));
		ProbabilityFunction pf = (ProbabilityFunction) value;
		assertEquals(ProbabilityFunctionType.PDF, pf.getType());
		assertNotNull(pf.getDistribution());
	}
	
}
