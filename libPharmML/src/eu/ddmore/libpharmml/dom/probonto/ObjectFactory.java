package eu.ddmore.libpharmml.dom.probonto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import static eu.ddmore.libpharmml.impl.NamespaceFilter.NS_DEFAULT_PROBONTO;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.pharmml.probonto.probonto package. 
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
	
	private static final ObjectFactory instance = new ObjectFactory();

    private final static QName _ProbOnto_QNAME = new QName(NS_DEFAULT_PROBONTO, "ProbOnto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.pharmml.probonto.probonto
     * 
     */
    public ObjectFactory() {
    }
    
    public static ObjectFactory getInstance(){
    	return instance;
    }

    /**
     * Create an instance of {@link ProbOnto }
     * 
     */
    public ProbOnto createProbOnto() {
        return new ProbOnto();
    }

    /**
     * Create an instance of {@link MixtureComponent }
     * 
     */
    public MixtureComponent createMixtureComponent() {
        return new MixtureComponent();
    }

    /**
     * Create an instance of {@link DistributionParameter }
     * 
     */
    public DistributionParameter createDistributionParameter() {
        return new DistributionParameter();
    }

    /**
     * Create an instance of {@link DistributionBound }
     * 
     */
    public DistributionBound createDistributionBound() {
        return new DistributionBound();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProbOnto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_PROBONTO, name = "ProbOnto")
    public JAXBElement<ProbOnto> createProbOnto(ProbOnto value) {
        return new JAXBElement<ProbOnto>(_ProbOnto_QNAME, ProbOnto.class, null, value);
    }

}

