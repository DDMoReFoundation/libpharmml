/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml.dom;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.VectorValue;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameter;
import eu.ddmore.libpharmml.dom.modeldefn.GaussianObsError;
import eu.ddmore.libpharmml.dom.modeldefn.GeneralObsError;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationError;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.SimpleParameter;
import eu.ddmore.libpharmml.dom.uncertml.AbstractCategoricalMultivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractCategoricalUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractDiscreteMultivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.AbstractDiscreteUnivariateDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.BernoulliDistribution;
import eu.ddmore.libpharmml.dom.uncertml.BinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalDistribution;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalMultivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteMultivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteUnivariateMixtureModel;
import eu.ddmore.libpharmml.dom.uncertml.GeometricDistribution;
import eu.ddmore.libpharmml.dom.uncertml.HypergeometricDistribution;
import eu.ddmore.libpharmml.dom.uncertml.MultinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.NegativeBinomialDistribution;
import eu.ddmore.libpharmml.dom.uncertml.PoissonDistribution;
import eu.ddmore.libpharmml.dom.uncertml.WishartDistribution;

/**
 * Class for providing static intances of object factories and avoid multiples instances of them.
 * 
 * @author Florent Yvon
 *
 */
public class MasterObjectFactory {
	
	public static ObjectFactory ROOT_OF = new ObjectFactory();
	public static eu.ddmore.libpharmml.dom.commontypes.ObjectFactory COMMONTYPES_OF = new eu.ddmore.libpharmml.dom.commontypes.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.dataset.ObjectFactory DATASET_OF = new eu.ddmore.libpharmml.dom.dataset.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.maths.ObjectFactory MATHS_OF = new eu.ddmore.libpharmml.dom.maths.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory MODELDEFN_OF = new eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.modellingsteps.ObjectFactory MODELLINGSTEPS_OF = new eu.ddmore.libpharmml.dom.modellingsteps.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.trialdesign.ObjectFactory TRIALDESIGN_OF = new eu.ddmore.libpharmml.dom.trialdesign.ObjectFactory();
	public static eu.ddmore.libpharmml.dom.uncertml.ObjectFactory UNCERTML_OF = new eu.ddmore.libpharmml.dom.uncertml.ObjectFactory();
	
	/**
	 * Creates a proper {@link JAXBElement} from {@link Scalar}
	 * @param scalar
	 * @return
	 */
	public static JAXBElement<? extends Scalar> createScalar(Scalar scalar){
		JAXBElement<? extends Scalar> element;
		if(scalar instanceof IntValue){
			element = COMMONTYPES_OF.createInt((IntValue) scalar);
		} else if(scalar instanceof RealValue){
			element = COMMONTYPES_OF.createReal((RealValue) scalar);
		} else if(scalar instanceof StringValue){
			element = COMMONTYPES_OF.createString((StringValue) scalar);
		} else if(scalar instanceof IdValue){
			element = COMMONTYPES_OF.createId((IdValue) scalar);
		} else if(scalar instanceof BooleanValue){
			if(scalar instanceof TrueBoolean){
				element = COMMONTYPES_OF.createTrue((TrueBoolean) scalar);
			} else {
				element = COMMONTYPES_OF.createFalse((FalseBoolean) scalar);
			}
		} else {
			throw new IllegalArgumentException("Unknown scalar type");
		}
		return element;
	}
	
	/**
	 * Creates a {@link JAXBElement} from {@link AbstractDiscreteUnivariateDistributionType}.
	 * Authorized types are {@link GeometricDistribution }
     *     {@link HypergeometricDistribution }
     *     {@link NegativeBinomialDistribution }
     *     {@link AbstractDiscreteUnivariateDistributionType }
     *     {@link PoissonDistribution }
     *     {@link BinomialDistribution }
     *     {@link DiscreteUnivariateMixtureModel }.
	 * @param distrib
	 * @return
	 */
	public static JAXBElement<? extends AbstractDiscreteUnivariateDistributionType> createDiscreteUnivariateDistribution(AbstractDiscreteUnivariateDistributionType distrib){
		JAXBElement<? extends AbstractDiscreteUnivariateDistributionType> element;
		if(distrib instanceof GeometricDistribution){
			element = UNCERTML_OF.createGeometricDistribution((GeometricDistribution) distrib);
		} else if(distrib instanceof NegativeBinomialDistribution){
			element = UNCERTML_OF.createNegativeBinomialDistribution((NegativeBinomialDistribution) distrib);
		} else if(distrib instanceof PoissonDistribution){
			element = UNCERTML_OF.createPoissonDistribution((PoissonDistribution) distrib);
		} else if(distrib instanceof DiscreteUnivariateMixtureModel){
			element = UNCERTML_OF.createDiscreteUnivariateMixtureModel((DiscreteUnivariateMixtureModel) distrib);
		} else if(distrib instanceof BinomialDistribution){
			element = UNCERTML_OF.createBinomialDistribution((BinomialDistribution) distrib);
		} else if(distrib instanceof HypergeometricDistribution){
			element = UNCERTML_OF.createHypergeometricDistribution((HypergeometricDistribution) distrib);
		} else {
			element = UNCERTML_OF.createAbstractDiscreteUnivariateDistribution(distrib);
		}
		return element;
	}
	
