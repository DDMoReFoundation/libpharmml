package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Oral")
public class OralMacro extends AbsorptionOralMacro {

	@Override
	public String getName() {
		return "oral";
	}

}
