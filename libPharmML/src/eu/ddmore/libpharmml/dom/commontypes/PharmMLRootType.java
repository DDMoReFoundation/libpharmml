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
import eu.ddmore.libpharmml.dom.modeldefn.CovariateRelation;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateTransformation;
import eu.ddmore.libpharmml.dom.modeldefn.Dependance;
import eu.ddmore.libpharmml.dom.modeldefn.DiscreteDataParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Discrete;
import eu.ddmore.libpharmml.dom.modeldefn.FixedEffectRelation;
import eu.ddmore.libpharmml.dom.modeldefn.ListOfCategories;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationError;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.Pairwise;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomEffect;
import eu.ddmore.libpharmml.dom.modeldefn.ParentLevel;
import eu.ddmore.libpharmml.dom.modeldefn.ProbabilityAssignment;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.modeldefn.TTEFunction;
import eu.ddmore.libpharmml.dom.modeldefn.TransitionRate;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityDefnBlock;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityLevelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.AbsorptionOralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.OralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.dom.modellingsteps.Algorithm;
import eu.ddmore.libpharmml.dom.modellingsteps.CodeInjection;
import eu.ddmore.libpharmml.dom.modellingsteps.CommonModellingStep;
import eu.ddmore.libpharmml.dom.modellingsteps.DatasetMapping;
import eu.ddmore.libpharmml.dom.modellingsteps.DependentsType;
import eu.ddmore.libpharmml.dom.modellingsteps.EstimationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.GenericCode;
import eu.ddmore.libpharmml.dom.modellingsteps.MappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.ModellingSteps;
import eu.ddmore.libpharmml.dom.modellingsteps.MultipleDVMapping;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSet;
import eu.ddmore.libpharmml.dom.modellingsteps.Observations;
import eu.ddmore.libpharmml.dom.modellingsteps.OperationProperty;
import eu.ddmore.libpharmml.dom.modellingsteps.ParameterEstimate;
import eu.ddmore.libpharmml.dom.modellingsteps.SimulationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.StepDependency;
import eu.ddmore.libpharmml.dom.modellingsteps.StepType;
import eu.ddmore.libpharmml.dom.modellingsteps.SymbolMapping;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolReference;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolSymbol;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetTool;
import eu.ddmore.libpharmml.dom.modellingsteps.Timepoints;
import eu.ddmore.libpharmml.dom.modellingsteps.ToEstimate;
import eu.ddmore.libpharmml.dom.trialdesign.Activity;
import eu.ddmore.libpharmml.dom.trialdesign.ArmDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.CellDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.DemographicType;
import eu.ddmore.libpharmml.dom.trialdesign.DosingRegimen;
import eu.ddmore.libpharmml.dom.trialdesign.DosingTimesPoints;
import eu.ddmore.libpharmml.dom.trialdesign.DosingVariable;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualDosing;
import eu.ddmore.libpharmml.dom.trialdesign.LookupTable;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationsGroup;
import eu.ddmore.libpharmml.dom.trialdesign.PopulationMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Population;
import eu.ddmore.libpharmml.dom.trialdesign.SegmentDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyStateParameter;
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
    ModelDefinition.class,
    TrialDesignType.class,
    ModellingSteps.class,
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
    StructuralModel.class,
    ObservationError.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.GeneralCovariate.class,
    eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.class,
    CommonParameter.class,
    ParentLevel.class,
    TransitionRate.class,
    CovariateTransformation.class,
    Pairwise.class,
    VariabilityLevelDefinition.class,
    CountPMF.class,
    Discrete.class,
    VariabilityDefnBlock.class,
    CommonParameterModel.class,
    CategoricalCovariate.class,
    CovariateRelation.class,
    CovariateModel.class,
    CommonObservationModel.class,
    Censoring.class,
    FixedEffectRelation.class,
    CommonDiscreteState.class,
    ObservationModel.class,
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
    ParameterRandomEffect.class,
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
    LookupTable.class,
    Activity.class,
    WashoutType.class,
    DosingRegimen.class,
    StudyEventType.class,
    TrialStructureType.class,
    DosingVariable.class,
    SteadyStateParameter.class,
    ArmDefinition.class,
    Population.class,
    SteadyStateType.class,
    StudyTimePointType.class,
    IndividualDosing.class,
    CellDefinition.class,
    SegmentDefinition.class,
    ObservationsGroup.class,
    PopulationMapping.class,
    DemographicType.class,
    TargetType.class,
    StudyPeriodType.class,
    DosingTimesPoints.class,
    Timepoints.class,
    MappingType.class,
    CommonModellingStep.class,
    OperationProperty.class,
    NONMEMdataSetReference.class,
    SimulationOperation.class,
    Algorithm.class,
    TargetToolReference.class,
    CodeInjection.class,
    TargetTool.class,
    ParameterEstimate.class,
    Observations.class,
    StepDependency.class,
    DependentsType.class,
    NONMEMdataSet.class,
    ScalarRhs.class,
    TargetToolSymbol.class,
    MultipleDVMapping.class,
    DatasetMapping.class,
    StepType.class,
    GenericCode.class,
    SymbolMapping.class,
    ToEstimate.class,
    EstimationOperation.class,
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