package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class IdValue extends IdValueType {

	public IdValue(){
		
	}
	
	public IdValue(String value){
		this.value = value;
	}
	
	public IdValue(String value, String id){
		this.value = value;
		this.id = id;
	}
}
