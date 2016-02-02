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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Marshaller.Listener;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.IMarshaller;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.impl.PharmMLSchemaFactory.NamespaceType;
import eu.ddmore.libpharmml.validation.SymbolResolver;

public class MarshallerImpl implements IMarshaller {
	public static final String CONTEXT_NAME = Messages.getString("MarshallerImpl.contextDefn"); //$NON-NLS-1$
	private IErrorHandler errorHandler;
	
	@Override
	public void marshall(PharmML dom, OutputStream os) {
		marshall(dom, os, null);
	}

	@Override
	public void marshall(PharmML dom, OutputStream os, Listener mListener) {
		try {
			JAXBContext context = JAXBContext.newInstance(CONTEXT_NAME);
			
//			if(dom.getWrittenVersion() == null){
//				throw new RuntimeException("writtenVersion attribute must be set to the root element.");
//			}
//			
			PharmMLVersion version = PharmMLVersion.getEnum(dom.getWrittenVersion());
			if(version == null){
				version = PharmMLVersion.DEFAULT;
			}
			setMarshalVersion(dom, version);
//			MarshalListener mListener;
//			if(version != null){
//				mListener = new MarshalListener(version,idFactory);
//			} else {
//				throw new RuntimeException("Unknown or unsupported PharmML written version ("+dom.getWrittenVersion()+")");
//			}
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setListener(mListener);
			
			// TODO: use a proper XML writer. Use last version as default one.
			if(!version.isEqualOrLaterThan(PharmMLVersion.DEFAULT)){
				// Marshalling into a XMLStreamWriter with filter for namespaces.
				// Into a ByteArray so it can be inputstreamed again.
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				XMLFilter filter = new XMLFilter(version);	
//				XMLStreamWriter xmlsw = filter.getXMLStreamWriter(byteOut);	
				m.marshal(dom, byteOut);
				
				filter.filterRawText(new ByteArrayInputStream(byteOut.toByteArray()), os);
			} else { // no filtering, applying old default namespace
				m.marshal(dom, os);
			}
			
//			// Using a transformer for pretty XML print
//			Transformer transformer = TransformerFactory.newInstance().newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); // indent length
//			transformer.transform(
//					new StreamSource(new ByteArrayInputStream(byteOut.toByteArray())), 
//					new StreamResult(os)
//					);
//			
		} catch (JAXBException e) {
			throw new RuntimeException(e);
//		} catch (XMLStreamException e) {
//			throw new RuntimeException(e);
//		} catch (TransformerException e) {
//			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PharmML unmarshall(InputStream is) {
		try {
			// Convert inputStream to byteArray so it can be read twice 
			// (first to get PharmML version before unmarshalling)
			byte[] data = toByteArray(is);
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			final PharmMLVersion currentDocVersion = parseVersion(bais);
			bais.reset();
			
			return unmarshall(bais, currentDocVersion);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public PharmML unmarshall(InputStream in, PharmMLVersion version) {
		return unmarshall(in, version, null);
	}
	
	@Override
	public PharmML unmarshall(InputStream is, PharmMLVersion version, javax.xml.bind.Unmarshaller.Listener uListener) {
		try {
//			String packageName = PharmML.class.getPackage().getName();
			JAXBContext context = JAXBContext.newInstance(CONTEXT_NAME);
			Unmarshaller u = context.createUnmarshaller();
			u.setEventHandler(new ValidationEventHandler() {
				
				@Override
				public boolean handleEvent(ValidationEvent event) {
					int severity = event.getSeverity();
					switch(severity){
					case ValidationEvent.ERROR:
						errorHandler.handleError(ValidationReportFactory.SCHEMA_ERR_CODE, event.getMessage(),event.getLocator());
						break;
					case ValidationEvent.FATAL_ERROR:
						errorHandler.handleError(ValidationReportFactory.SCHEMA_ERR_CODE, event.getMessage(),event.getLocator());
						break;
					case ValidationEvent.WARNING:
						errorHandler.handleWarning(event.getMessage());
						break;
					}
					return true;
				}
			});

			// Schema
			Schema mySchema = PharmMLSchemaFactory.getInstance().createPharmMlSchema(version,NamespaceType.DEFAULT);
			u.setSchema(mySchema);
			
			u.setListener(uListener);
			
			PharmML doc;
			if(!version.isEqualOrLaterThan(PharmMLVersion.DEFAULT)){
				XMLStreamReader xmlsr = new XMLFilter(version).getXMLStreamReader(is);
				doc = (PharmML)u.unmarshal(xmlsr);
			} else {
				doc = (PharmML)u.unmarshal(is);
			}
			
			// Not calling the full validator, as the validation is performed but the
			// UnmarshalListener.
			if(version.isEqualOrLaterThan(PharmMLVersion.V0_6)){
				SymbolResolver sr = new SymbolResolver(doc, errorHandler);
				sr.validateAll();
			} else {
				LoggerWrapper.getLogger().info("Version is below "+PharmMLVersion.V0_6+", no complex validation performed.");
			}
			

			return doc;
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (XMLStreamException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void setErrorHandler(IErrorHandler repFact) {
		this.errorHandler = repFact;
	}

	@Override
	public IErrorHandler getErrorHandler() {
		return this.errorHandler;
	}
	
	static PharmMLVersion parseVersion(InputStream is) throws XMLStreamException{
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLStreamReader sReader = factory.createXMLStreamReader(is);
		String version = null;
		while(sReader.hasNext() && version == null){
			int event = sReader.next();
			switch(event){
			case XMLStreamConstants.START_ELEMENT:
				if("PharmML".equals(sReader.getLocalName())){
					version = sReader.getAttributeValue(null,"writtenVersion");
				}
			}
		}
		sReader.close();
		PharmMLVersion phVersion = PharmMLVersion.getEnum(version);
		if(phVersion == null){
			phVersion = PharmMLVersion.DEFAULT;
			LoggerWrapper.getLogger().warning("Missing writtenVersion attribute or unknown version for PharmML element. Using default version ("+phVersion.getValue()+").");
		}
		return phVersion;
	}
	
	static byte[] toByteArray(InputStream is) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();				
		byte[] buffer = new byte[1024];
		int read = 0;
		while ((read = is.read(buffer, 0, buffer.length)) != -1) {
			baos.write(buffer, 0, read);
		}		
		baos.flush();	
		return baos.toByteArray();
	}
	
	private void setMarshalVersion(PharmMLElement node, PharmMLVersion version){
		node.setMarshalVersion(version);
		Enumeration<TreeNode> children = node.children();
		while(children.hasMoreElements()){
			TreeNode child = children.nextElement();
			if(child instanceof PharmMLElement){
				setMarshalVersion((PharmMLElement) child, version);
			}
		}
	}

}
