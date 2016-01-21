package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.ObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class BinopTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private Rhs container;
	private ObjectFactory ctof;
	
	private static final String TESTFILE_PROBAFUNCTION = "testBinopProbaFunction.xml";
	
	@Before
	public void setUp() throws Exception {
		libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		ctof = ObjectFactory.getInstance();
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.createModelDefinition();
		StructuralModel sm = mdef.createStructuralModel("sm1");
		DerivativeVariable dv = sm.createDerivativeVariable("Ac", SymbolType.REAL);
		container = ctof.createRhs();
		dv.setAssign(container);
	}
	
	@After
	public void tearDown() throws Exception {
		this.ctof = null;
		this.container = null;
		this.libPharmML = null;
		this.resource = null;
	}
	
	@Test
	public void testMarshalProbaFunction() throws Exception {
		Binop binop = new Binop(Binoperator.DIVIDE, new RealValue(1), TestMathObjectFactory.createValidProbabilityFunction(ProbabilityFunctionType.CDF));
		container.setBinop(binop);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:Binop op=\"divide\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<math:CDF>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testUnmarshalProbaFunction() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_PROBAFUNCTION);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(res.getCreationReport());
		assertValid(libPharmML.getValidator().createValidationReport(res));
		
		Rhs rhs = ((DerivativeVariable) res.getDom().getModelDefinition().getListOfStructuralModel().get(0).getListOfStructuralModelElements().get(0)).getAssign();
		assertNotNull("Rhs not null",rhs);
		Binop binop = rhs.getBinop();
		assertNotNull(binop);
		Operand op1 = binop.getOperand1();
		assertNotNull(op1);
		assertThat(op1, instanceOf(RealValue.class));
		Operand op2 = binop.getOperand2();
		assertNotNull(op2);
		assertThat(op2, instanceOf(ProbabilityFunction.class));
		ProbabilityFunction pf = (ProbabilityFunction) op2;
		assertEquals(ProbabilityFunctionType.CDF, pf.getType());
	}

}
