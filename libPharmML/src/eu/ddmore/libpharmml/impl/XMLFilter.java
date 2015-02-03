package eu.ddmore.libpharmml.impl;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

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
	static final public String NS_OLD_DS = NS_OLD_ROOT + "Dataset";
	static final public String NS_OLD_MATH = NS_OLD_ROOT + "Maths";
	static final public String NS_OLD_MDEF = NS_OLD_ROOT + "ModelDefinition";
	static final public String NS_OLD_TD = NS_OLD_ROOT + "TrialDesign";
	static final public String NS_OLD_MSTEPS = NS_OLD_ROOT + "ModellingSteps";
	static final public String NS_OLD_MML = NS_OLD_ROOT + "PharmML";

    public XMLFilter(PharmMLVersion writtenVersion) {
        super();
        
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

        super.startElement(filterNamespace(arg0), arg1, arg2, arg3);
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2)
            throws SAXException {

        super.endElement(filterNamespace(arg0), arg1, arg2);
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
    private String filterNamespace(String ns){
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
    
    

}
