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
// Generated on: 2014.07.21 at 11:29:00 AM BST 
//


package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.IndependentVariable;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.dataset.CategoryMapping;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.dataset.ColumnsDefinitionType;
import eu.ddmore.libpharmml.dom.dataset.CommonColumnDefinition;
import eu.ddmore.libpharmml.dom.dataset.DataSetTableType;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.dom.dataset.DatasetRow;
import eu.ddmore.libpharmml.dom.dataset.ImportDataType;
import eu.ddmore.libpharmml.dom.dataset.ImportTargetDataType;
import eu.ddmore.libpharmml.dom.dataset.MapType;
import eu.ddmore.libpharmml.dom.dataset.TargetToolDataSet;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.EquationType;
import eu.ddmore.libpharmml.dom.maths.Expression;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicCondition;
import eu.ddmore.libpharmml.dom.maths.LogicExpression;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalRelation;
import eu.ddmore.libpharmml.dom.modeldefn.CensoringFeature;
import eu.ddmore.libpharmml.dom.modeldefn.Censoring;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteState;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteVariable;
import eu.ddmore.libpharmml.dom.modeldefn.CommonObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameterModel;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameter;
import eu.ddmore.libpharmml.dom.modeldefn.ContinuousCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.CorrelatedRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.Correlation;
import eu.ddmore.libpharmml.dom.modeldefn.CountPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateModel;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateRelationType;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateTransformationType;
import eu.ddmore.libpharmml.dom.modeldefn.Dependance;
import eu.ddmore.libpharmml.dom.modeldefn.DiscreteDataParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Discrete;
import eu.ddmore.libpharmml.dom.modeldefn.FixedEffectRelationType;
import eu.ddmore.libpharmml.dom.modeldefn.ListOfCategories;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinitionType;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationErrorType;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationModelType;
import eu.ddmore.libpharmml.dom.modeldefn.PairwiseType;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomEffectType;
import eu.ddmore.libpharmml.dom.modeldefn.ParentLevelType;
import eu.ddmore.libpharmml.dom.modeldefn.ProbabilityAssignment;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModelType;
import eu.ddmore.libpharmml.dom.modeldefn.TTEFunction;
import eu.ddmore.libpharmml.dom.modeldefn.TransitionRate;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityDefnBlock;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityLevelDefnType;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.AbsorptionOralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.OralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.dom.modellingsteps.AlgorithmType;
import eu.ddmore.libpharmml.dom.modellingsteps.CodeInjectionType;
import eu.ddmore.libpharmml.dom.modellingsteps.CommonModellingStepType;
import eu.ddmore.libpharmml.dom.modellingsteps.DatasetMappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.DependentsType;
import eu.ddmore.libpharmml.dom.modellingsteps.EstimationOperationType;
import eu.ddmore.libpharmml.dom.modellingsteps.GenericCodeType;
import eu.ddmore.libpharmml.dom.modellingsteps.MappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.ModellingStepsType;
import eu.ddmore.libpharmml.dom.modellingsteps.MultipleDVMappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSetReferenceType;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSetType;
import eu.ddmore.libpharmml.dom.modellingsteps.ObservationsType;
import eu.ddmore.libpharmml.dom.modellingsteps.OperationPropertyType;
import eu.ddmore.libpharmml.dom.modellingsteps.ParameterEstimateType;
import eu.ddmore.libpharmml.dom.modellingsteps.SimulationOperationType;
import eu.ddmore.libpharmml.dom.modellingsteps.StepDependencyType;
import eu.ddmore.libpharmml.dom.modellingsteps.StepType;
import eu.ddmore.libpharmml.dom.modellingsteps.SymbolMappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolReferenceType;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolSymbolType;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolType;
import eu.ddmore.libpharmml.dom.modellingsteps.TimepointsType;
import eu.ddmore.libpharmml.dom.modellingsteps.ToEstimateType;
import eu.ddmore.libpharmml.dom.trialdesign.ActivityType;
import eu.ddmore.libpharmml.dom.trialdesign.ArmDefnType;
import eu.ddmore.libpharmml.dom.trialdesign.CellDefnType;
import eu.ddmore.libpharmml.dom.trialdesign.DemographicType;
import eu.ddmore.libpharmml.dom.trialdesign.DosingRegimenType;
import eu.ddmore.libpharmml.dom.trialdesign.DosingTimesPointsType;
import eu.ddmore.libpharmml.dom.trialdesign.DosingVariableType;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualDosingType;
import eu.ddmore.libpharmml.dom.trialdesign.LookupTableType;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationsGroupType;
import eu.ddmore.libpharmml.dom.trialdesign.PopulationMappingType;
import eu.ddmore.libpharmml.dom.trialdesign.PopulationType;
import eu.ddmore.libpharmml.dom.trialdesign.SegmentDefnType;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyStateParameterType;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyStateType;
import eu.ddmore.libpharmml.dom.trialdesign.StudyEventType;
import eu.ddmore.libpharmml.dom.trialdesign.StudyPeriodType;
import eu.ddmore.libpharmml.dom.trialdesign.StudyTimePointType;
import eu.ddmore.libpharmml.dom.trialdesign.TargetType;
import eu.ddmore.libpharmml.dom.trialdesign.TrialDesignType;
import eu.ddmore.libpharmml.dom.trialdesign.TrialStructureType;
import eu.ddmore.libpharmml.dom.trialdesign.WashoutType;


