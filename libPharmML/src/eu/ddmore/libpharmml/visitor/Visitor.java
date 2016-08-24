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
package eu.ddmore.libpharmml.visitor;

import eu.ddmore.libpharmml.dom.IndependentVariable;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.PharmMLNode;
import eu.ddmore.libpharmml.dom.commontypes.AnnotationType;
import eu.ddmore.libpharmml.dom.commontypes.CategoryRef;
import eu.ddmore.libpharmml.dom.commontypes.CovariateModelRef;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.DelayVariable;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.FunctionDefinition;
import eu.ddmore.libpharmml.dom.commontypes.FunctionParameter;
import eu.ddmore.libpharmml.dom.commontypes.History;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IndependentVariableReference;
import eu.ddmore.libpharmml.dom.commontypes.InitialCondition;
import eu.ddmore.libpharmml.dom.commontypes.InitialTime;
import eu.ddmore.libpharmml.dom.commontypes.InitialValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.InterpolationIV;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.LowUpLimit;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixBlock;
import eu.ddmore.libpharmml.dom.commontypes.MatrixBlockSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixCell;
import eu.ddmore.libpharmml.dom.commontypes.MatrixCellSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixColumn;
import eu.ddmore.libpharmml.dom.commontypes.MatrixColumnRowNames;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRow;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixVectorIndex;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RandomEffectMapping;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.ScalarRhs;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.commontypes.StandardOptionalAssignable;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SumIndexSet;
import eu.ddmore.libpharmml.dom.commontypes.SumProductIndex;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.VariableAssignment;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorCell;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.commontypes.VectorSegment;
import eu.ddmore.libpharmml.dom.commontypes.VectorSegmentSelector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.dataset.CategoryMapping;
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
import eu.ddmore.libpharmml.dom.dataset.IgnoreLine;
import eu.ddmore.libpharmml.dom.dataset.ImportTargetData;
import eu.ddmore.libpharmml.dom.dataset.MapType;
import eu.ddmore.libpharmml.dom.dataset.MissingDataMap;
import eu.ddmore.libpharmml.dom.dataset.TargetMapping;
import eu.ddmore.libpharmml.dom.dataset.TargetToolDataSet;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.ConditionalStatement;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.ElseCondition;
import eu.ddmore.libpharmml.dom.maths.EquationType;
import eu.ddmore.libpharmml.dom.maths.Expression;
import eu.ddmore.libpharmml.dom.maths.FunctionArgumentType;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.IfElseIfCondition;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicCondition;
import eu.ddmore.libpharmml.dom.maths.LogicExpression;
import eu.ddmore.libpharmml.dom.maths.Naryop;
import eu.ddmore.libpharmml.dom.maths.Otherwise;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.ProbabilityFunction;
import eu.ddmore.libpharmml.dom.maths.Statsop;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalData;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CategoricalRelation;
import eu.ddmore.libpharmml.dom.modeldefn.Category;
import eu.ddmore.libpharmml.dom.modeldefn.Censoring;
import eu.ddmore.libpharmml.dom.modeldefn.CensoringFeature;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteState;
import eu.ddmore.libpharmml.dom.modeldefn.CommonDiscreteVariable;
import eu.ddmore.libpharmml.dom.modeldefn.ContinuousCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.ContinuousObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.CorrelatedRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.Correlation;
import eu.ddmore.libpharmml.dom.modeldefn.CountData;
import eu.ddmore.libpharmml.dom.modeldefn.CountPMF;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateModel;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateRelation;
import eu.ddmore.libpharmml.dom.modeldefn.CovariateTransformation;
import eu.ddmore.libpharmml.dom.modeldefn.DSCategoricalCovariateType;
import eu.ddmore.libpharmml.dom.modeldefn.DSCategoryType;
import eu.ddmore.libpharmml.dom.modeldefn.DSCovariateDefinitionType;
import eu.ddmore.libpharmml.dom.modeldefn.Dependance;
import eu.ddmore.libpharmml.dom.modeldefn.DesignParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Discrete;
import eu.ddmore.libpharmml.dom.modeldefn.DiscreteDataParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Distribution;
import eu.ddmore.libpharmml.dom.modeldefn.FixedEffectRelation;
import eu.ddmore.libpharmml.dom.modeldefn.GaussianObsError;
import eu.ddmore.libpharmml.dom.modeldefn.GeneralObsError;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.InterventionSequence;
import eu.ddmore.libpharmml.dom.modeldefn.LHSTransformationType;
import eu.ddmore.libpharmml.dom.modeldefn.LRHSTransformationType;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ObservationModel;
import eu.ddmore.libpharmml.dom.modeldefn.Pairwise;
import eu.ddmore.libpharmml.dom.modeldefn.Parameter;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModel;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomEffect;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterRandomVariable;
import eu.ddmore.libpharmml.dom.modeldefn.ParentLevel;
import eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.ProbabilityAssignment;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.modeldefn.SimpleParameter;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredModel;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredModel.GeneralCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredModel.LinearCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredModel.PopulationValue;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredObsError;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredObsError.ErrorModel;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredObsError.Output;
import eu.ddmore.libpharmml.dom.modeldefn.StructuredObsError.ResidualError;
import eu.ddmore.libpharmml.dom.modeldefn.TTEFunction;
import eu.ddmore.libpharmml.dom.modeldefn.TimeToEventData;
import eu.ddmore.libpharmml.dom.modeldefn.TransformedCovariate;
import eu.ddmore.libpharmml.dom.modeldefn.TransitionMatrix;
import eu.ddmore.libpharmml.dom.modeldefn.TransitionRate;
import eu.ddmore.libpharmml.dom.modeldefn.UncertML;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityDefnBlock;
import eu.ddmore.libpharmml.dom.modeldefn.VariabilityLevelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.AbsorptionMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.CompartmentMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.DepotMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.EffectMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.EliminationMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.IVMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.MacroValue;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.OralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PeripheralMacro;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.TransferMacro;
import eu.ddmore.libpharmml.dom.modellingsteps.Algorithm;
import eu.ddmore.libpharmml.dom.modellingsteps.ApproximateFIM;
import eu.ddmore.libpharmml.dom.modellingsteps.Compute;
import eu.ddmore.libpharmml.dom.modellingsteps.ComputeFIM;
import eu.ddmore.libpharmml.dom.modellingsteps.Cost;
import eu.ddmore.libpharmml.dom.modellingsteps.CostFunction;
import eu.ddmore.libpharmml.dom.modellingsteps.CriterionDef;
import eu.ddmore.libpharmml.dom.modellingsteps.DependentsType;
import eu.ddmore.libpharmml.dom.modellingsteps.DesignType;
import eu.ddmore.libpharmml.dom.modellingsteps.Estimation;
import eu.ddmore.libpharmml.dom.modellingsteps.EstimationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.ExternalDataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.FIM;
import eu.ddmore.libpharmml.dom.modellingsteps.FIMfunction;
import eu.ddmore.libpharmml.dom.modellingsteps.IndividualMapping;
import eu.ddmore.libpharmml.dom.modellingsteps.InterventionsReference;
import eu.ddmore.libpharmml.dom.modellingsteps.MONOLIXdataSet;
import eu.ddmore.libpharmml.dom.modellingsteps.MONOLIXdataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.Method;
import eu.ddmore.libpharmml.dom.modellingsteps.ModellingSteps;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSet;
import eu.ddmore.libpharmml.dom.modellingsteps.NONMEMdataSetReference;
import eu.ddmore.libpharmml.dom.modellingsteps.Observations;
import eu.ddmore.libpharmml.dom.modellingsteps.ObservationsReference;
import eu.ddmore.libpharmml.dom.modellingsteps.OperationProperty;
import eu.ddmore.libpharmml.dom.modellingsteps.OptimalDesignOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.OptimalDesignStep;
import eu.ddmore.libpharmml.dom.modellingsteps.OptimisationAlgorithm;
import eu.ddmore.libpharmml.dom.modellingsteps.OptimiseOn;
import eu.ddmore.libpharmml.dom.modellingsteps.ParameterEstimate;
import eu.ddmore.libpharmml.dom.modellingsteps.Prior;
import eu.ddmore.libpharmml.dom.modellingsteps.Simulation;
import eu.ddmore.libpharmml.dom.modellingsteps.SimulationOperation;
import eu.ddmore.libpharmml.dom.modellingsteps.SoftwareSettings;
import eu.ddmore.libpharmml.dom.modellingsteps.StepDependency;
import eu.ddmore.libpharmml.dom.modellingsteps.StepType;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetTool;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetToolReference;
import eu.ddmore.libpharmml.dom.modellingsteps.ToEstimate;
import eu.ddmore.libpharmml.dom.modellingsteps.TypeFIM;
import eu.ddmore.libpharmml.dom.modellingsteps.VariableMapping;
import eu.ddmore.libpharmml.dom.probonto.DistributionBound;
import eu.ddmore.libpharmml.dom.probonto.DistributionParameter;
import eu.ddmore.libpharmml.dom.probonto.MixtureComponent;
import eu.ddmore.libpharmml.dom.probonto.ProbOnto;
import eu.ddmore.libpharmml.dom.trialdesign.Action;
import eu.ddmore.libpharmml.dom.trialdesign.Activity;
import eu.ddmore.libpharmml.dom.trialdesign.Administration;
import eu.ddmore.libpharmml.dom.trialdesign.ArmDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.ArmMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Arms;
import eu.ddmore.libpharmml.dom.trialdesign.Bolus;
import eu.ddmore.libpharmml.dom.trialdesign.CellDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.CodeInjection;
import eu.ddmore.libpharmml.dom.trialdesign.ContinuousObservation;
import eu.ddmore.libpharmml.dom.trialdesign.CovariateMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Covariates;
import eu.ddmore.libpharmml.dom.trialdesign.DatasetMapping;
import eu.ddmore.libpharmml.dom.trialdesign.Demographic;
import eu.ddmore.libpharmml.dom.trialdesign.DemographicMapping;
import eu.ddmore.libpharmml.dom.trialdesign.DesignSpaces;
import eu.ddmore.libpharmml.dom.trialdesign.DiscreteObservation;
import eu.ddmore.libpharmml.dom.trialdesign.DosingTimesPoints;
import eu.ddmore.libpharmml.dom.trialdesign.DosingVariable;
import eu.ddmore.libpharmml.dom.trialdesign.EpochMapping;
import eu.ddmore.libpharmml.dom.trialdesign.ExternalDataSet;
import eu.ddmore.libpharmml.dom.trialdesign.GenericCode;
import eu.ddmore.libpharmml.dom.trialdesign.IndependentVariableMapping;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualAdministration;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualCovariates;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.IndividualDosing;
import eu.ddmore.libpharmml.dom.trialdesign.Infusion;
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
import eu.ddmore.libpharmml.dom.trialdesign.ReplicateMapping;
import eu.ddmore.libpharmml.dom.trialdesign.SegmentDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.SingleDesignSpace;
import eu.ddmore.libpharmml.dom.trialdesign.SingleIntervention;
import eu.ddmore.libpharmml.dom.trialdesign.SingleObservation;
import eu.ddmore.libpharmml.dom.trialdesign.Stage;
import eu.ddmore.libpharmml.dom.trialdesign.StageDefinition;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyState;
import eu.ddmore.libpharmml.dom.trialdesign.SteadyStateParameter;
import eu.ddmore.libpharmml.dom.trialdesign.StudyPeriod;
import eu.ddmore.libpharmml.dom.trialdesign.StudyTimePoint;
import eu.ddmore.libpharmml.dom.trialdesign.SymbolMapping;
import eu.ddmore.libpharmml.dom.trialdesign.TDCovariateModel;
import eu.ddmore.libpharmml.dom.trialdesign.Target;
import eu.ddmore.libpharmml.dom.trialdesign.TargetToolSymbol;
import eu.ddmore.libpharmml.dom.trialdesign.Timepoints;
import eu.ddmore.libpharmml.dom.trialdesign.TrialDesign;
import eu.ddmore.libpharmml.dom.trialdesign.TrialStructure;
import eu.ddmore.libpharmml.dom.trialdesign.VariableToReset;
import eu.ddmore.libpharmml.dom.trialdesign.Washout;
import eu.ddmore.libpharmml.dom.uncertml.BernoulliDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.BetaDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.BinomialDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalMultivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalProbabilityValueType;
import eu.ddmore.libpharmml.dom.uncertml.CategoricalUnivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.CauchyDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.CentredMomentType;
import eu.ddmore.libpharmml.dom.uncertml.ChiSquareDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.CoefficientOfVariationType;
import eu.ddmore.libpharmml.dom.uncertml.ConfidenceIntervalType;
import eu.ddmore.libpharmml.dom.uncertml.ContinuousMultivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.ContinuousUnivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.CovarianceMatrixType;
import eu.ddmore.libpharmml.dom.uncertml.CredibleIntervalType;
import eu.ddmore.libpharmml.dom.uncertml.DecileType;
import eu.ddmore.libpharmml.dom.uncertml.DiracDeltaDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.DirichletDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteMultivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteProbabilityType;
import eu.ddmore.libpharmml.dom.uncertml.DiscreteUnivariateMixtureModelType;
import eu.ddmore.libpharmml.dom.uncertml.ExponentialDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.FDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.GammaDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.GeometricDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.HypergeometricDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.InterquartileRangeType;
import eu.ddmore.libpharmml.dom.uncertml.InverseGammaDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.KurtosisType;
import eu.ddmore.libpharmml.dom.uncertml.LaplaceDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.LogNormalDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.LogisticDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.MeanType;
import eu.ddmore.libpharmml.dom.uncertml.MedianType;
import eu.ddmore.libpharmml.dom.uncertml.ModeType;
import eu.ddmore.libpharmml.dom.uncertml.MomentType;
import eu.ddmore.libpharmml.dom.uncertml.MultinomialDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.MultivariateNormalDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.MultivariateStudentTDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.NegativeBinomialDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.NormalDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.NormalInverseGammaDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.ParetoDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.PercentileType;
import eu.ddmore.libpharmml.dom.uncertml.PoissonDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.ProbabilityType;
import eu.ddmore.libpharmml.dom.uncertml.QuantileType;
import eu.ddmore.libpharmml.dom.uncertml.QuartileType;
import eu.ddmore.libpharmml.dom.uncertml.RandomSampleType;
import eu.ddmore.libpharmml.dom.uncertml.RangeType;
import eu.ddmore.libpharmml.dom.uncertml.RealisationType;
import eu.ddmore.libpharmml.dom.uncertml.SkewnessType;
import eu.ddmore.libpharmml.dom.uncertml.StandardDeviationType;
import eu.ddmore.libpharmml.dom.uncertml.StatisticsCollectionType;
import eu.ddmore.libpharmml.dom.uncertml.StudentTDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.SystematicSampleType;
import eu.ddmore.libpharmml.dom.uncertml.UniformDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.UnknownSampleType;
import eu.ddmore.libpharmml.dom.uncertml.VarianceType;
import eu.ddmore.libpharmml.dom.uncertml.WeibullDistributionType;
import eu.ddmore.libpharmml.dom.uncertml.WishartDistributionType;
import eu.ddmore.libpharmml.util.WrappedList;

