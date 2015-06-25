/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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
