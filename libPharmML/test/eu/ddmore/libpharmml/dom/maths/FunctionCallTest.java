package eu.ddmore.libpharmml.dom.maths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.FunctionDefinition;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType.FunctionArgument;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class FunctionCallTest {

	private final PharmMLVersion VERSION = PharmMLVersion.V0_7_1;

	private ILibPharmML libPharmML;
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
	}
	
	private IPharmMLResource createInvalidModel() {
		IPharmMLResource resource = libPharmML.createDom(VERSION);
		PharmML dom = resource.getDom();
		FunctionDefinition fd = dom.createFunctionDefinition("fd1", SymbolType.REAL);
		fd.createFunctionArgument("a1", SymbolType.REAL);
		fd.createFunctionArgument("a2", SymbolType.REAL);
		fd.createDefinition().assign(new Binop(Binoperator.PLUS, new SymbolRef("a1"), new SymbolRef("a2")));
		ModelDefinition mdef = dom.createModelDefinition();
		StructuralModel sm = mdef.createStructuralModel("sm1");
		VariableDefinition var = sm.createVariable("X", SymbolType.REAL);
		
		FunctionCallType fc = new FunctionCallType(fd);
		var.assign(fc);
		FunctionArgument arg1 = new FunctionArgument();
		arg1.setSymbId("a1");
		arg1.assign(new RealValue(1));
		fc.getListOfFunctionArgument().add(arg1);
		FunctionArgument arg2 = new FunctionArgument();
		arg2.setSymbId("a3");
		arg2.assign(new RealValue(1));
		fc.getListOfFunctionArgument().add(arg2);
		
		return resource;
	}
	
	@Test
	public void testMissingArgument() throws Exception {
		IValidationReport report = libPharmML.getValidator().createValidationReport(createInvalidModel());
		Assert.assertEquals(2, report.numErrors());
	}
	
}
