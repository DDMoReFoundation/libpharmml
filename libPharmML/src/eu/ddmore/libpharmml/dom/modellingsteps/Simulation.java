/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type defining a simulation step.
 *             
 * 
 * <p>Java class for SimulationStepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimulationStepType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/ModellingSteps}CommonModellingStepType">
 *       &lt;sequence>
 *         &lt;element name="Observations" type="{http://www.pharmml.org/2013/03/ModellingSteps}ObservationsType" maxOccurs="unbounded"/>
 *         &lt;element name="Operation" type="{http://www.pharmml.org/2013/03/ModellingSteps}SimulationOperationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimulationStepType", propOrder = {
    "observations",
    "operation"
})
public class Simulation
    extends CommonModellingStep
{

    @XmlElement(name = "Observations")
    @Deprecated
    protected List<Observations> observations;
    @XmlElement(name = "Operation")
    protected List<SimulationOperation> operation;

    /**
     * Gets the value of the observations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the observations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Observations }
     * 
     * @deprecated Since PharmML 0.7
     */
    @Deprecated
    public List<Observations> getObservations() {
        if (observations == null) {
            observations = new ArrayList<Observations>();
        }
        return this.observations;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimulationOperation }
     * 
     * 
     */
    public List<SimulationOperation> getOperation() {
        if (operation == null) {
            operation = new ArrayList<SimulationOperation>();
        }
        return this.operation;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(observations)
				.addIfNotNull(operation);
	}

}
