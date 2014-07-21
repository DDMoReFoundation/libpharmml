package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class StringValue extends StringValueType {

	public StringValue(){
		super();
	}
	
	public StringValue(String value){
		this.value = value;
	}
	
	public StringValue(String value, String id){
		this.value = value;
		this.id = id;
	}
}
