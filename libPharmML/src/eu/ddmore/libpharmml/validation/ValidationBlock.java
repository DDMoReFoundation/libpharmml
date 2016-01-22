/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import eu.ddmore.libpharmml.dom.commontypes.Block;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.exceptions.DuplicatedSymbolException;

/**
 * Class representing a scope of symbols (defined by a blkId within a model)
 * @author F. Yvon
 *
 */
public class ValidationBlock {

	private String id;
	private Map<String,Symbol> symbols;
	private List<SymbolRef> references;
	
	/**
	 * Constructs a new {@link ValidationBlock} with the given id.
	 * @param id The blkId of the {@link Block} object. Can be null
	 * for anonymous blocks.
	 */
	public ValidationBlock(String id){
		this.id = id;
		this.symbols = new Hashtable<String,Symbol>();
		this.references = new ArrayList<SymbolRef>();
	}
	
	/**
	 * The identifier of the block, i.e. the value of the blkId attribute.
	 * Can be null for anonymous blocks (function definitions for instance).
	 * @return blkId as a {@link String}.
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Gets all the symbols defined within this block. .add() and .addAll()
	 * are not supported for this collection.
	 * @return A {@link Collection} of {@link Symbol}.
	 */
	public Collection<Symbol> listOfSymbol(){
		return symbols.values();
	}
	
	/**
	 * Gets the symbol defined within this block. Returns null if the symbol does not
	 * exist.
	 * @param symbId The symbolId value.
	 * @return The object implementing {@link Symbol} defined with the given symbolId.
	 */
	public Symbol getSymbol(String symbId){
		return symbols.get(symbId);
	}
	
	/**
	 * Checks if there is a symbol defined with the given identifier within this block.
	 * @param symbId The identifier of the tested symbol.
	 * @return true if the symbol exists.
	 */
	public boolean containsSymbol(String symbId){
		return symbols.containsKey(symbId);
	}
	
	/**
	 * Add a new symbol to this block. The symbolId attribute value must be defined.
	 * The symbol id must also be unique within this block.
	 * @param symbol The object that implements {@link Symbol}.
	 * @throws DuplicatedSymbolException If a symbol with the given symbol identifier
	 * already exists within this block.
	 */
	public void addSymbol(Symbol symbol) throws DuplicatedSymbolException{
		if(symbols.containsKey(symbol.getSymbId())){
			throw new DuplicatedSymbolException(symbol);
		}
		symbols.put(symbol.getSymbId(), symbol);
	}
	
	/**
	 * Adds a {@link SymbolRef} object that is defined within that block. If the symbol reference
	 * does not specify a blkId, it means that it refers to a symbol defined within the same block,
	 * or to an independent variable.
	 * @param ref A {@link SymbolRef} object.
	 */
	public void addReference(SymbolRef ref){
		references.add(ref);
	}
	
	/**
	 * Gets all the symbol references defined within this block.
	 * @return A {@link List} of {@link SymbolRef} instances.
	 */
	public List<SymbolRef> getListOfSymbolRef(){
		return references;
	}
	
}
