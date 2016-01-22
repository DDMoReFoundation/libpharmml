package eu.ddmore.libpharmml.dom.modeldefn;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.AssertUtil;
import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.maths.Condition;
import eu.ddmore.libpharmml.dom.maths.ConditionalStatement;
import eu.ddmore.libpharmml.dom.maths.ElseCondition;
import eu.ddmore.libpharmml.dom.maths.IfElseIfCondition;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicOperator;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.CompartmentMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class StructuralModelTest {
	
	private final PharmMLVersion VERSION;
	
	private final String MODEL_NAME = "StructuralModel Test";
	private static final String TESTFILE = "TestStructuralModel.xml";
	
	private ILibPharmML libPharmML;
	private ObjectFactory mdefof;
	private eu.ddmore.libpharmml.dom.commontypes.ObjectFactory ctof;
	private IPharmMLResource resource;
	private StructuralModel sm;
	
	public StructuralModelTest(PharmMLVersion version) {
		this.VERSION = version;
	}
	
	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_8}
		});
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.mdefof = MasterObjectFactory.MODELDEFN_OF;
		this.ctof = MasterObjectFactory.COMMONTYPES_OF;
		this.resource = createValidModel();
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.mdefof = null;
		this.sm = null;
		this.resource = null;
	}
	
	private IPharmMLResource createValidModel(){
		IPharmMLResource resource = libPharmML.createDom(VERSION);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		PharmML dom = resource.getDom();
		dom.createName(MODEL_NAME);
		dom.createIndependentVariable("t");
		ModelDefinition mdef = dom.createModelDefinition();
		this.sm = mdef.createStructuralModel("sm1");
		
		// DerivativeVariable
		DerivativeVariable dv = sm.createDerivativeVariable("Ac", SymbolType.REAL);
		
		// Variable
		VariableDefinition vd = sm.createVariable();
		vd.setSymbId("C");
		vd.setSymbolType(SymbolType.REAL);
		VariableDefinition vd2 = sm.createVariable();
		vd2.setSymbId("V");
		vd2.setSymbolType(SymbolType.REAL);
		
		// ConditionalStatement
		ConditionalStatement cs = sm.createConditionalStatement();
		IfElseIfCondition if1 = cs.createIf();
		Condition condition = new Condition(); if1.setCondition(condition);
		LogicBinOp logicBinop = new LogicBinOp(LogicOperator.GT); condition.setLogicBinop(logicBinop);
		logicBinop.getContent().add(ctof.createSymbRef(new SymbolRef("t")));
		logicBinop.getContent().add(ctof.createReal(new RealValue(60)));
		
		ElseCondition _else = cs.createElse();
		Parameter esleParam = new Parameter();
		esleParam.setSymbId("ElseVar");
		_else.getContent().add(esleParam);
		
		// PKMacro
		PKMacroList macroList = sm.createPKMacroList();
		CompartmentMacro comp = macroList.createCompartment();
		comp.createValue(CompartmentMacro.Arg.CMT, new Rhs(new IntValue(1)));
		comp.createValue(CompartmentMacro.Arg.AMOUNT, new Rhs(new SymbolRef(dv.getSymbId())));
		
		return resource;
	}
	
	@Test
	public void testValidationReport() throws Exception {
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testMarshalSMElements() throws Exception {		
		File tmpFile = File.createTempFile("libpharmmltest_", ".xml");
		tmpFile.deleteOnExit();
		libPharmML.save(new FileOutputStream(tmpFile), resource);
		AssertUtil.assertSameContent(new File(this.getClass().getResource(TESTFILE).toURI()), tmpFile);
	}
	
	public void testUnmarshalSMElements() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.getModelDefinition();
		StructuralModel sm = mdef.getListOfStructuralModel().get(0);
		
	}
	
	@Test
	public void testFetchers() throws Exception {
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.getModelDefinition();
		StructuralModel sm = mdef.getListOfStructuralModel().get(0);
		
		assertEquals(1, sm.fetchDerivativeVariables().size());
		assertEquals(2, sm.fetchVariables().size());
		assertEquals(1, sm.fetchConditionalStatements().size());
		assertEquals(1, sm.fetchPKMacroLists().size());
		
		// Test if immutable
		try {
			sm.fetchDerivativeVariables().add(new DerivativeVariable());
			AssertUtil.fail("Exception is not caught");
		} catch (UnsupportedOperationException e){
			System.out.println("It's caught");
		}
	}

}
