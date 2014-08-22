package eu.ddmore.libpharmml.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import eu.ddmore.libpharmml.IValidationError;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.ValidationErrorImpl;

/**
 * Class for performing symbol validation.
 * @author F. Yvon
 */
public class SymbolResolver {
	
	private Block masterBlock;
	private List<PharmMLElementWrapper> symbolReferences;
	
	/**
	 * Constructs a symbol resolver for the given model
	 * @param dom The tested model
	 */
	public SymbolResolver(final PharmML dom){
		PharmMLElementWrapper wDom = new PharmMLElementWrapper(dom);
		
		masterBlock = new Block(null);
		symbolReferences = new ArrayList<PharmMLElementWrapper>();
		
		generateBlkTree(wDom, masterBlock);
	}
	
	/**
	 * Tries to resolve the symbol references within the wrapped model.
	 * @return A list of {@link IValidationError} for each dangling reference.
	 */
	public List<IValidationError> resolveSymbols(){
		List<IValidationError> errors = new ArrayList<IValidationError>();
		for(PharmMLElementWrapper wSymbRef : symbolReferences){
			if(!isSymbolExists(wSymbRef.getBlkIdRef(), wSymbRef.getSymbIdRef())){
				StringBuilder symbRefString = new StringBuilder();
				if(wSymbRef.getBlkIdRef() != null){
					symbRefString.append("blkIdRef="+wSymbRef.getBlkIdRef()+",");
				} 
				symbRefString.append("symbIdRef="+wSymbRef.getSymbIdRef());
				errors.add(new ValidationErrorImpl("S4",
						"Symbol reference ["+symbRefString.toString()+"] in "+
								wSymbRef.getWorkingClass().getSimpleName()+" is not resolved"));
			}
		}
		return errors;
	}
	
	/**
	 * Checks the unicity of symbols within the model.
	 * @return A list of {@link IValidationError} for each duplicate symbol.
	 */
	public List<IValidationError> checkUnicity(){
		List<IValidationError> errors = new ArrayList<IValidationError>();
		List<String> duplicateSymbols = new ArrayList<String>();
		
		unicityRecur(masterBlock, new HashSet<String>(), duplicateSymbols);
		
		for(String symbolId : duplicateSymbols){
			errors.add(new ValidationErrorImpl("S3", "Symbol \""+ symbolId +"\" is duplicate."));
		}
		
		return errors;
	}
	
	private void unicityRecur(Block block, HashSet<String> symbols, List<String> duplicateSymbols){
		for(String symbId : block.getSymbIds()){
			boolean isUnique = symbols.add(symbId);
			if(!isUnique){
				duplicateSymbols.add(symbId);
			}
		}
		for(Block subBlock : block.getSubBlocks()){
			unicityRecur(subBlock, new HashSet<String>(symbols), duplicateSymbols);
		}
	}
	
	/**
	 * Tests if the given symbol id exists in the model in the specified scope.
	 * @param blkId Scope of the symbol. Can be null to search within the entire model.
	 * @param symbId Id of the tested symbol.
	 * @return True if the symbol exists in the model within the given scope.
	 */
	public boolean isSymbolExists(String blkId, String symbId){
		if(blkId == null){
			return masterBlock.contains(symbId);
		} else {
			Block block = findBlock(masterBlock, blkId);
			if(block == null){
				return false;
			} else {
				return block.contains(symbId);
			}
		}
	}
	
	/**
	 * Prints the tree structure of blocks and symbols of the dom.
	 */
	public void printTree(){
		printRecur(masterBlock, 0);
	}
	
	private void printRecur(Block block, int level){
		StringBuilder tab = new StringBuilder();
		for(int i=0; i < level;i++){
			tab.append("\t");
		}
		System.out.print(tab+"|- "+block.getId()+" [");
		for(String symbId : block.getSymbIds()){
			System.out.print(symbId+",");
		}
		System.out.println("]");
		for(Block subBlock : block.getSubBlocks()){
			printRecur(subBlock, level+1);
		}
	}
	
	private Block findBlock(Block container, String blkId){
		Block rBlock = null;
		for(Block block : container.getSubBlocks()){
			if(block.getId().equals(blkId)){
				rBlock = block;
			} else {
				rBlock = findBlock(block, blkId);
			}
			
			if(rBlock != null){
				return rBlock;
			}
		}
		return null;
	}
	
	private void generateBlkTree(PharmMLElementWrapper el, Block currentBlock){
		if(el.getSymbId() != null){
			currentBlock.addSymbol(el.getSymbId());
		}
		if(el.getSymbIdRef() != null){
			symbolReferences.add(el);
		}
		for(PharmMLElementWrapper subEl : el.getChildren()){
			if(subEl.getBlkId() != null){
				generateBlkTree(subEl, currentBlock.createSubBlock(subEl.getBlkId()));
			} else {
				generateBlkTree(subEl, currentBlock);
			}
		}
	}

}