package eu.ddmore.libpharmml.dom.maths;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.TestDomFactory;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.trialdesign.Stage;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class LogicBinopTest {
	
	private ILibPharmML libPharmML;
	
	private final static String TESTFILE_STAGE = "testLogicBinOp_Stage.xml";
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
	}
	
	@Test
	public void testValidateStage() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		Piecewise pw = TestDomFactory.createPiecewise(resource);
		pw.createPiece(new Condition(new LogicBinOp(LogicOperator.EQ, new Stage(), new IntValue(1))), new RealValue(0));
		pw.createPiece(new Condition(new Otherwise()), new RealValue(1));
		
		libPharmML.save(System.out, resource);
		
		assertValid(libPharmML.getValidator().createValidationReport(resource));
	}
	
	@Test
	public void testUnmarshalStage() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_STAGE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		Piecewise pw = ((DerivativeVariable) resource.getDom().getModelDefinition().getListOfStructuralModel().get(0).getListOfStructuralModelElements().get(0)).getAssign().getPiecewise();
		assertNotNull(pw);
		Piece p = pw.getListOfPiece().get(0);
		LogicBinOp logicBinop = p.getCondition().getLogicBinop();
		JAXBElement<?> jaxbEl = logicBinop.getContent().get(0);
		QName qname = jaxbEl.getName();
		assertEquals("Name is Stage", "Stage", qname.getLocalPart());
		assertThat("Object is stage", jaxbEl.getValue(), IsInstanceOf.instanceOf(Stage.class));
	}

}