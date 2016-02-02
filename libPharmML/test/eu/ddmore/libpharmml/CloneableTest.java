package eu.ddmore.libpharmml;

import static eu.ddmore.libpharmml.AssertUtil.assertAssignValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Binoperator;
import eu.ddmore.libpharmml.dom.maths.FunctionArgumentType;

public class CloneableTest {
	
	@Test
	public void testCloneBinop() throws Exception {
		Binop binop = new Binop(Binoperator.PLUS, new RealValue(2), new RealValue(3));
		binop.setId("source");
		
		Binop clone = (Binop) binop.clone();
		assertEquals("Binop operand1 clone is same", binop.getOperand1().toString(), clone.getOperand1().toString());
		assertEquals("Binop operand2 clone is same", binop.getOperand2().toString(), clone.getOperand2().toString());
		assertEquals("Binop operator clone is same", Binoperator.PLUS, clone.getOperator());
		assertNull("Clone id", clone.getId());
	}
	
	@Test
	public void testCloneFunctionArgument() throws Exception {
		FunctionArgumentType fa = new FunctionArgumentType();
		fa.setSymbId("arg1");
		fa.assign(new IntValue(0));
		
		FunctionArgumentType clone = (FunctionArgumentType) fa.clone();
		assertEquals("SymbId is same", fa.getSymbId(), clone.getSymbId());
		assertAssignValue(Integer.valueOf(0), clone.getAssign());
	}
	
	@Test
	public void testCloneRealValue() throws Exception {
		Double value = 123456.0;
		RealValue rv = new RealValue(value);
		rv.setId("id1");
		
		RealValue clone = (RealValue) rv.clone();
		assertEquals("Double value is same", value, Double.valueOf(clone.getValue()));
		assertNull("Clone id", clone.getId());
	}
	
}
