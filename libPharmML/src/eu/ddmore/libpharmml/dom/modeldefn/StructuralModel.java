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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.Block;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.FunctionDefinition;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.maths.ConditionalStatement;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacroList;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type that specifies a structural model.
 *             
 * 
 * <p>Java class for StructuralModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuralModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Name" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;sequence>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}PopulationParameter" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}IndividualParameter" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}Parameter" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}CommonVariable" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="PKmacros" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}PKmacroType" minOccurs="0"/>
 *             &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}AssignStatement" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="ConditionalStatement" type="{http://www.pharmml.org/pharmml/0.8/Maths}ConditionalStatementType" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}BlockDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuralModelType", propOrder = {
    "name",
    "listOfElements"
})
public class StructuralModel
    extends PharmMLRootType implements Block
{

    @XmlElement(name = "Name", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Name name;
    @XmlAttribute(name = "blkId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String blkId;

    /**
     * Attribute that regroups all the variables, parameters, PKMacros and conditional statements.
     */
    @SuppressWarnings("deprecation")
	@XmlElements({
        @XmlElement(name = "CommonVariable", namespace = NS_DEFAULT_CT, required = false),
        @XmlElement(name = "Variable", namespace = NS_DEFAULT_CT, type = VariableDefinition.class, required = false),
        @XmlElement(name = "DerivativeVariable", namespace = NS_DEFAULT_CT, type = DerivativeVariable.class, required = false),
        @XmlElement(name = "ConditionalStatement", namespace = NS_DEFAULT_MDEF, type = ConditionalStatement.class, required = false),
        @XmlElement(name = "PopulationParameter", namespace = NS_DEFAULT_MDEF, type = PopulationParameter.class, required = false),
        @XmlElement(name = "Parameter", namespace = NS_DEFAULT_MDEF, type = Parameter.class, required = false),
        @XmlElement(name = "SimpleParameter", namespace = NS_DEFAULT_MDEF, type = SimpleParameter.class, required = false), // BC
        @XmlElement(name = "PKmacros", namespace = NS_DEFAULT_MDEF, type = PKMacroList.class, required = false),
        @XmlElement(name = "AssignStatement", namespace = NS_DEFAULT_CT, type = LogicBinOp.class, required = false),
        @XmlElement(name = "IndividualParameter", namespace = NS_DEFAULT_MDEF, type = IndividualParameter.class, required = false),
        @XmlElement(name = "FunctionDefinition", namespace = NS_DEFAULT_CT, type = FunctionDefinition.class, required = false),
        @XmlElement(name = "RandomVariable", namespace = NS_DEFAULT_MDEF, type = ParameterRandomVariable.class, required = false)
    })
    protected List<PharmMLElement> listOfElements;
    
    public List<PharmMLElement> getListOfStructuralModelElements() {
        if (listOfElements == null) {
        	listOfElements = new ArrayList<PharmMLElement>();
        }
        return this.listOfElements;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the blkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlkId() {
        return blkId;
    }

    /**
     * Sets the value of the blkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlkId(String value) {
        this.blkId = value;
    }
    
    /**
     * Creates an empty list of PKMacros.
     * @return The created {@link PKMacroList} instance.
     */
    public PKMacroList createPKMacroList(){
    	PKMacroList macros = new PKMacroList();
    	getListOfStructuralModelElements().add(macros);
    	return macros;
    }
    
    /**
     * @deprecated See {@link #createIndividualParameter()} and {@link #createPopulationParameter()}.
     */
    @Deprecated
    public SimpleParameter createSimpleParameter(){
    	SimpleParameter param = new SimpleParameter();
    	getListOfStructuralModelElements().add(param);
    	return param;
    }
    
    /**
     * @deprecated See {@link #createIndividualParameter()} and {@link #createPopulationParameter()}.
     */
    @Deprecated
    public SimpleParameter createSimpleParameter(String symbId){
    	SimpleParameter param = createSimpleParameter();
    	param.setSymbId(symbId);
    	return param;
    }
    
    public IndividualParameter createIndividualParameter(){
    	IndividualParameter param = new IndividualParameter();
    	getListOfStructuralModelElements().add(param);
    	return param;
    }
    
    public PopulationParameter createPopulationParameter(){
    	PopulationParameter param = new PopulationParameter();
    	getListOfStructuralModelElements().add(param);
    	return param;
    }
    
    public VariableDefinition createVariable(){
    	VariableDefinition var = new VariableDefinition();
    	getListOfStructuralModelElements().add(var);
    	return var;
    }
    
    public VariableDefinition createVariable(String symbId, SymbolType symbolType){
    	VariableDefinition var = createVariable();
    	var.setSymbId(symbId);
    	var.setSymbolType(symbolType);
    	return var;
    }
    
    public DerivativeVariable createDerivativeVariable(){
    	DerivativeVariable var = new DerivativeVariable();
    	getListOfStructuralModelElements().add(var);
    	return var;
    }
    
    public DerivativeVariable createDerivativeVariable(String symbId, SymbolType symbolType){
    	DerivativeVariable var = createDerivativeVariable();
    	var.setSymbId(symbId);
    	var.setSymbolType(symbolType);
    	return var;
    }
    
    public LogicBinOp createAssignStatement(){
    	LogicBinOp as = new LogicBinOp();
    	getListOfStructuralModelElements().add(as);
    	return as;
    }
    
    public ConditionalStatement createConditionalStatement(){
    	ConditionalStatement cs = new ConditionalStatement();
    	getListOfStructuralModelElements().add(cs);
    	return cs;
    }
    
    public Parameter createParameter(){
    	Parameter param = new Parameter();
    	getListOfStructuralModelElements().add(param);
    	return param;
    }
    
    public Parameter createParameter(String symbId){
    	Parameter param = new Parameter(symbId);
    	getListOfStructuralModelElements().add(param);
    	return param;
    }
    
    /**
     * Creates a new empty {@link FunctionDefinition} functionDefinition element, adds it to the current object and returns it.
     * @return The created {@link FunctionDefinition} object.
     */
    public FunctionDefinition createFunctionDefinition(){
            FunctionDefinition el = new FunctionDefinition();
            getListOfStructuralModelElements().add(el);
            return el;
    }
    /**
     * Creates a new {@link FunctionDefinition} functionDefinition element, adds it to the
     * current object and returns it.
     * @param symbId Symbol of the function, used when it is referred to.
     * @param type Return type of the function.
     * @return The created {@link FunctionDefinition} object.
     */
    public FunctionDefinition createFunctionDefinition(String symbId, SymbolType type){
            FunctionDefinition el = createFunctionDefinition();
            el.setSymbId(symbId);
            el.setSymbolType(type);
            return el;
    }
    
    //TODO: deal with FunctionParameter no of
    
    @Override
	protected List<TreeNode> listChildren() {
		ChainedList<TreeNode> list = new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(name)
				.addIfNotNull(listOfElements);
		return list;
	}

}
