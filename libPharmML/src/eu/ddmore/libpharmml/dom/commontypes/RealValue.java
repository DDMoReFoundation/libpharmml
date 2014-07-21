package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;


@XmlTransient
public class RealValue extends RealValueType {
	
	public RealValue(){
		super();
	}
	
	public RealValue(double value){
		this.value = value;
	}
	
	public RealValue(double value, String id){
		this.value = value;
		this.id = id;
	}

}