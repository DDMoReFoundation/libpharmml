package eu.ddmore.libpharmml.dom.trialdesign;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class VariableToResetTest {

	private ILibPharmML libPharmML;
	private IPharmMLResource resource7;
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource7 = libPharmML.createDom(PharmMLVersion.V0_7);
		this.resource7.setParameter(IPharmMLResource.AUTOSET_ID, false);

		LoggerWrapper.getLogger().setLevel(Level.INFO);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource7 = null;
	}
	
	@Test
	public void testMarshal() throws Exception {
		PharmML dom = resource7.getDom();
		TrialDesign td = dom.createTrialDesign();
		Interventions interventions = td.createInterventions();
		Action action = interventions.createAction();
		action.setOid("a1");
		Washout washout = action.createWashout();
		VariableToReset vtr = washout.createVariableToReset();
		vtr.setFullReset(true);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource7);
		
		assertThat(baos.toString(), containsString("<td:FullReset/>"));
		
//		System.out.println(baos);
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream("testVariableToReset.xml");
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		PharmML dom = resource.getDom();
		TrialDesign td = dom.getTrialDesign();
		Interventions interv = td.getInterventions();
		Action action1 = interv.getListOfAction().get(0);
		Washout washout1 = action1.getWashout();
		VariableToReset vtr1 = washout1.getListOfVariableToReset().get(0);
		assertTrue(vtr1.isFullReset());
		
		Action action2 = interv.getListOfAction().get(1);
		Washout washout2= action2.getWashout();
		VariableToReset vtr2 = washout2.getListOfVariableToReset().get(0);
		assertFalse(vtr2.isFullReset());
		assertNotNull(vtr2.getSymbRef());
		assertEquals("W", vtr2.getSymbRef().getSymbIdRef());
		assertEquals(Double.valueOf(70), Double.valueOf(vtr2.getResetValue().getValue()));
		assertEquals(Double.valueOf(0.1), Double.valueOf(vtr2.getResetTime().getValue()));
	}
	
}
