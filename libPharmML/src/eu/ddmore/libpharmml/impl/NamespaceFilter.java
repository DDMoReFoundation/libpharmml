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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * This class performs namespace URIs conversion during marshalling and unmarshalling if needed.
 * 
 * @author F. Yvon
 * @see XMLFilterImpl
 */
public class NamespaceFilter extends XMLFilterImpl {
	
	static final private String NS_PATTERN_ROOT = "http://www.pharmml.org/pharmml/%s/";
	static final protected String NS_PATTERN_CT = NS_PATTERN_ROOT + "CommonTypes";
	static final protected String NS_PATTERN_DS = NS_PATTERN_ROOT + "Dataset";
	static final protected String NS_PATTERN_MATH = NS_PATTERN_ROOT + "Maths";
	static final protected String NS_PATTERN_MDEF = NS_PATTERN_ROOT + "ModelDefinition";
	static final protected String NS_PATTERN_TD = NS_PATTERN_ROOT + "TrialDesign";
	static final protected String NS_PATTERN_MSTEPS = NS_PATTERN_ROOT + "ModellingSteps";
	static final public String NS_PATTERN_MML = NS_PATTERN_ROOT + "PharmML";
	
	// Default namespace URIs. These fields MUST BE updated to the latest PharmML version
	static final public String NS_DEFAULT_CT = "http://www.pharmml.org/pharmml/0.8/CommonTypes";
	static final public String NS_DEFAULT_DS = "http://www.pharmml.org/pharmml/0.8/Dataset";
	static final public String NS_DEFAULT_MATH = "http://www.pharmml.org/pharmml/0.8/Maths";
	static final public String NS_DEFAULT_MDEF = "http://www.pharmml.org/pharmml/0.8/ModelDefinition";
	static final public String NS_DEFAULT_TD = "http://www.pharmml.org/pharmml/0.8/TrialDesign";
	static final public String NS_DEFAULT_MSTEPS = "http://www.pharmml.org/pharmml/0.8/ModellingSteps";
	static final public String NS_DEFAULT_MML = "http://www.pharmml.org/pharmml/0.8/PharmML";
	static final public String NS_DEFAULT_UNCERTML = "http://www.uncertml.org/3.0";
	static final public String NS_DEFAULT_PROBONTO = "http://www.pharmml.org/probonto/ProbOnto";
	
	final protected String NS_DOC_ROOT;
	final protected String NS_DOC_CT;
	final protected String NS_DOC_DS;
	final protected String NS_DOC_MATH;
	final protected String NS_DOC_MDEF;
	final protected String NS_DOC_TD;
	final protected String NS_DOC_MSTEPS;
	final protected String NS_DOC_MML;
	final protected String NS_DOC_PROBONTO;

	static final private String NS_OLD_ROOT = "http://www.pharmml.org/2013/03/";
	
	static final public String NS_OLD_CT = NS_OLD_ROOT + "CommonTypes";
	static final public String NS_OLD_DS = "http://www.pharmml.org/2013/08/Dataset";
	static final public String NS_OLD_MATH = NS_OLD_ROOT + "Maths";
	static final public String NS_OLD_MDEF = NS_OLD_ROOT + "ModelDefinition";
	static final public String NS_OLD_TD = NS_OLD_ROOT + "TrialDesign";
	static final public String NS_OLD_MSTEPS = NS_OLD_ROOT + "ModellingSteps";
	static final public String NS_OLD_MML = NS_OLD_ROOT + "PharmML";
	
