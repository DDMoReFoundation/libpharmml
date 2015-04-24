package eu.ddmore.libpharmml.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a scope of symbols (defined by a blkId within a model)
 * @author F. Yvon
 *
 */
public class Block {

	private String id;
	private List<String> symbIds = new ArrayList<String>();
	private List<Block> subBlocks = new ArrayList<Block>();
	
	/**
	 * Constructs a new empty block.
	 * @param blkId The id of the block.
	 */
	public Block(String blkId){
		this.id = blkId;
	}
	
	/**
	 * Gets the id of this block (blkId).
	 * @return The blkId string.
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Creates a new blok within this block.
	 * @param id The blkId of the new block.
	 * @return The created block.
	 */
	public Block createSubBlock(String blkId){
		Block subBlk = new Block(blkId);
		subBlocks.add(subBlk);
		return subBlk;
	}
	
	/**
	 * Gets the direct subblocks of this block.
	 * @return A list of the direct subblocks.
	 */
	public List<Block> getSubBlocks(){
		return subBlocks;
	}
	
	/**
	 * Gets the symbols in this block level. The ones containd in subblocks are not returned.
	 * @return A list of the symbol ids within this block.
	 */
	public List<String> getSymbIds(){
		return this.symbIds;
	}
	
	/**
	 * Adds a new symbol to this block.
	 * @param symbId The id of the added symbol.
	 * @return True if the symbol has been added properly.
	 */
	public boolean addSymbol(String symbId){
		return symbIds.add(symbId);
	}
	
	/**
	 * Tests if this block contains the given symbol. The search is also performed in all
	 * the subblocks of this block recursively.
	 * @param symbId The id of the symbol to search for.
	 * @return True if the block (or a subblock of this block) contains the provided symbol id.
	 */
	public boolean contains(String symbId){
		boolean c = false;
		for(String smb : symbIds){
			if(smb.equals(symbId)){
				c = true;
			}
		}
		for(Block block : getSubBlocks()){
			if(block.contains(symbId)){
				c = true;
			}
		}
		return c;
	}
	
}
