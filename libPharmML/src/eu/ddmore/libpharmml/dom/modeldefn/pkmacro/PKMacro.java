package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;

/**
 * Abstract class for PK macros.
 * 
 * <p>
 * This class provides common methods to PK macros. At the moment, there is no control of the
 * argument names at the creation stage, this is why the methods for adding values are 
 * implemented in this class. The control of the argument is performed during the validation step.
 * 
 * @author F. Yvon
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {
    "listOfValue"
})
public abstract class PKMacro extends PharmMLRootType {
	
	@XmlElement(name = "Value", type=MacroValue.class, required = true)
	protected List<MacroValue> listOfValue;
		
	/**
	 * Gets the list of values of this macro.
	 * 
	 * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * 
	 * @return A {@link List} of {@link MacroValue} objects.
	 */
	public List<MacroValue> getListOfValue(){
		if(listOfValue == null){
			listOfValue = new ArrayList<MacroValue>();
		}
		return listOfValue;
	}
	
	/**
	 * Creates a new value for this macro with a symbol reference.
	 * @param symbRef A symbol reference. The refered symbol id must be compliant with
	 * the macro definition.
	 * @return The created {@link MacroValue} object.
	 */
	public MacroValue createValue(SymbolRef symbRef){
		MacroValue value = new MacroValue(symbRef);
		getListOfValue().add(value);
		return value;
	}
	
	/**
	 * Creates a new value for this macro with an assignment.
	 * @param argument The name of the argument. It must be compliant with the macro definition.
	 * @param assignment The value that is assigned to the argument.
	 * @return The created {@link MacroValue} object.
	 */
	public MacroValue createValue(String argument, Rhs assignment){
		MacroValue value = new MacroValue(argument, assignment);
		getListOfValue().add(value);
		return value;
	}
	
	/**
	 * Gets the name representation of this macro. It is generally the same than the XML element in lowercase.
	 * @return The name of the macro as {@link String}.
	 */
	abstract public String getName();
	
	/**
	 * Generates a Monolix-like string representation of the macro. The string follows the following
	 * syntax:
	 * <pre>
	 *        macro_name(value_name,value_name=assignment)
	 * </pre>
	 * The macro_name is the value returned by {@link #getName()}.
	 * The value_name (or value=assignment if an assignment has been made) 
	 * is the value returned by {@link MacroValue#toString()}.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+"(");
		
		Iterator<MacroValue> it = getListOfValue().iterator();
		while(it.hasNext()){
			sb.append(it.next());
			if(it.hasNext()){
				sb.append(",");
			}
		}
		
		sb.append(")");
		
		return sb.toString();
	}

}
