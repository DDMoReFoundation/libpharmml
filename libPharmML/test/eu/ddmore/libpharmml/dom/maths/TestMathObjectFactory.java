package eu.ddmore.libpharmml.dom.maths;

import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.modeldefn.Distribution;
import eu.ddmore.libpharmml.dom.probonto.ProbOnto;
import eu.ddmore.libpharmml.dom.probonto.ProbOntoTest;

public class TestMathObjectFactory {
	
	private static eu.ddmore.libpharmml.dom.commontypes.ObjectFactory ctof = eu.ddmore.libpharmml.dom.commontypes.ObjectFactory.getInstance();

	public static Naryop createValidNaryop(){
		Naryop naryop = new Naryop(Naryoperator.MAX);
		Vector vector = naryop.createVector();
		VectorElements ve = vector.createVectorElements();
		ve.createRealValue(1);
		ve.createRealValue(7);
		ve.createRealValue(3);
		ve.createRealValue(9);
		ve.createRealValue(2);
		return naryop;
	}
	
	public static ProbabilityFunction createValidProbabilityFunction(ProbabilityFunctionType type){
		ProbabilityFunction pf = new ProbabilityFunction(type);
		Distribution distrib = pf.createDistribution();
		ProbOnto po = ProbOntoTest.createValidProbOnto();
		distrib.setProbOnto(po);
		return pf;
	}
	
	public static Condition createValidCondition(){
		Condition condition = new Condition();
		// t > 60
		LogicBinOp lb = new LogicBinOp(LogicOperator.GT);
		lb.getContent().add(ctof.createSymbRef(new SymbolRef("t")));
		lb.getContent().add(ctof.createReal(new RealValue(60)));
		condition.setLogicBinop(lb);
		
		return condition;
	}
	
}
