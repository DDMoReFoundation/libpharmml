package eu.ddmore.libpharmml.dom.commontypes;

import static eu.ddmore.libpharmml.AssertUtil.assertAssignValue;
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

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class IntervalTest {

	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private VariableDefinition var;
	
	private static final String TESTFILE = "testInterval.xml";
	
	public IntervalTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		PharmML dom = resource.getDom();
		ModelDefinition mdef = dom.createModelDefinition();
		StructuralModel sm = mdef.createStructuralModel("sm1");
		
		var = sm.createVariable("var1", SymbolType.REAL);
	}
	
	@After
	public void tearDown() throws Exception {
		this.var = null;
		this.libPharmML = null;
		this.resource = null;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_7}
		});
	}
	
	@Test
	public void testMarshal() throws Exception {
		Interval interval = new Interval();
		StandardAssignable length = interval.createIntervalLength();
		length.assign(new IntValue(20));
		
		Endpoint left = interval.createLeftEndpoint();
		Endpoint right = interval.createRightEndpoint();
		
		left.assign(new IntValue(10));
		right.assign(new IntValue(30));
		
		left.setType(EndpointType.OPEN);
		
		var.assign(interval);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		libPharmML.save(baos, resource);
		
		assertThat(baos.toString(), containsString("<ct:Interval>"));
		assertThat(baos.toString(), containsString("<ct:LeftEndpoint type=\"open\">"));
		assertThat(baos.toString(), containsString("ct:RightEndpoint"));
		assertThat(baos.toString(), containsString("<ct:Int>20</ct:Int>"));
		assertThat(baos.toString(), containsString("<ct:Int>10</ct:Int>"));
		assertThat(baos.toString(), containsString("<ct:Int>30</ct:Int>"));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource testResource = libPharmML.createDomFromResource(is);
		
		Interval interval = ((VariableDefinition) testResource.getDom().getModelDefinition()
				.getListOfStructuralModel().get(0).getCommonVariable().get(0).getValue()).getAssign().getInterval();
		
		assertNotNull(interval);
		assertNotNull(interval.getIntervalLength());
		assertAssignValue(20, interval.getIntervalLength().getAssign());
		
		Endpoint left = interval.getLeftEndpoint();
		assertAssignValue(10, left.getAssign());
		assertEquals(EndpointType.OPEN, left.getType());
		
		Endpoint right = interval.getRightEndpoint();
		assertAssignValue(30, right.getAssign());
		assertEquals(EndpointType.CLOSED, right.getType()); // default
	}
	
	
}
