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
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.AbstractTreeNode;
import eu.ddmore.libpharmml.dom.IndependentVariable;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.Block;
import eu.ddmore.libpharmml.dom.commontypes.FunctionDefinition;
import eu.ddmore.libpharmml.dom.commontypes.FunctionParameter;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.SymbolScope;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType.FunctionArgument;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.exceptions.DuplicatedBlockException;
import eu.ddmore.libpharmml.exceptions.DuplicatedSymbolException;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

/**
 * Class for performing symbol validation.
 * @author F. Yvon
 */
public class SymbolResolver {
	
	private IErrorHandler errorHandler;
	
	private ValidationBlock globalBlock;
	private List<ValidationBlock> anonymousBlocks;
	private Map<String,ValidationBlock> blocks; // refered by SymbRef elements
	private Map<String,ValidationBlock> functions; // only refered by FunctionCall elements
	private List<FunctionCallType> functionCalls;
	
	private List<ReferenceContainer> containers;
	private Map<String,PharmMLObject> objects;
		
	public SymbolResolver(PharmML dom, IErrorHandler errorHandler){
		blocks = new Hashtable<String,ValidationBlock>();
		functions = new Hashtable<String,ValidationBlock>();
		functionCalls = new ArrayList<FunctionCallType>();
		anonymousBlocks = new ArrayList<ValidationBlock>();
		globalBlock = new ValidationBlock(null);
		this.errorHandler = errorHandler;
		
		containers = new ArrayList<ReferenceContainer>();
		objects = new Hashtable<String, PharmMLObject>();
		
		init(dom);
	}
	
	/**
	 * Method performing the fetching of blocks, symbols and reference by browsing the DOM tree
	 * recursively.
	 * @param dom A {@link PharmML} dom instance.
	 */
	private void init(PharmML dom){
		for(IndependentVariable iv : dom.getListOfIndependentVariable()){
			try {
				globalBlock.addSymbol(iv);
			} catch (DuplicatedSymbolException e) {
				handleException(e);
			}
		}
		
		for(FunctionDefinition fd : dom.getListOfFunctionDefinition()){
			ValidationBlock block = storeFunctionDefinition(fd);
			for(FunctionParameter fa : fd.getFunctionArgument()){
				try {
					block.addSymbol(fa);
				} catch (DuplicatedSymbolException e) {
					handleException(e);
				}
			}
		}
		
		if(dom.getModelDefinition() != null){
			browseTree(dom.getModelDefinition(), globalBlock);
		}
		if(dom.getModellingSteps() != null){
			browseTree(dom.getModellingSteps(), globalBlock);
		}
		if(dom.getTrialDesign() != null){
			browseTree(dom.getTrialDesign(), globalBlock);
		}
	}
	
	/**
	 * The recursive browsing method itself.
	 * @param node The current browsed node.
	 * @param currentScope The current scope at this step.
	 */
	private void browseTree(TreeNode node, ValidationBlock currentScope){
		if(node instanceof FunctionCallType){
			storeFunctionCall((FunctionCallType) node);
			return; // will have its own validation procedure
		}
		
		if(node instanceof SymbolScope){
			if(node instanceof Block){
				currentScope = storeBlock((Block) node);
			} else {
				currentScope = storeAnonymousBlock((SymbolScope) node);
			}
		}
		
		if(node instanceof Symbol){
			try {
				if(((Symbol) node).getSymbId() != null){
					currentScope.addSymbol((Symbol) node);
				}
			} catch (DuplicatedSymbolException e) {
				handleException(e);
			}
		}
		if(node instanceof SymbolRef){
			currentScope.addReference((SymbolRef) node);
		}
		
		if(node instanceof PharmMLObject){
			storeObject((PharmMLObject) node);
		}
		
		if(node instanceof ReferenceContainer){
			storeReferenceContainer((ReferenceContainer) node);
		}
		
		@SuppressWarnings("unchecked")
		Enumeration<TreeNode> children = node.children();
		while(children.hasMoreElements()){
			browseTree(children.nextElement(), currentScope);
		}
	}
	
	private ValidationBlock storeBlock(Block block){
		if(block.getBlkId() == null){
			LoggerWrapper.getLogger().warning(block+" has undefined blkId. Will be validated as an"
					+ " anonymous scope.");
			return storeAnonymousBlock(block);
		} else {
			if(blocks.containsKey(block.getBlkId())){
				handleException(new DuplicatedBlockException(block));
			}
			ValidationBlock newBlock = new ValidationBlock(block.getBlkId());
			blocks.put(block.getBlkId(), newBlock);
			return newBlock;
		}
	}
	
	private ValidationBlock storeAnonymousBlock(SymbolScope block){
		ValidationBlock newBlock = new ValidationBlock(null);
		anonymousBlocks.add(newBlock);
		return newBlock;
	}
	
	private ValidationBlock storeFunctionDefinition(FunctionDefinition fd){
		ValidationBlock newBlock = new ValidationBlock(null);
		functions.put(fd.getSymbId(), newBlock);
		return newBlock;
	}
	
	private void storeFunctionCall(FunctionCallType fc){
		functionCalls.add(fc);
	}
	
	private void storeObject(PharmMLObject o){
		if(o.getOid() != null){
			objects.put(o.getOid(), o);
		} else {
			LoggerWrapper.getLogger().info("PharmMLObject with null oid won't be stored.");
		}
	}
	
	private void storeReferenceContainer(ReferenceContainer rc){
		containers.add(rc);
	}
	
	private void handleException(DuplicatedSymbolException e){
		errorHandler.handleError("S1", "Symbols must be unique within their scope ("+e.getDuplicatedSymbol().getSymbId()+").", 
				(AbstractTreeNode) e.getDuplicatedSymbol());
	}
	
