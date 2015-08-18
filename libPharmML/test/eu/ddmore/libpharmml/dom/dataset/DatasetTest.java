package eu.ddmore.libpharmml.dom.dataset;

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
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.commontypes.VectorValue;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.trialdesign.ContinuousObservation;
import eu.ddmore.libpharmml.dom.trialdesign.DatasetMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Observations;
import eu.ddmore.libpharmml.dom.trialdesign.TrialDesign;
import eu.ddmore.libpharmml.impl.LibPharmMLImpl;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class DatasetTest {

	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	
	private static final String TESTFILE = "testDataset.xml";
	private IPharmMLResource unmarshalResource;
	
	public DatasetTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);

		
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
				{PharmMLVersion.V0_7_1}
		});
	}
	
	@Test
	public void testMarshal() throws Exception {
		IPharmMLResource resource = libPharmML.createDom(VERSION);
		PharmML dom = resource.getDom();
		
		TrialDesign td = dom.createTrialDesign();
		Observations obs = new Observations();
		td.setObservations(obs);
		DatasetMapping indObs = new DatasetMapping();
		obs.getListOfIndividualObservations().add(indObs);
		
		DataSet ds = indObs.createDataSet();
		
		HeaderColumnsDefinition def = ds.createDefinition();
		def.createHeaderDefinition("h1", HeaderType.MAIN_HEADER.value(), 1);
		def.createColumnDefinition("ID", ColumnType.ID, SymbolType.STRING, 1);
		def.createColumnDefinition("time", ColumnType.TIME, SymbolType.REAL, 2);
		def.createColumnDefinition("dv", ColumnType.DV, SymbolType.REAL, 3);
		
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
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		System.out.println(baos);
	}
	
}