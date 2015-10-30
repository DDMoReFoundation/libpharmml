package eu.ddmore.libpharmml.dom.modellingsteps;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.AssertUtil;
import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.ConstantOperator;
import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.MatrixUnioperator;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class OptimalDesignTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private IPharmMLResource unmarshalResource;
	
	private static final String TESTFILE = "testOptimalDesign.xml";
	
	private static final PharmMLVersion VERSION = PharmMLVersion.V0_7_1;
	
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
		
		libPharmML.save(System.out, resource);
	}
	
	@Test
	public void testValidateUnmarshal() throws Exception {
		AssertUtil.assertValid(unmarshalResource.getCreationReport());
		AssertUtil.assertValid(libPharmML.getValidator().createValidationReport(unmarshalResource));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		PharmML dom = unmarshalResource.getDom();
		
		ModellingSteps msteps = dom.getModellingSteps();
		assertNotNull(msteps);
		TargetTool tt = msteps.getTargetTool().get(0);
		assertEquals("tTool", tt.getOid());
		assertEquals("PFIM", tt.getTargetToolName());
		
		OptimalDesignStep odstep = msteps.getListOfOptimalDesignStep().get(0);
		assertEquals("evaTask1", odstep.getOid());
		
		TargetToolReference ttRef = odstep.getTargetToolReference();
		assertNotNull(ttRef);
		assertEquals("tTool", ttRef.getOidRef().getOidRef());
		
		OptimiseOn optimiseOn = odstep.getOptimiseOn();
		assertNotNull(optimiseOn);
		
		assertEmptyAssignable(optimiseOn.getArmSize());
		assertAssignable(optimiseOn.getDoseAmount(), 100.0);
		assertEmptyAssignable(optimiseOn.getDosingTimes());
		assertEmptyAssignable(optimiseOn.getDuration());
		assertEmptyAssignable(optimiseOn.getNumberArms());
		assertAssignable(optimiseOn.getNumberSamples(), 20.0);
		assertEmptyAssignable(optimiseOn.getNumberTimes());
		assertEmptyAssignable(optimiseOn.getObservationTimes());
		
		FIM fim = odstep.getFIM();
		assertEquals("FIM1", fim.getSymbId());
		assertNotNull(fim.getMatrix());
		
		Method method = odstep.getMethod();
		CriterionDef criterion = method.getCriterion();
		assertNotNull(criterion);
		assertEquals(Criterion.A,criterion.getType());
		
		FIMfunction fimFunction = method.getFIMfunction();
		assertNotNull(fimFunction);
		assertEquals(BuiltInFIMfct.TR_INV,fimFunction.getType());
		Rhs assign = fimFunction.getAssign();
		assertNotNull(assign);
		Object content = assign.getContent();
		assertThat(content, instanceOf(MatrixUniOp.class));
		MatrixUniOp matrixUniop = (MatrixUniOp) content;
		assertEquals(MatrixUnioperator.TRACE, matrixUniop.getOp());
		ExpressionValue value = matrixUniop.getValue();
		assertThat(value, instanceOf(MatrixUniOp.class));
		MatrixUniOp matrixUniop2 = (MatrixUniOp) value;
		assertEquals(MatrixUnioperator.INVERSE, matrixUniop2.getOp());
		ExpressionValue value2 = matrixUniop2.getValue();
		assertThat(value2, instanceOf(SymbolRef.class));
		
		ComputeFIM computeFIM = method.getComputeFIM();
		assertNotNull(computeFIM);
		assertEquals(ComputeAlgo.FO, computeFIM.getType());
		
		ApproximateFIM approxFIM = method.getApproximateFIM();
		assertNotNull(approxFIM);
		assertEquals(ApproxAlgo.FULL, approxFIM.getType());
		
		TypeFIM typeFIM = method.getTypeFIM();
		assertNotNull(typeFIM);
		assertEquals(TypeFIMType.POPULATION, typeFIM.getType());
		
		DesignType designType = method.getDesignType();
		assertNotNull(designType);
		assertEquals(Optimisation.EXACT, designType.getType());
		
		OptimisationAlgorithm optimAlgo = method.getOptimizationAlgorithm();
		assertNotNull(optimAlgo);
		assertEquals(OptimAlgo.FEDOROV_WYNN, optimAlgo.getType());
		
		
		Cost cost = odstep.getCost();
		assertNotNull(cost);
		StandardAssignable totalCost = cost.getTotalCost();
		assertNotNull(totalCost);
		AssertUtil.assertAssignValue(1.3, totalCost.getAssign());
		CostFunction costFunction = cost.getCostFunction();
		assertNotNull(costFunction);
		assertEquals(CostList.SAMPLE, costFunction.getType());
		
		Prior priorInfo = odstep.getPriorInformation();
		assertNotNull(priorInfo);
		assertNotNull(priorInfo.getMatrix());
		
		Compute compute = odstep.getCompute();
		assertAssignable(compute.getGraphOnly(), Boolean.FALSE);
		assertAssignable(compute.getPowerComparison(), Boolean.TRUE);
		assertAssignable(compute.getNSubjectComparison(), Boolean.TRUE);
		assertAssignable(compute.getPowerEquivalence(), 0.8);
		assertAssignable(compute.getNSubjectEquivalence(), Boolean.TRUE);
		StandardAssignable equiv = compute.getEquivalenceRange();
		assertNotNull(equiv);
		assertNotNull(equiv.getAssign());
		assertThat(equiv.getAssign().getContent(), instanceOf(Interval.class));
		assertAssignable(compute.getTypeIError(), 0.05);
		assertAssignable(compute.getTypeIIError(), 0.9);
		SoftwareSettings ss = odstep.getSoftwareSettings();
		assertNotNull(ss);
		assertNotNull(ss.getFile());
		
		OptimalDesignOperation operation1 = odstep.getListOfOperation().get(0);
		assertEquals(OptimalDesignOpType.EVALUATION, operation1.getOpType());
		assertEquals(Integer.valueOf(1), operation1.getOrder());
		OperationProperty prop0 = operation1.getListOfProperty().get(0);
		assertEquals("RtolEq", prop0.getName());
		assertAssignable(prop0, 1e-06);
		OperationProperty prop1 = operation1.getListOfProperty().get(1);
		assertEquals("AtolEq", prop1.getName());
		assertAssignable(prop1, 1e-06);
		OperationProperty prop2 = operation1.getListOfProperty().get(2);
		assertEquals("graph.logical", prop2.getName());
		assertAssignable(prop2, Boolean.TRUE);
		OperationProperty prop3 = operation1.getListOfProperty().get(3);
		assertEquals("log.logical", prop3.getName());
		assertAssignable(prop3, "\'y\'");
		OperationProperty prop4 = operation1.getListOfProperty().get(4);
		assertEquals("graph.only", prop4.getName());
		assertAssignable(prop4, 0.0);
		OperationProperty prop5 = operation1.getListOfProperty().get(5);
		assertEquals("y.range", prop5.getName());
		assertAssignable(prop5, Interval.class);
	}
	
	private static void assertEmptyAssignable(Assignable sa){
		assertNotNull(sa);
		assertNull(sa.getAssign());
	}
	
	private static void assertAssignable(Assignable sa, Class<?> _class){
		assertNotNull(sa);
		assertNotNull(sa.getAssign());
		assertThat(sa.getAssign().getContent(), instanceOf(_class));
	}
	
	private static void assertAssignable(Assignable sa, Double expected){
		assertNotNull(sa);
		AssertUtil.assertAssignValue(expected, sa.getAssign());
	}
	
	private static void assertAssignable(Assignable sa, Boolean expected){
		assertNotNull(sa);
		AssertUtil.assertAssignValue(expected, sa.getAssign());
	}
	
	private static void assertAssignable(Assignable sa, String expected){
		assertNotNull(sa);
		AssertUtil.assertAssignValue(expected, sa.getAssign());
	}

}
