package eu.ddmore.libpharmml.dom.maths;

public enum ProbabilityFunctionType {
	
	CDF("CDF"),
	
	PDF("PDF"),
	
	HF("HF"),
	
	SF("SF");
	
	private final String value;
	
	private ProbabilityFunctionType(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
	
	public static ProbabilityFunctionType fromValue(String value){
		for(ProbabilityFunctionType pft : values()){
			if(value.equals(pft.value())){
				return pft;
			}
		}
		throw new IllegalArgumentException(value);
	}
	
}
