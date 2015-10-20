/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.modeldefn;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import static eu.ddmore.libpharmml.impl.XMLFilter.NS_DEFAULT_MDEF;;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.ddmore.libpharmml.dom.modeldefn package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StructuralModel_QNAME = new QName(NS_DEFAULT_MDEF, "StructuralModel");
    private final static QName _ModelDefinition_QNAME = new QName(NS_DEFAULT_MDEF, "ModelDefinition");
    private final static QName _General_QNAME = new QName(NS_DEFAULT_MDEF, "General");
    private final static QName _Probability_QNAME = new QName(NS_DEFAULT_MDEF, "Probability");
    private final static QName _Standard_QNAME = new QName(NS_DEFAULT_MDEF, "Standard");
    private final static QName _SimpleParameter_QNAME = new QName(NS_DEFAULT_MDEF, "SimpleParameter");
    private final static QName _IndividualParameter_QNAME = new QName(NS_DEFAULT_MDEF, "IndividualParameter");
    private final static QName _ObservationError_QNAME = new QName(NS_DEFAULT_MDEF, "ObservationError");
    private final static QName _CommonParameterElement_QNAME = new QName(NS_DEFAULT_MDEF, "CommonParameterElement");
    private final static QName _RandomVariable_QNAME = new QName(NS_DEFAULT_MDEF, "RandomVariable");

    // PharmML 0.7
    private final static QName _DesignParameter_QNAME = new QName(NS_DEFAULT_MDEF, "DesignParameter");
    private final static QName _PopulationParameter_QNAME = new QName(NS_DEFAULT_MDEF, "PopulationParameter");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.modeldefn
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IndividualParameter }
     * 
     */
    public IndividualParameter createIndividualParameterType() {
        return new IndividualParameter();
    }

    /**
     * Create an instance of {@link IndividualParameter.GaussianModel }
     * 
     */
    @Deprecated
    public IndividualParameter.GaussianModel createIndividualParameterTypeGaussianModel() {
        return new IndividualParameter.GaussianModel();
    }

    /**
     * Create an instance of {@link IndividualParameter.GaussianModel.LinearCovariate }
     * 
     */
    @Deprecated
    public IndividualParameter.GaussianModel.LinearCovariate createIndividualParameterTypeGaussianModelLinearCovariate() {
        return new IndividualParameter.GaussianModel.LinearCovariate();
    }

    /**
     * Create an instance of {@link GaussianObsError }
     * 
     */
    @Deprecated
    public GaussianObsError createGaussianObsError() {
        return new GaussianObsError();
    }

    /**
     * Create an instance of {@link ModelDefinition }
     * 
     */
    public ModelDefinition createModelDefinitionType() {
        return new ModelDefinition();
    }

    /**
     * Create an instance of {@link Probability }
     * 
     */
    public Probability createProbabilityType() {
        return new Probability();
    }

    /**
     * Create an instance of {@link StructuralModel }
     * 
     */
    public StructuralModel createStructuralModelType() {
        return new StructuralModel();
    }

    /**
     * Create an instance of {@link GeneralObsError }
     * 
     */
    public GeneralObsError createGeneralObsError() {
        return new GeneralObsError();
    }

    /**
     * Create an instance of {@link ParameterRandomVariable }
     * 
     */
    public ParameterRandomVariable createParameterRandomVariableType() {
        return new ParameterRandomVariable();
    }

    /**
     * Create an instance of {@link SimpleParameter }
     * 
     */
    @Deprecated
    public SimpleParameter createSimpleParameterType() {
        return new SimpleParameter();
    }

    /**
     * Create an instance of {@link ParentLevel }
     * 
     */
    public ParentLevel createParentLevelType() {
        return new ParentLevel();
    }

    /**
     * Create an instance of {@link TransitionRate }
     * 
     */
    public TransitionRate createTransitionRateType() {
        return new TransitionRate();
    }

    /**
     * Create an instance of {@link CovariateTransformation }
     * 
     */
    public CovariateTransformation createCovariateTransformationType() {
        return new CovariateTransformation();
    }

    /**
     * Create an instance of {@link Pairwise }
     * 
     */
    public Pairwise createPairwiseType() {
        return new Pairwise();
    }

    /**
     * Create an instance of {@link ContinuousObservationModel }
     * 
     */
    public ContinuousObservationModel createContinuousObservationModelType() {
        return new ContinuousObservationModel();
    }

    /**
     * Create an instance of {@link VariabilityLevelDefinition }
     * 
     */
    public VariabilityLevelDefinition createVariabilityLevelDefnType() {
        return new VariabilityLevelDefinition();
    }

    /**
     * Create an instance of {@link CountPMF }
     * 
     */
    public CountPMF createCountPMFType() {
        return new CountPMF();
    }

    /**
     * Create an instance of {@link Discrete }
     * 
     */
    public Discrete createDiscreteType() {
        return new Discrete();
    }

    /**
     * Create an instance of {@link TimeToEventData }
     * 
     */
    public TimeToEventData createTimeToEventDataType() {
        return new TimeToEventData();
    }

    /**
     * Create an instance of {@link VariabilityDefnBlock }
     * 
     */
    public VariabilityDefnBlock createVariabilityDefnBlock() {
        return new VariabilityDefnBlock();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategoryType() {
        return new Category();
    }

    /**
     * Create an instance of {@link ParameterModel }
     * 
     */
    public ParameterModel createParameterModelType() {
        return new ParameterModel();
    }

    /**
     * Create an instance of {@link CategoricalCovariate }
     * 
     */
    public CategoricalCovariate createCategoricalCovariateType() {
        return new CategoricalCovariate();
    }

    /**
     * Create an instance of {@link CovariateRelation }
     * 
     */
    public CovariateRelation createCovariateRelationType() {
        return new CovariateRelation();
    }

    /**
     * Create an instance of {@link CategoricalData }
     * 
     */
    public CategoricalData createCategoricalDataType() {
        return new CategoricalData();
    }

    /**
     * Create an instance of {@link CovariateModel }
     * 
     */
    public CovariateModel createCovariateModelType() {
        return new CovariateModel();
    }

    /**
     * Create an instance of {@link CountData }
     * 
     */
    public CountData createCountDataType() {
        return new CountData();
    }

    /**
     * Create an instance of {@link Censoring }
     * 
     */
    public Censoring createCensoringType() {
        return new Censoring();
    }

    /**
     * Create an instance of {@link FixedEffectRelation }
     * 
     */
    public FixedEffectRelation createFixedEffectRelationType() {
        return new FixedEffectRelation();
    }

    /**
     * Create an instance of {@link CommonDiscreteState }
     * 
     */
    public CommonDiscreteState createCommonDiscreteStateType() {
        return new CommonDiscreteState();
    }

    /**
     * Create an instance of {@link ObservationModel }
     * 
     */
    public ObservationModel createObservationModelType() {
        return new ObservationModel();
    }

    /**
     * Create an instance of {@link CensoringFeature }
     * 
     */
    @Deprecated
    public CensoringFeature createCensoringFeatureType() {
        return new CensoringFeature();
    }

    /**
     * Create an instance of {@link DiscreteDataParameter }
     * 
     */
    public DiscreteDataParameter createDiscreteDataParameterType() {
        return new DiscreteDataParameter();
    }

    /**
     * Create an instance of {@link ProbabilityAssignment }
     * 
     */
    public ProbabilityAssignment createProbabilityAssignmentType() {
        return new ProbabilityAssignment();
    }

    /**
     * Create an instance of {@link ListOfCategories }
     * 
     */
    public ListOfCategories createListOfCategoriesType() {
        return new ListOfCategories();
    }

    /**
     * Create an instance of {@link Correlation }
     * 
     */
    public Correlation createCorrelationType() {
        return new Correlation();
    }

    /**
     * Create an instance of {@link CommonDiscreteVariable }
     * 
     */
    public CommonDiscreteVariable createCommonDiscreteVariableType() {
        return new CommonDiscreteVariable();
    }

    /**
     * Create an instance of {@link CorrelatedRandomVariable }
     * 
     */
    public CorrelatedRandomVariable createCorrelatedRandomVarType() {
        return new CorrelatedRandomVariable();
    }

    /**
     * Create an instance of {@link CategoricalPMF }
     * 
     */
    public CategoricalPMF createCategoricalPMFType() {
        return new CategoricalPMF();
    }

    /**
     * Create an instance of {@link TTEFunction }
     * 
     */
    public TTEFunction createTTEFunctionType() {
        return new TTEFunction();
    }

    /**
     * Create an instance of {@link CategoricalRelation }
     * 
     */
    public CategoricalRelation createCategoricalRelationType() {
        return new CategoricalRelation();
    }

    /**
     * Create an instance of {@link ContinuousCovariate }
     * 
     */
    public ContinuousCovariate createContinuousCovariateType() {
        return new ContinuousCovariate();
    }

    /**
     * Create an instance of {@link Dependance }
     * 
     */
    public Dependance createDependanceType() {
        return new Dependance();
    }

    /**
     * Create an instance of {@link ParameterRandomEffect }
     * 
     */
    public ParameterRandomEffect createParameterRandomEffectType() {
        return new ParameterRandomEffect();
    }

    /**
     * Create an instance of {@link CovariateDefinition }
     * 
     */
    public CovariateDefinition createCovariateDefinitionType() {
        return new CovariateDefinition();
    }

    /**
     * Create an instance of {@link CategoricalCovariate }
     * 
     */
    public CategoricalCovariate createCategorialCovariateType() {
        return new CategoricalCovariate();
    }

    /**
     * Create an instance of {@link IndividualParameter.GaussianModel.GeneralCovariate }
     * 
     */
    @Deprecated
    public IndividualParameter.GaussianModel.GeneralCovariate createIndividualParameterTypeGaussianModelGeneralCovariate() {
        return new IndividualParameter.GaussianModel.GeneralCovariate();
    }

    /**
     * Create an instance of {@link IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter }
     * 
     */
    @Deprecated
    public IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter createIndividualParameterTypeGaussianModelLinearCovariatePopulationParameter() {
        return new IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter();
    }

    /**
     * Create an instance of {@link GaussianObsError.Output }
     * 
     */
    @Deprecated
    public GaussianObsError.Output createGaussianObsErrorOutput() {
        return new GaussianObsError.Output();
    }

    /**
     * Create an instance of {@link GaussianObsError.ErrorModel }
     * 
     */
    @Deprecated
    public GaussianObsError.ErrorModel createGaussianObsErrorErrorModel() {
        return new GaussianObsError.ErrorModel();
    }

    /**
     * Create an instance of {@link GaussianObsError.ResidualError }
     * 
     */
    @Deprecated
    public GaussianObsError.ResidualError createGaussianObsErrorResidualError() {
        return new GaussianObsError.ResidualError();
    }
    
    /**
     * Create an instance of {@link DesignParameter }
     * 
     * @since PharmML 0.7
     */
    public DesignParameter createDesignParameter() {
        return new DesignParameter();
    }

    /**
     * Create an instance of {@link PopulationParameter }
     * 
     * @since PharmML 0.7
     */
    public PopulationParameter createPopulationParameter() {
        return new PopulationParameter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuralModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "StructuralModel")
    public JAXBElement<StructuralModel> createStructuralModel(StructuralModel value) {
        return new JAXBElement<StructuralModel>(_StructuralModel_QNAME, StructuralModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModelDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "ModelDefinition")
    public JAXBElement<ModelDefinition> createModelDefinition(ModelDefinition value) {
        return new JAXBElement<ModelDefinition>(_ModelDefinition_QNAME, ModelDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralObsError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "General", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "ObservationError")
    public JAXBElement<GeneralObsError> createGeneral(GeneralObsError value) {
        return new JAXBElement<GeneralObsError>(_General_QNAME, GeneralObsError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Probability }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "Probability")
    public JAXBElement<Probability> createProbability(Probability value) {
        return new JAXBElement<Probability>(_Probability_QNAME, Probability.class, null, value);
    }

//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link GaussianObsError }{@code >}}
//     * 
//     */
//    @Deprecated
//    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "Standard", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "ObservationError")
//    public JAXBElement<GaussianObsError> createStandard(GaussianObsError value) {
//        return new JAXBElement<GaussianObsError>(_Standard_QNAME, GaussianObsError.class, null, value);
//    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleParameter }{@code >}}
     * 
     */
    @Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "SimpleParameter", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "CommonParameterElement")
    public JAXBElement<SimpleParameter> createSimpleParameter(SimpleParameter value) {
        return new JAXBElement<SimpleParameter>(_SimpleParameter_QNAME, SimpleParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "IndividualParameter", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "CommonParameterElement")
    public JAXBElement<IndividualParameter> createIndividualParameter(IndividualParameter value) {
        return new JAXBElement<IndividualParameter>(_IndividualParameter_QNAME, IndividualParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObservationError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "ObservationError")
    public JAXBElement<ObservationError> createObservationError(ObservationError value) {
        return new JAXBElement<ObservationError>(_ObservationError_QNAME, ObservationError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "CommonParameterElement")
    public JAXBElement<CommonParameter> createCommonParameterElement(CommonParameter value) {
        return new JAXBElement<CommonParameter>(_CommonParameterElement_QNAME, CommonParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterRandomVariable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "RandomVariable", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "CommonParameterElement")
    public JAXBElement<ParameterRandomVariable> createRandomVariable(ParameterRandomVariable value) {
        return new JAXBElement<ParameterRandomVariable>(_RandomVariable_QNAME, ParameterRandomVariable.class, null, value);
    }
    
    // PharmML 0.7
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesignParameter }{@code >}}
     * 
     * @since PharmML 0.7
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "DesignParameter", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "CommonParameterElement")
    public JAXBElement<DesignParameter> createDesignParameter(DesignParameter value) {
        return new JAXBElement<DesignParameter>(_DesignParameter_QNAME, DesignParameter.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PopulationParameter }{@code >}}
     * 
     * @since PharmML 0.7
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "PopulationParameter", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "CommonParameterElement")
    public JAXBElement<PopulationParameter> createPopulationParameter(PopulationParameter value) {
        return new JAXBElement<PopulationParameter>(_PopulationParameter_QNAME, PopulationParameter.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuredObsError }{@code >}}
     * 
     * @since PharmML 0.7
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MDEF, name = "Standard", substitutionHeadNamespace = NS_DEFAULT_MDEF, substitutionHeadName = "ObservationError")
    public JAXBElement<StructuredObsError> createStandard(StructuredObsError value) {
        return new JAXBElement<StructuredObsError>(_Standard_QNAME, StructuredObsError.class, null, value);
    }

}
