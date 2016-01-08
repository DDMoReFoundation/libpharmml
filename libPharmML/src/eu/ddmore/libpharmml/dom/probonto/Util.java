package eu.ddmore.libpharmml.dom.probonto;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.AbstractTreeNode;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

class Util {
	
	static void validateProbOnto(IProbOntoDistribution probOnto, IErrorHandler errorHandler){
		DistributionName name = probOnto.getName();
		if(name != null){
			ParameterName[] paramNames = name.requiredParameters();
			for(ParameterName requiredParam : paramNames){
				LoggerWrapper.getLogger().warning(requiredParam.toString());
				if(!probOnto.containsParameter(requiredParam)){
					errorHandler.handleError("undef", "Parameter \""+requiredParam.value()+"\" is missing in distribution +\""+name+"\".", (AbstractTreeNode) probOnto);
				}
			}
		}
	}

}
