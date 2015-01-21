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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.ddmore.libpharmml.dom.modellingsteps package. 
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

    private final static QName _SimulationStep_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "SimulationStep");
    private final static QName _Property_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "Property");
    private final static QName _CommonModellingStep_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "CommonModellingStep");
    private final static QName _ModellingSteps_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "ModellingSteps");
    private final static QName _VariableMapping_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "VariableMapping");
    private final static QName _IndividualMapping_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "IndividualMapping");
	@Deprecated
    private final static QName _Operation_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "Operation");
    private final static QName _EstimationStep_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "EstimationStep");
    private final static QName _Timepoints_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "Timepoints");
    private final static QName _Mapping_QNAME = new QName("http://www.pharmml.org/2013/03/ModellingSteps", "Mapping");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.modellingsteps
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModellingStepsType }
     * 
     */
    public ModellingStepsType createModellingStepsType() {
        return new ModellingStepsType();
    }

    /**
     * Create an instance of {@link SimulationStepType }
     * 
     */
    public SimulationStepType createSimulationStepType() {
        return new SimulationStepType();
    }

    /**
     * Create an instance of {@link IndividualMappingType }
     * 
     */
    @Deprecated
    public IndividualMappingType createIndividualMappingType() {
        return new IndividualMappingType();
    }

    /**
     * Create an instance of {@link TimepointsType }
     * 
     */
    public TimepointsType createTimepointsType() {
        return new TimepointsType();
    }

    /**
     * Create an instance of {@link VariableMappingType }
     * 
     */
    @Deprecated
    public VariableMappingType createVariableMappingType() {
        return new VariableMappingType();
    }

    /**
     * Create an instance of {@link EstimationStepType }
     * 
     */
    public EstimationStepType createEstimationStepType() {
        return new EstimationStepType();
    }

    /**
     * Create an instance of {@link OperationPropertyType }
     * 
     */
    public OperationPropertyType createOperationPropertyType() {
        return new OperationPropertyType();
    }

    /**
     * Create an instance of {@link ContinuousObservationType }
     * 
     */
    public ContinuousObservationType createContinuousObservationType() {
        return new ContinuousObservationType();
    }

    /**
     * Create an instance of {@link SimulationOperationType }
     * 
	 * @since PharmML 0.3
     */
    public SimulationOperationType createSimulationOperationType() {
        return new SimulationOperationType();
    }

    /**
     * Create an instance of {@link Algorithm }
     * 
     */
    public Algorithm createAlgorithmType() {
        return new Algorithm();
    }

    /**
     * Create an instance of {@link TargetToolReferenceType }
     * 
     */
    public TargetToolReferenceType createTargetToolReferenceType() {
        return new TargetToolReferenceType();
    }

    /**
     * Create an instance of {@link CodeInjection }
     * 
     */
    public CodeInjection createCodeInjectionType() {
        return new CodeInjection();
    }

    /**
     * Create an instance of {@link TargetToolType }
     * 
     */
    public TargetToolType createTargetToolType() {
        return new TargetToolType();
    }

    /**
     * Create an instance of {@link ParameterEstimateType }
     * 
     */
    public ParameterEstimateType createParameterEstimateType() {
        return new ParameterEstimateType();
    }

    /**
     * Create an instance of {@link ObservationsType }
     * 
     */
    public ObservationsType createObservationsType() {
        return new ObservationsType();
    }

    /**
     * Create an instance of {@link StepDependencyType }
     * 
     */
    public StepDependencyType createStepDependencyType() {
        return new StepDependencyType();
    }

    /**
     * Create an instance of {@link DependentsType }
     * 
     */
    public DependentsType createDependentsType() {
        return new DependentsType();
    }

    /**
     * Create an instance of {@link NONMEMdataSetType }
     * 
	 * @since PharmML0.3
     */
    public NONMEMdataSetType createNONMEMdataSetType() {
        return new NONMEMdataSetType();
    }

    /**
     * Create an instance of {@link InitialEstimateType }
     * 
     */
    public InitialEstimateType createInitialEstimateType() {
        return new InitialEstimateType();
    }

    /**
     * Create an instance of {@link TargetToolSymbolType }
     * 
	 * @since PharmML0.3
     */
    public TargetToolSymbolType createTargetToolSymbolType() {
        return new TargetToolSymbolType();
    }
    
    /**
     * Create an instance of {@link MultipleDVMappingType }
     * 
     */
    public MultipleDVMappingType createMultipleDVMappingType() {
        return new MultipleDVMappingType();
    }
    
    /**
     * Create an instance of {@link NONMEMdataSetReferenceType }
     * 
     */
    public NONMEMdataSetReferenceType createNONMEMdataSetReferenceType() {
        return new NONMEMdataSetReferenceType();
    }



    /**
     * Create an instance of {@link DatasetMappingType }
     * 
	 * @since PharmML0.3
     */
    public DatasetMappingType createDatasetMappingType() {
        return new DatasetMappingType();
    }

    /**
     * Create an instance of {@link StepType }
     * 
	 * @since PharmML0.3
     */
    public StepType createStepType() {
        return new StepType();
    }

    /**
     * Create an instance of {@link GenericCodeType }
     * 
	 * @since PharmML0.3
     */
    public GenericCodeType createGenericCodeType() {
        return new GenericCodeType();
    }

    /**
     * Create an instance of {@link SymbolMappingType }
     * 
	 * @since PharmML0.3
     */
    public SymbolMappingType createSymbolMappingType() {
        return new SymbolMappingType();
    }

    /**
     * Create an instance of {@link ToEstimateType }
     * 
	 * @since PharmML0.3
     */
    public ToEstimateType createToEstimateType() {
        return new ToEstimateType();
    }

    /**
     * Create an instance of {@link EstimationOperationType }
     * 
     */
    public EstimationOperationType createEstimationOperationType() {
        return new EstimationOperationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulationStepType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "SimulationStep", substitutionHeadNamespace = "http://www.pharmml.org/2013/03/ModellingSteps", substitutionHeadName = "CommonModellingStep")
    public JAXBElement<SimulationStepType> createSimulationStep(SimulationStepType value) {
        return new JAXBElement<SimulationStepType>(_SimulationStep_QNAME, SimulationStepType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "Property")
    public JAXBElement<OperationPropertyType> createProperty(OperationPropertyType value) {
        return new JAXBElement<OperationPropertyType>(_Property_QNAME, OperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModellingStepType }{@code >}}
     * 
     */
	@XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "CommonModellingStep")
    public JAXBElement<CommonModellingStepType> createCommonModellingStep(CommonModellingStepType value) {
        return new JAXBElement<CommonModellingStepType>(_CommonModellingStep_QNAME, CommonModellingStepType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModellingStepsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "ModellingSteps")
    public JAXBElement<ModellingStepsType> createModellingSteps(ModellingStepsType value) {
        return new JAXBElement<ModellingStepsType>(_ModellingSteps_QNAME, ModellingStepsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VariableMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "VariableMapping", substitutionHeadNamespace = "http://www.pharmml.org/2013/03/ModellingSteps", substitutionHeadName = "Mapping")
    @Deprecated
    public JAXBElement<VariableMappingType> createVariableMapping(VariableMappingType value) {
        return new JAXBElement<VariableMappingType>(_VariableMapping_QNAME, VariableMappingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "IndividualMapping", substitutionHeadNamespace = "http://www.pharmml.org/2013/03/ModellingSteps", substitutionHeadName = "Mapping")
    @Deprecated
    public JAXBElement<IndividualMappingType> createIndividualMapping(IndividualMappingType value) {
        return new JAXBElement<IndividualMappingType>(_IndividualMapping_QNAME, IndividualMappingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstimationOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "Operation")
	@Deprecated
    public JAXBElement<EstimationOperationType> createOperation(EstimationOperationType value) {
        return new JAXBElement<EstimationOperationType>(_Operation_QNAME, EstimationOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstimationStepType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "EstimationStep", substitutionHeadNamespace = "http://www.pharmml.org/2013/03/ModellingSteps", substitutionHeadName = "CommonModellingStep")
    public JAXBElement<EstimationStepType> createEstimationStep(EstimationStepType value) {
        return new JAXBElement<EstimationStepType>(_EstimationStep_QNAME, EstimationStepType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimepointsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "Timepoints")
    public JAXBElement<TimepointsType> createTimepoints(TimepointsType value) {
        return new JAXBElement<TimepointsType>(_Timepoints_QNAME, TimepointsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/03/ModellingSteps", name = "Mapping")
    @Deprecated
    public JAXBElement<MappingType> createMapping(MappingType value) {
        return new JAXBElement<MappingType>(_Mapping_QNAME, MappingType.class, null, value);
    }

}
