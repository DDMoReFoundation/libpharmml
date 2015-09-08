package eu.ddmore.libpharmml.dom.commontypes;

import static eu.ddmore.libpharmml.impl.LoggerWrapper.getLogger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RhsEquationAdapter extends XmlAdapter<Rhs, Rhs>{

	@Override
	public Rhs unmarshal(Rhs v) throws Exception {
		getLogger().info("Unmarshal using RhsVoidAdapter");
		return v;
	}

	@Override
	public Rhs marshal(Rhs v) throws Exception {
		getLogger().info("Marshal using RhsVoidAdapter");
		return v;
	}

}
