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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.modeldefn.DesignParameter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                 Type defining the design spaces for optimization.
 *             
 * 
 * <p>Java class for DesignSpacesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DesignSpacesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DesignParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DesignSpace" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}SingleDesignSpaceType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DesignSpacesType", propOrder = {
    "listOfDesignParameter",
    "listOfDesignSpace"
})
public class DesignSpaces
    extends PharmMLRootType
{

    @XmlElement(name = "DesignParameter", namespace = NS_DEFAULT_MDEF)
    protected List<DesignParameter> listOfDesignParameter;
    @XmlElement(name = "DesignSpace", required = true)
    protected List<SingleDesignSpace> listOfDesignSpace;

    /**
     * A parameter definition.Gets the value of the designParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfDesignParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DesignParameter }
     * 
     * 
     */
    public List<DesignParameter> getListOfDesignParameter() {
        if (listOfDesignParameter == null) {
        	listOfDesignParameter = new ArrayList<DesignParameter>();
        }
        return this.listOfDesignParameter;
    }

    /**
     * Gets the value of the designSpace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designSpace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfDesignSpace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SingleDesignSpace }
     * 
     * 
     */
    public List<SingleDesignSpace> getListOfDesignSpace() {
        if (listOfDesignSpace == null) {
        	listOfDesignSpace = new ArrayList<SingleDesignSpace>();
        }
        return this.listOfDesignSpace;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfDesignParameter)
    			.addIfNotNull(listOfDesignSpace);
    }
    
    /**
    * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
    * @return The created {@link DesignParameter} object.
    */
    public DesignParameter createDesignParameter(){
        DesignParameter el = new DesignParameter();
        getListOfDesignParameter().add(el);
        return el;
    }

    /**
    * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
    * @param symbId The symbol id of the parameter.
    * @return The created {@link DesignParameter} object.
    */
    public DesignParameter createDesignParameter(String symbId){
        DesignParameter el = new DesignParameter();
        el.setSymbId(symbId);
        getListOfDesignParameter().add(el);
        return el;
    }

    /**
     * Creates a new empty {@link SingleDesignSpace} DesignSpace element, adds it to the current object and returns it.
     * @return The created {@link SingleDesignSpace} object.
     */
    public SingleDesignSpace createDesignSpace(){
            SingleDesignSpace el = new SingleDesignSpace();
            getListOfDesignSpace().add(el);
            return el;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
