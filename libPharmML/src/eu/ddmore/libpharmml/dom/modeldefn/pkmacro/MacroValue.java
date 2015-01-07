package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.BooleanType;

import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.InterpolationType;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.SequenceType;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRefType;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.VectorType;
import eu.ddmore.libpharmml.dom.maths.Equation;

public class MacroValue extends PharmMLRootType implements Assignable {
	
	// TODO: scalar under assignment, afterUnmarshal
	
	@XmlElement(name = "Assign", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected Rhs assign;
    @XmlElement(name = "SymbRef", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected SymbolRefType symbRef;
    @XmlElementRef(name = "Scalar", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class, required = false)
    protected Scalar scalar;
    @XmlAttribute(name = "argument")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String argument;
    
    /**
     * Empty constructor
     */
    public MacroValue(){}
    
    /**
     * Constructs a new macro value without an assignment. The referenced symbol must be compliant
     * with the macro definition which this value belongs to.
     * @param symbolRef
     */
    public MacroValue(SymbolRefType symbolRef){
    	this.symbRef = symbolRef;
    }
    
    /**
     * Constructs a new macro value with an assignment.
     * @param argument The argument must a have a valid name in the macro definition which
     * this macro value belongs to.
     * @param assignment The assignment for the argument.
     */
    public MacroValue(String argument, Rhs assignment){
    	this.argument = argument;
    	this.assign = assignment;
    }

    /**
     * Initialise the name attribute.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setAssign(Rhs value) {
    	this.scalar = null;
        this.assign = value;
    }

    /**
     * Reference to the variable which is assigned to the 'name' attribute.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRefType }
     *     
     */
    public SymbolRefType getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRefType }
     *     
     */
    public void setSymbRef(SymbolRefType value) {
        this.symbRef = value;
    }

//    /**
//     * The value of the name attribute.
//     * 
//     * @return
//     *     possible object is
//     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
//     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
//     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
//     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
//     *     
//     */
//    public Scalar getScalar() {
//        return scalar;
//    }
//
//    /**
//     * Sets the value of the scalar property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link JAXBElement }{@code <}{@link FalseBooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
//     *     {@link JAXBElement }{@code <}{@link BooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link StringValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IntValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link TrueBooleanType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link RealValueType }{@code >}
//     *     {@link JAXBElement }{@code <}{@link IdValueType }{@code >}
//     *     
//     */
//    public void setScalar(Scalar value) {
//        this.scalar = value;
//    }

    /**
     * Gets the value of the argument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgument() {
        return argument;
    }

    /**
     * Sets the value of the argument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgument(String value) {
        this.argument = value;
    }

	@Override
	public Rhs assign(Scalar scalar) {
		Rhs assign = new Rhs(scalar);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Equation equation) {
		Rhs assign = new Rhs(equation);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(SymbolRefType symbolRef) {
		Rhs assign = new Rhs(symbolRef);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(SequenceType sequence) {
		Rhs assign = new Rhs(sequence);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(VectorType vector) {
		Rhs assign = new Rhs(vector);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(InterpolationType interpolation) {
		Rhs assign = new Rhs(interpolation);
		setAssign(assign);
		return assign;
	}

	@Override
	public Rhs assign(Matrix matrix) {
		Rhs assign = new Rhs(matrix);
		setAssign(assign);
		return assign;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(argument != null){
			sb.append(argument+"=");
		}
		if(scalar != null){
			sb.append(scalar.toString());
		} else if(assign != null && assign.getContent() != null){
			sb.append(assign.getContent().toString());
		} else if(symbRef != null){
			sb.append(symbRef.getSymbIdRef());
		}
		return sb.toString();
	}
	
	protected void afterUnmarshal(Unmarshaller u, Object parent) {
		
	}

}
