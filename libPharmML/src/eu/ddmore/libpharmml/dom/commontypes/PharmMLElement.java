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
package eu.ddmore.libpharmml.dom.commontypes;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.AbstractTreeNode;
import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.PharmMLNode;
import eu.ddmore.libpharmml.impl.IdFactoryImpl;
import eu.ddmore.libpharmml.impl.MarshalListener;
import eu.ddmore.libpharmml.impl.MarshallerImpl;
import eu.ddmore.libpharmml.impl.NamespaceFilter;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.UnmarshalListener;


/**
 * Abstract class for all PharmML-binded elements. Any XML element from PharmML must inherit from
 * this class.
 * @since libPharmML 0.3
 */
@XmlTransient
public abstract class PharmMLElement extends AbstractTreeNode implements Cloneable, PharmMLNode {
	
	@XmlTransient
	protected static final String NS_DEFAULT_CT = NamespaceFilter.NS_DEFAULT_CT;
	@XmlTransient
	protected static final String NS_DEFAULT_DS = NamespaceFilter.NS_DEFAULT_DS;
	@XmlTransient
	protected static final String NS_DEFAULT_MATH = NamespaceFilter.NS_DEFAULT_MATH;
	@XmlTransient
	protected static final String NS_DEFAULT_MDEF = NamespaceFilter.NS_DEFAULT_MDEF;
	@XmlTransient
	protected static final String NS_DEFAULT_MML = NamespaceFilter.NS_DEFAULT_MML;
	@XmlTransient
	protected static final String NS_DEFAULT_MSTEPS = NamespaceFilter.NS_DEFAULT_MSTEPS;
	@XmlTransient
	protected static final String NS_DEFAULT_PROBONTO = NamespaceFilter.NS_DEFAULT_PROBONTO;
	@XmlTransient
	protected static final String NS_DEFAULT_TD = NamespaceFilter.NS_DEFAULT_TD;
	@XmlTransient
	protected static final String NS_DEFAULT_UNCERTML = NamespaceFilter.NS_DEFAULT_UNCERTML;
	
	@XmlTransient
    private PharmMLVersion unmarshalVersion = null;
	
	/**
	 * Marshal version may be used by adapters to dynamically change the name or namespace of some
	 * elements depending on the PharmML version.
	 */
	@XmlTransient
	private PharmMLVersion marshalVersion = null;
	
	/**
	 * Each unmarshalled element has the version of PharmML that was used to encode the model.
	 * If the element has not been unmarshalled, this method returns null.
	 * @return the version on the PharmML document of which this element has been unmarshalled.
	 */
	@XmlTransient
	public final PharmMLVersion getUnmarshalVersion(){
    	return this.unmarshalVersion;
    }
	
	/**
	 * Sets the PharmML version used in the model where this element comes from. This method is called
	 * during the unmarshalling process and should never be used by the client.
	 * @param version The {@link PharmMLVersion} used in the read model.
	 */
    public final void setUnmarshalVersion(PharmMLVersion version){
    	this.unmarshalVersion = version;
    }
    
    /**
     * Gets the version of PharmML used to marshal this element. If this element has never been marshalled,
     * this method returns null. The version is updated every time a marshal process is performed.
     * @return The {@link PharmMLVersion} value used to marshal this element in the last performed marshalling.
     */
    @XmlTransient
    public final PharmMLVersion getMarshalVersion(){
    	return marshalVersion;
    }
    
    /**
     * Sets the PharmML version used to marshal this object. This method is used during the marshalling process
     * to update the version and should never be used by the client.
     * @param version The {@link PharmMLVersion} used for marshalling.
     */
    public final void setMarshalVersion(PharmMLVersion version){
    	this.marshalVersion = version;
    }
    
    /**
     * Makes a <b>deep</b> clone of this node. The returned object may be cast to the concrete type from which this
     * method is called. The value of the attribute "id" is not copied in this process, as they must be unique. The "id"
     * attribute value of the clones is null.
     * 
     * <p>When overriding this method, one can simply use {@link #clone(Class, PharmMLElement)} in the method code.
     */
    @Override
	public abstract PharmMLElement clone();
    
    /**
     * Utility method for cloning a {@link PharmMLElement} object. This method is meant to factorise the cloning code
     * using JAXB marshalling when the method {@link #clone()} needs to be implemented. The class used as a parameter
     * must be binded and known in the JAXB context.
     * 
     * <p>Usage:
     * <pre>
     * {@literal @}Override
     * public PharmMLElement clone(){
     * 		return clone(BindedClass.class,this);
     * }
     * </pre>
     * @param _class Class that must be known in the JAXB context.
     * @param source The object to be cloned.
     * @return The cloned object.
     */
    protected static <T extends PharmMLElement> T clone(Class<T> _class, T source){
    	try {
    		setMarshalVersion(source, PharmMLVersion.DEFAULT);
			JAXBContext jc = JAXBContext.newInstance(MarshallerImpl.CONTEXT_NAME);
			JAXBElement<T> origEl = new JAXBElement<T>(new QName("root"), _class, source);
			Marshaller m = jc.createMarshaller();
			
			MarshalListener ml = new MarshalListener(PharmMLVersion.DEFAULT, new IdFactoryImpl());
			ml.autosetId(false);
			m.setListener(ml);
			
			JAXBSource jaxbsource = new JAXBSource(m, origEl);
			Unmarshaller um = jc.createUnmarshaller();
			um.setListener(new CloningListener(PharmMLVersion.DEFAULT));
			JAXBElement<T> clonedJAXBElement = um.unmarshal(jaxbsource, _class);
			T clone = clonedJAXBElement.getValue();
	        return clone;
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
    }
    
    private static void setMarshalVersion(PharmMLElement node, PharmMLVersion version){
		node.setMarshalVersion(version);
		Enumeration<TreeNode> children = node.children();
		while(children.hasMoreElements()){
			TreeNode child = children.nextElement();
			if(child instanceof PharmMLElement){
				setMarshalVersion((PharmMLElement) child, version);
			}
		}
	}
    
    
    /**
     * Unmarshalistener used during cloning to delete the value of the "id" attribute of the clones.
     */
    @XmlTransient
    private static class CloningListener extends UnmarshalListener {

		public CloningListener(PharmMLVersion version) {
			super(version, new IdFactoryImpl(), new CloningErrorHandler());
		}
		
		@Override
		public void afterUnmarshal(Object target, Object parent) {
			super.afterUnmarshal(target, parent);
			if(target instanceof Identifiable){
				((Identifiable) target).setId(null);
			}
		}
    	
    }
    
    /**
     * Errorhandler used during cloning. As object don't need to be valid in order to be cloned,
     * this class doesn't do anything with the caught error messages.
     */
    @XmlTransient
    private static class CloningErrorHandler implements IErrorHandler {
    	

		@Override
		public void handleError(String errMsg) {
		}

		@Override
		public void handleError(String id, String errMsg) {
		}

		@Override
		public void handleError(String id, String errMsg, ValidationEventLocator locator) {
		}

		@Override
		public void handleError(String id, String errMsg, AbstractTreeNode invalidObject) {
		}

		@Override
		public void handleWarning(String warnMsg) {
		}
    	
    }

}
