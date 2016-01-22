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
package eu.ddmore.libpharmml.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class wrapping a logger for libPharmML
 * @author Florent Yvon
 *
 */
public class LoggerWrapper {
	private static Logger logger = Logger.getLogger("libPharmML");
	static {
		logger.setLevel(Level.WARNING);
	}
	
	/**
	 * Access to the internal logger
	 * @return a static {@link Logger}
	 */
	public static Logger getLogger(){
		return logger;
	}
	
}