/**
 * Root type of all elements and types defining elements in PharmML.
 * 
 * <p>Java class for PharmMLRootType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmMLRootType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://www.pharmml.org/2013/03/CommonTypes}RootElementGroup"/>
 *       &lt;attGroup ref="{http://www.pharmml.org/2013/03/CommonTypes}RootAttributesGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@SuppressWarnings("deprecation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmMLRootType", propOrder = {
    "description"
})
@XmlSeeAlso({
    IndependentVariable.class,
    ModelDefinitionType.class,
    TrialDesignType.class,
    ModellingStepsType.class,
    LogicBinOp.class,
    Binop.class,
    SymbolRef.class,
    FunctionCallType.class,
    Sum.class,
    Product.class,
    Delay.class,
    VectorSelector.class,
    MatrixSelector.class,
    Probability.class,
    LogicExpression.class,
    Expression.class,
    StructuralModelType.class,
    ObservationErrorType.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameterType.GaussianModel.LinearCovariate.PopulationParameter.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameterType.GaussianModel.LinearCovariate.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameterType.GaussianModel.GeneralCovariate.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameterType.GaussianModel.class,
    CommonParameter.class,
    ParentLevelType.class,
    TransitionRate.class,
    CovariateTransformationType.class,
    PairwiseType.class,
    VariabilityLevelDefnType.class,
    CountPMF.class,
    Discrete.class,
    VariabilityDefnBlock.class,
    CommonParameterModel.class,
    CategoricalCovariate.class,
    CovariateRelationType.class,
    CovariateModel.class,
    CommonObservationModel.class,
    Censoring.class,
    FixedEffectRelationType.class,
    CommonDiscreteState.class,
    ObservationModelType.class,
    CensoringFeature.class,
    DiscreteDataParameter.class,
    ProbabilityAssignment.class,
    ListOfCategories.class,
    Correlation.class,
    CommonDiscreteVariable.class,
    CorrelatedRandomVariable.class,
    CategoricalPMF.class,
    TTEFunction.class,
    CategoricalRelation.class,
    ContinuousCovariate.class,
    Dependance.class,
    ParameterRandomEffectType.class,
    CovariateDefinition.class,
    LevelReference.class,
    Matrix.class,
    VariableAssignment.class,
    OidRef.class,
    Sequence.class,
    Rhs.class,
    Interpolation.class,
    BooleanValue.class,
    Vector.class,
    History.class,
    SumIndexSet.class,
    VectorCell.class,
    SumProductIndex.class,
    VectorElements.class,
    MatrixRow.class,
    VectorSegmentSelector.class,
    InitialCondition.class,
    MatrixCellSelector.class,
    MatrixVectorIndex.class,
    CommonVariableDefinition.class,
    MatrixBlock.class,
    MatrixCell.class,
    InitialTime.class,
    IndependentVariableReference.class,
    DelayVariable.class,
    InterpolationIV.class,
    MatrixColumnRowNames.class,
    LowUpLimit.class,
    VectorSegment.class,
    InitialValue.class,
    MatrixBlockSelector.class,
    ImportTargetDataType.class,
    TargetToolDataSet.class,
    DataSet.class,
    DataSetTableType.class,
    ImportDataType.class,
    ColumnsDefinitionType.class,
    ColumnReference.class,
    DatasetRow.class,
    CategoryMapping.class,
    ColumnMapping.class,
    CommonColumnDefinition.class,
    MapType.class,
    LookupTableType.class,
    ActivityType.class,
    WashoutType.class,
    DosingRegimenType.class,
    StudyEventType.class,
    TrialStructureType.class,
    DosingVariableType.class,
    SteadyStateParameterType.class,
    ArmDefnType.class,
    PopulationType.class,
    SteadyStateType.class,
    StudyTimePointType.class,
    IndividualDosingType.class,
    CellDefnType.class,
    SegmentDefnType.class,
    ObservationsGroupType.class,
    PopulationMappingType.class,
    DemographicType.class,
    TargetType.class,
    StudyPeriodType.class,
    DosingTimesPointsType.class,
    TimepointsType.class,
    MappingType.class,
    CommonModellingStepType.class,
    OperationPropertyType.class,
    NONMEMdataSetReferenceType.class,
    SimulationOperationType.class,
    AlgorithmType.class,
    TargetToolReferenceType.class,
    CodeInjectionType.class,
    TargetToolType.class,
    ParameterEstimateType.class,
    ObservationsType.class,
    StepDependencyType.class,
    DependentsType.class,
    NONMEMdataSetType.class,
    ScalarRhs.class,
    TargetToolSymbolType.class,
    MultipleDVMappingType.class,
    DatasetMappingType.class,
    StepType.class,
    GenericCodeType.class,
    SymbolMappingType.class,
    ToEstimateType.class,
    EstimationOperationType.class,
    EquationType.class,
    LogicCondition.class,
    AbsorptionOralMacro.class,
    OralMacro.class,
    PKMacroList.class
})
public abstract class PharmMLRootType extends PharmMLElement {

    @XmlElement(name = "Description")
    protected AnnotationType description;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationType }
     *     
     */
    public AnnotationType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationType }
     *     
     */
    public void setDescription(AnnotationType value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}