package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface ScalarContainer {

	public IntValue createIntValue(int value);
	public IntValue createIntValue(int value, String id);

	public RealValue createRealValue(double value);
	public RealValue createRealValue(double value, String id);

	public StringValue createStringValue(String value);
	public StringValue createStringValue(String value, String id);

	public IdValue createIdValue(String value);
	public IdValue createIdValue(String value, String id);

	public BooleanType createBooleanValue(boolean value);
	public BooleanType createBooleanValue(boolean value, String id);

	
}
