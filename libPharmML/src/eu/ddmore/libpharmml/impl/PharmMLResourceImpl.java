package eu.ddmore.libpharmml.impl;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.IdFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.validation.PharmMLElementWrapper;

public class PharmMLResourceImpl implements IPharmMLResource {
	
	private final PharmML dom;
	private final IValidationReport creationReport;
	private IdFactory idFactory;
	
	PharmMLResourceImpl(PharmML dom, IValidationReport creationReport) {
		this.dom = dom;
		this.creationReport = creationReport;
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

}
