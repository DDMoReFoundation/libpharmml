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
package eu.ddmore.libpharmml.dom.maths;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.FalseBoolean;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.TrueBoolean;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Basic stats operators. Take up to two operands.
 *             
 * 
 * <p>Java class for StatsopType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatsopType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sequence"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Interval"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Vector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Dataset}ColumnRef"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sequence"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Interval"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Vector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="centredMoment"/>
 *             &lt;enumeration value="coefficientOfVariation"/>
 *             &lt;enumeration value="correlation"/>
 *             &lt;enumeration value="decile"/>
 *             &lt;enumeration value="geometricMean"/>
 *             &lt;enumeration value="kurtosis"/>
 *             &lt;enumeration value="mean"/>
 *             &lt;enumeration value="median"/>
 *             &lt;enumeration value="mode"/>
 *             &lt;enumeration value="moment"/>
 *             &lt;enumeration value="percentile"/>
 *             &lt;enumeration value="quantile"/>
 *             &lt;enumeration value="quartile"/>
 *             &lt;enumeration value="range"/>
 *             &lt;enumeration value="skewness"/>
 *             &lt;enumeration value="standardDeviation"/>
 *             &lt;enumeration value="variance"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatsopType", propOrder = {
    "rest"
})
public class Statsop
    extends PharmMLRootType implements ExpressionValue, Operand
{

    @XmlElementRefs({
        @XmlElementRef(name = "VectorSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Vector", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Naryop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MatrixSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Interval", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Binop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Statsop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Uniop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Sequence", namespace = NS_DEFAULT_CT, type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ColumnRef", namespace = NS_DEFAULT_DS, type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;
    @XmlAttribute(name = "op", required = true)
    protected Statsoperator op;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "SymbRef" is used by two different parts of a schema. See: 
     * line 82 of file:/automount/vnas-homes_vol-vol_homes-homes/florent/git/libPharmML/libPharmML/src/eu/ddmore/libpharmml/impl/definitions/0_8/maths.xsd
     * line 69 of file:/automount/vnas-homes_vol-vol_homes-homes/florent/git/libPharmML/libPharmML/src/eu/ddmore/libpharmml/impl/definitions/0_8/maths.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Vector }{@code >}
     * {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Naryop }{@code >}
     * {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     * {@link JAXBElement }{@code <}{@link SymbolRef }{@code >}
     * {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Statsop }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Uniop }{@code >}
     * {@link JAXBElement }{@code <}{@link VectorSelector }{@code >}
     * {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     * {@link JAXBElement }{@code <}{@link Interval }{@code >}
     * {@link JAXBElement }{@code <}{@link MatrixSelector }{@code >}
     * {@link JAXBElement }{@code <}{@link Binop }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Sequence }{@code >}
     * {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     * {@link JAXBElement }{@code <}{@link ColumnReference }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link Statsoperator }
     *     
     */
    public Statsoperator getOp() {
        return op;
    }

    /**
     * Sets the value of the op property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statsoperator }
     *     
     */
    public void setOp(Statsoperator value) {
        this.op = value;
    }

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		return MasterObjectFactory.MATHS_OF.createStatsop(this);
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		ChainedList<TreeNode> list = new ChainedList<TreeNode>(super.listChildren());
		for(JAXBElement<?> jaxbEl : getRest()){
			list.add((TreeNode) jaxbEl.getValue());
		}
		return list;
	}

	@Override
	public String toMathExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMathML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convert(MathExpressionConverter converter) {
		// TODO Auto-generated method stub
		return null;
	}

}
