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
import eu.ddmore.libpharmml.dom.dataset.*;
import eu.ddmore.libpharmml.dom.maths.*;
import eu.ddmore.libpharmml.dom.modeldefn.*;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.*;
import eu.ddmore.libpharmml.dom.modellingsteps.*;
import eu.ddmore.libpharmml.dom.trialdesign.*;
import eu.ddmore.libpharmml.dom.probonto.*;


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

}
