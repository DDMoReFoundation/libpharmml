package eu.ddmore.libpharmml.dom.commontypes;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Binoperator;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.ConstantOperator;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLVersion;


public class RhsTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private IPharmMLResource old_resource;
	
	DerivativeVariable container;
	DerivativeVariable old_container;
	
	private static final String TESTFILE = "testRhs.xml";
	private static final String TESTFILE_OLD = "testRhs_old.xml";
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		this.old_resource = libPharmML.createDom(PharmMLVersion.V0_6);
		this.old_resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.createModelDefinition();
		StructuralModel sm = mdef.createStructuralModel("sm1");
		container = sm.createDerivativeVariable("Ac", SymbolType.REAL);
		
		PharmML old_dom = old_resource.getDom();
		ModelDefinition old_mdef = old_dom.createModelDefinition();
		StructuralModel old_sm = old_mdef.createStructuralModel("sm1");
		old_container = old_sm.createDerivativeVariable("Ac", SymbolType.REAL);
		
		LoggerWrapper.getLogger().setLevel(Level.ALL);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.old_resource = null;
		this.resource = null;
	}
	
	@Test
	public void testMarshalBinopDefault() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setBinop(new Binop(Binoperator.PLUS, new RealValue(1), new RealValue(2)));
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:Binop op=\"plus\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalBinopDefaultWithEquation() throws Exception {
		Rhs rhs = new Rhs();
		Equation eq = new Equation();
		eq.setBinop(new Binop(Binoperator.PLUS, new RealValue(1), new RealValue(2)));
		rhs.setEquation(eq);;
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:Binop op=\"plus\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalBinopOld() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setBinop(new Binop(Binoperator.PLUS, new RealValue(1), new RealValue(2)));
		old_container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, old_resource);
		
		String output = baos.toString();
		assertThat(output, containsString("<math:Equation>"));
		assertThat(output, containsString("<math:Binop op=\"plus\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));
		
		assertValid(libPharmML.getValidator().createValidationReport(old_resource));
	}
	
	@Test
	public void testMarshalBinopOldWithEquation() throws Exception {
		Rhs rhs = new Rhs();
		Equation eq = new Equation();
		eq.setBinop(new Binop(Binoperator.PLUS, new RealValue(1), new RealValue(2)));
		rhs.setEquation(eq);;
		old_container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, old_resource);
		
		String output = baos.toString();
		assertThat(output, containsString("<math:Equation>"));
		assertThat(output, containsString("<math:Binop op=\"plus\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));
		
		assertValid(libPharmML.getValidator().createValidationReport(old_resource));
	}
	
	@Test
	public void testUnmarshalBinop07() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(libPharmML.getValidator().createValidationReport(old_resource));
		
		assertNotNull(((DerivativeVariable) res.getDom().getModelDefinition().
				getListOfStructuralModel().get(0).getCommonVariable().get(0).
				getValue()).getAssign().getBinop());
	}
	
	@Test
	public void testUnmarshalBinop06() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_OLD);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(libPharmML.getValidator().createValidationReport(old_resource));
		
		assertNotNull(((DerivativeVariable) res.getDom().getModelDefinition().
				getListOfStructuralModel().get(0).getCommonVariable().get(0).
				getValue()).getAssign().getBinop());
	}
	
	@Test
	public void testMarshalScalarDefault() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setScalar(new IntValue(10));
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<ct:Int>10</ct:Int>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalSymbolRefDefault() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setSymbRef(new SymbolRef("Ac"));
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<ct:SymbRef symbIdRef=\"Ac\"/>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalVectorDefault() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setVector(new Vector(new VectorValue[]{new IntValue(0),new IntValue(4)},2));
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<ct:Vector"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalConstantDefault() throws Exception {
		Rhs rhs = new Rhs();
		rhs.setConstant(new Constant(ConstantOperator.PI));
		container.setAssign(rhs);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:Constant op=\"pi\"/>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
}
