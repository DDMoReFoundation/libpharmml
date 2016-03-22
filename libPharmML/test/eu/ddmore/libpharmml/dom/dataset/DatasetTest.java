package eu.ddmore.libpharmml.dom.dataset;

import static eu.ddmore.libpharmml.AssertUtil.assertValid;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.maths.Condition;
import eu.ddmore.libpharmml.dom.maths.Otherwise;
import eu.ddmore.libpharmml.dom.maths.Piece;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.trialdesign.DatasetMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Observation;
import eu.ddmore.libpharmml.dom.trialdesign.Observations;
import eu.ddmore.libpharmml.dom.trialdesign.TrialDesign;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class DatasetTest {

	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	
	private static final String TESTFILE = "testDataset.xml";
	private IPharmMLResource unmarshalResource;
	
	private static final String TESTFILE_COLUMNDEF = "testColumnDefinition.xml";
	private IPharmMLResource unmarshalColumnDef;
	
	private static final String TESTFILE_PIECEWISE7 = "testPiecewise7.xml";
	private static final String TESTFILE_PIECEWISE8 = "testPiecewise8.xml";
	
	public DatasetTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		createValidDataset(this.resource);
		
//		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
//		unmarshalResource = libPharmML.createDomFromResource(is);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource = null;
		this.unmarshalResource = null;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
//				{PharmMLVersion.V0_7_3},
				{PharmMLVersion.V0_8_1}
		});
	}
	
	public DataSet createValidDataset(IPharmMLResource resource){
		PharmML dom = resource.getDom();
		dom.createIndependentVariable("t");
		
		TrialDesign td = dom.createTrialDesign();
		Observations obs = new Observations();
		td.setObservations(obs);
		DatasetMapping indObs = new DatasetMapping();
		indObs.setOid("indObs");
		
		ColumnMapping cmap = indObs.createColumnMapping();
		cmap.createColumnRef("time");
		cmap.createSymbRef("t");
		
		obs.getListOfObservationsElements().add(indObs);
		
		DataSet ds = indObs.createDataSet();
		
		HeaderColumnsDefinition def = ds.createDefinition();
		def.createHeaderDefinition("h1", HeaderType.MAIN_HEADER.value(), 1);
		def.createColumnDefinition("ID", ColumnType.ID, SymbolType.STRING, 1);
		def.createColumnDefinition("time", ColumnType.TIME, SymbolType.REAL, 2);
		ColumnDefinition cdef = def.createColumnDefinition("dv", ColumnType.DV, SymbolType.REAL, 3);
		cdef.setColumnType(ColumnType.DV,ColumnType.OCCASION);
		
		DataSetTable table = ds.createTable();
		
		HeaderRow headerRow = table.createHeaderRow(1);
		headerRow.createStringValue("header1");
		headerRow.createStringValue("header2");
		headerRow.createStringValue("header3");
		DatasetRow row1 = table.createRow();
		row1.getListOfValue().add(new StringValue("1"));
		row1.getListOfValue().add(new RealValue(1));
		row1.getListOfValue().add(new RealValue(1));
		DatasetRow row2 = table.createRow();
		row2.getListOfValue().add(new StringValue("2"));
		row2.getListOfValue().add(new RealValue(2));
		row2.getListOfValue().add(new RealValue(1.9));
		return ds;
	}
	
	private static DataSet getDataset(IPharmMLResource resource){
		PharmML dom = resource.getDom();
		TrialDesign td = dom.getTrialDesign();
		Observations obs = td.getObservations();
		DatasetMapping indObs = (DatasetMapping) obs.getListOfObservationsElements().get(0);
		return indObs.getDataSet();
	}
	
	@Test
	public void testValidate() throws Exception {
		IValidationReport report = libPharmML.getValidator().createValidationReport(resource);
		assertValid(report);
	}
	
	@Test
	public void testUnmarshalMultipleColumnTypes() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_COLUMNDEF);
		unmarshalColumnDef = libPharmML.createDomFromResource(is);
		PharmML dom = unmarshalColumnDef.getDom();
		TrialDesign td = dom.getTrialDesign();
		Observations obs = td.getObservations();
		DatasetMapping indObs = (DatasetMapping) obs.getListOfObservationsElements().get(0);
		DataSet ds = indObs.getDataSet();
		HeaderColumnsDefinition hcdef = ds.getDefinition();
		ColumnDefinition cdef = hcdef.getListOfColumn().get(2);
		List<ColumnType> types = cdef.getListOfColumnType();
		assertEquals("2 types",2 , types.size());
		assertEquals("type1=dv",ColumnType.DV, types.get(0));
		assertEquals("type2=occasion",ColumnType.OCCASION, types.get(1));
	}
	
	@Test
	public void testPiecewiseNS_DefaultVersion() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		createValidDataset(resource);
		PharmML dom = resource.getDom();
		TrialDesign td = dom.getTrialDesign();
		Observations obs = td.getObservations();
		DatasetMapping indObs = (DatasetMapping) obs.getListOfObservationsElements().get(0);
		ColumnMapping cmapping = indObs.getListOfColumnMapping().get(0);
		cmapping.setSymbRef(null);
		Piecewise pw = cmapping.createPiecewise();
		Piece p = new Piece(); pw.getPiece().add(p);
		Condition condition = new Condition(); p.setCondition(condition);
		Otherwise otherwise = new Otherwise(); condition.setOtherwise(otherwise);
		
		libPharmML.save(System.out, resource);
		IValidationReport report = libPharmML.getValidator().createValidationReport(resource);
		assertValid(report);
		
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_PIECEWISE8);
		IPharmMLResource uResource = libPharmML.createDomFromResource(is);
		PharmML udom = uResource.getDom();
		TrialDesign utd = udom.getTrialDesign();
		Observations uobs = utd.getObservations();
		DatasetMapping uindObs = (DatasetMapping) uobs.getListOfObservationsElements().get(0);
		assertNotNull(uindObs.getListOfColumnMapping().get(0).getPiecewise());
	}
	
	@Test
	public void testPiecewiseNS_Version7() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.V0_7_3);
		resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		DataSet ds = createValidDataset(resource);
		PharmML dom = resource.getDom();
		TrialDesign td = dom.getTrialDesign();
		Observations obs = td.getObservations();
		DatasetMapping indObs = (DatasetMapping) obs.getListOfObservationsElements().get(0);
		ColumnMapping cmapping = indObs.getListOfColumnMapping().get(0);
		cmapping.setSymbRef(null);
		Piecewise pw = cmapping.createPiecewise();
		Piece p = new Piece(); pw.getPiece().add(p);
		Condition condition = new Condition(); p.setCondition(condition);
		Otherwise otherwise = new Otherwise(); condition.setOtherwise(otherwise);
		
		ds.getDefinition().getListOfColumn().get(2).getListOfColumnType().remove(1);
		
		IValidationReport report = libPharmML.getValidator().createValidationReport(resource);
		assertValid(report);
		
		InputStream is = this.getClass().getResourceAsStream(TESTFILE_PIECEWISE7);
		IPharmMLResource uResource = libPharmML.createDomFromResource(is);
		PharmML udom = uResource.getDom();
		TrialDesign utd = udom.getTrialDesign();
		Observations uobs = utd.getObservations();
		DatasetMapping uindObs = (DatasetMapping) uobs.getListOfObservationsElements().get(0);
		assertNotNull(uindObs.getListOfColumnMapping().get(0).getPiecewise());
	}
	
}