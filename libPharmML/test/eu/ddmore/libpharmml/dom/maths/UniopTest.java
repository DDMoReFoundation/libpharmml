package eu.ddmore.libpharmml.dom.maths;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
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
	private eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory of = MasterObjectFactory.MODELDEFN_OF;
	
	private static final String TESTFILE = "testUniop.xml";
	
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
				{PharmMLVersion.V0_7_1}
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
		if(VERSION.isEqualOrLaterThan(PharmMLVersion.V0_7_1)){
			addLogPopParam(pm, "param1", new RealValue(33));
			addLogPopParam(pm, "param2", new Binop(Binoperator.PLUS, new IntValue(1), new IntValue(2)));
			addLogPopParam(pm, "param3", new Constant(ConstantOperator.PI));
		} else {
			SimpleParameter sp = new SimpleParameter();
			sp.setSymbId("param1");
			sp.assign(new Uniop(Unioperator.LOG, new RealValue(33)));
			pm.getCommonParameterElement().add(of.createSimpleParameter(sp));
			// A SM is mandatory in this version
			StructuralModel sm =mdef.createStructuralModel("sm1");
			sm.createDerivativeVariable("Ac", SymbolType.REAL);
		}
		
		libPharmML.save(System.out, resource);
		
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	private void addLogPopParam(ParameterModel pm, String name, ExpressionValue value){
		PopulationParameter pp = new PopulationParameter();
		pp.setSymbId(name);
		pp.assign(new Uniop(Unioperator.LOG, value));
		pm.getCommonParameterElement().add(of.createPopulationParameter(pp));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		if(VERSION.equals(PharmMLVersion.V0_7_1)){
			ModelDefinition mdef = resource.getDom().getModelDefinition();
			ParameterModel pm = mdef.getListOfParameterModel().get(0);
			validate((PopulationParameter) pm.getCommonParameterElement().get(0).getValue(), 
					RealValue.class, "param1");
			validate((PopulationParameter) pm.getCommonParameterElement().get(1).getValue(), 
					Binop.class, "param2");
			validate((PopulationParameter) pm.getCommonParameterElement().get(2).getValue(), 
					Constant.class, "param3");
		}
	}
	
	private void validate(PopulationParameter param,Class<?> type,String name){
		assertEquals(name, param.getSymbId());
		assertThat(param.getAssign().getUniop().getValue(), instanceOf(type));
	}
	
}