	/**
	 * Constructs the namespace filter needed for a document with the given written version.
	 * @param writtenVersion The {@link PharmMLVersion} of the marshalled/unmarshalled document.
	 */
    public NamespaceFilter(PharmMLVersion writtenVersion) {
        super();
        
        if(writtenVersion == null){
        	throw new IllegalArgumentException("Written version cannot be null");
        }
                
        if(writtenVersion.isEqualOrLaterThan(PharmMLVersion.V0_6)){
        	NS_DOC_ROOT = String.format(NS_PATTERN_ROOT, writtenVersion.getURIVersion());
        	NS_DOC_CT = String.format(NS_PATTERN_CT, writtenVersion.getURIVersion());
        	NS_DOC_DS = String.format(NS_PATTERN_DS, writtenVersion.getURIVersion());
        	NS_DOC_MATH = String.format(NS_PATTERN_MATH, writtenVersion.getURIVersion());
        	NS_DOC_MDEF = String.format(NS_PATTERN_MDEF, writtenVersion.getURIVersion());
        	NS_DOC_TD = String.format(NS_PATTERN_TD, writtenVersion.getURIVersion());
        	NS_DOC_MSTEPS = String.format(NS_PATTERN_MSTEPS, writtenVersion.getURIVersion());
        	NS_DOC_MML = String.format(NS_PATTERN_MML, writtenVersion.getURIVersion());
        	if(writtenVersion.isEqualOrLaterThan(PharmMLVersion.V0_7_3)){
        		NS_DOC_PROBONTO = NS_DEFAULT_PROBONTO;
        	} else {
        		NS_DOC_PROBONTO = NS_DOC_MSTEPS; // In 0.7, ProbOnto elements were located in the msteps schema 
        	}
        	
        } else {
        	NS_DOC_ROOT = NS_OLD_ROOT;
        	NS_DOC_CT = NS_OLD_CT;
        	NS_DOC_DS = NS_OLD_DS;
        	NS_DOC_MATH = NS_OLD_MATH;
        	NS_DOC_MDEF = NS_OLD_MDEF;
        	NS_DOC_TD = NS_OLD_TD;
        	NS_DOC_MSTEPS = NS_OLD_MSTEPS;
        	NS_DOC_MML = NS_OLD_MML;
        	NS_DOC_PROBONTO = null; // didn't exist before 0.7
        }
        
    }
    

	@Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        if (addNamespace) {
//            startControlledPrefixMapping();
//        }
    }

    @Override
    public void startElement(String arg0, String arg1, String arg2,
            Attributes arg3) throws SAXException {

        super.startElement(filterInputNamespace(arg0), arg1, arg2, arg3);
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2)
            throws SAXException {

        super.endElement(filterInputNamespace(arg0), arg1, arg2);
    }

    /**
     * Transform the document namespace to the default one used by JAXB.
     * @param ns Document namespace
     * @return Default namespace
     */
    private String filterInputNamespace(String ns){
    	if(ns == null){
    		return null;
    	}
    	if(ns.equals(NS_DOC_CT)){
    		return NS_DEFAULT_CT;
    	} else if(ns.equals(NS_DOC_DS)){
        	return NS_DEFAULT_DS;
    	} else if(ns.equals(NS_DOC_MATH)){
        	return NS_DEFAULT_MATH;
    	} else if(ns.equals(NS_DOC_MDEF)){
        	return NS_DEFAULT_MDEF;
    	} else if(ns.equals(NS_DOC_MSTEPS)){
        	return NS_DEFAULT_MSTEPS;
    	} else if(ns.equals(NS_DOC_TD)){
        	return NS_DEFAULT_TD;
    	} else if(ns.equals(NS_DOC_MML)){
        	return NS_DEFAULT_MML;
    	} else {
    		return ns;
    	}
    }
    
    /**
     * Transforms the given default namespace to the one corresponding to the document version used 
     * to construct this {@link NamespaceFilter}.
     * @param ns One of the default PharmML namespaces (latest version)
     * @return The namespace URI as written in the given document version.
     */
    private String filterOutputNamespace(String ns){
    	if(ns == null){
    		return null;
    	}
    	if(ns.equals(NS_DEFAULT_CT)){
    		return NS_DOC_CT;
    	} else if(ns.equals(NS_DEFAULT_DS)){
        	return NS_DOC_DS;
    	} else if(ns.equals(NS_DEFAULT_MATH)){
        	return NS_DOC_MATH;
    	} else if(ns.equals(NS_DEFAULT_MDEF)){
        	return NS_DOC_MDEF;
    	} else if(ns.equals(NS_DEFAULT_MSTEPS)){
        	return NS_DOC_MSTEPS;
    	} else if(ns.equals(NS_DEFAULT_TD)){
        	return NS_DOC_TD;
    	} else if(ns.equals(NS_DEFAULT_MML)){
        	return NS_DOC_MML;
    	} else {
    		return ns;
    	}
    }
    
