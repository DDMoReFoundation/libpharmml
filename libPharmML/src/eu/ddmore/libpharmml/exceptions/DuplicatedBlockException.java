package eu.ddmore.libpharmml.exceptions;

import eu.ddmore.libpharmml.dom.commontypes.Block;

/**
 * Exception that occurs during the validation process if the model contains two blocks
 * with the same blkId attribute value.
 */
public class DuplicatedBlockException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1923773358534850101L;
	private final Block block;
	private final String message;
	
	public DuplicatedBlockException(Block block){
		this.block = block;
		this.message = "Block with blkId="+block.getBlkId()+" is duplicated.";
	}
	
	/**
	 * Gets the duplicated block entity (the second one found by the validation process)
	 * @return The duplicated block as a {@link Block} implementation.
	 */
	public Block getDuplicatedBlock(){
		return this.block;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
