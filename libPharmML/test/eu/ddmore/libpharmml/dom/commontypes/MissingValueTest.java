package eu.ddmore.libpharmml.dom.commontypes;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
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
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class MissingValueTest {
	
	private final PharmMLVersion VERSION;
	
	private ILibPharmML libPharmML;
	private IPharmMLResource resource;
	private ScalarRhs rhs;
	
	private static final String TESTFILE = "testMissingValue.xml";
	
	public MissingValueTest(PharmMLVersion version) {
		this.VERSION = version;
	}
	
	@Before
	public void setUp() throws Exception {
		this.libPharmML = PharmMlFactory.getInstance().createLibPharmML();
		this.resource = libPharmML.createDom(VERSION);
		this.resource.setParameter(IPharmMLResource.AUTOSET_ID, false);
		
		PharmML dom = resource.getDom();
		FunctionDefinition fd = dom.createFunctionDefinition("fd1", SymbolType.REAL);
		fd.createFunctionArgument("fa1", SymbolType.REAL);
		rhs = fd.createDefinition();
		rhs.setId("testRhs");
	}
	
	@After
	public void tearDown() throws Exception {
		this.rhs = null;
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
	public void testMarshal() throws Exception {
		testSymbolMarshalsTo(MissingValueSymbol.ALQ, "ALQ");
		testSymbolMarshalsTo(MissingValueSymbol.BLQ, "BLQ");
		testSymbolMarshalsTo(MissingValueSymbol.MINUSINF, "minusInf");
		testSymbolMarshalsTo(MissingValueSymbol.NA, "NA");
		testSymbolMarshalsTo(MissingValueSymbol.NaN, "NaN");
		testSymbolMarshalsTo(MissingValueSymbol.PLUSINF, "plusInf");
	}
	
	private void testSymbolMarshalsTo(MissingValueSymbol symbol, String qname){
		MissingValue mv = new MissingValue(symbol);
		mv.setId("mv1");
		rhs.setScalar(mv);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		libPharmML.save(baos, resource);
		assertThat(baos.toString(), containsString("<ct:"+qname+" id=\"mv1\"/>"));
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		InputStream is = this.getClass().getResourceAsStream(TESTFILE);
		IPharmMLResource resource = libPharmML.createDomFromResource(is);
		
		FunctionDefinition fd = resource.getDom().getListOfFunctionDefinition().get(0);
		assertNotNull(fd);
		ScalarRhs def = fd.getDefinition();
		assertNotNull(def);
		Scalar value = def.getScalar();
		assertNotNull(value);
		assertThat(value, instanceOf(MissingValue.class));
		assertEquals(MissingValueSymbol.NA, ((MissingValue)value).getSymbol());
	}
	
}
