package eu.ddmore.libpharmml.dom.trialdesign;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.StringContains.containsString;
import static eu.ddmore.libpharmml.AssertUtil.containsRegex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.ToolName;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class ExternalDatasetTest {
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource6;
	private IPharmMLResource resource7;
	private IPharmMLResource resourceDV;
	private IPharmMLResource resourceDV_BC;
	
//	private static final String TESTFILE = "testExternalDataset.xml";
//	private IPharmMLResource unmarshalResource;
	
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource7 = libPharmML.createDom(PharmMLVersion.V0_7_3);
		this.resource7.setParameter(IPharmMLResource.AUTOSET_ID, false);
		this.resource6 = libPharmML.createDom(PharmMLVersion.V0_6);
		this.resource6.setParameter(IPharmMLResource.AUTOSET_ID, false);
		this.resourceDV = libPharmML.createDom(PharmMLVersion.DEFAULT);
		this.resourceDV.setParameter(IPharmMLResource.AUTOSET_ID, false);
		this.resourceDV_BC = libPharmML.createDom(PharmMLVersion.V0_6);
		this.resourceDV_BC.setParameter(IPharmMLResource.AUTOSET_ID, false);

		LoggerWrapper.getLogger().setLevel(Level.INFO);
//		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
//		unmarshalResource = libPharmML.createDomFromResource(is);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource7 = null;
		this.resource6 = null;
//		this.unmarshalResource = null;
	}
	
	@Test
	public void testMarshalTD() throws Exception {
		PharmML dom = resource7.getDom();
		TrialDesign td = dom.createTrialDesign();
		ExternalDataSet dataset = td.createExternalDataSet("d1", ToolName.BUGS);
		CodeInjection ci = dataset.createCodeInjection();
		GenericCode gc = ci.createTargetCode();
		gc.setCode("test code;");
		SymbolMapping smt = ci.createSymbolMapping();
		smt.setId("smt1");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource7);
		
//		System.out.println(baos);
		
		assertThat(baos.toString(), containsString("<td:ExternalDataSet toolName=\"BUGS\" oid=\"d1\">"));
		assertThat(baos.toString(), containsString("<td:CodeInjection>"));
		assertThat(baos.toString(), containsRegex("<td:SymbolMapping id=\"smt1\"/?>"));
		assertThat(baos.toString(), containsString("<td:TargetCode>"));
		assertThat(baos.toString(), containsString("<td:Code>test code;</td:Code>"));
	}
	
	@Test
	public void testUnmarshalTD() throws Exception {
		final String fileName = "testExternalDataset7.xml";
		InputStream is = this.getClass().getResourceAsStream(fileName);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		PharmML dom = resource.getDom();
		assertNotNull(dom);
		TrialDesign td = dom.getTrialDesign();
		assertNotNull(td);
		ExternalDataSet ed = td.getListOfExternalDataSet().get(0);
		assertNotNull(ed);
		CodeInjection ci = ed.getCodeInjection();
		assertNotNull(ci);
		assertEquals(1, ci.getListOfSymbolMapping().size());
		SymbolMapping sm = ci.getListOfSymbolMapping().get(0);
		assertNotNull(sm);
		GenericCode tc = ci.getTargetCode();
		assertNotNull(tc);
		assertEquals("test code;", tc.getCode());
	}
	
	@Test
	public void testMarshalMS() throws Exception {
		PharmML dom = resource6.getDom();
		TrialDesign td = dom.createTrialDesign();
		ExternalDataSet dataset = td.createExternalDataSet("d1", ToolName.BUGS);
		CodeInjection ci = dataset.createCodeInjection();
		GenericCode gc = ci.createTargetCode();
		gc.setCode("test code;");
		SymbolMapping smt = ci.createSymbolMapping();
		smt.setId("smt1");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource6);
		
