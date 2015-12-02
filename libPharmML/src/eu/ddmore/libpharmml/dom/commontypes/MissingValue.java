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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;


/**
 * Class of encoding a missing value in data.
 * 
 * <p>This class has a different mapping behaviour than the other ones. While the type of any missing
 * value uses this class, the actual name of the XML element is determined by the {@link #getSymbol()}
 * attribute value of the mapped object. Therefore the value if this attribute can't be null, or a
 * {@link NullPointerException} may be thrown during the marshalling process.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MissingValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}RootAttributesGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MissingValueType")
public class MissingValue
    extends PharmMLRootType implements Scalar
{
	
	/**
	 * This attribute is required to determine the name of the JAXBElement for marshalling.
	 */
	@XmlTransient
	protected MissingValueSymbol symbol;
	
	protected MissingValue(){}
	
	/**
	 * Minimal constructor.
	 * @param symbol The {@link MissingValueSymbol} is required to determine the name of the marshalled
	 * object (see {@link MissingValue}).
	 */
	public MissingValue(MissingValueSymbol symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Gets the type of the missing symbol.
	 * @return The {@link MissingValueSymbol} of this missing data value.
	 */
	public MissingValueSymbol getSymbol(){
		return symbol;
	}
	
	/**
	 * Sets the type of the missing value.
	 * @param symbol The symbol can not be null and must have of the values within the 
	 * {@link MissingValueSymbol} enum.
	 */
	public void setSymbol(MissingValueSymbol symbol){
		this.symbol = symbol;
	}

	@Override
	public String asString() {
		return valueToString();
	}

	@Override
	public JAXBElement<MissingValue> toJAXBElement() {
		return MasterObjectFactory.createMissingValue(this);
	}

	@Override
	public String valueToString() {
		if(symbol == null){
			return "null";
		} else {
			return symbol.value();
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + valueToString();
	}
	
	@Override
	public String toMathExpression() {
		return valueToString();
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
