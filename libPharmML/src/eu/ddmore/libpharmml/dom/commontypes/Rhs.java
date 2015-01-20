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
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.Equation;


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
@SuppressWarnings("deprecation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rhs", propOrder = {
    "equation",
    "scalar",
    "symbRef",
    "sequence",
    "vector",
    "interpolation",
    "matrix"
})
@XmlSeeAlso({
    AssignType.class
})
public class Rhs
    extends PharmMLRootType
{

    @XmlElement(name = "Equation", namespace = "http://www.pharmml.org/2013/03/Maths")
    protected Equation equation;
    @XmlElementRef(name = "Scalar", namespace = "http://www.pharmml.org/2013/03/CommonTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<?> scalar;
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
    
    public Rhs(){}
    
    public Rhs(Equation equation){
    	this.equation = equation;
    }
    
    public Rhs(Scalar scalar){
    	// TODO: remove JAXBElement use
    	this.scalar = MasterObjectFactory.createScalar(scalar);
    }
    
    public Rhs(SymbolRef symbRef){
    	this.symbRef = symbRef;
    }

    public Rhs(Sequence sequence){
    	this.sequence = sequence;
    }
    
    public Rhs(Vector vector){
    	this.vector = vector;
    }
    
    public Rhs(Interpolation interpolation){
    	this.interpolation = interpolation;
    }
    
    public Rhs(Matrix matrix){
    	this.matrix = matrix;
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
     *     
     */
    public JAXBElement<?> getScalar() {
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
     *     
     */
    public void setScalar(JAXBElement<?> value) {
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
     * {@link Vector}, {@link Matrix}, {@link Interpolation} and {@link Sequence}.
     */
    public Object getContent(){
    	if(equation != null) return equation;
    	if(scalar != null) return scalar.getValue();
    	if(symbRef != null) return symbRef;
    	if(vector != null) return vector;
    	if(matrix != null) return matrix;
    	if(interpolation != null) return interpolation;
    	if(sequence != null) return sequence;
    	else return null;
    }

}