/**
 * Interface for using a visitor mechanism for browsing a PharmML DOM object.
 * 
 * @author Florent Yvon
 */
@SuppressWarnings("deprecation")
public interface Visitor {
	
	void visitDefault(PharmMLNode o);
	
	void visit(PharmML o);
	
	void visit(IndependentVariable o);
	
	void visit(AnnotationType o);
	
	void visit(CategoryRef o);
	
	void visit(CovariateModelRef o);
	
	void visit(Delay o);
	
	void visit(DelayVariable o);
	
	void visit(DerivativeVariable o);
	
	void visit(FalseBoolean o);
	
	void visit(FunctionDefinition o);
	
	void visit(FunctionParameter o);
	
	void visit(History o);
	
	void visit(IdValue o);
	
	void visit(IndependentVariableReference o);
	
	void visit(InitialCondition o);
	
	void visit(InitialTime o);
	
	void visit(InitialValue o);
	
	void visit(Interpolation o);
	
	void visit(InterpolationIV o);
	
	void visit(Interval o);
	
	void visit(IntValue o);
	
	void visit(LevelReference o);
	
	void visit(LowUpLimit o);
	
	void visit(Matrix o);
	
	void visit(MatrixBlock o);
	
	void visit(MatrixBlockSelector o);
	
	void visit(MatrixCell o);
	
