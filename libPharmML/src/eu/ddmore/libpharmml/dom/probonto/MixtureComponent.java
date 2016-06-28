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
package eu.ddmore.libpharmml.dom.probonto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type for ProbOnto distribution mixture component.
 * 
 * <p>Java class for MixtureComponent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MixtureComponent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Parameter" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionParameterType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistroNameType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MixtureComponent", propOrder = {
    "listOfParameter"
})
public class MixtureComponent
    extends PharmMLRootType implements IProbOntoDistribution
{

    @XmlElement(name = "Parameter", required = true)
    protected List<DistributionParameter> listOfParameter;
    @XmlAttribute(name = "name", required = true)
    protected DistributionName name;

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributionParameter }
     * 
     * 
     */
    @Override
	public List<DistributionParameter> getListOfParameter() {
        if (listOfParameter == null) {
            listOfParameter = new ArrayList<DistributionParameter>();
        }
        return this.listOfParameter;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionName }
     *     
     */
    @Override
	public DistributionName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionName }
     *     
     */
    @Override
	public void setName(DistributionName value) {
        this.name = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfParameter);
    }
    
    /**
    * Creates a new empty {@link DistributionParameter} listOfParameter element, adds it to the current object and returns it.
    * @return The created {@link DistributionParameter} object.
    */
    public DistributionParameter createParameter(){
        DistributionParameter el = new DistributionParameter();
        getListOfParameter().add(el);
        return el;
    }

    /**
    * Creates a new empty {@link DistributionParameter} listOfParameter element, adds it to the current object and returns it.
    * @param name Name of the parameter. Check the validity of this name according to the name of
    * this distribution.
    * @return The created {@link DistributionParameter} object.
    */
    public DistributionParameter createParameter(ParameterName name){
        DistributionParameter el = new DistributionParameter();
        el.setName(name);
        getListOfParameter().add(el);
        return el;
    }

	@Override
	public void validate(IErrorHandler errorHandler) {
		Util.validateProbOnto(this, errorHandler);
	}

	/**
	 * Gets the {@link DistributionParameter} defined with the given name. If the parameter is not defined,
	 * this method returns null.
	 * @param parameter Name of the parameter
	 * @return The {@link DistributionParameter} with the given name.
	 */
	@Override
	public DistributionParameter getParameter(ParameterName parameter){
		for(DistributionParameter dp : getListOfParameter()){
			if(dp.getName() != null && dp.getName().equals(parameter)){
				return dp;
			}
		}
		return null;
	}
	
	/**
	 * Checks if this distribution contains the given parameter.
	 * @param parameter Name of the parameter
	 * @return true if the parameter is defined, else false.
	 */
	@Override
	public boolean containsParameter(ParameterName parameter){
		for(DistributionParameter dp : getListOfParameter()){
			if(dp.getName() != null && dp.getName().equals(parameter)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
