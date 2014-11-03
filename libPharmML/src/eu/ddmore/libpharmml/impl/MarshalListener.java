package eu.ddmore.libpharmml.impl;

import javax.xml.bind.Marshaller.Listener;

public class MarshalListener extends Listener {
	
	PharmMLVersion marshalVersion;
	
	public MarshalListener(PharmMLVersion version){
		this.marshalVersion = version;
	}
	
	public PharmMLVersion getMarshalVersion(){
		return this.marshalVersion;
	}

}
