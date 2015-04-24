package eu.ddmore.libpharmml.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

//import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

public class XMLFilter extends XMLFilterImpl {
	
	static final private String NS_PATTERN_ROOT = "http://www.pharmml.org/pharmml/%s/";
	static final protected String NS_PATTERN_CT = NS_PATTERN_ROOT + "CommonTypes";
	static final protected String NS_PATTERN_DS = NS_PATTERN_ROOT + "Dataset";
	static final protected String NS_PATTERN_MATH = NS_PATTERN_ROOT + "Maths";
	static final protected String NS_PATTERN_MDEF = NS_PATTERN_ROOT + "ModelDefinition";
	static final protected String NS_PATTERN_TD = NS_PATTERN_ROOT + "TrialDesign";
	static final protected String NS_PATTERN_MSTEPS = NS_PATTERN_ROOT + "ModellingSteps";
	static final public String NS_PATTERN_MML = NS_PATTERN_ROOT + "PharmML";
	
	static final private PharmMLVersion DEFAULT_VERSION = PharmMLVersion.V0_6;
	static final public String NS_DEFAULT_CT = String.format(NS_PATTERN_CT, DEFAULT_VERSION);
	static final public String NS_DEFAULT_DS = String.format(NS_PATTERN_DS, DEFAULT_VERSION);
	static final public String NS_DEFAULT_MATH = String.format(NS_PATTERN_MATH, DEFAULT_VERSION);
	static final public String NS_DEFAULT_MDEF = String.format(NS_PATTERN_MDEF, DEFAULT_VERSION);
	static final public String NS_DEFAULT_TD = String.format(NS_PATTERN_TD, DEFAULT_VERSION);
	static final public String NS_DEFAULT_MSTEPS = String.format(NS_PATTERN_MSTEPS, DEFAULT_VERSION);
	static final public String NS_DEFAULT_MML = String.format(NS_PATTERN_MML, DEFAULT_VERSION);
	
	final protected String NS_DOC_CT;
	final protected String NS_DOC_DS;
	final protected String NS_DOC_MATH;
	final protected String NS_DOC_MDEF;
	final protected String NS_DOC_TD;
	final protected String NS_DOC_MSTEPS;
	final protected String NS_DOC_MML;

	static final private String NS_OLD_ROOT = "http://www.pharmml.org/2013/03/";
	
	static final public String NS_OLD_CT = NS_OLD_ROOT + "CommonTypes";
	static final public String NS_OLD_DS = "http://www.pharmml.org/2013/08/Dataset";
	static final public String NS_OLD_MATH = NS_OLD_ROOT + "Maths";
	static final public String NS_OLD_MDEF = NS_OLD_ROOT + "ModelDefinition";
	static final public String NS_OLD_TD = NS_OLD_ROOT + "TrialDesign";
	static final public String NS_OLD_MSTEPS = NS_OLD_ROOT + "ModellingSteps";
	static final public String NS_OLD_MML = NS_OLD_ROOT + "PharmML";
	
	private final PharmMLVersion version;

