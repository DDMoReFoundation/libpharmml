package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Absorption")
public class AbsorptionMacro extends AbsorptionOralMacro {

	@Override
	public String getName() {
		return "absorption";
	}

}
