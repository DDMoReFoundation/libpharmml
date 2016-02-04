package eu.ddmore.libpharmml.dom.probonto;

import java.util.Set;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.AbstractTreeNode;

class Util {
	
	static void validateProbOnto(IProbOntoDistribution probOnto, IErrorHandler errorHandler){
		DistributionName name = probOnto.getName();
		if(name != null){
			ParameterName[] requiredParamArray = name.requiredParameters();
			for(ParameterName requiredParam : requiredParamArray){
				if(!probOnto.containsParameter(requiredParam)){
					errorHandler.handleError("undef", "Parameter \""+requiredParam.value()+"\" is missing in distribution +\""+name+"\".", (AbstractTreeNode) probOnto);
				}
			}
			Set<ParameterName> allowedParamSet = name.allowedParameters();
			for(DistributionParameter distribParam : probOnto.getListOfParameter()){
				if(distribParam.getName() != null){
					if(!allowedParamSet.contains(distribParam.getName())){
						errorHandler.handleError("undef", "Parameter \""+distribParam.getName()+"\" does not exist for distribution "+name+".", (AbstractTreeNode) probOnto);
					}
				}
			}
		}
	}

}