	void visit(MatrixCellSelector o);
	
	void visit(MatrixColumn o);
	
	void visit(MatrixColumnRowNames o);
	
	void visit(MatrixRow o);
	
	void visit(MatrixSelector o);
	
	void visit(MatrixVectorIndex o);
	
	void visit(MissingValue o);
	
	void visit(Name o);
	
	void visit(OidRef o);
	
	void visit(Product o);
	
	void visit(RandomEffectMapping o);
	
	void visit(RealValue o);
	
	void visit(Rhs o);
	
	void visit(ScalarRhs o);
	
	void visit(Sequence o);
	
	void visit(StandardAssignable o);
	
//	void visit(StandardAssignableAdapted o);
	
	void visit(StandardOptionalAssignable o);
	
	void visit(StringValue o);
	
	void visit(Sum o);
	
	void visit(SumIndexSet o);
	
	void visit(SumProductIndex o);
	
	void visit(SymbolRef o);
	
	void visit(TrueBoolean o);
	
	void visit(VariableAssignment o);
	
	void visit(VariableDefinition o);
	
	void visit(Vector o);
	
	void visit(VectorCell o);
	
	void visit(VectorElements o);
	
	void visit(VectorSegment o);
	
	void visit(VectorSegmentSelector o);
	
	void visit(VectorSelector o);
	
