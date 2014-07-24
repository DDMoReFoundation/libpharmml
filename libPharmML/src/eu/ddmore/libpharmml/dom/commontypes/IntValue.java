package eu.ddmore.libpharmml.dom.commontypes;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class IntValue extends IntValueType {
	
	public IntValue(BigInteger integer){
		this.value = integer;
	}
	
	public IntValue(Integer integer){
		this.value = BigInteger.valueOf(integer);
	}

}