package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;

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
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;


public class NaryopTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private Rhs container;
	private ObjectFactory ctof;
	
	private static final String TESTFILE = "testNaryop.xml";
	
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
	
	private static Naryop createValidNaryop(){
		return TestMathObjectFactory.createValidNaryop();
	}
	
	@Test
	public void testMarshal() throws Exception {
		container.clearContent();
		container.setNaryop(createValidNaryop());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		String output = baos.toString();
		assertThat(output, not(containsString("<math:Equation>")));
		assertThat(output, containsString("<math:Naryop op=\"max\">"));
		assertThat(output, containsString("<ct:Real>1.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>7.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>3.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>9.0</ct:Real>"));
		assertThat(output, containsString("<ct:Real>2.0</ct:Real>"));

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
		Naryop naryop = rhs.getNaryop();
		assertNotNull("Naryop not null", naryop);
		assertEquals("Naryoperator is MAX", Naryoperator.MAX, naryop.getOp());
		Vector vector = (Vector) naryop.getContent().get(0);
		assertNotNull("Vector is not null", vector);
		VectorElements ve = vector.getVectorElements();
		assertNotNull("VectorElements is not null", ve);
	}

}
