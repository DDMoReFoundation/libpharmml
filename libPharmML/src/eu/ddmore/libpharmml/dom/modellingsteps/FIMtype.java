package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FIMtype {
	
	@XmlEnumValue("P")
	P("P"),
	@XmlEnumValue("I")
	I("I"),
	@XmlEnumValue("B")
	B("B");
	
	private final String value;
	
	private FIMtype(String value){
		this.value = value;
	}
	
	/**
	 * Gets the string value as written in PharmML.
	 * @return The enum value as a string.
	 */
	public String value(){
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
