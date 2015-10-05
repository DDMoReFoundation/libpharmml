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
					Equation eq = v.getEquation();
					v.clearContent();
					if(eq.getBinop() != null){
						getLogger().info("Equation content (Binop) moved into "+v);
						v.setBinop(eq.getBinop());
					} else if (eq.getUniop() != null){
						getLogger().info("Equation content (Uniop) moved into "+v);
						v.setUniop(eq.getUniop());
					} else if (eq.getPiecewise() != null){
						getLogger().info("Equation content (Piecewise) moved into "+v);
						v.setPiecewise(eq.getPiecewise());
					} else if (eq.getScalar() != null) {
						getLogger().info("Scalar within Equation moved into "+v);
						v.setScalar((Scalar) eq.getScalar().getValue());
					} else if (eq.getSymbRef() != null) {
						getLogger().info("Equation content (SymbolRef) moved into "+v);
						v.setSymbRef(eq.getSymbRef());
					} else if (eq.getFunctionCall() != null){
						getLogger().info("Equation content (FunctionCall) moved into "+v);
						v.setFunctionCall(eq.getFunctionCall());
					} else if (eq.getSum() != null){
						getLogger().info("Equation content (Sum) moved into "+v);
						v.setSum(eq.getSum());
					} else if (eq.getProduct() != null){
						getLogger().info("Equation content (Product) moved into "+v);
						v.setProduct(eq.getProduct());
					} else if (eq.getDelay() != null){
						getLogger().info("Equation content (Delay) moved into "+v);
						v.setDelay(eq.getDelay());
					} else if (eq.getVectorSelector() != null){
						getLogger().info("Equation content (VectorSelector) moved into "+v);
						v.setVectorSelector(eq.getVectorSelector());
					} else if (eq.getMatrixSelector() != null){
						getLogger().info("Equation content (MatrixSelector) moved into "+v);
						v.setMatrixSelector(eq.getMatrixSelector());
					} else if (eq.getMatrixUniop() != null){
						getLogger().info("Equation content (MatrixUniop) moved into "+v);
						v.setMatrixUniop(eq.getMatrixUniop());
					} else if (eq.getProbability() != null){
						getLogger().info("Equation content (Probability) moved into "+v);
						v.setProbability(eq.getProbability());
					}
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
			
			if(v.getMarshalVersion() == null){
				throw new IllegalStateException("marshalVersion is not set before marshalling in "+v+" (parent:"+v.getParent()+").");
			}
			
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
				} else {
					getLogger().info("No content detected. "+clone.getContent()+" "+v.getContent());
				}
			}
			
			return clone;
		}
	}

}