	// dataset
	
	void visit(CategoryMapping o);
	
	void visit(ColumnMapping o);
	
	void visit(ColumnReference o);
	
	void visit(ColumnsDefinitionType o);
	
	void visit(ColumnTransformation o);
	
	void visit(CommonColumnDefinition o);
	
	void visit(DataSet o);
	
	void visit(DatasetRow o);
	
	void visit(DataSetTable o);
	
	void visit(ExternalFile o);
	
	void visit(HeaderColumnsDefinition o);
	
	void visit(HeaderDefinition o);
	
	void visit(HeaderRow o);
	
	void visit(IgnoreLine o);
	
	void visit(ImportTargetData o);
	
	void visit(MapType o);
	
	void visit(MissingDataMap o);
	
	void visit(TargetMapping o);
	
	void visit(TargetToolDataSet o);
	
	// maths
	
	void visit(Binop o);
	
	void visit(ConditionalStatement o);
	
	void visit(Constant o);
	
	void visit(ElseCondition o);
	
	void visit(EquationType o);
	
	void visit(Expression o);
	
	void visit(FunctionArgumentType o);
	
	void visit(FunctionCallType o);
	
	void visit(IfElseIfCondition o);
	
	void visit(LogicBinOp o);
	
	void visit(LogicCondition o);
	
