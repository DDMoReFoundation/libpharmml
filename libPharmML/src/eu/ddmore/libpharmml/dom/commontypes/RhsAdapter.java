package eu.ddmore.libpharmml.dom.commontypes;

import static eu.ddmore.libpharmml.impl.LoggerWrapper.getLogger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@SuppressWarnings("deprecation")
public class RhsAdapter extends XmlAdapter<Rhs, Rhs>{

	@Override
	public Rhs unmarshal(Rhs v) throws Exception {
		getLogger().info("Unmarshal using RhsAdapter");
		if(v == null){
			return null;
		} else {
			if(v.getContent() instanceof Equation){ // Equation is returned last.
				if(v.getUnmarshalVersion().isEqualOrLaterThan(PharmMLVersion.V0_7_1)){
					getLogger().warning("Equation was ignored in "+v
							+". (PharmML version:"+v.getUnmarshalVersion().getValue()+").");
					v.setEquation(null);
				} else {
					getLogger().info("Equation content moved into "+v);
					Equation eq = v.getEquation();
					v.clearContent();
					v.setBinop(eq.getBinop());
					v.setUniop(eq.getUniop());
					v.setPiecewise(eq.getPiecewise());
					v.setFunctionCall(eq.getFunctionCall());
					v.setSum(eq.getSum());
					v.setProduct(eq.getProduct());
					v.setDelay(eq.getDelay());
					v.setVectorSelector(eq.getVectorSelector());
					v.setMatrixSelector(eq.getMatrixSelector());
					v.setMatrixUniop(eq.getMatrixUniop());
					v.setProbability(eq.getProbability());
				}
			} else {
				v.setEquation(null);
			}
			return v;
		}
	}

	@Override
	public Rhs marshal(Rhs v) throws Exception {
		getLogger().info("Marshal using RhsAdapter");
		if(v == null){
			return null;
		} else {
			Rhs clone = ObjectFactory.getInstance().createRhs();
			clone.setId(v.getId());
			clone.setDescription(v.getDescription());
			clone.setBinop(v.getBinop());
			clone.setConstant(v.getConstant());
			clone.setDelay(v.getDelay());
			clone.setEquation(v.getEquation());
			clone.setFunctionCall(v.getFunctionCall());
			clone.setInterpolation(v.getInterpolation());
			clone.setInterval(v.getInterval());
			clone.setMarshalVersion(v.getMarshalVersion());
			clone.setMatrix(v.getMatrix());
			clone.setMatrixSelector(v.getMatrixSelector());
			clone.setMatrixUniop(v.getMatrixUniop());
			clone.setPiecewise(v.getPiecewise());
			clone.setProbability(v.getProbability());
			clone.setProduct(v.getProduct());
			clone.setScalar(v.getScalar());
			clone.setSequence(v.getSequence());
			clone.setSum(v.getSum());
			clone.setSymbRef(v.getSymbRef());
			clone.setUniop(v.getUniop());
			clone.setVector(v.getVector());
			clone.setVectorSelector(v.getVectorSelector());
			
			if(v.getMarshalVersion().isEqualOrLaterThan(PharmMLVersion.V0_7_1)){
				if(v.getContent() instanceof Equation){ // Should never happen
					getLogger().info("Equation attribute is no more used.");
					clone = Equation.toRhs(v.getEquation());
				}
			} else {
				// Looking through attributes added in PharmML 0.7, and wrap them into an
				// Equation for BC.
				if(clone.getBinop() != null){
					getLogger().info("Binop value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setBinop(clone.getBinop());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getUniop() != null){
					getLogger().info("Uniop value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setUniop(clone.getUniop());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getPiecewise() != null){
					getLogger().info("Piecewise value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setPiecewise(clone.getPiecewise());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getFunctionCall() != null){
					getLogger().info("FunctionCall value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setFunctionCall(clone.getFunctionCall());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getSum() != null){
					getLogger().info("Sum value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setSum(clone.getSum());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getProduct() != null){
					getLogger().info("Product value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setProduct(clone.getProduct());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getDelay() != null){
					getLogger().info("Delay value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setDelay(clone.getDelay());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getVectorSelector() != null){
					getLogger().info("VectorSelector value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setVectorSelector(clone.getVectorSelector());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getMatrixSelector() != null){
					getLogger().info("MatrixSelector value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setMatrixSelector(clone.getMatrixSelector());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getMatrixUniop() != null){
					getLogger().info("MatrixUniop value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setMatrixUniop(clone.getMatrixUniop());
					clone.clearContent();
					clone.setEquation(eq);
				} else if (clone.getProbability() != null){
					getLogger().info("Probability value of "+v+" moved into new Equation element.");
					Equation eq = new Equation();
					eq.setProbability(clone.getProbability());
					clone.clearContent();
					clone.setEquation(eq);
				}
			}
			
			return clone;
		}
	}

}
