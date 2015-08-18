package eu.ddmore.libpharmml.dom.commontypes;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static eu.ddmore.libpharmml.AssertUtil.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.hamcrest.core.IsInstanceOf;
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
public class VectorTest {

	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private VariableDefinition var1;
	private VariableDefinition var2;
	
	private static final String TESTFILE = "testVector.xml";
	private IPharmMLResource unmarshalResource;
	
	public VectorTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	private static VectorValue[] generateArrayOfValues(){
		return new VectorValue[]{new IntValue(1),new IntValue(2),new IntValue(3)};
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		StructuralModel sm = this.resource.getDom().createModelDefinition().createStructuralModel("sm1");
		this.var1 = sm.createVariable("var1", SymbolType.REAL);
		this.var2 = sm.createVariable("var2", SymbolType.REAL);
		
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		unmarshalResource = libPharmML.createDomFromResource(is);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource = null;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_7_1}
		});
	}
	
	@Test
	public void testMarshalVectorElements() throws Exception {
		Vector vector = new Vector(77, 10);
		VectorElements ve = vector.createVectorElements();
		ve.createMissingValue(MissingValueSymbol.ALQ);
		ve.createIntValue(20);
		ve.createRealValue(23.3);
		ve.createStringValue("stringvalue");
		
		var1.assign(vector);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		System.out.print(baos);
		
		assertThat(baos.toString(), containsString("<ct:Vector default=\"77.0\" length=\"10\">"));
		assertThat(baos.toString(), containsString("<ct:ALQ/>"));
		assertThat(baos.toString(), containsString("<ct:Int>20</ct:Int>"));
		assertThat(baos.toString(), containsString("<ct:Real>23.3</ct:Real>"));
		assertThat(baos.toString(), containsString("<ct:String>stringvalue</ct:String>"));
	}
	
	@Test
	public void testMarshalVectorCellAndSegment() throws Exception {
		Vector vector = new Vector(77, 10);
		vector.createVectorCell(1, false);
		vector.createVectorCell(2, 36);
		vector.createVectorCell(3, "stringvalue");
		vector.createVectorCell(4, new IdValue("an_id"));
		
		VectorCell cell = new VectorCell();
		cell.setValue(new RealValue(89));
		cell.setVectorIndex(new MatrixVectorIndex(5));
		vector.getListOfVectorCellAndSegment().add(cell);
		
		vector.createVectorSegment(1, 10, 0, generateArrayOfValues());
		
		VectorSegment segment = new VectorSegment();
		segment.setDefaultValue(0);
		segment.setStartIndex(new MatrixVectorIndex(1));
		segment.setSegmentLength(new MatrixVectorIndex(10));
		segment.createVectorElements(generateArrayOfValues());
		vector.getListOfVectorCellAndSegment().add(segment);
		
		var2.assign(vector);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		System.out.print(baos);
	}
	
	private VariableDefinition fetchVariable(IPharmMLResource resource, int i){
		PharmML dom = resource.getDom();
		assertNotNull(dom);
		ModelDefinition mdef = dom.getModelDefinition();
		assertNotNull(mdef);
		assertNotNull(mdef.getListOfStructuralModel());
		StructuralModel sm = mdef.getListOfStructuralModel().get(0);
		JAXBElement<?> jaxb_var = sm.getCommonVariable().get(i);
		Object var = jaxb_var.getValue();
		assertThat(var, IsInstanceOf.instanceOf(VariableDefinition.class));
		return (VariableDefinition) var;
	}
	
	@Test
	public void testUnmarshalCellAndSegment() throws Exception {
		VariableDefinition var = fetchVariable(unmarshalResource, 1);
		assertEquals("var2", var.getSymbId());
		assertNotNull(var.getAssign());
		Vector vector = var.getAssign().getVector();
		assertNotNull(vector);
		
		assertVectorCell(1, new FalseBoolean(), vector.getListOfVectorCellAndSegment().get(0));
		assertVectorCell(2, new IntValue(36), vector.getListOfVectorCellAndSegment().get(1));
		assertVectorCell(3, new StringValue("stringvalue"), vector.getListOfVectorCellAndSegment().get(2));
		assertVectorCell(4, new IdValue("an_id"), vector.getListOfVectorCellAndSegment().get(3));
		assertVectorCell(5, new RealValue(89), vector.getListOfVectorCellAndSegment().get(4));
		
		assertVectorSegment(Double.valueOf(0), 1, 10, generateArrayOfValues(), vector.getListOfVectorCellAndSegment().get(5));
		assertVectorSegment(Double.valueOf(0), 1, 10, generateArrayOfValues(), vector.getListOfVectorCellAndSegment().get(6));
	}
	
	private static void assertVectorCell(int expectedIndex, Scalar expectedValue, Object actual){
		assertNotNull(actual);
		assertThat(actual, IsInstanceOf.instanceOf(VectorCell.class));
		VectorCell cell = (VectorCell) actual;
		assertNotNull(cell.getIndex());
		assertEquals(expectedIndex, cell.getIndex().getIntValue().getValue().intValue());
		assertNotNull(cell.getValue());
		assertThat(cell.getValue(), IsInstanceOf.instanceOf(expectedValue.getClass()));
		assertEquals(expectedValue.valueToString(), ((Scalar)cell.getValue()).valueToString());
	}
	
	private static void assertVectorSegment(Double _default, int startIndex, int length, VectorValue[] values, Object actual){
		assertNotNull(actual);
		assertThat(actual, IsInstanceOf.instanceOf(VectorSegment.class));
		VectorSegment segment = (VectorSegment) actual;
		assertEquals(_default, segment.getDefaultValue());
		assertNotNull(segment.getStartIndex());
		assertNotNull(segment.getStartIndex().getIntValue());
		assertEquals(startIndex, segment.getStartIndex().getIntValue().getValue().intValue());
		assertNotNull(segment.getSegmentLength());
		assertNotNull(segment.getSegmentLength().getIntValue());
		assertEquals(length, segment.getSegmentLength().getIntValue().getValue().intValue());
		
		assertNotNull(segment.getVectorElements());
		VectorElements ve = segment.getVectorElements();
		List<VectorValue> list = ve.getListOfElements();
		assertEquals(values.length, list.size());
		for(int i = 0;i<list.size();i++){
			assertVectorValueEquals(values[i], list.get(i));
		}
	}
	
	
	
}