	void visit(LogicExpression o);
	
	void visit(Naryop o);
	
	void visit(Otherwise o);
	
	void visit(Piecewise o);
	
	void visit(ProbabilityFunction o);
	
	void visit(Statsop o);
	
	// modeldefn
	
	void visit(CategoricalCovariate o);
	
	void visit(CategoricalData o);

	void visit(CategoricalPMF o);
	
	void visit(CategoricalRelation o);
	
	void visit(Category o);
	
	void visit(Censoring o);
	
	void visit(CensoringFeature o);
	
	void visit(CommonDiscreteState o);
	
	void visit(CommonDiscreteVariable o);
	
	void visit(ContinuousCovariate o);
	
	void visit(ContinuousObservationModel o);
	
	void visit(CorrelatedRandomVariable o);
	
	void visit(Correlation o);
	
	void visit(CountData o);
	
	void visit(CountPMF o);
	
	void visit(CovariateDefinition o);
	
	void visit(CovariateModel o);
	
	void visit(CovariateRelation o);
	
	void visit(CovariateTransformation o);
	
	void visit(Dependance o);
	
	void visit(DesignParameter o);
	
	void visit(Discrete o);
	
	void visit(DiscreteDataParameter o);
	
	void visit(Distribution o);
	
	void visit(DSCategoricalCovariateType o);
	
