package eu.ddmore.libpharmml.visitor.impl;

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
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel;
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
import eu.ddmore.libpharmml.dom.uncertml.CorrelationType;
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
import eu.ddmore.libpharmml.visitor.Visitor;

/**
 * Default implementation of {@link Visitor}.
 * 
 * <p>With this visitor, any element is visited via the abstract method {@link #visitDefault(PharmMLNode)}. Although users may override
 * any particular method to implement a defined behaviour for a specific DOM class. An concrete implementation of this visitor may be 
 * useful to browse a DOM object attribute which can contain multiple different concrete types. Then one can override the methods concerning
 * those specific types only.
 * 
 * <p><h2>Example:</h2>
 * <pre>
 * <code>
 * Binop binop = getBinop();
 * Operand op1 = binop.getOperand();
 * 
 * DefaultVisitor visitor = new DefaultVisitor(){
 * 
 * 		&#64;Override
 * 		public void visitDefault(PharmMLNode o){
 * 			// Routine for object with unknown type (possibly throwing an error?)
 * 		}
 * 
 * 		// For every possible type of Operand
 * 		&#64;Override
 * 		public void visit(RealValue o){
 * 			// handling a real value
 * 			// ...
 * 		}
 * 
 * 		&#64;Override
 * 		public void visit(Binop o){
 * 			// handling a binop
 * 			// Potentially calling this visitor for the operands of this new binop
 * 			// ...
 * 		}
 * 
 * 		// etc
 * 		// Any method that is not overrided will call visitDefault(o)
 * 
 * }
 * 
 * op1.visit(visitor); // We don't need to know the operand concrete type. The implementation will call the right visit method.
 * </code>
 * </pre>
 * 
 * @author Florent Yvon
 */
@SuppressWarnings("deprecation")
public abstract class DefaultVisitor implements Visitor {

	public abstract void visitDefault(PharmMLNode o);

