package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
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
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class ConditionalStatementTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private StructuralModel container;
	private PopulationParameter param;
	
	private static final String TESTFILE = "testConditionalStatement.xml";
	
	@Before
	public void setUp() throws Exception {
		libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		PharmML dom = resource.getDom();
		dom.createIndependentVariable("t");
		ModelDefinition mdef = dom.createModelDefinition();
		container = mdef.createStructuralModel("sm1");
		param = container.createPopulationParameter();
		param.setSymbId("p1");
	}
	
	@After
	public void tearDown() throws Exception {
		this.param = null;
		this.container = null;
		this.libPharmML = null;
		this.resource = null;
	}
	
	@Test
	public void testMarshal() throws Exception {
		ConditionalStatement cs = container.createConditionalStatement();
		IfElseIfCondition _if = cs.createIf();
		_if.setCondition(TestMathObjectFactory.createValidCondition());
		_if.createPopulationParameterRef(param).assign(new RealValue(123));
		
		IfElseIfCondition _if2 = cs.createElseIf();
		_if2.setCondition(TestMathObjectFactory.createValidCondition());
		_if2.createPopulationParameterRef(param).assign(new RealValue(456));
		
		cs.createElse();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, containsString("<math:If>"));
		assertThat(output, containsString("<math:Condition>"));
		assertThat(output, containsString("<mdef:PopulationParameter symbIdRef=\"p1\">"));
		assertThat(output, containsString("<math:Else/>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
		
		libPharmML.save(System.out, resource);
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(res.getCreationReport());
		assertValid(libPharmML.getValidator().createValidationReport(res));
		
		StructuralModel sm = res.getDom().getModelDefinition().getListOfStructuralModel().get(0);
		assertEquals("2 SM elements",2, sm.getListOfStructuralModelElements().size());
		
		Object el1 = sm.getListOfStructuralModelElements().get(0);
		assertThat(el1, instanceOf(PopulationParameter.class));
		
		Object el2 = sm.getListOfStructuralModelElements().get(1);
		assertThat(el2, instanceOf(ConditionalStatement.class));
		
		ConditionalStatement cs = (ConditionalStatement) el2;
		IfElseIfCondition _if = cs.getIf();
		assertNotNull("_If not null",_if);
		Condition condition = _if.getCondition();
		assertNotNull("condition not null", condition);
		assertEquals("1 if element",1, _if.getContent().size());
		PharmMLElement ifEl1 = _if.getContent().get(0);
		assertThat(ifEl1, instanceOf(PopulationParameter.class));
		PopulationParameter pp1 = (PopulationParameter) ifEl1;
		assertEquals("ppRef to param", param.getSymbId(), pp1.getSymbIdRef());
		
		assertEquals("1 IfElse element",1, cs.getListOfElseIf().size());
		IfElseIfCondition _ifelse = cs.getListOfElseIf().get(0);
		assertNotNull("_If not null",_ifelse);
		Condition condition2 = _ifelse.getCondition();
		assertNotNull("condition not null", condition2);
	}
}