	/**
	 * Creates a {@link JAXBElement} from {@link AbstractDiscreteMultivariateDistributionType}.
	 * Authorized types are {@link MultinomialDistribution }
     *     {@link WishartDistribution }
     *     {@link DiscreteMultivariateMixtureModel }.
	 * @param distrib
	 * @return
	 */
	public static JAXBElement<? extends AbstractDiscreteMultivariateDistributionType> createDiscreteMultivariateDistribution(AbstractDiscreteMultivariateDistributionType distrib){
		JAXBElement<? extends AbstractDiscreteMultivariateDistributionType> element;
		if(distrib instanceof MultinomialDistribution){
			element = UNCERTML_OF.createMultinomialDistribution((MultinomialDistribution) distrib);
		} else if (distrib instanceof WishartDistribution) {
			element = UNCERTML_OF.createWishartDistribution((WishartDistribution) distrib);
		} else if (distrib instanceof DiscreteMultivariateMixtureModel){
			element = UNCERTML_OF.createDiscreteMultivariateMixtureModel((DiscreteMultivariateMixtureModel) distrib);
		} else {
			element = UNCERTML_OF.createAbstractDiscreteMultivariateDistribution(distrib);
		}
		return element;
	}
	
	/**
	 * Creates a {@link JAXBElement} from {@link AbstractCategoricalUnivariateDistributionType}.
	 * Authorized types are {@link BernoulliDistribution }
     *     {@link CategoricalUnivariateMixtureModel }.
	 * @param distrib
	 * @return
	 */
	public static JAXBElement<? extends AbstractCategoricalUnivariateDistributionType> createCategoricalUnivariateDistribution(AbstractCategoricalUnivariateDistributionType distrib){
		JAXBElement<? extends AbstractCategoricalUnivariateDistributionType> element;
		if(distrib instanceof BernoulliDistribution){
			element = UNCERTML_OF.createBernoulliDistribution((BernoulliDistribution) distrib);
		} else if (distrib instanceof CategoricalUnivariateMixtureModel){
			element = UNCERTML_OF.createCategoricalUnivariateMixtureModel((CategoricalUnivariateMixtureModel) distrib);
		} else {
			element = UNCERTML_OF.createAbstractCategoricalUnivariateDistribution(distrib);
		}
		return element;
	}
	
	/**
	 * Creates a {@link JAXBElement} from {@link AbstractCategoricalMultivariateDistributionType}.
	 * Authorized types are {@link CategoricalDistribution }
     *     {@link CategoricalMultivariateMixtureModel }.
	 * @param distrib
	 * @return
	 */
	public static JAXBElement<? extends AbstractCategoricalMultivariateDistributionType> createCategoricalMultivariateDistribution(AbstractCategoricalMultivariateDistributionType distrib){
		JAXBElement<? extends AbstractCategoricalMultivariateDistributionType> element;
		if(distrib instanceof CategoricalDistribution){
			element = UNCERTML_OF.createCategoricalDistribution((CategoricalDistribution) distrib);
		} else if(distrib instanceof CategoricalMultivariateMixtureModel){
			element = UNCERTML_OF.createCategoricalMultivariateMixtureModel((CategoricalMultivariateMixtureModel) distrib);
		} else {
			element = UNCERTML_OF.createAbstractCategoricalMultivariateDistribution(distrib);
		}
		return element;
	}
	
	public static JAXBElement<? extends ObservationError> createObservationError(ObservationError model){
		JAXBElement<? extends ObservationError> element;
		if(model instanceof GeneralObsError){
			element = MODELDEFN_OF.createGeneral((GeneralObsError) model);
		} else if (model instanceof GaussianObsError){
			element = MODELDEFN_OF.createStandard((GaussianObsError) model);
		} else {
			element = MODELDEFN_OF.createObservationError(model);
		} 
		return element;
	}
	
	public static JAXBElement<? extends CommonParameter> createParameter(CommonParameter param){
		JAXBElement<? extends CommonParameter> element;
		if(param instanceof ParameterRandomVariable){
			element = MODELDEFN_OF.createRandomVariable((ParameterRandomVariable) param);
		} else if(param instanceof SimpleParameter){
			element = MODELDEFN_OF.createSimpleParameter((SimpleParameter) param);
		} else if(param instanceof IndividualParameter){
			element = MODELDEFN_OF.createIndividualParameter((IndividualParameter) param);
		} else {
			element = MODELDEFN_OF.createCommonParameterElement(param);
		}
		return element;
	}
	
	public static JAXBElement<? extends VectorValue> createVectorValue(VectorValue value){
		JAXBElement<? extends VectorValue> element;
		if(value instanceof Scalar){
			element = createScalar((Scalar) value);
		} else if(value instanceof SymbolRef){
			element = COMMONTYPES_OF.createSymbRef((SymbolRef) value);
		} else if(value instanceof Sequence){
			element = COMMONTYPES_OF.createSequence((Sequence) value);
		} else {
			throw new RuntimeException("Unknown VectorValue type");
		}
		return element;
	}

}
