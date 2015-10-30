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
import eu.ddmore.libpharmml.dom.commontypes.Matrix.Type;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class MatrixTest {

private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private VariableDefinition var;
	
	private static final String TESTFILE = "testMatrix.xml";
	
	public MatrixTest(PharmMLVersion version){
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		this.var = this.resource.getDom().createModelDefinition().createStructuralModel("sm1")
			.createVariable("var1", SymbolType.REAL);
	}
	
	@After
	public void tearDown() throws Exception {
		this.libPharmML = null;
		this.resource = null;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		
		return Arrays.asList(new Object[][] {
				{PharmMLVersion.V0_7_3}
		});
	}
	
	@Test
	public void testMarshal() throws Exception {
		Matrix matrix = new Matrix(Type.ANY, 10, 16);
		matrix.createMatrixRow(new MatrixRowValue[]{new IntValue(1), new RealValue(23.2)});
		matrix.createMatrixBlock(new MatrixVectorIndex(3), new MatrixVectorIndex(4));
		
		MatrixColumn column = matrix.createMatrixColumn();
		column.getListOfValues().add(new IntValue(10));
		column.getListOfValues().add(new RealValue(432.74));
		column.getListOfValues().add(new SymbolRef("foo"));
		column.getListOfValues().add(new MissingValue(MissingValueSymbol.NaN));
		
		MatrixRow row = matrix.createMatrixRow(new MatrixVectorIndex(6), 34);
		row.getListOfValues().add(new IntValue(10));
		row.getListOfValues().add(new RealValue(432.74));
		row.getListOfValues().add(new SymbolRef("foo"));
		row.getListOfValues().add(new MissingValue(MissingValueSymbol.NaN));
		
		var.assign(matrix);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		
		System.out.println(baos);
		
		assertThat(baos.toString(),
				containsString("<ct:Matrix numbCols=\"10\" numbRows=\"16\" matrixType=\"Any\">"));
		assertThat(baos.toString(),
				containsString("<ct:MatrixRow>[\\r\\n\\s]*"+
                            "<ct:Int>1</ct:Int>[\\r\\n\\s]*"+
                            "<ct:Real>23.2</ct:Real>[\\r\\n\\s]*"+
                        "</ct:MatrixRow>"));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		VariableDefinition variable = (VariableDefinition) resource.getDom().getModelDefinition()
				.getListOfStructuralModel().get(0).getCommonVariable().get(0).getValue();
		
		assertNotNull(variable.getAssign());
		assertNotNull(variable.getAssign().getMatrix());
		Matrix matrix = variable.getAssign().getMatrix();
		
		assertEquals(10, matrix.getNumbCols().intValue());
		assertEquals(16, matrix.getNumbRows().intValue());
		assertEquals(Matrix.Type.ANY.toString(), matrix.getMatrixType());
		
		MatrixRow row1 = (MatrixRow) matrix.getListOfMatrixElements().get(0);
		IntValue row1_value1 = (IntValue) row1.getListOfValues().get(0);
		assertEquals(1, row1_value1.getValue().intValue());
		RealValue row1_value2 = (RealValue) row1.getListOfValues().get(1);
		assertEquals(Double.valueOf(23.2), Double.valueOf(row1_value2.getValue()));
		
		MatrixBlock block = (MatrixBlock) matrix.getListOfMatrixElements().get(1);
		IntValue startRow = block.getBlockStartRow().getIntValue();
		assertEquals(3, startRow.getValue().intValue());
		IntValue startCol = block.getBlockStartColumn().getIntValue();
		assertEquals(4, startCol.getValue().intValue());
		
		MatrixColumn column = (MatrixColumn) matrix.getListOfMatrixElements().get(2);
		assertScalarEquals(10, (IntValue) column.getListOfValues().get(0));
		assertScalarEquals(432.74, (RealValue) column.getListOfValues().get(1));
		assertSymbRefEquals(new SymbolRef("foo"), (SymbolRef) column.getListOfValues().get(2));
		assertEquals(MissingValueSymbol.NaN, ((MissingValue) column.getListOfValues().get(3)).getSymbol());
	}
	
}