    /**
     * Converts the given input stream to a filtered stream reader. The input stream must
     * be a model encoded with the version used to construct this {@link XMLFilter}. The output
     * of this method is the same model, but with the namespaces changed to the default ones, i.e.
     * the namespaces used by JAXB annotations in libPharmML.
     * @param is {@link InputStream} of a PharmML model.
     * @return {@link XMLStreamReader} implementation resulting of the namespace filtering of the input model.
     * @throws XMLStreamException If error in parsing.
     */
    public final XMLStreamReader getXMLStreamReader(final InputStream is) throws XMLStreamException{
    	
    	XMLStreamReader filterReader = new XMLStreamReader(){
    		
    		XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(is);

			public Object getProperty(String name) throws IllegalArgumentException {
				return reader.getProperty(name);
			}

			public int next() throws XMLStreamException {
				return reader.next();
			}

			public void require(int type, String namespaceURI, String localName) throws XMLStreamException {
				reader.require(type, filterInputNamespace(namespaceURI), localName);
			}

			public String getElementText() throws XMLStreamException {
				return reader.getElementText();
			}

			public int nextTag() throws XMLStreamException {
				return reader.nextTag();
			}

			public boolean hasNext() throws XMLStreamException {
				return reader.hasNext();
			}

			public void close() throws XMLStreamException {
				reader.close();
			}

			public String getNamespaceURI(String prefix) {
				return filterInputNamespace(reader.getNamespaceURI(prefix));
			}

			public boolean isStartElement() {
				return reader.isStartElement();
			}

			public boolean isEndElement() {
				return reader.isEndElement();
			}

			public boolean isCharacters() {
				return reader.isCharacters();
			}

			public boolean isWhiteSpace() {
				return reader.isWhiteSpace();
			}

			public String getAttributeValue(String namespaceURI, String localName) {
				return reader.getAttributeValue(filterInputNamespace(namespaceURI), localName);
			}

			public int getAttributeCount() {
				return reader.getAttributeCount();
			}

			public QName getAttributeName(int index) {
				return reader.getAttributeName(index);
			}

			public String getAttributeNamespace(int index) {
				return filterInputNamespace(reader.getAttributeNamespace(index));
			}

			public String getAttributeLocalName(int index) {
				return reader.getAttributeLocalName(index);
			}

			public String getAttributePrefix(int index) {
				return reader.getAttributePrefix(index);
			}

			public String getAttributeType(int index) {
				return reader.getAttributeType(index);
			}

			public String getAttributeValue(int index) {
				return reader.getAttributeValue(index);
			}

			public boolean isAttributeSpecified(int index) {
				return reader.isAttributeSpecified(index);
			}

			public int getNamespaceCount() {
				return reader.getNamespaceCount();
			}

			public String getNamespacePrefix(int index) {
				return reader.getNamespacePrefix(index);
			}

			public String getNamespaceURI(int index) {
				return filterInputNamespace(reader.getNamespaceURI(index));
			}

			public NamespaceContext getNamespaceContext() {
				final NamespaceContext context = reader.getNamespaceContext();
				return new NamespaceContext() {
					
					@Override
					public Iterator<?> getPrefixes(String namespaceURI) {
						return context.getPrefixes(namespaceURI);
					}
					
					@Override
					public String getPrefix(String namespaceURI) {
						return context.getPrefix(namespaceURI);
					}
					
					@Override
					public String getNamespaceURI(String prefix) {
						return filterInputNamespace(context.getNamespaceURI(prefix));
					}
				};
			}

			public int getEventType() {
				return reader.getEventType();
			}

			public String getText() {
				return reader.getText();
			}

			public char[] getTextCharacters() {
				return reader.getTextCharacters();
			}

			public int getTextCharacters(int sourceStart, char[] target, int targetStart, int length)
					throws XMLStreamException {
				return reader.getTextCharacters(sourceStart, target, targetStart, length);
			}

			public int getTextStart() {
				return reader.getTextStart();
			}

			public int getTextLength() {
				return reader.getTextLength();
			}

			public String getEncoding() {
				return reader.getEncoding();
			}

			public boolean hasText() {
				return reader.hasText();
			}

			public Location getLocation() {
				return reader.getLocation();
			}

			public QName getName() {
				QName qname = reader.getName();
				QName newQname = new QName(filterInputNamespace(qname.getNamespaceURI()), 
						qname.getLocalPart(), 
						qname.getPrefix());
				return newQname;
			}

			public String getLocalName() {
				return reader.getLocalName();
			}

			public boolean hasName() {
				return reader.hasName();
			}

			public String getNamespaceURI() {
				return filterInputNamespace(reader.getNamespaceURI());
			}

			public String getPrefix() {
				return reader.getPrefix();
			}

			public String getVersion() {
				return reader.getVersion();
			}

			public boolean isStandalone() {
				return reader.isStandalone();
			}

			public boolean standaloneSet() {
				return reader.standaloneSet();
			}

			public String getCharacterEncodingScheme() {
				return reader.getCharacterEncodingScheme();
			}

			public String getPITarget() {
				return reader.getPITarget();
			}

			public String getPIData() {
				return reader.getPIData();
			}

			
    		
    	};
    	
    	return filterReader;
    }
    
