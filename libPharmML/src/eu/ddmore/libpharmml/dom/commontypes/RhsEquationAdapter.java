package eu.ddmore.libpharmml.dom.commontypes;

import static eu.ddmore.libpharmml.impl.LoggerWrapper.getLogger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.util.annotations.HasElementsRenamed;

/**
 * This adapter handles the backward compatibility of {@link Equation} with PharmML models encoded in version 0.6 and older.
 * This adapter is used in combination with the annotation {@link HasElementsRenamed} in classes where the equation attribute
 * was replaced with an assign attribute in PharmML 0.7 update.
 * 
 * @author F. Yvon
 *
 */
@SuppressWarnings("deprecation")
public class RhsEquationAdapter extends XmlAdapter<Equation, Rhs>{

	@Override
	public Equation marshal(Rhs v) throws Exception {
		if(v == null){
			return null;
		}
		getLogger().info("Converting Rhs to Equation");
		return Equation.fromRhs(v);
	}

	@Override
	public Rhs unmarshal(Equation v) throws Exception {
		if(v == null){
			return null;
		}
		getLogger().info("Converting Equation to Rhs");
		return Equation.toRhs(v);
	}

}
