package eu.ddmore.libpharmml.dom.probonto;

import java.util.List;

import eu.ddmore.libpharmml.validation.Validatable;

public interface IProbOntoDistribution extends Validatable {
	
	public DistributionName getName();
	public void setName(DistributionName value);
	public List<DistributionParameter> getListOfParameter();
	public boolean containsParameter(ParameterName parameter);
	public DistributionParameter getParameter(ParameterName parameter);

}
