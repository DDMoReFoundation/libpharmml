package eu.ddmore.libpharmml.dom.dataset;

public enum HeaderType {

	MAIN_HEADER("mainHeader"),
	SUBHEADER("subHeader"),
	USER_DEFINED("userDefined");
	
	private String value;
	
	private HeaderType(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
	
}
