package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRefType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {
    "listOfValue"
})
public abstract class Macro extends PharmMLRootType {
	
	@XmlElement(name = "Value", type=MacroValue.class, required = true)
	List<MacroValue> listOfValue;
	
	public List<MacroValue> getListOfValue(){
		if(listOfValue == null){
			listOfValue = new ArrayList<MacroValue>();
		}
		return listOfValue;
	}
	
	public MacroValue createValue(SymbolRefType symbRef){
		MacroValue value = new MacroValue(symbRef);
		getListOfValue().add(value);
		return value;
	}
	
	public MacroValue createValue(String argument, Rhs assignment){
		MacroValue value = new MacroValue(argument, assignment);
		getListOfValue().add(value);
		return value;
	}

}
