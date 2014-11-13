package eu.ddmore.libpharmml.dom.maths;

/**
 * Enumeration for handling operators within {@link Binop} elements.
 * 
 * The possible values are the following:
 * <ul>
 * <li>PLUS ("plus")</li>
 * <li>MINUS ("minus")</li>
 * <li>TIMES ("times")</li>
 * <li>DIVIDE ("divide")</li>
 * <li>POWER ("power")</li>
 * <li>LOGX ("logx")</li>
 * <li>ROOT ("root")</li>
 * <li>MIN ("min")</li>
 * <li>MAX ("max")</li>
 * <li>REM ("rem")</li>
 * </ul>
 * 
 * @author Florent Yvon
 */
public enum Binoperator {
	
	PLUS("plus"),
	MINUS("minus"),
	TIMES("times"),
	DIVIDE("divide"),
	POWER("power"),
	LOGX("logx"),
	ROOT("root"),
	MIN("min"),
	MAX("max"),
	REM("rem");
	
	private String operator;
	
	private Binoperator(String operator){
		this.operator = operator;
	}
	
	@Override
	/**
	 * Return the PharmML valid string value of the operator.
	 */
	public String toString() {
		return super.toString(); //TODO: test
	}
	
	/**
	 * Gets the PharmML string representation of the current operator.
	 * @return The operator as {@link String}, as it is written in the PharmML document.
	 */
	public String getOperator(){
		return operator;
	}
	
	/**
	 * Converts a string representation of a binoperator to a {@link Binoperator} object.
	 * @param operator The operator as {@link String}, as it is written in a PharmML document.
	 * @return The corresponding {@link Binoperator} object.
	 */
	public static Binoperator fromString(String operator){
		if(operator != null){
			if(operator.equals("plus")){
				return Binoperator.PLUS;
			} else if(operator.equals("minus")){
				return Binoperator.MINUS;
			} else if(operator.equals("times")){
				return Binoperator.TIMES;
			} else if(operator.equals("divide")){
				return Binoperator.DIVIDE;
			} else if(operator.equals("power")){
				return Binoperator.POWER;
			} else if(operator.equals("logx")){
				return Binoperator.LOGX;
			} else if(operator.equals("root")){
				return Binoperator.ROOT;
			} else if(operator.equals("min")){
				return Binoperator.MIN;
			} else if(operator.equals("max")){
				return Binoperator.MAX;
			} else if(operator.equals("rem")){
				return Binoperator.REM;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