	void visit(DSCategoryType o);
	
	void visit(DSCovariateDefinitionType o);
	
	void visit(FixedEffectRelation o);
	
	void visit(GaussianObsError o);
	
	void visit(GeneralObsError o);
	
	void visit(IndividualParameter o);
	
	void visit(InterventionSequence o);
	
	void visit(LHSTransformationType o);
	
	void visit(LRHSTransformationType o);
	
	void visit(ModelDefinition o);
	
	void visit(ObservationModel o);
	
	void visit(Pairwise o);
	
	void visit(Parameter o);
	
	void visit(ParameterModel o);
	
	void visit(ParameterRandomEffect o);
	
	void visit(ParameterRandomVariable o);
	
	void visit(ParentLevel o);
	
	void visit(PopulationParameter o);
	
	void visit(Probability o);
	
	void visit(ProbabilityAssignment o);
	
	void visit(Realisation o);
	
	void visit(SimpleParameter o);
	
	void visit(StructuralModel o);
	
	void visit(StructuredModel o);
	
	void visit(StructuredObsError o);
	
	void visit(TimeToEventData o);
	
	void visit(TransformedCovariate o);
	
	void visit(TransitionMatrix o);
	
	void visit(TransitionRate o);
	
	void visit(TTEFunction o);
	
	void visit(UncertML o);
	
	void visit(VariabilityDefnBlock o);
	
	void visit(VariabilityLevelDefinition o);

	void visit(GeneralCovariate generalCovariate);

	void visit(LinearCovariate linearCovariate);

	void visit(PopulationValue populationValue);
	
	void visit(eu.ddmore.libpharmml.dom.modeldefn.StructuredModel.LinearCovariate.PopulationValue o);

	void visit(ErrorModel errorModel);

	void visit(Output output);

	void visit(ResidualError residualError);

	void visit(GaussianObsError.ErrorModel errorModel);

	void visit(GaussianObsError.Output output);

	void visit(GaussianObsError.ResidualError residualError);

	void visit(IndividualParameter.GaussianModel.GeneralCovariate generalCovariate);

	void visit(IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter populationParameter);

	void visit(IndividualParameter.GaussianModel.LinearCovariate linearCovariate);

	void visit(IndividualParameter.GaussianModel gaussianModel);
	
	// pkmacro
	
	void visit(AbsorptionMacro o);
	
	void visit(CompartmentMacro o);
	
	void visit(DepotMacro o);
	
	void visit(EffectMacro o);
	
	void visit(EliminationMacro o);
	
	void visit(IVMacro o);
	
	void visit(MacroValue o);
	
	void visit(OralMacro o);
	
	void visit(PeripheralMacro o);
	
	void visit(PKMacroList o);
	
	void visit(TransferMacro o);
	
	// modellingsteps
	
	void visit(Algorithm o);
	
