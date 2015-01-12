package eu.ddmore.libpharmml.dom.maths;

/**
 * Enumeration for handling operators within {@link Uniop} elements.
 * 
 * @author F. Yvon
 *
 */
public enum Unioperator {

	ABS("abs"),
	EXP("exp"),
	FACTORIAL("factorial"),
	FACTLN("factln"),
	GAMMALN("gammaln"),
	LOG("log"),
	LOG2("log2"),
	LOG10("log10"),
	LOGISTIC("logistic"),
	LOGIT("logit"),
	NORMCDF("normcdf"),
	PROBIT("probit"),
	MINUS("minus"),
	SQRT("sqrt"),
	HEAVISIDE("heaviside"),
	SIGN("sign"),
	SIN("sin"),
	COS("cos"),
	TAN("tan"),
	COT("cot"),
	/**
	 * @deprecated Since PharmML 0.5.1, moved to {@link Binoperator}.
	 */
	ATAN2("atan2"),
	SEC("sec"),
	CSC("csc"),
	SINH("sinh"),
	COSH("cosh"),
	TANH("tanh"),
	SECH("sech"),
	CSCH("csch"),
	COTH("coth"),
	ARCSIN("arcsin"),
	ARCCOS("arccos"),
	ARCTAN("arctan"),
	ARCSEC("arcsec"),
	ARCCSC("arccsc"),
	ARCCOT("arccot"),
	ARCSINH("arcsinh"),
	ARCCOSH("arccosh"),
	ARCTANH("arctanh"),
	ARCSECH("arcsech"),
	ARCCSCH("arccsch"),
	ARCCOTH("arccoth"),
	FLOOR("floor"),
	CEILING("ceiling");
	
	private String operator;
	
	private Unioperator(String op){
		this.operator = op;
	}
	
	/**
	 * Gets the operator as it is written in the PharmML document.
	 * @return The operator as {@link String}.
	 */
	public String getOperator(){
		return operator;
	}
	
	/**
	 * Converts a string representation of a unioperator to a {@link Unioperator} object.
	 * @param operator The operator as {@link String}, as it is written in a PharmML document.
	 * @return The corresponding {@link Unioperator} object. null if the operator does not exist.
	 */
	public static Unioperator fromString(String operator){
		if(operator != null){
			if(operator.equals("abs")){
			    return Unioperator.ABS;       
			} else if(operator.equals("exp")){
			    return Unioperator.EXP;       
			} else if(operator.equals("factorial")){
			    return Unioperator.FACTORIAL;       
			} else if(operator.equals("factln")){   
			    return Unioperator.FACTLN;          
			} else if(operator.equals("gammaln")){  
			    return Unioperator.GAMMALN;         
			} else if(operator.equals("log")){      
			    return Unioperator.LOG;             
			} else if(operator.equals("log2")){     
			    return Unioperator.LOG2;            
			} else if(operator.equals("log10")){    
			    return Unioperator.LOG10;           
			} else if(operator.equals("logistic")){ 
			    return Unioperator.LOGISTIC;        
			} else if(operator.equals("logit")){    
			    return Unioperator.LOGIT;           
			} else if(operator.equals("normcdf")){  
			    return Unioperator.NORMCDF;         
			} else if(operator.equals("probit")){   
			    return Unioperator.PROBIT;          
			} else if(operator.equals("minus")){    
			    return Unioperator.MINUS;           
			} else if(operator.equals("sqrt")){     
			    return Unioperator.SQRT;            
			} else if(operator.equals("sin")){      
			    return Unioperator.SIN;             
			} else if(operator.equals("cos")){      
			    return Unioperator.COS;             
			} else if(operator.equals("tan")){
			    return Unioperator.TAN;
			} else if(operator.equals("cot")){
			    return Unioperator.COT;
			} else if(operator.equals("atan2")){
			    return Unioperator.ATAN2;
			} else if(operator.equals("sec")){
			    return Unioperator.SEC;
			} else if(operator.equals("csc")){
			    return Unioperator.CSC;
			} else if(operator.equals("sinh")){
			    return Unioperator.SINH;
			} else if(operator.equals("cosh")){
			    return Unioperator.COSH;
			} else if(operator.equals("tanh")){
			    return Unioperator.TANH;
			} else if(operator.equals("sech")){
			    return Unioperator.SECH;
			} else if(operator.equals("csch")){
			    return Unioperator.CSCH;
			} else if(operator.equals("coth")){
			    return Unioperator.COTH;
			} else if(operator.equals("arcsin")){
			    return Unioperator.ARCSIN;
			} else if(operator.equals("arccos")){
			    return Unioperator.ARCCOS;
			} else if(operator.equals("arctan")){
			    return Unioperator.ARCTAN;
			} else if(operator.equals("arcsec")){
			    return Unioperator.ARCSEC;
			} else if(operator.equals("arccsc")){
			    return Unioperator.ARCCSC;
			} else if(operator.equals("arccot")){
			    return Unioperator.ARCCOT;
			} else if(operator.equals("arcsinh")){
			    return Unioperator.ARCSINH;
			} else if(operator.equals("arccosh")){
			    return Unioperator.ARCCOSH;
			} else if(operator.equals("arctanh")){
			    return Unioperator.ARCTANH;
			} else if(operator.equals("arcsech")){
			    return Unioperator.ARCSECH;
			} else if(operator.equals("arccsch")){
			    return Unioperator.ARCCSCH;
			} else if(operator.equals("arccoth")){
			    return Unioperator.ARCCOTH;
			} else if(operator.equals("floor")){
			    return Unioperator.FLOOR;
			} else if(operator.equals("ceiling")){
			    return Unioperator.CEILING;
			} else if(operator.equals("heaviside")){
			    return Unioperator.HEAVISIDE;
			} else if(operator.equals("sign")){
			    return Unioperator.SIGN;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
}
