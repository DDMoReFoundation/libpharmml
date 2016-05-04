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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Structured (e.g. Gaussian) residual error definition. Definition is of the form: 
 * u(y) = u(f) + g * eps. The type dependen on the distribution of 'eps' - can be 
 * Normal or Student-T distribtion.
 * 
 * <p>Java class for StructuredObsError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuredObsError">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}ObservationErrorType">
 *       &lt;sequence>
 *         &lt;element name="Transformation" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}LRHSTransformationType" minOccurs="0"/>
 *         &lt;element name="Output">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ErrorModel">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ResidualError">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredObsError", propOrder = {
    "transformation",
    "output",
    "errorModel",
    "residualError"
})
public class StructuredObsError
    extends ObservationError
{

    @XmlElement(name = "Transformation")
    protected LRHSTransformationType transformation;
    @XmlElement(name = "Output", required = true)
    protected StructuredObsError.Output output;
    @XmlElement(name = "ErrorModel", required = true)
    protected StructuredObsError.ErrorModel errorModel;
    @XmlElement(name = "ResidualError", required = true)
    protected StructuredObsError.ResidualError residualError;

    /**
     * Gets the value of the transformation property.
     * 
     * @return
     *     possible object is
     *     {@link LRHSTransformationType }
     *     
     */
    public LRHSTransformationType getTransformation() {
        return transformation;
    }

    /**
     * Sets the value of the transformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LRHSTransformationType }
     *     
     */
    public void setTransformation(LRHSTransformationType value) {
        this.transformation = value;
    }

    /**
     * The output variable from the structural model.
     * 
     * @return
     *     possible object is
     *     {@link StructuredObsError.Output }
     *     
     */
    public StructuredObsError.Output getOutput() {
        return output;
    }

    /**
     * The output variable from the structural model.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredObsError.Output }
     *     
     */
    public void setOutput(StructuredObsError.Output value) {
        this.output = value;
    }

    /**
     * The error model (g) to apply to the residual error.
     * 
     * @return
     *     possible object is
     *     {@link StructuredObsError.ErrorModel }
     *     
     */
    public StructuredObsError.ErrorModel getErrorModel() {
        return errorModel;
    }

    /**
     * The error model (g) to apply to the residual error.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredObsError.ErrorModel }
     *     
     */
    public void setErrorModel(StructuredObsError.ErrorModel value) {
        this.errorModel = value;
    }

    /**
     * The residual error (eps).
     * 
     * @return
     *     possible object is
     *     {@link StructuredObsError.ResidualError }
     *     
     */
    public StructuredObsError.ResidualError getResidualError() {
        return residualError;
    }

    /**
     * The residual error (eps).
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredObsError.ResidualError }
     *     
     */
    public void setResidualError(StructuredObsError.ResidualError value) {
        this.residualError = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "assign"
    })
    public static class ErrorModel extends PharmMLElement {

        @XmlElement(name = "Assign", namespace = NS_DEFAULT_CT, required = true)
        protected Rhs assign;

        /**
         * Gets the value of the assign property.
         * 
         * @return
         *     possible object is
         *     {@link Rhs }
         *     
         */
        public Rhs getAssign() {
            return assign;
        }

        /**
         * Sets the value of the assign property.
         * 
         * @param value
         *     allowed object is
         *     {@link Rhs }
         *     
         */
        public void setAssign(Rhs value) {
            this.assign = value;
        }
        
        @Override
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>(super.listChildren())
        			.addIfNotNull(assign);
        }

		@Override
		public PharmMLElement clone() {
			return clone(ErrorModel.class, this);
		}

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "symbRef"
    })
    public static class Output extends PharmMLElement {

        @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT, required = true)
        protected SymbolRef symbRef;

        /**
         * Gets the value of the symbRef property.
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
        
        @Override
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>(super.listChildren())
        			.addIfNotNull(symbRef);
        }
        
        @Override
		public PharmMLElement clone() {
			return clone(Output.class, this);
		}

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "symbRef"
    })
    public static class ResidualError extends PharmMLElement {

        @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT, required = true)
        protected SymbolRef symbRef;

        /**
         * Gets the value of the symbRef property.
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
        
        @Override
        protected List<TreeNode> listChildren() {
        	return new ChainedList<TreeNode>(super.listChildren())
        			.addIfNotNull(symbRef);
        }
        
        @Override
		public PharmMLElement clone() {
			return clone(ResidualError.class, this);
		}

    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(super.listChildren())
				.addIfNotNull(transformation)
				.addIfNotNull(output)
				.addIfNotNull(errorModel)
				.addIfNotNull(residualError);
	}

}
