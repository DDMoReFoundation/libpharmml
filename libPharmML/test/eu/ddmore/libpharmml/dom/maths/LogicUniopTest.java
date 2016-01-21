package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
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
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class LogicUniopTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private Condition container;
	
	private static final String TESTFILE = "testLogicUniOp.xml";
	
	@Before
	public void setUp() throws Exception {
		libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.createModelDefinition();
		StructuralModel sm = mdef.createStructuralModel("sm1");
		DerivativeVariable dv = sm.createDerivativeVariable("Ac", SymbolType.REAL);
		Piecewise pw = new Piecewise();
		dv.assign(pw);
		Piece piece = new Piece(); pw.getPiece().add(piece);
		container = piece.createCondition();
	}
	
	@After
	public void tearDown() throws Exception {
		this.container = null;
		this.libPharmML = null;
		this.resource = null;
	}
	
	@Test
	public void testMarshal() throws Exception {
		LogicUniOp lu = new LogicUniOp(); container.setLogicUniop(lu);
		lu.setOp("isDefined");
		ProbabilityFunction pf = TestMathObjectFactory.createValidProbabilityFunction(ProbabilityFunctionType.HF);
		lu.setProbabilityFunction(pf);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:LogicUniop op=\"isDefined\">"));
		assertThat(output, containsString("<math:HF>"));
		assertThat(output, containsString("<math:Distribution>"));
//		assertThat(output, containsString("<ct:Real>3.0</ct:Real>"));
//		assertThat(output, containsString("<ct:Real>9.0</ct:Real>"));
//		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
		
//		libPharmML.save(System.out, resource);
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(res.getCreationReport());
		assertValid(libPharmML.getValidator().createValidationReport(res));
		
		Rhs rhs = ((DerivativeVariable) res.getDom().getModelDefinition().getListOfStructuralModel().get(0).getListOfStructuralModelElements().get(0)).getAssign();
		assertNotNull("Rhs not null",rhs);
		Piecewise piecewise = rhs.getPiecewise();
		assertNotNull("Piecewise is not null", piecewise);
		Piece piece = piecewise.getPiece().get(0);
		assertNotNull("Piece is not null", piece);
		Condition condition = piece.getCondition();
		assertNotNull("Condition is not null", condition);
		LogicUniOp lu = condition.getLogicUniop();
		assertNotNull("LogicUniOp is not null", lu);
		ProbabilityFunction pf = lu.getProbabilityFunction();
		assertNotNull("ProbabilityFunction is not null", pf);
		assertEquals("PF type is HF", ProbabilityFunctionType.HF, pf.getType());
	}

}
