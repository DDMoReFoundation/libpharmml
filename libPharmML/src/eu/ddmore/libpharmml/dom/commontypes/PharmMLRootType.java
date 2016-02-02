/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.IndependentVariable;
import eu.ddmore.libpharmml.dom.dataset.CategoryMapping;
import eu.ddmore.libpharmml.dom.dataset.ColumnDefinition;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.dataset.ColumnTransformation;
import eu.ddmore.libpharmml.dom.dataset.ColumnsDefinitionType;
import eu.ddmore.libpharmml.dom.dataset.CommonColumnDefinition;
import eu.ddmore.libpharmml.dom.dataset.DataSet;
import eu.ddmore.libpharmml.dom.dataset.DataSetTable;
import eu.ddmore.libpharmml.dom.dataset.DatasetRow;
import eu.ddmore.libpharmml.dom.dataset.ExternalFile;
import eu.ddmore.libpharmml.dom.dataset.HeaderColumnsDefinition;
import eu.ddmore.libpharmml.dom.dataset.HeaderDefinition;
import eu.ddmore.libpharmml.dom.dataset.HeaderRow;
import eu.ddmore.libpharmml.dom.dataset.ImportTargetData;
import eu.ddmore.libpharmml.dom.dataset.MapType;
import eu.ddmore.libpharmml.dom.dataset.MissingDataMap;
import eu.ddmore.libpharmml.dom.dataset.TargetMapping;
import eu.ddmore.libpharmml.dom.dataset.TargetToolDataSet;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.maths.EquationType;
import eu.ddmore.libpharmml.dom.maths.Expression;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicCondition;
import eu.ddmore.libpharmml.dom.maths.LogicExpression;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalRelation;
import eu.ddmore.libpharmml.dom.modeldefn.Censoring;
import eu.ddmore.libpharmml.dom.modeldefn.CensoringFeature;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteState;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteVariable;
import eu.ddmore.libpharmml.dom.modeldefn.CommonObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameter;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameterModel;
import eu.ddmore.libpharmml.dom.modeldefn.ContinuousCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.CorrelatedRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.Correlation;
import eu.ddmore.libpharmml.dom.modeldefn.CountPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateModel;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateRelation;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateTransformation;
import eu.ddmore.libpharmml.dom.modeldefn.DSCategoricalCovariateType;
import eu.ddmore.libpharmml.dom.modeldefn.DSCategoryType;
import eu.ddmore.libpharmml.dom.modeldefn.DSCovariateDefinitionType;
import eu.ddmore.libpharmml.dom.modeldefn.Dependance;
import eu.ddmore.libpharmml.dom.modeldefn.Discrete;
import eu.ddmore.libpharmml.dom.modeldefn.DiscreteDataParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Distribution;
import eu.ddmore.libpharmml.dom.modeldefn.FixedEffectRelation;
import eu.ddmore.libpharmml.dom.modeldefn.LHSTransformationType;
import eu.ddmore.libpharmml.dom.modeldefn.LRHSTransformation;
import eu.ddmore.libpharmml.dom.modeldefn.ListOfCategories;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationError;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.Pairwise;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomEffect;
import eu.ddmore.libpharmml.dom.modeldefn.ParentLevel;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.ProbabilityAssignment;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredModel;
import eu.ddmore.libpharmml.dom.modeldefn.TTEFunction;
import eu.ddmore.libpharmml.dom.modeldefn.TransformedCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.TransitionRate;
import eu.ddmore.libpharmml.dom.modeldefn.UncertML;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityDefnBlock;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityLevelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.AbsorptionOralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.CompartmentMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.DepotMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.EffectMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.EliminationMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.IVMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.MacroValue;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.OralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PeripheralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.TransferMacro;
import eu.ddmore.libpharmml.dom.modellingsteps.Algorithm;
import eu.ddmore.libpharmml.dom.modellingsteps.CommonModellingStep;
import eu.ddmore.libpharmml.dom.modellingsteps.DependentsType;
import eu.ddmore.libpharmml.dom.modellingsteps.EstimationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.ExternalDataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.InterventionsReference;
import eu.ddmore.libpharmml.dom.modellingsteps.MappingType;
import eu.ddmore.libpharmml.dom.modellingsteps.ModellingSteps;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSet;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.ObservationsReference;
import eu.ddmore.libpharmml.dom.modellingsteps.OperationProperty;
import eu.ddmore.libpharmml.dom.modellingsteps.ParameterEstimate;
import eu.ddmore.libpharmml.dom.modellingsteps.SimulationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.StepDependency;
import eu.ddmore.libpharmml.dom.modellingsteps.StepType;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetTool;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolReference;
import eu.ddmore.libpharmml.dom.modellingsteps.ToEstimate;
import eu.ddmore.libpharmml.dom.probonto.DistributionBound;
import eu.ddmore.libpharmml.dom.probonto.DistributionParameter;
import eu.ddmore.libpharmml.dom.probonto.MixtureComponent;
import eu.ddmore.libpharmml.dom.probonto.ProbOnto;
import eu.ddmore.libpharmml.dom.trialdesign.Action;
import eu.ddmore.libpharmml.dom.trialdesign.Activity;
import eu.ddmore.libpharmml.dom.trialdesign.Administration;
import eu.ddmore.libpharmml.dom.trialdesign.ArmDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.Arms;
import eu.ddmore.libpharmml.dom.trialdesign.CellDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.Covariates;
import eu.ddmore.libpharmml.dom.trialdesign.Demographic;
import eu.ddmore.libpharmml.dom.trialdesign.DesignSpaces;
import eu.ddmore.libpharmml.dom.trialdesign.DosingRegimen;
import eu.ddmore.libpharmml.dom.trialdesign.DosingTimesPoints;
import eu.ddmore.libpharmml.dom.trialdesign.DosingVariable;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualAdministration;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualCovariates;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualDosing;
import eu.ddmore.libpharmml.dom.trialdesign.InterventionList;
import eu.ddmore.libpharmml.dom.trialdesign.Interventions;
import eu.ddmore.libpharmml.dom.trialdesign.InterventionsCombination;
import eu.ddmore.libpharmml.dom.trialdesign.LookupTable;
import eu.ddmore.libpharmml.dom.trialdesign.MultipleDVMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Observation;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationList;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationSequence;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationsCombination;
import eu.ddmore.libpharmml.dom.trialdesign.ObservationsGroup;
import eu.ddmore.libpharmml.dom.trialdesign.Occasion;
import eu.ddmore.libpharmml.dom.trialdesign.OccasionList;
import eu.ddmore.libpharmml.dom.trialdesign.OccasionSequence;
import eu.ddmore.libpharmml.dom.trialdesign.Population;
import eu.ddmore.libpharmml.dom.trialdesign.PopulationMapping;
import eu.ddmore.libpharmml.dom.trialdesign.SegmentDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.SingleDesignSpace;
import eu.ddmore.libpharmml.dom.trialdesign.SingleIntervention;
import eu.ddmore.libpharmml.dom.trialdesign.SingleObservation;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyState;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyStateParameter;
import eu.ddmore.libpharmml.dom.trialdesign.StudyEvent;
import eu.ddmore.libpharmml.dom.trialdesign.StudyPeriod;
import eu.ddmore.libpharmml.dom.trialdesign.StudyTimePoint;
import eu.ddmore.libpharmml.dom.trialdesign.TDCovariateModel;
import eu.ddmore.libpharmml.dom.trialdesign.Target;
import eu.ddmore.libpharmml.dom.trialdesign.TrialDesign;
import eu.ddmore.libpharmml.dom.trialdesign.TrialStructure;
import eu.ddmore.libpharmml.dom.trialdesign.VariableToReset;
import eu.ddmore.libpharmml.dom.trialdesign.Washout;


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
	MacroValue.class,
	AbsorptionOralMacro.class,
	Action.class,
	Activity.class,
	Administration.class,
	Algorithm.class,
	ArmDefinition.class,
	Arms.class,
	Binop.class,
	Boolean.class,
	BooleanValue.class,
	CategoricalCovariate.class,
	CategoricalPMF.class,
	CategoricalRelation.class,
	CategoryMapping.class,
	CategoryRef.class,
	CellDefinition.class,
	Censoring.class,
	CensoringFeature.class,
	eu.ddmore.libpharmml.dom.trialdesign.CodeInjection.class,
	ColumnDefinition.class,
	ColumnMapping.class,
	ColumnReference.class,
	ColumnsDefinitionType.class,
	ColumnTransformation.class,
	CommonColumnDefinition.class,
	CommonDiscreteState.class,
	CommonDiscreteVariable.class,
	CommonModellingStep.class,
	CommonObservationModel.class,
	CommonParameter.class,
	CommonParameterModel.class,
	CommonVariableDefinition.class,
	CompartmentMacro.class,
	ContinuousCovariate.class,
	eu.ddmore.libpharmml.dom.trialdesign.ContinuousObservation.class,
	CorrelatedRandomVariable.class,
	Correlation.class,
	CountPMF.class,
	CovariateDefinition.class,
	CovariateModel.class,
	CovariateModelRef.class,
	CovariateRelation.class,
	Covariates.class,
	CovariateTransformation.class,
	DataSet.class,
	eu.ddmore.libpharmml.dom.trialdesign.DatasetMapping.class,
	DatasetRow.class,
	DataSetTable.class,
	Delay.class,
	DelayVariable.class,
	Demographic.class,
	Dependance.class,
	DependentsType.class,
	DepotMacro.class,
	DesignSpaces.class,
	Discrete.class,
	DiscreteDataParameter.class,
	eu.ddmore.libpharmml.dom.trialdesign.DiscreteObservation.class,
	DistributionBound.class,
	Distribution.class,
	DistributionParameter.class,
	DosingRegimen.class,
	DosingTimesPoints.class,
	DosingVariable.class,
	DSCategoricalCovariateType.class,
	DSCategoryType.class,
	DSCovariateDefinitionType.class,
	EffectMacro.class,
	EliminationMacro.class,
	Equation.class,
	EquationType.class,
	EstimationOperation.class,
	eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.class,
	eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.GeneralCovariate.class,
	eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate.class,
	eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter.class,
	eu.ddmore.libpharmml.dom.modeldefn.InterventionSequence.class,
	eu.ddmore.libpharmml.dom.trialdesign.InterventionSequence.class,
	Expression.class,
	eu.ddmore.libpharmml.dom.trialdesign.ExternalDataSet.class,
	ExternalDataSetReference.class,
	ExternalFile.class,
	FixedEffectRelation.class,
	FunctionCallType.class,
	eu.ddmore.libpharmml.dom.trialdesign.GenericCode.class,
	HeaderColumnsDefinition.class,
	HeaderDefinition.class,
	HeaderRow.class,
	History.class,
	ImportTargetData.class,
	IndependentVariable.class,
	IndependentVariableReference.class,
	IndividualAdministration.class,
	IndividualCovariates.class,
	IndividualDosing.class,
	InitialCondition.class,
	InitialTime.class,
	InitialValue.class,
	Interpolation.class,
	InterpolationIV.class,
	Interval.class,
	InterventionList.class,
	Interventions.class,
	InterventionsCombination.class,
	InterventionsReference.class,
	IVMacro.class,
	LevelReference.class,
	LHSTransformationType.class,
	ListOfCategories.class,
	LogicBinOp.class,
	LogicCondition.class,
	LogicExpression.class,
	LookupTable.class,
	LowUpLimit.class,
	LRHSTransformation.class,
	MapType.class,
	MappingType.class,
	MapType.class,
	MatrixBlock.class,
	MatrixBlockSelector.class,
	MatrixCell.class,
	MatrixCellSelector.class,
	Matrix.class,
	MatrixColumn.class,
	MatrixColumnRowNames.class,
	MatrixRow.class,
	MatrixSelector.class,
	MatrixVectorIndex.class,
	MissingDataMap.class,
	MissingValue.class,
	MixtureComponent.class,
	ModelDefinition.class,
	ModellingSteps.class,
	MultipleDVMapping.class,
	NONMEMdataSet.class,
	NONMEMdataSetReference.class,
	Observation.class,
	ObservationError.class,
	ObservationList.class,
	ObservationModel.class,
	eu.ddmore.libpharmml.dom.modellingsteps.Observations.class,
	eu.ddmore.libpharmml.dom.trialdesign.Observations.class,
	ObservationsCombination.class,
	ObservationSequence.class,
	ObservationsGroup.class,
	ObservationsReference.class,
	Occasion.class,
	OccasionList.class,
	OccasionSequence.class,
	OidRef.class,
	OperationProperty.class,
	OralMacro.class,
	Pairwise.class,
	ParameterEstimate.class,
	ParameterRandomEffect.class,
	ParentLevel.class,
	PeripheralMacro.class,
	PKMacro.class,
	PKMacroList.class,
	Population.class,
	PopulationMapping.class,
	ProbabilityAssignment.class,
	Probability.class,
	ProbOnto.class,
	Product.class,
	RandomEffectMapping.class,
	Rhs.class,
	ScalarRhs.class,
	SegmentDefinition.class,
	Sequence.class,
	SimulationOperation.class,
	SingleDesignSpace.class,
	SingleIntervention.class,
	SingleObservation.class,
	StandardAssignable.class,
	SteadyState.class,
	SteadyStateParameter.class,
	StepDependency.class,
	StepType.class,
	StructuralModel.class,
	StructuredModel.class,
	StructuredModel.GeneralCovariate.class,
	StructuredModel.LinearCovariate.class,
	StructuredModel.LinearCovariate.PopulationValue.class,
	StructuredModel.PopulationValue.class,
	StudyEvent.class,
	StudyPeriod.class,
	StudyTimePoint.class,
	Sum.class,
	SumIndexSet.class,
	SumProductIndex.class,
	eu.ddmore.libpharmml.dom.trialdesign.SymbolMapping.class,
	SymbolRef.class,
	Target.class,
	TargetMapping.class,
	TargetTool.class,
	TargetToolDataSet.class,
	TargetToolReference.class,
	eu.ddmore.libpharmml.dom.trialdesign.TargetToolSymbol.class,
	TDCovariateModel.class,
	eu.ddmore.libpharmml.dom.trialdesign.Timepoints.class,
	ToEstimate.class,
	TransferMacro.class,
	TransformedCovariate.class,
	TransitionRate.class,
	TrialDesign.class,
	TrialStructure.class,
	TTEFunction.class,
	UncertML.class,
	VariabilityDefnBlock.class,
	VariabilityLevelDefinition.class,
	VariableAssignment.class,
	VariableToReset.class,
	VectorCell.class,
	Vector.class,
	VectorElements.class,
	VectorSegment.class,
	VectorSegmentSelector.class,
	VectorSelector.class,
	Washout.class
})
public abstract class PharmMLRootType extends PharmMLElement implements Identifiable {

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
    @Override
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
    @Override
    public void setId(String value) {
        this.id = value;
    }
    
    /**
     * Creates a new description for this element and returns it.
     * @param description The text value of the description.
     * @return The created description element as {@link AnnotationType}.
     */
    public AnnotationType createDescription(String description){
    	AnnotationType desc = ObjectFactory.getInstance().createAnnotationType();
    	desc.setValue(description);
    	this.description = desc;
    	return desc;
    }
    
    @Override
    public String toString() {
    	if(id != null){
    		return super.toString()+"#"+id;
    	} else {
    		return super.toString();
    	}
    }
    
    @Override
    public PharmMLElement clone(){
    	return clone(PharmMLRootType.class, this);
    }

}
