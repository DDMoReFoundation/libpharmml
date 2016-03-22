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
package eu.ddmore.libpharmml.dom.trialdesign;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import static eu.ddmore.libpharmml.impl.XMLFilter.NS_DEFAULT_TD;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.ddmore.libpharmml.dom.trialdesign package. 
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

    private final static QName _Order_QNAME = new QName(NS_DEFAULT_TD, "Order");
    @Deprecated
	private final static QName _AttributeMapping_QNAME = new QName(NS_DEFAULT_TD, "AttributeMapping");
    private final static QName _TrialDesign_QNAME = new QName(NS_DEFAULT_TD, "TrialDesign");
    @Deprecated
	private final static QName _ArmMapping_QNAME = new QName(NS_DEFAULT_TD, "ArmMapping");
    @Deprecated
	private final static QName _DemographicMapping_QNAME = new QName(NS_DEFAULT_TD, "DemographicMapping");
    @Deprecated
	private final static QName _ReplicateMapping_QNAME = new QName(NS_DEFAULT_TD, "ReplicateMapping");
    private final static QName _DosingRegimen_QNAME = new QName(NS_DEFAULT_TD, "DosingRegimen");
    @Deprecated // since PharmML 0.7
    private final static QName _StudyEvent_QNAME = new QName(NS_DEFAULT_TD, "StudyEvent");
    private final static QName _Bolus_QNAME = new QName(NS_DEFAULT_TD, "Bolus");
    private final static QName _Washout_QNAME = new QName(NS_DEFAULT_TD, "Washout");
    private final static QName _Infusion_QNAME = new QName(NS_DEFAULT_TD, "Infusion");
	@Deprecated
    private final static QName _IndividualMapping_QNAME = new QName(NS_DEFAULT_TD, "IndividualMapping");
	@Deprecated
    private final static QName _CovariateMapping_QNAME = new QName(NS_DEFAULT_TD, "CovariateMapping");
    @Deprecated // since PharmML 0.7
	private final static QName _ObservationsEvent_QNAME = new QName(NS_DEFAULT_TD, "ObservationsEvent");
    private final static QName _LookupTable_QNAME = new QName(NS_DEFAULT_TD, "LookupTable");
    @Deprecated // since PharmML 0.7
    private final static QName _Activity_QNAME = new QName(NS_DEFAULT_TD, "Activity");
    
    // PharmML 0.8.1
    private final static QName _Stage_QNAME = new QName(NS_DEFAULT_TD, "Stage");
    
    private final static ObjectFactory instance = new ObjectFactory();

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.trialdesign
     * 
     */
    public ObjectFactory() {
    }
    
    public static ObjectFactory getInstance(){
    	return instance;
    }

    /**
     * Create an instance of {@link Infusion }
     * 
     */
    public Infusion createInfusionType() {
        return new Infusion();
    }

    /**
     * Create an instance of {@link TrialDesign }
     * 
     */
    public TrialDesign createTrialDesignType() {
        return new TrialDesign();
    }

    /**
     * Create an instance of {@link LookupTable }
     * 
     */
    public LookupTable createLookupTableType() {
        return new LookupTable();
    }

    /**
     * Create an instance of {@link DemographicMapping }
     * 
     */
	@Deprecated
    public DemographicMapping createDemographicMappingType() {
        return new DemographicMapping();
    }

    /**
     * Create an instance of {@link ReplicateMapping }
     * 
     */
	@Deprecated
    public ReplicateMapping createReplicateMappingType() {
        return new ReplicateMapping();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
	@Deprecated
    public Activity createActivityType() {
        return new Activity();
    }

    /**
     * Create an instance of {@link IndividualMapping }
     * 
     */
	@Deprecated
    public IndividualMapping createIndividualMappingType() {
        return new IndividualMapping();
    }

    /**
     * Create an instance of {@link ArmMapping }
     * 
     */
	@Deprecated
    public ArmMapping createArmMappingType() {
        return new ArmMapping();
    }

    /**
     * Create an instance of {@link Washout }
     * 
     */
    public Washout createWashoutType() {
        return new Washout();
    }

    /**
     * Create an instance of {@link Bolus }
     * 
     */
    public Bolus createBolusType() {
        return new Bolus();
    }
	
	/**
     * Create an instance of {@link CovariateMapping }
     * 
     */
	@Deprecated
    public CovariateMapping createCovariateMappingType() {
        return new CovariateMapping();
    }

    /**
     * Create an instance of {@link TrialStructure }
     * 
     */
	@Deprecated
    public TrialStructure createTrialStructureType() {
        return new TrialStructure();
    }

    /**
     * Create an instance of {@link DosingVariable }
     * 
     */
    public DosingVariable createDosingVariableType() {
        return new DosingVariable();
    }

    /**
     * Create an instance of {@link Treatment }
     * 
     */
	@Deprecated
    public Treatment createTreatmentType() {
        return new Treatment();
    }

    /**
     * Create an instance of {@link SteadyStateParameter }
     * 
     */
    public SteadyStateParameter createSteadyStateParameterType() {
        return new SteadyStateParameter();
    }

    /**
     * Create an instance of {@link StudyPeriod }
     * 
     */
    public StudyPeriod createStudyPeriodType() {
        return new StudyPeriod();
    }

    /**
     * Create an instance of {@link ArmDefinition }
     * 
     */
    public ArmDefinition createArmDefnType() {
        return new ArmDefinition();
    }

    /**
     * Create an instance of {@link Population }
     * 
     */
    @Deprecated
    public Population createPopulationType() {
        return new Population();
    }

    /**
     * Create an instance of {@link IndividualDefinition }
     * 
     */
	@Deprecated
    public IndividualDefinition createIndividualDefinitionType() {
        return new IndividualDefinition();
    }

    /**
     * Create an instance of {@link SteadyState }
     * 
     */
    public SteadyState createSteadyStateType() {
        return new SteadyState();
    }

    /**
     * Create an instance of {@link StudyTimePoint }
     * 
     */
    public StudyTimePoint createStudyTimePointType() {
        return new StudyTimePoint();
    }

    /**
     * Create an instance of {@link IndividualDosing }
     * 
     */
    @Deprecated
    public IndividualDosing createIndividualDosingType() {
        return new IndividualDosing();
    }

    /**
     * Create an instance of {@link CellDefinition }
     * 
     */
    @Deprecated
    public CellDefinition createCellDefnType() {
        return new CellDefinition();
    }

    /**
     * Create an instance of {@link SegmentDefinition }
     * 
     */
    @Deprecated
    public SegmentDefinition createSegmentDefnType() {
        return new SegmentDefinition();
    }

    /**
     * Create an instance of {@link ObservationsGroup }
     * 
     */
    @Deprecated
    public ObservationsGroup createObservationsGroupType() {
        return new ObservationsGroup();
    }

    /**
     * Create an instance of {@link IndependentVariableMapping }
     * 
     */
    @Deprecated
    public IndependentVariableMapping createIndependentVariableMappingType() {
        return new IndependentVariableMapping();
    }

    /**
     * Create an instance of {@link Demographic }
     * 
     */
    @Deprecated
    public Demographic createDemographicType() {
        return new Demographic();
    }

    /**
     * Create an instance of {@link Target }
     * 
     */
    public Target createTargetMappingType() {
        return new Target();
    }

    /**
     * Create an instance of {@link EpochDefinition }
     * 
     */
    public EpochDefinition createEpochDefnType() {
        return new EpochDefinition();
    }

    /**
     * Create an instance of {@link EpochMapping }
     * 
     */
	@Deprecated
    public EpochMapping createEpochMappingType() {
        return new EpochMapping();
    }

    /**
     * Create an instance of {@link DosingTimesPoints }
     * 
     */
    public DosingTimesPoints createDosingTimesPointsType() {
        return new DosingTimesPoints();
    }

    /**
     * Create an instance of {@link IndependentVariableDependentMapping }
     * 
     */
	@Deprecated
    public IndependentVariableDependentMapping createIndependentVariableDependentMappingType() {
        return new IndependentVariableDependentMapping();
    }

    /**
     * Create an instance of {@link Infusion.DoseAmount }
     * 
     */
    public Infusion.DoseAmount createInfusionTypeDoseAmount() {
        return new Infusion.DoseAmount();
    }
    
    //////////////////////////
    /**
     * Create an instance of {@link TDCovariateModel }
     * 
     */
    public TDCovariateModel createTDCovariateModelType() {
        return new TDCovariateModel();
    }

    /**
     * Create an instance of {@link Observation }
     * 
     */
    public Observation createObservationType() {
        return new Observation();
    }

    /**
     * Create an instance of {@link SingleIntervention }
     * 
     */
    public SingleIntervention createSingleInterventionType() {
        return new SingleIntervention();
    }

    /**
     * Create an instance of {@link SingleObservation }
     * 
     */
    public SingleObservation createSingleObservationType() {
        return new SingleObservation();
    }

    /**
     * Create an instance of {@link DesignSpaces }
     * 
     */
    public DesignSpaces createDesignSpacesType() {
        return new DesignSpaces();
    }

    /**
     * Create an instance of {@link ObservationList }
     * 
     */
    public ObservationList createObservationListType() {
        return new ObservationList();
    }

    /**
     * Create an instance of {@link Arms }
     * 
     */
    public Arms createArmsType() {
        return new Arms();
    }

    /**
     * Create an instance of {@link Occasion }
     * 
     */
    public Occasion createOccasionType() {
        return new Occasion();
    }

    /**
     * Create an instance of {@link TargetToolSymbol }
     * 
     */
    public TargetToolSymbol createTargetToolSymbolType() {
        return new TargetToolSymbol();
    }

    /**
     * Create an instance of {@link MultipleDVMapping }
     * 
     */
    public MultipleDVMapping createMultipleDVMappingType() {
        return new MultipleDVMapping();
    }

    /**
     * Create an instance of {@link ObservationsCombination }
     * 
     */
    public ObservationsCombination createObservationsCombinationType() {
        return new ObservationsCombination();
    }

    /**
     * Create an instance of {@link DiscreteObservation }
     * 
     */
    public DiscreteObservation createDiscreteObservationType() {
        return new DiscreteObservation();
    }

    /**
     * Create an instance of {@link InterventionsCombination }
     * 
     */
    public InterventionsCombination createInterventionsCombinationType() {
        return new InterventionsCombination();
    }

    /**
     * Create an instance of {@link DatasetMapping }
     * 
     */
    public DatasetMapping createDatasetMappingType() {
        return new DatasetMapping();
    }

    /**
     * Create an instance of {@link Action }
     * 
     */
    public Action createActionType() {
        return new Action();
    }

    /**
     * Create an instance of {@link GenericCode }
     * 
     */
    public GenericCode createGenericCodeType() {
        return new GenericCode();
    }
    
    /**
     * Create an instance of {@link VariableToReset }
     * 
     */
    public VariableToReset createVariableToResetType() {
        return new VariableToReset();
    }

    /**
     * Create an instance of {@link Covariates }
     * 
     */
    public Covariates createCovariatesType() {
        return new Covariates();
    }

    /**
     * Create an instance of {@link IndividualAdministration }
     * 
     */
    public IndividualAdministration createIndividualAdministrationType() {
        return new IndividualAdministration();
    }

    /**
     * Create an instance of {@link ContinuousObservation }
     * 
     */
    public ContinuousObservation createContinuousObservationType() {
        return new ContinuousObservation();
    }

    /**
     * Create an instance of {@link OccasionList }
     * 
     */
    public OccasionList createOccasionListType() {
        return new OccasionList();
    }

    /**
     * Create an instance of {@link Administration }
     * 
     */
    public Administration createAdministrationType() {
        return new Administration();
    }

    /**
     * Create an instance of {@link CodeInjection }
     * 
     */
    public CodeInjection createCodeInjectionType() {
        return new CodeInjection();
    }

    /**
     * Create an instance of {@link SingleDesignSpace }
     * 
     */
    public SingleDesignSpace createSingleDesignSpaceType() {
        return new SingleDesignSpace();
    }

    /**
     * Create an instance of {@link InterventionList }
     * 
     */
    public InterventionList createInterventionListType() {
        return new InterventionList();
    }

    /**
     * Create an instance of {@link ObservationSequence }
     * 
     */
    public ObservationSequence createObservationSequenceType() {
        return new ObservationSequence();
    }

    /**
     * Create an instance of {@link IndividualCovariates }
     * 
     */
    public IndividualCovariates createIndividualCovariatesType() {
        return new IndividualCovariates();
    }

    /**
     * Create an instance of {@link Observations }
     * 
     */
    public Observations createObservationsType() {
        return new Observations();
    }

    /**
     * Create an instance of {@link Interventions }
     * 
     */
    public Interventions createInterventionsType() {
        return new Interventions();
    }

    /**
     * Create an instance of {@link OccasionSequence }
     * 
     */
    public OccasionSequence createOccasionSequenceType() {
        return new OccasionSequence();
    }

    /**
     * Create an instance of {@link Target }
     * 
     */
    public Target createTargetType() {
        return new Target();
    }

    /**
     * Create an instance of {@link ExternalDataSet }
     * 
     */
    public ExternalDataSet createExternalDataSetType() {
        return new ExternalDataSet();
    }

    /**
     * Create an instance of {@link InterventionSequence }
     * 
     */
    public InterventionSequence createInterventionSequenceType() {
        return new InterventionSequence();
    }

    /**
     * Create an instance of {@link Timepoints }
     * 
     */
    @Deprecated
    public Timepoints createTimepointsType() {
        return new Timepoints();
    }

    /**
     * Create an instance of {@link SymbolMapping }
     * 
     */
    public SymbolMapping createSymbolMappingType() {
        return new SymbolMapping();
    }
    
    /**
     * Create an instance of {@link StageDefinition }
     * 
     * @since PharmML 0.8.1
     */
    public StageDefinition createStageDefinition() {
        return new StageDefinition();
    }
    
    ///////////////////////////

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Order")
    public JAXBElement<IntValue> createOrder(IntValue value) {
        return new JAXBElement<IntValue>(_Order_QNAME, IntValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
	@Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "AttributeMapping")
    public JAXBElement<Object> createAttributeMapping(Object value) {
        return new JAXBElement<Object>(_AttributeMapping_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrialDesign }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "TrialDesign")
    public JAXBElement<TrialDesign> createTrialDesign(TrialDesign value) {
        return new JAXBElement<TrialDesign>(_TrialDesign_QNAME, TrialDesign.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArmMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "ArmMapping")
    @Deprecated
	public JAXBElement<ArmMapping> createArmMapping(ArmMapping value) {
        return new JAXBElement<ArmMapping>(_ArmMapping_QNAME, ArmMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DemographicMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "DemographicMapping", substitutionHeadNamespace = NS_DEFAULT_TD, substitutionHeadName = "AttributeMapping")
    @Deprecated
	public JAXBElement<DemographicMapping> createDemographicMapping(DemographicMapping value) {
        return new JAXBElement<DemographicMapping>(_DemographicMapping_QNAME, DemographicMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplicateMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "ReplicateMapping")
    @Deprecated
	public JAXBElement<ReplicateMapping> createReplicateMapping(ReplicateMapping value) {
        return new JAXBElement<ReplicateMapping>(_ReplicateMapping_QNAME, ReplicateMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DosingRegimen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "DosingRegimen")
    public JAXBElement<DosingRegimen> createDosingRegimen(DosingRegimen value) {
        return new JAXBElement<DosingRegimen>(_DosingRegimen_QNAME, DosingRegimen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudyEvent }{@code >}}
     * 
     */
    @Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "StudyEvent")
    public JAXBElement<StudyEvent> createStudyEvent(StudyEvent value) {
        return new JAXBElement<StudyEvent>(_StudyEvent_QNAME, StudyEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bolus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Bolus", substitutionHeadNamespace = NS_DEFAULT_TD, substitutionHeadName = "DosingRegimen")
    public JAXBElement<Bolus> createBolus(Bolus value) {
        return new JAXBElement<Bolus>(_Bolus_QNAME, Bolus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Washout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Washout")
    public JAXBElement<Washout> createWashout(Washout value) {
        return new JAXBElement<Washout>(_Washout_QNAME, Washout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Infusion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Infusion", substitutionHeadNamespace = NS_DEFAULT_TD, substitutionHeadName = "DosingRegimen")
    public JAXBElement<Infusion> createInfusion(Infusion value) {
        return new JAXBElement<Infusion>(_Infusion_QNAME, Infusion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "IndividualMapping")
    @Deprecated
	public JAXBElement<IndividualMapping> createIndividualMapping(IndividualMapping value) {
        return new JAXBElement<IndividualMapping>(_IndividualMapping_QNAME, IndividualMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovariateMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "ObservationsEvent", substitutionHeadNamespace = NS_DEFAULT_TD, substitutionHeadName = "StudyEvent")
    public JAXBElement<Observations> createObservationsEvent(Observations value) {
        return new JAXBElement<Observations>(_ObservationsEvent_QNAME, Observations.class, null, value);
    }
	
	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovariateMapping }{@code >}}
     * 
     */
	@Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "CovariateMapping", substitutionHeadNamespace = NS_DEFAULT_TD, substitutionHeadName = "AttributeMapping")
    public JAXBElement<CovariateMapping> createCovariateMapping(CovariateMapping value) {
        return new JAXBElement<CovariateMapping>(_CovariateMapping_QNAME, CovariateMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "LookupTable")
    public JAXBElement<LookupTable> createLookupTable(LookupTable value) {
        return new JAXBElement<LookupTable>(_LookupTable_QNAME, LookupTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}}
     * 
     */
    @Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Activity")
    public JAXBElement<Activity> createActivity(Activity value) {
        return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stage }{@code >}}
     * 
     * @since PharmML 0.8.1
     */
    @XmlElementDecl(namespace = NS_DEFAULT_TD, name = "Stage")
    public JAXBElement<Stage> createStage(Stage value) {
        return new JAXBElement<Stage>(_Stage_QNAME, Stage.class, null, value);
    }
    
}
