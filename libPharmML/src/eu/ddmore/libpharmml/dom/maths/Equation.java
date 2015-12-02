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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.MatrixCellValue;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRowValue;
import eu.ddmore.libpharmml.dom.commontypes.OperationVariable;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.VectorValue;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/Maths}EquationType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.7.1, equation elements has been removed as they were semantically
 * incorrect.
 */
@Deprecated
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Equation")
public class Equation
    extends EquationType implements MatrixCellValue, MatrixRowValue, OperationVariable, VectorValue
{

	@Override
	public String asString() {
		return toString();
	}

	/**
	 * For backwards compatiblity.
	 * @param rhs
	 */
	public static Equation fromRhs(Rhs rhs){
		Equation eq = new Equation();
		
		eq.setBinop(rhs.getBinop());
		eq.setDelay(rhs.getDelay());
		eq.setDescription(rhs.getDescription());
		eq.setFunctionCall(rhs.getFunctionCall());
		eq.setId(rhs.getId());
		eq.setMatrixSelector(rhs.getMatrixSelector());
		eq.setMatrixUniop(rhs.getMatrixUniop());
		eq.setPiecewise(rhs.getPiecewise());
		eq.setProbability(rhs.getProbability());
		eq.setProduct(rhs.getProduct());
		if(rhs.getScalar() != null){
			eq.setScalar(MasterObjectFactory.createScalar(rhs.getScalar()));
		}
		eq.setSum(rhs.getSum());
		eq.setSymbRef(rhs.getSymbRef());
		eq.setUniop(rhs.getUniop());
		eq.setVectorSelector(rhs.getVectorSelector());
		
		return eq;
	}
	
	/**
	 * For backwards compatibility
	 * @param eq
	 */
	public static Rhs toRhs(Equation eq){
		Rhs rhs = new Rhs();

		if(eq.getScalar() != null){
			rhs.setScalar((Scalar) eq.getScalar().getValue());
		} else {
			rhs.setBinop(eq.getBinop());
			rhs.setDelay(eq.getDelay());
			rhs.setDescription(eq.getDescription());
			rhs.setFunctionCall(eq.getFunctionCall());
			rhs.setId(eq.getId());
			rhs.setMatrixSelector(eq.getMatrixSelector());
			rhs.setMatrixUniop(eq.getMatrixUniop());
			rhs.setPiecewise(eq.getPiecewise());
			rhs.setProbability(eq.getProbability());
			rhs.setProduct(eq.getProduct());
			rhs.setSum(eq.getSum());
			rhs.setSymbRef(eq.getSymbRef());
			rhs.setUniop(eq.getUniop());
			rhs.setVectorSelector(eq.getVectorSelector());
		}

		return rhs;
	}
	
	public void dump(){
		
	}

	@Override
	public String toMathExpression() {
		return toRhs(this).toMathExpression();
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(toRhs(this));
	}
	
	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(toRhs(this));
	}

}
