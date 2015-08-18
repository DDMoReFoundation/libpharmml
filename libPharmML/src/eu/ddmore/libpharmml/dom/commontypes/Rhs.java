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
package eu.ddmore.libpharmml.dom.commontypes;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.dom.modellingsteps.InitialEstimate;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * <p>Java class for Rhs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rhs">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/Maths}Equation"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Sequence"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Vector"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Interpolation"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rhs", propOrder = {
    "equation",
    "constant",
    "scalar",
    "symbRef",
    "sequence",
    "interval",
    "vector",
    "interpolation",
    "matrix"
})
@XmlSeeAlso({
    InitialEstimate.class
})
public class Rhs
    extends PharmMLRootType
{

    @XmlElement(name = "Equation", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class, required = false)
    protected Scalar scalar;
    @XmlElement(name = "SymbRef")
    protected SymbolRef symbRef;
    @XmlElement(name = "Sequence")
    protected Sequence sequence;
    @XmlElement(name = "Vector")
    protected Vector vector;
    @XmlElement(name = "Interpolation")
    protected Interpolation interpolation;
    @XmlElement(name = "Matrix")
    protected Matrix matrix;
    
    // PharmML 0.7
    @XmlElement(name = "Constant", namespace = XMLFilter.NS_DEFAULT_MATH)
    protected Constant constant;
    @XmlElement(name = "Interval")
    protected Interval interval;
    
    /**
     * Empty constructor.
     */
    public Rhs(){}
    
    /**
     * Constructs a right-hand side assignment with a {@link Equation}.
     * @param equation The {@link Equation} to be assigned.
     */
    public Rhs(Equation equation){
    	this.equation = equation;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Scalar}.
     * @param scalar The {@link Scalar} to be assigned.
     */
    public Rhs(Scalar scalar){
    	this.scalar = scalar;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link SymbolRef}.
     * @param symbRef The {@link SymbolRef} to be assigned.
     */
    public Rhs(SymbolRef symbRef){
    	this.symbRef = symbRef;
    }

    /**
     * Constructs a right-hand side assignment with a {@link Sequence}.
     * @param sequence The {@link Sequence} to be assigned.
     */
    public Rhs(Sequence sequence){
    	this.sequence = sequence;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Vector}.
     * @param vector The {@link Vector} to be assigned.
     */
    public Rhs(Vector vector){
    	this.vector = vector;
    }
    
    /**
     * Constructs a right-hand side assignment with an {@link Interpolation}.
     * @param interpolation The {@link Interpolation} to be assigned.
     */
    public Rhs(Interpolation interpolation){
    	this.interpolation = interpolation;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Matrix}.
     * @param matrix The {@link Matrix} to be assigned.
     * 
     * @since PharmML 0.4.1
     */
    public Rhs(Matrix matrix){
    	this.matrix = matrix;
    }
    
    /**
     * Constructs a right-hand side assignment with an {@link Interval}.
     * @param interval The {@link Interval} to be assigned.
     * 
     * @since PharmML 0.7
     */
    public Rhs(Interval interval){
    	this.interval = interval;
    }
    
    /**
     * Constructs a right-hand side assignment with a {@link Constant}.
     * @param constant The {@link Constant} to be assigned.
     * 
     * @since PharmML 0.7
     */
    public Rhs(Constant constant){
    	this.constant = constant;
    }
    
    /**
     * A mathematical expression.
     * 
     * @return
     *     possible object is
     *     {@link Equation }
     *     
     */
    public Equation getEquation() {
        return equation;
    }

    /**
     * Sets the value of the equation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Equation }
     *     
     */
    public void setEquation(Equation value) {
        this.equation = value;
    }
    
    /**
     * Gets the value of the constant property.
     * 
     * @return
     *     possible object is
     *     {@link Constant }
     *     
     * @since PharmML 0.7
     */
    public Constant getConstant() {
        return constant;
    }

    /**
     * Sets the value of the constant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Constant }
     *     
     * @since PharmML 0.7
     */
    public void setConstant(Constant value) {
        this.constant = value;
    }

    /**
     * A scalar value.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     *     
     */
    public Scalar getScalar() {
        return scalar;
    }

    /**
     * Sets the value of the scalar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IdValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link FalseBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link StringValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link RealValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link BooleanValue }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrueBoolean }{@code >}
     *     {@link JAXBElement }{@code <}{@link MissingValue }{@code >}
     *     
     */
    public void setScalar(Scalar value) {
        this.scalar = value;
    }

    /**
     * A variable reference.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Sequence }
     *     
     */
    public Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequence }
     *     
     */
    public void setSequence(Sequence value) {
        this.sequence = value;
    }
    
    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Interval }
     *     
     * @since PharmML 0.7
     */
    public Interval getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interval }
     *     
     * @since PharmML 0.7
     */
    public void setInterval(Interval value) {
        this.interval = value;
    }

    /**
     * Gets the value of the vector property.
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Sets the value of the vector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setVector(Vector value) {
        this.vector = value;
    }

    /**
     * Gets the value of the interpolation property.
     * 
     * @return
     *     possible object is
     *     {@link Interpolation }
     *     
     */
    public Interpolation getInterpolation() {
        return interpolation;
    }

    /**
     * Sets the value of the interpolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interpolation }
     *     
     */
    public void setInterpolation(Interpolation value) {
        this.interpolation = value;
    }
    
    /**
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link Matrix }
     *     
     * @since PharmML 0.4.1
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matrix }
     *     
     * @since PharmML 0.4.1
     */
    public void setMatrix(Matrix value) {
        this.matrix = value;
    }
    
    /**
     * Gets the unique content of this Rhs. Each mapped attribute is checked and the first checked one
     * that is not null is returned. Only one is returned even if 2 or more attributes have been set.
     * If there is no content, this method returns null.
     * @return Possible return types are {@link Equation}, {@link Scalar}, {@link SymbolRef}, 
     * {@link Vector}, {@link Matrix}, {@link Interpolation}, {@link Interval},
     * {@link Constant} and {@link Sequence}.
     */
    public Object getContent(){
    	if(equation != null) return equation;
    	if(scalar != null) return scalar;
    	if(symbRef != null) return symbRef;
    	if(vector != null) return vector;
    	if(matrix != null) return matrix;
    	if(interpolation != null) return interpolation;
    	if(sequence != null) return sequence;
    	if(interval != null) return interval;
    	if(constant != null) return constant;
    	else return null;
    }

	@Override
	protected List<TreeNode> listChildren() {
		List<TreeNode> list = new ChainedList<TreeNode>()
				.addIfNotNull(equation)
				.addIfNotNull(scalar)
				.addIfNotNull(symbRef)
				.addIfNotNull(sequence)
				.addIfNotNull(interval)
				.addIfNotNull(vector)
				.addIfNotNull(interpolation)
				.addIfNotNull(matrix);
		return list;
	}

}
