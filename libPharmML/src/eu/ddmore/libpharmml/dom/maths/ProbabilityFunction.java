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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.Interpolation;
import eu.ddmore.libpharmml.dom.commontypes.Interval;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.modeldefn.Distribution;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * The general probability function type.
 * 
 * <p>Java class for ProbabilityFctType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProbabilityFctType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Distribution" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DistributionType"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Assign" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProbabilityFctType", propOrder = {
    "distribution",
    "assign"
})
@XmlJavaTypeAdapter(ProbabilityFunction.Adapter.class)
public class ProbabilityFunction
    extends PharmMLRootType implements Symbol, Assignable, ExpressionValue, Operand
{

	@XmlTransient
	protected ProbabilityFunctionType type;
	
    @XmlElement(name = "Distribution", required = true)
    protected Distribution distribution;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;
    
    public ProbabilityFunction(){}
    
    public ProbabilityFunction(ProbabilityFunctionType type){
    	this.type = type;
    }
    
    public ProbabilityFunctionType getType(){
    	return type;
    }
    
    public void setType(ProbabilityFunctionType type){
    	this.type = type;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * @return
     *     possible object is
     *     {@link Distribution }
     *     
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Sets the value of the distribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Distribution }
     *     
     */
    public void setDistribution(Distribution value) {
        this.distribution = value;
    }

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

    /**
     * Gets the value of the symbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbId() {
        return symbId;
    }

    /**
     * Sets the value of the symbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbId(String value) {
        this.symbId = value;
    }
    
    public Distribution createDistribution(){
    	Distribution distrib = new Distribution();
    	this.distribution = distrib;
    	return distrib;
    }
    
    @Override
   	public Rhs assign(Scalar scalar) {
   		Rhs rhs = new Rhs(scalar);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(SymbolRef symbolRef) {
   		Rhs rhs = new Rhs(symbolRef);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Sequence sequence) {
   		Rhs rhs = new Rhs(sequence);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Vector vector) {
   		Rhs rhs = new Rhs(vector);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Interpolation interpolation) {
   		Rhs rhs = new Rhs(interpolation);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Matrix matrix) {
   		Rhs rhs = new Rhs(matrix);
   		setAssign(rhs);
   		return rhs;
   	}
   	
   	@Override
   	public Rhs assign(Constant constant) {
   		Rhs rhs = new Rhs(constant);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Interval interval) {
   		Rhs rhs = new Rhs(interval);
   		setAssign(rhs);
   		return rhs;
   	}
   	
   	@Override
   	public Rhs assign(Binop binop) {
   		Rhs rhs = new Rhs(binop);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Uniop uniop) {
   		Rhs rhs = new Rhs(uniop);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Piecewise piecewise) {
   		Rhs rhs = new Rhs(piecewise);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(FunctionCallType functionCall) {
   		Rhs rhs = new Rhs(functionCall);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Sum sum) {
   		Rhs rhs = new Rhs(sum);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Product product) {
   		Rhs rhs = new Rhs(product);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Delay delay) {
   		Rhs rhs = new Rhs(delay);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(VectorSelector vectorSelector) {
   		Rhs rhs = new Rhs(vectorSelector);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(MatrixSelector matrixSelector) {
   		Rhs rhs = new Rhs(matrixSelector);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(MatrixUniOp matrixUniop) {
   		Rhs rhs = new Rhs(matrixUniop);
   		setAssign(rhs);
   		return rhs;
   	}

   	@Override
   	public Rhs assign(Probability probability) {
   		Rhs rhs = new Rhs(probability);
   		setAssign(rhs);
   		return rhs;
   	}
   	
   	@Override
   	protected List<TreeNode> listChildren() {
   		return new ChainedList<TreeNode>(super.listChildren())
   				.addIfNotNull(distribution)
   				.addIfNotNull(assign);
   	}
   	
   	public static class Adapter extends XmlAdapter<JAXBElement<ProbabilityFunction>, ProbabilityFunction>{

		@Override
		public ProbabilityFunction unmarshal(JAXBElement<ProbabilityFunction> v) throws Exception {
			if(v != null){
				ProbabilityFunction pf = v.getValue();
				pf.setType(ProbabilityFunctionType.fromValue(v.getName().getLocalPart()));
				return pf;
			} else {
				return null;
			}
		}

		@Override
		public JAXBElement<ProbabilityFunction> marshal(ProbabilityFunction v) throws Exception {
			if(v != null && v.getType() != null){
				LoggerWrapper.getLogger().info("Marshal using ProbabilityFunction.Adapter");
				ObjectFactory of = MasterObjectFactory.MATHS_OF;
				switch (v.getType()) {
				case CDF:
					return of.createCDF(v);
				case HF:
					return of.createHF(v);
				case PDF:
					return of.createPDF(v);
				case SF:
					return of.createSF(v);
				default:
					LoggerWrapper.getLogger().warning("Attribute \"type\" is required in ProbabilityFunction "+v);
					return createInvalidPF(v);
				}
			} else {
				return null;
			}
		}
		
		private JAXBElement<ProbabilityFunction> createInvalidPF(ProbabilityFunction v){
			return new JAXBElement<ProbabilityFunction>(
					new QName(NS_DEFAULT_MATH, "invalidProbabilityFunction"), 
					ProbabilityFunction.class, null, v);
		}
   		
   	}

	@Override
	public JAXBElement<? extends Operand> toJAXBElement() {
		try {
			return new Adapter().marshal(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toMathExpression() {
		return new MathExpressionConverterToExpression().convert(this);
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}

	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}

}
