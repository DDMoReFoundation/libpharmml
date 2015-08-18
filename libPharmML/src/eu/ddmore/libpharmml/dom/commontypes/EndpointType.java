package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Enumeration defining the type of an interval {@link Endpoint}.
 * 
 * @since PharmML 0.7
 */
@XmlEnum
public enum EndpointType {
	
	@XmlEnumValue("closed")
	CLOSED("closed"),
	@XmlEnumValue("open")
	OPEN("open");
	
	private String value;
	
	private EndpointType(String value){
		this.value = value;
	}
	
	/**
	 * Gets the value of the enum as displayed in PharmML.
	 * @return The value as a {@link String}.
	 */
	public String value(){
		return value;
	}
	
	/**
	 * Checks if the input value is valid or not.
	 * @param value The value as a {@link String}.
	 * @return true if there is an enum value corresponding to the input, else false.
	 */
	public boolean contains(String value){
		for(EndpointType type : values()){
			if(type.value().equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public EndpointType fromValue(String value){
		for(EndpointType type : values()){
			if(type.value().equals(value)){
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown endpoint type \""+value+"\"");
	}

}
