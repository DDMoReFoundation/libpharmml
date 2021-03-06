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
package eu.ddmore.libpharmml;

import eu.ddmore.libpharmml.impl.LibPharmMLImpl;
import eu.ddmore.libpharmml.impl.MarshallerImpl;
import eu.ddmore.libpharmml.impl.PharmMLValidatorImpl;

/**
 * This factory class provides a convenient way to obtain the PharmML API. 
 * @author Stuart Moodie
 *
 */
public class PharmMlFactory {
	private static PharmMlFactory anInstance; 
	
	/**
	 * Get a singleton of this class.
	 * @return the singleton instance of this class.
	 */
	public static PharmMlFactory getInstance(){
		if(anInstance == null){
			anInstance = new PharmMlFactory();
		}
		return anInstance;
	}
	
	/**
	 * Create a new instance of the PharmML API. The instance will
	 * be ready to use and set with an appropriate marshaller and validator.
	 * @return the new instance of the API.
	 */
	public ILibPharmML createLibPharmML(){
		ILibPharmML retVal = new LibPharmMLImpl();
		retVal.setMarshaller(new MarshallerImpl());
		retVal.setValidator(new PharmMLValidatorImpl());
		return retVal;
	}
}
