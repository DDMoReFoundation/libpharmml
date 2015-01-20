/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.21 at 11:29:00 AM BST 
//


package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;


/**
 * Abstract type defining common observation model.
 * 
 * <p>Java class for CommonObservationModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonObservationModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModelDefinition}CommonParameterElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Variable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Correlation" type="{http://www.pharmml.org/2013/03/ModelDefinition}CorrelationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonObservationModelType", propOrder = {
    "name",
    "commonParameterElement",
    "variable",
    "correlation"
})
@XmlSeeAlso({
    ContinuousObservationModel.class,
    TimeToEventData.class,
    CategoricalData.class,
    CountData.class
})
//@XmlJavaTypeAdapter(CommonObservationModel.Adapter.class)
public abstract class CommonObservationModel
    extends PharmMLRootType
{

    @XmlElement(name = "Name", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected Name name;
    
    // -----------
    @XmlElementRef(name = "CommonParameterElement", namespace = "http://www.pharmml.org/2013/03/ModelDefinition", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CommonParameterType>> commonParameterElement;
    @XmlTransient
    protected List<CommonParameterType> listOfCommonParameterElement;
    // ------------
    
    @XmlElement(name = "Variable", namespace = "http://www.pharmml.org/2013/03/CommonTypes")
    protected List<VariableDefinition> variable;
    @XmlElement(name = "Correlation")
    protected List<CorrelationType> correlation;

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

//    /**
//     * Gets the value of the commonParameterElement property.
//     * 
//     * <p>
//     * This accessor method returns a reference to the live list,
//     * not a snapshot. Therefore any modification you make to the
//     * returned list will be present inside the JAXB object.
//     * This is why there is not a <CODE>set</CODE> method for the commonParameterElement property.
//     * 
//     * <p>
//     * For example, to add a new item, do as follows:
//     * <pre>
//     *    getCommonParameterElement().add(newItem);
//     * </pre>
//     * 
//     * 
//     * <p>
//     * Objects of the following type(s) are allowed in the list
//     * {@link JAXBElement }{@code <}{@link CommonParameterType }{@code >}
//     * {@link JAXBElement }{@code <}{@link SimpleParameterType }{@code >}
//     * {@link JAXBElement }{@code <}{@link IndividualParameterType }{@code >}
//     * {@link JAXBElement }{@code <}{@link ParameterRandomVariableType }{@code >}
//     * 
//     * 
//     */
//    public List<JAXBElement<? extends CommonParameterType>> getListOfCommonParameterElement() {
//        if (commonParameterElement == null) {
//            commonParameterElement = new ArrayList<JAXBElement<? extends CommonParameterType>>();
//        }
//        return this.commonParameterElement;
//    }
    
    /**
     * Gets the value of the commonParameterElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonParameterElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonParameterElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonParameterType }
     * {@link SimpleParameterType }
     * {@link IndividualParameterType }
     * {@link ParameterRandomVariableType }
     * 
     * 
     */
    public List<CommonParameterType> getListOfCommonParameterElement() {
        if (listOfCommonParameterElement == null) {
        	listOfCommonParameterElement = new ArrayList<CommonParameterType>();
        }
        return this.listOfCommonParameterElement;
    }

    /**
     * A variable definition.Gets the value of the variable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableDefinition }
     * 
     * 
     */
    public List<VariableDefinition> getListOfVariable() {
        if (variable == null) {
            variable = new ArrayList<VariableDefinition>();
        }
        return this.variable;
    }

    /**
     * Gets the value of the correlation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the correlation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorrelation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorrelationType }
     * 
     * 
     */
    public List<CorrelationType> getListOfCorrelation() {
        if (correlation == null) {
            correlation = new ArrayList<CorrelationType>();
        }
        return this.correlation;
    }
    
    /**
     * Creates a new {@link Name} name element, adds it to the current object and returns it.
     * @param name The value of the name
     * @return The created {@link Name} object.
     */
    public Name createName(String name){
            Name el = new Name();
            this.name = el;
            el.setValue(name);
            return el;
    }

    /**
     * Creates a new empty {@link VariableDefinition} variable element, adds it to the current object and returns it.
     * @return The created {@link VariableDefinition} object.
     */
    public VariableDefinition createVariable(){
            VariableDefinition el = new VariableDefinition();
            getListOfVariable().add(el);
            return el;
    }
    
    /**
     * Creates a new {@link VariableDefinition} variable element, adds it to the current object and returns it.
     * @param symbolId The identifier of the symbol
     * @param type The symbol type
     * @return The created {@link VariableDefinition} object.
     */
    public VariableDefinition createVariable(String symbolId, SymbolType type){
            VariableDefinition el = new VariableDefinition();
            getListOfVariable().add(el);
            el.setSymbId(symbolId);
            el.setSymbolType(type);
            return el;
    }

    /**
     * Creates a new empty {@link CorrelationType} correlation element, adds it to the current object and returns it.
     * @return The created {@link CorrelationType} object.
     */
    public CorrelationType createCorrelation(){
            CorrelationType el = new CorrelationType();
            getListOfCorrelation().add(el);
            return el;
    }
    
    protected void afterUnmarshal(Unmarshaller u, Object parent){
    	if(commonParameterElement != null){
			listOfCommonParameterElement = new ArrayList<CommonParameterType>();
			for(JAXBElement<? extends CommonParameterType> el : commonParameterElement){
				listOfCommonParameterElement.add(el.getValue());
			}
		} else {
			listOfCommonParameterElement = null;
		}
    }
    
    protected void beforeMarshal(Marshaller m){
    	if(listOfCommonParameterElement != null){
			commonParameterElement = new ArrayList<JAXBElement<? extends CommonParameterType>>();
			for(CommonParameterType param : listOfCommonParameterElement){
				commonParameterElement.add(MasterObjectFactory.createParameter(param));
			}
		} else {
			commonParameterElement = null;
		}
    }
    
//    protected static class Adapter extends XmlAdapter<CommonObservationModel,CommonObservationModel>{
//
//		@Override
//		public CommonObservationModel unmarshal(CommonObservationModel v)
//				throws Exception {
//			if(v.commonParameterElement != null){
//				v.listOfCommonParameterElement = new ArrayList<CommonParameterType>();
//				for(JAXBElement<? extends CommonParameterType> el : v.commonParameterElement){
//					v.listOfCommonParameterElement.add(el.getValue());
//				}
//			}
//			return v;
//		}
//
//		@Override
//		public CommonObservationModel marshal(CommonObservationModel v)
//				throws Exception {
//			if(v == null){
//				return v;
//			}
//			if(v.listOfCommonParameterElement != null){
//				v.commonParameterElement = new ArrayList<JAXBElement<? extends CommonParameterType>>();
//				for(CommonParameterType param : v.listOfCommonParameterElement){
//					v.commonParameterElement.add(MasterObjectFactory.createParameter(param));
//				}
//			}
//			return v;
//		}
//    	
//    }


}
