package eu.ddmore.libpharmml.dom.commontypes;

public class TestObjectFactory {
	
	public static Vector createValidVectorWithElements(){
		Vector vector = new Vector(77, 10);
		VectorElements ve = vector.createVectorElements();
		ve.createMissingValue(MissingValueSymbol.ALQ);
		ve.createIntValue(20);
		ve.createRealValue(23.3);
		ve.createStringValue("stringvalue");
		return vector;
	}

}
