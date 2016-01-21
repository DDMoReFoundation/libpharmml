package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
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
import eu.ddmore.libpharmml.dom.commontypes.ObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class StatsopTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private Rhs container;
	private ObjectFactory ctof;
	
	private static final String TESTFILE = "testStatsop.xml";
	
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
	public void testMarshal() throws Exception {
		Statsop op = new Statsop(); container.setStatsop(op);
		op.setOp(Statsoperator.MEAN);
		addReal(op, 10);
		addReal(op, 4);
		addReal(op, 18);
		addReal(op, 14);
		addReal(op, 7);
		addReal(op, 1);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, containsString("<math:Statsop op=\"mean\">"));
		assertThat(output, containsString("<ct:Vector>"));

		assertValid(libPharmML.getValidator().createValidationReport(resource));
		
		libPharmML.save(System.out, resource);
	}
	
	private void addReal(Statsop op, double value){
		if(op.getRest().size() == 0){
			Vector vector = new Vector();
			op.getRest().add(ctof.createVector(vector));
			vector.createVectorElements();
		}
		((Vector) op.getRest().get(0).getValue()).getVectorElements().getListOfElements().add(new RealValue(value));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource res = libPharmML.createDomFromResource(is);
		assertValid(res.getCreationReport());
		assertValid(libPharmML.getValidator().createValidationReport(res));
		
		Rhs rhs = ((DerivativeVariable) res.getDom().getModelDefinition().getListOfStructuralModel().get(0).getListOfStructuralModelElements().get(0)).getAssign();
		assertNotNull("Rhs not null",rhs);
		Statsop statsop = rhs.getStatsop();
		assertNotNull("Statsop not null", statsop);
		assertEquals("Statsoperator is MEAN", Statsoperator.MEAN, statsop.getOp());
		assertEquals("Statsop contains 1 element",1,statsop.getRest().size());
		Vector vector = (Vector) statsop.getRest().get(0).getValue();
		assertNotNull("Vector is not null", vector);
	}

}
