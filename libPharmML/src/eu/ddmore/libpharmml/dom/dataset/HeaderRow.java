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
package eu.ddmore.libpharmml.dom.dataset;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.MissingValueSymbol;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.ScalarContainer;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 This type specifies a header in the dataset.
 *             
 * 
 * <p>Java class for HeaderRowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderRowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Scalar"/>
 *       &lt;/choice>
 *       &lt;attribute name="order" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderRowType", propOrder = {
    "listOfScalar"
})
public class HeaderRow
    extends PharmMLRootType implements ScalarContainer
{

	@XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
	protected List<Scalar> listOfScalar;
    @XmlAttribute(name = "order", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer order;

    /**
     * Gets the value of the scalar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scalar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfScalar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list:
     * {@link StringValue },
     * {@link MissingValue },
     * {@link RealValue },
     * {@link FalseBoolean },
     * {@link IntValue },
     * {@link TrueBoolean },
     * {@link IdValue }
     * 
     * 
     */
    public List<Scalar> getListOfScalar() {
        if (listOfScalar == null) {
        	listOfScalar = new ArrayList<Scalar>();
        }
        return this.listOfScalar;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfScalar);
    }

	@Override
	public IntValue createIntValue(int value) {
		IntValue scalar = new IntValue(value);
		getListOfScalar().add(scalar);
		return scalar;
	}

	@Override
	public RealValue createRealValue(double value) {
		RealValue scalar = new RealValue(value);
		getListOfScalar().add(scalar);
		return scalar;
	}

	@Override
	public StringValue createStringValue(String value) {
		StringValue scalar = new StringValue(value);
		getListOfScalar().add(scalar);
		return scalar;
	}

	@Override
	public IdValue createIdValue(String value) {
		IdValue scalar = new IdValue(value);
		getListOfScalar().add(scalar);
		return scalar;
	}

	@Override
	public BooleanValue createBooleanValue(boolean value) {
		BooleanValue scalar;
		if(value){
			scalar = new TrueBoolean();
		} else {
			scalar = new FalseBoolean();
		}
		getListOfScalar().add(scalar);
		return scalar;
	}

	@Override
	public MissingValue createMissingValue(MissingValueSymbol symbol) {
		MissingValue scalar = new MissingValue(symbol);
		getListOfScalar().add(scalar);
		return scalar;
	}

}
