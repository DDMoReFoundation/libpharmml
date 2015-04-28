package eu.ddmore.libpharmml.impl;

import java.util.Hashtable;
import java.util.Map;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.IdFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.validation.PharmMLElementWrapper;

public class PharmMLResourceImpl implements IPharmMLResource {
	
	private final PharmML dom;
	private final IValidationReport creationReport;
	private IdFactory idFactory;
	
	private final Map<String,Boolean> parameters;
	
	PharmMLResourceImpl(PharmML dom, IValidationReport creationReport) {
		this.dom = dom;
		this.creationReport = creationReport;
		
		// Options
		parameters = new Hashtable<String, Boolean>();
		parameters.put(IPharmMLResource.AUTOSET_ID, Boolean.TRUE);
	}

	@Override
	public PharmML getDom() {
		return dom;
	}

	@Override
	public IValidationReport getCreationReport() {
		return creationReport;
	}

	@Override
	public Object find(String id) {
		PharmMLElementWrapper wrappedDom = new PharmMLElementWrapper(getDom());
		PharmMLElementWrapper foundWrappedEl = Utils.findById(wrappedDom, id);
		if(foundWrappedEl != null){
			return foundWrappedEl.getElement();
		} else {
			return null;
		}
	}

	@Override
	public IdFactory getIdFactory() {
		return idFactory;
	}

	@Override
	public void setIdFactory(IdFactory idFactory) {
		this.idFactory = idFactory;
	}

	@Override
	public void setParameter(String param, Boolean value) {
		parameters.put(param, value);
	}

	@Override
	public Boolean getParameter(String argument) {
		return parameters.get(argument);
	}

}
