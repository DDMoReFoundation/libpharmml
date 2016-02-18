package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.tags.AdaptedClass;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;

@SuppressWarnings("deprecation")
public class StandardAssignableAdapted extends PharmMLRootType implements AdaptedClass<StandardAssignable> {
	
	@XmlTransient
	private StandardAssignable unmappedObject;
	
	@XmlElement(name = "Assign")
    protected Rhs assign;
    
    // The following attributes are meant to support the backward compatiblity before version 0.7.1.
    // When ScalarRhs attributes changed to StandardAssignable.
    @XmlElement(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class)
    protected Scalar scalar;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    
    public StandardAssignableAdapted(){}
    
    public StandardAssignableAdapted(StandardAssignable unmapped){
    	this.unmappedObject = unmapped;
    }
    
    public static StandardAssignableAdapted normal(StandardAssignable sa){
    	StandardAssignableAdapted adapted = new StandardAssignableAdapted();
    	copyRoot(sa, adapted);
    	adapted.assign = sa.getAssign();
    	return adapted;
    }
    
    public static StandardAssignableAdapted scalarRhs(StandardAssignable sa){
    	StandardAssignableAdapted adapted = new StandardAssignableAdapted();
    	copyRoot(sa, adapted);
    	if(sa.getAssign() != null){
    		Rhs assign = sa.getAssign();
    		if(assign.getScalar() != null){
    			adapted.scalar = assign.getScalar();
    		} else if(assign.getSymbRef() != null){
    			adapted.symbRef = assign.getSymbRef();
    		} else if(assign.getEquation() != null){
    			adapted.equation = assign.getEquation();
    		} else {
    			adapted.equation = Equation.fromRhs(assign);
    		}
    	}
    	return adapted;
    }
    
    private static void copyRoot(StandardAssignable from, StandardAssignableAdapted to){
    	to.setId(from.getId());
    	to.setDescription(from.getDescription());
    	to.setMarshalVersion(from.getMarshalVersion());
    }
    
    private static void copyRoot(StandardAssignableAdapted from, StandardAssignable to){
    	to.setId(from.getId());
    	to.setDescription(from.getDescription());
    	to.setMarshalVersion(from.getMarshalVersion());
    }

	@Override
	public StandardAssignable getUnmappedObject() {
		if(unmappedObject == null){
			unmappedObject = generatesPOJO();
		}
		return unmappedObject;
	}
	
	private StandardAssignable generatesPOJO(){
		StandardAssignable sa = new StandardAssignable();
		copyRoot(this, sa);
		if(this.assign != null){
			sa.setAssign(this.assign);
		} else if(this.equation != null) {
			sa.setAssign(Equation.toRhs(this.equation));
		} else if(this.scalar != null){
			sa.setAssign(new Rhs(this.scalar));
		} else if(this.symbRef != null){
			sa.setAssign(new Rhs(this.symbRef));
		}
		return sa;
	}
	
	public static class ScalarRhsAdapter extends XmlAdapter<StandardAssignableAdapted, StandardAssignable>{

		@Override
		public StandardAssignable unmarshal(StandardAssignableAdapted v) throws Exception {
			if(v != null){
				return v.getUnmappedObject();
			} else {
				return null;
			}
		}

		@Override
		public StandardAssignableAdapted marshal(StandardAssignable v) throws Exception {
			if(v != null){
				StandardAssignableAdapted adapted;
				if(v.getMarshalVersion().isEqualOrLaterThan(PharmMLVersion.V0_7_3)){
					adapted = normal(v);
				} else {
					adapted = scalarRhs(v);
				}
				adapted.unmappedObject = v;
				return adapted;
			} else {
				return null;
			}
		}
		
	}

}
