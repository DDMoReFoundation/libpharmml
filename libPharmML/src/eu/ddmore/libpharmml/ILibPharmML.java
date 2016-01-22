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

import java.io.InputStream;
import java.io.OutputStream;

import eu.ddmore.libpharmml.impl.PharmMLVersion;

/**
 * The main API for manipulating PharmML and managing its persistence. 
 * @author Stuart Moodie
 *
 */
public interface ILibPharmML {

	/**
	 * Saves the DOM to a PharmML representation in the output stream. Note that it does not
	 * validate that the DOM will generate a valid PharmML document. To ensure this the client must
	 * explicitly validate the DOM before saving it. 
	 * @param opStr The output stream to use.
	 * @param resource The DOM to be saved.
	 * @throws RuntimeException if there is any error preventing the writing of the DOM to the output stream.
	 * 			Note that another exception such as an IOException may be chained to the RuntimeException.
	 */
	void save(OutputStream opStr, IPharmMLResource resource);
	
	/**
	 * Create a new resource that is generated from the PharmML
	 * document held in the input stream. The document is validated
	 * and a DOM will be generated. If it is invalid then the validation
	 * errors will be provided in the resource.  
	 * @param inStr the input stream containing the PharmML document.
	 * @return a resource containing the DOM and a validation report about it. This will
	 * 		not be null.
	 * @throws RuntimeException if there is an error preventing the generation of the resource. Typically this
	 * 			will be a runtime error.
	 */
	IPharmMLResource createDomFromResource(InputStream inStr);
	
	/**
	 * Create a complete new DOM. This generates a basic, but valid stub PharmML representation, according to the last PharmML version. 
	 * This can then be modified by the client as required. It's associated validation report will report that it is valid. 
	 * @return the new resource. This cannot be null.
	 * @deprecated Since libPharmML handles different PharmML versions, it is more robust to use {@link #createDom(PharmMLVersion)} instead.
	 */
	@Deprecated
	IPharmMLResource createDom();
	
	/**
	 * Create a complete new DOM. This generates a basic, but valid stub PharmML representation, according to the specified version. 
	 * This can then be modified by the client as required. It's associated validation report will report that it is valid. 
	 * @param version the PharmML version of which the stub would fits the schema.
	 * @return the new resource. This cannot be null.
	 * @since libPharmML 0.3
	 */
	IPharmMLResource createDom(PharmMLVersion version);
	
	/**
	 * Sets the validator to use with this API. Clients will generally not use this method and should use the
	 * PharmMLFactory to ensure an appropriate validator is provided here.  
	 * @param validator
	 */
	void setValidator(IPharmMLValidator validator);
	
	/**
	 * Gets a validator that can be used to validate a PharmML DOM.  
	 * @return the validator.
	 */
	IPharmMLValidator getValidator();
	
	/**
	 * Sets the marshaller to use to marshall and unmarshall a DOM to and from PharmML.Clients will generally
	 *  not use this method and should use the PharmMLFactory to ensure an appropriate marshaller is provided
	 *  here.  
	 * @param marshaller
	 */
	void setMarshaller(IMarshaller marshaller);
	
	/**
	 * Gets the marshaller used by this instance.
	 * @return the marshaller.
	 */
	IMarshaller getMarshaller();
}