	@Override
	public void visit(PharmML o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndependentVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(AnnotationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoryRef o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateModelRef o) {
		visitDefault(o);

	}

	@Override
	public void visit(Delay o) {
		visitDefault(o);

	}

	@Override
	public void visit(DelayVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(DerivativeVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(FalseBoolean o) {
		visitDefault(o);

	}

	@Override
	public void visit(FunctionDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(FunctionParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(History o) {
		visitDefault(o);

	}

	@Override
	public void visit(IdValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndependentVariableReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(InitialCondition o) {
		visitDefault(o);

	}

	@Override
	public void visit(InitialTime o) {
		visitDefault(o);

	}

	@Override
	public void visit(InitialValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(Interpolation o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterpolationIV o) {
		visitDefault(o);

	}

	@Override
	public void visit(Interval o) {
		visitDefault(o);

	}

	@Override
	public void visit(IntValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(LevelReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(LowUpLimit o) {
		visitDefault(o);

	}

	@Override
	public void visit(Matrix o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixBlock o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixBlockSelector o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixCell o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixCellSelector o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixColumn o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixColumnRowNames o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixRow o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixSelector o) {
		visitDefault(o);

	}

	@Override
	public void visit(MatrixVectorIndex o) {
		visitDefault(o);

	}

	@Override
	public void visit(MissingValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(Name o) {
		visitDefault(o);

	}

	@Override
	public void visit(OidRef o) {
		visitDefault(o);

	}

	@Override
	public void visit(Product o) {
		visitDefault(o);

	}

	@Override
	public void visit(RandomEffectMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(RealValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(Rhs o) {
		visitDefault(o);

	}

	@Override
	public void visit(ScalarRhs o) {
		visitDefault(o);

	}

	@Override
	public void visit(Sequence o) {
		visitDefault(o);

	}

	@Override
	public void visit(StandardAssignable o) {
		visitDefault(o);

	}

	@Override
	public void visit(StandardOptionalAssignable o) {
		visitDefault(o);

	}

	@Override
	public void visit(StringValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(Sum o) {
		visitDefault(o);

	}

	@Override
	public void visit(SumIndexSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(SumProductIndex o) {
		visitDefault(o);

	}

	@Override
	public void visit(SymbolRef o) {
		visitDefault(o);

	}

	@Override
	public void visit(TrueBoolean o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariableAssignment o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariableDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(Vector o) {
		visitDefault(o);

	}

	@Override
	public void visit(VectorCell o) {
		visitDefault(o);

	}

	@Override
	public void visit(VectorElements o) {
		visitDefault(o);

	}

	@Override
	public void visit(VectorSegment o) {
		visitDefault(o);

	}

	@Override
	public void visit(VectorSegmentSelector o) {
		visitDefault(o);

	}

	@Override
	public void visit(VectorSelector o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoryMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(ColumnMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(ColumnReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(ColumnsDefinitionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ColumnTransformation o) {
		visitDefault(o);

	}

	@Override
	public void visit(CommonColumnDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(DataSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(DatasetRow o) {
		visitDefault(o);

	}

	@Override
	public void visit(DataSetTable o) {
		visitDefault(o);

	}

	@Override
	public void visit(ExternalFile o) {
		visitDefault(o);

	}

	@Override
	public void visit(HeaderColumnsDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(HeaderDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(HeaderRow o) {
		visitDefault(o);

	}

	@Override
	public void visit(IgnoreLine o) {
		visitDefault(o);

	}

	@Override
	public void visit(ImportTargetData o) {
		visitDefault(o);

	}

	@Override
	public void visit(MapType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MissingDataMap o) {
		visitDefault(o);

	}

	@Override
	public void visit(TargetMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(TargetToolDataSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(Binop o) {
		visitDefault(o);

	}

	@Override
	public void visit(ConditionalStatement o) {
		visitDefault(o);

	}

	@Override
	public void visit(Constant o) {
		visitDefault(o);

	}

	@Override
	public void visit(ElseCondition o) {
		visitDefault(o);

	}

	@Override
	public void visit(EquationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(Expression o) {
		visitDefault(o);

	}

	@Override
	public void visit(FunctionArgumentType o) {
		visitDefault(o);

	}

	@Override
	public void visit(FunctionCallType o) {
		visitDefault(o);

	}

	@Override
	public void visit(IfElseIfCondition o) {
		visitDefault(o);

	}

	@Override
	public void visit(LogicBinOp o) {
		visitDefault(o);

	}

	@Override
	public void visit(LogicCondition o) {
		visitDefault(o);

	}

	@Override
	public void visit(LogicExpression o) {
		visitDefault(o);

	}

	@Override
	public void visit(Naryop o) {
		visitDefault(o);

	}

	@Override
	public void visit(Otherwise o) {
		visitDefault(o);

	}

	@Override
	public void visit(Piecewise o) {
		visitDefault(o);

	}

	@Override
	public void visit(ProbabilityFunction o) {
		visitDefault(o);

	}

	@Override
	public void visit(Statsop o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalData o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalPMF o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalRelation o) {
		visitDefault(o);

	}

	@Override
	public void visit(Category o) {
		visitDefault(o);

	}

	@Override
	public void visit(Censoring o) {
		visitDefault(o);

	}

	@Override
	public void visit(CensoringFeature o) {
		visitDefault(o);

	}

	@Override
	public void visit(CommonDiscreteState o) {
		visitDefault(o);

	}

	@Override
	public void visit(CommonDiscreteVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(ContinuousCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(ContinuousObservationModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(CorrelatedRandomVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(Correlation o) {
		visitDefault(o);

	}

	@Override
	public void visit(CountData o) {
		visitDefault(o);

	}

	@Override
	public void visit(CountPMF o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateRelation o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateTransformation o) {
		visitDefault(o);

	}

	@Override
	public void visit(Dependance o) {
		visitDefault(o);

	}

	@Override
	public void visit(DesignParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(Discrete o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiscreteDataParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(Distribution o) {
		visitDefault(o);

	}

	@Override
	public void visit(DSCategoricalCovariateType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DSCategoryType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DSCovariateDefinitionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(FixedEffectRelation o) {
		visitDefault(o);

	}

	@Override
	public void visit(GaussianObsError o) {
		visitDefault(o);

	}

	@Override
	public void visit(GeneralObsError o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterventionSequence o) {
		visitDefault(o);

	}

	@Override
	public void visit(LHSTransformationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(LRHSTransformationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ModelDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(Pairwise o) {
		visitDefault(o);

	}

	@Override
	public void visit(Parameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParameterModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParameterRandomEffect o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParameterRandomVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParentLevel o) {
		visitDefault(o);

	}

	@Override
	public void visit(PopulationParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(
			eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate.PopulationParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(Probability o) {
		visitDefault(o);

	}

	@Override
	public void visit(ProbabilityAssignment o) {
		visitDefault(o);

	}

	@Override
	public void visit(Realisation o) {
		visitDefault(o);

	}

	@Override
	public void visit(SimpleParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(StructuralModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(StructuredModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(StructuredObsError o) {
		visitDefault(o);

	}

	@Override
	public void visit(TimeToEventData o) {
		visitDefault(o);

	}

	@Override
	public void visit(TransformedCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(TransitionMatrix o) {
		visitDefault(o);

	}

	@Override
	public void visit(TransitionRate o) {
		visitDefault(o);

	}

	@Override
	public void visit(TTEFunction o) {
		visitDefault(o);

	}

	@Override
	public void visit(UncertML o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariabilityDefnBlock o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariabilityLevelDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(GeneralCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(
			eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.GeneralCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(LinearCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(
			eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel.LinearCovariate o) {
		visitDefault(o);

	}

	@Override
	public void visit(PopulationValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.modeldefn.StructuredModel.LinearCovariate.PopulationValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(ErrorModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.modeldefn.GaussianObsError.ErrorModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(Output o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.modeldefn.GaussianObsError.Output o) {
		visitDefault(o);

	}

	@Override
	public void visit(ResidualError o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.modeldefn.GaussianObsError.ResidualError o) {
		visitDefault(o);

	}

	@Override
	public void visit(GaussianModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(AbsorptionMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(CompartmentMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(DepotMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(EffectMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(EliminationMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(IVMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(MacroValue o) {
		visitDefault(o);

	}

	@Override
	public void visit(OralMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(PeripheralMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(PKMacroList o) {
		visitDefault(o);

	}

	@Override
	public void visit(TransferMacro o) {
		visitDefault(o);

	}

	@Override
	public void visit(Algorithm o) {
		visitDefault(o);

	}

	@Override
	public void visit(ApproximateFIM o) {
		visitDefault(o);

	}

	@Override
	public void visit(Compute o) {
		visitDefault(o);

	}

	@Override
	public void visit(ComputeFIM o) {
		visitDefault(o);

	}

	@Override
	public void visit(Cost o) {
		visitDefault(o);

	}

	@Override
	public void visit(CostFunction o) {
		visitDefault(o);

	}

	@Override
	public void visit(CriterionDef o) {
		visitDefault(o);

	}

	@Override
	public void visit(DependentsType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DesignType o) {
		visitDefault(o);

	}

	@Override
	public void visit(Estimation o) {
		visitDefault(o);

	}

	@Override
	public void visit(EstimationOperation o) {
		visitDefault(o);

	}

	@Override
	public void visit(ExternalDataSetReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(FIM o) {
		visitDefault(o);

	}

	@Override
	public void visit(FIMfunction o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterventionsReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(Method o) {
		visitDefault(o);

	}

	@Override
	public void visit(ModellingSteps o) {
		visitDefault(o);

	}

	@Override
	public void visit(MONOLIXdataSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(MONOLIXdataSetReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(NONMEMdataSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(NONMEMdataSetReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(Observations o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationsReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(OperationProperty o) {
		visitDefault(o);

	}

	@Override
	public void visit(OptimalDesignOperation o) {
		visitDefault(o);

	}

	@Override
	public void visit(OptimalDesignStep o) {
		visitDefault(o);

	}

	@Override
	public void visit(OptimisationAlgorithm o) {
		visitDefault(o);

	}

	@Override
	public void visit(OptimiseOn o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParameterEstimate o) {
		visitDefault(o);

	}

	@Override
	public void visit(Prior o) {
		visitDefault(o);

	}

	@Override
	public void visit(Simulation o) {
		visitDefault(o);

	}

	@Override
	public void visit(SimulationOperation o) {
		visitDefault(o);

	}

	@Override
	public void visit(SoftwareSettings o) {
		visitDefault(o);

	}

	@Override
	public void visit(StepDependency o) {
		visitDefault(o);

	}

	@Override
	public void visit(StepType o) {
		visitDefault(o);

	}

	@Override
	public void visit(TargetTool o) {
		visitDefault(o);

	}

	@Override
	public void visit(TargetToolReference o) {
		visitDefault(o);

	}

	@Override
	public void visit(ToEstimate o) {
		visitDefault(o);

	}

	@Override
	public void visit(TypeFIM o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariableMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(DistributionBound o) {
		visitDefault(o);

	}

	@Override
	public void visit(DistributionParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(MixtureComponent o) {
		visitDefault(o);

	}

	@Override
	public void visit(ProbOnto o) {
		visitDefault(o);

	}

	@Override
	public void visit(Action o) {
		visitDefault(o);

	}

	@Override
	public void visit(Activity o) {
		visitDefault(o);

	}

	@Override
	public void visit(Administration o) {
		visitDefault(o);

	}

	@Override
	public void visit(ArmDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(ArmMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Arms o) {
		visitDefault(o);

	}

	@Override
	public void visit(Bolus o) {
		visitDefault(o);

	}

	@Override
	public void visit(CellDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(CodeInjection o) {
		visitDefault(o);

	}

	@Override
	public void visit(ContinuousObservation o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovariateMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Covariates o) {
		visitDefault(o);

	}

	@Override
	public void visit(DatasetMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Demographic o) {
		visitDefault(o);

	}

	@Override
	public void visit(DemographicMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(DesignSpaces o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiscreteObservation o) {
		visitDefault(o);

	}

	@Override
	public void visit(DosingTimesPoints o) {
		visitDefault(o);

	}

	@Override
	public void visit(DosingVariable o) {
		visitDefault(o);

	}

	@Override
	public void visit(EpochMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(ExternalDataSet o) {
		visitDefault(o);

	}

	@Override
	public void visit(GenericCode o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndependentVariableMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualAdministration o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualCovariates o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(IndividualDosing o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.trialdesign.IndividualMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Infusion o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterventionList o) {
		visitDefault(o);

	}

	@Override
	public void visit(Interventions o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterventionsCombination o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.trialdesign.InterventionSequence o) {
		visitDefault(o);

	}

	@Override
	public void visit(LookupTable o) {
		visitDefault(o);

	}

	@Override
	public void visit(MultipleDVMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Observation o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationList o) {
		visitDefault(o);

	}

	@Override
	public void visit(eu.ddmore.libpharmml.dom.trialdesign.Observations o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationsCombination o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationSequence o) {
		visitDefault(o);

	}

	@Override
	public void visit(ObservationsGroup o) {
		visitDefault(o);

	}

	@Override
	public void visit(Occasion o) {
		visitDefault(o);

	}

	@Override
	public void visit(OccasionList o) {
		visitDefault(o);

	}

	@Override
	public void visit(OccasionSequence o) {
		visitDefault(o);

	}

	@Override
	public void visit(Population o) {
		visitDefault(o);

	}

	@Override
	public void visit(ReplicateMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(SegmentDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(SingleDesignSpace o) {
		visitDefault(o);

	}

	@Override
	public void visit(SingleIntervention o) {
		visitDefault(o);

	}

	@Override
	public void visit(SingleObservation o) {
		visitDefault(o);

	}

	@Override
	public void visit(StageDefinition o) {
		visitDefault(o);

	}

	@Override
	public void visit(SteadyState o) {
		visitDefault(o);

	}

	@Override
	public void visit(SteadyStateParameter o) {
		visitDefault(o);

	}

	@Override
	public void visit(StudyPeriod o) {
		visitDefault(o);

	}

	@Override
	public void visit(StudyTimePoint o) {
		visitDefault(o);

	}

	@Override
	public void visit(SymbolMapping o) {
		visitDefault(o);

	}

	@Override
	public void visit(Target o) {
		visitDefault(o);

	}

	@Override
	public void visit(TargetToolSymbol o) {
		visitDefault(o);

	}

	@Override
	public void visit(TDCovariateModel o) {
		visitDefault(o);

	}

	@Override
	public void visit(Timepoints o) {
		visitDefault(o);

	}

	@Override
	public void visit(TrialDesign o) {
		visitDefault(o);

	}

	@Override
	public void visit(TrialStructure o) {
		visitDefault(o);

	}

	@Override
	public void visit(VariableToReset o) {
		visitDefault(o);

	}

	@Override
	public void visit(Washout o) {
		visitDefault(o);

	}

	@Override
	public void visit(BernoulliDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(BetaDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(BinomialDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalMultivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalProbabilityValueType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CategoricalUnivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CauchyDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CentredMomentType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ChiSquareDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CoefficientOfVariationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ConfidenceIntervalType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ContinuousMultivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ContinuousUnivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CorrelationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CovarianceMatrixType o) {
		visitDefault(o);

	}

	@Override
	public void visit(CredibleIntervalType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DecileType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiracDeltaDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DirichletDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiscreteMultivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiscreteProbabilityType o) {
		visitDefault(o);

	}

	@Override
	public void visit(DiscreteUnivariateMixtureModelType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ExponentialDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(FDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(GammaDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(GeometricDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(HypergeometricDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(InterquartileRangeType o) {
		visitDefault(o);

	}

	@Override
	public void visit(InverseGammaDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(KurtosisType o) {
		visitDefault(o);

	}

	@Override
	public void visit(LaplaceDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(LogisticDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(LogNormalDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MeanType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MedianType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ModeType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MomentType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MultinomialDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MultivariateNormalDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(MultivariateStudentTDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(NegativeBinomialDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(NormalDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(NormalInverseGammaDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ParetoDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(PercentileType o) {
		visitDefault(o);

	}

	@Override
	public void visit(PoissonDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(ProbabilityType o) {
		visitDefault(o);

	}

	@Override
	public void visit(QuantileType o) {
		visitDefault(o);

	}

	@Override
	public void visit(QuartileType o) {
		visitDefault(o);

	}

	@Override
	public void visit(RandomSampleType o) {
		visitDefault(o);

	}

	@Override
	public void visit(RangeType o) {
		visitDefault(o);

	}

	@Override
	public void visit(RealisationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(SkewnessType o) {
		visitDefault(o);

	}

	@Override
	public void visit(StandardDeviationType o) {
		visitDefault(o);

	}

	@Override
	public void visit(StatisticsCollectionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(StudentTDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(SystematicSampleType o) {
		visitDefault(o);

	}

	@Override
	public void visit(UniformDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(UnknownSampleType o) {
		visitDefault(o);

	}

	@Override
	public void visit(VarianceType o) {
		visitDefault(o);

	}

	@Override
	public void visit(WeibullDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(WishartDistributionType o) {
		visitDefault(o);

	}

	@Override
	public void visit(WrappedList<? extends PharmMLNode> o) {
		visitDefault(o);

	}

}
