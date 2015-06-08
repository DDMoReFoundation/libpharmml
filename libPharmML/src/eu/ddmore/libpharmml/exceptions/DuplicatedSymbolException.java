package eu.ddmore.libpharmml.exceptions;

import eu.ddmore.libpharmml.dom.commontypes.Symbol;

public class DuplicatedSymbolException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6846084948453473238L;
	private final Symbol symbol;
	private final String message;
	
	public DuplicatedSymbolException(Symbol symbol){
		this.symbol = symbol;
		this.message = "Symbol with symbolId="+symbol.getSymbId()+" is duplicated.";
	}
	
	public Symbol getDuplicatedSymbol(){
		return symbol;
	}
	
	@Override
	public String getMessage(){
		return message;
	}

}