	void visit(ApproximateFIM o);
	
	void visit(Compute o);
	
	void visit(ComputeFIM o);
	
	void visit(Cost o);
	
	void visit(CostFunction o);
	
	void visit(CriterionDef o);
	
	void visit(DependentsType o);
	
	void visit(DesignType o);
	
	void visit(Estimation o);
	
	void visit(EstimationOperation o);
	
	void visit(ExternalDataSetReference o);
	
	void visit(FIM o);
	
	void visit(FIMfunction o);
	
	void visit(IndividualMapping o);
	
	void visit(InterventionsReference o);
	
	void visit(Method o);
	
	void visit(ModellingSteps o);
	
	void visit(MONOLIXdataSet o);
	
	void visit(MONOLIXdataSetReference o);
	
	void visit(NONMEMdataSet o);
	
	void visit(NONMEMdataSetReference o);
	
	void visit(Observations o);
	
	void visit(ObservationsReference o);
	
	void visit(OperationProperty o);
	
	void visit(OptimalDesignOperation o);
	
	void visit(OptimalDesignStep o);
	
	void visit(OptimisationAlgorithm o);
	
	void visit(OptimiseOn o);
	
	void visit(ParameterEstimate o);
	
	void visit(Prior o);
	
	void visit(Simulation o);
	
	void visit(SimulationOperation o);
	
	void visit(SoftwareSettings o);
	
	void visit(StepDependency o);
	
	void visit(StepType o);
	
	void visit(TargetTool o);
	
	void visit(TargetToolReference o);
	
	void visit(ToEstimate o);
	
	void visit(TypeFIM o);
	
	void visit(VariableMapping o);
	
	// probonto
	
	void visit(DistributionBound o);
	
	void visit(DistributionParameter o);
	
	void visit(MixtureComponent o);
	
	void visit(ProbOnto o);
	
	// trialdesign
	
	void visit(Action o);
	
	void visit(Activity o);
	
	void visit(Administration o);
	
	void visit(ArmDefinition o);
	
	void visit(ArmMapping o);
	
	void visit(Arms o);
	
	void visit(Bolus o);
	
	void visit(CellDefinition o);
	
	void visit(CodeInjection o);
	
	void visit(ContinuousObservation o);
	
	void visit(CovariateMapping o);
	
	void visit(Covariates o);
	
	void visit(DatasetMapping o);
	
	void visit(Demographic o);
	
	void visit(DemographicMapping o);
	
	void visit(DesignSpaces o);
	
	void visit(DiscreteObservation o);
	
	void visit(DosingTimesPoints o);
	
	void visit(DosingVariable o);
	
	void visit(EpochMapping o);
	
	void visit(ExternalDataSet o);
	
	void visit(GenericCode o);
	
	void visit(IndependentVariableMapping o);
	
	void visit(IndividualAdministration o);
	
	void visit(IndividualCovariates o);
	
	void visit(IndividualDefinition o);
	
	void visit(IndividualDosing o);
	
	void visit(eu.ddmore.libpharmml.dom.trialdesign.IndividualMapping o);
	
	void visit(Infusion o);
	
	void visit(InterventionList o);
	
	void visit(Interventions o);
	
	void visit(InterventionsCombination o);
	
	void visit(eu.ddmore.libpharmml.dom.trialdesign.InterventionSequence o);
	
	void visit(LookupTable o);
	
	void visit(MultipleDVMapping o);
	
	void visit(Observation o);
	
	void visit(ObservationList o);
	
	void visit(eu.ddmore.libpharmml.dom.trialdesign.Observations o);
	
	void visit(ObservationsCombination o);
	
	void visit(ObservationSequence o);
	
	void visit(ObservationsGroup o);
	
	void visit(Occasion o);
	
	void visit(OccasionList o);
	
	void visit(OccasionSequence o);
	
	void visit(Population o);
	
	void visit(ReplicateMapping o);
	
	void visit(SegmentDefinition o);
	
	void visit(SingleDesignSpace o);
	