	private void handleException(DuplicatedBlockException e){
		errorHandler.handleError("S1", "Blocks must be unique ("+e.getDuplicatedBlock().getBlkId()+").", 
				(AbstractTreeNode) e.getDuplicatedBlock());
	}
	
	public void handleUnresolvedObject(OidRef oidRef){
		errorHandler.handleError("S2", "Object reference (oidRef) \""+oidRef.getOidRef()+"\" is not resolved.", oidRef);
	}
	
	public void handleIncompatibleObject(OidRef oidref, PharmMLObject o, TreeNode parent){
		errorHandler.handleError("S5", "Element using oidRef=\""+oidref.getOidRef()+"\" within "+parent+" object is incompatible with the referred object type ("+o.getClass().getSimpleName()+").", oidref);
	}
	
	private void handleUnresolvedSymbol(SymbolRef symbolRef, ValidationBlock within){
		errorHandler.handleError("S2", "Symbol reference \""+symbolRef+"\" is not resolved.", symbolRef);
	}
	
	private void handleUnresolvedSymbol(FunctionCallType symbolRef){
		errorHandler.handleError("S2", "Symbol reference \""+symbolRef+"\" is not resolved.", symbolRef);
	}
	
	private void handleUnresolvedSymbol(FunctionArgument fa, String functionId){
		errorHandler.handleError("S2", "Function argument \""+fa.getSymbId()+"\" is not defined within the function \""+functionId+"\".", fa);
	}
	
	private void handleUnusedArgument(FunctionCallType fc, String faId){
		errorHandler.handleError("S2", "Function argument \""+faId+"\" is not used in FunctionCall \""+fc.getSymbRef().getSymbIdRef()+"\".", fc);
	}
	
	private boolean isIndependentSymbol(String symbId){
		return (globalBlock.containsSymbol(symbId));
	}
	
	/**
	 * Executes {@link #validateSymbols()}, {@link #validateFunctionCalls()} and
	 * {@link #validateObjectReferences()}.
	 */
	public void validateAll(){
		validateSymbols();
		validateFunctionCalls();
		validateObjectReferences();
	}
	
	public void validateSymbols(){
		List<ValidationBlock> blocks = getAllBlocks();
		for(ValidationBlock block : blocks){
			for(SymbolRef ref : block.getListOfSymbolRef()){
				ValidationBlock targetBlock;
				if(ref.getBlkIdRef() == null){
					targetBlock = block;
				} else {
					if(this.blocks.containsKey(ref.getBlkIdRef())){
						targetBlock = this.blocks.get(ref.getBlkIdRef());
					} else {
						handleUnresolvedSymbol(ref, block);
						continue;
					}
				}
				if(!(targetBlock.containsSymbol(ref.getSymbIdRef()) ||
						isIndependentSymbol(ref.getSymbIdRef()))){
					handleUnresolvedSymbol(ref, block);
				}
			}
		}
	}
	
	/**
	 * Validation of {@link FunctionCallType} objects. All the {@link FunctionArgument} within a
	 * function call must be defined within the called {@link FunctionDefinition} object.
	 */
	public void validateFunctionCalls(){
		for(FunctionCallType fc : functionCalls){
			if(fc.getSymbRef() != null && fc.getSymbRef().getSymbIdRef() != null){
				if(functions.containsKey(fc.getSymbRef().getSymbIdRef())){
					ValidationBlock functionBlock = functions.get(fc.getSymbRef().getSymbIdRef());
					for(FunctionArgument fp : fc.getListOfFunctionArgument()){
						if(fp.getSymbId() != null && !functionBlock.containsSymbol(fp.getSymbId())){
							handleUnresolvedSymbol(fp,fc.getSymbRef().getSymbIdRef());
						}
					}
					for(Symbol fa : functionBlock.listOfSymbol()){
						if(!fc.containsFunctionArgument(fa.getSymbId())){
							handleUnusedArgument(fc, fa.getSymbId());
						}
					}
				} else {
					handleUnresolvedSymbol(fc);
				}
			}
		}
	}
	
	public void validateObjectReferences(){
		for(ReferenceContainer rc : containers){
			rc.validateReferences(this, errorHandler);
		}
	}
	
	/**
	 * Fetch the object with the given oid attribute.
	 * @param oid Unique idenfitier of the object.
	 * @return A {@link PharmMLObject}, or null if the oid does not exist.
	 */
	public PharmMLObject getObject(String oid){
		return objects.get(oid);
	}
	
	/**
	 * Checks if an object with the given oid exists.
	 * @param oid The searched oid.
	 * @return true if the oid has been given, else false.
	 */
	public boolean containsObject(String oid){
		return objects.containsKey(oid);
	}

//	public ValidationBlock addBlock(SymbolScope scope) throws DuplicatedBlockException{
//		ValidationBlock valBlock;
//		if(scope instanceof Block && ((Block) scope).getBlkId() != null){
//			String blkId = ((Block) scope).getBlkId();
//			if(blocks.containsKey(blkId)){
//				throw new DuplicatedBlockException((Block) scope);
//			}
//			valBlock = new ValidationBlock(blkId);
//			blocks.put(blkId,valBlock);
//		} else {
//			valBlock = new ValidationBlock(null);
//			anonymousBlocks.add(valBlock);
//		}
//		return valBlock;
//	}
	
	List<ValidationBlock> getAllBlocks(){
		List<ValidationBlock> list = new ArrayList<ValidationBlock>();
		list.add(globalBlock);
		list.addAll(anonymousBlocks);
		list.addAll(blocks.values());
		return list;
	}

}