    public final XMLStreamWriter getXMLStreamWriter(final XMLStreamWriter writer) throws XMLStreamException{
    	
    	return new XMLStreamWriter() {
			
			/**
			 * @param localName
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeStartElement(java.lang.String)
			 */
			public void writeStartElement(String localName) throws XMLStreamException {
				writer.writeStartElement(localName);
			}

			/**
			 * @param namespaceURI
			 * @param localName
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeStartElement(java.lang.String, java.lang.String)
			 */
			public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
				writer.writeStartElement(filterOutputNamespace(namespaceURI), localName);
			}

			/**
			 * @param namespaceURI
			 * @param localName
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String, java.lang.String)
			 */
			public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
				writer.writeEmptyElement(filterOutputNamespace(namespaceURI), localName);
			}

			/**
			 * @param prefix
			 * @param localName
			 * @param namespaceURI
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String, java.lang.String, java.lang.String)
			 */
			public void writeEmptyElement(String prefix, String localName, String namespaceURI)
					throws XMLStreamException {
				writer.writeEmptyElement(prefix, localName, filterOutputNamespace(namespaceURI));
			}

			/**
			 * @param localName
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String)
			 */
			public void writeEmptyElement(String localName) throws XMLStreamException {
				writer.writeEmptyElement(localName);
			}

			/**
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEndElement()
			 */
			public void writeEndElement() throws XMLStreamException {
				writer.writeEndElement();
			}

			/**
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEndDocument()
			 */
			public void writeEndDocument() throws XMLStreamException {
				writer.writeEndDocument();
			}

			/**
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#close()
			 */
			public void close() throws XMLStreamException {
				writer.close();
			}

			/**
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#flush()
			 */
			public void flush() throws XMLStreamException {
				writer.flush();
			}

			/**
			 * @param localName
			 * @param value
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String)
			 */
			public void writeAttribute(String localName, String value) throws XMLStreamException {
				writer.writeAttribute(localName, value);
			}

			/**
			 * @param prefix
			 * @param namespaceURI
			 * @param localName
			 * @param value
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
			 */
			public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
					throws XMLStreamException {
				writer.writeAttribute(prefix, filterOutputNamespace(namespaceURI), localName, value);
			}