	void visit(SingleIntervention o);
	
	void visit(SingleObservation o);
	
	void visit(Stage o);
	
	void visit(StageDefinition o);
	
	void visit(SteadyState o);
	
	void visit(SteadyStateParameter o);
	
	void visit(StudyPeriod o);
	
	void visit(StudyTimePoint o);
	
	void visit(SymbolMapping o);
	
	void visit(Target o);
	
	void visit(TargetToolSymbol o);
	
	void visit(TDCovariateModel o);
	
	void visit(Timepoints o);
	
	void visit(TrialDesign o);
	
	void visit(TrialStructure o);
	
	void visit(VariableToReset o);
	
	void visit(Washout o);
	
	// uncertml
	
	void visit(BernoulliDistributionType o);
	
	void visit(BetaDistributionType o);
	
	void visit(BinomialDistributionType o);
	
	void visit(CategoricalDistributionType o);
	
	void visit(CategoricalMultivariateMixtureModelType o);
	
	void visit(CategoricalProbabilityValueType o);
	
	void visit(CategoricalUnivariateMixtureModelType o);
	
	void visit(CauchyDistributionType o);
	
	void visit(CentredMomentType o);
	
	void visit(ChiSquareDistributionType o);
	
	void visit(CoefficientOfVariationType o);
	
	void visit(ConfidenceIntervalType o);
	
	void visit(ContinuousMultivariateMixtureModelType o);
	
	void visit(ContinuousUnivariateMixtureModelType o);
	
	void visit(eu.ddmore.libpharmml.dom.uncertml.CorrelationType o);
	
	void visit(CovarianceMatrixType o);
	
	void visit(CredibleIntervalType o);
	
	void visit(DecileType o);
	
	void visit(DiracDeltaDistributionType o);
	
	void visit(DirichletDistributionType o);
	
	void visit(DiscreteMultivariateMixtureModelType o);
	
	void visit(DiscreteProbabilityType o);
	
	void visit(DiscreteUnivariateMixtureModelType o);
	
	void visit(ExponentialDistributionType o);
	
	void visit(FDistributionType o);
	
	void visit(GammaDistributionType o);
	
	void visit(GeometricDistributionType o);
	
	void visit(HypergeometricDistributionType o);
	
	void visit(InterquartileRangeType o);
	
	void visit(InverseGammaDistributionType o);
	
	void visit(KurtosisType o);
	
	void visit(LaplaceDistributionType o);
	
	void visit(LogisticDistributionType o);
	
	void visit(LogNormalDistributionType logNormalDistributionType);
	
	void visit(MeanType o);
	
	void visit(MedianType o);
	
	void visit(ModeType o);
	
	void visit(MomentType o);
	
	void visit(MultinomialDistributionType o);
	
	void visit(MultivariateNormalDistributionType o);
	
	void visit(MultivariateStudentTDistributionType o);
	
	void visit(NegativeBinomialDistributionType o);
	
	void visit(NormalDistributionType o);
	
	void visit(NormalInverseGammaDistributionType o);
	
	void visit(ParetoDistributionType o);
	
	void visit(PercentileType o);
	
	void visit(PoissonDistributionType o);
	
	void visit(ProbabilityType o);
	
	void visit(QuantileType o);
	
	void visit(QuartileType o);
	
	void visit(RandomSampleType o);
	
	void visit(RangeType o);
	
	void visit(RealisationType o);
	
	void visit(SkewnessType o);
	
	void visit(StandardDeviationType o);
	
	void visit(StatisticsCollectionType o);
	
	void visit(StudentTDistributionType o);
	
	void visit(SystematicSampleType o);
	
	void visit(UniformDistributionType o);
	
	void visit(UnknownSampleType o);
	
	void visit(VarianceType o);
	
	void visit(WeibullDistributionType o);
	
	void visit(WishartDistributionType o);
	
	// generic
	
	void visit(WrappedList<? extends PharmMLNode> o);
}