    public XMLFilter(PharmMLVersion writtenVersion) {
        super();
        
        if(writtenVersion == null){
        	throw new IllegalArgumentException("Written version cannot be null");
        }
        
        this.version = writtenVersion;
        
        if(writtenVersion.isEqualOrLaterThan(PharmMLVersion.V0_6)){
        	NS_DOC_CT = String.format(NS_PATTERN_CT, writtenVersion);
        	NS_DOC_DS = String.format(NS_PATTERN_DS, writtenVersion);
        	NS_DOC_MATH = String.format(NS_PATTERN_MATH, writtenVersion);
        	NS_DOC_MDEF = String.format(NS_PATTERN_MDEF, writtenVersion);
        	NS_DOC_TD = String.format(NS_PATTERN_TD, writtenVersion);
        	NS_DOC_MSTEPS = String.format(NS_PATTERN_MSTEPS, writtenVersion);
        	NS_DOC_MML = String.format(NS_PATTERN_MML, writtenVersion);
        } else {
        	NS_DOC_CT = NS_OLD_CT;
        	NS_DOC_DS = NS_OLD_DS;
        	NS_DOC_MATH = NS_OLD_MATH;
        	NS_DOC_MDEF = NS_OLD_MDEF;
        	NS_DOC_TD = NS_OLD_TD;
        	NS_DOC_MSTEPS = NS_OLD_MSTEPS;
        	NS_DOC_MML = NS_OLD_MML;
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

//    @Override
//    public void startPrefixMapping(String prefix, String url)
//            throws SAXException {
//
//
//        if (addNamespace) {
//            this.startControlledPrefixMapping();
//        } else {
//            //Remove the namespace, i.e. don´t call startPrefixMapping for parent!
//        }
//
//    }

//    private void startControlledPrefixMapping() throws SAXException {
//
//        if (this.addNamespace && !this.addedNamespace) {
//            //We should add namespace since it is set and has not yet been done.
//            super.startPrefixMapping("", this.usedNamespaceUri);
//
//            //Make sure we dont do it twice
//            this.addedNamespace = true;
//        }
//    }

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
    		return NS_OLD_CT;
    	} else if(ns.equals(NS_DOC_DS)){
        	return NS_OLD_DS;
    	} else if(ns.equals(NS_DOC_MATH)){
        	return NS_OLD_MATH;
    	} else if(ns.equals(NS_DOC_MDEF)){
        	return NS_OLD_MDEF;
    	} else if(ns.equals(NS_DOC_MSTEPS)){
        	return NS_OLD_MSTEPS;
    	} else if(ns.equals(NS_DOC_TD)){
        	return NS_OLD_TD;
    	} else if(ns.equals(NS_DOC_MML)){
        	return NS_OLD_MML;
    	} else {
    		return ns;
    	}
    }
    
    private String filterOutputNamespace(String ns){
    	if(ns == null){
    		return null;
    	}
    	if(ns.equals(NS_OLD_CT)){
    		return NS_DOC_CT;
    	} else if(ns.equals(NS_OLD_DS)){
        	return NS_DOC_DS;
    	} else if(ns.equals(NS_OLD_MATH)){
        	return NS_DOC_MATH;
    	} else if(ns.equals(NS_OLD_MDEF)){
        	return NS_DOC_MDEF;
    	} else if(ns.equals(NS_OLD_MSTEPS)){
        	return NS_DOC_MSTEPS;
    	} else if(ns.equals(NS_OLD_TD)){
        	return NS_DOC_TD;
    	} else if(ns.equals(NS_OLD_MML)){
        	return NS_DOC_MML;
    	} else {
    		return ns;
    	}
    }
    