			/**
			 * @param namespaceURI
			 * @param localName
			 * @param value
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String, java.lang.String)
			 */
			public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
				writer.writeAttribute(filterOutputNamespace(namespaceURI), localName, value);
			}

			/**
			 * @param prefix
			 * @param namespaceURI
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeNamespace(java.lang.String, java.lang.String)
			 */
			public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
				writer.writeNamespace(prefix, filterOutputNamespace(namespaceURI));
			}

			/**
			 * @param namespaceURI
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeDefaultNamespace(java.lang.String)
			 */
			public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
				writer.writeDefaultNamespace(filterOutputNamespace(namespaceURI));
			}

			/**
			 * @param data
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeComment(java.lang.String)
			 */
			public void writeComment(String data) throws XMLStreamException {
				writer.writeComment(data);
			}

			/**
			 * @param target
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeProcessingInstruction(java.lang.String)
			 */
			public void writeProcessingInstruction(String target) throws XMLStreamException {
				writer.writeProcessingInstruction(target);
			}

			/**
			 * @param target
			 * @param data
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeProcessingInstruction(java.lang.String, java.lang.String)
			 */
			public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
				writer.writeProcessingInstruction(target, data);
			}

			/**
			 * @param data
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeCData(java.lang.String)
			 */
			public void writeCData(String data) throws XMLStreamException {
				writer.writeCData(data);
			}

			/**
			 * @param dtd
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeDTD(java.lang.String)
			 */
			public void writeDTD(String dtd) throws XMLStreamException {
				writer.writeDTD(dtd);
			}

			/**
			 * @param name
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeEntityRef(java.lang.String)
			 */
			public void writeEntityRef(String name) throws XMLStreamException {
				writer.writeEntityRef(name);
			}

			/**
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument()
			 */
			public void writeStartDocument() throws XMLStreamException {
				writer.writeStartDocument();
			}

			/**
			 * @param version
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument(java.lang.String)
			 */
			public void writeStartDocument(String version) throws XMLStreamException {
				writer.writeStartDocument(version);
			}

			/**
			 * @param encoding
			 * @param version
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument(java.lang.String, java.lang.String)
			 */
			public void writeStartDocument(String encoding, String version) throws XMLStreamException {
				writer.writeStartDocument(encoding, version);
			}

			/**
			 * @param text
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(java.lang.String)
			 */
			public void writeCharacters(String text) throws XMLStreamException {
				writer.writeCharacters(text);
			}

			/**
			 * @param text
			 * @param start
			 * @param len
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(char[], int, int)
			 */
			public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
				writer.writeCharacters(text, start, len);
			}

			/**
			 * @param uri
			 * @return
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#getPrefix(java.lang.String)
			 */
			public String getPrefix(String uri) throws XMLStreamException {
				return writer.getPrefix(filterOutputNamespace(uri));
			}

			/**
			 * @param prefix
			 * @param uri
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#setPrefix(java.lang.String, java.lang.String)
			 */
			public void setPrefix(String prefix, String uri) throws XMLStreamException {
				writer.setPrefix(prefix, filterOutputNamespace(uri));
			}

			/**
			 * @param uri
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#setDefaultNamespace(java.lang.String)
			 */
			public void setDefaultNamespace(String uri) throws XMLStreamException {
				writer.setDefaultNamespace(filterOutputNamespace(uri));
			}

			/**
			 * @param context
			 * @throws XMLStreamException
			 * @see javax.xml.stream.XMLStreamWriter#setNamespaceContext(javax.xml.namespace.NamespaceContext)
			 */
			public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
				writer.setNamespaceContext(context);
			}

			/**
			 * @return
			 * @see javax.xml.stream.XMLStreamWriter#getNamespaceContext()
			 */
			public NamespaceContext getNamespaceContext() {
				return writer.getNamespaceContext();
			}

			/**
			 * @param name
			 * @return
			 * @throws IllegalArgumentException
			 * @see javax.xml.stream.XMLStreamWriter#getProperty(java.lang.String)
			 */
			public Object getProperty(String name) throws IllegalArgumentException {
				return writer.getProperty(name);
			}

			@Override
			public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
				writer.writeStartElement(prefix, localName, filterOutputNamespace(namespaceURI));
			}
			
		};
    }
    
    /**
     * Creates a filtering {@link XMLStreamWriter} which will write the proper namespaces URIs for the given
     * document version.
     * @param os Output of the filtered XML.
     * @return {@link XMLStreamWriter} implementation which will dynamically change the namespaces.
     * @throws XMLStreamException If error in writing.
     */
    public final XMLStreamWriter getXMLStreamWriter(OutputStream os) throws XMLStreamException{
    	return getXMLStreamWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(os));
    }
    
    public final XMLStreamWriter getXMLStreamWriter(Writer writer) throws XMLStreamException{
    	return getXMLStreamWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(writer));
    }
    
    void filterRawText(InputStream is, OutputStream os) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(is));
    	String line = null;
    	OutputStreamWriter osw = new OutputStreamWriter(os);
    	while((line = br.readLine()) != null){
    		line = line.replaceAll("xmlns(:\\w+)?=\"http://www.pharmml.org/[^\"]+/([^\"]+)\"",
    				"xmlns$1=\""+ NS_DOC_ROOT +"$2\"");
    		line = line.replaceAll("xmlns(:\\w+)?=\"http://www.pharmml.org/[^\"]+/ProbOnto\"",
    				"xmlns$1=\"http://www.pharmml.org/probonto/ProbOnto\""); //TODO: smarter regex to avoid rereplacing
    		line = line.replaceAll("xmlns(:\\w+)?=\"http://www.pharmml.org/2013/03/Dataset",
    				"xmlns$1=\"http://www.pharmml.org/2013/08/Dataset");
    		osw.append(line);
    		osw.append("\n");
    	}
    	br.close();
    	osw.close();
    }
    
    /**
     * Gets the URI corresponding to the version used to construct this filter.
     * @return The full namespace URI of PharmML root domain (mml).
     */
    public String getMMLNamespaceURI(){
    	return NS_DOC_MML;
    }

}