//		System.out.println(baos);
		
		assertThat(baos.toString(), containsString("<td:ExternalDataSet toolName=\"BUGS\" oid=\"d1\">"));
		assertThat(baos.toString(), containsString("<msteps:CodeInjection>"));
		assertThat(baos.toString(), containsRegex("<msteps:SymbolMapping id=\"smt1\"/?>"));
		assertThat(baos.toString(), containsString("<msteps:TargetCode>"));
		assertThat(baos.toString(), containsString("<msteps:Code>test code;</msteps:Code>"));
	}
	
	@Test
	public void testUnmarshalMS() throws Exception {
		final String fileName = "testExternalDataset6.xml";
		InputStream is = this.getClass().getResourceAsStream(fileName);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		PharmML dom = resource.getDom();
		assertNotNull(dom);
		TrialDesign td = dom.getTrialDesign();
		assertNotNull(td);
		ExternalDataSet ed = td.getListOfExternalDataSet().get(0);
		assertNotNull(ed);
		CodeInjection ci = ed.getCodeInjection();
		assertNotNull(ci);
		assertEquals(1, ci.getListOfSymbolMapping().size());
		SymbolMapping sm = ci.getListOfSymbolMapping().get(0);
		assertNotNull(sm);
		GenericCode tc = ci.getTargetCode();
		assertNotNull(tc);
		assertEquals("test code;", tc.getCode());
	}
	
	@Test
	public void testMarshalDVMappingBC() throws Exception {
		PharmML dom = resourceDV_BC.getDom();
		TrialDesign td = dom.createTrialDesign();
		ExternalDataSet dataset = td.createExternalDataSet("d1", ToolName.MONOLIX);
		
		MultipleDVMapping dvm = new MultipleDVMapping();
		dataset.getListOfColumnMappingOrColumnTransformationOrMultipleDVMapping().add(dvm);
		
		MultipleDVMapping dep_dvm = new MultipleDVMapping();
		dataset.getListOfColumnMappingOrColumnTransformationOrMultipleDVMapping().add(dep_dvm);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resourceDV_BC);
		
//		System.out.print(baos);
		
//		assertThat(baos.toString(), containsString("<td:MultipleDVMapping/>"));
		assertThat(baos.toString(), containsRegex("<msteps:MultipleDVMapping/?>"));
	}
	
	@Test
	public void testMarshalDVMapping() throws Exception {
		PharmML dom = resourceDV.getDom();
		TrialDesign td = dom.createTrialDesign();
		ExternalDataSet dataset = td.createExternalDataSet("d1", ToolName.MONOLIX);
		
		MultipleDVMapping dvm = new MultipleDVMapping();
		dataset.getListOfColumnMappingOrColumnTransformationOrMultipleDVMapping().add(dvm);
		
		MultipleDVMapping dep_dvm = new MultipleDVMapping();
		dataset.getListOfColumnMappingOrColumnTransformationOrMultipleDVMapping().add(dep_dvm);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resourceDV);
		
//		System.out.print(baos);
		
		assertThat(baos.toString(), containsRegex("<td:MultipleDVMapping/?>"));
//		assertThat(baos.toString(), containsString("<msteps:MultipleDVMapping/>"));
	}
	
	@Test
	public void testUnmarshalDVMappingBC() throws Exception {
		final String fileName = "testExternalDatasetDVBC.xml";
		InputStream is = this.getClass().getResourceAsStream(fileName);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		PharmML dom = resource.getDom();
		assertNotNull(dom);
		TrialDesign td = dom.getTrialDesign();
		assertNotNull(td);
		ExternalDataSet ed = td.getListOfExternalDataSet().get(0);
		assertNotNull(ed);
		
		List<PharmMLRootType> mappings = ed.getListOfColumnMappingOrColumnTransformationOrMultipleDVMapping();
		assertEquals(1, mappings.size());
		assertThat(mappings.get(0), instanceOf(MultipleDVMapping.class));
	}
	
}
