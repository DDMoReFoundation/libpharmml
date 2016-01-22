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

import javax.xml.bind.Marshaller.Listener;

import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public interface IMarshaller {

	void marshall(PharmML dom, OutputStream os);
	
	void marshall(PharmML dom, OutputStream os, Listener mListener);

	PharmML unmarshall(InputStream in);
	
	PharmML unmarshall(InputStream in, PharmMLVersion version);
	
	PharmML unmarshall(InputStream in, PharmMLVersion version, javax.xml.bind.Unmarshaller.Listener uListener);

	void setErrorHandler(IErrorHandler errHandler);

	IErrorHandler getErrorHandler();
	
}