    public XMLStreamReader getXMLStreamReader(final InputStream is) throws XMLStreamException{
    	
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
					public Iterator getPrefixes(String namespaceURI) {
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
    
//    @Deprecated
//    public XMLStreamWriter getXMLStreamWriter(final OutputStream stream) throws XMLStreamException{
//    	
//    	XMLStreamWriter filterWriter =  new XMLStreamWriter() {
//    		
//    		XMLStreamWriter writer = new IndentingXMLStreamWriter(XMLOutputFactory.newFactory().createXMLStreamWriter(stream));
//
//			@Override
//			public void writeStartElement(String localName) throws XMLStreamException {
//				writer.writeStartElement(localName);
//			}
//
//			@Override
//			public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
//				writer.writeStartElement(filterOutputNamespace(namespaceURI), localName);
//			}
//
//			@Override
//			public void writeStartElement(String prefix, String localName, String namespaceURI)
//					throws XMLStreamException {
//				writer.writeStartElement(prefix, localName, filterOutputNamespace(namespaceURI));
//			}
//
//			@Override
//			public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
//				writer.writeEmptyElement(filterOutputNamespace(namespaceURI), localName);
//			}
//
//			@Override
//			public void writeEmptyElement(String prefix, String localName, String namespaceURI)
//					throws XMLStreamException {
//				writer.writeEmptyElement(prefix, localName, filterOutputNamespace(namespaceURI));
//			}
//
//			@Override
//			public void writeEmptyElement(String localName) throws XMLStreamException {
//				writer.writeEmptyElement(localName);
//			}
//
//			@Override
//			public void writeEndElement() throws XMLStreamException {
//				writer.writeEndElement();
//			}
//
//			@Override
//			public void writeEndDocument() throws XMLStreamException {
//				writer.writeEndDocument();
//			}
//
//			@Override
//			public void close() throws XMLStreamException {
//				writer.close();
//			}
//
//			@Override
//			public void flush() throws XMLStreamException {
//				writer.flush();
//			}
//
//			@Override
//			public void writeAttribute(String localName, String value) throws XMLStreamException {
//				writer.writeAttribute(localName, value);
//			}
//
//			@Override
//			public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
//					throws XMLStreamException {
//				writer.writeAttribute(prefix, filterOutputNamespace(namespaceURI), localName, value);
//			}
//
//			@Override
//			public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
//				writer.writeAttribute(filterOutputNamespace(namespaceURI), localName, value);
//			}
//
//			@Override
//			public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
//				writer.writeNamespace(prefix, filterOutputNamespace(namespaceURI));
//			}
//
//			@Override
//			public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
//				writer.writeDefaultNamespace(filterOutputNamespace(namespaceURI));
//			}
//
//			@Override
//			public void writeComment(String data) throws XMLStreamException {
//				writer.writeComment(data);
//			}
//
//			@Override
//			public void writeProcessingInstruction(String target) throws XMLStreamException {
//				writer.writeProcessingInstruction(target);
//			}
//
//			@Override
//			public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
//				writer.writeProcessingInstruction(target, data);
//			}
//
//			@Override
//			public void writeCData(String data) throws XMLStreamException {
//				writer.writeCData(data);
//			}
//
//			@Override
//			public void writeDTD(String dtd) throws XMLStreamException {
//				writer.writeDTD(dtd);
//			}
//
//			@Override
//			public void writeEntityRef(String name) throws XMLStreamException {
//				writer.writeEntityRef(name);
//			}
//
//			@Override
//			public void writeStartDocument() throws XMLStreamException {
//				writer.writeStartDocument();
//			}
//
//			@Override
//			public void writeStartDocument(String version) throws XMLStreamException {
//				writer.writeStartDocument(version);
//			}
//
//			@Override
//			public void writeStartDocument(String encoding, String version) throws XMLStreamException {
//				writer.writeStartDocument(encoding, version);
//			}
//
//			@Override
//			public void writeCharacters(String text) throws XMLStreamException {
//				writer.writeCharacters(text);
//			}
//
//			@Override
//			public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
//				writer.writeCharacters(text, start, len);
//			}
//
//			@Override
//			public String getPrefix(String uri) throws XMLStreamException {
//				return writer.getPrefix(filterOutputNamespace(uri));
//			}
//
//			@Override
//			public void setPrefix(String prefix, String uri) throws XMLStreamException {
//				writer.setPrefix(prefix, filterOutputNamespace(uri));
//			}
//
//			@Override
//			public void setDefaultNamespace(String uri) throws XMLStreamException {
//				writer.setDefaultNamespace(filterOutputNamespace(uri));
//			}
//
//			@Override
//			public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
//				writer.setNamespaceContext(context);
//			}
//
//			@Override
//			public NamespaceContext getNamespaceContext() {
//				return writer.getNamespaceContext();
//			}
//
//			@Override
//			public Object getProperty(String name) throws IllegalArgumentException {
//				return writer.getProperty(name);
//			}
//    		
//    	};
//    	
//    	return filterWriter;
//    }
    
    void filterRawText(InputStream is, OutputStream os) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(is));
    	String line = null;
    	OutputStreamWriter osw = new OutputStreamWriter(os);
    	while((line = br.readLine()) != null){
    		line = line.replaceAll("xmlns(:\\w+)?=\"http://www.pharmml.org/[^\"]+/([^\"]+)\"",
    				"xmlns$1=\"http://www.pharmml.org/pharmml/"+ version.toString() +"/$2\"");
    		osw.append(line);
    		osw.append("\n");
    	}
    	br.close();
    	osw.close();
    }

}
